package com.example.apptreegame.initial_fundamental;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;

import java.util.Random;

public class Quest8 implements QuestController {
    float dX, dY = 0.0f;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        ImageView tree = rootView.findViewById(R.id.treeMovel);
        ImageView posi = rootView.findViewById(R.id.theCorrect);

        tree.setOnTouchListener((v, e) -> {
            switch (e.getAction()){
                case MotionEvent.ACTION_DOWN:
                    dX = v.getX() - e.getRawX();
                    dY = v.getY() - e.getRawY();
                    break;

                case MotionEvent.ACTION_MOVE:
                    v.animate()
                        .x(e.getRawX() + dX)
                        .y(e.getRawY() + dY)
                        .setDuration(0)
                        .start();
                    break;
                default:
                        break;
            }

            System.out.println(posi.getX() + " " + " " + tree.getX() +" " + posi.getY() + " " + " " + tree.getY());
            if((int) Math.abs(posi.getX() - tree.getX()) <= 10 && (int) Math.abs(posi.getY() - tree.getY()) <= 10){
                tree.setOnTouchListener((vi, ev) -> true);
                tree.setX(posi.getX());
                tree.setY(posi.getY());
                root.replaceInclude(R.layout.efi_quest_9, new Quest9());
            }
            return true;
        });
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }
}
