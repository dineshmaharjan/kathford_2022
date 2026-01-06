package np.edu.kathford.sendingandgettingcontentfromserver.network;

import java.util.List;

import np.edu.kathford.sendingandgettingcontentfromserver.model.request.PostRequest;
import np.edu.kathford.sendingandgettingcontentfromserver.model.response.PostResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("posts")
    Call<PostResponse> createPost(@Body PostRequest request);

    @GET("posts")
    Call<List<PostResponse>> getPosts();


}
