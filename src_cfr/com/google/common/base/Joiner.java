/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner$1;
import com.google.common.base.Joiner$2;
import com.google.common.base.Joiner$3;
import com.google.common.base.Joiner$MapJoiner;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public class Joiner {
    private final String separator;

    @CheckReturnValue
    public static Joiner on(String string) {
        return new Joiner(string);
    }

    @CheckReturnValue
    public static Joiner on(char c2) {
        return new Joiner(String.valueOf(c2));
    }

    private Joiner(String string) {
        this.separator = (String)Preconditions.checkNotNull(string);
    }

    private Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    public Appendable appendTo(Appendable appendable, Iterable iterable) {
        return this.appendTo(appendable, iterable.iterator());
    }

    public Appendable appendTo(Appendable appendable, Iterator iterator) {
        Preconditions.checkNotNull(appendable);
        if (!iterator.hasNext()) return appendable;
        appendable.append(this.toString(iterator.next()));
        while (iterator.hasNext()) {
            appendable.append(this.separator);
            appendable.append(this.toString(iterator.next()));
        }
        return appendable;
    }

    public final Appendable appendTo(Appendable appendable, Object[] arrobject) {
        return this.appendTo(appendable, Arrays.asList(arrobject));
    }

    public final /* varargs */ Appendable appendTo(Appendable appendable, @Nullable Object object, @Nullable Object object2, Object ... arrobject) {
        return this.appendTo(appendable, Joiner.iterable(object, object2, arrobject));
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Iterable iterable) {
        return this.appendTo(stringBuilder, iterable.iterator());
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Iterator iterator) {
        try {
            this.appendTo((Appendable)stringBuilder, iterator);
            return stringBuilder;
        }
        catch (IOException var3_3) {
            throw new AssertionError(var3_3);
        }
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Object[] arrobject) {
        return this.appendTo(stringBuilder, Arrays.asList(arrobject));
    }

    public final /* varargs */ StringBuilder appendTo(StringBuilder stringBuilder, @Nullable Object object, @Nullable Object object2, Object ... arrobject) {
        return this.appendTo(stringBuilder, Joiner.iterable(object, object2, arrobject));
    }

    @CheckReturnValue
    public final String join(Iterable iterable) {
        return this.join(iterable.iterator());
    }

    @CheckReturnValue
    public final String join(Iterator iterator) {
        return this.appendTo(new StringBuilder(), iterator).toString();
    }

    @CheckReturnValue
    public final String join(Object[] arrobject) {
        return this.join(Arrays.asList(arrobject));
    }

    @CheckReturnValue
    public final /* varargs */ String join(@Nullable Object object, @Nullable Object object2, Object ... arrobject) {
        return this.join(Joiner.iterable(object, object2, arrobject));
    }

    @CheckReturnValue
    public Joiner useForNull(String string) {
        Preconditions.checkNotNull(string);
        return new Joiner$1(this, this, string);
    }

    @CheckReturnValue
    public Joiner skipNulls() {
        return new Joiner$2(this, this);
    }

    @CheckReturnValue
    public Joiner$MapJoiner withKeyValueSeparator(String string) {
        return new Joiner$MapJoiner(this, string, null);
    }

    CharSequence toString(Object object) {
        CharSequence charSequence;
        Preconditions.checkNotNull(object);
        if (object instanceof CharSequence) {
            charSequence = (CharSequence)object;
            return charSequence;
        }
        charSequence = object.toString();
        return charSequence;
    }

    private static Iterable iterable(Object object, Object object2, Object[] arrobject) {
        Preconditions.checkNotNull(arrobject);
        return new Joiner$3(arrobject, object, object2);
    }

    /* synthetic */ Joiner(Joiner joiner, Joiner$1 joiner$1) {
        this(joiner);
    }

    static /* synthetic */ String access$100(Joiner joiner) {
        return joiner.separator;
    }
}

