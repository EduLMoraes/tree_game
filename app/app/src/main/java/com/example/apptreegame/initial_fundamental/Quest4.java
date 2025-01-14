package com.example.apptreegame.initial_fundamental;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;

import java.util.Random;

public class Quest4 implements QuestController {

    private float dX, dY;
    private boolean[] Correct = {
        false, false, false, false,
        false, false, false, false,
        false, false, false, false
    };

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        ImageView[] peaces = {
                root.findViewById(R.id.peaces),
                root.findViewById(R.id.peaces2),
                root.findViewById(R.id.peaces3),
                root.findViewById(R.id.peaces4),
                root.findViewById(R.id.peaces5),
                root.findViewById(R.id.peaces6),
                root.findViewById(R.id.peaces7),
                root.findViewById(R.id.peaces8),
                root.findViewById(R.id.peaces9),
                root.findViewById(R.id.peaces10),
                root.findViewById(R.id.peaces11),
                root.findViewById(R.id.peaces12),
        };

        ImageView[] shadows = {
                root.findViewById(R.id.sombra1),
                root.findViewById(R.id.sombra2),
                root.findViewById(R.id.sombra3),
                root.findViewById(R.id.sombra4),
                root.findViewById(R.id.sombra5),
                root.findViewById(R.id.sombra6),
                root.findViewById(R.id.sombra7),
                root.findViewById(R.id.sombra8),
                root.findViewById(R.id.sombra9),
                root.findViewById(R.id.sombra10),
                root.findViewById(R.id.sombra11),
                root.findViewById(R.id.sombra12),
        };

        Random rand = new Random();
        for (ImageView peace: peaces) {
            peace.setX(rand.nextInt(250));
            peace.setY(rand.nextInt(200));
        }

//        peaces[3].setScaleX(peaces[2].getScaleX() + 0.2f);
//        peaces[3].setScaleY(peaces[2].getScaleY() + 0.2f);
//
        for (int i = 0; i < peaces.length; i++) {
            peaces[i].setOnTouchListener((view, event) -> {
                for (int k = 0; k< peaces.length; k++){
                    if (
                        ((int) Math.abs(peaces[k].getX() - shadows[k].getX())  >= 0 && (int) Math.abs(peaces[k].getX() - shadows[k].getX())  <= 10)
                            &&
                        ((int) Math.abs(peaces[k].getY() - shadows[k].getY())  >= 0 && (int) Math.abs(peaces[k].getY() - shadows[k].getY())  <= 10)
                    ){
                        peaces[k].setOnTouchListener((v, e) -> { return true; });
                        
                        peaces[k].setX(shadows[k].getX());
                        peaces[k].setY(shadows[k].getY());

                        Correct[k] = true;
                    }

                    if(isCorrect()){
                        root.replaceInclude(R.layout.efi_quest_5, new Quest5());
                    };
                }

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();

                        
                        break;

                    case MotionEvent.ACTION_MOVE:

                        
                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;

                    default:
                        return false;
                }
                return true;
            });
        }
    }

    private boolean isCorrect(){
        for(boolean pos: Correct){
            if (!pos){
                return false;
            }
        }
        return true;
    }

    public void onResume() {

    }

    public void onPause() {

    }
}
