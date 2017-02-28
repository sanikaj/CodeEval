/* Sample code to read in test cases:*/
import java.io.*;
import java.util.Iterator;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class Main {
	public static void main (String[] args) throws IOException {
        File file = new File("args[0]");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            if(line != "\n" && !line.trim().isEmpty()) {
        	try {
				line = line.trim();
				JSONObject json = new JSONObject(line);
				JSONObject jsonObj = json.getJSONObject("menu");
				JSONArray jsonArray = (JSONArray) jsonObj.getJSONArray("items");
				int sum=0;
				for(int i=0 ; i<jsonArray.length(); i++) {
				  if(!jsonArray.get(i).equals(null)) {
				  JSONObject jsonObjectArr = jsonArray.getJSONObject(i);
				  if(jsonObjectArr.has("id") && jsonObjectArr.has("label")) {
					 sum += (Integer)jsonObjectArr.get("id"); 
				  }
				 }
			   }
				System.out.println(sum);
        	
				
				
			}  catch (JSONException e) {
				throw new RuntimeException(e);
			}
        }
       }
    }
}
