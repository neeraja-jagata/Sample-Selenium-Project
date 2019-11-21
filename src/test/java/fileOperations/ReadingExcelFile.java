package fileOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingExcelFile {

	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\Neeraja\\Documents\\study\\java\\FileOp\\MyExcel.xlsx");
		FileInputStream fin= new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fin);
		//Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet0=workbook.getSheetAt(0);
		Row row0=sheet0.getRow(0); 	Row row1=sheet0.getRow(1); 
		Cell cell0=row0.getCell(0); Cell cell1=row0.getCell(1);
		Cell cell2=row1.getCell(0); Cell cell3=row1.getCell(1);
		System.out.println("Sheet0: First Sheet");
		System.out.println(cell0 + "	" +cell1);
		System.out.println(cell2 + "	" +cell3);
		
		Sheet sheet1=workbook.getSheet("second sheet");
		System.out.println("Sheet0: second Sheet");
		for (Row row : sheet1) {
			for (Cell cell : row) {
				//System.out.print(cell.getStringCellValue() + "	");
				switch(cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t");
						break;
					case BLANK:	
						System.out.print("\t");
						break;
					default:
						break;
			
				}
			}
			System.out.println();
		}
		workbook.close();
		fin.close();
		
		 
	}

}
