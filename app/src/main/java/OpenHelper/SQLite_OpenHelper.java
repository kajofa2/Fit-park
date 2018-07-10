package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;

public class SQLite_OpenHelper extends SQLiteOpenHelper
{
    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {

        //Creacion de la tabla
    String sqlUsuario="create table usuarios(id_us integer primary key autoincrement, " +
            "Usuario text, Password text);";
    sdb.execSQL(sqlUsuario);


        String sqlPerfil = "create table perfil(id_per integer primary key autoincrement," +
                "Nombre text, Apellido text, Estatura int, Peso int, usuarios_id integer," +
                "FOREIGN KEY (usuarios_id) REFERENCES usuarios(id_us));";
        sdb.execSQL(sqlPerfil);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    //metodo que permite abrir la base de datos
    public void abrir(){

        this.getWritableDatabase();
    }

    //metodo que permite cerrar la base de datos

    public void cerrar()
    {
        this.close();
    }

    //metodo que permite insertar registros en la tabla usuarios

    public void insertarRegis(String usuario, String pass)
    {
        ContentValues valores = new ContentValues();
        valores.put("Usuario", usuario);
        valores.put("Password", pass);


        this.getWritableDatabase().insert("usuarios", null, valores);

    }

    //metodo para insertar datos al perfil
    public void insertarPerfil(String nombre, String apellido, int estatura, int peso)
    {
        ContentValues valores = new ContentValues();
        valores.put("Nombre", nombre);
        valores.put("Apellido", apellido);
        valores.put("Estatura", estatura);
        valores.put("Peso", peso);

        this.getWritableDatabase().insert("perfil", null, valores);
    }

    //metodo que permite validar si el usuario existe

    public Cursor ConsultarUsupas(String usu, String pas) throws SQLException{
        //el cursor es en donde se  guadaron los datos de un select

        Cursor mcursor= null;

        mcursor = this.getReadableDatabase().query("usuarios", new String []{"id_us", "Usuario", "Password"},
                "Usuario like'"+usu+"' and Password like '"+pas+"'",
                null,null,null,null);

        return mcursor; // El resultado de la consulta lo guarda en mcursor.
        // si el usuario existe te guarda un registro

    }

    public Cursor ConsultarPerfil (Integer usuarios_id) throws SQLException{

        Cursor mcursor= null;
        mcursor = this.getReadableDatabase().query("perfil", new String []{"id_per", "usuarios_id"},
                "usuarios_id",
                null,null,null,null);
        return mcursor;

    }
}

