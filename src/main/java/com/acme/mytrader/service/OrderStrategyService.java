package com.acme.mytrader.service;

import com.acme.mytrader.domain.OrderStrategy;
import com.acme.mytrader.domain.OrderStrategyRepository;
import com.acme.mytrader.execution.ExecutionManager;
import com.acme.mytrader.strategy.TradingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class OrderStrategyService  {


    private OrderStrategyRepository orderStrategyRepository;


    public OrderStrategyService(OrderStrategyRepository orderStrategyRepository) {
        this.orderStrategyRepository = orderStrategyRepository;
    }

    /**
     * Either save the orderStrategy into the orderStrategyRepository
     * @param orderStrategy object, which can be either new or existing
     * @return the new/updated orderStrategy is stored in the repository
     */
    public OrderStrategy save(OrderStrategy orderStrategy ){

        return orderStrategyRepository.save(orderStrategy);

    }



    /**
     * delete the orderStrategy into the orderStrategyRepository
     * @param  id
     * @return void
     */
    public void delete(Long id ){

        OrderStrategy orderStrategy = orderStrategyRepository.findById(id).orElseThrow(objectNotFoundException::new);

        orderStrategyRepository.deleteById(id);
    }





    /**
     * Gathers a list of all orderStrategy
     * @return a list of all orderStrategy in the orderStrategyRepository
     */
    public List<OrderStrategy> list() {
        return orderStrategyRepository.findAll();
    }







    /**
     * Gathers a list of all orderStrategy per stock
     * @return a list of all orderStrategy in the orderStrategyRepository per stock
     */
    public List<OrderStrategy> findByStockName(String stock) {

        return orderStrategyRepository.findByStockName(stock);
    }





    /**
     *   Execute the Strategy as defined by OrderStrategy
     * @param security
     * @param price
     */
    public String updatePrice(String security, double price) {

        List<OrderStrategy> orderStrategyList = orderStrategyRepository.findByStockName(security);
        List<TradingStrategy> tradingStrategyList= new ArrayList<>();
        orderStrategyList.forEach( x -> tradingStrategyList.add(   new TradingStrategy(x,new ExecutionManager())  )  );

        for (TradingStrategy tr : tradingStrategyList) {  // execute each Strategy for each stock
            tr.priceUpdate(security,price);
        }

        return "price updated";

    }






}
