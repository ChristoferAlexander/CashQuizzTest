package com.tg.alex.cashquizztest.project.TournamentCategories.providers.impl;

import android.support.annotation.NonNull;

import com.tg.alex.cashquizztest.network.ApiClient;
import com.tg.alex.cashquizztest.network.pojo.TournamentCategoriesPojo;
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
public class TournamentCategoriesProvider implements IDataProvider<TournamentCategoriesPojo> {

    @Bean
    ApiClient mApiClient;

    @Override
    public void provide(@NonNull final IDataListener<TournamentCategoriesPojo> pDataListener) {
        mApiClient.getService()
                .getTournamentCategories()
                .enqueue(new Callback<TournamentCategoriesPojo>() {
                    @Override
                    public void onResponse(Call<TournamentCategoriesPojo> call, Response<TournamentCategoriesPojo> response) {
                        if (response.isSuccessful()) {
                            pDataListener.onComplete(response.body());
                        } else {
                            pDataListener.onError(Constants.NOT_FOUND);
                        }
                    }
                    @Override
                    public void onFailure(Call<TournamentCategoriesPojo> call, Throwable t) {
                        pDataListener.onError(Constants.NOT_FOUND);
                    }
                });
    }
}
