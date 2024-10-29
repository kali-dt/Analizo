package com.dhanrajataware.analizo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

public class text extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private StanfordCoreNLP pipeline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_text);

        editText = findViewById(R.id.editTextInput);
        button = findViewById(R.id.buttonAnalyze);

        Properties props = new Properties();
        props.setProperty("annotators","tokenize,ssplit,pos,lemma,ner,sentiment");
        props.setProperty("outputformat","json");
        pipeline = new StanfordCoreNLP(props);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = editText.getText().toString().trim();
                String Sentiment = analyzeSentiment(text);
                Intent intent = new Intent(text.this,Resultclass.class);
                startActivity(intent);
            }
        });

    }

    private String analyzeSentiment(String text) {
        edu.stanford.nlp.pipeline.Annotation annotation = new edu.stanford.nlp.pipeline.Annotation();
        pipeline.annotate(annotation);

        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        StringBuilder result = new StringBuilder();

        for (CoreMap sentence : sentences){
            String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
            result.append(sentiment).append("");
        }
        return result.toString().trim();
    }
}