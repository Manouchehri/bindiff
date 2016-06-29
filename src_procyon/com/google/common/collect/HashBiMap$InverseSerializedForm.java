package com.google.common.collect;

import java.io.*;

final class HashBiMap$InverseSerializedForm implements Serializable
{
    private final HashBiMap bimap;
    
    HashBiMap$InverseSerializedForm(final HashBiMap bimap) {
        this.bimap = bimap;
    }
    
    Object readResolve() {
        return this.bimap.inverse();
    }
}
