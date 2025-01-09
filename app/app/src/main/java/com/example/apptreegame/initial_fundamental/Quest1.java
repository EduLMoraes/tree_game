package com.example.apptreegame.initial_fundamental;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;

public class Quest1 implements QuestController {
    public static boolean isCorrect = false;
    float dX, dY = 0.0f;
    char[] order = {' ', ' ', ' ', ' ', ' ', ' '};

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        TextView text;
        ImageView img;
        TextView[] letters = {
                rootView.findViewById(R.id.a),
                rootView.findViewById(R.id.fruto),
                rootView.findViewById(R.id.tronco),
                rootView.findViewById(R.id.o),
                rootView.findViewById(R.id.r2),
                rootView.findViewById(R.id.folha)
        };

        for (TextView letter : letters)
            letter.setOnTouchListener((view, event) -> {
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


                        for (int i = 0; i < letters.length; i++){
                            if ( letter.getText().charAt(0) == 'Á' && letter.getX() < letters[i].getX()){
                                order[0] = letter.getText().charAt(0);
                            }else if ( letter.getText().charAt(0) == 'R' && letter.getX() < letters[2].getX() && letter.getX() > letters[0].getX()){
                                order[1] = letter.getText().charAt(0);
                            }else if ( letter.getText().charAt(0) == 'V' && letter.getX() < letters[3].getX() && letter.getX() > letters[0].getX() && letter.getX() > letters[1].getX() ){
                                order[2] = letter.getText().charAt(0);
                            }else if ( letter.getText().charAt(0) == 'O' && letter.getX() < letters[4].getX() && letter.getX() > letters[2].getX()){
                                order[3] = letter.getText().charAt(0);
                            }else if ( letter.getText().charAt(0) == 'R' && letter.getX() < letters[5].getX() && letter.getX() > letters[i].getX()){
                                order[4] = letter.getText().charAt(0);
                            }else if ( letter.getText().charAt(0) == 'E' && letter.getX() > letters[i].getX()){
                                order[5] = letter.getText().charAt(0);
                            }
                        }

                        break;

                    default:
                        return false;
                }

                if(valid_position()){
                    for (TextView letter2 : letters){
                        letter2.setOnTouchListener((v, e) -> { return true; });
                    }
                    root.replaceInclude(R.layout.efi_quest_2, new Quest2());
                }

                return true;
            });
    }

    private boolean valid_position(){
        return order[0] == 'Á'
                && order[1] == 'R'
                && order[2] == 'V'
                && order[3] == 'O'
                && order[4] == 'R'
                && order[5] == 'E';
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }
}
