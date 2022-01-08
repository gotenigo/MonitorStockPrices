package com.acme.mytrader.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(path = "orderStrategy")
public interface OrderStrategyRepository  extends JpaRepository<OrderStrategy, Long> {


    @Query("SELECT o FROM OrderStrategy o  WHERE o.stock= (:stockname)")
    List<OrderStrategy> findByStockName(@Param("stockname") String stockname);



}
