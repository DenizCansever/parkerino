package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CarPark extends Activity {
    private TextView park1,park2,park3,park4,park5,park6,park7,park8;
    private ListView mylist;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listItems = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpark);
        park1 = findViewById(R.id.park1);
        park2 = findViewById(R.id.park2);
        park3 = findViewById(R.id.park3);
        park4 = findViewById(R.id.park4);
        park5 = findViewById(R.id.park5);
        park6 = findViewById(R.id.park6);
        park7 = findViewById(R.id.park7);
        park8 = findViewById(R.id.park8);
        mylist = findViewById(R.id.mylist);
        listItems = new ArrayList<String>();
        listItems.add("Area 1: ");
        listItems.add("Area 2: ");
        listItems.add("Area 3: ");
        listItems.add("Area 4: ");
        listItems.add("Area 5: ");
        listItems.add("Area 6: ");
        listItems.add("Area 7: ");
        listItems.add("Area 8: ");
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItems);
        mylist.setAdapter(adapter);
    }


    public void fillArea(View v){

        String p1 = park1.getText().toString().substring(0,6);
        String p2 = park2.getText().toString().substring(0,6);
        String p3 = park3.getText().toString().substring(0,6);
        String p4 = park4.getText().toString().substring(0,6);
        String p5 = park5.getText().toString().substring(0,6);
        String p6 = park6.getText().toString().substring(0,6);
        String p7 = park7.getText().toString().substring(0,6);
        String p8 = park8.getText().toString().substring(0,6);

        int i1 = R.id.park1;
        int i2 = R.id.park2;
        int i3 = R.id.park3;
        int i4 = R.id.park4;
        int i5 = R.id.park5;
        int i6 = R.id.park6;
        int i7 = R.id.park7;
        int i8 = R.id.park8;

        switch (v.getId()) {
            case R.id.park1:
                listItems.set(0,"Area 1 is Full!");
                mylist.setAdapter(adapter);
                Intent intent1 = new Intent(CarPark.this,CarActivity.class);
                Bundle myBundle1 = new Bundle();
                myBundle1.putString("park", p1);
                myBundle1.putInt("id",i1);
                intent1.putExtras(myBundle1);
                startActivity(intent1);
                break;
            case R.id.park2:
                listItems.set(1,"Area 2 is Full!");
                mylist.setAdapter(adapter);
                Intent intent2 = new Intent(CarPark.this,CarActivity.class);
                Bundle myBundle2 = new Bundle();
                myBundle2.putString("park", p2);
                myBundle2.putInt("id",i2);
                intent2.putExtras(myBundle2);
                startActivity(intent2);
                break;
            case R.id.park3:
                listItems.set(2,"Area 3 is Full!");
                mylist.setAdapter(adapter);
                Intent intent3 = new Intent(CarPark.this,CarActivity.class);
                Bundle myBundle3 = new Bundle();
                myBundle3.putString("park", p3);
                myBundle3.putInt("id",i3);
                intent3.putExtras(myBundle3);
                startActivity(intent3);
                break;
            case R.id.park4:
                listItems.set(3,"Area 4 is Full!");
                mylist.setAdapter(adapter);
                Intent intent4 = new Intent(CarPark.this,CarActivity.class);
                Bundle myBundle4 = new Bundle();
                myBundle4.putString("park", p4);
                myBundle4.putInt("id",i4);
                intent4.putExtras(myBundle4);
                startActivity(intent4);
                break;
            case R.id.park5:
                listItems.set(4,"Area 5 is Full!");
                mylist.setAdapter(adapter);
                Intent intent5 = new Intent(CarPark.this,CarActivity.class);
                Bundle myBundle5 = new Bundle();
                myBundle5.putString("park", p5);
                myBundle5.putInt("id",i5);
                intent5.putExtras(myBundle5);
                startActivity(intent5);
                break;
            case R.id.park6:
                listItems.set(5,"Area 6 is Full!");
                mylist.setAdapter(adapter);
                Intent intent6 = new Intent(CarPark.this,CarActivity.class);
                Bundle myBundle6 = new Bundle();
                myBundle6.putString("park", p6);
                myBundle6.putInt("id",i6);
                intent6.putExtras(myBundle6);
                startActivity(intent6);
                break;
            case R.id.park7:
                listItems.set(6,"Area 7 is Full!");
                mylist.setAdapter(adapter);
                Intent intent7 = new Intent(CarPark.this,CarActivity.class);
                Bundle myBundle7 = new Bundle();
                myBundle7.putString("park", p7);
                myBundle7.putInt("id",i7);
                intent7.putExtras(myBundle7);
                startActivity(intent7);
                break;
            case R.id.park8:
                listItems.set(7,"Area 8 is Full!");
                mylist.setAdapter(adapter);
                Intent intent8 = new Intent(CarPark.this,CarActivity.class);
                Bundle myBundle8 = new Bundle();
                myBundle8.putString("park", p8);
                myBundle8.putInt("id",i8);
                intent8.putExtras(myBundle8);
                startActivity(intent8);
                break;
        }
    }
}
