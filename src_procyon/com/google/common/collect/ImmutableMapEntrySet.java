package com.google.common.collect;

import javax.annotation.*;
import java.util.*;
import com.google.common.annotations.*;

@GwtCompatible(emulated = true)
abstract class ImmutableMapEntrySet extends ImmutableSet
{
    abstract ImmutableMap map();
    
    @Override
    public int size() {
        return this.map().size();
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            final Object value = this.map().get(entry.getKey());
            return value != null && value.equals(entry.getValue());
        }
        return false;
    }
    
    @Override
    boolean isPartialView() {
        return this.map().isPartialView();
    }
    
    @GwtIncompatible("not used in GWT")
    @Override
    boolean isHashCodeFast() {
        return this.map().isHashCodeFast();
    }
    
    @Override
    public int hashCode() {
        return this.map().hashCode();
    }
    
    @GwtIncompatible("serialization")
    @Override
    Object writeReplace() {
        return new ImmutableMapEntrySet$EntrySetSerializedForm(this.map());
    }
}
