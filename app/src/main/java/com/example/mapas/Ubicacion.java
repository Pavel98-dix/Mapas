package com.example.mapas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ubicacion extends AppCompatActivity {
    TextView tvMostrar;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);
        SqlLocalizacion lugar= new SqlLocalizacion(this,"ubicaciones",null,1);
        SQLiteDatabase db=lugar.getWritableDatabase();
        c=db.rawQuery("SELECT * FROM ubicaciones",null);

        if (c.moveToFirst())
        {
            do {
                Integer id=c.getInt(0);
                String calle=c.getString(1);
                Double latitud=c.getDouble(2);
                Double longitud= c.getDouble(3);
                tvMostrar.append("ID"+id+"\n Direccion: "+calle
                        +"\n"+"Latitud: "+latitud+"\nLongitud"+longitud+"\n\n\n");
            }while (c.moveToNext());
            db.close();
        }
    }
}