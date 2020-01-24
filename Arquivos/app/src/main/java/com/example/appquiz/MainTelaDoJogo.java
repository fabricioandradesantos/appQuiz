package com.example.appquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainTelaDoJogo extends AppCompatActivity {

    private Button resposta1;
    private Button resposta2;
    private Button resposta3;
    private Button resposta4;

    private String correta;
    private TextView questao;
    private TextView recorde;

    private QuestoesClass cQuestao = new QuestoesClass();
    private DadosClass dados = new DadosClass();

    private  int i;
    private  int posicao;
    private  int score;
    private  int tentativas;
    private  int questaoTam = cQuestao.mQuestoes.length;

    private List<Integer> numSorteados = new ArrayList<Integer>(questaoTam);

   // private Random numRamdom = new Random();

    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tela_do_jogo);

        resposta1 = (Button)  findViewById(R.id.btnQuestao1ID);
        resposta2 = (Button)  findViewById(R.id.btnQuestao2ID);
        resposta3 = (Button)  findViewById(R.id.btnQuestao3ID);
        resposta4 = (Button)  findViewById(R.id.btnQuestao4ID);

        questao = (TextView) findViewById(R.id.txtPerguntaId);
        recorde = (TextView) findViewById(R.id.txtRecordeId);

        //som
        mediaPlayer = MediaPlayer.create(this, R.raw.woohoo);

        //lendo dados
        SharedPreferences mTentativas = this.getSharedPreferences("tentativa", MODE_PRIVATE);
        tentativas = mTentativas.getInt("tentativa",0);
        tentativas = tentativas +1;


        //salvando dados
        dados.salvarTentativas(tentativas, MainTelaDoJogo.this);
        dados.ultimoRecorde(score, MainTelaDoJogo.this);

        //sorteando questões
        for (i=0; i<questaoTam;i++){
            numSorteados.add(i);
        }

        Collections.shuffle(numSorteados);
        rodar(posicao);

        resposta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (resposta1.getText() == correta) {
                    mediaPlayer.start();
                    score++;
                    recorde.setText("" + score);
                    posicao++;
                    rodar(posicao);
                } else {

                    dados.recorde(score, tentativas,MainTelaDoJogo.this);
                    if(score > 3){

                        confirmarScoreOnline();
                    }else {
                        passarActivity();
                        finish();
                    }

                }

            }
        });

        resposta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (resposta2.getText() == correta) {
                    mediaPlayer.start();
                    score++;
                    recorde.setText("" + score);
                    posicao++;
                    rodar(posicao);
                } else {
                    dados.recorde(score,tentativas,MainTelaDoJogo.this);

                    if(score > 3){

                        confirmarScoreOnline();
                    }else {
                        passarActivity();
                        finish();
                    }
                }

            }
        });

        resposta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (resposta3.getText() == correta) {
                    mediaPlayer.start();
                    score++;
                    recorde.setText("" + score);
                    posicao++;
                    rodar(posicao);
                } else {
                    dados.recorde(score,tentativas,MainTelaDoJogo.this);
                    // confirmarScoreOnline();
                    if(score > 3){
                        confirmarScoreOnline();
                    }else {
                        passarActivity();
                        finish();
                    }
                }

            }
        });

        resposta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resposta4.getText() == correta) {
                    mediaPlayer.start();
                    score++;
                    recorde.setText("" + score);
                    posicao++;
                    rodar(posicao);
                }else {
                    dados.recorde(score,tentativas,MainTelaDoJogo.this);

                    if(score > 3){
                        confirmarScoreOnline();
                    }else {
                        Intent intent = new Intent( MainTelaDoJogo.this, MainPrincipal.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

    }

    private void updateQuestao(int n){

        questao.setText(cQuestao.getQuestoes(n));
        resposta1.setText(cQuestao.getRespota1(n));
        resposta2.setText(cQuestao.getRespota2(n));
        resposta3.setText(cQuestao.getRespota3(n));
        resposta4.setText(cQuestao.getRespota4(n));

        correta = cQuestao.getCorreta(n);
    }

    private void rodar(int n){

        if (n < questaoTam){
            updateQuestao(numSorteados.get(posicao));
        }else {
            dados.recorde(score,tentativas,MainTelaDoJogo.this);
            mediaPlayer.start();
            Toast.makeText(getApplicationContext(), "Ganhou!", Toast.LENGTH_SHORT).show();
            passarActivity();
        }
    }


    private void confirmarScoreOnline(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.tituloDialogo);
        alert.setMessage("Uau! "+ score +" pontos! " + "Em breve poderá subir para o Ranking Online!");
        alert.setPositiveButton("Skip", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                passarActivity();
                finish();
            }

        });

        alert.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                passarActivity();
                finish();
            }
        });

        alert.show();

    }

    public void passarActivity(){
        Intent intent = new Intent( MainTelaDoJogo.this, MainPrincipal.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        dados.salvarTentativas(tentativas-1,this);

        passarActivity();
        finish();

        super.onBackPressed();
    }

    @Override
    public  void onDestroy(){
        if (mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}