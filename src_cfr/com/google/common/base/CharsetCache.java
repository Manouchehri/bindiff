/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.CharsetCache$1;
import com.google.common.base.CharsetCache$DefaultLookup;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.lang.ref.SoftReference;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@GoogleInternal
public final class CharsetCache {
    private static final CharsetCache INSTANCE = new CharsetCache(new CharsetCache$DefaultLookup(null), 100);
    private final ConcurrentMap hitCache;
    private final Map missCache;
    private final Function lookupFunction;

    public static Charset forName(@Nullable String string) {
        return INSTANCE.lookup(string);
    }

    CharsetCache(Function function, int n2) {
        Preconditions.checkNotNull(function);
        Preconditions.checkArgument(n2 > 1);
        this.lookupFunction = function;
        this.hitCache = new ConcurrentHashMap();
        CharsetCache$1 charsetCache$1 = new CharsetCache$1(this, n2, 0.75f, true, n2);
        this.missCache = Collections.synchronizedMap(charsetCache$1);
    }

    Charset lookup(String string) {
        Preconditions.checkArgument(string != null, "Charset name may not be null");
        string = string.toLowerCase();
        SoftReference softReference = (SoftReference)this.hitCache.get(string);
        if (softReference != null) {
            Charset charset = (Charset)softReference.get();
            if (charset == null) return this.lookupAndCache(string);
            return charset;
        }
        if (this.missCache.get(string) == null) return this.lookupAndCache(string);
        throw new UnsupportedCharsetException(string);
    }

    private Charset lookupAndCache(String string) {
        try {
            Charset charset = (Charset)this.lookupFunction.apply(string);
            SoftReference<Charset> softReference = new SoftReference<Charset>(charset);
            this.hitCache.put(string, softReference);
            Iterator<String> iterator = charset.aliases().iterator();
            while (iterator.hasNext()) {
                String string2 = iterator.next();
                this.hitCache.put(string2.toLowerCase(), softReference);
            }
            return charset;
        }
        catch (UnsupportedCharsetException var2_3) {
            this.missCache.put(string, Boolean.TRUE);
            throw var2_3;
        }
    }
}

