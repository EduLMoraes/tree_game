package com.example.apptreegame;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class QuestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.quests_medio);

        TextView quest;
        quest = findViewById(R.id.nQuest);
        quest.setText("1");

        quest = findViewById(R.id.questText);
        quest.setText("Os seres vivos podem desempenhar diferentes papéis nos ambientes onde vivem. Os animais que se alimentam de plantas são chamados de herbívoros e os carnívoros usam os herbívoros como alimento. Dois animais de espécies diferentes que se alimentam da mesma planta possuem o(a) mesmo(a): ");

        ImageView image = findViewById(R.id.questImage);
        image.setBackground(getDrawable(R.drawable.questao3));

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
                        for(int j = 0; j<options.length; j++){
                            if (options[j].isPressed() && options[j].getText().charAt(0) != response){
                                options[j].setBackgroundColor(Color.rgb(255, 0, 0));
                                backgroundOptions.setBackgroundColor(Color.rgb(255, 0, 0));
                            }else if(!options[j].isPressed() && options[j].getText().charAt(0) == response){
                                options[j].setBackgroundColor(Color.rgb(0, 255, 0));
                            }else if(options[j].isPressed() && options[j].getText().charAt(0) == response){
                                options[j].setBackgroundColor(Color.rgb(0, 255, 0));
                                backgroundOptions.setBackgroundColor(Color.rgb(0, 255, 0));
                            }else{
                                options[j].setVisibility(View.INVISIBLE);
                                options[j].setEnabled(false);
                            }
                        }
                    }
                }
            );
        }

        optionA.setText("A) "+"Hábitat");
        optionB.setText("B) "+"Nicho Ecológico");
        optionC.setText("C) "+"População");
        optionD.setText("D) "+"Sociedade");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quests_medio), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
