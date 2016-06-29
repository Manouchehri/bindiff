package com.google.protobuf;

import java.util.*;

class RepeatedFieldBuilder$BuilderExternalList extends AbstractList implements List
{
    RepeatedFieldBuilder builder;
    
    RepeatedFieldBuilder$BuilderExternalList(final RepeatedFieldBuilder builder) {
        this.builder = builder;
    }
    
    public int size() {
        return this.builder.getCount();
    }
    
    public GeneratedMessage$Builder get(final int n) {
        return this.builder.getBuilder(n);
    }
    
    void incrementModCount() {
        ++this.modCount;
    }
}
