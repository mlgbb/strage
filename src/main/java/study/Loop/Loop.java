package study.Loop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Loop {
    public static void main(String[] args) {
        // while循环 只要括号中的表达式条件为真就会一直循环下去

//        int x = 10, count = 0;
//        while (x < 18) {
//            System.out.println("x: " + x);
//            x++;
//            count++;
//        }
//        System.out.println("共循环了" + count + "次");

        //do{
//  //代码语句
//  }while（布尔值表达式）；

//  注意：布尔表达式在循环体的后面，所以语句块在检测布尔表达式之前已经执行了。如果布尔表达式值为true，则语句块
//一直执行，直到布尔表达式的值为false。

//  实例:

//        int xx = 21;
//        do {
//            System.out.print("value of x :" + xx);
//            xx++;
//            System.out.print("\n");
//        } while (xx < 20);

        //for (  1初始化;  2布尔表达式; 4更新){
        //代码语句
        //} for 循环  //1，最先执行初始化步骤。可以声明一种类型，但可初始化一个或多个循环控制变量，也可以是空语句。
        //    //2，然后，检测布尔表达式的值。如果是true，循环体被执行，如果是false，循环体终止，开始执行循环后面的语句。
        //    //3，执行一次循环后，更新循环控制变量。
        //    //4，再次检测布尔表达式。循环执行上面的过程

//        for (int y = 0; y < 5; y++) {
//            System.out.println("y的值为" + y);
//        }

        // 增强for循环
        //for(声明语句：表达式){
        //代码句子
        //}
        //声明语句：声明新的局部变量，该变量的类型必须和数组元素的类型匹配。其作用域限定在循环语句块
        //其值与此时数组元素的值相等。
        //表达式：表达式是要访问的数组名，或者是返回值为数组的方法。
//
//        int a[] = {0, 1, 2, 3, 4};
//        for (int key : a) {
//            System.out.println("2k=" + key * 2);
//        }

        // break break主要用在循环语句或者switch语句中，用来跳出整个语句块。
        //    break跳出最里面的循环，并且继续执行该循环下面的语句。

//        for (int q = 0; q < a.length; q++) {
//            if (a[q] == 3) {
//                break;
//            }
//            System.out.println(q);
//        }
//        System.out.println("break");

        //contiue
        //continue 适用于任何循环控制结构中。作用是让程序立刻跳到下一次循环的迭代。
        //在for循环中，continue语句使程序立即跳转到更新语句。
        //在while或者do...while循环中，程序立即跳转到布尔表达式的判断语句。

//        for (int q = 0; q < a.length; q++) {
//            if (a[q] == 3) {
//                continue;
//            }
//            System.out.println(q);
//        }
//        System.out.println("continue");


        //迭代器
        iterator();

        //swtch..case
        switchCase();
    }

    private static void iterator(){
        //next() 返回当前元素，并指向下一个元素
        //hasNext(),则是判断是否还有下一个元素
        List<String> list = new ArrayList<String>();
        list.add("张三");list.add("李四");list.add("王麻子");
        Iterator <String> listIt = list.iterator();
        while (listIt.hasNext()){
            System.out.println(listIt.next());
        }
    }
    private static void switchCase(){
        String demo = "bb";
        switch (demo) {
            case "1": System.out.println("找到了1");break;
            case "aa": System.out.println("找到了aa");break;
            case "bb": System.out.println("找到了bb");
            case "cc": System.out.println("肯定会到cc");return;
            case "dd": System.out.println("除非输入dd 否则不会到这里 当前输入："+demo);
            default:
                System.out.println("什么都没有找到");break;

        }
    }
}
