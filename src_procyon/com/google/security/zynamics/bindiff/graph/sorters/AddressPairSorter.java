package com.google.security.zynamics.bindiff.graph.sorters;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.types.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;

public class AddressPairSorter
{
    public static List getSortedList(final Collection collection, final ESide eSide) {
        final ArrayList<Pair> list = new ArrayList<Pair>();
        final ArrayList<Object> list2 = new ArrayList<Object>();
        if (eSide == ESide.PRIMARY) {
            list2.addAll(collection);
        }
        else {
            for (final Pair pair : collection) {
                list2.add(new Pair(pair.second(), pair.first()));
            }
        }
        final ArrayList<Object> list3 = new ArrayList<Object>();
        final ArrayList<Pair> list4 = new ArrayList<Pair>();
        for (final Pair pair2 : collection) {
            if (pair2.first() == null) {
                list4.add(pair2);
            }
            else if (pair2.second() == null) {
                list3.add(pair2);
            }
            else {
                list3.add(pair2);
                list4.add(pair2);
            }
        }
        Collections.sort(list3, new AddressPairComparator(ESide.PRIMARY));
        Collections.sort((List<Object>)list4, new AddressPairComparator(ESide.SECONDARY));
        if (list3.size() == collection.size()) {
            list.addAll((Collection<?>)list3);
        }
        else if (list4.size() == collection.size()) {
            list.addAll((Collection<?>)list4);
        }
        else {
            int n = 0;
            final HashMap<Object, Integer> hashMap = (HashMap<Object, Integer>)new HashMap<Object, Object>();
            for (final Pair pair3 : list4) {
                if (pair3.first() != null && pair3.second() != null) {
                    hashMap.put(pair3.second(), n);
                }
                ++n;
            }
            int n2 = 0;
            for (final Pair pair4 : list3) {
                if (pair4.second() == null) {
                    list.add(pair4);
                }
                else {
                    final int intValue = hashMap.get(pair4.second());
                    for (int i = n2; i < intValue; ++i) {
                        list.add((Pair)list4.get(i));
                    }
                    list.add(pair4);
                    n2 = intValue + 1;
                }
            }
            for (int j = n2; j < list4.size(); ++j) {
                list.add((Pair)list4.get(j));
            }
        }
        if (eSide == ESide.SECONDARY) {
            final ArrayList<Pair> list5 = new ArrayList<Pair>();
            for (final Pair pair5 : list) {
                list5.add(new Pair(pair5.second(), pair5.second()));
            }
            return list5;
        }
        return list;
    }
}
