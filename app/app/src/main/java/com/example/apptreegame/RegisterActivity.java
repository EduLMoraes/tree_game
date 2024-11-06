package com.example.apptreegame;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.register);

        ChipGroup chipgroup = findViewById(R.id.chipGroups);
        for(int i=0; i < chipgroup.getChildCount(); i++){
            Chip option = (Chip) chipgroup.getChildAt(i);
            option.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    switchChoice(option.getId());
                }
            });
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    protected void switchChoice(int checked){
        ChipGroup chipgroup = findViewById(R.id.chipGroups);

        for(int i=0; i < chipgroup.getChildCount(); i++){
            Chip option = (Chip) chipgroup.getChildAt(i);
            if(option.getId() != checked){
                option.setChecked(false);
                System.out.println("Desmarcando......: " + option.getId());
            }else{
                System.out.println("esse foi o escolhido, não dá pra desmarcar");
            }
        }
    }

}

