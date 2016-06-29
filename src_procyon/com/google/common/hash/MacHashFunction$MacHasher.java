package com.google.common.hash;

import javax.crypto.*;
import com.google.common.base.*;

final class MacHashFunction$MacHasher extends AbstractByteHasher
{
    private final Mac mac;
    private boolean done;
    
    private MacHashFunction$MacHasher(final Mac mac) {
        this.mac = mac;
    }
    
    @Override
    protected void update(final byte b) {
        this.checkNotDone();
        this.mac.update(b);
    }
    
    @Override
    protected void update(final byte[] array) {
        this.checkNotDone();
        this.mac.update(array);
    }
    
    @Override
    protected void update(final byte[] array, final int n, final int n2) {
        this.checkNotDone();
        this.mac.update(array, n, n2);
    }
    
    private void checkNotDone() {
        Preconditions.checkState(!this.done, (Object)"Cannot re-use a Hasher after calling hash() on it");
    }
    
    @Override
    public HashCode hash() {
        this.checkNotDone();
        this.done = true;
        return HashCode.fromBytesNoCopy(this.mac.doFinal());
    }
}
