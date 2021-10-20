package com.example.bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampionService {
    private final StatsRepo statsRepo;
    private final SkillRepo skillRepo;

    @Autowired
    public ChampionService(StatsRepo statsRepo, SkillRepo skillRepo) {
        this.statsRepo = statsRepo;
        this.skillRepo = skillRepo;
    }

    public String getChampOverview() {
        return statsRepo.getStats() + skillRepo.getSkills();
    }
}
