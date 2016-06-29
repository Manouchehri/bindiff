package com.google.protobuf;

import java.io.*;

public final class BoolValue extends GeneratedMessage implements BoolValueOrBuilder
{
    public static final int VALUE_FIELD_NUMBER = 1;
    private boolean value_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final BoolValue DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private BoolValue(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private BoolValue() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.value_ = false;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private BoolValue(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.value_ = codedInputStream.readBool();
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
        return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BoolValue.class, BoolValue$Builder.class);
    }
    
    public boolean getValue() {
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
        if (this.value_) {
            codedOutputStream.writeBool(1, this.value_);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (this.value_) {
            memoizedSerializedSize2 += CodedOutputStream.computeBoolSize(1, this.value_);
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static BoolValue parseFrom(final ByteString byteString) {
        return (BoolValue)BoolValue.PARSER.parseFrom(byteString);
    }
    
    public static BoolValue parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)BoolValue.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static BoolValue parseFrom(final byte[] array) {
        return (BoolValue)BoolValue.PARSER.parseFrom(array);
    }
    
    public static BoolValue parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)BoolValue.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static BoolValue parseFrom(final InputStream inputStream) {
        return (BoolValue)BoolValue.PARSER.parseFrom(inputStream);
    }
    
    public static BoolValue parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)BoolValue.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static BoolValue parseDelimitedFrom(final InputStream inputStream) {
        return (BoolValue)BoolValue.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static BoolValue parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)BoolValue.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static BoolValue parseFrom(final CodedInputStream codedInputStream) {
        return (BoolValue)BoolValue.PARSER.parseFrom(codedInputStream);
    }
    
    public static BoolValue parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)BoolValue.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public BoolValue$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static BoolValue$Builder newBuilder() {
        return BoolValue.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static BoolValue$Builder newBuilder(final BoolValue boolValue) {
        return BoolValue.DEFAULT_INSTANCE.toBuilder().mergeFrom(boolValue);
    }
    
    public BoolValue$Builder toBuilder() {
        return (this == BoolValue.DEFAULT_INSTANCE) ? new BoolValue$Builder((BoolValue$1)null) : new BoolValue$Builder((BoolValue$1)null).mergeFrom(this);
    }
    
    protected BoolValue$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BoolValue$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static BoolValue getDefaultInstance() {
        return BoolValue.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return BoolValue.PARSER;
    }
    
    public BoolValue getDefaultInstanceForType() {
        return BoolValue.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new BoolValue();
        PARSER = new BoolValue$1();
    }
}
