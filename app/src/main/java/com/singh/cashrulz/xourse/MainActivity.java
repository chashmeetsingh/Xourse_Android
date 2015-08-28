package com.singh.cashrulz.xourse;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by cashrulz on 24/8/15.
 */
public class MainActivity extends AppCompatActivity {

    private ListView course_list;

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
                        String[] course_title_array = new String[response.length()] ;
                        for(int i=0;i<response.length();i++)
                            try {
                                course_json = response.getJSONObject(i);
                                Log.d("cash", String.valueOf(course_json));
                                course_title_array[i] = (course_json.getString(getString(R.string.title)));
                                Log.d("cash", String.valueOf(course_title_array[i]));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        Log.d("Cash",String.valueOf(course_title_array));


//                        course_list = (ListView) findViewById(course_list_view);
//
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                                MainActivity.this,
//                                android.R.layout.simple_list_item_1,
//                                course_title_array);
//
//                        Log.d("cash",String.valueOf(arrayAdapter));
//
//                        course_list.setAdapter(arrayAdapter);

                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

                        // 2. set layoutManger
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        // 3. create an adapter
                        MyAdapter mAdapter = new MyAdapter(course_title_array);
                        // 4. set adapter
                        recyclerView.setAdapter(mAdapter);
                        // 5. set item animator to DefaultAnimator
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
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
