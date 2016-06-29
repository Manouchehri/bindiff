/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter$1;
import com.google.common.base.Converter$ConverterComposition;
import com.google.common.base.Converter$FunctionBasedConverter;
import com.google.common.base.Converter$IdentityConverter;
import com.google.common.base.Converter$ReverseConverter;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public abstract class Converter
implements Function {
    private final boolean handleNullAutomatically;
    @LazyInit
    private transient Converter reverse;

    protected Converter() {
        this(true);
    }

    Converter(boolean bl2) {
        this.handleNullAutomatically = bl2;
    }

    protected abstract Object doForward(Object var1);

    protected abstract Object doBackward(Object var1);

    @Nullable
    public final Object convert(@Nullable Object object) {
        return this.correctedDoForward(object);
    }

    @Nullable
    Object correctedDoForward(@Nullable Object object) {
        if (!this.handleNullAutomatically) return this.doForward(object);
        if (object == null) {
            return null;
        }
        Object object2 = Preconditions.checkNotNull(this.doForward(object));
        return object2;
    }

    @Nullable
    Object correctedDoBackward(@Nullable Object object) {
        if (!this.handleNullAutomatically) return this.doBackward(object);
        if (object == null) {
            return null;
        }
        Object object2 = Preconditions.checkNotNull(this.doBackward(object));
        return object2;
    }

    public Iterable convertAll(Iterable iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Converter$1(this, iterable);
    }

    public Converter reverse() {
        Converter converter;
        Converter converter2 = this.reverse;
        if (converter2 == null) {
            converter = this.reverse = new Converter$ReverseConverter(this);
            return converter;
        }
        converter = converter2;
        return converter;
    }

    public final Converter andThen(Converter converter) {
        return this.doAndThen(converter);
    }

    Converter doAndThen(Converter converter) {
        return new Converter$ConverterComposition(this, (Converter)Preconditions.checkNotNull(converter));
    }

    @Deprecated
    @Nullable
    @Override
    public final Object apply(@Nullable Object object) {
        return this.convert(object);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return super.equals(object);
    }

    public static Converter from(Function function, Function function2) {
        return new Converter$FunctionBasedConverter(function, function2, null);
    }

    public static Converter identity() {
        return Converter$IdentityConverter.INSTANCE;
    }
}

