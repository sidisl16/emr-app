package com.emr.app.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.app.dtos.MedicineInventoryDto;
import com.emr.app.mongo.dal.InventoryMongoDAL;
import com.emr.app.mongo.entities.MedicineInventory;
import com.emr.app.mongo.repositories.MedicineInventoryRepository;
import com.emr.app.utilities.EntityAndDtoConversionUtil;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private MedicineInventoryRepository medicineInventoryRepository;

	@Autowired
	private InventoryMongoDAL inventoryMongoDAL;

	@Autowired
	private AutoSuggestionService autoSuggestionService;

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
		autoSuggestionService.addMedicineToTrie(medicineInventoryDto);
		return medicineInventoryDto;
	}

	@Override
	public void uploadInventoryFile(File inventoryFile) throws Exception {

	}

	@Override
	public List<MedicineInventoryDto> getAllMedicine() {
		List<MedicineInventory> medicines = medicineInventoryRepository.findAll();
		List<MedicineInventoryDto> medicineDtos = new ArrayList<>();
		medicines.forEach(medicine -> {
			MedicineInventoryDto medicineDto = EntityAndDtoConversionUtil.convert(medicine, MedicineInventoryDto.class);
			medicineDto.setMedicineInventoryId(medicine.getId().toString());
			medicineDtos.add(medicineDto);
		});
		return medicineDtos;
	}

}
