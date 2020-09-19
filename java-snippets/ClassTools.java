import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


public class ClassTools {

    public static void main(String[] args) {
        System.out.println(new TopTest().toString());
        System.out.println(new SubTest().toString());
        /**
         * std output:
         *     TopTest[attr1=0,attr2=1][]
         *     SubTest[][attr1=2,attr2=3][]
         */
    }
}


/**
 * Provide an inheritable display overload method that shows
 * instance with their class name and a name=value pair for
 * each attribute stored on the instance itself (but not attrs
 * inherited from its classes). Can be mixed into any class,
 * and will work on any instance
 *
 */
interface AttrDisplay {

    /**
     * Converts an object to a string representation that lists all fields.
     *
     * @return a string with the object's class name and all field names and
     * values.
     */
    default String selfInspect() {
        Class cl = this.getClass();
        String r = cl.getName();
        // inspect the fields of this class and all superclasses
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            // get the names and values of all fields
            for (Field f : fields)
            {
                if (!Modifier.isStatic(f.getModifiers()))
                {
                    if(!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try
                    {
                        Class t = f.getType();
                        Object val = f.get(this);
                        if (t.isPrimitive()) r += val;
                        else r = val.toString();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl != null);
        return r;
    }

}

class TopTest implements AttrDisplay {
    private static int count = 0;

    private int attr1;
    private int attr2;

    public TopTest() {
        this.attr1 = TopTest.count;
        this.attr2 = TopTest.count + 1;
        TopTest.count += 2;
    }

    @Override
    public String toString() {
        return this.selfInspect();
    }
}

class SubTest extends TopTest {}