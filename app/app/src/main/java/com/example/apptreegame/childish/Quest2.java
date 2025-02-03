package com.example.apptreegame.childish;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;
import com.example.apptreegame.TemplateQuest;

import java.util.Random;

public class Quest2 implements QuestController {


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        ImageView[] images = {
                rootView.findViewById(R.id.maca_ei_2),
                rootView.findViewById(R.id.folha_ei_2),
                rootView.findViewById(R.id.tronco_ei_2),
        };

        int tree_height = (int) rootView.findViewById(R.id.arvore_ei_2).getScaleX();

        for (ImageView img:
             images) {
            img.setScaleX(tree_height);
            img.setScaleY(tree_height);
        }

        images[0].setOnClickListener((v)->{
            root.replaceInclude(R.layout.ei_quest_3, new Quest3(), R.raw.questao_ei_3);
        });

    }

    public void onResume() {

    }

    public void onPause() {

    }
}
