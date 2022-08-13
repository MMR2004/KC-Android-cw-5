package com.example.cw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();

        TextView nameText = findViewById(R.id.nametext);
        TextView ageText = findViewById(R.id.agetext);
        ImageView photo3 = findViewById(R.id.imageView);


        //Name
        String name2 = bundle.getString("item1");
        nameText.setText(name2);
        //Age
        String age2 = bundle.getString("item2");
        ageText.setText(age2);
        //photo
        int photo2 = bundle.getInt("item3");
        photo3.setImageResource(photo2);

        //Back Button
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackTruck = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(BackTruck);
            }
        });
    }
}
