package com.example.appquiz;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class DadosClass {

    private int ultimoRecorde;
    private int auxScore;
    private int score1;
    private int score2;
    private int score3;
    private int score4;

    private int ultimaTentativa;
    private int auxTentativa;
    private int tentativa1;
    private int tentativa2;
    private int tentativa3;
    private int tentativa4;

    public void salvarTentativas(int tentativas, Context context) {

        SharedPreferences mTentativas = context.getSharedPreferences("tentativa", MODE_PRIVATE);
        SharedPreferences.Editor editor = mTentativas.edit();
        editor.putInt("tentativa", tentativas);
        editor.commit();
    }

    public void ultimoRecorde(int score, Context context) {

        SharedPreferences mRecorde = context.getSharedPreferences("recorde", MODE_PRIVATE);
        SharedPreferences.Editor editor = mRecorde.edit();
        editor.putInt("ultimoRecorde", score);
        editor.apply();
    }

    public void recorde(int score, int tentativa, Context context) {

        SharedPreferences mRecorde = context.getSharedPreferences("recorde", MODE_PRIVATE);

        ultimoRecorde = score;
        score1 = mRecorde.getInt("score1", MODE_PRIVATE);
        score2 = mRecorde.getInt("score2", MODE_PRIVATE);
        score3 = mRecorde.getInt("score3", MODE_PRIVATE);
        score4 = mRecorde.getInt("score4", MODE_PRIVATE);

        ultimaTentativa = tentativa;

        tentativa1 = mRecorde.getInt("tentativa1", MODE_PRIVATE);
        tentativa2 = mRecorde.getInt("tentativa2", MODE_PRIVATE);
        tentativa3 = mRecorde.getInt("tentativa3", MODE_PRIVATE);
        tentativa4 = mRecorde.getInt("tentativa4", MODE_PRIVATE);


        if (ultimoRecorde > score4) {

            score4 = ultimoRecorde;
            tentativa4 = ultimaTentativa;

            SharedPreferences.Editor editor = mRecorde.edit();
            editor.putInt("tentativa4", tentativa4);
            editor.putInt("score4", score4);
            editor.apply();
        }
        if (ultimoRecorde > score3) {

            auxScore = score3;
            auxTentativa = tentativa3;

            score3 = ultimoRecorde;
            tentativa3 = ultimaTentativa;
            score4 = auxScore;
            tentativa4 = auxTentativa;

            SharedPreferences.Editor editor = mRecorde.edit();
            editor.putInt("tentativa3", tentativa3);
            editor.putInt("tentativa4", tentativa4);
            editor.putInt("score3", score3);
            editor.putInt("score4", score4);
            editor.apply();
        }
        if (ultimoRecorde > score2) {

            auxScore = score2;
            auxTentativa = tentativa2;
            score2 = ultimoRecorde;
            tentativa2 = ultimaTentativa;
            score3 = auxScore;
            tentativa3 = auxTentativa;

            SharedPreferences.Editor editor = mRecorde.edit();
            editor.putInt("tentativa2", tentativa2);
            editor.putInt("tentativa3", tentativa3);
            editor.putInt("score2", score2);
            editor.putInt("score3", score3);
            editor.apply();
        }
        if (ultimoRecorde > score1) {

            auxScore = score1;
            auxTentativa = tentativa1;
            score1 = ultimoRecorde;
            tentativa1 = ultimaTentativa;
            score2 = auxScore;
            tentativa2 = auxTentativa;

            SharedPreferences.Editor editor = mRecorde.edit();
            editor.putInt("tentativa1", tentativa1);
            editor.putInt("tentativa2", tentativa2);
            editor.putInt("score1", score1);
            editor.putInt("score2", score2);
            editor.apply();
        }

    }
}
