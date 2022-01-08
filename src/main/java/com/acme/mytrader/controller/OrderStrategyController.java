package com.acme.mytrader.controller;


import com.acme.mytrader.domain.OrderStrategy;
import com.acme.mytrader.service.OrderStrategyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
○
@Slf4j
@RestController
@RequestMapping(path="/orderStrategy" , produces = { "application/json" } ) // Force the output format to JSON. ALso help to workaround issue with the some browser that does not specify the Media TYpe on GET
public class OrderStrategyController {


    // using the  Cart service + CarResourceAssembler to publish data
    private final OrderStrategyService orderStrategyService;

    public OrderStrategyController(OrderStrategyService orderStrategyService) {
        this.orderStrategyService = orderStrategyService;
    }


    /*********************************
     *
     * @param orderStrategy
     * @return
     * @throws URISyntaxException
     */
    @PostMapping
    ResponseEntity<?> post(@Valid @RequestBody OrderStrategy orderStrategy) throws URISyntaxException {

        OrderStrategy vorderStrategy = orderStrategyService.save(orderStrategy); // we save car into thr database via CarRepository that uses JPA (Crud)

        return new ResponseEntity<OrderStrategy>(vorderStrategy, HttpStatus.OK);

    }





    /**
     * Creates a list to store any vehicles.
     * @return list of vehicles
     */
    @GetMapping
    ResponseEntity<List<OrderStrategy>>  list() {
        List<OrderStrategy> orderStrategyList =orderStrategyService.list();

        return new ResponseEntity<List<OrderStrategy>>(orderStrategyList, HttpStatus.OK);
    }



    /**
     * Creates a list to store any vehicles.
     * @return list of vehicles
     */
    @GetMapping("/stock")
    ResponseEntity<List<OrderStrategy>> listperStock(String stock) {

        List<OrderStrategy> orderStrategyList =orderStrategyService.findByStockName(stock);

        return new ResponseEntity<List<OrderStrategy>>(orderStrategyList, HttpStatus.OK);
    }





    /***
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {

        orderStrategyService.delete(id);

        return ResponseEntity.noContent().build();
    }




    /**
     * Update the price on the move !
     * @return list of vehicles
     */
    @GetMapping("/updateprice")
    ResponseEntity<String> spawnPrice(String security, double price) {

        String ret = orderStrategyService.updatePrice(security,price);

        return new ResponseEntity<String>(ret, HttpStatus.OK);
    }






}
