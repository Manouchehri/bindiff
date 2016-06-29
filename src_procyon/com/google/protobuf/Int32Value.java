package com.google.protobuf;

import java.io.*;

public final class Int32Value extends GeneratedMessage implements Int32ValueOrBuilder
{
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Int32Value DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Int32Value(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Int32Value() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.value_ = 0;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Int32Value(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.value_ = codedInputStream.readInt32();
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
        return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int32Value.class, Int32Value$Builder.class);
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
            codedOutputStream.writeInt32(1, this.value_);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (this.value_ != 0) {
            memoizedSerializedSize2 += CodedOutputStream.computeInt32Size(1, this.value_);
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static Int32Value parseFrom(final ByteString byteString) {
        return (Int32Value)Int32Value.PARSER.parseFrom(byteString);
    }
    
    public static Int32Value parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)Int32Value.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Int32Value parseFrom(final byte[] array) {
        return (Int32Value)Int32Value.PARSER.parseFrom(array);
    }
    
    public static Int32Value parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)Int32Value.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Int32Value parseFrom(final InputStream inputStream) {
        return (Int32Value)Int32Value.PARSER.parseFrom(inputStream);
    }
    
    public static Int32Value parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)Int32Value.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Int32Value parseDelimitedFrom(final InputStream inputStream) {
        return (Int32Value)Int32Value.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Int32Value parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)Int32Value.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Int32Value parseFrom(final CodedInputStream codedInputStream) {
        return (Int32Value)Int32Value.PARSER.parseFrom(codedInputStream);
    }
    
    public static Int32Value parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)Int32Value.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Int32Value$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Int32Value$Builder newBuilder() {
        return Int32Value.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Int32Value$Builder newBuilder(final Int32Value int32Value) {
        return Int32Value.DEFAULT_INSTANCE.toBuilder().mergeFrom(int32Value);
    }
    
    public Int32Value$Builder toBuilder() {
        return (this == Int32Value.DEFAULT_INSTANCE) ? new Int32Value$Builder((Int32Value$1)null) : new Int32Value$Builder((Int32Value$1)null).mergeFrom(this);
    }
    
    protected Int32Value$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Int32Value$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Int32Value getDefaultInstance() {
        return Int32Value.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Int32Value.PARSER;
    }
    
    public Int32Value getDefaultInstanceForType() {
        return Int32Value.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Int32Value();
        PARSER = new Int32Value$1();
    }
}
