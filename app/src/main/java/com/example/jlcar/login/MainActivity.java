package com.example.jlcar.login;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jlcar.login.entidades.Usuario;

import OpenHelper.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity {
    TextView lblRegistrar;
    Button btnIngresar;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblRegistrar = (TextView) findViewById(R.id.lblRegistrar);
        lblRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(intentReg);
            }
        });

        btnIngresar = (Button)findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                EditText txtUsu = (EditText)findViewById(R.id.txtUsuario);
                EditText txtPass = (EditText)findViewById(R.id.txtpass);

                String usu = txtUsu.getText().toString();
                String pass = txtPass.getText().toString();


                Cursor cursor = helper.ConsultarUsupas(usu, pass);

                if(cursor.getCount()>0)
                {
                    Intent i = new Intent(getApplicationContext(), Controlador_perfil.class);
                    Usuario u = new Usuario();
                    i.putExtra( "id_us", u.getId_us());
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "usuario y/o pass Incorrectos",Toast.LENGTH_LONG).show();
                }
                txtUsu.setText("");
                txtPass.setText("");
                txtUsu.findFocus();


            }
        });
    }
}
