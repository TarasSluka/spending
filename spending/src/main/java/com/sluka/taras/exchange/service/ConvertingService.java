package com.sluka.taras.exchange.service;

import org.apache.log4j.Logger;

public interface ConvertingService {
    Logger LOGGER = Logger.getLogger(ConvertingService.class);

    String getExchangeRate(String currency);

    boolean isValidCurrency(String currency);
}
