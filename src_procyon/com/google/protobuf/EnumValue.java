package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class EnumValue extends GeneratedMessage implements EnumValueOrBuilder
{
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int NUMBER_FIELD_NUMBER = 2;
    private int number_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private List options_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final EnumValue DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private EnumValue(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private EnumValue() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.number_ = 0;
        this.options_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private EnumValue(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n = 0;
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
                    case 16: {
                        this.number_ = codedInputStream.readInt32();
                        continue;
                    }
                    case 26: {
                        if ((n & 0x4) != 0x4) {
                            this.options_ = new ArrayList();
                            n |= 0x4;
                        }
                        this.options_.add(codedInputStream.readMessage(Option.PARSER, extensionRegistryLite));
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
            if ((n & 0x4) == 0x4) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
            }
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, EnumValue$Builder.class);
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
    
    public int getNumber() {
        return this.number_;
    }
    
    public List getOptionsList() {
        return this.options_;
    }
    
    public List getOptionsOrBuilderList() {
        return this.options_;
    }
    
    public int getOptionsCount() {
        return this.options_.size();
    }
    
    public Option getOptions(final int n) {
        return this.options_.get(n);
    }
    
    public OptionOrBuilder getOptionsOrBuilder(final int n) {
        return this.options_.get(n);
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
        if (this.number_ != 0) {
            codedOutputStream.writeInt32(2, this.number_);
        }
        for (int i = 0; i < this.options_.size(); ++i) {
            codedOutputStream.writeMessage(3, (MessageLite)this.options_.get(i));
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
        if (this.number_ != 0) {
            memoizedSerializedSize2 += CodedOutputStream.computeInt32Size(2, this.number_);
        }
        for (int i = 0; i < this.options_.size(); ++i) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_.get(i));
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static EnumValue parseFrom(final ByteString byteString) {
        return (EnumValue)EnumValue.PARSER.parseFrom(byteString);
    }
    
    public static EnumValue parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)EnumValue.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static EnumValue parseFrom(final byte[] array) {
        return (EnumValue)EnumValue.PARSER.parseFrom(array);
    }
    
    public static EnumValue parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)EnumValue.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static EnumValue parseFrom(final InputStream inputStream) {
        return (EnumValue)EnumValue.PARSER.parseFrom(inputStream);
    }
    
    public static EnumValue parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)EnumValue.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static EnumValue parseDelimitedFrom(final InputStream inputStream) {
        return (EnumValue)EnumValue.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static EnumValue parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)EnumValue.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static EnumValue parseFrom(final CodedInputStream codedInputStream) {
        return (EnumValue)EnumValue.PARSER.parseFrom(codedInputStream);
    }
    
    public static EnumValue parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)EnumValue.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public EnumValue$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static EnumValue$Builder newBuilder() {
        return EnumValue.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static EnumValue$Builder newBuilder(final EnumValue enumValue) {
        return EnumValue.DEFAULT_INSTANCE.toBuilder().mergeFrom(enumValue);
    }
    
    public EnumValue$Builder toBuilder() {
        return (this == EnumValue.DEFAULT_INSTANCE) ? new EnumValue$Builder((EnumValue$1)null) : new EnumValue$Builder((EnumValue$1)null).mergeFrom(this);
    }
    
    protected EnumValue$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new EnumValue$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static EnumValue getDefaultInstance() {
        return EnumValue.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return EnumValue.PARSER;
    }
    
    public EnumValue getDefaultInstanceForType() {
        return EnumValue.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new EnumValue();
        PARSER = new EnumValue$1();
    }
}
