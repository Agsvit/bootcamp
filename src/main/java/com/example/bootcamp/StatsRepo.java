package com.example.bootcamp;

import org.springframework.stereotype.Repository;

@Repository
public class StatsRepo {
    String Stats = "Stat1";

    public String getStats() {
        return Stats;
    }
}
