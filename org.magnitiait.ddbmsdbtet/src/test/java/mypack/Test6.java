package mypack;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Test6 
{
	public static void main(String[] args) 
	{
		//Creating a Mongo client 
	    MongoClient mc=new MongoClient("localhost",27017);  
	    //Access the database 
	    MongoDatabase db=mc.getDatabase("indiadb"); 
	    //delete matching documents from collection
	    MongoCollection<Document> col=db.getCollection("people");
	    col.deleteMany(Filters.eq("name","kohli"));
	    mc.close();
	}
}
