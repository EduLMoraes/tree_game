package com.example.apptreegame;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CodeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceData){
        super.onCreate(savedInstanceData);
        EdgeToEdge.enable(this);
        setContentView(R.layout.code_insert);

        Drawable[] simbols = {
                getDrawable(R.drawable.circulo),
                getDrawable(R.drawable.cruz),
                getDrawable(R.drawable.quadrado),
                getDrawable(R.drawable.triangulo),
                getDrawable(R.drawable.estrela)
        };

        switchSimbol(findViewById(R.id.up1), findViewById(R.id.down1), findViewById(R.id.i1), simbols);
        switchSimbol(findViewById(R.id.up2), findViewById(R.id.down2), findViewById(R.id.i2), simbols);
        switchSimbol(findViewById(R.id.up3), findViewById(R.id.down3), findViewById(R.id.i3), simbols);
    }

    private void switchSimbol(Button up, Button down, ImageView simbol, Drawable[] simbols){
        simbol.setBackground(simbols[0]);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i< simbols.length; i++) {
                    if(simbol.getBackground() == simbols[i]){
                        try {
                            simbol.setBackground(simbols[i+1]);
                        }catch (ArrayIndexOutOfBoundsException err){
                            simbol.setBackground(simbols[0]);
                        }
                        break;
                    }
                }
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = simbols.length - 1; i >= 0; i--) {
                    if(simbol.getBackground() == simbols[i]){
                        try {
                            simbol.setBackground(simbols[i-1]);
                        }catch (ArrayIndexOutOfBoundsException err){
                            simbol.setBackground(simbols[simbols.length - 1]);
                        }
                        break;
                    }
                }
            }
        });

    }
}
