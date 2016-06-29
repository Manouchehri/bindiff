package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import java.io.*;
import java.math.*;

@GwtCompatible
@Beta
public abstract class DiscreteDomain
{
    public static DiscreteDomain integers() {
        return DiscreteDomain$IntegerDomain.INSTANCE;
    }
    
    public static DiscreteDomain longs() {
        return DiscreteDomain$LongDomain.INSTANCE;
    }
    
    public static DiscreteDomain bigIntegers() {
        return DiscreteDomain$BigIntegerDomain.INSTANCE;
    }
    
    public abstract Comparable next(final Comparable p0);
    
    public abstract Comparable previous(final Comparable p0);
    
    public abstract long distance(final Comparable p0, final Comparable p1);
    
    public Comparable minValue() {
        throw new NoSuchElementException();
    }
    
    public Comparable maxValue() {
        throw new NoSuchElementException();
    }
}
