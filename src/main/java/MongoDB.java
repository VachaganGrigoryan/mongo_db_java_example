
import java.net.UnknownHostException;
import java.util.*;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class MongoDB {

    public static void main(String[] args) throws UnknownHostException {

        // Creating a Mongo client
        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("vachagan", "myJavaDB",
                "password".toCharArray());
        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("myJavaDB");
        System.out.println("Credentials ::"+ credential);

        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection("Accounts");
        System.out.println("Collection Accounts selected successfully");

        collection.drop();

        ArrayList<Resource> resources = new ArrayList<Resource>();
        resources.add(new Resource(1,"PC","1","01/10/2019",false));
        resources.add(new Resource(2,"Table","1","01/08/2019",true));
        User user = new User(1,"Vachagan","Grigoryan","vachagan_g@instigatemobile.com","password","13/10/1995","contract","sQA",resources,true);

        collection.insertOne(createDocument(user));

        Map findobj = new HashMap();
        findobj.put("_id",1);
        HashMap<String,String> updateobj = new HashMap<String,String>();
        updateobj.put("name","Anna");
        updateobj.put("lastname","Sargsyan");

        updateCollection(collection,findobj,updateobj);

        showCollection(collection);
    }

    private static void updateCollection(MongoCollection<Document> collection, Map findOBJ,HashMap<String,String> updateOBJ){
        Set set = updateOBJ.entrySet();
        Iterator iterator = set.iterator();
        String key = "";
        for (Object i : findOBJ.keySet()) {
            key = i.toString();
        }
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.println(key+mentry.getKey().toString()+ mentry.getValue().toString());
            collection.updateOne(Filters.eq(key, findOBJ.get(key)), Updates.set(mentry.getKey().toString(), mentry.getValue().toString()));
        }
    }

    private  static  Document createDocument(User user){
        List<Document> resource = new ArrayList<Document>();
        ArrayList<Resource> res = user.getResource();
        for(int i = 0; i < res.size(); i++){
            resource.add(new Document()
            .append("id",res.get(i).getId())
            .append("name",res.get(i).getName())
            .append("count",res.get(i).getCount())
            .append("date",res.get(i).getDate())
            .append("isStatus",res.get(i).isStatus()));
        }

        Document document = new Document()
                .append("_id", user.getId())
                .append("name", user.getName())
                .append("lastname", user.getLastname())
                .append("email", user.getEmail())
                .append("password",user.getPassword())
                .append("birddate",user.getBirddate())
                .append("contract",user.getContract())
                .append("role",user.getRole())
                .append("resource",resource)
                .append("isStatus",user.isStatus());
        return document;
    }

    private static void showCollection(MongoCollection<Document> collection){
        // Getting the iterable object
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;

        // Getting the iterator
        Iterator it = iterDoc.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
    }

}
