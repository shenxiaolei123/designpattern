package lazybones;

public class InnerClassSingle {
    private InnerClassSingle (){}
    public static final InnerClassSingle getInstance(){
        return InnerClass.innerClassSingle;
    }
    private static final class InnerClass{
        protected  static  InnerClassSingle innerClassSingle = new InnerClassSingle();
    }
}
