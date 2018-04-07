package com.oksana.zakharchenko.customenum;

import java.util.ArrayList;
import java.util.List;

public class AbstractCustomEnum<E extends AbstractCustomEnum<E>> implements Comparable<E> {

    private static int count = 0;
    private int num = 0;
    private final String name;
    private static List<AbstractCustomEnum> items = new ArrayList<>();

    public AbstractCustomEnum(String name) {
        this.name = name;
        items.add(this);
        num = count;
        count++;
    }

    public final String name() {
        return name;
    }

    public static AbstractCustomEnum[] values() {
        AbstractCustomEnum[] arr = new AbstractCustomEnum[items.size()];
        items.toArray(arr);
        return arr;
    }

    public static AbstractCustomEnum valueOf(String name) {
        if (name == null)
            return null;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).name.equals(name))
                return items.get(i);
        }
        return null;
    }




    public final int compareTo(E o) {
        AbstractCustomEnum<?> other = o;
        AbstractCustomEnum<E> self = this;
        if (self.getClass() != other.getClass())
            throw new ClassCastException();

        return items.indexOf(self) - items.indexOf(other);
    }

    public int ordinal() {
        return num;
    }

    @Override
    public String toString() {
        return name;
    }
}
