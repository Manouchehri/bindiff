package com.google.common.collect;

import java.io.*;
import com.google.common.base.*;
import java.util.*;

final class MultimapBuilder$TreeSetSupplier implements Supplier, Serializable
{
    private final Comparator comparator;
    
    MultimapBuilder$TreeSetSupplier(final Comparator comparator) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }
    
    @Override
    public SortedSet get() {
        return new TreeSet(this.comparator);
    }
}
