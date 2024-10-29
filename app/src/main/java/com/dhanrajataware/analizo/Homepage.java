package com.dhanrajataware.analizo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Homepage extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);

    }

    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        Bundle extras = getIntent().getExtras();
        String V1 = extras.getString(Intent.EXTRA_TEXT);
        Log.d("NumberMainActivity", V1);
    }

    public void text(View view){
        Intent i = new Intent(getApplicationContext(),text.class);
        startActivity(i);
    }

    public void image(View view){
        Intent i = new Intent(getApplicationContext(),image.class);
        startActivity(i);
    }

    public void develper(View view){
        Intent i = new Intent(getApplicationContext(),developer.class);
        startActivity(i);
    }

    public void audio(View view){
        Intent i = new Intent(getApplicationContext(),audio.class);
        startActivity(i);
    }

    public void logout(View view){
        Intent i = new Intent(getApplicationContext(),login.class);
        startActivity(i);
    }

}