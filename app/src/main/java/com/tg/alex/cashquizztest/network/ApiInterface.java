package com.tg.alex.cashquizztest.network;

import com.tg.alex.cashquizztest.network.pojo.TournamentCategoriesPojo;
import com.tg.alex.cashquizztest.network.pojo.TournamentsPojo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Alex on 10/25/2017.
 */

public interface ApiInterface {

    @GET("de5540a72b47153c550c916aae3ab0ae392dbd23/")
    Call<TournamentCategoriesPojo> getTournamentCategories();

    @GET("de5540a72b47153c550c916aae3ab0ae392dbd23/tournaments.json")
    Call<TournamentsPojo> getTournaments();

}
