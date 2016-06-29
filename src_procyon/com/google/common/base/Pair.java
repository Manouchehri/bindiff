package com.google.common.base;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@CheckReturnValue
@GoogleInternal
@GwtCompatible(serializable = true)
public class Pair implements Serializable
{
    public final Object first;
    public final Object second;
    private static final long serialVersionUID = 747826592375603043L;
    
    public static Pair of(@Nullable final Object o, @Nullable final Object o2) {
        return new Pair(o, o2);
    }
    
    protected Pair(@Nullable final Object first, @Nullable final Object second) {
        this.first = first;
        this.second = second;
    }
    
    public Object getFirst() {
        return this.first;
    }
    
    public Object getSecond() {
        return this.second;
    }
    
    public static Function firstFunction() {
        return Pair$PairFirstFunction.INSTANCE;
    }
    
    public static Function secondFunction() {
        return Pair$PairSecondFunction.INSTANCE;
    }
    
    public static Comparator compareByFirst() {
        return Pair$FirstComparator.FIRST_COMPARATOR;
    }
    
    public static Comparator compareBySecond() {
        return Pair$SecondComparator.SECOND_COMPARATOR;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Pair) {
            final Pair pair = (Pair)o;
            return Objects.equal(this.getFirst(), pair.getFirst()) && Objects.equal(this.getSecond(), pair.getSecond());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 31 * ((this.first == null) ? 0 : this.first.hashCode()) + ((this.second == null) ? 0 : this.second.hashCode());
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.getFirst());
        final String value2 = String.valueOf(this.getSecond());
        return new StringBuilder(4 + String.valueOf(value).length() + String.valueOf(value2).length()).append("(").append(value).append(", ").append(value2).append(")").toString();
    }
}
