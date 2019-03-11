package regist;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingle {
    private ContainerSingle() {
    }

    private static Map<String, Object> container = new ConcurrentHashMap<String, Object>();

    public static Object getBean(String clazz) {
        Object obj = null;
        if (clazz != null) {
            if ((obj = container.get(clazz)) == null) {
                synchronized (container) {
                    if (!container.containsKey(clazz)) {
                        try {
                            obj = Class.forName(clazz).newInstance();
                            container.put(clazz, obj);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return obj;
    }
}
