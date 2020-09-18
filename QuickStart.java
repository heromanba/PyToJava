
import java.util.*;


public class QuickStart {
    public static <E> E[] array(E... array) { return array; }
    public static void main(String[] args) {
        var superPair = new Pair<SuperClass>(new SubClass(), new SubClass());
        Pair<? super SuperClass> wildcardPair = superPair;
        wildcardPair.setFirst(new SubClass());
        Object a = wildcardPair.getFirst();
        System.out.println(a.getClass());
    }
}

class SuperClass
{

}
class SubClass extends SuperClass
{

}
class Pair<T>
{
    private T first;
    private T second;

    public Pair() { first = null; second = null; }
    public Pair(T first, T second) { this.first = first; this.second = second; }

    public T getFirst() { return first; }
    public T getSecond() { return second; }

    public void setFirst(T newValue) { first = newValue; }
    public void setSecond(T newValue) { second = newValue; }

    public static <T> void addAll(Collection<T> coll, T...ts)
    {
        for (T t : ts) coll.add(t);
    }

}


class ArrayAlg
{
    public static <T extends Comparable> T[] minmax(T... a)
    {
        if (a == null || a.length ==0) return null;
        var result = new Comparable[2];
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        result[0] = min;
        result[1] = max;
        return  (T[])result;
    }
}