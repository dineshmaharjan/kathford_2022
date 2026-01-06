package np.edu.kathford.sendingandgettingcontentfromserver.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper {

    private static Retrofit retrofit;

     private static final String BASE_URL="https://jsonplaceholder.typicode.com/";

    private NetworkHelper() {
    }


    public static Retrofit INSTANCE(){
        if(retrofit==null){
            retrofit= new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
