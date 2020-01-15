package com.example.appquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPrincipal extends AppCompatActivity {

    private Button btnComecar;
    private Button btnEvolucao;
    private Button btnRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComecar = (Button) findViewById(R.id.btnComecarId);
        btnEvolucao = (Button) findViewById(R.id.btnEvolucaoId);
        btnRanking = (Button) findViewById(R.id.btnRankingId);


        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPrincipal.this, MainTelaDoJogo.class);
                startActivity(intent);
                finish();
            }
        });

        btnEvolucao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPrincipal.this, MainEvolucao.class);
                startActivity(intent);
                finish();
            }
        });


        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainPrincipal.this);
                alert.setTitle("Em breve...");
                alert.setMessage("Você poderá competir com outros crânios no Ranking Online!");
                alert.setPositiveButton("Skip", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //opcional
                    }
                });
                alert.show();
            }
        });




    }

    @Override
    public void onBackPressed(){
        finish();
        super.onBackPressed();
    }

}