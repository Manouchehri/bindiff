/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.AbstractList;
import java.util.List;

class RepeatedFieldBuilder$MessageOrBuilderExternalList
extends AbstractList
implements List {
    RepeatedFieldBuilder builder;

    RepeatedFieldBuilder$MessageOrBuilderExternalList(RepeatedFieldBuilder repeatedFieldBuilder) {
        this.builder = repeatedFieldBuilder;
    }

    @Override
    public int size() {
        return this.builder.getCount();
    }

    public MessageOrBuilder get(int n2) {
        return this.builder.getMessageOrBuilder(n2);
    }

    void incrementModCount() {
        ++this.modCount;
    }
}

