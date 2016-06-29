/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractByteHasher;
import com.google.common.hash.HashCode;
import com.google.common.hash.MessageDigestHashFunction$1;
import java.security.MessageDigest;
import java.util.Arrays;

final class MessageDigestHashFunction$MessageDigestHasher
extends AbstractByteHasher {
    private final MessageDigest digest;
    private final int bytes;
    private boolean done;

    private MessageDigestHashFunction$MessageDigestHasher(MessageDigest messageDigest, int n2) {
        this.digest = messageDigest;
        this.bytes = n2;
    }

    @Override
    protected void update(byte by2) {
        this.checkNotDone();
        this.digest.update(by2);
    }

    @Override
    protected void update(byte[] arrby) {
        this.checkNotDone();
        this.digest.update(arrby);
    }

    @Override
    protected void update(byte[] arrby, int n2, int n3) {
        this.checkNotDone();
        this.digest.update(arrby, n2, n3);
    }

    private void checkNotDone() {
        Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
    }

    @Override
    public HashCode hash() {
        HashCode hashCode;
        this.checkNotDone();
        this.done = true;
        if (this.bytes == this.digest.getDigestLength()) {
            hashCode = HashCode.fromBytesNoCopy(this.digest.digest());
            return hashCode;
        }
        hashCode = HashCode.fromBytesNoCopy(Arrays.copyOf(this.digest.digest(), this.bytes));
        return hashCode;
    }

    /* synthetic */ MessageDigestHashFunction$MessageDigestHasher(MessageDigest messageDigest, int n2, MessageDigestHashFunction$1 messageDigestHashFunction$1) {
        this(messageDigest, n2);
    }
}

