package com.google.common.collect;

import java.util.*;
import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;

@GwtCompatible
public abstract class ForwardingMapEntry extends ForwardingObject implements Entry
{
    @Override
    protected abstract Entry delegate();
    
    @Override
    public Object getKey() {
        return this.delegate().getKey();
    }
    
    @Override
    public Object getValue() {
        return this.delegate().getValue();
    }
    
    @Override
    public Object setValue(final Object value) {
        return this.delegate().setValue(value);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return this.delegate().equals(o);
    }
    
    @Override
    public int hashCode() {
        return this.delegate().hashCode();
    }
    
    protected boolean standardEquals(@Nullable final Object o) {
        if (o instanceof Entry) {
            final Entry entry = (Entry)o;
            return Objects.equal(this.getKey(), entry.getKey()) && Objects.equal(this.getValue(), entry.getValue());
        }
        return false;
    }
    
    protected int standardHashCode() {
        final Object key = this.getKey();
        final Object value = this.getValue();
        return ((key == null) ? 0 : key.hashCode()) ^ ((value == null) ? 0 : value.hashCode());
    }
    
    @Beta
    protected String standardToString() {
        final String value = String.valueOf(this.getKey());
        final String value2 = String.valueOf(this.getValue());
        return new StringBuilder(1 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append("=").append(value2).toString();
    }
}
