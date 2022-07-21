package mypack;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Test7 
{
	public static void main(String[] args) 
	{
		//Creating a Mongo client 
	    MongoClient mc=new MongoClient("localhost",27017);  
	    //Access the database 
	    MongoDatabase db=mc.getDatabase("indiadb"); 
	    //collect and display names of all collections in that database
	    MongoIterable<String> l=db.listCollectionNames();
	    for(String n:l)
	    {
	    	System.out.println(n);
	    }
	    mc.close();
	}
}
