package app.oneapp.eddy.myapp.com.oneapp;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class empresaSQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_Nombre= "app.sqlite";

    public empresaSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_Nombre, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Adaptador.sqlCreateEmpresa);
        db.execSQL(Adaptador.sqlCreatePartido);
        db.execSQL(Adaptador.getSqlCreateTransmision);
        db.execSQL(Adaptador.getSqlCreateHorasRegistradas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Empresa");
        db.execSQL(Adaptador.sqlCreateEmpresa);
        db.execSQL("DROP TABLE IF EXIST Partido");
        db.execSQL(Adaptador.sqlCreatePartido);
        db.execSQL("DROP TABLE IF EXIST Transmision");
        db.execSQL(Adaptador.getSqlCreateTransmision);
        db.execSQL("DROP TABLE IF EXIST HorasRegistradas");
        db.execSQL(Adaptador.getSqlCreateHorasRegistradas);

    }
}

