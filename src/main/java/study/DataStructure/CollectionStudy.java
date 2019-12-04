package study.DataStructure;

import java.util.*;

public class CollectionStudy {
    public static void main(String[] args){
        //1、arraryList
        arrayList();
        
        //2、linkedList
        linkedList();
        
        //3、HashMap
        hashMap();
        //4、TreeMap
        treeMap();

        //5、ConcurrentHashMap
        concurrentHashMap();
    }

    private static void linkedList() {
    }

    private static void arrayList() {
        //1、定义一个arraryList
        ArrayList<Integer> testList = new ArrayList<Integer>();
        //2、给一个arraryList添加，删除元素
        testList.add(3); // 添加
        testList.add(999);
        int i = 5;
        while(i>0){
            testList.add(3 + (int)(Math.random()*7));
            i--;
        }
        System.out.println("数组链表的长度" + testList.size());
        //3、查询
        testList.get(0); // 查询

        System.out.println(testList); //打印

        Iterator<Integer> iterator = testList.iterator();
        System.out.println("遍历"); //遍历
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        testList.set(0,555);
        System.out.println("现在第一位是"+testList.get(0));
        System.out.println("检测是否包含555：" + testList.contains(555)); // 查询是否包含
        testList.remove(0);
        Integer x = 999;
        testList.remove(x);
        iterator = testList.iterator();
        System.out.println("遍历");
        while(iterator.hasNext()){

            System.out.print(iterator.next()+" ");
        }
        System.out.println("排序后");
//        Collections.sort(testList);  排序，也可以自定义排序方式 对象可以有不同的排序规则
        testList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(testList);
//        testList.clear(); //删除所有元素
        //4、如何初始化arraryLsit的长度（默认长度是多少，达到多少开始扩容，每次扩大到原来的几倍）
        //默认是10 也可以进行指定
        ArrayList<String> arrayList = new ArrayList<>(20);
        

    }

    private static void concurrentHashMap() {
    }

    private static void treeMap() {
    }

    private static void hashMap() {
    }
}
