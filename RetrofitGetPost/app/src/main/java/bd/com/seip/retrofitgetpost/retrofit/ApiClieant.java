package bd.com.seip.retrofitgetpost.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClieant {
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private static ApiClieant mInstance;
    private Retrofit retrofit;

    public ApiClieant() {
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiClieant getInstance(){
        if (mInstance==null){
            mInstance=new ApiClieant();
        }
        return mInstance;
    }
    public RetrofitInterface getApi(){
        return retrofit.create(RetrofitInterface.class);
    }
}
