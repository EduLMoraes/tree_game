package com.example.apptreegame.initial_fundamental;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;
import com.example.apptreegame.TemplateQuest;

import java.util.Random;

public class Quest3 implements QuestController {
    private boolean isCorrect = true;
    private Random rand =  new Random();
    private int clicks = 0;
    private int[] positions = {
        1, 1,
        2, 2,
        3, 3,
        4, 4,
        5, 5
    };
    private int[] opens = {
        201, 200
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

        System.out.println(figs[0].getBackground() + " X " + figs[1].getBackground());

        for (int i = 0; i < figs.length; i++){
            int num = rand.nextInt(200);
            num = num % figs.length;
            if (num == i){
                if (i > 0){
                    i--;
                }
            }else{
                swapFig(figs[i], figs[num]);
                swapPosition(i, num);
            }
        }

        Drawable[] fruits = new Drawable[10];
        for(int i = 0; i< fruits.length; i++){
            fruits[i] = figs[i].getBackground();
        }

        to_hide(figs, root);

        for (int i = 0; i< figs.length; i++){
            int finalI = i;
            figs[i].setOnClickListener((v) -> {
                if(lastClick != finalI){
                    opens[clicks%2] = positions[finalI];
                    v.setBackground(fruits[finalI]);

                    if(opens[0] == opens[1]){
                        v.setVisibility(View.INVISIBLE);
                        figs[lastClick].setVisibility(View.INVISIBLE);
                    }

                    clicks++;
                    if(clicks > 2){
                        to_hide(figs, root);
                    }else{
                        lastClick = finalI;
                    }
                }

                if(isFinish(figs)){
                    root.replaceInclude(R.layout.efi_quest_4, new Quest4(), R.raw.questao_efi_4);
                }

            });
        }
    }

    private void swapFig(ImageView fig1, ImageView fig2){
        Drawable temp = fig1.getBackground();
        fig1.setBackground(fig2.getBackground());
        fig2.setBackground(temp);
    }

    private void swapPosition(int p1, int p2){
        int temp = positions[p1];
        positions[p1] = positions[p2];
        positions[p2] = temp;
    }

    private boolean isFinish(ImageView[] figs){
        for (ImageView fig2: figs) {
            if(fig2.getVisibility() == View.VISIBLE){
                return false;
            }
        }

        return true;
    }

    private void to_hide(ImageView[] figs, TemplateQuest root){
        for(ImageView fig: figs){
            fig.setBackground(root.findViewById(R.id.verso).getBackground());
        }
        clicks = 0;
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }
}
