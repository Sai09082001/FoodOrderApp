package org.o7planning.knfood;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.Model.Store;
import org.o7planning.knfood.Model.Voucher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonUtils {
    private static String PATTERN = "MM/dd/yyyy HH:mm";
    private static final String FILE_NAME = "file_shared";
    private static CommonUtils instance;
    private CommonUtils() {
        //for singleton
    }

    public static CommonUtils getInstance(){
        if(instance==null){
            instance = new CommonUtils();
        }
        return instance;
    }

    public String getJsonStore(int path){
        InputStream is = KNFoodApp.getInstance().getResources().openRawResource(path);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // json string
        return writer.toString();
    }
    public Store convertStore (String jsonString) {
        Gson gson = new Gson();

        return gson.fromJson(jsonString, Store.class);
       // Log.i("KMFG", "Store: "+store);
    }

    public ArrayList<Food> convertListFood (String jsonString) {
        ArrayList<Food> listFood = new ArrayList<>();
        JSONObject jsonRoot = null;
        try {
            jsonRoot = new JSONObject(jsonString);
            JSONArray jsonArray = jsonRoot.getJSONArray("foods");
            String[] foods = new String[jsonArray.length()];
            JSONArray jsonArray1 = jsonRoot.getJSONArray("prices");
            String[] prices = new String[jsonArray.length()];
            JSONArray jsonArray2 = jsonRoot.getJSONArray("notes");
            String[] notes = new String[jsonArray.length()];

            for(int i=0;i < jsonArray.length();i++) {
                foods[i] = jsonArray.getString(i);
                prices[i] = jsonArray1.getString(i);
                notes[i] = jsonArray2.getString(i);
                Log.i("KMFG", "initViews: "+foods[i]);
                listFood.add(new Food(foods[i],notes[i],prices[i] ));
            }
//            for(int j=0;j < jsonArray1.length();j++) {
//                prices[j] = jsonArray1.getString(j);
//                Log.i("KMFG", "initViews: "+prices[j]);
//            }
//            for(int k=0;k < jsonArray2.length();k++) {
//                notes[k] = jsonArray2.getString(k);
//                Log.i("KMFG", "initViews: "+notes[k]);
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listFood;
    }
    public ArrayList<Voucher> convertListVoucher (String jsonString) {
        ArrayList<Voucher> listVoucher = new ArrayList<>();
        JSONObject jsonRoot = null;
        try {
            jsonRoot = new JSONObject(jsonString);
            JSONArray jsonArray = jsonRoot.getJSONArray("title");
            String[] titles = new String[jsonArray.length()];
            JSONArray jsonArray1 = jsonRoot.getJSONArray("time");
            String[] times = new String[jsonArray.length()];
            JSONArray jsonArray2 = jsonRoot.getJSONArray("status");
            String[] statuses = new String[jsonArray.length()];

            for(int i=0;i < jsonArray.length();i++) {
                titles[i] = jsonArray.getString(i);
                times[i] = jsonArray1.getString(i);
                statuses[i] = jsonArray2.getString(i);
                listVoucher.add(new Voucher(titles[i],times[i],statuses[i] ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listVoucher;
    }
    public boolean isExistPref(String key) {
        SharedPreferences pref=KNFoodApp.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return pref.contains(key);
    }

    public void savePref(String key, String value) {
        SharedPreferences pref=KNFoodApp.getInstance().getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        pref.edit().putString(key,value).apply();
    }

    public String getPref(String key) {
        SharedPreferences pref=KNFoodApp.getInstance().getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        return pref.getString(key,null);
    }

    public void clearPref(String key) {
        SharedPreferences pref = KNFoodApp.getInstance()
                .getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        pref.edit().remove(key).apply();
    }
    public String convertDateToString() {

// Create an instance of SimpleDateFormat used for formatting
// the string representation of date according to the chosen pattern
        DateFormat df = new SimpleDateFormat(PATTERN);

// Get the today date using Calendar object.
        Date today = Calendar.getInstance().getTime();
// Using DateFormat format method we can create a string
// representation of a date with the defined format.
        Log.i("KMFG", "convertDateToString: "+df.format(today));
        return df.format(today);

// Print the result!
    }
}
