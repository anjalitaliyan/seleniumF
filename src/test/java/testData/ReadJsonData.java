package testData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJsonData {

	public List<HashMap<String, String>> getJsonDatatoMap(String filepath) throws IOException {
		// convert jsonfiledata to String

		String stringcontent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);

		// convert string data to HashMap......need JacksonDataBind dependency

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> MapData = mapper.readValue(stringcontent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return MapData;

	}

}
