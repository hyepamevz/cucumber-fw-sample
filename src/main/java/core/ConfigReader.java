package core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigReader {

    private static JsonNode configData;

    static {
        try {
            // Load the config.json file from the resources folder
            ObjectMapper mapper = new ObjectMapper();
            configData = mapper.readTree(new File("src/test/resources/config.json"));

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file.");
        }
    }

    public static String getPageUrl(String page) {
        return configData.get(page).asText();
    }

    public static String getSampleText() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode data = mapper.readTree(new File("src/test/resources/sample_data.json"));

            return data.get("sample_text").asText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
