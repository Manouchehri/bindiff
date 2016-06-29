package com.google.common.base;

import javax.annotation.*;
import java.util.regex.*;
import com.google.common.annotations.*;
import java.util.*;

@Beta
public final class Splitter$MapSplitter
{
    private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
    private final Splitter outerSplitter;
    private final Splitter entrySplitter;
    
    private Splitter$MapSplitter(final Splitter outerSplitter, final Splitter splitter) {
        this.outerSplitter = outerSplitter;
        this.entrySplitter = (Splitter)Preconditions.checkNotNull(splitter);
    }
    
    @CheckReturnValue
    public Map split(final CharSequence charSequence) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap<String, String>();
        for (final String s : this.outerSplitter.split(charSequence)) {
            final Iterator access$000 = this.entrySplitter.splittingIterator(s);
            Preconditions.checkArgument(access$000.hasNext(), "Chunk [%s] is not a valid entry", s);
            final String s2 = access$000.next();
            Preconditions.checkArgument(!linkedHashMap.containsKey(s2), "Duplicate key [%s] found.", s2);
            Preconditions.checkArgument(access$000.hasNext(), "Chunk [%s] is not a valid entry", s);
            linkedHashMap.put(s2, access$000.next());
            Preconditions.checkArgument(!access$000.hasNext(), "Chunk [%s] is not a valid entry", s);
        }
        return Collections.unmodifiableMap((Map<?, ?>)linkedHashMap);
    }
}
