package com.dhanrajataware.analizo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class ResultClass extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_class);

            imageView = findViewById(R.id.imageViewEmoji);
            textView = findViewById(R.id.textViewResult);

            String sentiment = getIntent().getStringExtra("sentiment");
            textView.setText("Sentiment:" + sentiment);

            displayEmoji(sentiment);
    }

    private void displayEmoji(String sentiment) {
        String gifUrl;
        switch (sentiment.toLowerCase()){
            case "positive":
                gifUrl = "https://tenor.com/blOOV.gif";
                break;

            case "negative":
                gifUrl = "https://tenor.com/bh4xu.gif";
                break;

            case "neutral":
                gifUrl = "https://tenor.com/bAgYj.gif";
                break;

            default:
                gifUrl = "https://tenor.com/bniIt.gif";
        }
        Glide.with(this)
                .load(gifUrl)
                .into(imageView);
    }
}