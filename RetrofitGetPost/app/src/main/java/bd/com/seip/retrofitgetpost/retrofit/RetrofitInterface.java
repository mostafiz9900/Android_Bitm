package bd.com.seip.retrofitgetpost.retrofit;

import java.util.List;

import bd.com.seip.retrofitgetpost.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("comments")
    Call<List<User>> getDatas();

    @GET("comments")
    Call<List<User>> getSearch(
            @Query("postId")  int postId
    );
   /* @GET("comments/{id}")
    Call<List<User>> getDatasPath(
            @Path("postId")  int postId

    );*/
}
