package com.example.demo.service;

import com.example.demo.models.response.api.Amindi;
import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
@Service
public class AmindServiceImpl implements AmindService {
    @Override
    public String getUrl(String link) {
        StringBuilder crunchifyStringBuilder=new StringBuilder();
        URLConnection crunchifyURLConnection=null;
        InputStreamReader in=null;
        try{
            URL url=new URL(link);
            crunchifyURLConnection=url.openConnection();
            if(crunchifyURLConnection!=null){
                crunchifyURLConnection.setReadTimeout(5*1000);
                if(crunchifyURLConnection!=null &&  crunchifyURLConnection.getInputStream() != null){
                    in=new InputStreamReader(crunchifyURLConnection.getInputStream(), Charset.defaultCharset());
                    BufferedReader bufferedReader = new BufferedReader(in);
                        if(bufferedReader!=null){
                            int cp;
                            while((cp=bufferedReader.read())!=-1){
                                crunchifyStringBuilder.append(((char)cp));
                            }
                            bufferedReader.close();
                        }

                }
                in.close();
            }
        }catch(Exception e){
            e.getMessage();
        }
        return crunchifyStringBuilder.toString();
    }

    @Override
    public Amindi getUrlObject(String link) throws IOException {

        String jsonString = link;

      Gson gson=new Gson();
      System.out.println("gogaaaaaa");
System.out.println(jsonString);
      return gson.fromJson(jsonString, Amindi.class);
    }

    @Override
    public String GetRequests(String city) throws IOException {
        if(city.equals("bakuriani")){
            city="615583";
        }else if(city.equals("tbilisi")){
            city="611717";
        }else if(city.equals("mtskheta")){
            city="612890";
        }else if(city.equals("batumi")){
            city="615532";
        }else if(city.equals("kutaisi")){
            city="613607";
        }
        OkHttpClient client = new OkHttpClient();
        String url="https://any.ge/weather/api2.php?get=daily&id="+city;
        Request request=new Request.Builder()
                .url(url).build();
        Call call=client.newCall(request);
        Response response=call.execute();
        return response.body().string();
    }

    private static void crunchifyPrint(String print){
        System.out.println(print);
    }
}
