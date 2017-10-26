package com.tg.alex.cashquizztest.project.TournamentCategories.providers.inter;

/**
 * Created by Alex on 10/26/2017.
 *
 * Providers methods interface
 */

public interface IDataProvider<T> {
    void provide(final IDataListener<T> pDataListener);
}