package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView view;

    RequestQueue mQueue;
    //Fact fact=new Fact();
    Handler handler = new Handler();
    ProgressDialog progressDialog;
    Button button;

    // List<Fact> mlist=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        view = (TextView) findViewById(R.id.textView);
        mQueue = Volley.newRequestQueue(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new loadFact().start();


            }
        });

    }

    public class loadFact extends Thread {
        // Log.d("Miiii",fact.getmFact());
        @Override
        public void run() {

            handler.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setMessage("Fetching data.....");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                }
            });
            String JSON_URL = "https://catfact.ninja/fact";
            JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                    new Response.Listener<JSONObject>() {


                        @Override
                        public void onResponse(JSONObject response) {

                            try {
                                String a = response.getString("fact");
                                view.setText(a);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            mQueue.add(stringRequest);


            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (progressDialog.isShowing()){
                        progressDialog.dismiss();
                       //notify();
                    }
                }
            });

        }


    }

}
