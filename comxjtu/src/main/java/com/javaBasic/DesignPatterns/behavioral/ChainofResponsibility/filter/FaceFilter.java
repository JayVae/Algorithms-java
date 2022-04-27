package com.javaBasic.DesignPatterns.behavioral.ChainofResponsibility.filter;

public class FaceFilter implements Filter {

    @Override
    public String dofilter(String msg) {
        return msg.replace(":(", "^V^");
    }
}
