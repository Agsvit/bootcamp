package com.example.bootcamp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChampionController {

    private ChampionService championService;

    @Autowired
    public ChampionController(ChampionService championService){
        this.championService = championService;
    }

    @GetMapping(value="champ-overview")
    public String getChampOverview(){
        return championService.getChampOverview();
    }
}
