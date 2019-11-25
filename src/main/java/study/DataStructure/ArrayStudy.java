package study.DataStructure;

public class ArrayStudy {
    public static void main(String[] args) {
        // 数组 线型的序列可以快速的访问其他元素，数组在创建后容量是不变的也就是说固定了一个length
        // 并且在运行的时候会用这个length去做越界检查
        // 初始化一个数组 数据类型 [] 数组名称 = new 数据类型[长度];
        // 数组访问时 通过下标索引来完成 范围是 0~length-1
        // 遍历数组的话一般会用for循环来完成
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        for (int key : a) {
            System.out.println(key);
        }
        // 数组属于引用数据类型
        //引用传递的本质也一定是：同一块堆内存空间可以被不同的栈内存所指向。
        int temp[] = a;
        temp[2] = 99;
        System.out.println(a[2]);
        //先开辟空间再做初始化称之为 动态初始化 当然也可以进行静态初始化
        int b[] = {1, 2, 3, 4, 5};
        for (int i =0;i<b.length;i++){
            System.out.println("b["+i+"]"+"="+b[i]);
        }
        //当然也可以使用匿名数组这个概念 如：
        System.out.println(new int[]{1,2,3,4,5}.length);

        //当然缺陷也很明了，就是长度固定

        //二维数组

        int aa[][] = new int[3][3];
        for(int i =0;i<aa.length;i++){
            for(int j =0;j<aa[0].length;j++){
                aa[i][j] = (i+1)*(j+1);
            }
        }
        for(int i =0;i<aa.length;i++){
            for(int j =0;j<aa[0].length;j++){
                System.out.print(aa[i][j]+" ");
            }
            System.out.println();
        }

    }
}
