package com.example.cw5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    EditText name;
    EditText age;
    Button nextpage;
    Button BSelectImage;
    ImageView IVPreviewImage;
    int SELECT_PICTURE = 200;

    private static final Pattern NAME_PATTERN = Pattern
            .compile("[a-zA-Z0-9]{1,250}");
    private static final Pattern AGE_PATTERN = Pattern
            .compile("[a-zA-Z0-9+_.]{4,16}");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.NameEditText);
        age = findViewById(R.id.AgeEditText);
        nextpage = findViewById(R.id.NextPage);
//        ImageView Image1 = findViewById(R.id.profile);



            nextpage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final String Name3 = name.getText().toString();
                    final String Age3 = age.getText().toString() ;
                    if(Name3.equals("") || Age3.equals("")){
                        if (TextUtils.isEmpty(name.getText())) {
                        name.setError("Name is required!");}
                        if(TextUtils.isEmpty(age.getText())){
                            age.setError("Age is required!");
                        }
//                         if (Name3.equals("")) {
//                             Toast.makeText(MainActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
//                        }
//                         if (Age3.equals("")){
//                             Toast.makeText(MainActivity.this, "Enter Age", Toast.LENGTH_SHORT).show();
//                         }

                    } else{
                        Intent nextintent = new Intent(MainActivity.this, MainActivity2.class);
                        nextintent.putExtra("item1", Name3);
                        nextintent.putExtra("item2", Age3);
                        startActivity(nextintent);
                    }
                }
            });



        BSelectImage = findViewById(R.id.changeprofilebutton);
        IVPreviewImage = findViewById(R.id.profile);


        BSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
    }


    void imageChooser() {

        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);


        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {


            if (requestCode == SELECT_PICTURE) {

                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {

                    IVPreviewImage.setImageURI(selectedImageUri);
                    Intent profilephoto = new Intent(MainActivity.this, MainActivity2.class);
                }
            }
        }
    }
    private boolean Checkname(String name){
        return NAME_PATTERN.matcher(name).matches();
    }
    private boolean CheckAge(String age){
        return AGE_PATTERN.matcher(age).matches();

    }}