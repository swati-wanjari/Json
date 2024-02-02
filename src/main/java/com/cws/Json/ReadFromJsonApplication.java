package com.cws.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class ReadFromJsonApplication {

	public static void main(String[] args) throws IOException, ParseException {

		JSONParser jsonparser=new JSONParser();
		FileReader reader=new FileReader("JsonFiles/employee.json");
		Object obj=jsonparser.parse(reader);
		JSONObject empjsonobj=(JSONObject)obj;
		String fname= (String) empjsonobj.get("firstName");
		String lname= (String) empjsonobj.get("lastName");
		System.out.println("First name:"+fname);
		System.out.println("Last name:"+lname);
		JSONArray array = (JSONArray)empjsonobj.get("address");
		for(int i=0;i<array.size();i++)
		{
			JSONObject address=(JSONObject) array.get(i);
			String street = (String) address.get("street");
			String city=(String) address.get("city"); String state= (String) address.get("state");
			System.out.println("Address of "+i+"is...... ");
			System.out.println("Street:"+street);
			System.out.println("City:"+city);
			System.out.println("State: "+state);
		}
	}

}
