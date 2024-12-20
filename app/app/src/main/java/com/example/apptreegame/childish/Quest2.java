package com.example.apptreegame.childish;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;

public class Quest2 implements QuestController {
    public static boolean isCorrect = false;
    float dX, dY = 0.0f;
    boolean[] order = {false, false, false};

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

                        System.out.print(" " + (words[2].getY() - words[2].getHeight()));
                        System.out.print(" x " + rectangles[0].getHeight());
                        System.out.print(" " + (rectangles[0].getY() - rectangles[0].getHeight()) + "\n");

                        // folha
                        if (((int) words[0].getX() > (int) rectangles[1].getX() && words[0].getX() < (rectangles[1].getWidth() - rectangles[1].getX()))
                                && ((int) words[0].getY() > (int) rectangles[1].getHeight() && words[0].getY() < (rectangles[1].getY()))){
                            order[0] = true;
                            System.out.println('a');
                        }else{
                            order[0] = false;
                        }

                        // tronco
                        if (((int) words[1].getX() > (int) rectangles[2].getX() && words[1].getX() < (rectangles[2].getWidth() - rectangles[2].getX()))
                                && ((int) (words[1].getY() - words[1].getHeight()) > (int) rectangles[2].getHeight() && (words[1].getY() - words[1].getHeight()) < (rectangles[2].getY() - rectangles[2].getHeight()))){
                            order[1] = true;
                            System.out.println('b');
                        }else{
                            order[1] = false;
                        }

                        // fruto
                        if (((int) words[2].getX() > (int) rectangles[0].getX() && words[2].getX() < (rectangles[0].getWidth() - rectangles[0].getX()))
                            && ((int) words[2].getY() < (int) (rectangles[0].getHeight() - 50) && words[2].getY() > 0f)){
                            order[2] = true;
                            System.out.println('c');
                        }else {
                            order[2] = false;
                        }



                        break;

                    default:
                        return false;
                }

                if(valid_position()){
                    for (TextView letter2 : words){
                        letter2.setOnTouchListener((v, e) -> { return true; });
                    }
                    rootView.findViewById(R.id.quest).setBackgroundColor(Color.rgb(50, 255, 50));

                    root.replaceInclude(R.layout.efi_quest_3, new Quest3());
                }
                return true;
            });
    }

    private boolean valid_position(){
        return order[0]
                && order[1]
                && order[2];
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }
}
