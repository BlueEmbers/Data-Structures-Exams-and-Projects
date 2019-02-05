package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserBag implements Serializable {

	private Map<String, User> map;

	public UserBag() {
		this.map = new HashMap<String, User>();
		loadMap();
	}

	public void saveMap() {
		try {
			File fileOne = new File("fileone");
			FileOutputStream fos = new FileOutputStream(fileOne);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(map);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {
		}

	}

	public void loadMap() {
		
		
		try {
			File toRead = new File("fileone");
			FileInputStream fis = new FileInputStream(toRead);
			ObjectInputStream ois = new ObjectInputStream(fis);

			this.map =  (Map<String, User>) ois.readObject();

			ois.close();
			fis.close();

		} catch (Exception e) {
		}

	}
	
	public void displayMap() {
		for(String key : map.keySet()) {
			System.out.println(key + "\n" + map.get(key) + "\n");
		}
		
	}

	public void addUser(User user) {
		map.put(user.getUsername(), user);
		saveMap();
	}

	public Map getMap() {
		return map;
	}

	public void setMap(HashMap map) {
		this.map = map;
	}
	
	public User getUser(String key) {
		return map.get(key);
	}

}
