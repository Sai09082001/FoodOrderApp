package org.o7planning.knfood.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.o7planning.knfood.Model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodDAO {
    private SQLiteDatabase db;
    public FoodDAO(Context context){
//        DBHelper helper = new DBHelper(context);
//        db = helper.getWritableDatabase();
    }
    public List<Food> get(String sql, String ...selectAgrs){
        List<Food> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,selectAgrs);
        while (cursor.moveToNext()){
            Food food = new Food();
//            food.setTitle(cursor.getString(cursor.getColumnIndex("Title")));
//            food.setOriginal_price(cursor.getDouble(cursor.getColumnIndex("Original_price")));
//            food.setPrice(cursor.getDouble(cursor.getColumnIndex("Price")));
//            food.setImg(cursor.getString(cursor.getColumnIndex("Img")));
            list.add(food);
        }
        return  list;
    }

    public List<Food> getAll(){
        String sql = "SELECT * FROM dbo.Food";
        return get(sql);
    }
    public long insertFood(Food food){
        ContentValues contentValues = new ContentValues();
//        contentValues.put("Title",food.getTitle());
//        contentValues.put("Original_price",food.getOriginal_price());
//        contentValues.put("Price",food.getPrice());
//        contentValues.put("Img",food.getImg());
        return db.insert("Food",null,contentValues);
    }
//    public long updateFood(Food food){
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("Title",food.getTitle());
//        contentValues.put("Original_price",food.getOriginal_price());
//        contentValues.put("Price",food.getPrice());
//        contentValues.put("Img",food.getImg());

//        return db.update("Food",contentValues,"Title=?",new String[]{food.getTitle()});
//    }
    public int deleteAccount(String title){
        return db.delete("Food","Title=?",new String[]{title});
    }

}
