package com.emr.app.service;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.app.dtos.CSVBean;
import com.emr.app.dtos.ExaminationDto;
import com.emr.app.dtos.MedicinceCSVBean;
import com.emr.app.dtos.MedicineInventoryDto;
import com.emr.app.mongo.dal.InventoryMongoDAL;
import com.emr.app.mongo.entities.Examination;
import com.emr.app.mongo.entities.MedicineInventory;
import com.emr.app.mongo.repositories.ExaminationRepository;
import com.emr.app.mongo.repositories.MedicineInventoryRepository;
import com.emr.app.utilities.CSVUtils;
import com.emr.app.utilities.EntityAndDtoConversionUtil;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private MedicineInventoryRepository medicineInventoryRepository;

	@Autowired
	private InventoryMongoDAL inventoryMongoDAL;

	@Autowired
	private AutoSuggestionService autoSuggestionService;

	@Autowired
	private ExaminationRepository examinationRepository;

	@Override
	public MedicineInventoryDto addMedicine(MedicineInventoryDto medicineInventoryDto) throws Exception {
		MedicineInventory medicinceInventory = inventoryMongoDAL
				.upsertData(EntityAndDtoConversionUtil.convert(medicineInventoryDto, MedicineInventory.class));
		EntityAndDtoConversionUtil.copy(medicinceInventory, medicineInventoryDto);
		medicineInventoryDto.setMedicineInventoryId(medicinceInventory.getId().toString());
		autoSuggestionService.addMedicineToTrie(medicineInventoryDto);
		return medicineInventoryDto;
	}

	@Override
	public MedicineInventoryDto updateMedicine(MedicineInventoryDto medicineInventoryDto) throws Exception {
		Optional<MedicineInventory> medicinceInventoryOptional = medicineInventoryRepository
				.findById(new ObjectId(medicineInventoryDto.getMedicineInventoryId()));
		MedicineInventory medicinceInventory = new MedicineInventory();
		if (medicinceInventoryOptional.isPresent()) {
			medicinceInventory = medicinceInventoryOptional.get();
		} else {
			throw new Exception("medicince inventory Id not found.");
		}
		EntityAndDtoConversionUtil.copyIgnoreNull(medicineInventoryDto, medicinceInventory);
		medicinceInventory = medicineInventoryRepository.save(medicinceInventory);
		EntityAndDtoConversionUtil.copy(medicinceInventory, medicineInventoryDto);
		medicineInventoryDto.setMedicineInventoryId(medicinceInventory.getId().toString());
		autoSuggestionService.updateMedicineTrie(medicineInventoryDto);
		return medicineInventoryDto;
	}

	@Override
	public void uploadInventoryFile(File inventoryFile) throws Exception {
		validate(inventoryFile);
	}

	private List<MedicinceCSVBean> validate(File inventoryFile) throws Exception {
		List<MedicinceCSVBean> medList = CSVUtils.getList(Paths.get(inventoryFile.getAbsolutePath()),
				MedicinceCSVBean.class);
		for (MedicinceCSVBean csvBean : medList) {

		}
		return medList;
	}

	@Override
	public List<MedicineInventoryDto> getAllMedicine() {
		List<MedicineInventory> medicines = medicineInventoryRepository.findAllOrderByName();
		List<MedicineInventoryDto> medicineDtos = new ArrayList<>();
		medicines.forEach(medicine -> {
			MedicineInventoryDto medicineDto = EntityAndDtoConversionUtil.convert(medicine, MedicineInventoryDto.class);
			medicineDto.setMedicineInventoryId(medicine.getId().toString());
			medicineDtos.add(medicineDto);
		});
		return medicineDtos;
	}

	@Override
	public List<MedicineInventoryDto> searchMedicine(String name, String company) {
		List<MedicineInventory> medicines = inventoryMongoDAL.searchmedicine(name, company);
		List<MedicineInventoryDto> medicineDtos = new ArrayList<>();
		medicines.forEach(medicine -> {
			MedicineInventoryDto medicineDto = EntityAndDtoConversionUtil.convert(medicine, MedicineInventoryDto.class);
			medicineDto.setMedicineInventoryId(medicine.getId().toString());
			medicineDtos.add(medicineDto);
		});
		return medicineDtos;
	}

	@Override
	public void deleteMedicineById(String id) {
		MedicineInventory medInventory = medicineInventoryRepository.findById(new ObjectId(id)).get();
		MedicineInventoryDto medicine = EntityAndDtoConversionUtil.convert(medInventory, MedicineInventoryDto.class);
		medicineInventoryRepository.deleteById(new ObjectId(id));
		autoSuggestionService.removeMedicineFromMedicineTrie(medicine);
	}

	@Override
	public List<ExaminationDto> getAllExamination() {
		List<Examination> examinations = examinationRepository.findAllOrderByName();
		List<ExaminationDto> examinationDtos = new ArrayList<>();
		examinations.forEach(examination -> {
			ExaminationDto examinationDto = EntityAndDtoConversionUtil.convert(examination, ExaminationDto.class);
			examinationDto.setExaminationId(examination.getId().toHexString());
			examinationDtos.add(examinationDto);
		});
		return examinationDtos;
	}

	@Override
	public ExaminationDto storeExamination(ExaminationDto examinationDto) {
		Examination examination = examinationRepository
				.save(EntityAndDtoConversionUtil.convert(examinationDto, Examination.class));
		EntityAndDtoConversionUtil.copy(examination, examinationDto);
		examinationDto.setExaminationId(examination.getId().toString());
		autoSuggestionService.addExaminationToTrie(examinationDto.getName());
		return examinationDto;
	}

	@Override
	public void deleteExamination(String id) {
		ExaminationDto examination = EntityAndDtoConversionUtil
				.convert(examinationRepository.findById(new ObjectId(id)).get(), ExaminationDto.class);
		examinationRepository.deleteById(new ObjectId(id));
		autoSuggestionService.removeExaminationFromTrie(examination.getName());
	}
}
