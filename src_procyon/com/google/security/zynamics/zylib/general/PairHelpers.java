package com.google.security.zynamics.zylib.general;

import java.util.*;

public final class PairHelpers
{
    public static List projectFirst(final List list) {
        final ArrayList<Object> list2 = new ArrayList<Object>();
        final Iterator<Pair> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(iterator.next().first());
        }
        return list2;
    }
    
    public static List projectSecond(final List list) {
        final ArrayList<Object> list2 = new ArrayList<Object>();
        final Iterator<Pair> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(iterator.next().second());
        }
        return list2;
    }
}
