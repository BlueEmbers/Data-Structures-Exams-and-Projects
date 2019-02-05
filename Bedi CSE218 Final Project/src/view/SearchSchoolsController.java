package view;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import data.Schools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class SearchSchoolsController implements Initializable{
	
	@FXML
	private Button connect;
	
	String inLine ="";
	
	public String line = "";

	@FXML
	private ComboBox search;
	@FXML
	public void searching(ActionEvent action) throws IOException {
		URL url = new URL("https://api.data.gov/ed/collegescorecard/v1/schools.json?school.degrees_awarded.predominant=2,3&_fields=id,school.name,2013.student.size&api_key=yCjqwHiH0Dq7tS54EJy5sDKeJAcuiYLn19CLVYPn");
		HttpURLConnection conn = (HttpURLConnection)(url.openConnection());
		conn.connect();
		int connR = conn.getResponseCode();
		Scanner scan = new Scanner(url.openStream());
		while(scan.hasNext()) {
			inLine += scan.nextLine();
		}
		System.out.print(inLine);
		String[] parse = inLine.split("school.name");
		
		for(int i = 0; i < parse.length -1;i++) {
			System.out.print(parse[i]);
			System.out.println();
		}
		
		
	}
	@FXML
	public void saveStuff(ActionEvent event) {
		int page = 0;
		Hashtable<String, Schools> all = new Hashtable<>(14000);
		while(page<72) {
			StringBuffer line = new StringBuffer();
		try {
			URL url = new URL("https://api.data.gov/ed/collegescorecard/v1/schools.json?_fields=school.name,id,school.zip,school.city,school.school_url,school.state,latest.admissions.sat_scores.25th_percentile.critical_reading,latest.admissions.sat_scores.75th_percentile.critical_reading,latest.admissions.sat_scores.25th_percentile.math,latest.admissions.sat_scores.75th_percentile.math&_page="+ String.valueOf(page) +"&_per_page=100&api_key=yCjqwHiH0Dq7tS54EJy5sDKeJAcuiYLn19CLVYPn");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			String s;
			while((s=reader.readLine()) != null) {
				line.append(s);
				
			}
			reader.close();
			System.out.println(line);
			page++;
			
			
			
			
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public void saveSchools() throws IOException {
		try {
			URL url = new URL("https://api.data.gov/ed/collegescorecard/v1/schools.json?_fields=school.name&_page=0&_per_page=100&api_key=yCjqwHiH0Dq7tS54EJy5sDKeJAcuiYLn19CLVYPn");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			Scanner scan = new Scanner(url.openStream());
			while(scan.hasNext()) {
				line += scan.nextLine();
				
			}
			System.out.println(line);
			
			
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper obj = new ObjectMapper();
		try {
			JSONObject object = new JSONObject(line.toString());
			JSONArray toArray = object.getJSONArray("results");
			System.out.println(toArray.toString());
			FileOutputStream fos = new FileOutputStream("schools.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(line);
			oos.close();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	search.setPromptText("EnterSchoolHere");	
	search.setEditable(true);
	try {
		saveSchools();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
