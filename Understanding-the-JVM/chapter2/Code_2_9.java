/**
 * 借助CGLib使得方法区出现内存异常
 *
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class Code_2_9 {
    public static void main(String[] args) {
        JavaMethodAreaOOM.main();
    }
}


class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
        }
    }
}