import lazybones.DoubleCheckSingle;
import regist.ContainerSingle;
import regist.EnumSingle;
import lazybones.InnerClassSingle;
import thredlocal.ThreadLocalSingle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.rmi.server.ExportException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        for(int i=0;i<4;i++){
            new Thread(()->{
               // DoubleCheckSingle single = DoubleCheckSingle.getInstance();
/*                InnerClassSingle single =  InnerClassSingle.getInstance();
                System.out.println(single);*/
//                Object obj = ContainerSingle.getBean("regist.ContainerSingle");
//                System.out.println(obj);
              //  System.out.println(ThreadLocalSingle.getInstance());
            }).start();
        }
        System.out.println(EnumSingle.INSTANCE.list);
        System.out.println(EnumSingle.INSTANCE.list);
        System.out.println(EnumSingle.INSTANCE.list);
        System.out.println("--------------");
        System.out.println(Thread.currentThread().getName()+"-"+ThreadLocalSingle.getInstance());
        System.out.println(Thread.currentThread().getName()+"-"+ThreadLocalSingle.getInstance());
        System.out.println("--------------");

        try {
            Class clazz = EnumSingle.class;
//            Constructor c = clazz.getDeclaredConstructor();
////            c.newInstance();
            //1.8默认是找不到构造的
            Constructor c = clazz.getDeclaredConstructor(String.class);
            c.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            EnumSingle instance1 = null;
            EnumSingle instance2 = EnumSingle.getInstance();
            instance2.set(new ArrayList());
            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            oos.flush();
            oos.close();
            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance1 = (EnumSingle) ois.readObject();
            ois.close();
            System.out.println(instance1.list);
            System.out.println(instance2.list);
            System.out.println(instance1.list == instance2.list);
        }catch (Exception e){e.printStackTrace();}

        try {
            DoubleCheckSingle instance1 = null;
            DoubleCheckSingle instance2 = DoubleCheckSingle.getInstance();
            FileOutputStream fos = new FileOutputStream("InnerSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            oos.flush();
            oos.close();
            FileInputStream fis = new FileInputStream("InnerSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance1 = (DoubleCheckSingle) ois.readObject();
            ois.close();
            System.out.println(instance1);
            System.out.println(instance2);
            System.out.println(instance1 == instance2);
        }catch (Exception e){e.printStackTrace();}
    }
}
