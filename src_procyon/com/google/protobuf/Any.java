package com.google.protobuf;

import java.io.*;

public final class Any extends GeneratedMessage implements AnyOrBuilder
{
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    private volatile Object typeUrl_;
    public static final int VALUE_FIELD_NUMBER = 2;
    private ByteString value_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Any DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Any(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Any() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Any(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.typeUrl_ = codedInputStream.readBytes();
                        continue;
                    }
                    case 18: {
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
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Any$Builder.class);
    }
    
    public String getTypeUrl() {
        final Object typeUrl_ = this.typeUrl_;
        if (typeUrl_ instanceof String) {
            return (String)typeUrl_;
        }
        final ByteString byteString = (ByteString)typeUrl_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.typeUrl_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getTypeUrlBytes() {
        final Object typeUrl_ = this.typeUrl_;
        if (typeUrl_ instanceof String) {
            return (ByteString)(this.typeUrl_ = ByteString.copyFromUtf8((String)typeUrl_));
        }
        return (ByteString)typeUrl_;
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
        if (!this.getTypeUrlBytes().isEmpty()) {
            codedOutputStream.writeBytes(1, this.getTypeUrlBytes());
        }
        if (!this.value_.isEmpty()) {
            codedOutputStream.writeBytes(2, this.value_);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (!this.getTypeUrlBytes().isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(1, this.getTypeUrlBytes());
        }
        if (!this.value_.isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(2, this.value_);
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Any)) {
            return super.equals(o);
        }
        final Any any = (Any)o;
        return true && this.getTypeUrl().equals(any.getTypeUrl()) && this.getValue().equals(any.getValue());
    }
    
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        return this.memoizedHashCode = 29 * (53 * (37 * (53 * (37 * (19 * 41 + this.getDescriptorForType().hashCode()) + 1) + this.getTypeUrl().hashCode()) + 2) + this.getValue().hashCode()) + this.unknownFields.hashCode();
    }
    
    public static Any parseFrom(final ByteString byteString) {
        return (Any)Any.PARSER.parseFrom(byteString);
    }
    
    public static Any parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Any)Any.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Any parseFrom(final byte[] array) {
        return (Any)Any.PARSER.parseFrom(array);
    }
    
    public static Any parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Any)Any.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Any parseFrom(final InputStream inputStream) {
        return (Any)Any.PARSER.parseFrom(inputStream);
    }
    
    public static Any parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Any)Any.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Any parseDelimitedFrom(final InputStream inputStream) {
        return (Any)Any.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Any parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Any)Any.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Any parseFrom(final CodedInputStream codedInputStream) {
        return (Any)Any.PARSER.parseFrom(codedInputStream);
    }
    
    public static Any parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Any)Any.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Any$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Any$Builder newBuilder() {
        return Any.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Any$Builder newBuilder(final Any any) {
        return Any.DEFAULT_INSTANCE.toBuilder().mergeFrom(any);
    }
    
    public Any$Builder toBuilder() {
        return (this == Any.DEFAULT_INSTANCE) ? new Any$Builder((Any$1)null) : new Any$Builder((Any$1)null).mergeFrom(this);
    }
    
    protected Any$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Any$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Any getDefaultInstance() {
        return Any.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Any.PARSER;
    }
    
    public Any getDefaultInstanceForType() {
        return Any.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Any();
        PARSER = new Any$1();
    }
}
