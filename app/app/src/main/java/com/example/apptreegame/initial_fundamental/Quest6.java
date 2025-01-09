package com.example.apptreegame.initial_fundamental;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.apptreegame.QuestController;
import com.example.apptreegame.R;

public class Quest6 extends View implements QuestController {

    private View rootView;
    private TemplateQuest root;
    private Bitmap labirintoBitmap;
    private Bitmap capivaraBitmap;
    private Bitmap pastoBitmap;
    private int capivaraX = 10, capivaraY = 16;
    private int pastoX = 49, pastoY = 13;
    private int tamanhoCelula;
    private int larguraLabirinto, alturaLabirinto;
    private int[][] walls = {
        {0,  0, 1000,  0}, {14,  0, 14, 14},
        {23,  2, 30,  2}, {17, 15, 17, 18}, 
        {33,  2, 42,  2}, {17,  0, 17,  5},
        {24,  5, 20,  5}, {20,  3, 20, 14},
        {30,  5, 33,  5}, {20, 17, 20, 20},
        {36,  5, 42,  5}, {20, 23, 20, 30},
        {27,  8, 33,  8}, {23,  0, 23,  2},
        {14,  8, 17,  8}, {23,  9, 23, 12},
        {42,  8, 45,  8}, {23, 15, 23, 20},
        {17, 11, 33, 11}, {23, 23, 23, 27},
        {14, 14, 20, 14}, {26,  2, 26,  9},
        {23, 14, 27, 14}, {14, 17, 14, 30},
        {30, 14, 33, 14}, {26, 20, 26, 24},
        {36, 14, 42, 14}, {26, 26, 26, 30},
        {20, 17, 23, 17}, {29, 11, 29, 24},
        {26, 17, 30, 17}, {33,  0, 33,  3},
        {33, 17, 39, 17}, {33,  9, 33,  6},
        {42, 17, 45, 17}, {33, 26, 33, 30},
        {14, 20, 20, 20}, {36,  6, 36,  9},
        {24, 20, 27, 20}, {36, 11, 36, 15},
        {30, 20, 33, 20}, {36, 20, 36, 27},
        {39, 20, 42, 20}, {39,  6, 39, 11},
        {30, 23, 39, 23}, {39, 17, 39, 21},
        {17, 23, 21, 23}, {39, 26, 39, 30},
        {14, 26, 17, 26}, {42,  3, 42,  6},
        {24, 26, 27, 26}, {42, 11, 42, 18},
        {30, 26, 33, 26}, {42, 20, 42, 27},
        {39, 26, 42, 26}, {45, 14, 45, 30},
        {0, 30, 1000, 30}, {45,  0, 45, 12},
    };

    public Quest6(Context context) {
        super(context);
        labirintoBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iniciais_questao6a);
        capivaraBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iniciais_questao6b);
        pastoBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iniciais_questao6);
    }

    public Quest6(Context context, AttributeSet attrs) {
        super(context, attrs);
        labirintoBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iniciais_questao6a);
        capivaraBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iniciais_questao6b);
        pastoBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iniciais_questao6);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(labirintoBitmap, 300, 0, null);

        canvas.drawBitmap(capivaraBitmap, capivaraX * tamanhoCelula, capivaraY * tamanhoCelula, null);
        canvas.drawBitmap(pastoBitmap, pastoX * tamanhoCelula, pastoY * tamanhoCelula, null);
    }

    private boolean verificarColisao(int x, int y, int oldX, int oldY) {
        for(int[] wall : walls){
            if((x >= wall[0] && x <= wall[2])
                && (y >= wall[1] && y <= wall[3])){
                return false;
            }
        }

        return ((Math.abs(x - oldX) == 1 && Math.abs(y - oldY) == 0)
                || (Math.abs(y - oldY) == 1 && Math.abs(x - oldX) == 0));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(capivaraX > 45){
            win();
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            int novoX = (int) event.getX() / tamanhoCelula;
            int novoY = (int) event.getY() / tamanhoCelula;

            if (verificarColisao(novoX, novoY, capivaraX, capivaraY)) {
                capivaraX = novoX;
                capivaraY = novoY;


                invalidate();
            }
        }
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        larguraLabirinto = w;
        alturaLabirinto = h;
        tamanhoCelula =  20;
    }

    private void win(){
        root.replaceInclude(R.layout.efi_quest_7, new Quest7());
    }

    @SuppressLint("WrongCall")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        this.root = root;
        this.rootView = rootView;
        this.onDraw(new Canvas());
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

}
