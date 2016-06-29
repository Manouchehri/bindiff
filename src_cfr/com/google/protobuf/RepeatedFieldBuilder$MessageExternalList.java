/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.AbstractList;
import java.util.List;

class RepeatedFieldBuilder$MessageExternalList
extends AbstractList
implements List {
    RepeatedFieldBuilder builder;

    RepeatedFieldBuilder$MessageExternalList(RepeatedFieldBuilder repeatedFieldBuilder) {
        this.builder = repeatedFieldBuilder;
    }

    @Override
    public int size() {
        return this.builder.getCount();
    }

    public GeneratedMessage get(int n2) {
        return this.builder.getMessage(n2);
    }

    void incrementModCount() {
        ++this.modCount;
    }
}

