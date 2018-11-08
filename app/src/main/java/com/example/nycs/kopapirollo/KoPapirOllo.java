package com.example.nycs.kopapirollo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class KoPapirOllo extends AppCompatActivity {

    private ImageView kep_ember, kep_gep;
    private TextView Text_View1, Text_View2, Text_Eredmeny;
    private Button ko, papir, ollo;
    private int jatekos, gep, pont_j=0, pont_g=0;
    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ko_papir_ollo);
        init();

        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekos=1;
                kep_ember.setBackgroundResource(R.drawable.rock);
                GepMutat();
            }
        });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekos=2;
                kep_ember.setBackgroundResource(R.drawable.paper);
                GepMutat();
            }
        });

        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekos=3;
                kep_ember.setBackgroundResource(R.drawable.scissors);
                GepMutat();
            }
        });
    }

    public void GepMutat(){
        gep = rand.nextInt(3)+1;
        switch (gep){
            case 1: kep_gep.setBackgroundResource(R.drawable.rock); break;
            case 2: kep_gep.setBackgroundResource(R.drawable.paper); break;
            case 3: kep_gep.setBackgroundResource(R.drawable.scissors); break;
                default:
                    Toast.makeText(this, "rossz random", Toast.LENGTH_SHORT).show();break;
        }
        //1=ko, 2=papir, 3=ollo
        if (jatekos == gep){
            Toast.makeText(this, "Döntetlen, senki nem nyert", Toast.LENGTH_SHORT).show();
        }else if (jatekos == 1){
            if (gep==2){
                Toast.makeText(this, "A papír erősebb, mint a kő. A gép nyert!", Toast.LENGTH_SHORT).show();
                pont_g++;
            }else if (gep==3){
                Toast.makeText(this, "A kő erősebb, mint az olló. Te nyertél!", Toast.LENGTH_SHORT).show();
                pont_j++;
            }
        }else if (jatekos == 2){
            if (gep==1){
                Toast.makeText(this, "A papír erősebb, mint a kő. Te nyertél!", Toast.LENGTH_SHORT).show();
                pont_j++;
            }else if (gep==3){
                Toast.makeText(this, "Az olló erősebb, mint a papír. A gép nyert!", Toast.LENGTH_SHORT).show();
                pont_g++;
            }
        }else if (jatekos == 3){
            if (gep==1){
                Toast.makeText(this, "A kő erpsebb, mint az olló. A gép nyert!", Toast.LENGTH_SHORT).show();
                pont_g++;
            }else if (gep==2){
                Toast.makeText(this, "Az olló erősebb, mint a papír. Te nyertél!", Toast.LENGTH_SHORT).show();
                pont_j++;
            }
        }

        String s = "Eredmény: Ember: " + pont_j + " Gép: " + pont_g;
        Text_Eredmeny.setText(s);
    }

    public void init(){
        kep_ember = (ImageView) findViewById(R.id.Image_Ember);
        kep_gep = (ImageView) findViewById(R.id.Image_Gep);
        Text_View1 = (TextView) findViewById(R.id.Text_View1);
        Text_View2 = (TextView) findViewById(R.id.Text_View2);
        Text_Eredmeny = (TextView) findViewById(R.id.Text_Eredmeny);
        ko = (Button) findViewById(R.id.Button_ko);
        papir = (Button) findViewById(R.id.Button_papir);
        ollo = (Button) findViewById(R.id.Button_ollo);
    }
}
