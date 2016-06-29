package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

enum MultimapBuilder$LinkedListSupplier implements Supplier
{
    INSTANCE("INSTANCE", 0);
    
    private MultimapBuilder$LinkedListSupplier(final String s, final int n) {
    }
    
    public static Supplier instance() {
        return MultimapBuilder$LinkedListSupplier.INSTANCE;
    }
    
    @Override
    public List get() {
        return new LinkedList();
    }
}
