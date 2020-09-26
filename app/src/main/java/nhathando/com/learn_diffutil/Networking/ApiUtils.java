package nhathando.com.learn_diffutil.Networking;

import retrofit2.Retrofit;

public class ApiUtils {
    public static String BASE_URL = "https://pokeapi.co/api/v2/";
    public static PokeService getPokeService(){
        return RetrofitClient.getClient(BASE_URL).create(PokeService.class);
    }
}
