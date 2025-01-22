package com.example.apptreegame;

import static androidx.appcompat.content.res.AppCompatResources.getDrawable;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class QuestActivity implements QuestController{

    @Override
    public void initialize(View rootView, TemplateQuest root) {
        TextView quest;
        quest = rootView.findViewById(R.id.nQuest);
        quest.setText("1");

        quest = rootView.findViewById(R.id.questText);
        quest.setText("Os seres vivos podem desempenhar diferentes papéis nos ambientes onde vivem. Os animais que se alimentam de plantas são chamados de herbívoros e os carnívoros usam os herbívoros como alimento. Dois animais de espécies diferentes que se alimentam da mesma planta possuem o(a) mesmo(a): ");

        ImageView image = rootView.findViewById(R.id.questImage);
        image.setBackground(getDrawable(root, R.drawable.finais_questao3));

        Button optionA = rootView.findViewById(R.id.optionResponseA);
        Button optionB = rootView.findViewById(R.id.optionResponseB);
        Button optionC = rootView.findViewById(R.id.optionResponseC);
        Button optionD = rootView.findViewById(R.id.optionResponseD);
        Button[] options = {optionA, optionB, optionC, optionD};
        char response = 'A';

        for(int i = 0; i<options.length; i++){
            options[i].setOnClickListener(new View.OnClickListener(){
                                              @Override
                                              public void onClick(View view) {
                                                  LinearLayout backgroundOptions = rootView.findViewById(R.id.optionsLayout);
                                                  boolean isCorrect = false;

                                                  for(int j = 0; j<options.length; j++){
                                                      options[j].setEnabled(false);
                                                      if (options[j].isPressed() && options[j].getText().charAt(0) != response){
                                                          options[j].setBackgroundColor(Color.rgb(255, 0, 0));
                                                          backgroundOptions.setBackgroundColor(Color.rgb(255, 0, 0));
                                                      }else if(!options[j].isPressed() && options[j].getText().charAt(0) == response){
                                                          options[j].setBackgroundColor(Color.rgb(0, 255, 0));
                                                      }else if(options[j].isPressed() && options[j].getText().charAt(0) == response){
                                                          options[j].setBackgroundColor(Color.rgb(0, 255, 0));
                                                          backgroundOptions.setBackgroundColor(Color.rgb(0, 255, 0));
                                                          isCorrect = true;
                                                      }else{
                                                          options[j].setVisibility(View.INVISIBLE);
                                                          options[j].setEnabled(false);
                                                      }
                                                  }
                                                  if (isCorrect){
                                                      System.out.println("is ok");
                                                  }
                                              }
                                          }
            );
        }

        optionA.setText("A) "+"Hábitat");
        optionB.setText("B) "+"Nicho Ecológico");
        optionC.setText("C) "+"População");
        optionD.setText("D) "+"Sociedade");
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }
}

