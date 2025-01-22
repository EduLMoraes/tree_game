package com.example.apptreegame;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.media.MediaPlayer;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class TemplateQuest extends AppCompatActivity {
    private QuestController currentController;
    public static int COUNTQUEST = 0;
    private MediaPlayer mediaPlayer;
    private LevelSchooling levelShooling = LevelSchooling.childish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_template_quest);

        if (this.levelShooling == LevelSchooling.childish)
            replaceInclude(R.layout.ei_quest_2, new com.example.apptreegame.childish.Quest2(), R.raw.questao_ei_2);
        else if(this.levelShooling == LevelSchooling.initial_fundamental)
            replaceInclude(R.layout.efi_quest_1, new com.example.apptreegame.initial_fundamental.Quest1(), R.raw.questao_efi_1);
        else if(this.levelShooling == LevelSchooling.other)
            replaceInclude(R.layout.quests_medio, new com.example.apptreegame.QuestActivity());

    }

    public static void sumCount(){
        COUNTQUEST++;
    }

    public void replaceInclude(int newLayoutResId, QuestController controller, int mp) {

        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }

        mediaPlayer = MediaPlayer.create(this, mp);
        mediaPlayer.start();

        this.replaceInclude(newLayoutResId, controller);
    }

    public void replaceInclude(int newLayoutResId, QuestController controller) {
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

            currentController = controller;
            currentController.initialize(newView, this);
        }
    }
}