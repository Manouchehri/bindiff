/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.AbstractList;
import java.util.List;

class RepeatedFieldBuilder$BuilderExternalList
extends AbstractList
implements List {
    RepeatedFieldBuilder builder;

    RepeatedFieldBuilder$BuilderExternalList(RepeatedFieldBuilder repeatedFieldBuilder) {
        this.builder = repeatedFieldBuilder;
    }

    @Override
    public int size() {
        return this.builder.getCount();
    }

    public GeneratedMessage$Builder get(int n2) {
        return this.builder.getBuilder(n2);
    }

    void incrementModCount() {
        ++this.modCount;
    }
}

