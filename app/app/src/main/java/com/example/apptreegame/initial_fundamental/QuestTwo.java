package com.example.apptreegame.initial_fundamental;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.apptreegame.initial_fundamental.TemplateQuest;
import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;

public class QuestTwo implements QuestController {
    public static boolean isCorrect = false;
    float dX, dY = 0.0f;
    char[] order = {' ', ' ', ' '};

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        TextView text;
        ImageView[] rectangles = {
                rootView.findViewById(R.id.rectangle3),
                rootView.findViewById(R.id.rectangle2),
                rootView.findViewById(R.id.rectangle)
        };
        TextView[] words = {
                rootView.findViewById(R.id.folha),
                rootView.findViewById(R.id.tronco),
                rootView.findViewById(R.id.fruto)
        };

        for (TextView word : words)
            word.setOnTouchListener((view, event) -> {
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

                        if (((int) words[0].getX() > (int) rectangles[1].getX() && words[0].getX() < (rectangles[1].getWidth() - rectangles[1].getX()))
                                && ((int) words[0].getY() > (int) rectangles[1].getHeight() && words[0].getY() < (rectangles[1].getY()))){
                            System.out.println("Folha no lugar certo!");
                        }
                        if (((int) words[1].getX() > (int) rectangles[2].getX() && words[1].getX() < (rectangles[2].getWidth() - rectangles[2].getX()))
                                && ((int) words[1].getY() > (int) rectangles[2].getHeight() && words[1].getY() < (rectangles[2].getY()))){
                            System.out.println("Tronco no lugar certo!");
                        }
                        if (((int) words[2].getX() > (int) rectangles[0].getX() && words[2].getX() < (rectangles[0].getWidth() - rectangles[0].getX()))
                            && ((int) words[2].getY() < (int) (rectangles[0].getHeight() - 50) && words[2].getY() > 0f)){
                            System.out.println("Fruto no lugar certo!");
                        }

                        if(valid_position()){
                            for (TextView letter2 : words){
                                letter2.setOnTouchListener((v, e) -> { return true; });
                            }
                            rootView.findViewById(R.id.layout).setBackgroundColor(Color.rgb(50, 255, 50));
//                            root.questComplete(R.id.);
                        }

                        break;

                    default:
                        return false;
                }

                return true;
            });
    }

    private boolean valid_position(){
        return order[0] == 'Á'
                && order[1] == 'R'
                && order[2] == 'V';
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }
}
