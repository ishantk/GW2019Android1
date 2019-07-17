package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VoiceRecognitionActivity extends AppCompatActivity implements RecognitionListener {


    TextView txtVoiceData;
    Button btnSpeak;

    // API will be used to capture Speech and convert it to Text
    // SPEECH TO TEXT
    SpeechRecognizer speechRecognizer;

    TextToSpeech tts;
    boolean isTTSOk = true;

    void initViews(){
        txtVoiceData = findViewById(R.id.textViewData);
        btnSpeak = findViewById(R.id.buttonSpeak);

        // Initialization
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        // Set Listener
        speechRecognizer.setRecognitionListener(this);

        // Initialization of TTS
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.SUCCESS){
                    isTTSOk = false;
                    Toast.makeText(VoiceRecognitionActivity.this, "Please Enable Text to Speech Feature In Settings", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //RecognizerIntent will have a bundle which will contain textual data of our speech
                Intent intent = RecognizerIntent.getVoiceDetailsIntent(VoiceRecognitionActivity.this);
                speechRecognizer.startListening(intent);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_recognition);
        initViews();
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {

    }

    @Override
    public void onBeginningOfSpeech() {

    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(int i) {

    }

    @Override
    public void onResults(Bundle bundle) { // bundle contains data which we have said as voice in the form of text

        ArrayList<String> data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

        if(data!=null && data.size()>0) {
            String closestSaidText = data.get(0);
            txtVoiceData.setText(closestSaidText);

            if(closestSaidText.toLowerCase().contains("hello")){
                String response = "Hello, Its Good to hear from You !";

                if(isTTSOk) {
                    //tts.speak(response, TextToSpeech.QUEUE_FLUSH, null);
                    tts.speak(response, TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }

        }else{
            txtVoiceData.setText("Please Say Again !!");
        }

    }

    @Override
    public void onPartialResults(Bundle bundle) {

    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }
}
