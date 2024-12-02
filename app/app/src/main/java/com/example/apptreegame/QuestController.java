package com.example.apptreegame;

import android.view.View;

import com.example.apptreegame.initial_fundamental.TemplateQuest;

public interface QuestController {
//    void initialize(View rootView);
    void initialize(View rootView, TemplateQuest root);
    void onResume();
    void onPause();
}
