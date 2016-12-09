package com.example.lulzerver.betterxander;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.textView2);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("Now my superiors are attempting to get me to say Hello World, but I will tell you one thing, click button 2 to see the secrets.");
            }

        });


    }

    /**
     * Turn light one and two off
     */
    public void turnLightOneOff(View view) {
        sendRequest("off");
    }

    public void turnLightTwoOff(View view) {
        sendRequest("off");
    }

    /**
     * Turn light one and two on
     */
    public void turnLightOneOn(View view) {
        sendRequest("on");
    }
    public void turnLightTwoOn(View view) {
        sendRequest("on");
    }


    public void sendRequest(String state)  {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://requestb.in/1876nlo1";

        //define json object
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("state", state);
        } catch (JSONException e) {
            System.out.println("YOU HAVE INCORRECT JSON");
        }

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });
// Add the request to the RequestQueue.
        queue.add(jsObjRequest);
    }


}
