package com.example.listy_przepisy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class specyfikacjaActivity extends AppCompatActivity {
    TextView textViewOpis, textViewMarka, textViewSpecyfikacja;
    Button button;
    ImageView imageView;
    Marka specyfikacja = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_specyfikacja);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setContentView(R.layout.activity_specyfikacja);
        int index = getIntent().getIntExtra("INDEX", -1);
        String kategoria = getIntent().getStringExtra("KATEGORIA");

        textViewMarka = findViewById(R.id.textViewMarka);
        textViewOpis = findViewById(R.id.textViewOpis);
        textViewSpecyfikacja = findViewById(R.id.textViewSpecyfikacja);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        if(index>=0){
            specyfikacja = RepozytoriumMarek.zwrocAutoDanejKat(kategoria).get(index);
            wyswietlSpecyfikacje(specyfikacja);
        }

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentWyslij = new Intent();
                        intentWyslij.setAction(Intent.ACTION_SEND);
                        intentWyslij.putExtra(Intent.EXTRA_TEXT, specyfikacja.getNazwaMarki()
                                +" Specyfikacja: "+specyfikacja.getParametry()+" Opis: "
                                +specyfikacja.getOpis()+" Piekna furka cnie?");//wnetrze wiadomosci
                        intentWyslij.setType("text/plain");
                        Intent podzielIntent = Intent.createChooser(intentWyslij, null);
                        startActivity(podzielIntent);
                    }
                }
        );

    }
    private void wyswietlSpecyfikacje(Marka specyfikacja){
        textViewSpecyfikacja.setText("Specyfikacja:\n"+specyfikacja.getParametry());
        textViewOpis.setText("Krótki opis:\n"+specyfikacja.getOpis());
        textViewMarka.setText("Marka: "+specyfikacja.getNazwaMarki());
        imageView.setImageResource(specyfikacja.getIdObrazka());
    }
}