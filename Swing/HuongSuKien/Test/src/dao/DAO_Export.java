package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFFont;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;

import entity.ChuyenMon;
//import org.o7planning.apachepoiexcel.model.Employee;
//import org.o7planning.apachepoiexcel.model.EmployeeDAO;

public class DAO_Export {
	public void exportChamCong() {
//		XSSFWorkbook test;
//		XSSFSheet sheet = new XSSFSheet();
	}
	private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	public static void main(String[] args) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Employees");
		DAO_ChuyenMon daoChuyenMon = new DAO_ChuyenMon();
		List<ChuyenMon> list = daoChuyenMon.getDanhSachChuyenMon();

		int rownum = 1;
		Cell cell;
		Row row;
		//
		HSSFCellStyle style = createStyleForTitle(workbook);

		row = sheet.createRow(rownum);

		// EmpNo
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("EmpNo");
		cell.setCellStyle(style);
		// EmpName
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("EmpNo");
		cell.setCellStyle(style);
		// Salary
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Salary");
		cell.setCellStyle(style);
		// Grade
		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Grade");
		cell.setCellStyle(style);
		// Bonus
		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Bonus");
		cell.setCellStyle(style);

		// Data
		for (ChuyenMon emp : list) {
			rownum++;
			row = sheet.createRow(rownum);

			// EmpNo (A)
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(emp.getMaCM());
			// EmpName (B)
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(emp.getTenCM());
			// Salary (C)
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(emp.getMoTa());
		}
		File file = new File("C:/Users/quann/Desktop/employee.xlsx");
		file.getParentFile().mkdirs();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		System.out.println("Created file: " + file.getAbsolutePath());
	}
}
