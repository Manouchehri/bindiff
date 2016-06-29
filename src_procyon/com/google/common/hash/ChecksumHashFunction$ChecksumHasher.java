package com.google.common.hash;

import java.util.zip.*;
import java.io.*;
import com.google.common.base.*;

final class ChecksumHashFunction$ChecksumHasher extends AbstractByteHasher
{
    private final Checksum checksum;
    final /* synthetic */ ChecksumHashFunction this$0;
    
    private ChecksumHashFunction$ChecksumHasher(final ChecksumHashFunction this$0, final Checksum checksum) {
        this.this$0 = this$0;
        this.checksum = (Checksum)Preconditions.checkNotNull(checksum);
    }
    
    @Override
    protected void update(final byte b) {
        this.checksum.update(b);
    }
    
    @Override
    protected void update(final byte[] array, final int n, final int n2) {
        this.checksum.update(array, n, n2);
    }
    
    @Override
    public HashCode hash() {
        final long value = this.checksum.getValue();
        if (this.this$0.bits == 32) {
            return HashCode.fromInt((int)value);
        }
        return HashCode.fromLong(value);
    }
}
