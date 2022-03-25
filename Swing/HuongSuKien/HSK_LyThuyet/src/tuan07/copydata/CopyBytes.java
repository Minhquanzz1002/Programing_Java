package tuan07.copydata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
	public static void main(String[] args){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("txtData\\data.txt");
			fos = new FileOutputStream("txtData\\copy_data.txt");
			int c;
			while((c = fis.read()) != -1) {
				fos.write(c);
			}
			System.out.println("Đọc thành công");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
