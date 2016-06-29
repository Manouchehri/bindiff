package com.google.protobuf;

import java.io.*;

public final class UInt64Value extends GeneratedMessage implements UInt64ValueOrBuilder
{
    public static final int VALUE_FIELD_NUMBER = 1;
    private long value_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final UInt64Value DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private UInt64Value(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private UInt64Value() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.value_ = 0L;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private UInt64Value(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        try {
            int i = 0;
            while (i == 0) {
                final int tag = codedInputStream.readTag();
                switch (tag) {
                    case 0: {
                        i = 1;
                        continue;
                    }
                    default: {
                        if (!codedInputStream.skipField(tag)) {
                            i = 1;
                            continue;
                        }
                        continue;
                    }
                    case 8: {
                        this.value_ = codedInputStream.readUInt64();
                        continue;
                    }
                }
            }
        }
        catch (InvalidProtocolBufferException ex) {
            throw new RuntimeException(ex.setUnfinishedMessage(this));
        }
        catch (IOException ex2) {
            throw new RuntimeException(new InvalidProtocolBufferException(ex2.getMessage()).setUnfinishedMessage(this));
        }
        finally {
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt64Value.class, UInt64Value$Builder.class);
    }
    
    public long getValue() {
        return this.value_;
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if (this.value_ != 0L) {
            codedOutputStream.writeUInt64(1, this.value_);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (this.value_ != 0L) {
            memoizedSerializedSize2 += CodedOutputStream.computeUInt64Size(1, this.value_);
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static UInt64Value parseFrom(final ByteString byteString) {
        return (UInt64Value)UInt64Value.PARSER.parseFrom(byteString);
    }
    
    public static UInt64Value parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (UInt64Value)UInt64Value.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static UInt64Value parseFrom(final byte[] array) {
        return (UInt64Value)UInt64Value.PARSER.parseFrom(array);
    }
    
    public static UInt64Value parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (UInt64Value)UInt64Value.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static UInt64Value parseFrom(final InputStream inputStream) {
        return (UInt64Value)UInt64Value.PARSER.parseFrom(inputStream);
    }
    
    public static UInt64Value parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (UInt64Value)UInt64Value.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static UInt64Value parseDelimitedFrom(final InputStream inputStream) {
        return (UInt64Value)UInt64Value.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static UInt64Value parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (UInt64Value)UInt64Value.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static UInt64Value parseFrom(final CodedInputStream codedInputStream) {
        return (UInt64Value)UInt64Value.PARSER.parseFrom(codedInputStream);
    }
    
    public static UInt64Value parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (UInt64Value)UInt64Value.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public UInt64Value$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static UInt64Value$Builder newBuilder() {
        return UInt64Value.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static UInt64Value$Builder newBuilder(final UInt64Value uInt64Value) {
        return UInt64Value.DEFAULT_INSTANCE.toBuilder().mergeFrom(uInt64Value);
    }
    
    public UInt64Value$Builder toBuilder() {
        return (this == UInt64Value.DEFAULT_INSTANCE) ? new UInt64Value$Builder((UInt64Value$1)null) : new UInt64Value$Builder((UInt64Value$1)null).mergeFrom(this);
    }
    
    protected UInt64Value$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new UInt64Value$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static UInt64Value getDefaultInstance() {
        return UInt64Value.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return UInt64Value.PARSER;
    }
    
    public UInt64Value getDefaultInstanceForType() {
        return UInt64Value.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new UInt64Value();
        PARSER = new UInt64Value$1();
    }
}
