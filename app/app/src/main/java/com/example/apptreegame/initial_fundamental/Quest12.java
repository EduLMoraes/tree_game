package com.example.apptreegame.initial_fundamental;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;
import com.example.apptreegame.TemplateQuest;

public class Quest12 implements QuestController {
    float dX = 0.0f;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        ImageView[] img = {
                rootView.findViewById(R.id.coco),
                rootView.findViewById(R.id.limao),
                rootView.findViewById(R.id.abacate),
                rootView.findViewById(R.id.uva)
        };

        ImageView[] r = {
                rootView.findViewById(R.id.r1),
                rootView.findViewById(R.id.r2),
                rootView.findViewById(R.id.r3),
                rootView.findViewById(R.id.r4)
        };

        boolean[] p = {false, false, false, false};

        for(int i = 0; i< img.length; i++){
            int finalI = i;
            img[i].setOnTouchListener((v, e) -> {
                switch (e.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        dX = v.getX() - e.getRawX();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        v.animate()
                                .x(e.getRawX() + dX)
                                .setDuration(0)
                                .start();

                        if(img[finalI].getX() >= r[finalI].getX() && img[finalI].getX() + img[finalI].getWidth() <= r[finalI].getX() + r[finalI].getWidth()){
                            img[finalI].setOnTouchListener((_v, _e) -> true);
                            p[finalI] = true;

                            for (boolean ps:
                                 p) {
                                if(!ps){
                                    return true;
                                }
                            }

                            root.replaceInclude(R.layout.efi_quest_1, new Quest1(), R.raw.questao_efi_1);
                        }
                        break;
                    default:
                        break;
                }

                return true;
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
