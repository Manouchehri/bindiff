package com.google.protobuf;

import java.util.*;

public class Internal$ListAdapter extends AbstractList
{
    private final List fromList;
    private final Internal$ListAdapter$Converter converter;
    
    public Internal$ListAdapter(final List fromList, final Internal$ListAdapter$Converter converter) {
        this.fromList = fromList;
        this.converter = converter;
    }
    
    public Object get(final int n) {
        return this.converter.convert(this.fromList.get(n));
    }
    
    public int size() {
        return this.fromList.size();
    }
}
