package com.sluka.taras.exchange.model;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class ExchangeResponse {
    private Map<String, Double> rates = new HashMap<>();
    private String base;
    private Date date;
}
