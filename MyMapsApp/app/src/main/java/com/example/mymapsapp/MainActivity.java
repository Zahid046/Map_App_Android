package com.example.mymapsapp;
//Projects in Series 3:
//1. Access CSV in an Android Studio Project
//2. Access SQLite in an Android Studio Project
//3. Access WebView in an Android Studio Project
//4. Access NFC in an Android Studio Project
//5. Access Maps in an Android Studio Project


//androidx.appcompat.app.AppCompatActivity and android.os.Bundle are put in by default when basic
//activity selected when new project is created in Android Studio. All of the other imports were
//put in manually later during the making of the project.
//START
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
//END
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Creating Java equivalent objects for the widget in our activity main user interface which we created
    //in xml that we want to interact with (change) or give values to in some way.
    //START
    private Button btnReadMap;
    //END

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect our java objects to the appropriate widget in our user interface
        //START
        btnReadMap = findViewById(R.id.btnReadMap);
        //FINISH

        //This is setting the instructions of what to do when the button "Read Map" is pressed. When
        //we put "this" inside the brackets it is telling the system to use the main onClick method
        //for the onClickListener for this button. You only have one onClick that is not nested ie
        //the onClick is inside the setOnClickListener.
        //START
        btnReadMap.setOnClickListener(this);
        //FINISH
    }

    //When our user clicks on the Read Map button our app will launch our Maps Activity.
    public void onClick(View v){
        Intent intent = new Intent(v.getContext(), MapsActivity.class);
        startActivity(intent);
    }

}