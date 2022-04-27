package com.javaBasic.DesignPatterns.behavioral.ChainofResponsibility.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{

    List<Filter> filters = new ArrayList<Filter>();

    @Override
    public String dofilter(String msg) {
        String r = msg;
        for(Filter f : filters)
            r = f.dofilter(r);
        return r;
    }

    public FilterChain addFilter(Filter f){
        filters.add(f);
        return this;
    }

}

