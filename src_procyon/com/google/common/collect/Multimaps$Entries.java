package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

abstract class Multimaps$Entries extends AbstractCollection
{
    abstract Multimap multimap();
    
    @Override
    public int size() {
        return this.multimap().size();
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            return this.multimap().containsEntry(entry.getKey(), entry.getValue());
        }
        return false;
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            return this.multimap().remove(entry.getKey(), entry.getValue());
        }
        return false;
    }
    
    @Override
    public void clear() {
        this.multimap().clear();
    }
}
