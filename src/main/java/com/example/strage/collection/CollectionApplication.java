package com.example.strage.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionApplication {

    public static void main(String[] args){
        listApplication();
    }

    private static void listApplication(){
        List<String> list1 = new ArrayList<String>(){{
            add("a");
            add("b");
            add("c");
            add("d");
            add("e");
        }};

        List<String> list2 = new ArrayList<String>(){{
           add("a");
           add("b");
        }};
        //交集
//        list1.retainAll(list2);
//        list1.forEach(s->{System.out.println(s);});
//        if (list1.retainAll(list2)){
//            System.out.println("list1中包含了list2");
//        }
        //差集
        list1.retainAll(list2);
        list1.removeAll(list2);
        list1.forEach(s->{System.out.println(s);});
    }
}
