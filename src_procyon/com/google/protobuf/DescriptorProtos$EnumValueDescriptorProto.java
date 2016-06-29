package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$EnumValueDescriptorProto extends GeneratedMessage implements DescriptorProtos$EnumValueDescriptorProtoOrBuilder
{
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int NUMBER_FIELD_NUMBER = 2;
    private int number_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private DescriptorProtos$EnumValueOptions options_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$EnumValueDescriptorProto DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$EnumValueDescriptorProto(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$EnumValueDescriptorProto() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.number_ = 0;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$EnumValueDescriptorProto(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
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
                    case 16: {
                        this.bitField0_ |= 0x2;
                        this.number_ = codedInputStream.readInt32();
                        continue;
                    }
                    case 26: {
                        DescriptorProtos$EnumValueOptions$Builder builder2 = null;
                        if ((this.bitField0_ & 0x4) == 0x4) {
                            builder2 = this.options_.toBuilder();
                        }
                        this.options_ = (DescriptorProtos$EnumValueOptions)codedInputStream.readMessage(DescriptorProtos$EnumValueOptions.PARSER, extensionRegistryLite);
                        if (builder2 != null) {
                            builder2.mergeFrom(this.options_);
                            this.options_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 0x4;
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
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueDescriptorProto.class, DescriptorProtos$EnumValueDescriptorProto$Builder.class);
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
    
    public boolean hasNumber() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public int getNumber() {
        return this.number_;
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public DescriptorProtos$EnumValueOptions getOptions() {
        return (this.options_ == null) ? DescriptorProtos$EnumValueOptions.getDefaultInstance() : this.options_;
    }
    
    public DescriptorProtos$EnumValueOptionsOrBuilder getOptionsOrBuilder() {
        return (this.options_ == null) ? DescriptorProtos$EnumValueOptions.getDefaultInstance() : this.options_;
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
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
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeInt32(2, this.number_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
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
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeInt32Size(2, this.number_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeMessageSize(3, this.getOptions());
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(final ByteString byteString) {
        return (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(final byte[] array) {
        return (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto$Builder newBuilder() {
        return DescriptorProtos$EnumValueDescriptorProto.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto$Builder newBuilder(final DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        return DescriptorProtos$EnumValueDescriptorProto.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$EnumValueDescriptorProto);
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder toBuilder() {
        return (this == DescriptorProtos$EnumValueDescriptorProto.DEFAULT_INSTANCE) ? new DescriptorProtos$EnumValueDescriptorProto$Builder((DescriptorProtos$1)null) : new DescriptorProtos$EnumValueDescriptorProto$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$EnumValueDescriptorProto$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$EnumValueDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$EnumValueDescriptorProto getDefaultInstance() {
        return DescriptorProtos$EnumValueDescriptorProto.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$EnumValueDescriptorProto.PARSER;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$EnumValueDescriptorProto.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$EnumValueDescriptorProto();
        PARSER = new DescriptorProtos$EnumValueDescriptorProto$1();
    }
}
