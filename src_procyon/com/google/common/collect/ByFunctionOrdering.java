package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;

@GwtCompatible(serializable = true)
final class ByFunctionOrdering extends Ordering implements Serializable
{
    final Function function;
    final Ordering ordering;
    private static final long serialVersionUID = 0L;
    
    ByFunctionOrdering(final Function function, final Ordering ordering) {
        this.function = (Function)Preconditions.checkNotNull(function);
        this.ordering = (Ordering)Preconditions.checkNotNull(ordering);
    }
    
    @Override
    public int compare(final Object o, final Object o2) {
        return this.ordering.compare(this.function.apply(o), this.function.apply(o2));
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ByFunctionOrdering) {
            final ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering)o;
            return this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.function, this.ordering);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.ordering);
        final String value2 = String.valueOf(this.function);
        return new StringBuilder(13 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(".onResultOf(").append(value2).append(")").toString();
    }
}
