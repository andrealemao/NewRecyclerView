package com.cursoandroid.newrecyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cursoandroid.newrecyclerview.R;
import com.cursoandroid.newrecyclerview.RecyclerItemClickListener;
import com.cursoandroid.newrecyclerview.adapter.Adapter;
import com.cursoandroid.newrecyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Filme> filmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //listagem de filmes
        this.criarFilmes();

        //configura adapter
        Adapter adapter = new Adapter(filmes);

        //configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = filmes.get(position);
                                Toast.makeText(getApplicationContext(), "Item Pressionado: " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = filmes.get(position);
                                Toast.makeText(getApplicationContext(), "Click longo: " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void criarFilmes() {
        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");
        this.filmes.add(filme);
        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        this.filmes.add(filme);
        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        this.filmes.add(filme);
        filme = new Filme("Capitão América - Guerra Civil", "Aventura/Ficção", "2016");
        this.filmes.add(filme);
        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        this.filmes.add(filme);
        filme = new Filme("Avengers - End game", "Ação/Aventura", "2019");
        this.filmes.add(filme);
        filme = new Filme("A Múmia", "Aventura", "2017");
        this.filmes.add(filme);
        filme = new Filme("Meu Malvado Favorito 3", "Comédia/Animação", "2017");
        this.filmes.add(filme);
        filme = new Filme("Carros 3", "Comédia/Animação", "2017");
        this.filmes.add(filme);
        filme = new Filme("Busca Implacável", "Ação", "2017");
        this.filmes.add(filme);
    }
}