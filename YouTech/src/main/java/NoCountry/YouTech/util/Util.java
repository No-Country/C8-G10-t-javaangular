package NoCountry.YouTech.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Util {
    public static final ObjectMapper OBJECT_STATIC = new ObjectMapper();

    public static String castToString(Object data) {
        try {
            return OBJECT_STATIC.writeValueAsString(data);
        } catch (Exception exception) {
            return null;
        }
    }

    public static <T> T convertJsonToPOJO(String json, Class<?> target) {
        try {
            return OBJECT_STATIC.readValue(json, OBJECT_STATIC.getTypeFactory().constructType(Class.forName(target.getName())));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
