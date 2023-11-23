package com.example.contador;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MiBaseDeDatos.db";
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public BaseDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Código para crear las tablas de la base de datos
        // Ejemplo:
        // db.execSQL("CREATE TABLE IF NOT EXISTS tabla_nombre (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Código para actualizar la base de datos si es necesario
    }
    public void agregarUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", usuario.getUsername());
        values.put("password", usuario.getPassword());
        db.insert("usuarios", null, values);
        db.close();
    }
}

