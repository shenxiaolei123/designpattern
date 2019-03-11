package lazybones;

import java.io.Serializable;

public class LazyBonesSingle implements Serializable {
    private LazyBonesSingle(){}
    public static synchronized LazyBonesSingle getInstance(){
        return new LazyBonesSingle();
    }
}
