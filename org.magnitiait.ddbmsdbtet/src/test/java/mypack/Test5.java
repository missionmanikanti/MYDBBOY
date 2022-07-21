package mypack;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Test5 
{
	public static void main(String[] args) 
	{
		//Creating a Mongo client 
	    MongoClient mc=new MongoClient("localhost",27017);  
	    //Access the database 
	    MongoDatabase db=mc.getDatabase("indiadb"); 
	    //update matching documents in collection
	    MongoCollection<Document> col=db.getCollection("people");
	    col.updateMany(Filters.eq("name","sania mirza"),Updates.set("name","sania malik"));
	    mc.close();
	}
}
