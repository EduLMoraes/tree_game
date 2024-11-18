package com.example.apptreegame;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class QuestPuzzles extends AppCompatActivity {

    private float dX, dY;
    private boolean top;
    private boolean mid;
    private boolean bottom;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_move_peaces);

        ImageView[] peaces = {
                findViewById(R.id.peaces),
                findViewById(R.id.peaces2),
                findViewById(R.id.peaces3),
                findViewById(R.id.peaces4),
                findViewById(R.id.peaces5),
                findViewById(R.id.peaces6)
        };

        Random rand = new Random();
        for (ImageView peace: peaces) {
            peace.setX(rand.nextFloat() * 200f);
            peace.setY(rand.nextFloat() * 200f);
        }

        top = false;
        mid = false;
        bottom = false;

        for (int i = 0; i < peaces.length; i++) {
            int j = i;
            peaces[i].setOnTouchListener((view, event) -> {
                if(!top && "peace1".equals((String) peaces[j].getTag())){
                    if(
                            ((int) peaces[0].getY() - peaces[1].getY()  >= 20 && (int) peaces[0].getY() - peaces[1].getY() <= 30)
                            &&
                            ((int) peaces[1].getX() - peaces[0].getX()  >= 130 && (int) peaces[1].getX() - peaces[0].getX() <= 136)
                    ){
                        top = true;
                    }
                    if( (int) peaces[0].getX() == (int) peaces[2].getX() ){
                        System.out.println("Metade esquerda feita");
                    }
                }else if(!top && "peace2".equals((String) peaces[j].getTag())){
                    if(
                            ((int) peaces[0].getY() - peaces[1].getY()  >= 20 && (int) peaces[0].getY() - peaces[1].getY() <= 30)
                                    &&
                                    ((int) peaces[1].getX() - peaces[0].getX()  >= 130 && (int) peaces[1].getX() - peaces[0].getX() <= 136)
                    ){
                        top = true;
                    }
                    if( (int) peaces[0].getX() == (int) peaces[2].getX() ){
                        System.out.println("Metade esquerda feita");
                    }
                }
                if(!mid && "peace3".equals((String) peaces[j].getTag())){
                    if(
                            ((int) peaces[3].getY() - peaces[2].getY()  >= 0 && (int) peaces[2].getY() - peaces[3].getY() <= 5)
                                    &&
                                    ((int) peaces[3].getX() - peaces[2].getX()  >= 116 && (int) peaces[3].getX() - peaces[2].getX() <= 126)
                    ){
                        mid = true;
                    }
                    if( (int) peaces[0].getX() == (int) peaces[2].getX() ){
                        System.out.println("Metade esquerda feita");
                    }
                }else if(!mid && "peace4".equals((String) peaces[j].getTag())){
                    System.out.println("pX " + ((int) peaces[1].getX() - peaces[0].getX()));
                    System.out.println("p1Y: " + peaces[0].getY() % 6 + " p2Y: " + peaces[1].getY() % 6);
                    if(
                            ((int) peaces[0].getY() - peaces[1].getY()  >= 20 && (int) peaces[0].getY() - peaces[1].getY() <= 30)
                                    &&
                                    ((int) peaces[1].getX() - peaces[0].getX()  >= 130 && (int) peaces[1].getX() - peaces[0].getX() <= 136)
                    ){
                        top = true;
                    }
                    if( (int) peaces[0].getX() == (int) peaces[2].getX() ){
                        System.out.println("Metade esquerda feita");
                    }
                }
                if(!bottom && "peace5".equals((String) peaces[j].getTag())){
                    System.out.print("pX " + ((int) peaces[4].getX() - peaces[5].getX()));
                    System.out.println(" pY " + ((int) peaces[4].getY() - peaces[5].getY()));
                    if(
                            ((int) peaces[5].getY() - peaces[4].getY()  >= 20 && (int) peaces[5].getY() - peaces[4].getY() <= 26)
                                    &&
                                    ((int) peaces[5].getX() - peaces[4].getX()  >= 120 && (int) peaces[5].getX() - peaces[4].getX() <= 136)
                    ){
                        bottom = true;
                    }
                    if( (int) peaces[0].getX() == (int) peaces[2].getX() ){
                        System.out.println("Metade esquerda feita");
                    }
                }else if(!bottom && "peace6".equals((String) peaces[j].getTag())){
                    if(
                            ((int) peaces[5].getY() - peaces[4].getY()  >= 20 && (int) peaces[5].getY() - peaces[4].getY() <= 26)
                                    &&
                                    ((int) peaces[5].getX() - peaces[4].getX()  >= 120 && (int) peaces[5].getX() - peaces[4].getX() <= 136)
                    ){
                        bottom = true;
                    }
                    if( (int) peaces[0].getX() == (int) peaces[2].getX() ){
                        System.out.println("Metade esquerda feita");
                    }
                }
                    switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        if(top && ("peace1".equals((String) view.getTag()))){
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
                        }else if(top && ("peace2".equals((String) view.getTag()))){
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
                        }else if(mid && ("peace3".equals((String) view.getTag()))){
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
                        }else if(mid && ("peace4".equals((String) view.getTag()))){
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
                        }else if(bottom && ("peace5".equals((String) view.getTag()))){
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
                        }else if(bottom && ("peace6".equals((String) view.getTag()))){
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
                        }else {
                            view.animate()
                                    .x(event.getRawX() + dX)
                                    .y(event.getRawY() + dY)
                                    .setDuration(0)
                                    .start();
                        }
                        break;

                    default:
                        return false;
                }


                return true;
            });
        }
    }
}
