package tuan07.tangtocdoc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TangTocDoc {
	public static void main(String[] args) {
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		FileReader fReader = null;
		FileWriter fWriter = null;
		
		try {
			fReader = new FileReader("txtData\\data.txt");
			inputStream = new BufferedReader(fReader);
			
			fWriter = new FileWriter("txtData\\copy_data_2");
			outputStream = new PrintWriter(fWriter);
			
			String l;
			while((l = inputStream.readLine()) != null) {
				outputStream.println(l);
			}
			System.out.println("Đọc và ghi thành công");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(outputStream != null) {
				outputStream.close();
			}
			if(fReader != null) {
				try {
					fReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fWriter != null) {
				try {
					fWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
