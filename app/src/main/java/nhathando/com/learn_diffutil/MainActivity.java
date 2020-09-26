package nhathando.com.learn_diffutil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import nhathando.com.learn_diffutil.Adapters.PokeAdapter;
import nhathando.com.learn_diffutil.Models.Pokemon;
import nhathando.com.learn_diffutil.Models.Result;
import nhathando.com.learn_diffutil.Networking.ApiUtils;
import nhathando.com.learn_diffutil.Networking.PokeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_pokemon;
    private RecyclerView.LayoutManager layoutManager_poke;
    private PokeService mPokeService;
    private PokeAdapter mPokeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_pokemon = findViewById(R.id.rv_pokeList);
        mPokeService = ApiUtils.getPokeService();
        rv_pokemon.setHasFixedSize(true);

        layoutManager_poke = new LinearLayoutManager(this);
        rv_pokemon.setLayoutManager(layoutManager_poke);

        //Adding Fake Data
//        ArrayList<Pokemon> pokeList = new ArrayList<Pokemon>();
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));
//        pokeList.add(new Pokemon("bulbasaur","Water"));
//        pokeList.add(new Pokemon("ivysaur","Fire"));

        //Set Adapter **
        mPokeAdapter = new PokeAdapter(new ArrayList<Result>(0));
        rv_pokemon.setAdapter(mPokeAdapter);
        loadAnswers();
    }

    public void loadAnswers() {
        mPokeService.getPokemon().enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {

                if(response.isSuccessful()) {
                    mPokeAdapter.updateResult(response.body().getResults());
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

}