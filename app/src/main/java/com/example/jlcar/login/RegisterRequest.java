package com.example.jlcar.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest{
    private static final String REGISTER_REQUEST_URL:"fitnessplay.000webhostapp.com/dbConnect.php";
    private Map<String,String> params;
    public RegisterRequest(String name, String pass, String pass2, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params=new HashMap<>();
        params.put("name",name);
        params.put("pass",pass);
        params.put("pass2",pass2);
//vcvcssspes
        @Override
        public Map<String,String> getParams(){

        }
    }
}
