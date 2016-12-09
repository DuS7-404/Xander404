package com.example.lulzerver.betterxander;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
        sendRequest("light1", "off");
    }

    public void turnLightTwoOff(View view) {
        sendRequest("light2", "off");
    }

    /**
     * Turn light one and two on
     */
    public void turnLightOneOn(View view) {
        sendRequest("light1", "on");
    }

    public void turnLightTwoOn(View view) {
        sendRequest("light2", "on");
    }


    public void sendRequest(final String light, final String state) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://ec2-54-164-53-99.compute-1.amazonaws.com:6543";

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put(light, state);

                return params;
            }
        };
        queue.add(postRequest);
    }


}
