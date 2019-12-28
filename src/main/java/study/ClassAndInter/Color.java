package study.ClassAndInter;

public enum Color {
    WHITE("#FFFFFF"), // 相当于实例
    BLACK("#000000"),
    RED("#FF0000");

    private String color;

//枚举被设计成是单例模式，即枚举类型会由JVM在加载的时候，
    // 实例化枚举对象，你在枚举类中定义了多少个就会实例化多少个，
    // JVM为了保证每一个枚举类元素的唯一实例，是不会允许外部进行new的，
    // 所以会把构造函数设计成private，防止用户生成实例，破坏唯一性。

    Color(String color) {
        this.color = color;
    }

    private String getColor() {
        return color;
    }

    public static void main(String[] args) {
        System.out.println(Color.BLACK.toString());
        Color[] color = Color.values();
        for (Color C : color) {
            System.out.println(C + ":" + C.getColor());
        }
    }
}
