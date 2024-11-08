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
                getDrawable(R.drawable.questao3),
                getDrawable(R.drawable.questao2),
                getDrawable(R.drawable.questao1)
        };

//        PRIMEIRO CÓDIGO
        ImageView code1 = findViewById(R.id.i1);
        code1.setBackground(simbols[0]);

        Button up1 = findViewById(R.id.up1);
        Button down1 = findViewById(R.id.down1);

        up1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView code1 = findViewById(R.id.i1);

                     for (int i = 0; i< simbols.length; i++) {
                         if(code1.getBackground() == simbols[i]){
                             try {
                                 code1.setBackground(simbols[i+1]);
                             }catch (ArrayIndexOutOfBoundsException err){
                                 code1.setBackground(simbols[0]);
                             }
                             break;
                         }
                     }
                 }
             });

        down1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   ImageView code1 = findViewById(R.id.i1);

                   for (int i = simbols.length - 1; i >= 0; i--) {
                       if(code1.getBackground() == simbols[i]){
                           try {
                               code1.setBackground(simbols[i-1]);
                           }catch (ArrayIndexOutOfBoundsException err){
                               code1.setBackground(simbols[simbols.length - 1]);
                           }
                           break;
                       }
                   }
               }
           });


        //      SEGUNDO CÓDIGO
        ImageView code2 = findViewById(R.id.i2);
        code2.setBackground(simbols[0]);

        Button up2 = findViewById(R.id.up2);
        Button down2 = findViewById(R.id.down2);

        up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView code2 = findViewById(R.id.i2);

                for (int i = 0; i< simbols.length; i++) {
                    if(code2.getBackground() == simbols[i]){
                        try {
                            code2.setBackground(simbols[i+1]);
                        }catch (ArrayIndexOutOfBoundsException err){
                            code2.setBackground(simbols[0]);
                        }
                        break;
                    }
                }
            }
        });

        down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView code2 = findViewById(R.id.i2);

                for (int i = simbols.length - 1; i >= 0; i--) {
                    if(code2.getBackground() == simbols[i]){
                        try {
                            code2.setBackground(simbols[i-1]);
                        }catch (ArrayIndexOutOfBoundsException err){
                            code2.setBackground(simbols[simbols.length - 1]);
                        }
                        break;
                    }
                }
            }
        });

//        TERCEIRO CÓDIGO
        ImageView code3 = findViewById(R.id.i3);
        code3.setBackground(simbols[0]);

        Button up3 = findViewById(R.id.up3);
        Button down3 = findViewById(R.id.down3);

        up3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView code3 = findViewById(R.id.i3);

                for (int i = 0; i< simbols.length; i++) {
                    if(code3.getBackground() == simbols[i]){
                        try {
                            code3.setBackground(simbols[i+1]);
                        }catch (ArrayIndexOutOfBoundsException err){
                            code3.setBackground(simbols[0]);
                        }
                        break;
                    }
                }
            }
        });

        down3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView code3 = findViewById(R.id.i3);

                for (int i = simbols.length - 1; i >= 0; i--) {
                    if(code3.getBackground() == simbols[i]){
                        try {
                            code3.setBackground(simbols[i-1]);
                        }catch (ArrayIndexOutOfBoundsException err){
                            code3.setBackground(simbols[simbols.length - 1]);
                        }
                        break;
                    }
                }
            }
        });
    }
}
