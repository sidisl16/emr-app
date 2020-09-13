package com.emr.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeSet;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.app.dtos.ExaminationDto;
import com.emr.app.dtos.MedicineInventoryDto;
import com.emr.app.mongo.entities.Examination;
import com.emr.app.mongo.entities.MedicineInventory;
import com.emr.app.mongo.repositories.ExaminationRepository;
import com.emr.app.mongo.repositories.MedicineInventoryRepository;
import com.emr.app.utilities.AppUtil;
import com.emr.app.utilities.EntityAndDtoConversionUtil;

@Service
public class AutoSuggestionServiceImpl implements AutoSuggestionService {

	private Trie<String, Set<MedicineInventoryDto>> medicineTrie;
	private Trie<String, String> examinationTrie;

	@Autowired
	private MedicineInventoryRepository medicineInventoryRepository;

	@Autowired
	private ExaminationRepository examinationRepository;

	@Override
	public void loadAllMedicineAndExaminationDataInMemory() {

		medicineTrie = new PatriciaTrie<>();
		List<MedicineInventory> medicines = medicineInventoryRepository.findAll();
		medicines.forEach(medicine -> {
			MedicineInventoryDto medicineInventoryDto = EntityAndDtoConversionUtil.convert(medicine,
					MedicineInventoryDto.class);
			medicineInventoryDto.setMedicineInventoryId(medicine.getId().toString());
			if (medicineTrie.containsKey(medicineInventoryDto.getName().toLowerCase())) {
				medicineTrie.get(medicineInventoryDto.getName().toLowerCase()).add(medicineInventoryDto);
			} else {
				Set<MedicineInventoryDto> medicineDtoSet = new HashSet<>();
				medicineDtoSet.add(medicineInventoryDto);
				medicineTrie.put(medicineInventoryDto.getName().toLowerCase(), medicineDtoSet);
			}
		});

		examinationTrie = new PatriciaTrie<>();
		List<Examination> examinations = examinationRepository.findAllOrderByName();
		examinations.forEach(examination -> {
			ExaminationDto examinationDto = EntityAndDtoConversionUtil.convert(examination, ExaminationDto.class);
			examinationDto.setExaminationId(examination.getId().toString());
			examinationTrie.put(examinationDto.getName(), examinationDto.getName());
		});
	}

	@Override
	public Set<MedicineInventoryDto> searchMedicineByPrefix(String prefix) {
		Set<MedicineInventoryDto> response = new HashSet<>();
		SortedMap<String, Set<MedicineInventoryDto>> result = medicineTrie.prefixMap(prefix.toLowerCase());
		if (!result.isEmpty()) {
			for (Set<MedicineInventoryDto> value : result.values()) {
				response.addAll(value);
			}
		}
		return response;
	}

	@Override
	public Set<String> searchExaminationByPrefix(String prefix) {
		Set<String> response = new HashSet<>();
		SortedMap<String, String> result = examinationTrie.prefixMap(prefix.toLowerCase());
		if (!result.isEmpty()) {
			response.addAll(result.values());
		}
		return response;
	}

	@Override
	public void addMedicineToTrie(MedicineInventoryDto medicineInventoryDto) {
		if (medicineTrie.containsKey(medicineInventoryDto.getName())) {
			medicineTrie.get(medicineInventoryDto.getName().toLowerCase()).add(medicineInventoryDto);
		} else {
			Set<MedicineInventoryDto> medicineSet = new HashSet<>();
			medicineSet.add(medicineInventoryDto);
			medicineTrie.put(medicineInventoryDto.getName().toLowerCase(), medicineSet);
		}
	}

	@Override
	public void updateMedicineTrie(MedicineInventoryDto medicineInventoryDto) {
		Set<String> names = new TreeSet<>((o1, o2) -> {
			Integer dist1 = AppUtil.getHammingDistance(o1, medicineInventoryDto.getName());
			Integer dist2 = AppUtil.getHammingDistance(o2, medicineInventoryDto.getName());
			return dist2.compareTo(dist1);
		});

		for (String key : medicineTrie.keySet()) {
			names.add(key);
		}

		boolean isLoopRequired = true;
		for (String name : names) {
			Set<MedicineInventoryDto> medicines = medicineTrie.get(name);
			for (MedicineInventoryDto medicine : medicines) {
				if (medicine.getMedicineInventoryId().equals(medicineInventoryDto.getMedicineInventoryId())) {
					medicine = medicineInventoryDto;
					isLoopRequired = false;
					break;
				}
			}
			if (!isLoopRequired) {
				break;
			}
		}
	}

	@Override
	public void removeMedicineFromMedicineTrie(MedicineInventoryDto medicineInventoryDto) {
		if (medicineTrie.containsKey(medicineInventoryDto.getName().toLowerCase())) {
			medicineTrie.get(medicineInventoryDto.getName().toLowerCase()).remove(medicineInventoryDto);
		}
	}

	@Override
	public void addExaminationToTrie(String examination) {
		examinationTrie.put(examination, examination);
	}

	@Override
	public void removeExaminationFromTrie(String examination) {
		examinationTrie.remove(examination);
	}
}