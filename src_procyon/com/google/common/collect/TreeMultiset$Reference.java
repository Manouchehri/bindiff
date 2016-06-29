package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

final class TreeMultiset$Reference
{
    @Nullable
    private Object value;
    
    @Nullable
    public Object get() {
        return this.value;
    }
    
    public void checkAndSet(@Nullable final Object o, final Object value) {
        if (this.value != o) {
            throw new ConcurrentModificationException();
        }
        this.value = value;
    }
}
