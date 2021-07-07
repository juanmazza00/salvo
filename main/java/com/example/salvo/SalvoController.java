package com.example.salvo;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoController {



    @Autowired
    private GameRepository repo;
    @Autowired
    private GamePlayerRepository gp;


    @GetMapping("/games")

    public Map<String, Object> getAllGamePlayers() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();

               dto.put("games", repo.findAll().stream().map(this::makeGameDTO).collect(Collectors.toList()));
               return dto;

    }


    private Map<String, Object> makeGamePlayerDTO(GamePlayer gamePlayer) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id",gamePlayer.getGamePlayerid());
        dto.put("player", makePlayerDTO(gamePlayer.getPlayer()));
      //  dto.put("scores", gamePlayer.getGame().getScore());
        return dto;
    }

    private Map<String, Object> makeGameDTO(Game game) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", game.getGameid());
        dto.put("created", game.getDate());
        dto.put("gamePlayers",game.getGamePlayers().stream().map(this::makeGamePlayerDTO).collect(Collectors.toList()));
        dto.put("scores", game.getGamePlayers().stream().map(this::makeScoreDTO).collect(Collectors.toList()));

        return dto;
    }

    private Map<String, Object> makeScoreDTO(GamePlayer gp){
        Map<String, Object> dto = new LinkedHashMap<>();
        var gps = gp.getScore();
        if (gps.isEmpty()) {
            dto.put("El juego no tiene puntajes.", "");
        }
        else {


            dto.put("player", gps.get().getPlayer().getUserid());
            dto.put("score", gps.get().getScore());
            dto.put("finishDate", gps.get().getFinishDate());
        }
        return dto;
    }

    private Map<String, Object> makePlayerDTO(Player player) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", player.getUserid());
        dto.put("email", player.getUserName());
      // dto.put("score", player.getScore());


        return dto;
    }


    @GetMapping ("/game_view/{gamePlayerid}")
    public Map<String, Object> getGameView(@PathVariable long gamePlayerid){
        GamePlayer gamePlayer= gp.getById(gamePlayerid);
        Map<String, Object> dto= makeGameDTO(gamePlayer. getGame());
        dto.put("ships", gamePlayer.getShips().stream().map(this::makeShipDTO).collect(Collectors.toList()));
        dto.put("salvoes", gamePlayer.getGame().getGamePlayers().stream().flatMap(sv -> sv.getSalvoes().stream().map(sp -> makeSalvoDTO(sp))).collect(Collectors.toList()));
        return dto;

    }

    private Map<String, Object> makeShipDTO(Ship ship){
       Map<String,Object> dto = new LinkedHashMap<String, Object>();
       dto.put("locations", ship.getShipLocation());
       dto.put("type", ship.getTypeShip());
       return dto;

    }

    private Map<String, Object> makeSalvoDTO(Salvo salvo){

        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("turn", salvo.getTurn());
        dto.put("player", salvo.getGamePlayer().getPlayer().getUserid());
        dto.put("locations", salvo.getSalvoLocation());

        return dto;
    }


    }




