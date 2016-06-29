package com.google.protobuf;

import java.util.*;

class RepeatedFieldBuilder$MessageExternalList extends AbstractList implements List
{
    RepeatedFieldBuilder builder;
    
    RepeatedFieldBuilder$MessageExternalList(final RepeatedFieldBuilder builder) {
        this.builder = builder;
    }
    
    public int size() {
        return this.builder.getCount();
    }
    
    public GeneratedMessage get(final int n) {
        return this.builder.getMessage(n);
    }
    
    void incrementModCount() {
        ++this.modCount;
    }
}
