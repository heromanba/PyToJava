
import java.time.*;
import java.lang.reflect.*;
import java.util.Date;


public class PairTest {
    public static void main(String[] args) {
        Employee ep1 = new Employee("ep1", 1);
        Employee ep2 = new Employee("ep2", 2);

        /**
         * 8.5.2 转换泛型表达式
         * source code in .java file:
         * ```java
         * Pair<Employee> buddies = new Pair<>(ep1, ep2);
         * Employee budy = buddies.getFirst();
         * ```
         * decompiled .class file, bytecode version: 55.0:
         * ```java
         * Pair var3 = new Pair(var1, var2);
         * Employee var4 = (Employee)var3.getFirst();
         * ```
         *
         * if first is public, source code in .java file:
         * ```java
         * Employee buddy = buddies.first;
         * ```
         * decompiled .class file, bytecode version: 55.0:
         * ```java
         * Employee var5 = (Employee)var3.first;
         * ```
         */

        /**
         * 8.5.3 转换泛型方法
         *
         * source code in .java file:
         * ```java
         * Class DateIntervalClass = DateInterval.class;
         * Method[] methods = DateIntervalClass.getDeclaredMethods();
         * for (Method method : methods)
         *     System.out.println(method.toString());
         *
         * LocalDate ld1 = LocalDate.now();
         * LocalDate ld2 = LocalDate.now();
         *
         * var interval = new DateInterval(ld1, ld2);
         * Pair<LocalDate> pair = interval;
         *
         * pair.setFirst(ld1);
         * pair.setSecond(ld2);
         * ```
         *
         * stdout:
         * ```
         * public java.lang.Object DateInterval.getSecond()
         * public java.time.LocalDate DateInterval.getSecond()
         * public void DateInterval.setSecond(java.time.LocalDate)
         * public void DateInterval.setSecond(java.lang.Object)
         * ```
         */














    }
}


class Pair<T>
{
    public T first;
    private T second;

    public Pair() { first = null; second = null; }
    public Pair(T first, T second) { this.first = first; this.second = second; }

    public T getFirst() { return first; }
    public T getSecond() { return second; }

    public void setFirst(T newValue) { first = newValue; }
    public void setSecond(T newValue) { second = newValue; }
}


class DateInterval extends Pair<LocalDate>
{
    public DateInterval(LocalDate ld1, LocalDate ld2) { super(ld1, ld2); }

    public void setSecond(LocalDate second)
    {
        if (second.compareTo(getFirst()) >= 0)
            super.setSecond(second);
    }

    public LocalDate getSecond() { return (LocalDate) super.getSecond(); }
}


class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }
}


class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary)
    {
        super(name, salary);
        bonus = 0;
    }
}