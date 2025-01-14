package com.example.apptreegame.initial_fundamental;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;

public class Quest5 extends AppCompatActivity implements QuestController  {
    float dX, dY = 0.0f;
    boolean[] order = {
            false, false,
            false, false, true,
            false, false, false, true
    };

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        ImageView[] rectangles = {
            rootView.findViewById(R.id.r1),
            rootView.findViewById(R.id.a2),
            rootView.findViewById(R.id.b1),
            rootView.findViewById(R.id.b2),
            rootView.findViewById(R.id.b3),
            rootView.findViewById(R.id.c1),
            rootView.findViewById(R.id.c2),
            rootView.findViewById(R.id.c3),
            rootView.findViewById(R.id.c4)
        };
        TextView[] words = {
            rootView.findViewById(R.id.ta1),
            rootView.findViewById(R.id.ta2),
            rootView.findViewById(R.id.tb1),
            rootView.findViewById(R.id.tb2),
            rootView.findViewById(R.id.tb3),
            rootView.findViewById(R.id.tc1),
            rootView.findViewById(R.id.tc2),
            rootView.findViewById(R.id.tc3),
            rootView.findViewById(R.id.tc4)
        };

        for (int i = 0; i < words.length; i++){
            int finalI = i;
            words[i].setOnTouchListener((view, event) -> {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        if(!order[finalI]){
                            view.animate()
                                    .x(event.getRawX() + dX)
                                    .y(event.getRawY() + dY)
                                    .setDuration(0)
                                    .start();

                            int wix = (int) words[finalI].getX();
                            int wiy = (int) words[finalI].getY();

                            int rix = (int) rectangles[finalI].getX();
                            int riy = (int) rectangles[finalI].getY();

                            int wlx = (int) wix + words[finalI].getWidth();
                            int wly = (int) wiy + words[finalI].getHeight();

                            int rlx = (int) rix + rectangles[finalI].getWidth();
                            int rly = (int) riy + rectangles[finalI].getHeight();

                            order[finalI] = (wlx < rlx && wix > rix) && (wly < rly && wiy > riy);
                        }else
                            words[finalI].setOnTouchListener((v, e) -> true);
                            if (valid_position()) {
                                System.out.println("ok");
                                root.replaceInclude(R.layout.efi_quest_7, new Quest7());
                            }
                        break;

                    default:
                        return false;
                }


                return true;
            });
        }
    }

    private boolean valid_position(){
        for (boolean pos: order ) {
            System.out.println(pos);
            if (!pos)
                return false;
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
