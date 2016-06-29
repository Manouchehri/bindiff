/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner$1;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckReturnValue;

public final class Joiner$MapJoiner {
    private final Joiner joiner;
    private final String keyValueSeparator;

    private Joiner$MapJoiner(Joiner joiner, String string) {
        this.joiner = joiner;
        this.keyValueSeparator = (String)Preconditions.checkNotNull(string);
    }

    public Appendable appendTo(Appendable appendable, Map map) {
        return this.appendTo(appendable, map.entrySet());
    }

    public StringBuilder appendTo(StringBuilder stringBuilder, Map map) {
        return this.appendTo(stringBuilder, map.entrySet());
    }

    @CheckReturnValue
    public String join(Map map) {
        return this.join(map.entrySet());
    }

    @Beta
    public Appendable appendTo(Appendable appendable, Iterable iterable) {
        return this.appendTo(appendable, iterable.iterator());
    }

    @Beta
    public Appendable appendTo(Appendable appendable, Iterator iterator) {
        Preconditions.checkNotNull(appendable);
        if (!iterator.hasNext()) return appendable;
        Map.Entry entry = (Map.Entry)iterator.next();
        appendable.append(this.joiner.toString(entry.getKey()));
        appendable.append(this.keyValueSeparator);
        appendable.append(this.joiner.toString(entry.getValue()));
        while (iterator.hasNext()) {
            appendable.append(Joiner.access$100(this.joiner));
            Map.Entry entry2 = (Map.Entry)iterator.next();
            appendable.append(this.joiner.toString(entry2.getKey()));
            appendable.append(this.keyValueSeparator);
            appendable.append(this.joiner.toString(entry2.getValue()));
        }
        return appendable;
    }

    @Beta
    public StringBuilder appendTo(StringBuilder stringBuilder, Iterable iterable) {
        return this.appendTo(stringBuilder, iterable.iterator());
    }

    @Beta
    public StringBuilder appendTo(StringBuilder stringBuilder, Iterator iterator) {
        try {
            this.appendTo((Appendable)stringBuilder, iterator);
            return stringBuilder;
        }
        catch (IOException var3_3) {
            throw new AssertionError(var3_3);
        }
    }

    @CheckReturnValue
    @Beta
    public String join(Iterable iterable) {
        return this.join(iterable.iterator());
    }

    @CheckReturnValue
    @Beta
    public String join(Iterator iterator) {
        return this.appendTo(new StringBuilder(), iterator).toString();
    }

    @CheckReturnValue
    public Joiner$MapJoiner useForNull(String string) {
        return new Joiner$MapJoiner(this.joiner.useForNull(string), this.keyValueSeparator);
    }

    /* synthetic */ Joiner$MapJoiner(Joiner joiner, String string, Joiner$1 joiner$1) {
        this(joiner, string);
    }
}

