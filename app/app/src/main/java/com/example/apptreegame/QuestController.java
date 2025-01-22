package com.example.apptreegame;

import android.view.View;

public interface QuestController {

//    void initialize(View rootView);
    void initialize(View rootView, TemplateQuest root);
    void onResume();
    void onPause();
}
