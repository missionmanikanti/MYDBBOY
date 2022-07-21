package mypack;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test4 
{
	public static void main(String[] args) 
	{
		//Creating a Mongo client 
	    MongoClient mc=new MongoClient("localhost",27017);  
	    //Access the database 
	    MongoDatabase db=mc.getDatabase("indiadb"); 
	    //insert multiple documents into a collection
	    MongoCollection<Document> col=db.getCollection("people");
	    Document doc1=new Document("name","rahul gandhi")
	    		     .append("age","50")
	    		     .append("designation","upcoming PM");
	    Document doc2=new Document("name","kohli")
   		     .append("designation","team india captain")
   		     .append("url", "http://www.anushkasharma.com");
	    Document doc3=new Document("name","sania mirza")
   		     .append("age","31")
   		     .append("designation","grandslam winner in doubles")
   		     .append("url", "http://www.indiatennis.com");
	    ArrayList<Document> l=new ArrayList<Document>();
	    l.add(doc1);
	    l.add(doc2);
	    l.add(doc3);
	    col.insertMany(l); 
	    mc.close();
	}
}




