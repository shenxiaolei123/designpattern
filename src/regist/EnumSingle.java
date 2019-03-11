package regist;

import java.util.List;

public enum EnumSingle {
    INSTANCE;
    public Object list = new Object();
    EnumSingle(){}
    EnumSingle(String s){
        System.out.println("构造");
    }
    public static  EnumSingle getInstance(){
        return INSTANCE;
    }
    public void set(List list){
        this.list = list;
    }
}
