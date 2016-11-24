package com.example.shadhin.CreativeAppsBD;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    private String text1;
    private String text2;
    private String st;
    public String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


   /// public void calculate(View view){


    //}
public  void result(View view){


    EditText txt1 = (EditText)findViewById(R.id.text1);
    EditText txt2 = (EditText)findViewById(R.id.text2);
    text1 = txt1.getText().toString();
    text2 = txt2.getText().toString();
    st = text1 + text2;
    st = st.toLowerCase();
    int l = st.length();
    for(int k = 0; k<l; k++){
        for(int i=0; i<l; i++){
            for(int j=0; j<l-1; j++){
                if(i == j) continue;
                else if(st.charAt(i) == st.charAt(j)){
                    char[] chars = st.toCharArray();
                    chars[j] = st.charAt(j+1);
                    st = new String(chars);
                }
            }
        }
    }
    int sum = 0;
    for(int i=0; i<l; i++){
        sum += st.charAt(i);
    }
    int ret = sum % 101;
    String out = Integer.toString(ret);
    text = ""+text1+" has "+out+" % love for "+text2+"";
    //text += out;
    //Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
    Intent intent = new Intent(MainActivity.this,ResPop.class);
    intent.putExtra("result_key",text);
    startActivity(intent);

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.developer) {
            startActivity(new Intent(MainActivity.this,Pop.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
