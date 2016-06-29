/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$ListAdapter$Converter;
import java.util.AbstractList;
import java.util.List;

public class Internal$ListAdapter
extends AbstractList {
    private final List fromList;
    private final Internal$ListAdapter$Converter converter;

    public Internal$ListAdapter(List list, Internal$ListAdapter$Converter internal$ListAdapter$Converter) {
        this.fromList = list;
        this.converter = internal$ListAdapter$Converter;
    }

    @Override
    public Object get(int n2) {
        return this.converter.convert(this.fromList.get(n2));
    }

    @Override
    public int size() {
        return this.fromList.size();
    }
}

