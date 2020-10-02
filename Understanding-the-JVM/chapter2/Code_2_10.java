

import java.lang.reflect.Field;

import sun.misc.Unsafe;


/**
 * 使用unsafe分配本机内存
 *
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class Code_2_10 {
    public static void main(String[] args) throws Throwable {
        DirectMemoryOOM.main();
    }
}


class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main() throws Throwable {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}