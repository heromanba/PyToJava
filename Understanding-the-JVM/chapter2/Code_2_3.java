
import java.util.ArrayList;
import java.util.List;


/**
 * Java堆内存溢出异常测试
 *
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class Code_2_3 {
    public static void main(String[] args) {
        HeapOOM.main();
    }
}


class HeapOOM {

    static class OOMObject {}

    public static void main() {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}