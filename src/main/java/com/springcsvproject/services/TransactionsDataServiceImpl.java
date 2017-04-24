package com.springcsvproject.services;


import com.springcsvproject.controller.CSVReader;
import com.springcsvproject.model.ObjectCsv;
import com.springcsvproject.model.TransactionSummary;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by Maciej Kulikiewicz on 23.04.2017.
 */

@Component
public class TransactionsDataServiceImpl implements TransactionsDataService {

    private List<ObjectCsv> listOfTransactions;

    public TransactionsDataServiceImpl() {
        loadFile();
    }

    private void loadFile() {
        CSVReader csvReader = new CSVReader();
        listOfTransactions = csvReader.loadObjectList(ObjectCsv.class, "Sample.csv");
    }

    @Override
    public TransactionSummary findByCurrencyAndType(String currency, String type) throws Exception {
        if (listOfTransactions.stream().filter(x -> x.getCurrency().equals(currency) && x.getType().equals(type)).count() < 1)
            throw new Exception("Brak takiego biletu");
        return new TransactionSummary(currency, type).getSummary(listOfTransactions);
    }


}
