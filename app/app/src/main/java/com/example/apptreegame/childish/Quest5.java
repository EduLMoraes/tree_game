package com.example.apptreegame.childish;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;
import com.example.apptreegame.TemplateQuest;

import java.util.Random;

public class Quest5 implements QuestController {
    private float dX, dY;
    private int fruits = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        ImageView[] abacates = {
                rootView.findViewById(R.id.abacate_ei),
                rootView.findViewById(R.id.abacate_ei3),
                rootView.findViewById(R.id.abacate_ei4),
        };

        ImageView[] apples = {
                rootView.findViewById(R.id.apple),
                rootView.findViewById(R.id.apple2),
                rootView.findViewById(R.id.apple3),
        };

        ImageView[] oranges = {
                rootView.findViewById(R.id.orange),
                rootView.findViewById(R.id.orange2),
                rootView.findViewById(R.id.orange3),
        };

        ImageView[] cestas = {
                rootView.findViewById(R.id.cesta_abacate),
                rootView.findViewById(R.id.cesta_apple),
                rootView.findViewById(R.id.cesta_orange),
        };

        for (ImageView fruit : abacates){
            fruit.setOnTouchListener((view, event) -> {
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

                        float cx = cestas[0].getX();
                        float cy = cestas[0].getY();
                        float ecx = cx + cestas[0].getWidth();
                        float ecy = cy + cestas[0].getHeight();

                        if (view.getX() > cx && view.getY() > cy && view.getX() < ecx && view.getY() < ecy) {
                            view.setVisibility(View.INVISIBLE);
                            view.setOnTouchListener((v, e) -> true);
                            fruits += 1;
                            if(fruits >= 9){
                                root.replaceInclude(R.layout.ei_quest_1, new Quest1(), R.raw.questao_ei_1);
                            }
                        }
                        break;
                    default:
                        return false;
                }
                return true;
            });
        }

        for (ImageView fruit : oranges){
            fruit.setOnTouchListener((view, event) -> {
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

                        float cx = cestas[2].getX();
                        float cy = cestas[2].getY();
                        float ecx = cx + cestas[2].getWidth();
                        float ecy = cy + cestas[2].getHeight();

                        if (view.getX() > cx && view.getY() > cy && view.getX() < ecx && view.getY() < ecy) {
                            view.setVisibility(View.INVISIBLE);
                            view.setOnTouchListener((v, e) -> true);
                            fruits++;
                            if(fruits >= 9){
                                root.replaceInclude(R.layout.ei_quest_1, new Quest1(), R.raw.questao_ei_1);
                            }
                        }
                        break;
                    default:
                        return false;
                }
                return true;
            });
        }

        for (ImageView fruit : apples){
            fruit.setOnTouchListener((view, event) -> {
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

                        float cx = cestas[1].getX();
                        float cy = cestas[1].getY();
                        float ecx = cx + cestas[1].getWidth();
                        float ecy = cy + cestas[1].getHeight();

                        if (view.getX() > cx && view.getY() > cy && view.getX() < ecx && view.getY() < ecy) {
                            view.setVisibility(View.INVISIBLE);
                            view.setOnTouchListener((v, e) -> true);
                            fruits++;
                            if(fruits >= 9){
                                root.replaceInclude(R.layout.ei_quest_6, new Quest6(), R.raw.questao_ei_6);
                            }
                        }
                        break;
                    default:
                        return false;
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
