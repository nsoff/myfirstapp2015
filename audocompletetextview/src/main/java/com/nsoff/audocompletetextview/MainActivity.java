package com.nsoff.audocompletetextview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;


public class MainActivity extends ActionBarActivity {

    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mauto;
    String[] books=new String[]{
            "china","america","canada","chile"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,books);
        actv=(AutoCompleteTextView)findViewById(R.id.auto);
        actv.setAdapter(aa);
//        mauto=(MultiAutoCompleteTextView)findViewById(R.id.mauto);
//        mauto.setAdapter(aa);
//        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
