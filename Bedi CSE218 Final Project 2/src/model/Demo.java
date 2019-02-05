package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Demo {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
	CollegeBag bag = new CollegeBag();	
	bag.loadCollegeMap();
	System.out.println(bag.getCollegeMap().get("Harvard University"));
	}

}
