package lazybones;

import java.io.Serializable;

public class DoubleCheckSingle implements Serializable {
    private volatile static DoubleCheckSingle single = null;
    private DoubleCheckSingle(){}
    public static DoubleCheckSingle getInstance(){
        if(single ==null){
            synchronized(DoubleCheckSingle.class){
                if(single == null) single = new DoubleCheckSingle();
            }
        }
        return single;
    }
    private Object readResolve(){
        return single;
    }
}
