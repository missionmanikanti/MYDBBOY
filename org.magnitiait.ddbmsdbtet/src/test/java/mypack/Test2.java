package mypack;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Test2 
{
	public static void main(String[] args) 
	{
		//Creating a Mongo client 
	    MongoClient mc=new MongoClient("localhost",27017);  
	    //Access the database 
	    MongoDatabase db=mc.getDatabase("indiadb"); 
	    //Create a collection
	    db.createCollection("people"); 
	    mc.close();
	}
}
