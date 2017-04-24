package com.springcsvproject.services;

import com.springcsvproject.model.TransactionSummary;


/**
 * Created by Maciej Kulikiewicz on 23.04.2017.
 */
public interface TransactionsDataService {

    TransactionSummary findByCurrencyAndType(String currency, String type) throws Exception;

}
