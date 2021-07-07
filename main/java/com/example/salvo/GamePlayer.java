package com.example.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Entity
public class GamePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long gamePlayerid;
    private Date date;
    private String userName;

    public GamePlayer() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "salvoid")
    private Salvo salvo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gameid")
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shipid")
    private Ship ship;


    public long getGamePlayerid() {
        return gamePlayerid;
    }

    public GamePlayer(long gamePlayerid) {
        this.gamePlayerid = gamePlayerid;
    }


    public GamePlayer(Game game, Player player, Date date) {
        this.date = date;
        this.player = player;
        this.game = game;

    }


    public Player getPlayer() {
        return player;
    }

    public Game getGame() {
        return game;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToMany(mappedBy = "gamePlayer", fetch = FetchType.EAGER)
    Set<Ship> shipLocation = new HashSet<>();

    public Set<Ship> getShips() {
        return shipLocation;
    }

    public void addShip(Ship ship) {
        shipLocation.add(ship);
    }

    @OneToMany(mappedBy = "gamePlayer", fetch = FetchType.EAGER)
    Set<Salvo> SalvoLocation = new HashSet<>();

    public Set<Salvo> getSalvoes() {
        return SalvoLocation;
    }

    public void addSalvo(Salvo salvo) {
        SalvoLocation.add(salvo);
    }

    public Optional<Score> getScore(){
        return player.getScore(game);
    }



}















