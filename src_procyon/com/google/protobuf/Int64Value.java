package com.google.protobuf;

import java.io.*;

public final class Int64Value extends GeneratedMessage implements Int64ValueOrBuilder
{
    public static final int VALUE_FIELD_NUMBER = 1;
    private long value_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Int64Value DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Int64Value(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Int64Value() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.value_ = 0L;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Int64Value(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.value_ = codedInputStream.readInt64();
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
        return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int64Value.class, Int64Value$Builder.class);
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
            codedOutputStream.writeInt64(1, this.value_);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (this.value_ != 0L) {
            memoizedSerializedSize2 += CodedOutputStream.computeInt64Size(1, this.value_);
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static Int64Value parseFrom(final ByteString byteString) {
        return (Int64Value)Int64Value.PARSER.parseFrom(byteString);
    }
    
    public static Int64Value parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)Int64Value.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Int64Value parseFrom(final byte[] array) {
        return (Int64Value)Int64Value.PARSER.parseFrom(array);
    }
    
    public static Int64Value parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)Int64Value.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Int64Value parseFrom(final InputStream inputStream) {
        return (Int64Value)Int64Value.PARSER.parseFrom(inputStream);
    }
    
    public static Int64Value parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)Int64Value.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Int64Value parseDelimitedFrom(final InputStream inputStream) {
        return (Int64Value)Int64Value.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Int64Value parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)Int64Value.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Int64Value parseFrom(final CodedInputStream codedInputStream) {
        return (Int64Value)Int64Value.PARSER.parseFrom(codedInputStream);
    }
    
    public static Int64Value parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)Int64Value.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Int64Value$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Int64Value$Builder newBuilder() {
        return Int64Value.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Int64Value$Builder newBuilder(final Int64Value int64Value) {
        return Int64Value.DEFAULT_INSTANCE.toBuilder().mergeFrom(int64Value);
    }
    
    public Int64Value$Builder toBuilder() {
        return (this == Int64Value.DEFAULT_INSTANCE) ? new Int64Value$Builder((Int64Value$1)null) : new Int64Value$Builder((Int64Value$1)null).mergeFrom(this);
    }
    
    protected Int64Value$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Int64Value$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Int64Value getDefaultInstance() {
        return Int64Value.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Int64Value.PARSER;
    }
    
    public Int64Value getDefaultInstanceForType() {
        return Int64Value.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Int64Value();
        PARSER = new Int64Value$1();
    }
}
