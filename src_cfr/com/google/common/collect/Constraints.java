/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints$ConstrainedCollection;
import com.google.common.collect.Constraints$ConstrainedList;
import com.google.common.collect.Constraints$ConstrainedListIterator;
import com.google.common.collect.Constraints$ConstrainedRandomAccessList;
import com.google.common.collect.Constraints$ConstrainedSet;
import com.google.common.collect.Constraints$ConstrainedSortedSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible
final class Constraints {
    private Constraints() {
    }

    public static Collection constrainedCollection(Collection collection, Constraint constraint) {
        return new Constraints$ConstrainedCollection(collection, constraint);
    }

    public static Set constrainedSet(Set set, Constraint constraint) {
        return new Constraints$ConstrainedSet(set, constraint);
    }

    public static SortedSet constrainedSortedSet(SortedSet sortedSet, Constraint constraint) {
        return new Constraints$ConstrainedSortedSet(sortedSet, constraint);
    }

    public static List constrainedList(List list, Constraint constraint) {
        Constraints$ConstrainedRandomAccessList constraints$ConstrainedRandomAccessList /* !! */ ;
        if (list instanceof RandomAccess) {
            constraints$ConstrainedRandomAccessList /* !! */  = new Constraints$ConstrainedRandomAccessList(list, constraint);
            return constraints$ConstrainedRandomAccessList /* !! */ ;
        }
        constraints$ConstrainedRandomAccessList /* !! */  = new Constraints$ConstrainedList(list, constraint);
        return constraints$ConstrainedRandomAccessList /* !! */ ;
    }

    private static ListIterator constrainedListIterator(ListIterator listIterator, Constraint constraint) {
        return new Constraints$ConstrainedListIterator(listIterator, constraint);
    }

    static Collection constrainedTypePreservingCollection(Collection collection, Constraint constraint) {
        if (collection instanceof SortedSet) {
            return Constraints.constrainedSortedSet((SortedSet)collection, constraint);
        }
        if (collection instanceof Set) {
            return Constraints.constrainedSet((Set)collection, constraint);
        }
        if (!(collection instanceof List)) return Constraints.constrainedCollection(collection, constraint);
        return Constraints.constrainedList((List)collection, constraint);
    }

    private static Collection checkElements(Collection collection, Constraint constraint) {
        ArrayList arrayList = Lists.newArrayList(collection);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            constraint.checkElement(e2);
        }
        return arrayList;
    }

    static /* synthetic */ Collection access$000(Collection collection, Constraint constraint) {
        return Constraints.checkElements(collection, constraint);
    }

    static /* synthetic */ ListIterator access$100(ListIterator listIterator, Constraint constraint) {
        return Constraints.constrainedListIterator(listIterator, constraint);
    }
}

