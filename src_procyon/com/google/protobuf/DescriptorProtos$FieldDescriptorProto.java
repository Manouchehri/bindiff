package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$FieldDescriptorProto extends GeneratedMessage implements DescriptorProtos$FieldDescriptorProtoOrBuilder
{
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int NUMBER_FIELD_NUMBER = 3;
    private int number_;
    public static final int LABEL_FIELD_NUMBER = 4;
    private int label_;
    public static final int TYPE_FIELD_NUMBER = 5;
    private int type_;
    public static final int TYPE_NAME_FIELD_NUMBER = 6;
    private volatile Object typeName_;
    public static final int EXTENDEE_FIELD_NUMBER = 2;
    private volatile Object extendee_;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
    private volatile Object defaultValue_;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
    private int oneofIndex_;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    private DescriptorProtos$FieldOptions options_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$FieldDescriptorProto DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$FieldDescriptorProto(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$FieldDescriptorProto() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.number_ = 0;
        this.label_ = 1;
        this.type_ = 1;
        this.typeName_ = "";
        this.extendee_ = "";
        this.defaultValue_ = "";
        this.oneofIndex_ = 0;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$FieldDescriptorProto(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 18: {
                        final ByteString bytes2 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x20;
                        this.extendee_ = bytes2;
                        continue;
                    }
                    case 24: {
                        this.bitField0_ |= 0x2;
                        this.number_ = codedInputStream.readInt32();
                        continue;
                    }
                    case 32: {
                        final int enum1 = codedInputStream.readEnum();
                        if (DescriptorProtos$FieldDescriptorProto$Label.valueOf(enum1) == null) {
                            builder.mergeVarintField(4, enum1);
                            continue;
                        }
                        this.bitField0_ |= 0x4;
                        this.label_ = enum1;
                        continue;
                    }
                    case 40: {
                        final int enum2 = codedInputStream.readEnum();
                        if (DescriptorProtos$FieldDescriptorProto$Type.valueOf(enum2) == null) {
                            builder.mergeVarintField(5, enum2);
                            continue;
                        }
                        this.bitField0_ |= 0x8;
                        this.type_ = enum2;
                        continue;
                    }
                    case 50: {
                        final ByteString bytes3 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x10;
                        this.typeName_ = bytes3;
                        continue;
                    }
                    case 58: {
                        final ByteString bytes4 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x40;
                        this.defaultValue_ = bytes4;
                        continue;
                    }
                    case 66: {
                        DescriptorProtos$FieldOptions$Builder builder2 = null;
                        if ((this.bitField0_ & 0x100) == 0x100) {
                            builder2 = this.options_.toBuilder();
                        }
                        this.options_ = (DescriptorProtos$FieldOptions)codedInputStream.readMessage(DescriptorProtos$FieldOptions.PARSER, extensionRegistryLite);
                        if (builder2 != null) {
                            builder2.mergeFrom(this.options_);
                            this.options_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 0x100;
                        continue;
                    }
                    case 72: {
                        this.bitField0_ |= 0x80;
                        this.oneofIndex_ = codedInputStream.readInt32();
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
        return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$FieldDescriptorProto.class, DescriptorProtos$FieldDescriptorProto$Builder.class);
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
    
    public boolean hasLabel() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Label getLabel() {
        final DescriptorProtos$FieldDescriptorProto$Label value = DescriptorProtos$FieldDescriptorProto$Label.valueOf(this.label_);
        return (value == null) ? DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL : value;
    }
    
    public boolean hasType() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Type getType() {
        final DescriptorProtos$FieldDescriptorProto$Type value = DescriptorProtos$FieldDescriptorProto$Type.valueOf(this.type_);
        return (value == null) ? DescriptorProtos$FieldDescriptorProto$Type.TYPE_DOUBLE : value;
    }
    
    public boolean hasTypeName() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    public String getTypeName() {
        final Object typeName_ = this.typeName_;
        if (typeName_ instanceof String) {
            return (String)typeName_;
        }
        final ByteString byteString = (ByteString)typeName_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.typeName_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getTypeNameBytes() {
        final Object typeName_ = this.typeName_;
        if (typeName_ instanceof String) {
            return (ByteString)(this.typeName_ = ByteString.copyFromUtf8((String)typeName_));
        }
        return (ByteString)typeName_;
    }
    
    public boolean hasExtendee() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    public String getExtendee() {
        final Object extendee_ = this.extendee_;
        if (extendee_ instanceof String) {
            return (String)extendee_;
        }
        final ByteString byteString = (ByteString)extendee_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.extendee_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getExtendeeBytes() {
        final Object extendee_ = this.extendee_;
        if (extendee_ instanceof String) {
            return (ByteString)(this.extendee_ = ByteString.copyFromUtf8((String)extendee_));
        }
        return (ByteString)extendee_;
    }
    
    public boolean hasDefaultValue() {
        return (this.bitField0_ & 0x40) == 0x40;
    }
    
    public String getDefaultValue() {
        final Object defaultValue_ = this.defaultValue_;
        if (defaultValue_ instanceof String) {
            return (String)defaultValue_;
        }
        final ByteString byteString = (ByteString)defaultValue_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.defaultValue_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getDefaultValueBytes() {
        final Object defaultValue_ = this.defaultValue_;
        if (defaultValue_ instanceof String) {
            return (ByteString)(this.defaultValue_ = ByteString.copyFromUtf8((String)defaultValue_));
        }
        return (ByteString)defaultValue_;
    }
    
    public boolean hasOneofIndex() {
        return (this.bitField0_ & 0x80) == 0x80;
    }
    
    public int getOneofIndex() {
        return this.oneofIndex_;
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x100) == 0x100;
    }
    
    public DescriptorProtos$FieldOptions getOptions() {
        return (this.options_ == null) ? DescriptorProtos$FieldOptions.getDefaultInstance() : this.options_;
    }
    
    public DescriptorProtos$FieldOptionsOrBuilder getOptionsOrBuilder() {
        return (this.options_ == null) ? DescriptorProtos$FieldOptions.getDefaultInstance() : this.options_;
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
        if ((this.bitField0_ & 0x20) == 0x20) {
            codedOutputStream.writeBytes(2, this.getExtendeeBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeInt32(3, this.number_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeEnum(4, this.label_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            codedOutputStream.writeEnum(5, this.type_);
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            codedOutputStream.writeBytes(6, this.getTypeNameBytes());
        }
        if ((this.bitField0_ & 0x40) == 0x40) {
            codedOutputStream.writeBytes(7, this.getDefaultValueBytes());
        }
        if ((this.bitField0_ & 0x100) == 0x100) {
            codedOutputStream.writeMessage(8, this.getOptions());
        }
        if ((this.bitField0_ & 0x80) == 0x80) {
            codedOutputStream.writeInt32(9, this.oneofIndex_);
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
        if ((this.bitField0_ & 0x20) == 0x20) {
            n += CodedOutputStream.computeBytesSize(2, this.getExtendeeBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeInt32Size(3, this.number_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeEnumSize(4, this.label_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            n += CodedOutputStream.computeEnumSize(5, this.type_);
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            n += CodedOutputStream.computeBytesSize(6, this.getTypeNameBytes());
        }
        if ((this.bitField0_ & 0x40) == 0x40) {
            n += CodedOutputStream.computeBytesSize(7, this.getDefaultValueBytes());
        }
        if ((this.bitField0_ & 0x100) == 0x100) {
            n += CodedOutputStream.computeMessageSize(8, this.getOptions());
        }
        if ((this.bitField0_ & 0x80) == 0x80) {
            n += CodedOutputStream.computeInt32Size(9, this.oneofIndex_);
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$FieldDescriptorProto parseFrom(final ByteString byteString) {
        return (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$FieldDescriptorProto parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FieldDescriptorProto parseFrom(final byte[] array) {
        return (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$FieldDescriptorProto parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FieldDescriptorProto parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$FieldDescriptorProto parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FieldDescriptorProto parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$FieldDescriptorProto parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FieldDescriptorProto parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$FieldDescriptorProto parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$FieldDescriptorProto$Builder newBuilder() {
        return DescriptorProtos$FieldDescriptorProto.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$FieldDescriptorProto$Builder newBuilder(final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return DescriptorProtos$FieldDescriptorProto.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FieldDescriptorProto);
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder toBuilder() {
        return (this == DescriptorProtos$FieldDescriptorProto.DEFAULT_INSTANCE) ? new DescriptorProtos$FieldDescriptorProto$Builder((DescriptorProtos$1)null) : new DescriptorProtos$FieldDescriptorProto$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$FieldDescriptorProto$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$FieldDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$FieldDescriptorProto getDefaultInstance() {
        return DescriptorProtos$FieldDescriptorProto.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$FieldDescriptorProto.PARSER;
    }
    
    public DescriptorProtos$FieldDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$FieldDescriptorProto.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$FieldDescriptorProto();
        PARSER = new DescriptorProtos$FieldDescriptorProto$1();
    }
}
