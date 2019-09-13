package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pantry extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        button1 = (Button) findViewById(R.id.btn_menu);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });
        button2 = (Button) findViewById(R.id.btn_ShoppingList);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShoppingList();
            }
        });
    }

    public void openMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openShoppingList() {
        Intent intent = new Intent(this, shoppinglist.class);
        startActivity(intent);
    }
}