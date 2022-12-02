package org.o7planning.knfood.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.Model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Food.db";
    private static int DATABASE_VERSION = 1;

    public SQLiteHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE foods("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "fName TEXT,note TEXT,price TEXT,date TEXT,status TEXT)";
        String sql1 = "CREATE TABLE vouchers("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "title TEXT,time TEXT,status TEXT)";
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    public List<Food> getAll(){
        List<Food> list = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        String order = "fName DESC";
        Cursor rs = st.query("foods",null,null,
                null,null,null,order);
        while (rs != null && rs.moveToNext()) {
            int id = rs.getInt(0);
            String fName = rs.getString(1);
            String note = rs.getString(2);
            String price = rs.getString(3);
            String date = rs.getString(4);
            String status = rs.getString(5);
            list.add(new Food(id,fName,note,price,date,status));
        }
        return list;
    }
    public List<Voucher> getVoucherAll(){
        List<Voucher> list = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        String order = "time DESC";
        Cursor rs = st.query("vouchers",null,null,
                null,null,null,order);
        while (rs != null && rs.moveToNext()) {
            int id = rs.getInt(0);
            String title = rs.getString(1);
            String time = rs.getString(2);
            String status = rs.getString(3);
            list.add(new Voucher(id,title,time,status));
        }
        return list;
    }

    public long addFood (Food food) {
        ContentValues values = new ContentValues();
        values.put("fName",food.getfName());
        values.put("note",food.getNote());
        values.put("price",food.getPrice());
        values.put("date",food.getDate());
        values.put("status",food.getStatus());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert("foods",null,values);
    }
    public long addVoucher (Voucher voucher) {
        ContentValues values = new ContentValues();
        values.put("title",voucher.getTitle());
        values.put("time",voucher.getTime());
        values.put("status",voucher.getStatus());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert("vouchers",null,values);
    }

    public List<Food> searchByFName (String key) {
        List<Food> list = new ArrayList<>();
        String whereClause = "fName like ?";
        String[] whereArgs = {"%"+key+"%"};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.query("foods",null,whereClause,whereArgs,null,null,null);
        while (rs != null && rs.moveToNext()) {
            int id = rs.getInt(0);
            String fName = rs.getString(1);
            String note = rs.getString(2);
            String price = rs.getString(3);
            String date = rs.getString(4);
            String status = rs.getString(5);
            list.add(new Food(id,fName,note,price,date,status));
        }
        return list;
    }

    public List<Food> searchByNote (String noiDung) {
        List<Food> list = new ArrayList<>();
        String whereClause = "ten like ?";
        String[] whereArgs = {"%"+noiDung+"%"};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.query("foods",null,whereClause,whereArgs,null,null,null);
        while (rs != null && rs.moveToNext()) {
            int id = rs.getInt(0);
            String fName = rs.getString(1);
            String note = rs.getString(2);
            String price = rs.getString(3);
            String date = rs.getString(4);
            String status = rs.getString(5);
            list.add(new Food(id,fName,note,price,date,status));
        }
        return list;
    }

    public List<Food> getByDate (String date) {
        List<Food> list = new ArrayList<>();
        String whereClause = "date like ?";
        String[] whereArgs = {date};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.query("foods",null,whereClause,whereArgs,null,null,null);
        while (rs != null && rs.moveToNext()) {
            int id = rs.getInt(0);
            String fName = rs.getString(1);
            String note = rs.getString(2);
            String price = rs.getString(3);
            String status = rs.getString(5);
            list.add(new Food(id,fName,note,price,date,status));
        }
        return list;
    }
//
    public int update (Food food) {
        ContentValues values = new ContentValues();
        values.put("fName",food.getfName());
        values.put("note",food.getNote());
        values.put("price",food.getPrice());
        values.put("date",food.getDate());
        values.put("status",food.getStatus());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String whereClause = "id= ?";
        String[] whereArgs = {Integer.toString(food.getId())};
        return sqLiteDatabase.update("foods",values,whereClause,whereArgs);
    }

    public int delete (int id) {
        String whereClause = "id= ?";
        String[] whereArgs = {Integer.toString(id)};
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete("foods",whereClause,whereArgs);
    }
}
