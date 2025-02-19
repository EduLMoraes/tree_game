package com.example.apptreegame.childish;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;
import com.example.apptreegame.TemplateQuest;

import java.util.Random;

public class Quest4 implements QuestController {
    private boolean isCorrect = true;
    private Random rand =  new Random();
    private int clicks = 0;
    private String[] opens = {
        "", " "
    };
    private int lastClick = 200;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        ImageView[] figs = {
                rootView.findViewById(R.id.fig1),
                rootView.findViewById(R.id.fig2),
                rootView.findViewById(R.id.fig3),
                rootView.findViewById(R.id.fig4),
                rootView.findViewById(R.id.fig5),
                rootView.findViewById(R.id.fig6),
                rootView.findViewById(R.id.fig7),
                rootView.findViewById(R.id.fig8),
                rootView.findViewById(R.id.fig9),
                rootView.findViewById(R.id.fig10)
        };

        for (int i = 0; i < figs.length; i+=2){
            int num = rand.nextInt(200);
            num = num % figs.length;
            if (num == i){
                if (i > 0){
                    i--;
                }
            }else{
                swapFig(figs[i], figs[num]);
                swapTag(figs[i], figs[num]);
            }
        }

        String[] fruits = new String[10];

        for(int i = 0; i< fruits.length; i++){
            fruits[i] = figs[i].getTag().toString();
        }

        for (int i = 0; i< figs.length; i++){
            int finalI = i;
            figs[i].setOnClickListener((v) -> {
                if(lastClick != finalI){
                    opens[clicks%2] = fruits[finalI];

                    System.out.println(opens[0] + " " + opens[1] + " click " + clicks%2);

                    if(opens[0] == opens[1]){
                        v.setVisibility(View.INVISIBLE);
                        figs[lastClick].setVisibility(View.INVISIBLE);
                    }

                    clicks++;
                    lastClick = finalI;
                }

                if(isFinish(figs)){
                    root.replaceInclude(R.layout.ei_quest_5, new Quest5(), R.raw.questao_ei_5);
                }

            });
        }
    }

    private void swapTag(ImageView fig1, ImageView fig2){
        Object temp = fig1.getTag();
        fig1.setTag(fig2.getTag());
        fig2.setTag(temp);
    }

    private void swapFig(ImageView fig1, ImageView fig2){
        Drawable temp = fig1.getBackground();
        fig1.setBackground(fig2.getBackground());
        fig2.setBackground(temp);
    }

    private boolean isFinish(ImageView[] figs){
        for (ImageView fig2: figs) {
            if(fig2.getVisibility() == View.VISIBLE){
                return false;
            }
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
