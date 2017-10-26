package com.tg.alex.cashquizztest.project.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Alex on 10/25/2017.
 */

public class TournamentCategory implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    private List<Tournament> tournaments;

    public TournamentCategory() {
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public List<Tournament> getTournamentsSortedByEndDate() {
        ArrayList<Tournament> sortedTournaments = new ArrayList<>();
        sortedTournaments.addAll(tournaments);

        Collections.sort(sortedTournaments, new Comparator<Tournament>() {
            public int compare(Tournament obj1, Tournament obj2) {
                // Descending order
                return Long.valueOf(obj1.getEndDateTimeStamp()).compareTo(obj2.getEndDateTimeStamp());
            }
        });

        return sortedTournaments;
    }

    public void setTournament(Tournament tournament) {
        if (tournaments == null)
            tournaments = new ArrayList<>();
        tournaments.add(tournament);
    }


}
