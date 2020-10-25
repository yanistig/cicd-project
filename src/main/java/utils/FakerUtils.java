package utils;

import com.github.javafaker.Faker;
import org.json.JSONObject;

import java.util.Locale;

public class FakerUtils {

    static public Faker faker = null;

    /**
     * singleton data faker
     *
     * @return faker
     */
    static public Faker getFaker() {
        if (faker == null)
            faker = new Faker(Locale.ENGLISH);

        return faker;
    }

    static public JSONObject fakeJsonData(Faker faker) {

        JSONObject json = new JSONObject();

        /*
         * Random fields from data faker
         */
       // json.put("firstname", String.valueOf(faker.number().randomNumber(8, true)));
        json.put("firstname", faker.name().firstName());
        json.put("lastname", faker.name().lastName());
        json.put("age", faker.number().numberBetween(20,65));
        json.put("job", faker.job().position());
        json.put("height", faker.number().numberBetween(150,201));
        json.put("weight", faker.number().numberBetween(45,120));
        json.put("city", faker.address().city());

        return json;
    }

    static public String convertDataTypeJavaSql(String type) {
        String result = null;

        if (type.equals("String"))
            result = "varchar(100)";

        return result;
    }

}
