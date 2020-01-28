package tests;

import org.testng.annotations.Test;
import upload.utils.XlsData;

import java.util.List;
import java.util.Map;

public class InsuranceTest extends BaseTest {

    @Test
    public void testInsurance() {
        List<Map<String,String>> valuesToEnter = XlsData.getValuesFromXls();

        String region = valuesToEnter.get(0).get("region");
        String model = valuesToEnter.get(0).get("model");
        String yearFrom = valuesToEnter.get(0).get("yearFrom");
        String yearTo = valuesToEnter.get(0).get("yearTo");

    }
}
