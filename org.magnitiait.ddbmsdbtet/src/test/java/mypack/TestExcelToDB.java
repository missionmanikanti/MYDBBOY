package mypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestExcelToDB 
{
	public static void main(String[] args) throws Exception
	{
	    //Open excel file
		File f=new File("src\\test\\resources\\Book1.xlsx");
		//Take READ permission
		FileInputStream fi=new FileInputStream(f);
		//Access that file as an Excel Workbook
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Sheet1");
		int nour=sh.getPhysicalNumberOfRows(); //count of used rows
		int nouc=sh.getRow(0).getLastCellNum(); //count of used columns
		//Create result column(next to last column) with current date and time as heading
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		Cell rc=sh.getRow(0).createCell(nouc);
		rc.setCellValue("Results on "+sf.format(dt));
		//Creating a Mongo client 
	    MongoClient mc=new MongoClient("localhost",27017);  
	    //Access the database 
	    MongoDatabase db=mc.getDatabase("indiadb"); 
	    //get collection
	    MongoCollection<Document> col=db.getCollection("people");
		//loop from 2nd row(index=1) in excel file due to 1st row has names of columns
		for(int i=1;i<nour;i++)
		{
			//take data from ith row in sheet1
			DataFormatter df=new DataFormatter();
			String x=df.formatCellValue(sh.getRow((i)).getCell(0));
			String y=df.formatCellValue(sh.getRow((i)).getCell(1));
			String z=df.formatCellValue(sh.getRow((i)).getCell(2));
			String w=df.formatCellValue(sh.getRow((i)).getCell(3));
			//insert document
			try
			{
				//perform insert
				Document doc=new Document("name",x)
		    		     .append("age",y)
		    		     .append("designation",z)
		    		     .append("url",w);
				col.insertOne(doc);
				sh.getRow(i).createCell(nouc).setCellValue("correct insertion");
			}
			catch(Exception ex)
			{
				sh.getRow(i).createCell(nouc).setCellValue("Wrong insertion");
			}
		}
		sh.autoSizeColumn(nouc); //auto fit on column size
		//save and close excel
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();
	    //close mongo client
	    mc.close();
	}
}
