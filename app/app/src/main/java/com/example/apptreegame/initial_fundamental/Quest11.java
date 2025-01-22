package com.example.apptreegame.initial_fundamental;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;
import com.example.apptreegame.TemplateQuest;

public class Quest11 implements QuestController {
    float dX, dY = 0.0f;
    boolean[] order = {
            false, false, false
    };
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        ImageView[] rectangles = {
                rootView.findViewById(R.id.r1),
                rootView.findViewById(R.id.a2),
                rootView.findViewById(R.id.a3),
        };
        TextView[] words = {
                rootView.findViewById(R.id.ta1),
                rootView.findViewById(R.id.ta2),
                rootView.findViewById(R.id.ta3),
        };

        for (int i = 0; i < words.length; i++){
            int finalI = i;
            words[i].setOnTouchListener((view, event) -> {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        if(!order[finalI]){
                            view.animate()
                                    .x(event.getRawX() + dX)
                                    .y(event.getRawY() + dY)
                                    .setDuration(0)
                                    .start();

                            int wix = (int) words[finalI].getX();
                            int wiy = (int) words[finalI].getY();

                            int rix = (int) rectangles[finalI].getX();
                            int riy = (int) rectangles[finalI].getY();

                            int wlx = (int) wix + words[finalI].getWidth();
                            int wly = (int) wiy + words[finalI].getHeight();

                            int rlx = (int) rix + rectangles[finalI].getWidth();
                            int rly = (int) riy + rectangles[finalI].getHeight();

                            order[finalI] = (wlx < rlx && wix > rix) && (wly < rly && wiy > riy);
                        }else
                            words[finalI].setOnTouchListener((v, e) -> true);

                        break;

                    default:
                        return false;
                }

                if (valid_position()) {
//                    rootView.findViewById(R.id.quest).setBackgroundColor(Color.rgb(50, 255, 50));

                    root.replaceInclude(R.layout.efi_quest_12, new Quest12(), R.raw.questao_efi_12);
                }
                return true;
            });
        }
    }

    private boolean valid_position(){
        for (boolean pos: order ) {
            if (!pos)
                return false;
        }
        return true;
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }
}
