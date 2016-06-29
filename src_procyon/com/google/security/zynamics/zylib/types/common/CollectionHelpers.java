package com.google.security.zynamics.zylib.types.common;

import java.util.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.general.*;

public class CollectionHelpers
{
    public static boolean all(final Collection collection, final ICollectionFilter collectionFilter) {
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!collectionFilter.qualifies(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean any(final Collection collection, final ICollectionFilter collectionFilter) {
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (collectionFilter.qualifies(iterator.next())) {
                return true;
            }
        }
        return false;
    }
    
    public static int count(final Collection collection, final Object o) {
        int n = 0;
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == o) {
                ++n;
            }
        }
        return n;
    }
    
    public static int countIf(final Collection collection, final ICollectionFilter collectionFilter) {
        int n = 0;
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (collectionFilter.qualifies(iterator.next())) {
                ++n;
            }
        }
        return n;
    }
    
    public static List filter(final Collection collection, final ICollectionFilter collectionFilter) {
        final ArrayList<Object> list = new ArrayList<Object>();
        for (final Object next : collection) {
            if (collectionFilter.qualifies(next)) {
                list.add(next);
            }
        }
        return list;
    }
    
    public static Collection flatten(final Collection collection) {
        final ArrayList list = new ArrayList();
        final Iterator<Collection> iterator = collection.iterator();
        while (iterator.hasNext()) {
            list.addAll(iterator.next());
        }
        return list;
    }
    
    public static void iterate(final IIterableCollection collection, final ICollectionFilter collectionFilter, final IItemCallback itemCallback) {
        Preconditions.checkNotNull(collection, (Object)"Error: Graph argument can't be null");
        Preconditions.checkNotNull(itemCallback, (Object)"Error: Callback argument can't be null");
        Preconditions.checkNotNull(collectionFilter, (Object)"Error: Filter argument can't be null");
        collection.iterate(new CollectionHelpers$1(collectionFilter, itemCallback));
    }
    
    public static void iterate(final IIterableCollection collection, final IFilteredItemCallback filteredItemCallback) {
        collection.iterate(new CollectionHelpers$2(filteredItemCallback));
    }
    
    public static List map(final Collection collection, final ICollectionMapper collectionMapper) {
        final ArrayList<Object> list = new ArrayList<Object>();
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            list.add(collectionMapper.map(iterator.next()));
        }
        return list;
    }
    
    public static Object nth(final Collection collection, final ICollectionFilter collectionFilter, final int n) {
        int n2 = 0;
        for (final Object next : collection) {
            if (collectionFilter.qualifies(next)) {
                if (n2 == n) {
                    return next;
                }
                ++n2;
            }
        }
        throw new IllegalStateException("Error: nth element does not exist");
    }
    
    public static Pair unzip(final Collection collection) {
        final ArrayList<Object> list = new ArrayList<Object>(collection.size());
        final ArrayList<Object> list2 = new ArrayList<Object>(collection.size());
        for (final Pair pair : collection) {
            list.add(pair.first());
            list2.add(pair.second());
        }
        return new Pair(list, list2);
    }
}
