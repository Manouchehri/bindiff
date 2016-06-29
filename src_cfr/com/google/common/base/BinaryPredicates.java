/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.BinaryPredicate;
import com.google.common.base.BinaryPredicates$AlwaysFalse;
import com.google.common.base.BinaryPredicates$AlwaysTrue;
import com.google.common.base.BinaryPredicates$And;
import com.google.common.base.BinaryPredicates$Equality;
import com.google.common.base.BinaryPredicates$First;
import com.google.common.base.BinaryPredicates$Identity;
import com.google.common.base.BinaryPredicates$Not;
import com.google.common.base.BinaryPredicates$Or;
import com.google.common.base.BinaryPredicates$Second;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GoogleInternal
@GwtCompatible
public final class BinaryPredicates {
    private BinaryPredicates() {
    }

    @GwtCompatible(serializable=1)
    public static BinaryPredicate alwaysTrue() {
        return BinaryPredicates.restrict(BinaryPredicates$AlwaysTrue.AlwaysTrue);
    }

    @GwtCompatible(serializable=1)
    public static BinaryPredicate alwaysFalse() {
        return BinaryPredicates.restrict(BinaryPredicates$AlwaysFalse.AlwaysFalse);
    }

    @GwtCompatible(serializable=1)
    public static BinaryPredicate equality() {
        return BinaryPredicates.restrict(BinaryPredicates$Equality.Equality);
    }

    @GwtCompatible(serializable=1)
    public static BinaryPredicate identity() {
        return BinaryPredicates.restrict(BinaryPredicates$Identity.Identity);
    }

    public static BinaryPredicate first(Predicate predicate) {
        return new BinaryPredicates$First(predicate);
    }

    public static BinaryPredicate second(Predicate predicate) {
        return new BinaryPredicates$Second(predicate);
    }

    public static BinaryPredicate and(BinaryPredicate binaryPredicate, BinaryPredicate binaryPredicate2) {
        BinaryPredicate binaryPredicate3 = BinaryPredicates.restrict(binaryPredicate);
        BinaryPredicate binaryPredicate4 = BinaryPredicates.restrict(binaryPredicate2);
        List<BinaryPredicate> list = Arrays.asList(binaryPredicate3, binaryPredicate4);
        return new BinaryPredicates$And(list);
    }

    public static /* varargs */ BinaryPredicate and(BinaryPredicate ... arrbinaryPredicate) {
        return new BinaryPredicates$And(Arrays.asList(arrbinaryPredicate));
    }

    public static BinaryPredicate and(Iterable iterable) {
        return new BinaryPredicates$And(iterable);
    }

    public static BinaryPredicate or(BinaryPredicate binaryPredicate, BinaryPredicate binaryPredicate2) {
        BinaryPredicate binaryPredicate3 = BinaryPredicates.restrict(binaryPredicate);
        BinaryPredicate binaryPredicate4 = BinaryPredicates.restrict(binaryPredicate2);
        List<BinaryPredicate> list = Arrays.asList(binaryPredicate3, binaryPredicate4);
        return new BinaryPredicates$Or(list);
    }

    public static /* varargs */ BinaryPredicate or(BinaryPredicate ... arrbinaryPredicate) {
        return new BinaryPredicates$Or(Arrays.asList(arrbinaryPredicate));
    }

    public static BinaryPredicate or(Iterable iterable) {
        return new BinaryPredicates$Or(iterable);
    }

    public static BinaryPredicate not(BinaryPredicate binaryPredicate) {
        return new BinaryPredicates$Not(binaryPredicate);
    }

    private static BinaryPredicate restrict(@Nullable BinaryPredicate binaryPredicate) {
        return binaryPredicate;
    }

    private static boolean iterableElementsEqual(Iterable iterable, Iterable iterable2) {
        Iterator iterator = iterable.iterator();
        Iterator iterator2 = iterable2.iterator();
        while (iterator.hasNext()) {
            if (!iterator2.hasNext()) {
                return false;
            }
            if (iterator.next().equals(iterator2.next())) continue;
            return false;
        }
        if (iterator2.hasNext()) return false;
        return true;
    }

    private static int iterableAsListHashCode(Iterable iterable) {
        Iterator iterator = iterable.iterator();
        int n2 = 1;
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            n2 = 31 * n2 + t2.hashCode();
        }
        return n2;
    }

    static /* synthetic */ boolean access$000(Iterable iterable, Iterable iterable2) {
        return BinaryPredicates.iterableElementsEqual(iterable, iterable2);
    }

    static /* synthetic */ int access$100(Iterable iterable) {
        return BinaryPredicates.iterableAsListHashCode(iterable);
    }
}

