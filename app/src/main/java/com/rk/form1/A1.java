package com.rk.form1;

import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class A1 extends AppCompatActivity {
    EditText et_roll,et_name,et_phone,et_email,et_password;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_a1);
        et_roll=findViewById(R.id.et_roll_id);
        et_name=findViewById(R.id.et_name_id);
        et_phone=findViewById(R.id.et_phone_id);
        et_email=findViewById(R.id.et_email_id);
        et_password=findViewById(R.id.et_password_id);
        bt1=findViewById(R.id.bt1_id);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                network_func();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id){
            case R.id.action_settings:
                Toast.makeText(this,"Setting",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(this,"About",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void network_func()
    {
        String url="http://shubham.scsc.co.in/searchstudent.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(A1.this,""+response,Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        )

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String, String>();
                params.put("roll",et_roll.getText().toString());
                //params.put("name",et_name.getText().toString());
                //params.put("phone",et_phone.getText().toString());
                //params.put("email",et_email.getText().toString());
                //params.put("password",et_password.getText().toString());
                return params;
            }
        };
        RequestQueue re=Volley.newRequestQueue(this);
        re.add(stringRequest);

    }
}
