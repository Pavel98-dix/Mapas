package com.example.mapas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlLocalizacion extends SQLiteOpenHelper {
    //Datos de la tabla
    public String tabla=(("CREATE TABLE ubicaciones (id integer primary key autoincrement, calle text, latitud real, longitud real)"));

    public SqlLocalizacion(@Nullable Context context, @Nullable
            String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        //Nombre de la base de datos.
        super(context, "Direcciones", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creación de la tabla
        db.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Eliminacion de la tabla
        db.execSQL("DROP TABLE ubicaciones");
    }
}
