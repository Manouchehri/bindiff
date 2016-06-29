package com.google.protobuf;

public class LazyFieldLite
{
    private static final ExtensionRegistryLite EMPTY_REGISTRY;
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    protected volatile MessageLite value;
    private volatile ByteString memoizedBytes;
    
    public LazyFieldLite(final ExtensionRegistryLite extensionRegistry, final ByteString delayedBytes) {
        checkArguments(extensionRegistry, delayedBytes);
        this.extensionRegistry = extensionRegistry;
        this.delayedBytes = delayedBytes;
    }
    
    public LazyFieldLite() {
    }
    
    public static LazyFieldLite fromValue(final MessageLite value) {
        final LazyFieldLite lazyFieldLite = new LazyFieldLite();
        lazyFieldLite.setValue(value);
        return lazyFieldLite;
    }
    
    public boolean containsDefaultInstance() {
        return this.memoizedBytes == ByteString.EMPTY || (this.value == null && (this.delayedBytes == null || this.delayedBytes == ByteString.EMPTY));
    }
    
    public void clear() {
        this.delayedBytes = null;
        this.value = null;
        this.memoizedBytes = null;
    }
    
    public void set(final LazyFieldLite lazyFieldLite) {
        this.delayedBytes = lazyFieldLite.delayedBytes;
        this.value = lazyFieldLite.value;
        this.memoizedBytes = lazyFieldLite.memoizedBytes;
        if (lazyFieldLite.extensionRegistry != null) {
            this.extensionRegistry = lazyFieldLite.extensionRegistry;
        }
    }
    
    public MessageLite getValue(final MessageLite messageLite) {
        this.ensureInitialized(messageLite);
        return this.value;
    }
    
    public MessageLite setValue(final MessageLite value) {
        final MessageLite value2 = this.value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.value = value;
        return value2;
    }
    
    public void merge(final LazyFieldLite lazyFieldLite) {
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
            this.setValue(mergeValueAndBytes(lazyFieldLite.value, this.delayedBytes, this.extensionRegistry));
            return;
        }
        if (this.value != null && lazyFieldLite.value == null) {
            this.setValue(mergeValueAndBytes(this.value, lazyFieldLite.delayedBytes, lazyFieldLite.extensionRegistry));
            return;
        }
        if (lazyFieldLite.extensionRegistry != null) {
            this.setValue(mergeValueAndBytes(this.value, lazyFieldLite.toByteString(), lazyFieldLite.extensionRegistry));
            return;
        }
        if (this.extensionRegistry != null) {
            this.setValue(mergeValueAndBytes(lazyFieldLite.value, this.toByteString(), this.extensionRegistry));
            return;
        }
        this.setValue(mergeValueAndBytes(this.value, lazyFieldLite.toByteString(), LazyFieldLite.EMPTY_REGISTRY));
    }
    
    private static MessageLite mergeValueAndBytes(final MessageLite messageLite, final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return messageLite.toBuilder().mergeFrom(byteString, extensionRegistryLite).build();
        }
        catch (InvalidProtocolBufferException ex) {
            return messageLite;
        }
    }
    
    public void setByteString(final ByteString delayedBytes, final ExtensionRegistryLite extensionRegistry) {
        checkArguments(extensionRegistry, delayedBytes);
        this.delayedBytes = delayedBytes;
        this.extensionRegistry = extensionRegistry;
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
        if (this.value != null) {
            return this.value.getSerializedSize();
        }
        return 0;
    }
    
    public ByteString toByteString() {
        if (this.delayedBytes != null) {
            return this.delayedBytes;
        }
        if (this.memoizedBytes != null) {
            return this.memoizedBytes;
        }
        synchronized (this) {
            if (this.memoizedBytes != null) {
                return this.memoizedBytes;
            }
            if (this.value == null) {
                this.memoizedBytes = ByteString.EMPTY;
            }
            else {
                this.memoizedBytes = this.value.toByteString();
            }
            return this.memoizedBytes;
        }
    }
    
    protected void ensureInitialized(final MessageLite messageLite) {
        if (this.value != null) {
            return;
        }
        synchronized (this) {
            if (this.value != null) {
                return;
            }
            try {
                if (this.delayedBytes != null) {
                    this.value = (MessageLite)messageLite.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry);
                    this.memoizedBytes = this.delayedBytes;
                    this.delayedBytes = null;
                }
                else {
                    this.value = messageLite;
                    this.memoizedBytes = ByteString.EMPTY;
                    this.delayedBytes = null;
                }
            }
            catch (InvalidProtocolBufferException ex) {
                this.value = messageLite;
                this.memoizedBytes = ByteString.EMPTY;
                this.delayedBytes = null;
            }
        }
    }
    
    private static void checkArguments(final ExtensionRegistryLite extensionRegistryLite, final ByteString byteString) {
        if (extensionRegistryLite == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        }
        if (byteString == null) {
            throw new NullPointerException("found null ByteString");
        }
    }
    
    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }
}
