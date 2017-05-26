package com.sluka.taras.command.impl;

import com.sluka.taras.command.CommandReqExcConstant;
import com.sluka.taras.data.jaxb.impl.StorageServiceImpl;
import com.sluka.taras.data.model.Item;
import com.sluka.taras.data.model.ItemsByDate;
import com.sluka.taras.data.storage.StorageService;
import com.sluka.taras.exchange.mapper.ExchangeResponseMapper;
import com.sluka.taras.exchange.model.ExchangeResponse;
import com.sluka.taras.exchange.service.ConvertingService;
import com.sluka.taras.exchange.service.impl.ConvertingServiceImpl;
import com.sluka.taras.out.OutService;
import com.sluka.taras.out.impl.OutConsoleServiceImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class TotalCommand extends AbstractCommand {
    private static final Logger LOGGER = Logger.getLogger(TotalCommand.class);
    private final String reqEx = CommandReqExcConstant.REQ_EX_TOTAL_COMMAND;
    private ConvertingService convertingService = new ConvertingServiceImpl();
    private StorageService storageService = new StorageServiceImpl();
    private OutService outService = new OutConsoleServiceImpl();

    public TotalCommand() {
        super.reqEx = reqEx;

    }

    @Override
    public void execute(String request) {
        LOGGER.debug("execute total command");
        String parameter = getParameterCommand(request);
        String s = convertingService.getExchangeRate(parameter);
        ExchangeResponse exchangeResponse = ExchangeResponseMapper.toEntity(s);
        Double res = calculate(storageService.getSpent().getListItem(), exchangeResponse);
        System.out.println(("\t" + roundDouble(res)));
    }

    private double roundDouble(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private Double calculate(List<ItemsByDate> items, ExchangeResponse exchangeResponse) {
        Double res = 0.0;
        for (ItemsByDate itemsByDate : items) {
            for (Item item : itemsByDate.getItem()) {
                if (item.getCurrency().equals(exchangeResponse.getBase()))
                    res += item.getCost();
                else {
                    res += (item.getCost() * 1 / exchangeResponse.getRates().get(item.getCurrency()));
                }
            }
        }
        return res;
    }
}