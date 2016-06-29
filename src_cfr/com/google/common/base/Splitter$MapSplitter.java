/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.CheckReturnValue;

@Beta
public final class Splitter$MapSplitter {
    private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
    private final Splitter outerSplitter;
    private final Splitter entrySplitter;

    private Splitter$MapSplitter(Splitter splitter, Splitter splitter2) {
        this.outerSplitter = splitter;
        this.entrySplitter = (Splitter)Preconditions.checkNotNull(splitter2);
    }

    @CheckReturnValue
    public Map split(CharSequence charSequence) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        Iterator iterator = this.outerSplitter.split(charSequence).iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            Iterator iterator2 = Splitter.access$000(this.entrySplitter, string);
            Preconditions.checkArgument(iterator2.hasNext(), "Chunk [%s] is not a valid entry", string);
            String string2 = (String)iterator2.next();
            Preconditions.checkArgument(!linkedHashMap.containsKey(string2), "Duplicate key [%s] found.", string2);
            Preconditions.checkArgument(iterator2.hasNext(), "Chunk [%s] is not a valid entry", string);
            String string3 = (String)iterator2.next();
            linkedHashMap.put(string2, string3);
            Preconditions.checkArgument(!iterator2.hasNext(), "Chunk [%s] is not a valid entry", string);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* synthetic */ Splitter$MapSplitter(Splitter splitter, Splitter splitter2, Splitter$1 splitter$1) {
        this(splitter, splitter2);
    }
}

