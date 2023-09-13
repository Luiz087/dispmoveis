package com.example.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Churrasco> listaChurrasco = new ArrayList<Churrasco>();

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView.findViewById(R.id.lista);
        listaChurrasco.add(new Churrasco( 1, "Carne", R.drawable.carne));
        listaChurrasco.add(new Churrasco( 1, "Linguiça", R.drawable.linguica));
        listaChurrasco.add(new Churrasco( 1, "Pão de Alho", R.drawable.paodealho));
        listaChurrasco.add(new Churrasco( 1, "Cerveja", R.drawable.cerveja));
        listaChurrasco.add(new Churrasco( 1, "Refrigerante", R.drawable.coca));

        ChurrascoAdapter adapter = new ChurrascoAdapter(this, R.layout.activity_main,listaChurrasco);
        listView.setAdapter(adapter);
    }


}