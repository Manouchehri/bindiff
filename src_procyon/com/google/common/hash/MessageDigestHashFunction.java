package com.google.common.hash;

import java.io.*;
import com.google.common.base.*;
import java.security.*;

final class MessageDigestHashFunction extends AbstractStreamingHashFunction implements Serializable
{
    private final MessageDigest prototype;
    private final int bytes;
    private final boolean supportsClone;
    private final String toString;
    
    MessageDigestHashFunction(final String s, final String s2) {
        this.prototype = getMessageDigest(s);
        this.bytes = this.prototype.getDigestLength();
        this.toString = (String)Preconditions.checkNotNull(s2);
        this.supportsClone = this.supportsClone();
    }
    
    MessageDigestHashFunction(final String s, final int bytes, final String s2) {
        this.toString = (String)Preconditions.checkNotNull(s2);
        this.prototype = getMessageDigest(s);
        final int digestLength = this.prototype.getDigestLength();
        Preconditions.checkArgument(bytes >= 4 && bytes <= digestLength, "bytes (%s) must be >= 4 and < %s", bytes, digestLength);
        this.bytes = bytes;
        this.supportsClone = this.supportsClone();
    }
    
    private boolean supportsClone() {
        try {
            this.prototype.clone();
            return true;
        }
        catch (CloneNotSupportedException ex) {
            return false;
        }
    }
    
    @Override
    public int bits() {
        return this.bytes * 8;
    }
    
    @Override
    public String toString() {
        return this.toString;
    }
    
    private static MessageDigest getMessageDigest(final String s) {
        try {
            return MessageDigest.getInstance(s);
        }
        catch (NoSuchAlgorithmException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public Hasher newHasher() {
        if (this.supportsClone) {
            try {
                return new MessageDigestHashFunction$MessageDigestHasher((MessageDigest)this.prototype.clone(), this.bytes, null);
            }
            catch (CloneNotSupportedException ex) {}
        }
        return new MessageDigestHashFunction$MessageDigestHasher(getMessageDigest(this.prototype.getAlgorithm()), this.bytes, null);
    }
    
    Object writeReplace() {
        return new MessageDigestHashFunction$SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null);
    }
}
