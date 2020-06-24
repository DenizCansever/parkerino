package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CarActivity extends Activity {
    private EditText editPlate,editModel,editLocation;
    private Button btnAdd;
    private DatabaseHelper2 databaseHelper2;
    Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcar);
        databaseHelper2 = new DatabaseHelper2(this);


        editPlate = findViewById(R.id.editPlate);
        editModel = findViewById(R.id.editModel);
        btnAdd = findViewById(R.id.btnAdd);


    }

    public void addCar(View v){
        Intent myIntent = getIntent();
        Bundle myBundle = myIntent.getExtras();

        String p1 = myBundle.getString("park");
        int i1 = myBundle.getInt("id");


        boolean insert = databaseHelper2.insertCar(editPlate.getText().toString(),
                editModel.getText().toString());
        if(insert){
            Toast.makeText(CarActivity.this, editPlate.getText().toString() + " is entered to " + p1 + "."
                    ,Toast.LENGTH_LONG)
                    .show();

            finish();

        }
    }
}
