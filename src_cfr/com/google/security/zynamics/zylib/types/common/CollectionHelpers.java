/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.common;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers$1;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers$2;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.types.common.ICollectionMapper;
import com.google.security.zynamics.zylib.types.common.IFilteredItemCallback;
import com.google.security.zynamics.zylib.types.common.IItemCallback;
import com.google.security.zynamics.zylib.types.common.IIterableCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionHelpers {
    public static boolean all(Collection collection, ICollectionFilter iCollectionFilter) {
        Object e2;
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (iCollectionFilter.qualifies(e2 = iterator.next()));
        return false;
    }

    public static boolean any(Collection collection, ICollectionFilter iCollectionFilter) {
        Object e2;
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!iCollectionFilter.qualifies(e2 = iterator.next()));
        return true;
    }

    public static int count(Collection collection, Object object) {
        int n2 = 0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (e2 != object) continue;
            ++n2;
        }
        return n2;
    }

    public static int countIf(Collection collection, ICollectionFilter iCollectionFilter) {
        int n2 = 0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (!iCollectionFilter.qualifies(e2)) continue;
            ++n2;
        }
        return n2;
    }

    public static List filter(Collection collection, ICollectionFilter iCollectionFilter) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (!iCollectionFilter.qualifies(e2)) continue;
            arrayList.add(e2);
        }
        return arrayList;
    }

    public static Collection flatten(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Collection collection2 = (Collection)iterator.next();
            arrayList.addAll(collection2);
        }
        return arrayList;
    }

    public static void iterate(IIterableCollection iIterableCollection, ICollectionFilter iCollectionFilter, IItemCallback iItemCallback) {
        Preconditions.checkNotNull(iIterableCollection, "Error: Graph argument can't be null");
        Preconditions.checkNotNull(iItemCallback, "Error: Callback argument can't be null");
        Preconditions.checkNotNull(iCollectionFilter, "Error: Filter argument can't be null");
        iIterableCollection.iterate(new CollectionHelpers$1(iCollectionFilter, iItemCallback));
    }

    public static void iterate(IIterableCollection iIterableCollection, IFilteredItemCallback iFilteredItemCallback) {
        iIterableCollection.iterate(new CollectionHelpers$2(iFilteredItemCallback));
    }

    public static List map(Collection collection, ICollectionMapper iCollectionMapper) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            arrayList.add(iCollectionMapper.map(e2));
        }
        return arrayList;
    }

    public static Object nth(Collection collection, ICollectionFilter iCollectionFilter, int n2) {
        int n3 = 0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (!iCollectionFilter.qualifies(e2)) continue;
            if (n3 == n2) {
                return e2;
            }
            ++n3;
        }
        throw new IllegalStateException("Error: nth element does not exist");
    }

    public static Pair unzip(Collection collection) {
        ArrayList<Object> arrayList = new ArrayList<Object>(collection.size());
        ArrayList<Object> arrayList2 = new ArrayList<Object>(collection.size());
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Pair pair = (Pair)iterator.next();
            arrayList.add(pair.first());
            arrayList2.add(pair.second());
        }
        return new Pair(arrayList, arrayList2);
    }
}

