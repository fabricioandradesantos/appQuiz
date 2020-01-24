package com.example.appquiz;

public class QuestoesClass {

    public String mQuestoes[] = {

            "Representa o tratamento automático da informação",
            "É uma máquina constituída por uma série de componentes e circuitos eletrônicos, capaz de receber, armazenar, processar e transmitir informações",
            "Consiste num conjunto de dispositivos eletrônicos capazes de processar informações de acordo com um programa",
            "Considerado o pai da computação",
            "Considerado o pai do computador"

    };

    public String mRespostas[][] = {

            {"Informática", "Ciência", "Analise", "Ábaco"},
            {"Rádio", "Televisão", "Computador", "Telégrafo"},
            {"Sistema de Defesa", "Computador", "Sistema Númerico", "Sistema de Cálculo"},
            {"Robert Noyce", "Paul Mockapetris", "Tim Berners-Lee", "Alan Turing"},
            {"Claude Chappe", "Charles Babbage", "Alan Turing", "Gottfried Wilhelm Leibniz"}

    };

    public String mCorretas[] = {

            "Informática",
            "Computador",
            "Computador",
            "Alan Turing",
            "Charles Babbage"

    };


    public String getQuestoes(int n) {
        String questao = mQuestoes[n];
        return questao;
    }

    public String getRespota1(int n) {
        String respostas = mRespostas[n][0];
        return respostas;
    }

    public String getRespota2(int n) {
        String respostas = mRespostas[n][1];
        return respostas;
    }


    public String getRespota3(int n) {
        String respostas = mRespostas[n][2];
        return respostas;
    }


    public String getRespota4(int n) {
        String respostas = mRespostas[n][3];
        return respostas;
    }

    public String getCorreta(int n) {
        String correta = mCorretas[n];
        return correta;
    }
}