package com.example.nba.controller;

import com.example.nba.model.Player;
import com.example.nba.repository.PlayerRep;
import com.example.nba.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * PlayerApi
 *
 * @author 10905 2019/1/2
 * @version 1.0
 */
@Controller()
@RequestMapping("/player")
public class PlayerApi {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerRep playerRep;
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public String findAll(Model model){
        System.out.println("-------------------------PlayerApi------------------findAll");
        List<Player> players = playerRep.orderByPoint();
        model.addAttribute("players",players);
        return "index";
    }

}
