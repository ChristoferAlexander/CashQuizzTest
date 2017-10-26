package com.tg.alex.cashquizztest.project.TournamentCategories.providers.impl;

import android.support.annotation.NonNull;

import com.tg.alex.cashquizztest.network.ApiClient;
import com.tg.alex.cashquizztest.network.pojo.TournamentsPojo;
import com.tg.alex.cashquizztest.project.TournamentCategories.providers.inter.IDataListener;
import com.tg.alex.cashquizztest.project.TournamentCategories.providers.inter.IDataProvider;
import com.tg.alex.cashquizztest.project.utils.Constants;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/***
 * Created by Alex on 7/24/2017.
 */

@EBean
public class TournamentsProvider implements IDataProvider<TournamentsPojo> {

    @Bean
    ApiClient mApiClient;

    @Override
    public void provide(@NonNull final IDataListener<TournamentsPojo> pDataListener) {
        mApiClient.getService()
                .getTournaments()
                .enqueue(new Callback<TournamentsPojo>() {
                    @Override
                    public void onResponse(Call<TournamentsPojo> call, Response<TournamentsPojo> response) {
                        if (response.isSuccessful()) {
                            pDataListener.onComplete(response.body());
                        } else {
                            pDataListener.onError(Constants.NOT_FOUND);
                        }
                    }

                    @Override
                    public void onFailure(Call<TournamentsPojo> call, Throwable t) {
                        pDataListener.onError(Constants.NOT_FOUND);
                    }
                });
    }
}
