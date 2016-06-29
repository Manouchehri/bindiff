package com.google.protobuf;

import java.io.*;

public final class DoubleValue extends GeneratedMessage implements DoubleValueOrBuilder
{
    public static final int VALUE_FIELD_NUMBER = 1;
    private double value_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DoubleValue DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DoubleValue(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DoubleValue() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.value_ = 0.0;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private DoubleValue(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 9: {
                        this.value_ = codedInputStream.readDouble();
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
        return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_fieldAccessorTable.ensureFieldAccessorsInitialized(DoubleValue.class, DoubleValue$Builder.class);
    }
    
    public double getValue() {
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
        if (this.value_ != 0.0) {
            codedOutputStream.writeDouble(1, this.value_);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (this.value_ != 0.0) {
            memoizedSerializedSize2 += CodedOutputStream.computeDoubleSize(1, this.value_);
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static DoubleValue parseFrom(final ByteString byteString) {
        return (DoubleValue)DoubleValue.PARSER.parseFrom(byteString);
    }
    
    public static DoubleValue parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)DoubleValue.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DoubleValue parseFrom(final byte[] array) {
        return (DoubleValue)DoubleValue.PARSER.parseFrom(array);
    }
    
    public static DoubleValue parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)DoubleValue.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DoubleValue parseFrom(final InputStream inputStream) {
        return (DoubleValue)DoubleValue.PARSER.parseFrom(inputStream);
    }
    
    public static DoubleValue parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)DoubleValue.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DoubleValue parseDelimitedFrom(final InputStream inputStream) {
        return (DoubleValue)DoubleValue.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DoubleValue parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)DoubleValue.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DoubleValue parseFrom(final CodedInputStream codedInputStream) {
        return (DoubleValue)DoubleValue.PARSER.parseFrom(codedInputStream);
    }
    
    public static DoubleValue parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)DoubleValue.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DoubleValue$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DoubleValue$Builder newBuilder() {
        return DoubleValue.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DoubleValue$Builder newBuilder(final DoubleValue doubleValue) {
        return DoubleValue.DEFAULT_INSTANCE.toBuilder().mergeFrom(doubleValue);
    }
    
    public DoubleValue$Builder toBuilder() {
        return (this == DoubleValue.DEFAULT_INSTANCE) ? new DoubleValue$Builder((DoubleValue$1)null) : new DoubleValue$Builder((DoubleValue$1)null).mergeFrom(this);
    }
    
    protected DoubleValue$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DoubleValue$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DoubleValue getDefaultInstance() {
        return DoubleValue.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DoubleValue.PARSER;
    }
    
    public DoubleValue getDefaultInstanceForType() {
        return DoubleValue.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DoubleValue();
        PARSER = new DoubleValue$1();
    }
}
