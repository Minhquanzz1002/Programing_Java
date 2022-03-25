package qlnv;
import java.io.*;
public class StoredData {
	public boolean saveFile(Object obj, String path) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
	public Object loadFile(String path) throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
}
