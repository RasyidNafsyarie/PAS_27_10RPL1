package com.example.pas_27_10rpl1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Makanan>models;

    RecyclerView mRecyclerView;
    MakananAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        models = getMyList();


        mRecyclerView = findViewById(R.id.rvdata);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MakananAdapter(this, models, new MakananAdapter.FungsiBalik() {

            public void pasdiClick(int index) {
                Bundle bundle = new Bundle();
                bundle.putString("nama", models.get(index).getTitle());
                bundle.putInt("image", models.get(index).getImg());
                bundle.putString("deskripsi", models.get(index).getDeskripsi());
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(myAdapter);

       
    }

    private ArrayList<Makanan> getMyList() {

        ArrayList<Makanan> models = new ArrayList<>();

        Makanan m = new Makanan("Pizza", R.drawable.pizza, "Pizza biasanya dimakan di restoran, dibeli di pasar grosir atau supermarket, dan dapat pula dipesan melalui telepon atau ini melalui web untuk diantar.");
        models.add(m);

        m = new Makanan("Burger", R.drawable.burger, "Hamburger (atau sering kali disebut dengan burger) adalah sejenis makanan berupa roti berbentuk bundar yang diiris dua dan di tengahnya diisi dengan patty yang biasanya diambil dari daging.");
        models.add(m);

        m = new Makanan("Hotdog", R.drawable.hotdog, "Hot dog adalah suatu jenis sosis yang dimasak atau diasapi dan memiliki tekstur yang lebih halus serta rasa yang lebih lembut dan basah daripada kebanyakan sosis.");
        models.add(m);

        m = new Makanan("Milkcho", R.drawable.milk, "Milkshake adalah minuman dingin dari campuran susu, es krim, dan sirop berperasa yang dikocok hingga berbusa. Selain dikocok dengan blender, susu kocok bisa dibuat dengan memakai gelas pengocok bertutup");
        models.add(m);

        return models;

    }

}
