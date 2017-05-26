package com.sluka.taras.exchange.service.impl;

import com.sluka.taras.exchange.ExchangeException;
import com.sluka.taras.exchange.service.ConvertingService;
import com.sluka.taras.util.PropertyUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.sluka.taras.util.PropertyName.URL_TO_EXCHANGE_RATE;

public class ConvertingServiceImpl implements ConvertingService {
    private static final Logger LOGGER = Logger.getLogger(ConvertingServiceImpl.class);

    @Override
    public String getExchangeRate(String currency) {
        LOGGER.debug("get exchange rate from " + currency);
        String urlAddress = PropertyUtils.getProperty(URL_TO_EXCHANGE_RATE) + currency;
        HttpURLConnection connection = null;
        String res = null;
        URL url = null;
        try {
            url = new URL(urlAddress);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            res = getResponseFromConnection(connection);
            if (res == null) {
                throw new ExchangeException("Service to exchange not support this currency");
            }
        } catch (IOException e) {
            throw new ExchangeException("Exchange service error, check internet connection");
        }
        return res;
    }

    private String getResponseFromConnection(HttpURLConnection connection) throws IOException {
        LOGGER.debug("get response From Url:" + connection.getURL());
        StringBuilder sb = null;
        int status = connection.getResponseCode();
        switch (status) {
            case 200:
            case 201:
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
        }
        return sb != null ? sb.toString() : null;
    }

    @Override
    public boolean isValidCurrency(String currency) {
        LOGGER.debug("get exchange rate from " + currency);
        String urlAddress = PropertyUtils.getProperty(URL_TO_EXCHANGE_RATE) + currency;
        HttpURLConnection connection = null;
        URL url = null;
        try {
            url = new URL(urlAddress);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
        } catch (IOException e) {
            throw new ExchangeException("Check connection to the internet");
        }
        try {
            int status = connection.getResponseCode();
            if (status == 200 || status == 201) {
                return true;
            }
        } catch (IOException e) {
            throw new ExchangeException("Service to exchange is not available");
        }
        return false;
    }
}