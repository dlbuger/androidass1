package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }

    public void openShoppingList() {
        Intent intent = new Intent(this, shoppinglist.class);
        startActivity(intent);
    }

    public void openPantry() {
        Intent intent = new Intent(this, pantry.class);
        startActivity(intent);
    }
}