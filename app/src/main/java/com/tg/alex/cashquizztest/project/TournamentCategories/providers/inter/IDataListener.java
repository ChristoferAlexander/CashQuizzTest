package com.tg.alex.cashquizztest.project.TournamentCategories.providers.inter;

/**
 * Created by Alex on 10/26/2017.
 *
 * when a Provider is done uses this interface to notify the adapter
 */

public interface IDataListener<T> {

    void onComplete(T pData);

    void onError(int pError);
}