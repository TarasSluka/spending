package com.sluka.taras.command;

public interface CommandReqExcConstant {
    String REQ_EX_START = "^";
    String REQ_EX_DATE
            = "(([0-9]{4})-((0[1-9]|1[0-2])|([1-9]))-(([1-9])|(\\d{2})))";
    //"(([0-9]{4})-([1-12]|\\d{2})-([1-31]|(\\d{2})))";
    /*"([0-9]{4}-([1-12]|(\\d{2}))-([1-31]|(\\d{2})))"*/
    //="(\\d{4}-\\d{2}-\\d{2})";
    String REQ_EX_SPLIT = "\\s";
    String REQ_EX_COST = "((\\d+(\\.\\d+)?))";
    String REQ_EX_CURRENCY = "(([A-Z]|[a-z]){3})";
    String REQ_EX_NAME = "((.)+)";       //[\w]|[\W]
    String REQ_EX_END = "$";

    String REQ_EX_ADD = "(add)";
    String REQ_EX_CLEAR = "(clear)";
    String REQ_EX_TOTAL = "(total)";
    String REQ_EX_EXIT = "(exit)";
    String REQ_EX_LIST = "(list)";

    String REQ_EX_CLEAR_ALL_COMMAND
            = REQ_EX_START
            + REQ_EX_CLEAR
            + REQ_EX_END;

    String REQ_EX_LIST_COMMAND
            = REQ_EX_START
            + REQ_EX_LIST
            + REQ_EX_END;
    String REQ_EX_EXIT_COMMAND
            = REQ_EX_START
            + REQ_EX_EXIT
            + REQ_EX_END;
    String REQ_EX_TOTAL_COMMAND
            = REQ_EX_START
            + REQ_EX_TOTAL
            + REQ_EX_SPLIT
            + REQ_EX_CURRENCY
            + REQ_EX_END;
    String REQ_EX_CLEAR_BY_DATE_COMMAND
            = REQ_EX_START
            + REQ_EX_CLEAR
            + REQ_EX_SPLIT
            + REQ_EX_DATE
            + REQ_EX_END;
    String REQ_EX_ADD_COMMAND
            = REQ_EX_START
            + REQ_EX_ADD
            + REQ_EX_SPLIT
            + REQ_EX_DATE
            + REQ_EX_SPLIT
            + REQ_EX_COST
            + REQ_EX_SPLIT
            + REQ_EX_CURRENCY
            + REQ_EX_SPLIT
            + REQ_EX_NAME
            + REQ_EX_END;
}
