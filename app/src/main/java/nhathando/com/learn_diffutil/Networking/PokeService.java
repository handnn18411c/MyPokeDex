package nhathando.com.learn_diffutil.Networking;

import nhathando.com.learn_diffutil.Models.Pokemon;
import nhathando.com.learn_diffutil.Models.Result;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeService {

    @GET("pokemon?limit=200")
    Call<Pokemon> getPokemon();

}
