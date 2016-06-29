/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractByteHasher;
import com.google.common.hash.HashCode;
import com.google.common.hash.MacHashFunction$1;
import javax.crypto.Mac;

final class MacHashFunction$MacHasher
extends AbstractByteHasher {
    private final Mac mac;
    private boolean done;

    private MacHashFunction$MacHasher(Mac mac) {
        this.mac = mac;
    }

    @Override
    protected void update(byte by2) {
        this.checkNotDone();
        this.mac.update(by2);
    }

    @Override
    protected void update(byte[] arrby) {
        this.checkNotDone();
        this.mac.update(arrby);
    }

    @Override
    protected void update(byte[] arrby, int n2, int n3) {
        this.checkNotDone();
        this.mac.update(arrby, n2, n3);
    }

    private void checkNotDone() {
        Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
    }

    @Override
    public HashCode hash() {
        this.checkNotDone();
        this.done = true;
        return HashCode.fromBytesNoCopy(this.mac.doFinal());
    }

    /* synthetic */ MacHashFunction$MacHasher(Mac mac, MacHashFunction$1 macHashFunction$1) {
        this(mac);
    }
}

