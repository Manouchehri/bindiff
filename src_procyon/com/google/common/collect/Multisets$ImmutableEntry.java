package com.google.common.collect;

import java.io.*;
import javax.annotation.*;

class Multisets$ImmutableEntry extends Multisets$AbstractEntry implements Serializable
{
    @Nullable
    private final Object element;
    private final int count;
    private static final long serialVersionUID = 0L;
    
    Multisets$ImmutableEntry(@Nullable final Object element, final int count) {
        this.element = element;
        CollectPreconditions.checkNonnegative(this.count = count, "count");
    }
    
    @Nullable
    @Override
    public final Object getElement() {
        return this.element;
    }
    
    @Override
    public final int getCount() {
        return this.count;
    }
    
    public Multisets$ImmutableEntry nextInBucket() {
        return null;
    }
}
