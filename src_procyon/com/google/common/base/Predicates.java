package com.google.common.base;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.regex.*;
import java.util.*;

@CheckReturnValue
@GwtCompatible(emulated = true)
public final class Predicates
{
    private static final Joiner COMMA_JOINER;
    
    @GwtCompatible(serializable = true)
    public static Predicate alwaysTrue() {
        return Predicates$ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }
    
    @GwtCompatible(serializable = true)
    public static Predicate alwaysFalse() {
        return Predicates$ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }
    
    @GwtCompatible(serializable = true)
    public static Predicate isNull() {
        return Predicates$ObjectPredicate.IS_NULL.withNarrowedType();
    }
    
    @GwtCompatible(serializable = true)
    public static Predicate notNull() {
        return Predicates$ObjectPredicate.NOT_NULL.withNarrowedType();
    }
    
    public static Predicate not(final Predicate predicate) {
        return new Predicates$NotPredicate(predicate);
    }
    
    public static Predicate and(final Iterable iterable) {
        return new Predicates$AndPredicate(defensiveCopy(iterable), null);
    }
    
    public static Predicate and(final Predicate... array) {
        return new Predicates$AndPredicate(defensiveCopy((Object[])array), null);
    }
    
    public static Predicate and(final Predicate predicate, final Predicate predicate2) {
        return new Predicates$AndPredicate(asList((Predicate)Preconditions.checkNotNull(predicate), (Predicate)Preconditions.checkNotNull(predicate2)), null);
    }
    
    public static Predicate or(final Iterable iterable) {
        return new Predicates$OrPredicate(defensiveCopy(iterable), null);
    }
    
    public static Predicate or(final Predicate... array) {
        return new Predicates$OrPredicate(defensiveCopy((Object[])array), null);
    }
    
    public static Predicate or(final Predicate predicate, final Predicate predicate2) {
        return new Predicates$OrPredicate(asList((Predicate)Preconditions.checkNotNull(predicate), (Predicate)Preconditions.checkNotNull(predicate2)), null);
    }
    
    public static Predicate equalTo(@Nullable final Object o) {
        return (o == null) ? isNull() : new Predicates$IsEqualToPredicate(o, null);
    }
    
    @GwtIncompatible("Class.isInstance")
    public static Predicate instanceOf(final Class clazz) {
        return new Predicates$InstanceOfPredicate(clazz, null);
    }
    
    @GwtIncompatible("Class.isAssignableFrom")
    @Beta
    public static Predicate assignableFrom(final Class clazz) {
        return new Predicates$AssignableFromPredicate(clazz, null);
    }
    
    public static Predicate in(final Collection collection) {
        return new Predicates$InPredicate(collection, null);
    }
    
    public static Predicate compose(final Predicate predicate, final Function function) {
        return new Predicates$CompositionPredicate(predicate, function, null);
    }
    
    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate containsPattern(final String s) {
        return new Predicates$ContainsPatternFromStringPredicate(s);
    }
    
    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate contains(final Pattern pattern) {
        return new Predicates$ContainsPatternPredicate(pattern);
    }
    
    private static List asList(final Predicate predicate, final Predicate predicate2) {
        return Arrays.asList(predicate, predicate2);
    }
    
    private static List defensiveCopy(final Object... array) {
        return defensiveCopy(Arrays.asList(array));
    }
    
    static List defensiveCopy(final Iterable iterable) {
        final ArrayList<Object> list = new ArrayList<Object>();
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.add(Preconditions.checkNotNull(iterator.next()));
        }
        return list;
    }
    
    static {
        COMMA_JOINER = Joiner.on(',');
    }
}
