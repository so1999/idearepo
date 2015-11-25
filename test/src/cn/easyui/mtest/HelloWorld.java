package cn.easyui.mtest;

/**
 * Created by Sun on 2015/10/31.
 */
public class HelloWorld {
    public static void main(String []args){
        System.out.println("HelloWorld");
        for(int i=0;i<=10;i++){
            System.out.println(i);
        }
        System.out.println(findName());
    }

    public static String findName(){
        return "hello";
    }
}
