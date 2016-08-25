package com.seladanghijau.sqliteexternaldbtest;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // views
    ListView lvDataList;

    // variables
    DBHelper dbHelper;
    Cursor cursor;
    ArrayList dataList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initVars();
    }

    private void initViews() {
        lvDataList = (ListView) findViewById(R.id.lvDataList);
    }

    private void initVars() {
        try {
            dbHelper = new DBHelper(this);
            dbHelper.createDataBase();
            cursor = dbHelper.getData();
            dataList = new ArrayList<String>();

            cursor.moveToFirst();
            for(int x=0 ; x<cursor.getCount() ; x++) {
                dataList.add(cursor.getString(1));
                cursor.moveToNext();
            }
        } catch (Exception e) { e.printStackTrace(); }

        // lvDataList.setAdapter(new ArrayAdapter<>(this, R.layout.layout_simple_lv, dataList));
    }
}
