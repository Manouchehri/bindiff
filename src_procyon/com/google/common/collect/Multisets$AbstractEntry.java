package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;

abstract class Multisets$AbstractEntry implements Multiset$Entry
{
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Multiset$Entry) {
            final Multiset$Entry multiset$Entry = (Multiset$Entry)o;
            return this.getCount() == multiset$Entry.getCount() && Objects.equal(this.getElement(), multiset$Entry.getElement());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final Object element = this.getElement();
        return ((element == null) ? 0 : element.hashCode()) ^ this.getCount();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.getElement());
        final int count = this.getCount();
        return (count == 1) ? value : new StringBuilder(14 + String.valueOf(value).length()).append(value).append(" x ").append(count).toString();
    }
}
