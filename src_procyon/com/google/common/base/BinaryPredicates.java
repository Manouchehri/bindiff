package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@CheckReturnValue
@GoogleInternal
@GwtCompatible
public final class BinaryPredicates
{
    @GwtCompatible(serializable = true)
    public static BinaryPredicate alwaysTrue() {
        return restrict(BinaryPredicates$AlwaysTrue.AlwaysTrue);
    }
    
    @GwtCompatible(serializable = true)
    public static BinaryPredicate alwaysFalse() {
        return restrict(BinaryPredicates$AlwaysFalse.AlwaysFalse);
    }
    
    @GwtCompatible(serializable = true)
    public static BinaryPredicate equality() {
        return restrict(BinaryPredicates$Equality.Equality);
    }
    
    @GwtCompatible(serializable = true)
    public static BinaryPredicate identity() {
        return restrict(BinaryPredicates$Identity.Identity);
    }
    
    public static BinaryPredicate first(final Predicate predicate) {
        return new BinaryPredicates$First(predicate);
    }
    
    public static BinaryPredicate second(final Predicate predicate) {
        return new BinaryPredicates$Second(predicate);
    }
    
    public static BinaryPredicate and(final BinaryPredicate binaryPredicate, final BinaryPredicate binaryPredicate2) {
        return new BinaryPredicates$And(Arrays.asList(restrict(binaryPredicate), restrict(binaryPredicate2)));
    }
    
    public static BinaryPredicate and(final BinaryPredicate... array) {
        return new BinaryPredicates$And(Arrays.asList(array));
    }
    
    public static BinaryPredicate and(final Iterable iterable) {
        return new BinaryPredicates$And(iterable);
    }
    
    public static BinaryPredicate or(final BinaryPredicate binaryPredicate, final BinaryPredicate binaryPredicate2) {
        return new BinaryPredicates$Or(Arrays.asList(restrict(binaryPredicate), restrict(binaryPredicate2)));
    }
    
    public static BinaryPredicate or(final BinaryPredicate... array) {
        return new BinaryPredicates$Or(Arrays.asList(array));
    }
    
    public static BinaryPredicate or(final Iterable iterable) {
        return new BinaryPredicates$Or(iterable);
    }
    
    public static BinaryPredicate not(final BinaryPredicate binaryPredicate) {
        return new BinaryPredicates$Not(binaryPredicate);
    }
    
    private static BinaryPredicate restrict(@Nullable final BinaryPredicate binaryPredicate) {
        return binaryPredicate;
    }
    
    private static boolean iterableElementsEqual(final Iterable iterable, final Iterable iterable2) {
        final Iterator<Object> iterator = iterable.iterator();
        final Iterator<Object> iterator2 = iterable2.iterator();
        while (iterator.hasNext()) {
            if (!iterator2.hasNext()) {
                return false;
            }
            if (!iterator.next().equals(iterator2.next())) {
                return false;
            }
        }
        return !iterator2.hasNext();
    }
    
    private static int iterableAsListHashCode(final Iterable iterable) {
        final Iterator<Object> iterator = iterable.iterator();
        int n = 1;
        while (iterator.hasNext()) {
            n = 31 * n + iterator.next().hashCode();
        }
        return n;
    }
}
