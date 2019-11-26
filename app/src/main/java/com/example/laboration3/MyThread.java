package com.example.laboration3;

import android.os.AsyncTask;
import android.os.Message;
import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.GenericArrayType;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MyThread extends AsyncTask {
    String input;
    String URLstring;
    URL url;
    int id;
    ArrayList<String> outputNames;
    int outputId;
    MyAdapter myAdapter;
    String inputLine;
    String result;
    int NUMBER_OF_NAMES_SHOWING = 3;


    public MyThread(String input, int id){
        this.input = input;
        this.id = id;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        URLstring = ("http://andla.pythonanywhere.com/getnames/" + id + "/" + input);
        try {
            url = new URL(URLstring);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);

            connection.connect();

            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());

            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();
            while((inputLine = reader.readLine()) != null){
                stringBuilder.append(inputLine);

            }

            reader.close();
            streamReader.close();
            connection.disconnect();

            result = stringBuilder.toString();
        }
        catch(IOException e){
            e.printStackTrace();

        }
        return result;
    }

    @Override
    protected void onPostExecute(Object o) {
        try {
            if (result != null) {
                JSONObject object = new JSONObject(result);
                int j = object.getInt("id");
                JSONArray jarr = object.getJSONArray("result");

                outputNames = new ArrayList<String>();
                if (jarr !=null){
                    for(int i = 0; i<jarr.length(); i++){
                        outputNames.add(jarr.getString(i));
                    }
                }
                System.out.println(outputNames);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        myAdapter.updateData(outputId, outputNames, NUMBER_OF_NAMES_SHOWING);
    }
}
