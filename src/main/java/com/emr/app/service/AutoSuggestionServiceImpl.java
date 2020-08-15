package com.emr.app.service;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.springframework.stereotype.Service;

import com.emr.app.dtos.MedicineInventoryDto;

@Service
public class AutoSuggestionServiceImpl implements AutoSuggestionService {

	private Trie<String, Set<MedicineInventoryDto>> medicineTrie;
	private Trie<String, String> examinationTrie;

	@Override
	public void loadAllMedicineAndExaminationDataInMemory() {

		medicineTrie = new PatriciaTrie<>();
		examinationTrie = new PatriciaTrie<>();

		Set<MedicineInventoryDto> medicine1 = new HashSet<>();
		medicine1.add(new MedicineInventoryDto("", "Paraacteamol", 500f, "Oral", "Colpol", 100));
		medicine1.add(new MedicineInventoryDto("", "Paraacteamol", 650f, "Oral", "Dolo", 100));
		medicineTrie.put("paraacteamol", medicine1);

		Set<MedicineInventoryDto> medicine2 = new HashSet<>();
		medicine2.add(new MedicineInventoryDto("", "Pantoprazole", 40f, "Oral", "Cadila", 100));
		medicine2.add(new MedicineInventoryDto("", "Pantoprazole", 40f, "Oral", "PQR", 100));
		medicineTrie.put("pantoprazole", medicine2);

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
			medicineTrie.get(medicineInventoryDto.getName()).add(medicineInventoryDto);
		} else {
			Set<MedicineInventoryDto> medicineSet = new HashSet<>();
			medicineTrie.put(medicineInventoryDto.getName(), medicineSet);
		}
	}

	@Override
	public void addExaminationToTrie(String examination) {
		examinationTrie.put(examination, examination);
	}
}