/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.sorters;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.types.AddressPairComparator;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AddressPairSorter {
    public static List getSortedList(Collection collection, ESide eSide) {
        Object object3;
        Object object22;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<Pair> arrayList2 = new ArrayList<Pair>();
        if (eSide == ESide.PRIMARY) {
            arrayList2.addAll(collection);
        } else {
            for (Object object22 : collection) {
                arrayList2.add(new Pair(object22.second(), object22.first()));
            }
        }
        ArrayList arrayList3 = new ArrayList();
        object22 = new ArrayList();
        for (Object object3 : collection) {
            if (object3.first() == null) {
                object22.add(object3);
                continue;
            }
            if (object3.second() == null) {
                arrayList3.add(object3);
                continue;
            }
            arrayList3.add(object3);
            object22.add(object3);
        }
        Collections.sort(arrayList3, new AddressPairComparator(ESide.PRIMARY));
        Collections.sort(object22, new AddressPairComparator(ESide.SECONDARY));
        if (arrayList3.size() == collection.size()) {
            arrayList.addAll(arrayList3);
        } else if (object22.size() == collection.size()) {
            arrayList.addAll((Collection<Object>)object22);
        } else {
            Object object4;
            int n2 = 0;
            object3 = new HashMap();
            Iterator iterator = object22.iterator();
            while (iterator.hasNext()) {
                object4 = (Pair)iterator.next();
                if (object4.first() != null && object4.second() != null) {
                    object3.put(object4.second(), n2);
                }
                ++n2;
            }
            int n3 = 0;
            object4 = arrayList3.iterator();
            while (object4.hasNext()) {
                Pair pair = (Pair)object4.next();
                if (pair.second() == null) {
                    arrayList.add(pair);
                    continue;
                }
                IAddress iAddress = (IAddress)pair.second();
                int n4 = (Integer)object3.get(iAddress);
                for (n2 = n3; n2 < n4; ++n2) {
                    Pair pair2 = (Pair)object22.get(n2);
                    arrayList.add(pair2);
                }
                arrayList.add(pair);
                n3 = n4 + 1;
            }
            for (n2 = n3; n2 < object22.size(); ++n2) {
                object4 = (Pair)object22.get(n2);
                arrayList.add(object4);
            }
        }
        if (eSide != ESide.SECONDARY) return arrayList;
        ArrayList arrayList4 = new ArrayList();
        object3 = arrayList.iterator();
        while (object3.hasNext()) {
            Pair pair = (Pair)object3.next();
            arrayList4.add(new Pair(pair.second(), pair.second()));
        }
        return arrayList4;
    }
}

