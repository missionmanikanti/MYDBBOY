package mypack;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test3 
{
	public static void main(String[] args) 
	{
		//Creating a Mongo client 
	    MongoClient mc=new MongoClient("localhost",27017);  
	    //Access the database 
	    MongoDatabase db=mc.getDatabase("indiadb"); 
	    //Access the collection
	    MongoCollection<Document> col=db.getCollection("people");
	    //insert one document into collection
	    Document doc=new Document("name","kalam");
	    doc.append("age","93");
	    doc.append("designation","teacher");
	    doc.append("url", "http://www.abdulkalam.com");
	    col.insertOne(doc);
	    mc.close();
	}
}
