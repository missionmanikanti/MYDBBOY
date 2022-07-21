package mypack;

import com.mongodb.MongoClient;

public class Test1 
{
	public static void main(String[] args) throws Exception
	{
		//Creating a Mongo client 
	    MongoClient mc=new MongoClient("localhost",27017);  
	    //1. create a new database 
	    mc.getDatabase("indiadb"); 
	    mc.close();
	}
}
