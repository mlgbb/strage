package study.lang.Object;

public class Main {
    public static void main(String[] args) {
        TestObj zhu = new TestObj("朱", "武汉");
        TestObj guo = new TestObj("郭", "杨凌");
        TestObj guo1 = new TestObj("郭", "杨凌");
        TestObj zhu1 = new TestObj("朱", "湖北");

        System.out.println(zhu.equals(zhu1));
        System.out.println(guo.equals(guo1));
        System.out.println(zhu.equals(guo));

        System.out.println(guo.hashCode() + " ?  " + guo1.hashCode());
        System.out.println(zhu.toString());

    }
}
