package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.concurrent.*;
import java.lang.ref.*;
import java.nio.charset.*;
import java.util.*;

@GoogleInternal
public final class CharsetCache
{
    private static final CharsetCache INSTANCE;
    private final ConcurrentMap hitCache;
    private final Map missCache;
    private final Function lookupFunction;
    
    public static Charset forName(@Nullable final String s) {
        return CharsetCache.INSTANCE.lookup(s);
    }
    
    CharsetCache(final Function lookupFunction, final int n) {
        Preconditions.checkNotNull(lookupFunction);
        Preconditions.checkArgument(n > 1);
        this.lookupFunction = lookupFunction;
        this.hitCache = new ConcurrentHashMap();
        this.missCache = Collections.synchronizedMap((Map<Object, Object>)new CharsetCache$1(this, n, 0.75f, true, n));
    }
    
    Charset lookup(String lowerCase) {
        Preconditions.checkArgument(lowerCase != null, (Object)"Charset name may not be null");
        lowerCase = lowerCase.toLowerCase();
        final SoftReference softReference = (SoftReference)this.hitCache.get(lowerCase);
        if (softReference != null) {
            final Charset charset = softReference.get();
            if (charset != null) {
                return charset;
            }
        }
        else if (this.missCache.get(lowerCase) != null) {
            throw new UnsupportedCharsetException(lowerCase);
        }
        return this.lookupAndCache(lowerCase);
    }
    
    private Charset lookupAndCache(final String s) {
        try {
            final Charset charset = (Charset)this.lookupFunction.apply(s);
            final SoftReference softReference = new SoftReference(charset);
            this.hitCache.put(s, softReference);
            final Iterator<String> iterator = charset.aliases().iterator();
            while (iterator.hasNext()) {
                this.hitCache.put(iterator.next().toLowerCase(), softReference);
            }
            return charset;
        }
        catch (UnsupportedCharsetException ex) {
            this.missCache.put(s, Boolean.TRUE);
            throw ex;
        }
    }
    
    static {
        INSTANCE = new CharsetCache(new CharsetCache$DefaultLookup(null), 100);
    }
}
