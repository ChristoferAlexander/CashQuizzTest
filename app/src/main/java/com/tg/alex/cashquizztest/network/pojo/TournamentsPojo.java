package com.tg.alex.cashquizztest.network.pojo;

import com.google.gson.annotations.SerializedName;
import com.tg.alex.cashquizztest.project.models.Tournament;

import java.util.List;

/**
 * Created by Alex on 10/26/2017.
 */

public class TournamentsPojo {

    @SerializedName("tournaments")
    private List<Tournament> tournaments;

    public TournamentsPojo() {
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }
}
