package com.javaBasic.DesignPatterns.behavioral.ChainofResponsibility.filter;



public class Test {

    public static void main(String[] args){

        String msg = "Today is raining. What a fucking day! :(";
        String msg2 = "Today is raining. What a beautiful day! ";

        FilterChain fc = new FilterChain();
        fc.addFilter(new SensitiveWordFilter())
                .addFilter(new StopWordFilter())
                .addFilter(new FaceFilter());

        String result = fc.dofilter(msg);
        System.out.println(msg);
        System.out.println(result);

        String result2 = fc.dofilter(msg2);
        System.out.println(msg2);
        System.out.println(result2);

    }

}

