
/**
 * 虚拟机栈和本地方法栈测试（作为第1点测试程序）
 *
 * VM Args: -Xss136k
 */
public class Code_2_4 {
    public static void main(String[] args) {
        JavaVMStackSOF.main();
    }
}

class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main() {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack Length:" + oom.stackLength);
            throw e;
        }
    }
}