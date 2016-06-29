package com.google.protobuf;

import java.io.*;

public final class FloatValue extends GeneratedMessage implements FloatValueOrBuilder
{
    public static final int VALUE_FIELD_NUMBER = 1;
    private float value_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final FloatValue DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private FloatValue(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private FloatValue() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.value_ = 0.0f;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private FloatValue(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 13: {
                        this.value_ = codedInputStream.readFloat();
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
        return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_fieldAccessorTable.ensureFieldAccessorsInitialized(FloatValue.class, FloatValue$Builder.class);
    }
    
    public float getValue() {
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
        if (this.value_ != 0.0f) {
            codedOutputStream.writeFloat(1, this.value_);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (this.value_ != 0.0f) {
            memoizedSerializedSize2 += CodedOutputStream.computeFloatSize(1, this.value_);
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static FloatValue parseFrom(final ByteString byteString) {
        return (FloatValue)FloatValue.PARSER.parseFrom(byteString);
    }
    
    public static FloatValue parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (FloatValue)FloatValue.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static FloatValue parseFrom(final byte[] array) {
        return (FloatValue)FloatValue.PARSER.parseFrom(array);
    }
    
    public static FloatValue parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (FloatValue)FloatValue.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static FloatValue parseFrom(final InputStream inputStream) {
        return (FloatValue)FloatValue.PARSER.parseFrom(inputStream);
    }
    
    public static FloatValue parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (FloatValue)FloatValue.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static FloatValue parseDelimitedFrom(final InputStream inputStream) {
        return (FloatValue)FloatValue.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static FloatValue parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (FloatValue)FloatValue.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static FloatValue parseFrom(final CodedInputStream codedInputStream) {
        return (FloatValue)FloatValue.PARSER.parseFrom(codedInputStream);
    }
    
    public static FloatValue parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (FloatValue)FloatValue.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public FloatValue$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static FloatValue$Builder newBuilder() {
        return FloatValue.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static FloatValue$Builder newBuilder(final FloatValue floatValue) {
        return FloatValue.DEFAULT_INSTANCE.toBuilder().mergeFrom(floatValue);
    }
    
    public FloatValue$Builder toBuilder() {
        return (this == FloatValue.DEFAULT_INSTANCE) ? new FloatValue$Builder((FloatValue$1)null) : new FloatValue$Builder((FloatValue$1)null).mergeFrom(this);
    }
    
    protected FloatValue$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new FloatValue$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static FloatValue getDefaultInstance() {
        return FloatValue.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return FloatValue.PARSER;
    }
    
    public FloatValue getDefaultInstanceForType() {
        return FloatValue.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new FloatValue();
        PARSER = new FloatValue$1();
    }
}
