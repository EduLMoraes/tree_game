package com.example.apptreegame.childish;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;
import com.example.apptreegame.TemplateQuest;

public class Quest6 implements QuestController {
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        Button btn = rootView.findViewById(R.id.button3);

        btn.setOnClickListener(v -> {
            root.replaceInclude(R.layout.ei_quest_1, new Quest1(), R.raw.questao_ei_1);
        });

    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }
}
