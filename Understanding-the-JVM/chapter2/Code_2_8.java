


/**
 * 运行时常量池导致的内存溢出异常
 *
 * VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M
 */
public class Code_2_8 {
    public static void main(String[] args) {
        RuntimeConstantPoolOOM.main();
    }
}


class RuntimeConstantPoolOOM {

    public static void main() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}