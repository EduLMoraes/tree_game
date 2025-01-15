package com.example.apptreegame.initial_fundamental;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;

import java.util.Random;

public class Quest10 implements QuestController {

    @Override
    public void initialize(View rootView, TemplateQuest root) {
        ImageView[] apples ={
                rootView.findViewById(R.id.a),
                rootView.findViewById(R.id.b),
                rootView.findViewById(R.id.c),
                rootView.findViewById(R.id.d),
                rootView.findViewById(R.id.e),
                rootView.findViewById(R.id.f)
        };

        for (ImageView ap: apples){
            ap.setOnClickListener((v) -> {
                ap.setVisibility(View.INVISIBLE);
                ap.setOnClickListener((_v)->{});

                boolean all_invisible = true;

                for(ImageView a: apples){
                    if(a.getVisibility() == View.VISIBLE){
                        all_invisible = false;
                        break;
                    }
                }

                if(all_invisible){
                    root.replaceInclude(R.layout.efi_quest_11, new Quest11(), R.raw.questao_efi_11);
                }
            });
        }
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }
}
