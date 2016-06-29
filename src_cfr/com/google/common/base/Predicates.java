/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import com.google.common.base.Predicates$AndPredicate;
import com.google.common.base.Predicates$AssignableFromPredicate;
import com.google.common.base.Predicates$CompositionPredicate;
import com.google.common.base.Predicates$ContainsPatternFromStringPredicate;
import com.google.common.base.Predicates$ContainsPatternPredicate;
import com.google.common.base.Predicates$InPredicate;
import com.google.common.base.Predicates$InstanceOfPredicate;
import com.google.common.base.Predicates$IsEqualToPredicate;
import com.google.common.base.Predicates$NotPredicate;
import com.google.common.base.Predicates$ObjectPredicate;
import com.google.common.base.Predicates$OrPredicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible(emulated=1)
public final class Predicates {
    private static final Joiner COMMA_JOINER = Joiner.on(',');

    private Predicates() {
    }

    @GwtCompatible(serializable=1)
    public static Predicate alwaysTrue() {
        return Predicates$ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    @GwtCompatible(serializable=1)
    public static Predicate alwaysFalse() {
        return Predicates$ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }

    @GwtCompatible(serializable=1)
    public static Predicate isNull() {
        return Predicates$ObjectPredicate.IS_NULL.withNarrowedType();
    }

    @GwtCompatible(serializable=1)
    public static Predicate notNull() {
        return Predicates$ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static Predicate not(Predicate predicate) {
        return new Predicates$NotPredicate(predicate);
    }

    public static Predicate and(Iterable iterable) {
        return new Predicates$AndPredicate(Predicates.defensiveCopy(iterable), null);
    }

    public static /* varargs */ Predicate and(Predicate ... arrpredicate) {
        return new Predicates$AndPredicate(Predicates.defensiveCopy(arrpredicate), null);
    }

    public static Predicate and(Predicate predicate, Predicate predicate2) {
        return new Predicates$AndPredicate(Predicates.asList((Predicate)Preconditions.checkNotNull(predicate), (Predicate)Preconditions.checkNotNull(predicate2)), null);
    }

    public static Predicate or(Iterable iterable) {
        return new Predicates$OrPredicate(Predicates.defensiveCopy(iterable), null);
    }

    public static /* varargs */ Predicate or(Predicate ... arrpredicate) {
        return new Predicates$OrPredicate(Predicates.defensiveCopy(arrpredicate), null);
    }

    public static Predicate or(Predicate predicate, Predicate predicate2) {
        return new Predicates$OrPredicate(Predicates.asList((Predicate)Preconditions.checkNotNull(predicate), (Predicate)Preconditions.checkNotNull(predicate2)), null);
    }

    public static Predicate equalTo(@Nullable Object object) {
        Predicate predicate;
        if (object == null) {
            predicate = Predicates.isNull();
            return predicate;
        }
        predicate = new Predicates$IsEqualToPredicate(object, null);
        return predicate;
    }

    @GwtIncompatible(value="Class.isInstance")
    public static Predicate instanceOf(Class class_) {
        return new Predicates$InstanceOfPredicate(class_, null);
    }

    @GwtIncompatible(value="Class.isAssignableFrom")
    @Beta
    public static Predicate assignableFrom(Class class_) {
        return new Predicates$AssignableFromPredicate(class_, null);
    }

    public static Predicate in(Collection collection) {
        return new Predicates$InPredicate(collection, null);
    }

    public static Predicate compose(Predicate predicate, Function function) {
        return new Predicates$CompositionPredicate(predicate, function, null);
    }

    @GwtIncompatible(value="java.util.regex.Pattern")
    public static Predicate containsPattern(String string) {
        return new Predicates$ContainsPatternFromStringPredicate(string);
    }

    @GwtIncompatible(value="java.util.regex.Pattern")
    public static Predicate contains(Pattern pattern) {
        return new Predicates$ContainsPatternPredicate(pattern);
    }

    private static List asList(Predicate predicate, Predicate predicate2) {
        return Arrays.asList(predicate, predicate2);
    }

    private static /* varargs */ List defensiveCopy(Object ... arrobject) {
        return Predicates.defensiveCopy(Arrays.asList(arrobject));
    }

    static List defensiveCopy(Iterable iterable) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            arrayList.add(Preconditions.checkNotNull(t2));
        }
        return arrayList;
    }

    static /* synthetic */ Joiner access$800() {
        return COMMA_JOINER;
    }
}

