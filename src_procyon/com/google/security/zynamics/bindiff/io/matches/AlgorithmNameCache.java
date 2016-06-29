package com.google.security.zynamics.bindiff.io.matches;

import java.util.*;

public class AlgorithmNameCache
{
    private final List names;
    private final Map nameToIndexMap;
    private byte lastIndex;
    
    public AlgorithmNameCache() {
        this.names = new ArrayList();
        this.nameToIndexMap = new HashMap();
        this.lastIndex = 0;
    }
    
    public String get(final String s) {
        final Byte b = this.nameToIndexMap.get(s);
        if (b == null) {
            this.names.add(s);
            final Map nameToIndexMap = this.nameToIndexMap;
            final byte lastIndex = this.lastIndex;
            this.lastIndex = (byte)(lastIndex + 1);
            nameToIndexMap.put(s, lastIndex);
        }
        return (String)this.names.get(b);
    }
}
