package thredlocal;

public class ThreadLocalSingle {
   static ThreadLocal<ThreadLocalSingle> local  = new ThreadLocal<ThreadLocalSingle>(){
       @Override
       protected ThreadLocalSingle initialValue(){
            return new ThreadLocalSingle();
        }
    };
    private ThreadLocalSingle(){}
    public static ThreadLocalSingle getInstance(){
        return local.get();
    }
}
