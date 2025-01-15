package com.example.apptreegame.initial_fundamental;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;


public class TemplateQuest extends AppCompatActivity {
    private QuestController currentController;
    public static int COUNTQUEST = 6;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_quest);

        replaceInclude(R.layout.efi_quest_1, new Quest1(), R.raw.questao_efi_1);
    }

    public static void sumCount(){
        COUNTQUEST++;
    }

    public void replaceInclude(int newLayoutResId, QuestController controller, int mp) {
        View includeView = findViewById(R.id.quest);

        if (includeView != null) {
            ViewGroup parent = (ViewGroup) includeView.getParent();
            int index = parent.indexOfChild(includeView);
            parent.removeView(includeView);

            View newView = getLayoutInflater().inflate(newLayoutResId, parent, false);
            parent.addView(newView, index);

            TextView a = findViewById(R.id.nQuest);
            sumCount();
            a.setText("" + COUNTQUEST);

            if(mediaPlayer != null && mediaPlayer.isPlaying()){
               mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(this, mp);
            mediaPlayer.start();

            currentController = controller;
            currentController.initialize(newView, this);
        }
    }
}