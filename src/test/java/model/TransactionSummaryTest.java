package model;

import com.springcsvproject.model.ObjectCsv;
import com.springcsvproject.model.TransactionSummary;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by racex on 24.04.2017.
 */

public class TransactionSummaryTest {

    private TransactionSummary transactionSummary;

    @Test
    public void transactionSummaryReturnNotNull() {
        Assert.assertNotNull(new TransactionSummary("", "").getSummary(null));
    }

    @Test
    public void calculateSummaryTest() {
        ObjectCsv testObjectCsv1 = new ObjectCsv();
        testObjectCsv1.setType("TESTOWA");
        testObjectCsv1.setPrice(10);
        testObjectCsv1.setCommission(10);
        testObjectCsv1.setCurrency("WALUTA");
        testObjectCsv1.setIs_paid(false);
        ObjectCsv testObjectCsv2 = new ObjectCsv();
        testObjectCsv2.setType("TESTOWA");
        testObjectCsv2.setPrice(23);
        testObjectCsv2.setCommission(120);
        testObjectCsv2.setCurrency("WALUTA");
        testObjectCsv2.setIs_paid(true);

        List<ObjectCsv> testObjectCsvList = new ArrayList<>();
        testObjectCsvList.add(testObjectCsv1);
        testObjectCsvList.add(testObjectCsv2);

        transactionSummary = new TransactionSummary("WALUTA", "TESTOWA").getSummary(testObjectCsvList);

        Assert.assertEquals(transactionSummary.getCurrency(), "WALUTA", "Niepoprawna wartość currency");
        Assert.assertEquals(transactionSummary.getType(), "TESTOWA", "Niepoprawna wartość type");
        Assert.assertEquals(Math.toIntExact(transactionSummary.getPrice()), 33, "Niepoprawna wartość price");
        Assert.assertEquals(Math.toIntExact(transactionSummary.getCommission()), 130, "Niepoprawna wartość comission");
        Assert.assertEquals(Math.toIntExact(transactionSummary.getToChargeValue()), 10, "Niepoprawna wartość to_charge_value");
        Assert.assertEquals(Math.toIntExact(transactionSummary.getSettlementValue()), -107, "Niepoprawna wartość settlement");
    }
}
