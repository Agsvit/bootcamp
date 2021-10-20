package com.example.bootcamp;

import org.springframework.stereotype.Repository;

@Repository
public class SkillRepo {
    String skills = "Skill1";

    public String getSkills() {
        return skills;
    }
}
