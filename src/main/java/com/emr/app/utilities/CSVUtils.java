package com.emr.app.utilities;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVUtils {

	public static <V> List<V> getList(Path path, Class<V> clazz) throws IOException {
		ColumnPositionMappingStrategy<V> ms = new ColumnPositionMappingStrategy<>();
		List<V> list = new ArrayList<>();
		ms.setType(clazz);
		try (Reader reader = Files.newBufferedReader(path);) {
			CsvToBean<V> cb = new CsvToBeanBuilder(reader).withType(clazz).withMappingStrategy(ms).build();
			list = cb.parse();
		}
		return list;
	}

}
