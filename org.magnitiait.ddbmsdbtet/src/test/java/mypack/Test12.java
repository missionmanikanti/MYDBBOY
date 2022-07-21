package mypack;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class Test12
{
	public static void main(String[] args) 
	{
		//Creating a Mongo client 
	    MongoClient mc=new MongoClient("localhost",27017);  
	    //Access the database 
	    MongoDatabase db=mc.getDatabase("indiadb"); 
	    //drop collection and DB
	    MongoCollection<Document> col=db.getCollection("people");
	    col.drop();
	    db.drop();
	    mc.close();
	}
}






