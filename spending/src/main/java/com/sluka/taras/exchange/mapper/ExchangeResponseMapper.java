package com.sluka.taras.exchange.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sluka.taras.exchange.ExchangeException;
import com.sluka.taras.exchange.model.ExchangeResponse;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ExchangeResponseMapper {

    private static final Logger LOGGER = Logger.getLogger(ExchangeResponseMapper.class);

    public static ExchangeResponse toEntity(String jsonString) {
        assert jsonString != null;
        LOGGER.debug("convert sting json object to java object");
        ExchangeResponse response = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            response = objectMapper.readValue(jsonString, ExchangeResponse.class);
        } catch (IOException e) {
            throw new ExchangeException("Unpredictable behavior by sharing service");
        }
        return response;
    }
}
