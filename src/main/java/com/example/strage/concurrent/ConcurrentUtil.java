package com.example.strage.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * @description:并发包
 * */
public class ConcurrentUtil {
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
        concurrentHashMap();
    }

    public static void concurrentHashMap(){
        new Thread(()->{
            map.put("a","1");
            concurrentHashMap.put("a","1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            map.put("b","2");
            concurrentHashMap.put("b","2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            map.put("c","3");
            concurrentHashMap.put("c","3");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(map.toString());
        System.out.println(concurrentHashMap.toString());

        /**
         * 输出：{a=1}
         * {a=1, b=2}
         *
         * */
    }
}
