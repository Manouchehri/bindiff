/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.MessageDigestHashFunction$1;
import com.google.common.hash.MessageDigestHashFunction$MessageDigestHasher;
import com.google.common.hash.MessageDigestHashFunction$SerializedForm;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class MessageDigestHashFunction
extends AbstractStreamingHashFunction
implements Serializable {
    private final MessageDigest prototype;
    private final int bytes;
    private final boolean supportsClone;
    private final String toString;

    MessageDigestHashFunction(String string, String string2) {
        this.prototype = MessageDigestHashFunction.getMessageDigest(string);
        this.bytes = this.prototype.getDigestLength();
        this.toString = (String)Preconditions.checkNotNull(string2);
        this.supportsClone = this.supportsClone();
    }

    MessageDigestHashFunction(String string, int n2, String string2) {
        this.toString = (String)Preconditions.checkNotNull(string2);
        this.prototype = MessageDigestHashFunction.getMessageDigest(string);
        int n3 = this.prototype.getDigestLength();
        Preconditions.checkArgument(n2 >= 4 && n2 <= n3, "bytes (%s) must be >= 4 and < %s", n2, n3);
        this.bytes = n2;
        this.supportsClone = this.supportsClone();
    }

    private boolean supportsClone() {
        try {
            this.prototype.clone();
            return true;
        }
        catch (CloneNotSupportedException var1_1) {
            return false;
        }
    }

    @Override
    public int bits() {
        return this.bytes * 8;
    }

    public String toString() {
        return this.toString;
    }

    private static MessageDigest getMessageDigest(String string) {
        try {
            return MessageDigest.getInstance(string);
        }
        catch (NoSuchAlgorithmException var1_1) {
            throw new AssertionError(var1_1);
        }
    }

    @Override
    public Hasher newHasher() {
        if (!this.supportsClone) return new MessageDigestHashFunction$MessageDigestHasher(MessageDigestHashFunction.getMessageDigest(this.prototype.getAlgorithm()), this.bytes, null);
        try {
            return new MessageDigestHashFunction$MessageDigestHasher((MessageDigest)this.prototype.clone(), this.bytes, null);
        }
        catch (CloneNotSupportedException var1_1) {
            // empty catch block
        }
        return new MessageDigestHashFunction$MessageDigestHasher(MessageDigestHashFunction.getMessageDigest(this.prototype.getAlgorithm()), this.bytes, null);
    }

    Object writeReplace() {
        return new MessageDigestHashFunction$SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null);
    }
}

