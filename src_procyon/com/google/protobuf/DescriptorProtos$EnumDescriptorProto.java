package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$EnumDescriptorProto extends GeneratedMessage implements DescriptorProtos$EnumDescriptorProtoOrBuilder
{
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int VALUE_FIELD_NUMBER = 2;
    private List value_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private DescriptorProtos$EnumOptions options_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$EnumDescriptorProto DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$EnumDescriptorProto(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$EnumDescriptorProto() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.value_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$EnumDescriptorProto(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n = 0;
        final UnknownFieldSet$Builder builder = UnknownFieldSet.newBuilder();
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
                        if (!this.parseUnknownField(codedInputStream, builder, extensionRegistryLite, tag)) {
                            i = 1;
                            continue;
                        }
                        continue;
                    }
                    case 10: {
                        final ByteString bytes = codedInputStream.readBytes();
                        this.bitField0_ |= 0x1;
                        this.name_ = bytes;
                        continue;
                    }
                    case 18: {
                        if ((n & 0x2) != 0x2) {
                            this.value_ = new ArrayList();
                            n |= 0x2;
                        }
                        this.value_.add(codedInputStream.readMessage(DescriptorProtos$EnumValueDescriptorProto.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 26: {
                        DescriptorProtos$EnumOptions$Builder builder2 = null;
                        if ((this.bitField0_ & 0x2) == 0x2) {
                            builder2 = this.options_.toBuilder();
                        }
                        this.options_ = (DescriptorProtos$EnumOptions)codedInputStream.readMessage(DescriptorProtos$EnumOptions.PARSER, extensionRegistryLite);
                        if (builder2 != null) {
                            builder2.mergeFrom(this.options_);
                            this.options_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 0x2;
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
            if ((n & 0x2) == 0x2) {
                this.value_ = Collections.unmodifiableList((List<?>)this.value_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$EnumDescriptorProto.class, DescriptorProtos$EnumDescriptorProto$Builder.class);
    }
    
    public boolean hasName() {
        return (this.bitField0_ & 0x1) == 0x1;
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
    
    public List getValueList() {
        return this.value_;
    }
    
    public List getValueOrBuilderList() {
        return this.value_;
    }
    
    public int getValueCount() {
        return this.value_.size();
    }
    
    public DescriptorProtos$EnumValueDescriptorProto getValue(final int n) {
        return this.value_.get(n);
    }
    
    public DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(final int n) {
        return this.value_.get(n);
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public DescriptorProtos$EnumOptions getOptions() {
        return (this.options_ == null) ? DescriptorProtos$EnumOptions.getDefaultInstance() : this.options_;
    }
    
    public DescriptorProtos$EnumOptionsOrBuilder getOptionsOrBuilder() {
        return (this.options_ == null) ? DescriptorProtos$EnumOptions.getDefaultInstance() : this.options_;
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        for (int i = 0; i < this.getValueCount(); ++i) {
            if (!this.getValue(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (this.hasOptions() && !this.getOptions().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
        }
        for (int i = 0; i < this.value_.size(); ++i) {
            codedOutputStream.writeMessage(2, (MessageLite)this.value_.get(i));
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeMessage(3, this.getOptions());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int n = 0;
        if ((this.bitField0_ & 0x1) == 0x1) {
            n += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        for (int i = 0; i < this.value_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(2, (MessageLite)this.value_.get(i));
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeMessageSize(3, this.getOptions());
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$EnumDescriptorProto parseFrom(final ByteString byteString) {
        return (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$EnumDescriptorProto parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumDescriptorProto parseFrom(final byte[] array) {
        return (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$EnumDescriptorProto parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumDescriptorProto parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$EnumDescriptorProto parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumDescriptorProto parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$EnumDescriptorProto parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumDescriptorProto parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$EnumDescriptorProto parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$EnumDescriptorProto$Builder newBuilder() {
        return DescriptorProtos$EnumDescriptorProto.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$EnumDescriptorProto$Builder newBuilder(final DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        return DescriptorProtos$EnumDescriptorProto.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$EnumDescriptorProto);
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder toBuilder() {
        return (this == DescriptorProtos$EnumDescriptorProto.DEFAULT_INSTANCE) ? new DescriptorProtos$EnumDescriptorProto$Builder((DescriptorProtos$1)null) : new DescriptorProtos$EnumDescriptorProto$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$EnumDescriptorProto$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$EnumDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$EnumDescriptorProto getDefaultInstance() {
        return DescriptorProtos$EnumDescriptorProto.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$EnumDescriptorProto.PARSER;
    }
    
    public DescriptorProtos$EnumDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$EnumDescriptorProto.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$EnumDescriptorProto();
        PARSER = new DescriptorProtos$EnumDescriptorProto$1();
    }
}
