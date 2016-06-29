package com.google.protobuf;

import java.io.*;

public final class UInt32Value extends GeneratedMessage implements UInt32ValueOrBuilder
{
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final UInt32Value DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private UInt32Value(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private UInt32Value() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.value_ = 0;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private UInt32Value(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.value_ = codedInputStream.readUInt32();
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
        return WrappersProto.internal_static_google_protobuf_UInt32Value_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_UInt32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt32Value.class, UInt32Value$Builder.class);
    }
    
    public int getValue() {
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
        if (this.value_ != 0) {
            codedOutputStream.writeUInt32(1, this.value_);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (this.value_ != 0) {
            memoizedSerializedSize2 += CodedOutputStream.computeUInt32Size(1, this.value_);
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static UInt32Value parseFrom(final ByteString byteString) {
        return (UInt32Value)UInt32Value.PARSER.parseFrom(byteString);
    }
    
    public static UInt32Value parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (UInt32Value)UInt32Value.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static UInt32Value parseFrom(final byte[] array) {
        return (UInt32Value)UInt32Value.PARSER.parseFrom(array);
    }
    
    public static UInt32Value parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (UInt32Value)UInt32Value.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static UInt32Value parseFrom(final InputStream inputStream) {
        return (UInt32Value)UInt32Value.PARSER.parseFrom(inputStream);
    }
    
    public static UInt32Value parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (UInt32Value)UInt32Value.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static UInt32Value parseDelimitedFrom(final InputStream inputStream) {
        return (UInt32Value)UInt32Value.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static UInt32Value parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (UInt32Value)UInt32Value.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static UInt32Value parseFrom(final CodedInputStream codedInputStream) {
        return (UInt32Value)UInt32Value.PARSER.parseFrom(codedInputStream);
    }
    
    public static UInt32Value parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (UInt32Value)UInt32Value.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public UInt32Value$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static UInt32Value$Builder newBuilder() {
        return UInt32Value.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static UInt32Value$Builder newBuilder(final UInt32Value uInt32Value) {
        return UInt32Value.DEFAULT_INSTANCE.toBuilder().mergeFrom(uInt32Value);
    }
    
    public UInt32Value$Builder toBuilder() {
        return (this == UInt32Value.DEFAULT_INSTANCE) ? new UInt32Value$Builder((UInt32Value$1)null) : new UInt32Value$Builder((UInt32Value$1)null).mergeFrom(this);
    }
    
    protected UInt32Value$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new UInt32Value$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static UInt32Value getDefaultInstance() {
        return UInt32Value.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return UInt32Value.PARSER;
    }
    
    public UInt32Value getDefaultInstanceForType() {
        return UInt32Value.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new UInt32Value();
        PARSER = new UInt32Value$1();
    }
}
