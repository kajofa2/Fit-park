package com.example.jlcar.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Registro extends AppCompatActivity {

    Button btnRegistrar;
    EditText txtUsuReg, txtPas1,txtPas2;


    SQLite_OpenHelper helper= new SQLite_OpenHelper(this, "BD1", null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);
        txtUsuReg = (EditText)findViewById(R.id.txtUsuarioReg);
        txtPas1 = (EditText)findViewById(R.id.txtpass1);
        txtPas2 = (EditText)findViewById(R.id.txtpass2);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String passwd1Text = txtPas1.getText().toString();
                String passwd2Text = txtPas2.getText().toString();
                String email = txtUsuReg.getText().toString();

                if(email.isEmpty() && passwd1Text.isEmpty() && passwd2Text.isEmpty())
                {
                    mensajes("Se deben completar todos  los campos");
                }
                else
                {

                    if (validarEmail(email))

                    {

                    if (passwd1Text.equals(passwd2Text))
                        {
                            helper.abrir();
                            helper.insertarRegis(String.valueOf(txtUsuReg.getText()),
                                    String.valueOf(txtPas1.getText()));

                            helper.cerrar();

                            mensajes("Registro Almacenado con Exito");

                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        }
                        else
                        {
                            mensajes("Las contraseñas deben coincidir");
                        }
                    }
                    else
                    {
                        txtUsuReg.setError("Email no válido");
                    }
                }
            }
        });
    }

    //metodo que permite validar email

    public final static boolean validarEmail(CharSequence email) {
        if (email== null) return false;
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    //metodo que permite escribir un mensaje
    public void mensajes (String mensaje)
    {
        Toast.makeText(getApplicationContext(), mensaje,
                Toast.LENGTH_LONG).show();
    }
}
