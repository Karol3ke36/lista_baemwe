package com.example.listy_przepisy;

import android.os.Bundle;
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
        Marka specyfikacja = null;

        textViewMarka = findViewById(R.id.textViewMarka);
        textViewOpis = findViewById(R.id.textViewOpis);
        textViewSpecyfikacja = findViewById(R.id.textViewSpecyfikacja);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        if(index>=0){
            specyfikacja = RepozytoriumMarek.zwrocAutoDanejKat(kategoria).get(index);
            wyswietlSpecyfikacje(specyfikacja);
        }
    }
    private void wyswietlSpecyfikacje(Marka specyfikacja){
        textViewSpecyfikacja.setText("Specyfikacja:\n"+specyfikacja.getParametry());
        textViewOpis.setText("Krótki opis:\n"+specyfikacja.getOpis());
        textViewMarka.setText("Marka: "+specyfikacja.getNazwaMarki());
        imageView.setImageResource(specyfikacja.getIdObrazka());
    }
}