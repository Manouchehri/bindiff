/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general;

import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PairHelpers {
    public static List projectFirst(List list) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Pair pair = (Pair)iterator.next();
            arrayList.add(pair.first());
        }
        return arrayList;
    }

    public static List projectSecond(List list) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Pair pair = (Pair)iterator.next();
            arrayList.add(pair.second());
        }
        return arrayList;
    }
}

