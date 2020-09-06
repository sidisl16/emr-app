package com.emr.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.app.dtos.MedicineInventoryDto;
import com.emr.app.mongo.entities.MedicineInventory;
import com.emr.app.mongo.repositories.MedicineInventoryRepository;
import com.emr.app.utilities.EntityAndDtoConversionUtil;

@Service
public class AutoSuggestionServiceImpl implements AutoSuggestionService {

	private Trie<String, Set<MedicineInventoryDto>> medicineTrie;
	private Trie<String, String> examinationTrie;

	@Autowired
	private MedicineInventoryRepository medicineceInventoryRepository;

	@Override
	public void loadAllMedicineAndExaminationDataInMemory() {

		medicineTrie = new PatriciaTrie<>();
		List<MedicineInventory> medicines = medicineceInventoryRepository.findAll();
		medicines.forEach(medicine -> {
			MedicineInventoryDto medicineInventoryDto = EntityAndDtoConversionUtil.convert(medicine,
					MedicineInventoryDto.class);
			medicineInventoryDto.setMedicineInventoryId(medicine.getId().toString());
			if (medicineTrie.containsKey(medicineInventoryDto.getName().toLowerCase())) {
				medicineTrie.get(medicineInventoryDto.getName().toLowerCase()).add(medicineInventoryDto);
			} else {
				Set<MedicineInventoryDto> medicineDtoSet = new HashSet<>();
				medicineTrie.putIfAbsent(medicineInventoryDto.getName().toLowerCase(), medicineDtoSet);
			}
		});

		examinationTrie = new PatriciaTrie<>();
		examinationTrie.put("cbc", "CBC");
		examinationTrie.put("xray", "XRAY");
		examinationTrie.put("urine", "Urine");

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
			medicineTrie.put(medicineInventoryDto.getName().toLowerCase(), medicineSet);
		}
	}

	@Override
	public void addExaminationToTrie(String examination) {
		examinationTrie.put(examination, examination);
	}
}