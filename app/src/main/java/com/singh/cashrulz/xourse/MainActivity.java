package com.singh.cashrulz.xourse;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cashrulz on 24/8/15.
 */
public class MainActivity extends AppCompatActivity {
    
    ArrayList<String> course_title = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest networkRequest = new JsonArrayRequest(Request.Method.GET, "http://xourse.herokuapp.com/api/courses",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject course_json;
                        Log.d("cash",String.valueOf(response.length()));
                        for(int i=0;i<response.length();i++) {
                            try {
                                course_json = response.getJSONObject(i);
                                Log.d("cash", String.valueOf(course_json));
                                course_title.add(course_json.getString("course_name"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }Log.d("Cash",String.valueOf(course_title));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("cash", String.valueOf(error));
                    }
                }) {};

        requestQueue.add(networkRequest);

    }
}
