package com.example.nba.controller.pre;

import com.example.nba.model.Player;
import com.example.nba.repository.PlayerRep;
import com.example.nba.service.PlayerService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PlayerApi
 *
 * @author 10905 2019/1/2
 * @version 1.0
 */
@RestController()
@RequestMapping("pre/player")
public class PlayerApiPre {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerRep playerRep;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public Object findAll(Model model,Integer startPage,Integer pageSize) {
        System.out.println("-------------------------PlayerApi------------------findAll");
//        分页逻辑(不用判断,layui已经帮我们搞定细节了)
        List<Player> players = playerRep.findByPage((startPage-1)*pageSize,pageSize);
        Map<String, Object > map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
//        一个多少条
        map.put("count",playerRep.findAll().size());
        map.put("data",players);
        return map;
    }


}
