package com.nsoff.arraylisttest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list1 = (ListView) findViewById(R.id.list1);
        // ??????
        String[] arr1 = { "圭", "基本原则", "顶戴要基本原则基本原则" };
        // ?????ArrayAdapter
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (this, R.layout.array_item, arr1);
        // ?ListView??Adapter
        list1.setAdapter(adapter1);
        ListView list2 = (ListView) findViewById(R.id.list2);
        // ??????
        String[] arr2 = { "Java", "Hibernate", "Spring" , "Android" };
        // ?????ArrayAdapter
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (this, R.layout.checked_item, arr2);
        // ?ListView??Adapter
        list2.setAdapter(adapter2);
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
