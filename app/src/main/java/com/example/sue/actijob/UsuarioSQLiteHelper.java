package com.example.sue.actijob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sue on 14/1/18.
 */

public class UsuarioSQLiteHelper extends SQLiteOpenHelper{

    //Se crea una variable que contendrá la sentencia SQL de creación de la tabla
    String sql = "CREATE TABLE Seguimiento (Identificacion INTEGER, Nombres TEXT, Apellidos TEXT)";

    public UsuarioSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Este método se ejecuta automáticamente cuando la base de datos no existe
        //es decir, que la primera vez que se hace llamada a la clase, crea la BD
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Este método se ejecuta cuando se detecta que la vesión de la base de datos
        //cambió, por lo que se deben definir todos los procesos de migración de la estructura
        //anterior a la estructura nueva. Por simplicidad del ejemplo, lo que haremos es eliminar la
        //tabla existente y crearla nuevamente

        db.execSQL("DROP TABLE IF EXISTS Cliente");
        db.execSQL(sql);
        //https://www.youtube.com/watch?v=yeQ1l7MVpGI 8minutos


    }
}
