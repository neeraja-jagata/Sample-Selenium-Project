package fileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcelFile {

	public static void main(String[] args) throws IOException {
		// Creating workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet1=workbook.createSheet("first sheet");
		XSSFSheet sheet2=workbook.createSheet("second sheet");
		
		Row row0=sheet1.createRow(0);  Row row1=sheet1.createRow(1);
		Cell cell00= row0.createCell(0); 	
		Cell cell10= row1.createCell(0);
		Cell cell01= row0.createCell(1);	
		Cell cell11= row1.createCell(1);
		cell00.setCellValue("ID");	cell01.setCellValue("Name");
		cell10.setCellValue("11");	cell11.setCellValue("Neeraja");
		
		for(int rowNum=0;rowNum<10;rowNum++) {
			Row row=sheet2.createRow(rowNum);
			for(int colNum=0;colNum<10;colNum++) {
				Cell cell=row.createCell(colNum);
				cell.setCellValue((int)(Math.random()*100));
			}
		}
		
		File file=new File("C:\\Users\\Neeraja\\Documents\\study\\java\\FileOp\\MyExcel.xlsx");
		FileOutputStream fo= new FileOutputStream(file);
		
		workbook.write(fo);
		
		workbook.close();
		fo.close();
		
		System.out.println("file created");
		
	}

}
