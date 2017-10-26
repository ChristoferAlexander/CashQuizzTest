package com.tg.alex.cashquizztest.network.pojo;

import com.google.gson.annotations.SerializedName;
import com.tg.alex.cashquizztest.project.models.TournamentCategory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alex on 10/26/2017.
 */

public class TournamentCategoriesPojo implements Serializable {

    @SerializedName("categories")
    private List<TournamentCategory> tournamentCategories;

    public TournamentCategoriesPojo() {
    }

    public List<TournamentCategory> getTournamentCategories() {
        return tournamentCategories;
    }
}
