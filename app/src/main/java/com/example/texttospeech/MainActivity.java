package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Locale;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button buttontext,buttonclear;
    TextToSpeech textToSpeech;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.Text);
        buttontext=findViewById(R.id.btnText);
        buttonclear=findViewById(R.id.btnclear);
        img= (GifImageView)findViewById(R.id.imageView);

        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
        buttontext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
                         img.setImageResource(R.drawable.mimic);

                } else
                    textToSpeech.speak(text.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
                ((GifDrawable)img.getDrawable()).stop();
            }
        });
    }
}