/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Multiset$Entry;
import javax.annotation.Nullable;

abstract class Multisets$AbstractEntry
implements Multiset$Entry {
    Multisets$AbstractEntry() {
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Multiset$Entry)) return false;
        Multiset$Entry multiset$Entry = (Multiset$Entry)object;
        if (this.getCount() != multiset$Entry.getCount()) return false;
        if (!Objects.equal(this.getElement(), multiset$Entry.getElement())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int n2;
        Object object = this.getElement();
        if (object == null) {
            n2 = 0;
            return n2 ^ this.getCount();
        }
        n2 = object.hashCode();
        return n2 ^ this.getCount();
    }

    @Override
    public String toString() {
        String string;
        String string2 = String.valueOf(this.getElement());
        int n2 = this.getCount();
        if (n2 == 1) {
            string = string2;
            return string;
        }
        string = new StringBuilder(14 + String.valueOf(string2).length()).append(string2).append(" x ").append(n2).toString();
        return string;
    }
}

