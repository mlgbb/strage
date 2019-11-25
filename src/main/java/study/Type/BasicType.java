package study.Type;

public class BasicType {
    public static void main(String[] args) {
        //逻辑类型
        boolean male = true, on = true, off = false, noData;

        //整型 有符号的 最高位为符号位
        byte s = -12, tom = 88, 汉字 = 99, m;//不存在表示法  1个字节占8位，-2^7 ， 2^7-1
        //可以将一定范围内的int型值赋予给byte或者short

        short t = 12, q = 1234;//不存在表示法 占 2个字节  ， -2^15 ，2^15 - 1

        int x = 12, y = 129, z = -129;//占用4个字节的内存取值范围是-2^31 ， 2^31 - 1
        int k = 012;//八进制10
        int l = 0x0012;//十六进制18
        m = (byte) x; // m =12 正确的赋值，如果越界会发生什么呢？取模？向左？向右？
        m = (byte) y;   // m = -127 就是取模
        m = (byte) z; // m =127

        long width = 12L, height = 2000L;//占用8个字节， -2^63, 2^63 - 1
        long eight = 013L;//八进制 11
        long xx = 0xF;//十六进制  15

        //字符类型 2个字节 占用16位，无负数char 0-65535(2^16 - 1)
        char ch1 = 'A', home = '家';// 对于A 在Unicode表中的位置为65所以也可以写成
        char ch2 = 65; // ch1 = ch2   A-Z 65-90   a-z  97-122
        // \n(换行) \b(退格) \t(水平制表)
        System.out.println("字符H的位置 " + (int) 'X' + '\n' + "汉字郭的位置是：" + (int) '郭');

        //浮点类型
        float cc = 33.5f, tomCat = 22.2f, weight = 2e32F;//float在存储变量时保留8位有效数字(相对于double型被称之为单精度)
        //  分配4个字节内存，占32位
        //  这32位 分别由 1(符号位)+8(指数位)+23(尾数位)
//        float 指数范围为 -127 ~ +128  取值范围为  -2^128 ~  + 2^127

        double dd=23.8954234d,rr = 1e12;// double 分配8个字节内存，占64位
        // 这64位由 1(符号位)11(指数位)52(尾数位)构成
        // -2^1024 ~  + 2^1023
        //需要注意的是float型数据和double型数据在做比较的时候必须注意实际的精度 ，
        // 可能会出现 float x = 0.4f  double y = o.4;  y<x

    }
}


