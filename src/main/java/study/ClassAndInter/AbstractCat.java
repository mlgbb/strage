package study.ClassAndInter;

public  abstract class AbstractCat {
    private  String name;
    private  Integer averAge;
    abstract void talk();
    public void run(){
        System.out.println("我会跑");
    }
    public void eat(){
        System.out.println("我会吃东西");
    }

}
class Cat extends AbstractCat{

    @Override
    void talk() {
        System.out.println("喵喵喵");
    }
    public void skill(){
        System.out.println("我能抓老鼠");
    }
}
class demo{
    public static void main(String[] args) {
        AbstractCat cat = new Cat();
        cat.talk();
        cat.eat();
        Cat cat2 = (Cat)cat;
        cat2.skill();
        cat2.run();
    }
}
