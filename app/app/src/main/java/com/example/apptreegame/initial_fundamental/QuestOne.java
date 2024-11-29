package com.example.apptreegame.initial_fundamental;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;

import java.util.Random;

public class QuestOne implements QuestController {
    public static boolean isCorrect = false;
    float dX, dY = 0.0f;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView) {
        TextView text;
        ImageView img;
        TextView[] letters = {
                rootView.findViewById(R.id.a),
                rootView.findViewById(R.id.r),
                rootView.findViewById(R.id.v),
                rootView.findViewById(R.id.o),
                rootView.findViewById(R.id.r2),
                rootView.findViewById(R.id.e)
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
                        break;

                    default:
                        return false;
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
