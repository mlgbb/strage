package study.DataStructure;

import java.lang.reflect.Array;
import java.util.*;

public class CollectionStudy
{
    public static void main(String[] args){
        //1、arraryList
//        arrayList();
        
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
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        ((LinkedList<String>) list).offer("123"); //当作队列使用
        list.add(2,"2.5");
        ((LinkedList<String>) list).addFirst("0");
        ((LinkedList<String>) list).addLast("+∞");

        // 不改变原数组的最快遍历方式
        //  通过removeFirst()和removeLast()来遍历LinkedList 是最快的
        for (String integ:list){
            System.out.println(integ);
        }

        String [] arr = (String[])list.toArray(new String[0]);
        System.out.println(arr);
         arr[0] = "100";
        for (String x:arr){
            System.out.println(x);
        }
        System.out.println(list.size());
        list.clear();
        System.out.println(list.isEmpty());

        useLinkedListAsLIFO();

        useLinkedListAsFIFO();

    }

    private static void arrayList() {
        //1、定义一个arraryList
        ArrayList<Integer> testList = new ArrayList<Integer>();
        //2、给一个arraryList添加，删除元素
        testList.add(3); // 添加
        testList.add(999);
        testList.add(2019);
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
        // 需要注意的是如果remove的是对象 需要重写equals 和 hashcode 方法
        testList.removeIf((Integer e) -> 2019  == e);

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

        //默认是0 也可以进行指定
        ArrayList<Integer> integers = new ArrayList<>(); // 默认为0
        // 第一次添加后 DEFAULT_CAPACITY=10。

        ArrayList<String> arrayList = new ArrayList<>(20); //指定为20
        int [] a ={1,2,3,4,5};
        String atest = "I want to test it ";
        Collection<String> mySc = new ArrayList<String>(Arrays.asList("a","b","c"));
        ArrayList<String> collections = new ArrayList<String>(mySc); //用集合去初始化
        System.out.println(collections);

//         扩容的核心方法 grow();
//        ArrayList扩容的核心方法，此方法用来决定扩容量
//        当前数组是由自定义初始容量构造方法创建并且指定初始容量为0。此时minCapacity等于1那么根据下面逻辑可以看到最后数组的容量
//        会从0变成1。这边可以看到一个严重的问题，一旦我们执行了初始容量为0，那么根据下面的算法前四次扩容每次都 +1，
//        在第5次添加数据进行扩容的时候才是按照当前容量的1.5倍进行扩容。
//    private void grow(int minCapacity) {
//            // overflow-conscious code
//            int oldCapacity = elementData.length;
//            int newCapacity = oldCapacity + (oldCapacity >> 1);
//            if (newCapacity - minCapacity < 0)
//                newCapacity = minCapacity;
//            if (newCapacity - MAX_ARRAY_SIZE > 0)
//                newCapacity = hugeCapacity(minCapacity);
//            // minCapacity is usually close to size, so this is a win:
//            elementData = Arrays.copyOf(elementData, newCapacity);
//        }
//
//        private static int hugeCapacity(int minCapacity) {
//            if (minCapacity < 0) // overflow
//                throw new OutOfMemoryError();
//            return (minCapacity > MAX_ARRAY_SIZE) ?
//                    Integer.MAX_VALUE :
//                    MAX_ARRAY_SIZE;
//        }
//
//    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

        new CollectionStudy().demo();

    }

    private static void concurrentHashMap() {
    }

    private static void treeMap() {
    }

    private static void hashMap() {
    }
    // 泛型 快速失败机制
    private void demo(){
        //泛型
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // 快速失败机制
        Iterator<Integer> iterator1 = list.iterator();
        while (iterator1.hasNext()){
            int index = iterator1.next();
            list.remove(0);
        }
//        User user = new User();
        //匿名内部类
        List<Integer> linkedList = new LinkedList<Integer>(){{
            add(1);
        }};

    }
    private static void useLinkedListAsLIFO() {
        System.out.println("\nuseLinkedListAsLIFO");
        // 新建一个LinkedList
        LinkedList stack = new LinkedList();

        // 将1,2,3,4添加到堆栈中
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        // 打印“栈”
        System.out.println("stack:"+stack);

        // 删除“栈顶元素”
        System.out.println("stack.pop():"+stack.pop());

        // 取出“栈顶元素”
        System.out.println("stack.peek():"+stack.peek());

        // 打印“栈”
        System.out.println("stack:"+stack);
    }

    /**
     * 将LinkedList当作 FIFO(先进先出)的队列
     */
    private static void useLinkedListAsFIFO() {
        System.out.println("\nuseLinkedListAsFIFO");
        // 新建一个LinkedList
        LinkedList queue = new LinkedList();

        // 将10,20,30,40添加到队列。每次都是插入到末尾
        queue.add("10");
        queue.add("20");
        queue.add("30");
        queue.add("40");
        // 打印“队列”
        System.out.println("queue:"+queue);

        // 删除(队列的第一个元素)
        System.out.println("queue.remove():"+queue.remove());

        // 读取(队列的第一个元素)
        System.out.println("queue.element():"+queue.element());

        // 打印“队列”
        System.out.println("queue:"+queue);
    }
}

//内部类
class User{
    private String userName;
    private int age;
    private Ability ablity;
}

class Ability{

    private String swiming;
    private boolean play;
}
