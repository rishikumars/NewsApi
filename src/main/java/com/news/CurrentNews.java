package com.news;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.*;

public class CurrentNews {
    static String api="";

   public static void initApi(String apikey){
        api=apikey;
    }
    public static List<Map> getNewsByLanguage(String language) throws IOException {
        if(api != ""){
        HttpClient httpClient=new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("https://newsapi.org/v2/sources?language="+language+"&apiKey="+api);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        JSONObject jsonObject = new JSONObject(responseString);
        JSONArray jsonArray=jsonObject.getJSONArray("sources");
        List<Map> list=  mapObjects(jsonArray);
        return list;}
        else{
        System.out.println("Null Pointer Exception:Missing API or Wrong API");
        return null;
    }

}


    public static List<Map> getNewsByCategory(String category) throws IOException {
        if(api != ""){
        HttpClient httpClient=new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("https://newsapi.org/v2/sources?category="+category+"&apiKey="+api);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        JSONObject jsonObject = new JSONObject(responseString);
        JSONArray jsonArray=jsonObject.getJSONArray("sources");
        List<Map> list=  mapObjects(jsonArray);
        return list;}
        else{
          System.out.println("Null Pointer Exception:Missing API or Wrong API");
          return null;
      }


    }

    public static List<Map> getHeadlinesByCountry(String country) throws IOException {
        if(api != ""){
        HttpClient httpClient=new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("https://newsapi.org/v2/top-headlines?country="+country+"&apiKey="+api);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");

        JSONObject jsonObject1=new JSONObject(responseString);
        JSONArray jsonArray=jsonObject1.getJSONArray("articles");
        List<Map> list=  mapObjects1(jsonArray);
        return list;}
        else{
        System.out.println("Null Pointer Exception:Missing API or Wrong API");
        return null;
    }

}
    public static List<Map> getNewsByTopic(String topic) throws IOException {
        if(api != ""){
            HttpClient httpClient=new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("https://newsapi.org/v2/everything?q="+topic+"&apiKey="+api);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            JSONObject jsonObject = new JSONObject(responseString);
            int  value = jsonObject.getInt("totalResults");
            System.out.println(value);
            JSONObject jsonObject1=new JSONObject(responseString);
            JSONArray jsonArray=jsonObject1.getJSONArray("articles");
            List<Map> list=  mapObjects1(jsonArray);
            return list;}
        else{
            System.out.println("Null Pointer Exception:Missing API or Wrong API");
            return null;
        }

    }

    private static List<Map> mapObjects1(JSONArray jsonArray) {
        List<Map> list=new ArrayList<Map>();
        for(int i=0;i<jsonArray.length();i++) {
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            Map<String,String> map=new HashMap<>();
            map.put("author",jsonObject2.optString("author"));
            map.put("title",jsonObject2.optString("title"));
            map.put("description",jsonObject2.optString("description"));
            map.put("url",jsonObject2.optString("url"));
            map.put("urlToImage",jsonObject2.optString("urlToImage"));
            map.put("publishedAt",jsonObject2.optString("publishedAt"));
            list.add(map);
        }
        return list;
    }

    private static List<Map> mapObjects(JSONArray jsonArray) {
        List<Map> list=new ArrayList<Map>();
        for(int i=0;i<jsonArray.length();i++) {
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            Map<String,String> map=new HashMap<>();
            map.put("id",jsonObject2.optString("id"));
            map.put("name",jsonObject2.optString("name"));
            map.put("description",jsonObject2.optString("description"));
            map.put("url",jsonObject2.optString("url"));
            map.put("category",jsonObject2.optString("category"));
            map.put("language",jsonObject2.optString("language"));
            map.put("country",jsonObject2.optString("country"));
            list.add(map);
        }
        return list;
    }


}
