package com.springcsvproject.controller;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.Collections;
import java.util.List;


/**
 * Created by Maciej Kulikiewicz on 23.04.2017.
 */
public class CSVReader {

    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                    mapper.reader(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            System.err.println("Błąd podczas próby załadowania listy objectów z pliku " + fileName + e.toString());
            return Collections.emptyList();
        }
    }
}

