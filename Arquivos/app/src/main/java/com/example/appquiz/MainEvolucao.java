package com.example.appquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainEvolucao extends AppCompatActivity {

    private TextView tentativa1;
    private TextView tentativa2;
    private TextView tentativa3;
    private TextView tentativa4;

    private TextView score1;
    private TextView score2;
    private TextView score3;
    private TextView score4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_evolucao);


        tentativa1 = (TextView) findViewById(R.id.txtTentativa1Id);
        tentativa2 = (TextView) findViewById(R.id.txtTentativa2Id);
        tentativa3 = (TextView) findViewById(R.id.txtTentativa3Id);
        tentativa4 = (TextView) findViewById(R.id.txtTentativa4Id);

        score1 = (TextView) findViewById(R.id.txtAcerto1Id);
        score2 = (TextView) findViewById(R.id.txtAcerto2Id);
        score3 = (TextView) findViewById(R.id.txtAcerto3Id);
        score4 = (TextView) findViewById(R.id.txtAcerto4Id);


        SharedPreferences mRecorde = this.getSharedPreferences("recorde",MODE_PRIVATE);

        tentativa1.setText(""+mRecorde.getInt("tentativa1", MODE_PRIVATE));
        tentativa2.setText(""+mRecorde.getInt("tentativa2", MODE_PRIVATE));
        tentativa3.setText(""+mRecorde.getInt("tentativa3", MODE_PRIVATE));
        tentativa4.setText(""+mRecorde.getInt("tentativa4", MODE_PRIVATE));

        score1.setText(""+mRecorde.getInt("score1",MODE_PRIVATE));
        score2.setText(""+mRecorde.getInt("score2",MODE_PRIVATE));
        score3.setText(""+mRecorde.getInt("score3",MODE_PRIVATE));
        score4.setText(""+mRecorde.getInt("score4",MODE_PRIVATE));

    }


    @Override
    public void onBackPressed(){
        Intent intent = new Intent( MainEvolucao.this, MainPrincipal.class);
        startActivity(intent);
        this.finish();
        super.onBackPressed();
    }

}