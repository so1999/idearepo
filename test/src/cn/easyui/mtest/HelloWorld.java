package cn.easyui.mtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun on 2015/10/31.
 */
public class HelloWorld {
    public static void main(String []args) {
        List list=new ArrayList();
        list.add(1);
        System.out.println(list.get(0));
        System.out.println(list.get(0) instanceof Integer);
    }
}
