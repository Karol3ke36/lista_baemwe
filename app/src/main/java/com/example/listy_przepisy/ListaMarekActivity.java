package com.example.listy_przepisy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaMarekActivity extends AppCompatActivity {
    private ArrayList<Marka> markaArraylist;
    private ListView listViewMarki;
    private ArrayAdapter<Marka> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_marek);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String wybranaKategoria = getIntent().getStringExtra("KATEGORIA");

        markaArraylist = RepozytoriumMarek.zwrocAutoDanejKat(wybranaKategoria);
        listViewMarki = findViewById(R.id.listViewKategorie);
        arrayAdapter = new ArrayAdapter<>(
                ListaMarekActivity.this,
                android.R.layout.simple_list_item_1,
                markaArraylist
        );
        listViewMarki.setAdapter(arrayAdapter);

        listViewMarki.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        int indexKliknietegoElementu = i;
                        String kategoria = wybranaKategoria;
                        Intent intent = new Intent(ListaMarekActivity.this, specyfikacjaActivity.class);
                        intent.putExtra("INDEX", indexKliknietegoElementu);
                        intent.putExtra("KATEGORIA", kategoria);
                        startActivity(intent);
                    }
                }
        );
    }
}