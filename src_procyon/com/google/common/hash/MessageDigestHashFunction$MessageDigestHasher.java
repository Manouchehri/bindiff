package com.google.common.hash;

import java.security.*;
import com.google.common.base.*;
import java.util.*;

final class MessageDigestHashFunction$MessageDigestHasher extends AbstractByteHasher
{
    private final MessageDigest digest;
    private final int bytes;
    private boolean done;
    
    private MessageDigestHashFunction$MessageDigestHasher(final MessageDigest digest, final int bytes) {
        this.digest = digest;
        this.bytes = bytes;
    }
    
    @Override
    protected void update(final byte b) {
        this.checkNotDone();
        this.digest.update(b);
    }
    
    @Override
    protected void update(final byte[] array) {
        this.checkNotDone();
        this.digest.update(array);
    }
    
    @Override
    protected void update(final byte[] array, final int n, final int n2) {
        this.checkNotDone();
        this.digest.update(array, n, n2);
    }
    
    private void checkNotDone() {
        Preconditions.checkState(!this.done, (Object)"Cannot re-use a Hasher after calling hash() on it");
    }
    
    @Override
    public HashCode hash() {
        this.checkNotDone();
        this.done = true;
        return (this.bytes == this.digest.getDigestLength()) ? HashCode.fromBytesNoCopy(this.digest.digest()) : HashCode.fromBytesNoCopy(Arrays.copyOf(this.digest.digest(), this.bytes));
    }
}
