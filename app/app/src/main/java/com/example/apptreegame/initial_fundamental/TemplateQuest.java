package com.example.apptreegame.initial_fundamental;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;


public class TemplateQuest extends AppCompatActivity {
    private QuestController currentController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_quest);
        View include = findViewById(R.id.quest);

        replaceInclude(R.layout.efi_quest_7, new Quest7());
    }

    public void replaceInclude(int newLayoutResId, QuestController controller) {
        View includeView = findViewById(R.id.quest);
        if (includeView != null) {
            ViewGroup parent = (ViewGroup) includeView.getParent();
            int index = parent.indexOfChild(includeView);
            parent.removeView(includeView);

            View newView = getLayoutInflater().inflate(newLayoutResId, parent, false);
            parent.addView(newView, index);

            currentController = controller;
            currentController.initialize(newView, this);
        }
    }
}