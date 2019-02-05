package data;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Demo {

	public static void main(String[] args) throws IOException {
		
		
		
		FileOutputStream fos = new FileOutputStream("schools.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		int page = 0;
		Hashtable<String, Schools> all = new Hashtable<>(14000);
		while(page<72) {
			StringBuffer line = new StringBuffer();
		try {
			URL url = new URL("https://api.data.gov/ed/collegescorecard/v1/schools.json?_fields=school.name,id,school.zip,school.city,school.school_url,school.state,latest.admissions.sat_scores.25th_percentile.critical_reading,latest.admissions.sat_scores.75th_percentile.critical_reading,latest.admissions.sat_scores.25th_percentile.math,latest.admissions.sat_scores.75th_percentile.math,latest.cost.tuition.out_of_state,latest.cost.tuition.in_state&_page="+ String.valueOf(page) +"&_per_page=100&api_key=yCjqwHiH0Dq7tS54EJy5sDKeJAcuiYLn19CLVYPn");
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
		
	try {
		
			JSONObject object = new JSONObject(line.toString());
			JSONArray toArray = object.getJSONArray("results");
			for(int i = 0; i< 100; i++) {
				
			JSONObject each = toArray.getJSONObject(i);
			
			all.put(each.getString("school.name"), new Schools(String.valueOf(each.getInt("id")), each.getString("school.name"),"",each.getString("school.city"),each.getString("school.zip"),each.getString("school.state"),String.valueOf(each.get("school.school_url")), "",String.valueOf(each.get("latest.cost.tuition.in_state")), String.valueOf(each.get("latest.cost.tuition.out_of_state")), String.valueOf(each.get("latest.admissions.sat_scores.25th_percentile.critical_reading")),String.valueOf(each.get("latest.admissions.sat_scores.75th_percentile.critical_reading")),String.valueOf(each.get("latest.admissions.sat_scores.25th_percentile.math")),String.valueOf(each.get("latest.admissions.sat_scores.75th_percentile.math"))));
			
			
			}
			
			
		} catch (JSONException e) {
			Set<String> keys = all.keySet();
			for(String key : keys) {
				oos.writeObject(all.get(key));
			}
			break;
		}
		}

		
		
		
	
		
		}
	
		

}
