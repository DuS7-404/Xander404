package com.example.lulzerver.betterxander;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    txt=(TextView) findViewById(R.id.textView2);
    btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
         @Override
            public void onClick(View v){
             txt.setText("Now my superiors are attempting to get me to say Hello World, but I will tell you one thing, click button 2 to see the secrets.");
         }

        });


    }


public void trig2(){
    txt=(TextView)findViewById(R.id.textView2);
    btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener(){
@Override
                public void onClick(View v){
                txt.setText("Now are you really ready for the secret ? If so press the 3rd and final button.");
            }
        });



}
    public void onCreate(){
        txt=(TextView)findViewById(R.id.textView2);
        btn=(Button)findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener(){
@Override
            public void onClick(View v){
                txt.setText("No Mans Sky was a dissappointment soley due to the fact that it was not multiplayer.");
            }
        });
    }
}
