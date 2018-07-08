package com.example.jlcar.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import OpenHelper.SQLite_OpenHelper;
import com.example.jlcar.login.entidades.Perfil;


public class Controlador_perfil extends AppCompatActivity {

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);



        Bundle datos = this.getIntent().getExtras();
        int id = datos.getInt("id_us");
        String id2 = String.valueOf(id);

        Perfil p = new Perfil();


        if(id2.equals(p.getUsuarios_id()))
        {
            Toast.makeText(getApplicationContext(), "Vista Perfil",Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent i = new Intent(getApplicationContext(), Principal.class);
            startActivity(i);

        }


    }
}