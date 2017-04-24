package com.springcsvproject.controller;

import com.springcsvproject.services.TransactionsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Maciej Kulikiewicz on 23.04.2017.
 */

@RestController
public class MainController {

    @Autowired
    private TransactionsDataService transactionsData;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(@RequestParam String currency, @RequestParam String type) {
        String massage = "";
        try {
            massage = transactionsData.findByCurrencyAndType(currency, type).toString();
        } catch (Exception e) {
            massage = e.getMessage();
        }
        return massage == "" ? "Upps coś poszło nie tak" : massage;

    }
}