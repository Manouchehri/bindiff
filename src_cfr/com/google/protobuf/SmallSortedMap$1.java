/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.SmallSortedMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class SmallSortedMap$1
extends SmallSortedMap {
    SmallSortedMap$1(int n2) {
        super(n2, null);
    }

    @Override
    public void makeImmutable() {
        if (!this.isImmutable()) {
            List list;
            for (int i2 = 0; i2 < this.getNumArrayEntries(); ++i2) {
                Map.Entry entry = this.getArrayEntryAt(i2);
                if (!((FieldSet$FieldDescriptorLite)entry.getKey()).isRepeated()) continue;
                list = (List)entry.getValue();
                entry.setValue(Collections.unmodifiableList(list));
            }
            for (Map.Entry entry : this.getOverflowEntries()) {
                if (!((FieldSet$FieldDescriptorLite)entry.getKey()).isRepeated()) continue;
                list = (List)entry.getValue();
                entry.setValue(Collections.unmodifiableList(list));
            }
        }
        super.makeImmutable();
    }
}

