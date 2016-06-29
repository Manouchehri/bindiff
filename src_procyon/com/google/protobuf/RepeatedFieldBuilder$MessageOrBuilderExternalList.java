package com.google.protobuf;

import java.util.*;

class RepeatedFieldBuilder$MessageOrBuilderExternalList extends AbstractList implements List
{
    RepeatedFieldBuilder builder;
    
    RepeatedFieldBuilder$MessageOrBuilderExternalList(final RepeatedFieldBuilder builder) {
        this.builder = builder;
    }
    
    public int size() {
        return this.builder.getCount();
    }
    
    public MessageOrBuilder get(final int n) {
        return this.builder.getMessageOrBuilder(n);
    }
    
    void incrementModCount() {
        ++this.modCount;
    }
}
