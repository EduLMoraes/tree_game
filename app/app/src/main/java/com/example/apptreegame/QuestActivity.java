package com.example.apptreegame;

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


public class QuestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        TextView quest;
        quest = findViewById(R.id.nQuest);
        quest.setText("1");

        quest = findViewById(R.id.questText);
        quest.setText("Os seres vivos podem desempenhar diferentes papéis nos ambientes onde vivem. Os animais que se alimentam de plantas são chamados de herbívoros e os carnívoros usam os herbívoros como alimento. Dois animais de espécies diferentes que se alimentam da mesma planta possuem o(a) mesmo(a): ");

        ImageView image = findViewById(R.id.questImage);
        image.setBackground(getDrawable(R.drawable.finais_questao3));

        Button optionA = findViewById(R.id.optionResponseA);
        Button optionB = findViewById(R.id.optionResponseB);
        Button optionC = findViewById(R.id.optionResponseC);
        Button optionD = findViewById(R.id.optionResponseD);
        Button[] options = {optionA, optionB, optionC, optionD};
        char response = 'A';

        for(int i = 0; i<options.length; i++){
            options[i].setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        LinearLayout backgroundOptions = findViewById(R.id.optionsLayout);
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
                            Intent intent = new Intent(QuestActivity.this, CodeActivity.class);
                            startActivity(intent);
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
}

