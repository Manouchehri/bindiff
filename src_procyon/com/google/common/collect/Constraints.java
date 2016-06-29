package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible
final class Constraints
{
    public static Collection constrainedCollection(final Collection collection, final Constraint constraint) {
        return new Constraints$ConstrainedCollection(collection, constraint);
    }
    
    public static Set constrainedSet(final Set set, final Constraint constraint) {
        return new Constraints$ConstrainedSet(set, constraint);
    }
    
    public static SortedSet constrainedSortedSet(final SortedSet set, final Constraint constraint) {
        return new Constraints$ConstrainedSortedSet(set, constraint);
    }
    
    public static List constrainedList(final List list, final Constraint constraint) {
        return (list instanceof RandomAccess) ? new Constraints$ConstrainedRandomAccessList(list, constraint) : new Constraints$ConstrainedList(list, constraint);
    }
    
    private static ListIterator constrainedListIterator(final ListIterator listIterator, final Constraint constraint) {
        return new Constraints$ConstrainedListIterator(listIterator, constraint);
    }
    
    static Collection constrainedTypePreservingCollection(final Collection collection, final Constraint constraint) {
        if (collection instanceof SortedSet) {
            return constrainedSortedSet((SortedSet)collection, constraint);
        }
        if (collection instanceof Set) {
            return constrainedSet((Set)collection, constraint);
        }
        if (collection instanceof List) {
            return constrainedList((List)collection, constraint);
        }
        return constrainedCollection(collection, constraint);
    }
    
    private static Collection checkElements(final Collection collection, final Constraint constraint) {
        final ArrayList arrayList = Lists.newArrayList(collection);
        final Iterator<Object> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            constraint.checkElement(iterator.next());
        }
        return arrayList;
    }
}
