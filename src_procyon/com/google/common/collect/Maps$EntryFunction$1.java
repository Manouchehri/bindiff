package com.google.common.collect;

import java.util.*;
import javax.annotation.*;

enum Maps$EntryFunction$1
{
    Maps$EntryFunction$1(final String s, final int n) {
    }
    
    @Nullable
    public Object apply(final Map.Entry entry) {
        return entry.getKey();
    }
}
