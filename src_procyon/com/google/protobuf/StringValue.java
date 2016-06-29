package com.google.protobuf;

import java.io.*;

public final class StringValue extends GeneratedMessage implements StringValueOrBuilder
{
    public static final int VALUE_FIELD_NUMBER = 1;
    private volatile Object value_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final StringValue DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private StringValue(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private StringValue() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.value_ = "";
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private StringValue(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
        return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_StringValue_fieldAccessorTable.ensureFieldAccessorsInitialized(StringValue.class, StringValue$Builder.class);
    }
    
    public String getValue() {
        final Object value_ = this.value_;
        if (value_ instanceof String) {
            return (String)value_;
        }
        final ByteString byteString = (ByteString)value_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.value_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getValueBytes() {
        final Object value_ = this.value_;
        if (value_ instanceof String) {
            return (ByteString)(this.value_ = ByteString.copyFromUtf8((String)value_));
        }
        return (ByteString)value_;
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
        if (!this.getValueBytes().isEmpty()) {
            codedOutputStream.writeBytes(1, this.getValueBytes());
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (!this.getValueBytes().isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(1, this.getValueBytes());
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static StringValue parseFrom(final ByteString byteString) {
        return (StringValue)StringValue.PARSER.parseFrom(byteString);
    }
    
    public static StringValue parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)StringValue.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static StringValue parseFrom(final byte[] array) {
        return (StringValue)StringValue.PARSER.parseFrom(array);
    }
    
    public static StringValue parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)StringValue.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static StringValue parseFrom(final InputStream inputStream) {
        return (StringValue)StringValue.PARSER.parseFrom(inputStream);
    }
    
    public static StringValue parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)StringValue.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static StringValue parseDelimitedFrom(final InputStream inputStream) {
        return (StringValue)StringValue.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static StringValue parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)StringValue.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static StringValue parseFrom(final CodedInputStream codedInputStream) {
        return (StringValue)StringValue.PARSER.parseFrom(codedInputStream);
    }
    
    public static StringValue parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)StringValue.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public StringValue$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static StringValue$Builder newBuilder() {
        return StringValue.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static StringValue$Builder newBuilder(final StringValue stringValue) {
        return StringValue.DEFAULT_INSTANCE.toBuilder().mergeFrom(stringValue);
    }
    
    public StringValue$Builder toBuilder() {
        return (this == StringValue.DEFAULT_INSTANCE) ? new StringValue$Builder((StringValue$1)null) : new StringValue$Builder((StringValue$1)null).mergeFrom(this);
    }
    
    protected StringValue$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new StringValue$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static StringValue getDefaultInstance() {
        return StringValue.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return StringValue.PARSER;
    }
    
    public StringValue getDefaultInstanceForType() {
        return StringValue.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new StringValue();
        PARSER = new StringValue$1();
    }
}
