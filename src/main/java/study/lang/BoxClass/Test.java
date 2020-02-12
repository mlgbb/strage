package study.lang.BoxClass;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Integer i = 1;//装箱
        int n = i;//拆箱
        // 数字链表
        List<Integer> list = new ArrayList<>();
        list .add(1);
        list.add(2);
        System.out.println(list);

        String str1 = "不可变的";
        StringBuffer str2 = new StringBuffer("线程安全的");
        StringBuilder str3 = new StringBuilder("速度最快的");

        System.out.println(str1+"\n" + str2 + "\n"+ str3);
        str2.append("v2");
        System.out.println("str2: "+str2);
        str3.insert(0,"v1");
        System.out.println("Str3:" + str3);
    }
}
