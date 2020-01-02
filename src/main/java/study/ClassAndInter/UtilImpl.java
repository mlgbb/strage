package study.ClassAndInter;

public class UtilImpl implements UtilConstants{

    @Override
    public void talk(String s) {
        System.out.println("汪汪" + UtilConstants.front.name);
        int x =1,y=2;
        int index [] = new int[]{x, y};
        System.out.println(index);
    }

}