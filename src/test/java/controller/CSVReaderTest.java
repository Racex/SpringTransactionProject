package controller;

import com.springcsvproject.controller.CSVReader;
import com.springcsvproject.model.ObjectCsv;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Maciej Kulikiewicz on 23.04.2017.
 */

public class CSVReaderTest {

    private CSVReader testedClass;

    @Test
    public void loadObjectMethodReturnsNotEmptyList() {
        testedClass = new CSVReader();
        List<ObjectCsv> objectCsvs = testedClass.loadObjectList(ObjectCsv.class, "Sample.csv");
        Assert.assertFalse(objectCsvs.isEmpty());
    }

}
