package com.acme.mytrader.domain;

import com.acme.mytrader.side.Side;
import org.springframework.data.annotation.Immutable;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Immutable // Hibernate make the entity Immutable. As such Update will be ignored without throwing an exception
@Entity // JPA - Entities represent persistent data stored. here we use H2 as per the config
public class OrderStrategy {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    private   double priceLevel; // need for user to define price level to take action on
    private  String stock;  // needed for user to define which stock price to monitor (security == stock !)
    private  int volume; // needed for user to define the volume to buy
    private  Side side;  // needed for user to define the side to action on
    private  String strategyName; // user can define a name for each Strategy



    public OrderStrategy(double priceLevel, String stock, int volume, Side side, String strategyName, Long id) {
        this.priceLevel = priceLevel;
        this.stock = stock;
        this.volume = volume;
        this.side = side;
        this.id=id;
        this.strategyName=strategyName;
    }

    public OrderStrategy(){}



    //Here, for immutability, cloning the object is not needed as we are returning primitive and a String
    public double getPriceLevel() {
        return priceLevel;
    }

    public String getStock() {
        return stock;
    }

    public int getVolume() {
        return volume;
    }

    public Side getSide() {
        return side;
    }

    public long getId() {
        return id;
    }

    public String getStrategyName() {
        return strategyName;
    }



    @Override
    public String toString() {
        return "OrderStrategy{" +
                "id=" + id +
                ", priceLevel=" + priceLevel +
                ", stock='" + stock + '\'' +
                ", volume=" + volume +
                ", side=" + side +
                ", strategyName='" + strategyName + '\'' +
                '}';
    }


}
