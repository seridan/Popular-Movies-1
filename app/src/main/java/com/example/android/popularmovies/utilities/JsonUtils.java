package com.example.android.popularmovies.utilities;

import android.util.Log;

import com.example.android.popularmovies.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seridan on 06/03/2018.
 */

public class JsonUtils {

    private static final String ID = "id";
    private static final String ORIGINAL_TITLE = "original_title";
    private static final String POSTER_PATH = "poster_path";
    private static final String OVERVIEW = "overview";
    private static final String VOTE_AVERAGE = "vote_average";
    private static final String RELEASE_DATE = "release_date";
    private static final String RESULTS = "results";
    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w85";
    private static final String BACKDROPS = "backdrops";
    private static final String FILE_PATH = "file_path";
    private static final String TAG = JsonUtils.class.toString();


    public static List<Movie> parseMovieList (String json) throws JSONException {
        JSONObject parentObject = new JSONObject(json);
        JSONArray resultsArray = parentObject.getJSONArray(RESULTS);
        List<Movie> parseMovieList = new ArrayList<>();

        if (resultsArray != null) {
            for (int i = 0; i < resultsArray.length(); i++) {
                Movie parseMovie = new Movie();
                JSONObject movieObject = resultsArray.getJSONObject(i);
                parseMovie.setId(movieObject.optInt(ID));
                parseMovie.setOriginalTitle(movieObject.optString(ORIGINAL_TITLE));
                parseMovie.setPosterPath(movieObject.optString(POSTER_PATH));
                parseMovie.setOverview(movieObject.optString(OVERVIEW));
                parseMovie.setVote_average(movieObject.optDouble(VOTE_AVERAGE));
                parseMovie.setReleaseDate(movieObject.optString(RELEASE_DATE));

                parseMovieList.add(parseMovie);
            }
        }
        return parseMovieList;
    }

    public static String getDetailImage (String json) throws JSONException {
        String filePath;
        JSONObject parentObject = new JSONObject(json);
        JSONArray backDropArray = parentObject.getJSONArray(BACKDROPS);

        if (backDropArray != null) {

            JSONObject backDroPObject = backDropArray.getJSONObject(0);
            if (backDroPObject != null){
                filePath = backDroPObject.getString(FILE_PATH);
                Log.v(TAG, "parse filepath " + filePath);
                return filePath;
            }
        }
        return null;
    }


    public static List<String> getSortedList (String json) throws JSONException {
        JSONObject parentObject = new JSONObject(json);
        JSONArray resultsArray = parentObject.getJSONArray(RESULTS);
        List<String> stringList = new ArrayList<>();
        if (resultsArray != null) {

            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject posterPath = resultsArray.getJSONObject(i);
                stringList.add((String) posterPath.get(POSTER_PATH));
            }
        }
        return stringList;
    }


}