package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CollegeBag {

	private HashMap<String, JsonNode> map;
	private int nElems;
	private Set<String> schoolNameSet;
	private Map<String, College> collegeMap;

	public CollegeBag() {
		super();
		this.map = new HashMap<>();
		nElems = 0;
		this.schoolNameSet = new HashSet();
		this.collegeMap = new HashMap<>();
		loadSet();
		try {
			loadMap();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadCollegeMap();

	}

	public HashMap getMap() {
		return map;
	}



	public int getnElems() {
		return nElems;
	}

	public void setnElems(int nElems) {
		this.nElems = nElems;
	}

	public void fillHashMap() throws JsonGenerationException, JsonMappingException, IOException {
		boolean nullValue = false;
		int i = 0;
		while (!nullValue) {
			nullValue = downloadNodes(i++);
		}
		saveCollegeMap();
		saveSet();
		saveMap();
	}

	public boolean downloadNodes(int pageNumber) {
		boolean nullValue = false;

		String inline = "";
		String urlString = "https://api.data.gov/ed/collegescorecard/v1/schools.json?school.degrees_awarded.predominant=3,"
				+ "&fields=latest.admissions.sat_scores.25th_percentile.critical_reading,"
				+ "latest.admissions.sat_scores.75th_percentile.critical_reading,"
				+ "latest.admissions.sat_scores.25th_percentile.math,"
				+ "latest.admissions.sat_scores.75th_percentile.math," + "latest.cost.tuition.in_state,"
				+ "latest.cost.tuition.out_of_state," + "school.school_url," + "id," + "school.name," + "school.city,"
				+ "school.state," + "school.zip," + "&_per_page=100,&_page=" + pageNumber
				+ "&api_key=gEjavtIYCy5hawNkMBuedMxccXJMiXaIu7OfPhR6";

		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			conn.connect();

			int responsecode = conn.getResponseCode();

			if (responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			else {
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
			}

			ObjectMapper objectMapper = new ObjectMapper();

			JsonNode node = objectMapper.readValue(inline, JsonNode.class);
			JsonNode resultsArray = node.get("results");
			JsonNode metaDataNode = node.get("metadata");
			JsonNode per_pageField = metaDataNode.get("per_page");
			int perPage = per_pageField.asInt();

			for (int i = 0; i < perPage; i++) {
				if (resultsArray.get(i) == null) {
					nullValue = true;
					break;
				}
				JsonNode newJsonNode = resultsArray.get(i);
				JsonNode schoolNameNode = newJsonNode.get("school.name");
				JsonNode idNode = newJsonNode.get("id");
				JsonNode cityNode = newJsonNode.get("school.city");
				JsonNode zipNode = newJsonNode.get("school.zip");
				JsonNode stateNode = newJsonNode.get("school.state");
				JsonNode satLowReadingNode = newJsonNode
						.get("latest.admissions.sat_scores.25th_percentile.critical_reading");
				JsonNode satHighReadingNode = newJsonNode
						.get("latest.admissions.sat_scores.75th_percentile.critical_reading");
				JsonNode satLowMathNode = newJsonNode.get("latest.admissions.sat_scores.25th_percentile.math");
				JsonNode satHighMathNode = newJsonNode.get("latest.admissions.sat_scores.75th_percentile.math");
				JsonNode inStateCostNode = newJsonNode.get("latest.cost.tuition.in_state");
				JsonNode outStateCostNode = newJsonNode.get("latest.cost.tuition.out_of_state");
				this.schoolNameSet.add(schoolNameNode.asText());
				this.map.put(schoolNameNode.asText(), newJsonNode);
				College college = new College(schoolNameNode.asText(), idNode.asText(), zipNode.asText(), cityNode.asText(), stateNode.asText(), inStateCostNode.asText(), outStateCostNode.asText(),
						satLowMathNode.asText(), satHighMathNode.asText(), satLowReadingNode.asText(), satHighReadingNode.asText());
				this.collegeMap.put(college.getName(), college);
				nElems++;
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	return nullValue;
	}

	public Map<String, College> getCollegeMap() {
		return collegeMap;
	}

	public void setCollegeMap(Map<String, College> collegeMap) {
		this.collegeMap = collegeMap;
	}

	public void setMap(HashMap<String, JsonNode> map) {
		this.map = map;
	}

	public Set<String> getSchoolNameSet() {
		return schoolNameSet;
	}

	public void setSchoolNameSet(Set<String> schoolNameSet) {
		this.schoolNameSet = schoolNameSet;
	}

	public void saveMap() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

	    mapper.writeValue(new File("myData.json"), map);

	}

	public void loadMap() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		
		this.map = mapper.readValue(
				new File("myData.json"), 
				new TypeReference<Map<String, Object>>() {
		});
		
	}

	public void saveSet() {
		try {
			File fileOne = new File("filethree");
			FileOutputStream fos = new FileOutputStream(fileOne);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(schoolNameSet);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {
		}

	}

	public void loadSet() {

		try {
			File toRead = new File("filethree");
			FileInputStream fis = new FileInputStream(toRead);
			ObjectInputStream ois = new ObjectInputStream(fis);

			this.schoolNameSet = (Set<String>) ois.readObject();

			ois.close();
			fis.close();

		} catch (Exception e) {
		}

	}

	public void displaySet() {
		for (String temp : schoolNameSet) {
			System.out.println(temp);
		}
	}
	
	public void saveCollegeMap() {
		try {
			File fileOne = new File("filecollege");
			FileOutputStream fos = new FileOutputStream(fileOne);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(collegeMap);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {
		}

	}

	public void loadCollegeMap() {

		try {
			File toRead = new File("filecollege");
			FileInputStream fis = new FileInputStream(toRead);
			ObjectInputStream ois = new ObjectInputStream(fis);

			this.collegeMap = (Map<String, College>) ois.readObject();

			ois.close();
			fis.close();

		} catch (Exception e) {
		}

	}

}
