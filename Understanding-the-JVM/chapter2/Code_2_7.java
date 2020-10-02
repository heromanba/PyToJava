
import java.util.HashSet;
import java.util.Set;


/**
 * 运行时常量池导致的内存溢出异常
 *
 * VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M
 */
public class Code_2_7 {
    public static void main(String[] args) {
        RuntimeConstantPoolOOM.main();
    }
}


class RuntimeConstantPoolOOM {

    public static void main() {
        // 使用Set保持常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();

        // 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}