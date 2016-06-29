package com.google.common.base;

import com.google.common.annotations.*;
import com.google.errorprone.annotations.concurrent.*;
import javax.annotation.*;

@Beta
@GwtCompatible
public abstract class Converter implements Function
{
    private final boolean handleNullAutomatically;
    @LazyInit
    private transient Converter reverse;
    
    protected Converter() {
        this(true);
    }
    
    Converter(final boolean handleNullAutomatically) {
        this.handleNullAutomatically = handleNullAutomatically;
    }
    
    protected abstract Object doForward(final Object p0);
    
    protected abstract Object doBackward(final Object p0);
    
    @Nullable
    public final Object convert(@Nullable final Object o) {
        return this.correctedDoForward(o);
    }
    
    @Nullable
    Object correctedDoForward(@Nullable final Object o) {
        if (this.handleNullAutomatically) {
            return (o == null) ? null : Preconditions.checkNotNull(this.doForward(o));
        }
        return this.doForward(o);
    }
    
    @Nullable
    Object correctedDoBackward(@Nullable final Object o) {
        if (this.handleNullAutomatically) {
            return (o == null) ? null : Preconditions.checkNotNull(this.doBackward(o));
        }
        return this.doBackward(o);
    }
    
    public Iterable convertAll(final Iterable iterable) {
        Preconditions.checkNotNull(iterable, (Object)"fromIterable");
        return new Converter$1(this, iterable);
    }
    
    public Converter reverse() {
        final Converter reverse = this.reverse;
        return (reverse == null) ? (this.reverse = new Converter$ReverseConverter(this)) : reverse;
    }
    
    public final Converter andThen(final Converter converter) {
        return this.doAndThen(converter);
    }
    
    Converter doAndThen(final Converter converter) {
        return new Converter$ConverterComposition(this, (Converter)Preconditions.checkNotNull(converter));
    }
    
    @Deprecated
    @Nullable
    @Override
    public final Object apply(@Nullable final Object o) {
        return this.convert(o);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return super.equals(o);
    }
    
    public static Converter from(final Function function, final Function function2) {
        return new Converter$FunctionBasedConverter(function, function2, null);
    }
    
    public static Converter identity() {
        return Converter$IdentityConverter.INSTANCE;
    }
}
