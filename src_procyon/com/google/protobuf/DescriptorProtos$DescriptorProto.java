package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$DescriptorProto extends GeneratedMessage implements DescriptorProtos$DescriptorProtoOrBuilder
{
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int FIELD_FIELD_NUMBER = 2;
    private List field_;
    public static final int EXTENSION_FIELD_NUMBER = 6;
    private List extension_;
    public static final int NESTED_TYPE_FIELD_NUMBER = 3;
    private List nestedType_;
    public static final int ENUM_TYPE_FIELD_NUMBER = 4;
    private List enumType_;
    public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
    private List extensionRange_;
    public static final int ONEOF_DECL_FIELD_NUMBER = 8;
    private List oneofDecl_;
    public static final int OPTIONS_FIELD_NUMBER = 7;
    private DescriptorProtos$MessageOptions options_;
    public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
    private List reservedRange_;
    public static final int RESERVED_NAME_FIELD_NUMBER = 10;
    private LazyStringList reservedName_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$DescriptorProto DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$DescriptorProto(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$DescriptorProto() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.field_ = Collections.emptyList();
        this.extension_ = Collections.emptyList();
        this.nestedType_ = Collections.emptyList();
        this.enumType_ = Collections.emptyList();
        this.extensionRange_ = Collections.emptyList();
        this.oneofDecl_ = Collections.emptyList();
        this.reservedRange_ = Collections.emptyList();
        this.reservedName_ = LazyStringArrayList.EMPTY;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$DescriptorProto(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                            this.field_ = new ArrayList();
                            n |= 0x2;
                        }
                        this.field_.add(codedInputStream.readMessage(DescriptorProtos$FieldDescriptorProto.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 26: {
                        if ((n & 0x8) != 0x8) {
                            this.nestedType_ = new ArrayList();
                            n |= 0x8;
                        }
                        this.nestedType_.add(codedInputStream.readMessage(DescriptorProtos$DescriptorProto.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 34: {
                        if ((n & 0x10) != 0x10) {
                            this.enumType_ = new ArrayList();
                            n |= 0x10;
                        }
                        this.enumType_.add(codedInputStream.readMessage(DescriptorProtos$EnumDescriptorProto.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 42: {
                        if ((n & 0x20) != 0x20) {
                            this.extensionRange_ = new ArrayList();
                            n |= 0x20;
                        }
                        this.extensionRange_.add(codedInputStream.readMessage(DescriptorProtos$DescriptorProto$ExtensionRange.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 50: {
                        if ((n & 0x4) != 0x4) {
                            this.extension_ = new ArrayList();
                            n |= 0x4;
                        }
                        this.extension_.add(codedInputStream.readMessage(DescriptorProtos$FieldDescriptorProto.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 58: {
                        DescriptorProtos$MessageOptions$Builder builder2 = null;
                        if ((this.bitField0_ & 0x2) == 0x2) {
                            builder2 = this.options_.toBuilder();
                        }
                        this.options_ = (DescriptorProtos$MessageOptions)codedInputStream.readMessage(DescriptorProtos$MessageOptions.PARSER, extensionRegistryLite);
                        if (builder2 != null) {
                            builder2.mergeFrom(this.options_);
                            this.options_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 0x2;
                        continue;
                    }
                    case 66: {
                        if ((n & 0x40) != 0x40) {
                            this.oneofDecl_ = new ArrayList();
                            n |= 0x40;
                        }
                        this.oneofDecl_.add(codedInputStream.readMessage(DescriptorProtos$OneofDescriptorProto.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 74: {
                        if ((n & 0x100) != 0x100) {
                            this.reservedRange_ = new ArrayList();
                            n |= 0x100;
                        }
                        this.reservedRange_.add(codedInputStream.readMessage(DescriptorProtos$DescriptorProto$ReservedRange.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 82: {
                        final ByteString bytes2 = codedInputStream.readBytes();
                        if ((n & 0x200) != 0x200) {
                            this.reservedName_ = new LazyStringArrayList();
                            n |= 0x200;
                        }
                        this.reservedName_.add(bytes2);
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
                this.field_ = Collections.unmodifiableList((List<?>)this.field_);
            }
            if ((n & 0x8) == 0x8) {
                this.nestedType_ = Collections.unmodifiableList((List<?>)this.nestedType_);
            }
            if ((n & 0x10) == 0x10) {
                this.enumType_ = Collections.unmodifiableList((List<?>)this.enumType_);
            }
            if ((n & 0x20) == 0x20) {
                this.extensionRange_ = Collections.unmodifiableList((List<?>)this.extensionRange_);
            }
            if ((n & 0x4) == 0x4) {
                this.extension_ = Collections.unmodifiableList((List<?>)this.extension_);
            }
            if ((n & 0x40) == 0x40) {
                this.oneofDecl_ = Collections.unmodifiableList((List<?>)this.oneofDecl_);
            }
            if ((n & 0x100) == 0x100) {
                this.reservedRange_ = Collections.unmodifiableList((List<?>)this.reservedRange_);
            }
            if ((n & 0x200) == 0x200) {
                this.reservedName_ = this.reservedName_.getUnmodifiableView();
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto.class, DescriptorProtos$DescriptorProto$Builder.class);
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
    
    public List getFieldList() {
        return this.field_;
    }
    
    public List getFieldOrBuilderList() {
        return this.field_;
    }
    
    public int getFieldCount() {
        return this.field_.size();
    }
    
    public DescriptorProtos$FieldDescriptorProto getField(final int n) {
        return this.field_.get(n);
    }
    
    public DescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(final int n) {
        return this.field_.get(n);
    }
    
    public List getExtensionList() {
        return this.extension_;
    }
    
    public List getExtensionOrBuilderList() {
        return this.extension_;
    }
    
    public int getExtensionCount() {
        return this.extension_.size();
    }
    
    public DescriptorProtos$FieldDescriptorProto getExtension(final int n) {
        return this.extension_.get(n);
    }
    
    public DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(final int n) {
        return this.extension_.get(n);
    }
    
    public List getNestedTypeList() {
        return this.nestedType_;
    }
    
    public List getNestedTypeOrBuilderList() {
        return this.nestedType_;
    }
    
    public int getNestedTypeCount() {
        return this.nestedType_.size();
    }
    
    public DescriptorProtos$DescriptorProto getNestedType(final int n) {
        return this.nestedType_.get(n);
    }
    
    public DescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(final int n) {
        return this.nestedType_.get(n);
    }
    
    public List getEnumTypeList() {
        return this.enumType_;
    }
    
    public List getEnumTypeOrBuilderList() {
        return this.enumType_;
    }
    
    public int getEnumTypeCount() {
        return this.enumType_.size();
    }
    
    public DescriptorProtos$EnumDescriptorProto getEnumType(final int n) {
        return this.enumType_.get(n);
    }
    
    public DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(final int n) {
        return this.enumType_.get(n);
    }
    
    public List getExtensionRangeList() {
        return this.extensionRange_;
    }
    
    public List getExtensionRangeOrBuilderList() {
        return this.extensionRange_;
    }
    
    public int getExtensionRangeCount() {
        return this.extensionRange_.size();
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange getExtensionRange(final int n) {
        return this.extensionRange_.get(n);
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder getExtensionRangeOrBuilder(final int n) {
        return this.extensionRange_.get(n);
    }
    
    public List getOneofDeclList() {
        return this.oneofDecl_;
    }
    
    public List getOneofDeclOrBuilderList() {
        return this.oneofDecl_;
    }
    
    public int getOneofDeclCount() {
        return this.oneofDecl_.size();
    }
    
    public DescriptorProtos$OneofDescriptorProto getOneofDecl(final int n) {
        return this.oneofDecl_.get(n);
    }
    
    public DescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(final int n) {
        return this.oneofDecl_.get(n);
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public DescriptorProtos$MessageOptions getOptions() {
        return (this.options_ == null) ? DescriptorProtos$MessageOptions.getDefaultInstance() : this.options_;
    }
    
    public DescriptorProtos$MessageOptionsOrBuilder getOptionsOrBuilder() {
        return (this.options_ == null) ? DescriptorProtos$MessageOptions.getDefaultInstance() : this.options_;
    }
    
    public List getReservedRangeList() {
        return this.reservedRange_;
    }
    
    public List getReservedRangeOrBuilderList() {
        return this.reservedRange_;
    }
    
    public int getReservedRangeCount() {
        return this.reservedRange_.size();
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange getReservedRange(final int n) {
        return this.reservedRange_.get(n);
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder getReservedRangeOrBuilder(final int n) {
        return this.reservedRange_.get(n);
    }
    
    public ProtocolStringList getReservedNameList() {
        return this.reservedName_;
    }
    
    public int getReservedNameCount() {
        return this.reservedName_.size();
    }
    
    public String getReservedName(final int n) {
        return this.reservedName_.get(n);
    }
    
    public ByteString getReservedNameBytes(final int n) {
        return this.reservedName_.getByteString(n);
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        for (int i = 0; i < this.getFieldCount(); ++i) {
            if (!this.getField(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int j = 0; j < this.getExtensionCount(); ++j) {
            if (!this.getExtension(j).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int k = 0; k < this.getNestedTypeCount(); ++k) {
            if (!this.getNestedType(k).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int l = 0; l < this.getEnumTypeCount(); ++l) {
            if (!this.getEnumType(l).isInitialized()) {
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
        for (int i = 0; i < this.field_.size(); ++i) {
            codedOutputStream.writeMessage(2, (MessageLite)this.field_.get(i));
        }
        for (int j = 0; j < this.nestedType_.size(); ++j) {
            codedOutputStream.writeMessage(3, (MessageLite)this.nestedType_.get(j));
        }
        for (int k = 0; k < this.enumType_.size(); ++k) {
            codedOutputStream.writeMessage(4, (MessageLite)this.enumType_.get(k));
        }
        for (int l = 0; l < this.extensionRange_.size(); ++l) {
            codedOutputStream.writeMessage(5, (MessageLite)this.extensionRange_.get(l));
        }
        for (int n = 0; n < this.extension_.size(); ++n) {
            codedOutputStream.writeMessage(6, (MessageLite)this.extension_.get(n));
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeMessage(7, this.getOptions());
        }
        for (int n2 = 0; n2 < this.oneofDecl_.size(); ++n2) {
            codedOutputStream.writeMessage(8, (MessageLite)this.oneofDecl_.get(n2));
        }
        for (int n3 = 0; n3 < this.reservedRange_.size(); ++n3) {
            codedOutputStream.writeMessage(9, (MessageLite)this.reservedRange_.get(n3));
        }
        for (int n4 = 0; n4 < this.reservedName_.size(); ++n4) {
            codedOutputStream.writeBytes(10, this.reservedName_.getByteString(n4));
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
        for (int i = 0; i < this.field_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(2, (MessageLite)this.field_.get(i));
        }
        for (int j = 0; j < this.nestedType_.size(); ++j) {
            n += CodedOutputStream.computeMessageSize(3, (MessageLite)this.nestedType_.get(j));
        }
        for (int k = 0; k < this.enumType_.size(); ++k) {
            n += CodedOutputStream.computeMessageSize(4, (MessageLite)this.enumType_.get(k));
        }
        for (int l = 0; l < this.extensionRange_.size(); ++l) {
            n += CodedOutputStream.computeMessageSize(5, (MessageLite)this.extensionRange_.get(l));
        }
        for (int n2 = 0; n2 < this.extension_.size(); ++n2) {
            n += CodedOutputStream.computeMessageSize(6, (MessageLite)this.extension_.get(n2));
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeMessageSize(7, this.getOptions());
        }
        for (int n3 = 0; n3 < this.oneofDecl_.size(); ++n3) {
            n += CodedOutputStream.computeMessageSize(8, (MessageLite)this.oneofDecl_.get(n3));
        }
        for (int n4 = 0; n4 < this.reservedRange_.size(); ++n4) {
            n += CodedOutputStream.computeMessageSize(9, (MessageLite)this.reservedRange_.get(n4));
        }
        int n5 = 0;
        for (int n6 = 0; n6 < this.reservedName_.size(); ++n6) {
            n5 += CodedOutputStream.computeBytesSizeNoTag(this.reservedName_.getByteString(n6));
        }
        return this.memoizedSerializedSize = n + n5 + 1 * this.getReservedNameList().size() + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$DescriptorProto parseFrom(final ByteString byteString) {
        return (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$DescriptorProto parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$DescriptorProto parseFrom(final byte[] array) {
        return (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$DescriptorProto parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$DescriptorProto parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$DescriptorProto parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$DescriptorProto parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$DescriptorProto parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$DescriptorProto parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$DescriptorProto parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$DescriptorProto$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$DescriptorProto$Builder newBuilder() {
        return DescriptorProtos$DescriptorProto.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$DescriptorProto$Builder newBuilder(final DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return DescriptorProtos$DescriptorProto.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$DescriptorProto);
    }
    
    public DescriptorProtos$DescriptorProto$Builder toBuilder() {
        return (this == DescriptorProtos$DescriptorProto.DEFAULT_INSTANCE) ? new DescriptorProtos$DescriptorProto$Builder((DescriptorProtos$1)null) : new DescriptorProtos$DescriptorProto$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$DescriptorProto$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$DescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$DescriptorProto getDefaultInstance() {
        return DescriptorProtos$DescriptorProto.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$DescriptorProto.PARSER;
    }
    
    public DescriptorProtos$DescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$DescriptorProto();
        PARSER = new DescriptorProtos$DescriptorProto$1();
    }
}
