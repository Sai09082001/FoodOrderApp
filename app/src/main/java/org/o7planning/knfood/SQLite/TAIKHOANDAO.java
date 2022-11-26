package org.o7planning.knfood.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.o7planning.knfood.Model.User;

import java.util.ArrayList;
import java.util.List;

public class TAIKHOANDAO {
    private SQLiteDatabase db;
    public TAIKHOANDAO(Context context){
//        DBHelper helper = new DBHelper(context);
//        db = helper.getWritableDatabase();
    }

    @SuppressLint("range")
    public List<User> get(String sql, String ...selectAgrs){
        List<User> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,selectAgrs);

        while (cursor.moveToNext()){
            User tk = new User();
            tk.setId(cursor.getString(cursor.getColumnIndex("ID")));
            tk.setUserName(cursor.getString(cursor.getColumnIndex("Username")));
            tk.setDisplayName(cursor.getString(cursor.getColumnIndex("Displayname")));
            tk.setTypeID(cursor.getString(cursor.getColumnIndex("TypeID")));
            list.add(tk);
        }
        return  list;
    }

    public List<User> getAll(){
        List<User> list = new ArrayList<>();
        String order = "name DESC";
        Cursor rs = db.query("taikhoans",null,null,
                null,null,null,order);
        while (rs != null && rs.moveToNext()) {
            int id = rs.getInt(0);
            String name = rs.getString(1);
            String password = rs.getString(2);
            String displayName = rs.getString(3);
            int typeId = rs.getInt(4);
          //  list.add(new User(id,name,password,displayName,typeId));
        }
        return list;
    }

    public User GetAccountByID(String id){
        String sql = "SELECT * FROM dbo.TAIKHOAN WHERE ID = ?";
        List<User> list = get(sql,id);
        return list.get(0);
    }
    public long insertAccount(User tk){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID",tk.getId());
        contentValues.put("Username",tk.getUserName());
        contentValues.put("Displayname",tk.getDisplayName());

        return db.insert("TAIKHOAN",null,contentValues);
    }
    public long updateAccount(User tk){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",tk.getUserName());
        contentValues.put("Displayname",tk.getDisplayName());

        return db.update("TAIKHOAN",contentValues,"ID=?",new String[]{String.valueOf(tk.getId())});
    }
    public int deleteAccount(String id){
        return db.delete("TAIKHOAN","ID=?",new String[]{id});
    }
    public boolean checkUsername(String username){
        Cursor cursor = db.rawQuery("SELECT * FROM TAIKHOAN WHERE Username = ?",new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkLogin(String username,String password){
        Cursor cursor = db.rawQuery("SELECT * from TAIKHOAN WHERE Username = ? AND Password = ?",new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

}
