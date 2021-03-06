

/**
 * 创建线程导致内存溢出异常
 *
 * VM Args: -Xss2M （这时候不妨设大些，请在32位系统下运行）
 */
public class Code_2_6 {

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM.main();
    }
}


class JavaVMStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main() throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
