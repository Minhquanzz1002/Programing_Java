package tuan06.quanlysach;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StoredData {
	public boolean saveFile(String path, ArrayList<Sach> dsSach, String columnsName) throws IOException {
		File file = new File(path);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		PrintWriter pw = new PrintWriter(bw);
		pw.println(columnsName);
		String line;
		for (Sach s : dsSach) {
			line = s.toString();
			pw.println(line);
		}
		pw.close();
		return true;
	}
}
