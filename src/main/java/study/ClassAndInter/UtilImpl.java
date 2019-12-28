package study.ClassAndInter;

public class UtilImpl implements UtilConstants{

    @Override
    public void talk(String s) {
        System.out.println("汪汪" + UtilConstants.front.name);
    }
}
