package com.example.myfirstapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfirstapp.setup.SetupDatabase;

public class MembroDAO {

    private SQLiteDatabase database;
    private SetupDatabase setupDB;

    public MembroDAO(Context context) {
        setupDB = new SetupDatabase(context);
    }

    public String insereMembro(String nome, String dataNasc, String email, String celular) {
        ContentValues valores;
        long resultado;

        database = setupDB.getWritableDatabase();
        valores = new ContentValues();
        valores.put(SetupDatabase.FIELD_NAME, nome);
        valores.put(SetupDatabase.FIELD_BIRTHDATE, dataNasc);
        valores.put(SetupDatabase.FIELD_EMAIL, email);
        valores.put(SetupDatabase.FIELD_PHONECEL, celular);

        resultado = database.insert(SetupDatabase.TABLE_MEMBRO, null, valores);
        database.close();

        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }

    }

}
