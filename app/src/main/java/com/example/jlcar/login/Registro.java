package com.example.jlcar.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;


public class Registro extends AppCompatActivity {

    Button btnRegistrar;
    EditText txtUsuReg, txtPas1,txtPas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistrar= findViewById(R.id.btnRegistrar);
        txtUsuReg = findViewById(R.id.txtUsuarioReg);
        txtPas1 = findViewById(R.id.txtpass1);
        txtPas2 = findViewById(R.id.txtpass2);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String pass1 = txtPas1.getText().toString();
                final String pass2= txtPas2.getText().toString();
                final String email = txtUsuReg.getText().toString();

                if(email.isEmpty() && pass1.isEmpty() && pass2.isEmpty())
                {
                    crearMensaje("Se deben completar todos  los campos");
                }
                else
                {

                    if (validarEmail(email))

                    {

                    if (pass1.equals(pass2))
                        {
                            //Registro MySql
                            Response.Listener<String> respoListener = new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success = jsonResponse.getBoolean("succes");

                                        if (success){
                                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                            startActivity(i);
                                            crearMensaje("Usuario Registrado");
                                        }else{
                                            AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                                            builder.setMessage("Error al registrar")
                                                    .setNegativeButton("Reintentar", null)
                                                    .create().show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };

                            RegisterRequest registerRequest = new RegisterRequest(email,pass1,respoListener);
                            RequestQueue queue = Volley.newRequestQueue(Registro.this);
                            queue.add(registerRequest);


                        }
                        else
                        {
                            crearMensaje("Las contraseñas deben coincidir");
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


    public final static boolean validarEmail(CharSequence email) {
        if (email== null) return false;
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public void crearMensaje (String mensaje)
    {
        Toast.makeText(getApplicationContext(), mensaje,
                Toast.LENGTH_LONG).show();
    }
  /*  public void Vista(MainActivity vista)
    {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }*/
}
