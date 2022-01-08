package com.acme.mytrader;

//import com.acme.mytrader.price.StockPriceMonitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level, orders can be executed automatically
 * </pre>
 */
@Slf4j
@SpringBootApplication
public class PricingAlertServiceApp  {


    public static void main(String[] args) {
        SpringApplication.run(PricingAlertServiceApp.class, args);
    }


/*
    @Bean
    CommandLineRunner initTradingStrategy(TradingStrategy tradingStrategy) {
        return args -> {

            tradingStrategy.

        };
    }*/



}
