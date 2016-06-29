package com.google.common.hash;

import java.util.zip.*;

enum Hashing$ChecksumType$2
{
    Hashing$ChecksumType$2(final String s, final int n, final int n2) {
    }
    
    @Override
    public Checksum get() {
        return new Adler32();
    }
}
