package testUtils;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import utils.FakerUtils;

public class JdbcUtilsTests {

    @Test
    public void ageShouldBeCorrect(){
        JSONObject fakeData = FakerUtils.fakeJsonData(FakerUtils.getFaker());
        int age = fakeData.getInt("age");
        Assert.assertTrue(age < 100);
    }

    @Test
    public void weightShouldBeCorrect(){
        JSONObject fakeData = FakerUtils.fakeJsonData(FakerUtils.getFaker());
        int weight = fakeData.getInt("weight");
        Assert.assertTrue(weight < 200);
    }

    @Test
    public void heightShouldBeCorrect(){
        JSONObject fakeData = FakerUtils.fakeJsonData(FakerUtils.getFaker());
        int height = fakeData.getInt("height");
        Assert.assertTrue(height < 220);
    }
}
