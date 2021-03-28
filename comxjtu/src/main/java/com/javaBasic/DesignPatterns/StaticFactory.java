package com.javaBasic.DesignPatterns;

/**
 * @Author: Jay
 * @Date: Created in 15:52 2019/1/25
 * @Modified By:
 */
interface food{}

class A implements food{}
class B implements food{}
class C implements food{}

public class StaticFactory {

    private StaticFactory(){}

    public static food getA(){  return new A(); }
    public static food getB(){  return new B(); }
    public static food getC(){  return new C(); }
}

class Client{
    //客户端代码只需要将相应的参数传入即可得到对象
    //用户不需要了解工厂类内部的逻辑。
    public void get(String name){
        food x = null ;
        if ( name.equals("A")) {
            x = StaticFactory.getA();
        }else if ( name.equals("B")){
            x = StaticFactory.getB();
        }else {
            x = StaticFactory.getC();
        }
    }
}
