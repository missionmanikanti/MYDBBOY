package mypack;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test8 
{
	public static void main(String[] args) throws Exception
	{
		//Start mongo server by running a "mongod" command
		Runtime.getRuntime().exec(
				"cmd.exe /c start cmd.exe /k \"mongod --dbpath E:\\batch260\"");
		Thread.sleep(10000);
		//Creating a Mongo client to Mongo server
	    MongoClient mc=new MongoClient("localhost",27017);  
	    //Access the database 
	    MongoDatabase db=mc.getDatabase("indiadb"); 
	    //collect all documents from a collection
	    MongoCollection<Document> col=db.getCollection("people");
	    FindIterable<Document> docs=col.find(); //no condition to get all documents
	    //display each document by using loop
		Iterator it=docs.iterator();
		while(it.hasNext()) 
		{
			System.out.println(it.next());
		}
	    //Close mongo client
		mc.close();
		Thread.sleep(5000);
	    //Close Mongo server via cmd prompt
		Runtime.getRuntime().exec("taskkill /F /IM mongod.exe"); 
		Thread.sleep(5000);
		//Close cmd prompt
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe"); 	
	}
}
