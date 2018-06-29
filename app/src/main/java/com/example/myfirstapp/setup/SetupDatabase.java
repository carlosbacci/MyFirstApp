package com.example.myfirstapp.setup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SetupDatabase extends SQLiteOpenHelper {

    private static final String NAME_DATABASE = "church.db";
    private static final int VERSAO = 1;

    public static final String TABLE_MEMBRO = "membros";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_BIRTHDATE = "birthdate";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_PHONECEL = "phonecel";

    public SetupDatabase(Context context) {
        super(context, NAME_DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_MEMBRO + " (" +
                "id integer primary key autoincrement, " +
                "name text, " +
                "birthdate text, " +
                "email text, " +
                "phonecel text)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_MEMBRO);
        onCreate(sqLiteDatabase);
    }
}
