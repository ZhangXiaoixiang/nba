package com.example.nba;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.nba.model.CompetitionPlatform;
import com.example.nba.model.Player;
import com.example.nba.model.PlayerRole;
import com.example.nba.model.Team;
import com.example.nba.repository.PlayerRep;
import com.example.nba.repository.TeamRep;
import com.example.nba.service.CompetitionPlatformService;
import com.example.nba.service.PalyerRoleService;
import com.example.nba.service.TeamService;
import com.example.nba.service.impl.CompetitionPlatformServiceImpl;
import com.mysql.cj.xdevapi.JsonArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NbaApplicationTests {
    @Autowired
    private CompetitionPlatformService service;
    @Autowired
    private TeamService teamService;
    @Autowired
    private PalyerRoleService palyerRoleService;
    @Autowired
    private PlayerRep playerRep;

    @Test
    public void contextLoads() {

    }

    /**
     * 查询测试jpa
     */
    @Test
    public void test1() {

        List<CompetitionPlatform> all1 = service.findAll();
        for (CompetitionPlatform competitionPlatform : all1) {
            System.out.println(competitionPlatform.toString());

        }
    }

    /**
     * 测试插入数据
     */
    @Test
    public void test2() {
        Team team = new Team();


        Team save = teamService.save(new Team("2", "3", 1, 23, 22, 12));
        System.out.println(save);

    }

    @Test
    public void test3() {
        List<Team> all = teamService.findAll();
        for (Team team : all) {
            System.out.println(team.toString());

        }
    }

    @Test
    public void test4() {
        PlayerRole ss = palyerRoleService.save(new PlayerRole(04, "ss"));
        System.out.println(ss.toString());
    }

    @Test
    public void test5() throws IOException {
        Document document = Jsoup.connect("https://news.zhibo8.cc/nba/more.htm").get();
        for (int i = 1; i < 16; i++) {
            String name = document.select("table[class=standings] tr").get(i).select("td").get(1).text();//球队名称
            Integer win = Integer.parseInt(document.select("table[class=standings] tr").get(i).select("td").get(2).text());//胜场数
            Integer bai = Integer.parseInt(document.select("table[class=standings] tr").get(i).select("td").get(3).text());//败场数
            Integer rank = Integer.parseInt(document.select("table[class=standings] tr").get(i).select("td").get(0).text());//排名
            Team team = new Team(i + "", name, 2, win, bai, rank);
            Team save = teamService.save(team);
            System.out.println("----------------");

        }

    }

    @Test
    public void test6() throws IOException {
        Document document = Jsoup.connect("https://news.zhibo8.cc/nba/more.htm").get();
        for (int i = 1; i < 16; i++) {
            String name = document.select("div[class=content]").eq(1).select("table[class=standings] tr").get(i).select("td").get(1).text();//球队名称
            Integer win = Integer.parseInt(document.select("div[class=content]").eq(1).select("table[class=standings] tr").get(i).select("td").get(2).text());//胜场数
            Integer bai = Integer.parseInt(document.select("div[class=content]").eq(1).select("table[class=standings] tr").get(i).select("td").get(3).text());//败场数
            Integer rank = Integer.parseInt(document.select("div[class=content]").eq(1).select("table[class=standings] tr").get(i).select("td").get(0).text());//排名
            Team team = new Team((i + 15) + "", name, 1, win, bai, rank);
            System.out.println(document.select("div[class=content]").eq(1).select("table[class=standings] tr").get(i).select("td").get(1).text());
            Team save = teamService.save(team);
            System.out.println("--------东部--------");

        }

    }

    /**
     * 获取球员的信息
     */
    @Test
    public void test7() throws IOException {
        System.out.println("---------------------------------------------------------");
        for (int i = 1; i < 51; i++) {
            Document document = Jsoup.connect("https://nba.hupu.com/stats/players/pts").get();
//            String text = document.select("table[class=players_table] tr").get(i).select("td").eq(0).text();//排名
            String name = document.select("table[class=players_table] tr").get(i).select("td").eq(1).text();//球员姓名
            String team = document.select("table[class=players_table] tr").get(i).select("td").eq(2).text();//球员球队
            String point = document.select("table[class=players_table] tr").get(i).select("td").eq(3).text();//球员得分
            System.out.println(name);
        }

    }

    /**
     * 获取球员的信息
     */
    @Test
    public void test8() throws Exception {
        System.out.println("---------------------------------------------------------\n\n\n");
        Document document = Jsoup.connect("https://data.zhibo8.cc/manage/public/app.php?_url=/nba/player_conditions")
                .ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                .timeout(5000).get();
        System.out.println("球员数据地址:   https://data.zhibo8.cc/nbaData/database/#/player_data");
        System.out.println("\n\n\n\n");
        JSONObject jsonObject = new JSONObject();
        JSONObject s = JSON.parseObject(document.text());
        System.out.println("原数据\n");
        System.out.println(document.text());
        System.out.println("\njson转换后的\n");
        System.out.println(s);
        System.out.println("\n获取指定KEY\n");
        JSONObject jsonObject1 = s.getJSONObject("data").getJSONObject("data");
        System.out.println(jsonObject1);
        System.out.println(jsonObject1.get("items"));
        System.out.println(jsonObject1.get("list"));
        List<Map<String, Object>> mapListJson = (List) jsonObject1.get("list");
        System.out.println(mapListJson.size());//排名
        for (Map<String, Object> map : mapListJson) {
            System.out.print(map.get("排名") + "  ");//暂时当做ID
            System.out.print(map.get("球员") + "  ");
            System.out.print(map.get("得分") + "\n");
//            存储球员信息到数据库
            Player player = new Player();
            player.setId(map.get("排名").toString());
            player.setName(map.get("球员").toString());
            player.setPoint(Float.valueOf((String) map.get("得分")));
            player.setTeam(Integer.parseInt(teamService.findByName(map.get("球队").toString()).getId()));
            player.setRebound(Float.valueOf(map.get("篮板").toString()));
            player.setAssist(Float.valueOf(map.get("助攻").toString()));
            player.setAssist(Float.valueOf(map.get("助攻").toString()));
            playerRep.save(player);
        }
        System.out.println("\n\n\n\n\n");
    }
    /**
     * 测试分页查询
     */
    @Test
    public void test9(){
        List<Player> byPage = playerRep.findByPage(0, 5);
        for (Player player : byPage) {
            System.out.println(player.toString());

        }
    }
    @Test
    public void test10() throws IOException {
        Document document = Jsoup.connect("https://www.layui.com/demo/table/user/").ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                .timeout(5000).get();
        System.out.println(document.text());
    }


}

