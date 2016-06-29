package com.google.protobuf;

import java.io.*;

public final class Option extends GeneratedMessage implements OptionOrBuilder
{
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int VALUE_FIELD_NUMBER = 2;
    private Any value_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Option DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Option(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Option() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Option(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.name_ = codedInputStream.readBytes();
                        continue;
                    }
                    case 18: {
                        Any$Builder builder = null;
                        if (this.value_ != null) {
                            builder = this.value_.toBuilder();
                        }
                        this.value_ = (Any)codedInputStream.readMessage(Any.PARSER, extensionRegistryLite);
                        if (builder != null) {
                            builder.mergeFrom(this.value_);
                            this.value_ = builder.buildPartial();
                            continue;
                        }
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
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Option$Builder.class);
    }
    
    public String getName() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (String)name_;
        }
        final ByteString byteString = (ByteString)name_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.name_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getNameBytes() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (ByteString)(this.name_ = ByteString.copyFromUtf8((String)name_));
        }
        return (ByteString)name_;
    }
    
    public boolean hasValue() {
        return this.value_ != null;
    }
    
    public Any getValue() {
        return (this.value_ == null) ? Any.getDefaultInstance() : this.value_;
    }
    
    public AnyOrBuilder getValueOrBuilder() {
        return this.getValue();
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
        if (!this.getNameBytes().isEmpty()) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
        }
        if (this.value_ != null) {
            codedOutputStream.writeMessage(2, this.getValue());
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (!this.getNameBytes().isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        if (this.value_ != null) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(2, this.getValue());
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static Option parseFrom(final ByteString byteString) {
        return (Option)Option.PARSER.parseFrom(byteString);
    }
    
    public static Option parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Option)Option.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Option parseFrom(final byte[] array) {
        return (Option)Option.PARSER.parseFrom(array);
    }
    
    public static Option parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Option)Option.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Option parseFrom(final InputStream inputStream) {
        return (Option)Option.PARSER.parseFrom(inputStream);
    }
    
    public static Option parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Option)Option.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Option parseDelimitedFrom(final InputStream inputStream) {
        return (Option)Option.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Option parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Option)Option.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Option parseFrom(final CodedInputStream codedInputStream) {
        return (Option)Option.PARSER.parseFrom(codedInputStream);
    }
    
    public static Option parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Option)Option.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Option$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Option$Builder newBuilder() {
        return Option.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Option$Builder newBuilder(final Option option) {
        return Option.DEFAULT_INSTANCE.toBuilder().mergeFrom(option);
    }
    
    public Option$Builder toBuilder() {
        return (this == Option.DEFAULT_INSTANCE) ? new Option$Builder((Option$1)null) : new Option$Builder((Option$1)null).mergeFrom(this);
    }
    
    protected Option$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Option$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Option getDefaultInstance() {
        return Option.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Option.PARSER;
    }
    
    public Option getDefaultInstanceForType() {
        return Option.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Option();
        PARSER = new Option$1();
    }
}
