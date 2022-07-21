package mypack;
import java.io.FileOutputStream;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
public class Test11
{
	public static void main(String[] args) throws Exception
	{
		//image download
		MongoClient mc=new MongoClient("localhost",27017);
		MongoDatabase db=mc.getDatabase("indiadb");
		GridFSBucket gb=GridFSBuckets.create(db);
		FileOutputStream fo=new FileOutputStream("E:\\batch260\\download-image.jpg");
		gb.downloadToStream("tulips",fo);
		fo.close();
		mc.close();
	}
}
