/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.io.matches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgorithmNameCache {
    private final List names = new ArrayList();
    private final Map nameToIndexMap = new HashMap();
    private byte lastIndex = 0;

    public String get(String string) {
        Byte by2 = (Byte)this.nameToIndexMap.get(string);
        if (by2 != null) return (String)this.names.get(by2.byteValue());
        this.names.add(string);
        byte by3 = this.lastIndex;
        this.lastIndex = (byte)(by3 + 1);
        this.nameToIndexMap.put(string, Byte.valueOf(by3));
        return (String)this.names.get(by2.byteValue());
    }
}

