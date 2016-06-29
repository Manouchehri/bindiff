package com.google.common.collect;

import java.io.*;
import com.google.common.base.*;
import java.util.*;

final class MultimapBuilder$EnumSetSupplier implements Supplier, Serializable
{
    private final Class clazz;
    
    MultimapBuilder$EnumSetSupplier(final Class clazz) {
        this.clazz = (Class)Preconditions.checkNotNull(clazz);
    }
    
    @Override
    public Set get() {
        return EnumSet.noneOf((Class<Enum>)this.clazz);
    }
}
