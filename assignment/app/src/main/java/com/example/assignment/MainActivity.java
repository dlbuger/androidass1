package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button button1, button2, buttonAdd;
    private static final String TAG = "MainActivity";
    private EditText EditText_name, EditText_price, EditText_quantity;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDatabaseHelper = new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText_name = (EditText) findViewById(R.id.ProductName);
        EditText_price = (EditText) findViewById(R.id.Price);
        EditText_quantity = (EditText) findViewById(R.id.Quantity);


        button1 = (Button) findViewById(R.id.btn_ShoppingList);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShoppingList();
            }
        });
        button2 = (Button) findViewById(R.id.btn_Pantry);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPantry();
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String newEntry = EditText.getText().toString();
                if (EditText_name.length() != 0) {
                    AddData(newEntry);
                    EditText_name.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }
            }
        });
    }

    public void openShoppingList() {
        Intent intent = new Intent(this, shoppinglist.class);
        startActivity(intent);
    }

    public void openPantry() {
        Intent intent = new Intent(this, pantry.class);
        startActivity(intent);
    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}