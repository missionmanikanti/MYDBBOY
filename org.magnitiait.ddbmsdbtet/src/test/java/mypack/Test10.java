package mypack;

import java.io.File;
import java.io.FileInputStream;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;


public class Test10
{
	public static void main(String[] args) throws Exception
	{
		//https://www.technicalkeeda.com/java-mongodb-tutorials/java-mongodb-upload-download-delete-read-image-using-gridfs-api
		//Open file in Read mode
		String filePath="C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg";
		File f=new File(filePath);
		FileInputStream fi=new FileInputStream(f);
		//Connect to MongoDB server using a client
		MongoClient mc=new MongoClient("localhost",27017);
		//Connect to a DB
		MongoDatabase db=mc.getDatabase("indiadb");
		//Take permissions to upload a file into DB
		GridFSBucket gb=GridFSBuckets.create(db);
	    GridFSUploadOptions uo=new GridFSUploadOptions().chunkSizeBytes(1024);
	    //image upload to DB
		gb.uploadFromStream("tulips", fi, uo);
		mc.close();
	}
}
