package services;

import com.springcsvproject.services.TransactionsDataServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Maciej Kulikiewicz on 23.04.2017.
 */

public class TransactionsDataServiceTest {


    @Test
    public void loadTransactionsWithNotValidParametersThrowException() {
        boolean status = false;
        try {
            new TransactionsDataServiceImpl().findByCurrencyAndType("Test", "nieprawidłowych typów");
        } catch (Exception e) {
            status = true;
        }
        Assert.assertTrue(status);
    }

}
