package data;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeSet;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("serial")
public class AllUsers implements Serializable{

	
	public static Hashtable<String, Schools> loadSchools() throws IOException{
		
		Hashtable<String, Schools> temp = new Hashtable<>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("schools.dat");
			ois = new ObjectInputStream(fis);
			
			while(true) {
				Schools schools = (Schools) ois.readObject();
				temp.put(schools.getCollegeName(), schools);
				
			}
			
			
		
		}catch(EOFException e){
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();
		fis.close();
		return temp;
		
	}
	
	public static void userSave(TreeSet<Users> t) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("UserData.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Iterator it = t.iterator();
			while(it.hasNext()) {
				oos.writeObject(it.next());
			}
			
			
			oos.close();
			fos.close();
			System.out.print("Saving is a success");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

	

	public static TreeSet<Users> userLoad() throws IOException {
		FileInputStream fis = new FileInputStream("UserData.dat");
		TreeSet<Users> allUsers = new TreeSet<>();
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
			while(true) {
				Users user = (Users)ois.readObject();
				allUsers.add(user);
			System.out.println("Loading is a success");
			
			
		} }catch(EOFException e){
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();
		fis.close();
		return allUsers;
		
		
		
	}
	
	

	
}
