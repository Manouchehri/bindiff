package com.google.protobuf;

import java.io.*;

public final class BytesValue extends GeneratedMessage implements BytesValueOrBuilder
{
    public static final int VALUE_FIELD_NUMBER = 1;
    private ByteString value_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final BytesValue DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private BytesValue(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private BytesValue() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.value_ = ByteString.EMPTY;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private BytesValue(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 10: {
                        this.value_ = codedInputStream.readBytes();
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
        return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BytesValue.class, BytesValue$Builder.class);
    }
    
    public ByteString getValue() {
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
        if (!this.value_.isEmpty()) {
            codedOutputStream.writeBytes(1, this.value_);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (!this.value_.isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(1, this.value_);
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static BytesValue parseFrom(final ByteString byteString) {
        return (BytesValue)BytesValue.PARSER.parseFrom(byteString);
    }
    
    public static BytesValue parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)BytesValue.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static BytesValue parseFrom(final byte[] array) {
        return (BytesValue)BytesValue.PARSER.parseFrom(array);
    }
    
    public static BytesValue parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)BytesValue.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static BytesValue parseFrom(final InputStream inputStream) {
        return (BytesValue)BytesValue.PARSER.parseFrom(inputStream);
    }
    
    public static BytesValue parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)BytesValue.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static BytesValue parseDelimitedFrom(final InputStream inputStream) {
        return (BytesValue)BytesValue.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static BytesValue parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)BytesValue.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static BytesValue parseFrom(final CodedInputStream codedInputStream) {
        return (BytesValue)BytesValue.PARSER.parseFrom(codedInputStream);
    }
    
    public static BytesValue parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)BytesValue.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public BytesValue$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static BytesValue$Builder newBuilder() {
        return BytesValue.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static BytesValue$Builder newBuilder(final BytesValue bytesValue) {
        return BytesValue.DEFAULT_INSTANCE.toBuilder().mergeFrom(bytesValue);
    }
    
    public BytesValue$Builder toBuilder() {
        return (this == BytesValue.DEFAULT_INSTANCE) ? new BytesValue$Builder((BytesValue$1)null) : new BytesValue$Builder((BytesValue$1)null).mergeFrom(this);
    }
    
    protected BytesValue$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BytesValue$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static BytesValue getDefaultInstance() {
        return BytesValue.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return BytesValue.PARSER;
    }
    
    public BytesValue getDefaultInstanceForType() {
        return BytesValue.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new BytesValue();
        PARSER = new BytesValue$1();
    }
}
