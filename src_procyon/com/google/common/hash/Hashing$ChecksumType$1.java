package com.google.common.hash;

import java.util.zip.*;

enum Hashing$ChecksumType$1
{
    Hashing$ChecksumType$1(final String s, final int n, final int n2) {
    }
    
    @Override
    public Checksum get() {
        return new CRC32();
    }
}
