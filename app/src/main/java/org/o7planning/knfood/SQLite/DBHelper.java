package org.o7planning.knfood.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Food.db";
    private static int DATABASE_VERSION = 1;
    public DBHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE taikhoans("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name TEXT NOT NULL, password TEXT NOT NULL, displayName TEXT NOT NULL, typeId int NOT NULL)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS TAIKHOAN";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
