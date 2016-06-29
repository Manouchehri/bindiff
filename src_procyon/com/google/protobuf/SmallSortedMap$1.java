package com.google.protobuf;

import java.util.*;

final class SmallSortedMap$1 extends SmallSortedMap
{
    SmallSortedMap$1(final int n) {
        super(n, null);
    }
    
    public void makeImmutable() {
        if (!this.isImmutable()) {
            for (int i = 0; i < this.getNumArrayEntries(); ++i) {
                final Entry arrayEntry = this.getArrayEntryAt(i);
                if (arrayEntry.getKey().isRepeated()) {
                    arrayEntry.setValue(Collections.unmodifiableList((List<?>)arrayEntry.getValue()));
                }
            }
            for (final Map.Entry<FieldSet$FieldDescriptorLite, V> entry : this.getOverflowEntries()) {
                if (entry.getKey().isRepeated()) {
                    entry.setValue((V)Collections.unmodifiableList((List<?>)entry.getValue()));
                }
            }
        }
        super.makeImmutable();
    }
}
