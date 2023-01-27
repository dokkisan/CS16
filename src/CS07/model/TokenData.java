package CS07.model;

import java.util.HashMap;
import java.util.Map;

public class TokenData {
    // TYPE
    private final String TYPE = "type";
    private final String VALUE = "value";
    private final String CHILD = "child";

    // VALUE
    private final String

    private Map<Object, String> tokenData;
    private Map<String, String> typeData;


    private

    public TokenData() {
        this.typeData = new HashMap<>();
        this.tokenData = new HashMap<>();
    }

    public Map<String, String> generateTypeData() {
//        Map<String, String> typeData = new HashMap<>();

        typeData.put("T", TYPE);
        typeData.put("V", VALUE);
        typeData.put("C", CHILD);

        return typeData;
    }

    public Map<Object, String> generateTokenData(Map<String, String> typeData) {
//        Map<Object, String> tokenData = new HashMap<>();

        // Key : TYPE
        tokenData.put(typeData.get("T"), "TAG_START_OPEN");
        tokenData.put(typeData.get("T"), "STRING");
        tokenData.put(typeData.get("T"), "ASSIGNMENT");

        // Key : VALUE
        tokenData.put(typeData.get("V"), "HTML");
        tokenData.put(typeData.get("V"), "lang");
        tokenData.put(typeData.get("V"), "=");

        return tokenData;
    }
}
