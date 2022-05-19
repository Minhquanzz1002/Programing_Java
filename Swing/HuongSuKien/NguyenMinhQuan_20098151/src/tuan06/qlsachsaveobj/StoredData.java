package tuan06.qlsachsaveobj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StoredData {
	public boolean saveFile(Object obj, String pathFile) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathFile));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
	
	public Object loadFile(String pathFile) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathFile));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
}
