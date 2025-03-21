package com.example.apptreegame.childish;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;
import com.example.apptreegame.TemplateQuest;
import com.example.apptreegame.initial_fundamental.Quest8;

public class Quest7 implements QuestController {
    int countErrors = 0;

    @Override
    public void initialize(View rootView, TemplateQuest root) {
        TextView[] errors = {
                rootView.findViewById(R.id.error01),
                rootView.findViewById(R.id.error02),
                rootView.findViewById(R.id.error03),
                rootView.findViewById(R.id.error04),
        };

        for(TextView e: errors){
            e.setTextColor(Color.TRANSPARENT);
            e.setOnClickListener((v) -> {
                e.setTextColor(Color.RED);
                e.setOnClickListener((_v) -> {});
                countErrors += 1;
                System.out.println(countErrors);
                if(countErrors >= 4){
                    root.replaceInclude(R.layout.ei_quest_8, new Quest8(), R.raw.questao_ei_8);
                }
            });
        }
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }
}
