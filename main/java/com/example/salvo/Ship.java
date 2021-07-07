package com.example.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long shipid;
    private String typeShip;

    @ElementCollection
    @Column(name = "ShipLocation")
    private List<String> ShipLocation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer")
    private GamePlayer gamePlayer;



    public Ship() {
    }

    public Ship(String typeShip, List<String> shipLocation, GamePlayer gamePlayer) {
        this.typeShip = typeShip;
        ShipLocation = shipLocation;
        this.gamePlayer = gamePlayer;

    }

    public Long getShipid() {
        return shipid;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public String getTypeShip() {
        return typeShip;
    }

    public void setTypeShip(String typeShip) {
        this.typeShip = typeShip;
    }

    public List<String> getShipLocation() {
        return ShipLocation;
    }

    public void setShipLocation(List<String> ShipLocation) {
        ShipLocation = ShipLocation;
    }


}