package dragger2.nuoyuan.com.myapplication.demo.model;


import java.util.List;

import dragger2.nuoyuan.com.myapplication.demo.model.entity.Movie;
import dragger2.nuoyuan.com.myapplication.demo.model.entity.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by weichyang on 2017/4/27.
 * 完整查询语句  https://api.douban.com/v2/movie/top250?start=0&count=20,%20tag=null
 */

public interface DouBanMovieService {

    String BASE_URL = "https://api.douban.com/v2/movie/";

    @GET("top250")
    Observable<Response<List<Movie>>> getMovies(@Query("start") int start, @Query("count") int count);

}
