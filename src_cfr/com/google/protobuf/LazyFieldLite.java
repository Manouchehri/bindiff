/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;

public class LazyFieldLite {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    protected volatile MessageLite value;
    private volatile ByteString memoizedBytes;

    public LazyFieldLite(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        LazyFieldLite.checkArguments(extensionRegistryLite, byteString);
        this.extensionRegistry = extensionRegistryLite;
        this.delayedBytes = byteString;
    }

    public LazyFieldLite() {
    }

    public static LazyFieldLite fromValue(MessageLite messageLite) {
        LazyFieldLite lazyFieldLite = new LazyFieldLite();
        lazyFieldLite.setValue(messageLite);
        return lazyFieldLite;
    }

    public boolean containsDefaultInstance() {
        if (this.memoizedBytes == ByteString.EMPTY) return true;
        if (this.value != null) return false;
        if (this.delayedBytes == null) return true;
        if (this.delayedBytes != ByteString.EMPTY) return false;
        return true;
    }

    public void clear() {
        this.delayedBytes = null;
        this.value = null;
        this.memoizedBytes = null;
    }

    public void set(LazyFieldLite lazyFieldLite) {
        this.delayedBytes = lazyFieldLite.delayedBytes;
        this.value = lazyFieldLite.value;
        this.memoizedBytes = lazyFieldLite.memoizedBytes;
        if (lazyFieldLite.extensionRegistry == null) return;
        this.extensionRegistry = lazyFieldLite.extensionRegistry;
    }

    public MessageLite getValue(MessageLite messageLite) {
        this.ensureInitialized(messageLite);
        return this.value;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.value = messageLite;
        return messageLite2;
    }

    public void merge(LazyFieldLite lazyFieldLite) {
        if (lazyFieldLite.containsDefaultInstance()) {
            return;
        }
        if (this.containsDefaultInstance()) {
            this.set(lazyFieldLite);
            return;
        }
        if (this.extensionRegistry == null) {
            this.extensionRegistry = lazyFieldLite.extensionRegistry;
        }
        if (this.delayedBytes != null && lazyFieldLite.delayedBytes != null) {
            this.delayedBytes = this.delayedBytes.concat(lazyFieldLite.delayedBytes);
            return;
        }
        if (this.value == null && lazyFieldLite.value != null) {
            this.setValue(LazyFieldLite.mergeValueAndBytes(lazyFieldLite.value, this.delayedBytes, this.extensionRegistry));
            return;
        }
        if (this.value != null && lazyFieldLite.value == null) {
            this.setValue(LazyFieldLite.mergeValueAndBytes(this.value, lazyFieldLite.delayedBytes, lazyFieldLite.extensionRegistry));
            return;
        }
        if (lazyFieldLite.extensionRegistry != null) {
            this.setValue(LazyFieldLite.mergeValueAndBytes(this.value, lazyFieldLite.toByteString(), lazyFieldLite.extensionRegistry));
            return;
        }
        if (this.extensionRegistry != null) {
            this.setValue(LazyFieldLite.mergeValueAndBytes(lazyFieldLite.value, this.toByteString(), this.extensionRegistry));
            return;
        }
        this.setValue(LazyFieldLite.mergeValueAndBytes(this.value, lazyFieldLite.toByteString(), EMPTY_REGISTRY));
    }

    private static MessageLite mergeValueAndBytes(MessageLite messageLite, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return messageLite.toBuilder().mergeFrom(byteString, extensionRegistryLite).build();
        }
        catch (InvalidProtocolBufferException var3_3) {
            return messageLite;
        }
    }

    public void setByteString(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        LazyFieldLite.checkArguments(extensionRegistryLite, byteString);
        this.delayedBytes = byteString;
        this.extensionRegistry = extensionRegistryLite;
        this.value = null;
        this.memoizedBytes = null;
    }

    public int getSerializedSize() {
        if (this.delayedBytes != null) {
            return this.delayedBytes.size();
        }
        if (this.memoizedBytes != null) {
            return this.memoizedBytes.size();
        }
        if (this.value == null) return 0;
        return this.value.getSerializedSize();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ByteString toByteString() {
        if (this.delayedBytes != null) {
            return this.delayedBytes;
        }
        if (this.memoizedBytes != null) {
            return this.memoizedBytes;
        }
        LazyFieldLite lazyFieldLite = this;
        synchronized (lazyFieldLite) {
            if (this.memoizedBytes != null) {
                return this.memoizedBytes;
            }
            this.memoizedBytes = this.value == null ? ByteString.EMPTY : this.value.toByteString();
            return this.memoizedBytes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void ensureInitialized(MessageLite messageLite) {
        if (this.value != null) {
            return;
        }
        LazyFieldLite lazyFieldLite = this;
        synchronized (lazyFieldLite) {
            if (this.value != null) {
                return;
            }
            try {
                if (this.delayedBytes != null) {
                    MessageLite messageLite2;
                    this.value = messageLite2 = (MessageLite)messageLite.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry);
                    this.memoizedBytes = this.delayedBytes;
                    this.delayedBytes = null;
                } else {
                    this.value = messageLite;
                    this.memoizedBytes = ByteString.EMPTY;
                    this.delayedBytes = null;
                }
            }
            catch (InvalidProtocolBufferException var3_4) {
                this.value = messageLite;
                this.memoizedBytes = ByteString.EMPTY;
                this.delayedBytes = null;
            }
            return;
        }
    }

    private static void checkArguments(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        if (extensionRegistryLite == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        }
        if (byteString != null) return;
        throw new NullPointerException("found null ByteString");
    }
}

