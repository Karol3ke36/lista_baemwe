package com.example.listy_przepisy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView listViewKategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewKategorie = findViewById(R.id.listViewKategorie);
        listViewKategorie.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        view.setBackgroundColor(Color.GRAY);
                        Toast.makeText(MainActivity.this, "Kliknieto elemnt "+i,  Toast.LENGTH_SHORT).show();
                        String wybranaKategoria = adapterView.getItemAtPosition(i).toString();
                        Intent intent = new Intent(MainActivity.this,ListaMarekActivity.class);
                        intent.putExtra("KATEGORIA", wybranaKategoria);
                        startActivity(intent);
                    }
                }
        );
    }
}