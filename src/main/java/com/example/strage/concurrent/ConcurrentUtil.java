package com.example.strage.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * @description:并发包
 * */
public class ConcurrentUtil implements Runnable{
    /**
     * 1、ConcurrentHashMap:并发版HashMap
     * 2、CopyOnWriteArrayList:并发版ArrayList
     * 3、CopyOnWriteArraySet：并发版Set
     * 4、ConcurrentLinkedQueue:并发队列（基于链表）
     * 5、ConcurrentLinkedDeque:并发队列（基于双向链表）
     * 6、ConcurrentSkipListMap:基于跳表的并发Map
     * 7、ConcurrentSkipListSet:基于调表的并发set
     * 8、ArrayBlockingQueue:阻塞队列（基于数组）
     * 9、LinkedBolckQueue：阻塞队列（基于链表）
     * 10、LinkedBlockingDeque:阻塞队列（基于双向链表）
     * 11、PriorityBolckingQueue:线程安全的优先队列
     * 12、SynchronousQueue:读写成对的队列
     * 13、LinkedTransferQueue：基于链表的数据交换队列
     * 14、DelayQueue:延时队列
     * */
    static Map<String,String> map = new HashMap<>();
    static ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args){
        concurrentHashMap1();
//        try {
//            concurrentHashMap2();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void concurrentHashMap1(){
         Map<String,String> map1 = new HashMap<>();
         ConcurrentHashMap<String,String> concurrentHashMap2 = new ConcurrentHashMap<>();

        new Thread(()->{
            map1.put("a","1");
            concurrentHashMap2.put("a","1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            map1.put("b","2");
            concurrentHashMap2.put("b","2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



//        new Thread(()->{
//            map.put("c","3");
//            concurrentHashMap.put("c","3");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        System.out.println(map1.toString());
        System.out.println(concurrentHashMap2.toString());
        /**
         * 输出：{a=1}
         * {a=1, b=2}
         *
         * */
    }

    public static void concurrentHashMap2() throws InterruptedException {
        Map<String,String> map = new HashMap<>();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String,String> map3 = new HashMap<>();
        Thread t1 = new Thread();
        t1.start();
        map.put("a","1");
        concurrentHashMap.put("a","1");
        Thread.currentThread().sleep(10000);

        Thread t2 = new Thread();
        t2.start();
        map.put("b","2");
        concurrentHashMap.put("b","2");

        map3.put("c","3");

        System.out.println(map.toString());
        System.out.println(concurrentHashMap.toString());
        System.out.println(map3.toString());
    }

    @Override
    public void run() {
        
    }
}
