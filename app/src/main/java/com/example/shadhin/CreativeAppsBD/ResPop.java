package com.example.shadhin.CreativeAppsBD;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Shadhin on 11/25/2015.
 */
public class ResPop extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultpopup);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        getWindow().setLayout((int)(width*.6),(int)(height*.3));
        TextView textView = (TextView)findViewById(R.id.textout);
        Intent intent = getIntent();
        String result = intent.getStringExtra("result_key");
        textView.setText(result);



        Button okButton = (Button) findViewById(R.id.dismiss);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        Button ohnoButton = (Button) findViewById(R.id.ohno_button);

        ohnoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ResPop.this, "There is no resone to Ohh No !! Press OK !", Toast.LENGTH_LONG).show();
            }
        });
    }

}
