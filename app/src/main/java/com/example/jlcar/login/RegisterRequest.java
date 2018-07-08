package com.example.jlcar.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest{
    private static final String REGISTER_REQUEST_URL="http://fitnessplay.000webhostapp.com/conexion.php";
    private Map<String,String> params;
    public RegisterRequest(String email, String pass1, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params=new HashMap<>();
        params.put("email",email);
        params.put("pass1",pass1);
    }

    @Override
    public Map<String,String> getParams()
    {
        return params;
    }
}
