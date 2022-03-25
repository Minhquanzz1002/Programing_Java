package tuan08.kiemtrachuoi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KiemTra {
	public static void main(String[] args) {
//		String input = "?";
//		String patternStr = "\\?";
//		Pattern pattern = Pattern.compile(patternStr);
//		Matcher macth = pattern.matcher(input);
//		Boolean macthFound = macth.matches();
//		System.out.println("_Match " + macthFound);
		
//		String input = "onnp";
//		String patternStr = ".n{1,3}p$";
//		Pattern pattern = Pattern.compile(patternStr);
//		Matcher macth = pattern.matcher(input);
//		Boolean macthFound = macth.matches();
//		System.out.println("_Match " + macthFound);
		
//		String input = "2bkbv";
//		String patternStr = ".+[abc][zv].*";
//		Pattern pattern = Pattern.compile(patternStr);
//		Matcher macth = pattern.matcher(input);
//		Boolean macthFound = macth.matches();
//		System.out.println("_Match " + macthFound);
		
		String input = "int lastName;";	//dung
//		String input = "name5";		//dung
//		String input = "name";	//dung
//		String input = "Name";	//sai
		
		String patternStr = "(boolean|byte|char|short|int|long|float|double){1}\s[a-z]+(([A-Z].*)|.)*;";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher macth = pattern.matcher(input);
		Boolean macthFound = macth.find();
		System.out.println("_Match " + macthFound);
	}
}
