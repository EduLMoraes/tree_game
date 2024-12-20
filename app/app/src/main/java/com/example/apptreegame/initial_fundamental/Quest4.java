package com.example.apptreegame.initial_fundamental;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;

import java.util.Random;

public class Quest4 implements QuestController {

    private float dX, dY;
    private boolean top, mid, mlt, mlb, mrt, mrb, bottom = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        ImageView[] peaces = {
                rootView.findViewById(R.id.peaces),
                rootView.findViewById(R.id.peaces2),
                rootView.findViewById(R.id.peaces3),
                rootView.findViewById(R.id.peaces4),
                rootView.findViewById(R.id.peaces5),
                rootView.findViewById(R.id.peaces6)
        };

        Random rand = new Random();
        for (ImageView peace: peaces) {
            peace.setX(rand.nextInt(350));
            peace.setY(rand.nextInt(400));
        }

        peaces[3].setScaleX(peaces[2].getScaleX() + 0.2f);
        peaces[3].setScaleY(peaces[2].getScaleY() + 0.2f);

        for (int i = 0; i < peaces.length; i++) {
            int j = i;
            peaces[i].setOnTouchListener((view, event) -> {
                if(!top){
                    if(
                            ((int) Math.abs(peaces[0].getY() - peaces[1].getY())  >= 20 && (int) Math.abs(peaces[0].getY() - peaces[1].getY()) <= 30)
                                    &&
                                    ((int) Math.abs(peaces[1].getX() - peaces[0].getX())  >= 130 && (int) Math.abs(peaces[1].getX() - peaces[0].getX()) <= 136)
                    ){
                        top = true;
                    }
                }
                if(!mid){
                    if(
                            ((int) Math.abs(peaces[3].getY() - peaces[2].getY())  >= 0 && (int) Math.abs(peaces[2].getY() - peaces[3].getY()) <= 5)
                                    &&
                                    ((int) Math.abs(peaces[3].getX() - peaces[2].getX())  >= 116 && (int) Math.abs(peaces[3].getX() - peaces[2].getX()) <= 126)
                    ){
                        mid = true;
                    }
                }
                if(!bottom){
                    if(
                            ((int) Math.abs(peaces[5].getY() - peaces[4].getY())  >= 20 && (int) Math.abs(peaces[5].getY() - peaces[4].getY()) <= 26)
                                    &&
                                    ((int) Math.abs(peaces[5].getX() - peaces[4].getX())  >= 120 && (int) Math.abs(peaces[5].getX() - peaces[4].getX()) <= 136)
                    ){
                        bottom = true;
                    }
                }
                if((!mlt || !mlb)){
                    if( ("peace1".equals((String) peaces[j].getTag()) || "peace3".equals((String) peaces[j].getTag())) &&
                            ((int) Math.abs(peaces[0].getX() - peaces[2].getX())  >= 20 && (int) Math.abs(peaces[0].getX() - peaces[2].getX()) <= 30)
                            &&
                            ((int) Math.abs(peaces[0].getY() - peaces[2].getY())  >= 130 && (int) Math.abs(peaces[0].getY() - peaces[2].getY()) <= 136)
                    ){
                        mlt = true;
                    }
                    if( ("peace3".equals((String) peaces[j].getTag()) || "peace5".equals((String) peaces[j].getTag())) &&
                            ((int) Math.abs(peaces[4].getX() - peaces[2].getX())  >= 20 && (int) Math.abs(peaces[4].getX() - peaces[2].getX()) <= 30)
                            &&
                            ((int) Math.abs(peaces[4].getY() - peaces[2].getY())  >= 130 && (int) Math.abs(peaces[4].getY() - peaces[2].getY()) <= 136)
                    ){
                        mlb = true;
                    }
                }
                if((!mrt || !mrb)){
                    if(
                            ((int) Math.abs(peaces[1].getX() - peaces[3].getX())  >= 20 && (int) Math.abs(peaces[1].getX() - peaces[3].getX()) <= 30)
                                    &&
                                    ((int) Math.abs(peaces[1].getY() - peaces[3].getY())  >= 150 && (int) Math.abs(peaces[1].getY() - peaces[3].getY()) <= 156)
                    ){
                        mrt = true;
                    }
                    if(
                            ((int) Math.abs(peaces[3].getX() - peaces[5].getX())  >= 20 && (int) Math.abs(peaces[3].getX() - peaces[5].getX()) <= 30)
                                    &&
                                    ((int) Math.abs(peaces[3].getY() - peaces[5].getY())  >= 150 && (int) Math.abs(peaces[3].getY() - peaces[5].getY()) <= 156)
                    ){
                        mrb = true;
                    }
                }


                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        if(mrb && mrt && mlt && mlb && top && mid && bottom){
                            if(
                                    ((int) Math.abs(peaces[0].getY() - peaces[1].getY())  >= 20 && (int) Math.abs(peaces[0].getY() - peaces[1].getY()) <= 30)
                                            &&
                                            ((int) Math.abs(peaces[2].getY() - peaces[3].getY())  >= 0 && (int) Math.abs(peaces[2].getY() - peaces[3].getY()) <= 5)
                                            &&
                                            ((int) Math.abs(peaces[4].getY() - peaces[5].getY())  >= 20 && (int) Math.abs(peaces[4].getY() - peaces[5].getY()) <= 26)

                                            &&

                                            ((int) Math.abs(peaces[1].getX() - peaces[0].getX())  >= 130 && (int) Math.abs(peaces[1].getX() - peaces[0].getX()) <= 136)
                                            &&
                                            ((int) Math.abs(peaces[2].getX() - peaces[3].getX())  >= 116 && (int) Math.abs(peaces[2].getX() - peaces[3].getX()) <= 126)
                                            &&
                                            ((int) Math.abs(peaces[4].getX() - peaces[5].getX())  >= 130 && (int) Math.abs(peaces[4].getX() - peaces[5].getX()) <= 136)
                            ){
                                System.out.println("Quebra-cabeça feito!");

                                for (ImageView peace : peaces) {
                                    peace.setOnTouchListener((view2, event2) -> {
                                        return false;
                                    });
                                }
                            }
                        }

                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();

                        if(top){
                            if ("peace1".equals((String) view.getTag())){
                                peaces[0].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();

                                peaces[1].animate()
                                        .x(event.getRawX() + dX + 133)
                                        .y(event.getRawY() + dY - 24)
                                        .setDuration(0)
                                        .start();
                            }
                            else if("peace2".equals((String) view.getTag())){
                                peaces[0].animate()
                                        .x(event.getRawX() + dX - 133)
                                        .y(event.getRawY() + dY + 24)
                                        .setDuration(0)
                                        .start();

                                peaces[1].animate()
                                        .x(event.getRawX() + dX )
                                        .y(event.getRawY() + dY )
                                        .setDuration(0)
                                        .start();
                            }
                        }
                        if(mid){
                            if("peace3".equals((String) view.getTag())){
                                peaces[2].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();

                                peaces[3].animate()
                                        .x(event.getRawX() + dX + 122)
                                        .y(event.getRawY() + dY - 1)
                                        .setDuration(0)
                                        .start();
                            }
                            else if("peace4".equals((String) view.getTag())){
                                peaces[2].animate()
                                        .x(event.getRawX() + dX - 122)
                                        .y(event.getRawY() + dY + 1)
                                        .setDuration(0)
                                        .start();

                                peaces[3].animate()
                                        .x(event.getRawX() + dX )
                                        .y(event.getRawY() + dY )
                                        .setDuration(0)
                                        .start();
                            }

                        }
                        if(bottom){
                            if ("peace5".equals((String) view.getTag())){
                                peaces[4].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();

                                peaces[5].animate()
                                        .x(event.getRawX() + dX + 124)
                                        .y(event.getRawY() + dY + 24)
                                        .setDuration(0)
                                        .start();
                            }
                            else if("peace6".equals((String) view.getTag())){
                                peaces[4].animate()
                                        .x(event.getRawX() + dX - 124)
                                        .y(event.getRawY() + dY - 24)
                                        .setDuration(0)
                                        .start();

                                peaces[5].animate()
                                        .x(event.getRawX() + dX )
                                        .y(event.getRawY() + dY )
                                        .setDuration(0)
                                        .start();
                            }
                        }
                        if(mlt && !mlb){
                            if("peace1".equals((String) view.getTag())){
                                peaces[0].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();

                                peaces[2].animate()
                                        .x(event.getRawX() + dX + 22)
                                        .y(event.getRawY() + dY + 130)
                                        .setDuration(0)
                                        .start();
                            }
                            else if("peace3".equals((String) view.getTag())){
                                peaces[0].animate()
                                        .x(event.getRawX() + dX - 22)
                                        .y(event.getRawY() + dY - 130)
                                        .setDuration(0)
                                        .start();

                                peaces[2].animate()
                                        .x(event.getRawX() + dX )
                                        .y(event.getRawY() + dY )
                                        .setDuration(0)
                                        .start();
                            }
                        }
                        if(mlb && !mlt){
                            if("peace3".equals((String) view.getTag())){
                                peaces[2].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();

                                peaces[4].animate()
                                        .x(event.getRawX() + dX - 22)
                                        .y(event.getRawY() + dY + 130)
                                        .setDuration(0)
                                        .start();
                            }
                            else if("peace5".equals((String) view.getTag())){
                                peaces[2].animate()
                                        .x(event.getRawX() + dX + 22)
                                        .y(event.getRawY() + dY - 130)
                                        .setDuration(0)
                                        .start();

                                peaces[4].animate()
                                        .x(event.getRawX() + dX )
                                        .y(event.getRawY() + dY )
                                        .setDuration(0)
                                        .start();
                            }
                        }
                        if(mrt && !mrb){
                            if("peace2".equals((String) view.getTag())){
                                peaces[1].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();

                                peaces[3].animate()
                                        .x(event.getRawX() + dX + 22)
                                        .y(event.getRawY() + dY + 155)
                                        .setDuration(0)
                                        .start();
                            }
                            else if("peace4".equals((String) view.getTag())){
                                peaces[1].animate()
                                        .x(event.getRawX() + dX - 22)
                                        .y(event.getRawY() + dY - 155)
                                        .setDuration(0)
                                        .start();

                                peaces[3].animate()
                                        .x(event.getRawX() + dX )
                                        .y(event.getRawY() + dY )
                                        .setDuration(0)
                                        .start();
                            }
                        }
                        if(mrb && !mrt){
                            if("peace4".equals((String) view.getTag())){
                                peaces[3].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();

                                peaces[5].animate()
                                        .x(event.getRawX() + dX - 22)
                                        .y(event.getRawY() + dY + 155)
                                        .setDuration(0)
                                        .start();
                            }
                            else if("peace6".equals((String) view.getTag())){
                                peaces[3].animate()
                                        .x(event.getRawX() + dX + 22)
                                        .y(event.getRawY() + dY - 155)
                                        .setDuration(0)
                                        .start();

                                peaces[5].animate()
                                        .x(event.getRawX() + dX )
                                        .y(event.getRawY() + dY )
                                        .setDuration(0)
                                        .start();
                            }
                        }
                        if(mlt && mlb){
                            if("peace1".equals((String) view.getTag())){
                                peaces[0].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();

                                peaces[2].animate()
                                        .x(event.getRawX() + dX + 22)
                                        .y(event.getRawY() + dY + 130)
                                        .setDuration(0)
                                        .start();

                                peaces[4].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY + 260)
                                        .setDuration(0)
                                        .start();
                            }
                            else if("peace3".equals((String) view.getTag())){
                                peaces[0].animate()
                                        .x(event.getRawX() + dX - 22)
                                        .y(event.getRawY() + dY - 130)
                                        .setDuration(0)
                                        .start();

                                peaces[2].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();

                                peaces[4].animate()
                                        .x(event.getRawX() + dX - 22)
                                        .y(event.getRawY() + dY + 130)
                                        .setDuration(0)
                                        .start();
                            }
                            else if("peace5".equals((String) view.getTag())){
                                peaces[0].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY - 260)
                                        .setDuration(0)
                                        .start();

                                peaces[2].animate()
                                        .x(event.getRawX() + dX + 22)
                                        .y(event.getRawY() + dY - 130)
                                        .setDuration(0)
                                        .start();

                                peaces[4].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();
                            }
                        }
                        if(mrt && mrb){
                            if("peace2".equals((String) view.getTag())){
                                peaces[1].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();

                                peaces[3].animate()
                                        .x(event.getRawX() + dX + 22)
                                        .y(event.getRawY() + dY + 155)
                                        .setDuration(0)
                                        .start();

                                peaces[5].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY + 310)
                                        .setDuration(0)
                                        .start();
                            }
                            else if("peace4".equals((String) view.getTag())){
                                peaces[1].animate()
                                        .x(event.getRawX() + dX - 22)
                                        .y(event.getRawY() + dY - 155)
                                        .setDuration(0)
                                        .start();

                                peaces[3].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();

                                peaces[5].animate()
                                        .x(event.getRawX() + dX - 22)
                                        .y(event.getRawY() + dY + 155)
                                        .setDuration(0)
                                        .start();
                            }
                            else if("peace6".equals((String) view.getTag())){
                                peaces[1].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY - 310)
                                        .setDuration(0)
                                        .start();

                                peaces[3].animate()
                                        .x(event.getRawX() + dX + 22)
                                        .y(event.getRawY() + dY - 155)
                                        .setDuration(0)
                                        .start();

                                peaces[5].animate()
                                        .x(event.getRawX() + dX)
                                        .y(event.getRawY() + dY)
                                        .setDuration(0)
                                        .start();
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

    public void onResume() {

    }

    public void onPause() {

    }
}
