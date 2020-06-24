package com.example.finalproject;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TabHost tabHost;
    private EditText editNameS,editUserS, editUserL,editPassS, editPassL,
            editPlate,editModel,editLocation;
    private Button btnSignup,btnLogin,btnAdd;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        editNameS = findViewById(R.id.editNameS);
        editUserL = findViewById(R.id.editUserL);
        editUserS = findViewById(R.id.editUserS);
        editPassL = findViewById(R.id.editPassL);
        editPassS = findViewById(R.id.editPassS);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec tabSpec;
        tabSpec = tabHost.newTabSpec("Screen_1");
        tabSpec.setContent(R.id.tabLogin);
        tabSpec.setIndicator("Login",null);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Screen_2");
        tabSpec.setContent(R.id.tabSignup);
        tabSpec.setIndicator("Signup",null);
        tabHost.addTab(tabSpec);
    }

    public void add(View view){
        boolean insert = databaseHelper.insertOfficer(editNameS.getText().toString(),
                editUserS.getText().toString(), editPassS.getText().toString());
        if(insert){
            Toast.makeText(MainActivity.this,"You are successfully registered!",Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void login(View view){
        boolean recordExists = databaseHelper.getAllData(editUserL.getText().toString(),
                editPassL.getText().toString());
        if(recordExists){
            Intent carIntent = new Intent(MainActivity.this,CarPark.class);
            startActivity(carIntent);
        }
        else {
            Toast.makeText(MainActivity.this, "Invalid username or password!",
                    Toast.LENGTH_LONG).show();
        }

    }




}
