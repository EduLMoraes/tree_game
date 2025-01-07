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

    private Bitmap labirintoBitmap;
    private Bitmap capivaraBitmap;
    private int capivaraX = 1, capivaraY = 0; // Posição inicial da capivara
    private int tamanhoCelula;
    private int larguraLabirinto, alturaLabirinto;

    public Quest6(Context context) {
        super(context);
        labirintoBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iniciais_questao6a);
        capivaraBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iniciais_questao6b);
    }

    public Quest6(Context context, AttributeSet attrs) {
        super(context, attrs);
        labirintoBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iniciais_questao6a);
        capivaraBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iniciais_questao6b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Desenha o labirinto
        canvas.drawBitmap(labirintoBitmap, 100, 0, null);

        // Desenha a capivara
        canvas.drawBitmap(capivaraBitmap, capivaraX * tamanhoCelula, capivaraY * tamanhoCelula, null);
    }

    // Detecta colisão com paredes negras do labirinto
    private boolean verificarColisao(int x, int y) {
        int pixel = labirintoBitmap.getPixel(x, y);
        int cor = Color.BLACK; // Cor da parede

        System.out.println(pixel == cor);
        System.out.println(pixel);
        System.out.println(cor);

        return pixel == cor;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            // Obtemos a nova posição do toque
            int novoX = (int) event.getX() / tamanhoCelula;
            int novoY = (int) event.getY() / tamanhoCelula;

            // Verifica se a nova posição está em uma parede preta
            if (verificarColisao(novoX, novoY)) {
                // Atualiza a posição da capivara apenas se não for uma colisão
                capivaraX = novoX;
                capivaraY = novoY;
                invalidate(); // Redesenha a tela
            }
        }
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        larguraLabirinto = w;
        alturaLabirinto = h;
        tamanhoCelula = w / 25;
    }

    @SuppressLint("WrongCall")
    @Override
    public void initialize(View rootView, TemplateQuest root) {
        this.onDraw(new Canvas());
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }
}
