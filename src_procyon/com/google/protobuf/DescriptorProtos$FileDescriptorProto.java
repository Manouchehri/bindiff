package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$FileDescriptorProto extends GeneratedMessage implements DescriptorProtos$FileDescriptorProtoOrBuilder
{
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int PACKAGE_FIELD_NUMBER = 2;
    private volatile Object package_;
    public static final int DEPENDENCY_FIELD_NUMBER = 3;
    private LazyStringList dependency_;
    public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
    private List publicDependency_;
    public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
    private List weakDependency_;
    public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
    private List messageType_;
    public static final int ENUM_TYPE_FIELD_NUMBER = 5;
    private List enumType_;
    public static final int SERVICE_FIELD_NUMBER = 6;
    private List service_;
    public static final int EXTENSION_FIELD_NUMBER = 7;
    private List extension_;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    private DescriptorProtos$FileOptions options_;
    public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
    private DescriptorProtos$SourceCodeInfo sourceCodeInfo_;
    public static final int SYNTAX_FIELD_NUMBER = 12;
    private volatile Object syntax_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$FileDescriptorProto DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$FileDescriptorProto(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$FileDescriptorProto() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.package_ = "";
        this.dependency_ = LazyStringArrayList.EMPTY;
        this.publicDependency_ = Collections.emptyList();
        this.weakDependency_ = Collections.emptyList();
        this.messageType_ = Collections.emptyList();
        this.enumType_ = Collections.emptyList();
        this.service_ = Collections.emptyList();
        this.extension_ = Collections.emptyList();
        this.syntax_ = "";
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$FileDescriptorProto(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        final ByteString bytes2 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x2;
                        this.package_ = bytes2;
                        continue;
                    }
                    case 26: {
                        final ByteString bytes3 = codedInputStream.readBytes();
                        if ((n & 0x4) != 0x4) {
                            this.dependency_ = new LazyStringArrayList();
                            n |= 0x4;
                        }
                        this.dependency_.add(bytes3);
                        continue;
                    }
                    case 34: {
                        if ((n & 0x20) != 0x20) {
                            this.messageType_ = new ArrayList();
                            n |= 0x20;
                        }
                        this.messageType_.add(codedInputStream.readMessage(DescriptorProtos$DescriptorProto.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 42: {
                        if ((n & 0x40) != 0x40) {
                            this.enumType_ = new ArrayList();
                            n |= 0x40;
                        }
                        this.enumType_.add(codedInputStream.readMessage(DescriptorProtos$EnumDescriptorProto.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 50: {
                        if ((n & 0x80) != 0x80) {
                            this.service_ = new ArrayList();
                            n |= 0x80;
                        }
                        this.service_.add(codedInputStream.readMessage(DescriptorProtos$ServiceDescriptorProto.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 58: {
                        if ((n & 0x100) != 0x100) {
                            this.extension_ = new ArrayList();
                            n |= 0x100;
                        }
                        this.extension_.add(codedInputStream.readMessage(DescriptorProtos$FieldDescriptorProto.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 66: {
                        DescriptorProtos$FileOptions$Builder builder2 = null;
                        if ((this.bitField0_ & 0x4) == 0x4) {
                            builder2 = this.options_.toBuilder();
                        }
                        this.options_ = (DescriptorProtos$FileOptions)codedInputStream.readMessage(DescriptorProtos$FileOptions.PARSER, extensionRegistryLite);
                        if (builder2 != null) {
                            builder2.mergeFrom(this.options_);
                            this.options_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 0x4;
                        continue;
                    }
                    case 74: {
                        DescriptorProtos$SourceCodeInfo$Builder builder3 = null;
                        if ((this.bitField0_ & 0x8) == 0x8) {
                            builder3 = this.sourceCodeInfo_.toBuilder();
                        }
                        this.sourceCodeInfo_ = (DescriptorProtos$SourceCodeInfo)codedInputStream.readMessage(DescriptorProtos$SourceCodeInfo.PARSER, extensionRegistryLite);
                        if (builder3 != null) {
                            builder3.mergeFrom(this.sourceCodeInfo_);
                            this.sourceCodeInfo_ = builder3.buildPartial();
                        }
                        this.bitField0_ |= 0x8;
                        continue;
                    }
                    case 80: {
                        if ((n & 0x8) != 0x8) {
                            this.publicDependency_ = new ArrayList();
                            n |= 0x8;
                        }
                        this.publicDependency_.add(codedInputStream.readInt32());
                        continue;
                    }
                    case 82: {
                        final int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                        if ((n & 0x8) != 0x8 && codedInputStream.getBytesUntilLimit() > 0) {
                            this.publicDependency_ = new ArrayList();
                            n |= 0x8;
                        }
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            this.publicDependency_.add(codedInputStream.readInt32());
                        }
                        codedInputStream.popLimit(pushLimit);
                        continue;
                    }
                    case 88: {
                        if ((n & 0x10) != 0x10) {
                            this.weakDependency_ = new ArrayList();
                            n |= 0x10;
                        }
                        this.weakDependency_.add(codedInputStream.readInt32());
                        continue;
                    }
                    case 90: {
                        final int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                        if ((n & 0x10) != 0x10 && codedInputStream.getBytesUntilLimit() > 0) {
                            this.weakDependency_ = new ArrayList();
                            n |= 0x10;
                        }
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            this.weakDependency_.add(codedInputStream.readInt32());
                        }
                        codedInputStream.popLimit(pushLimit2);
                        continue;
                    }
                    case 98: {
                        final ByteString bytes4 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x10;
                        this.syntax_ = bytes4;
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
                this.dependency_ = this.dependency_.getUnmodifiableView();
            }
            if ((n & 0x20) == 0x20) {
                this.messageType_ = Collections.unmodifiableList((List<?>)this.messageType_);
            }
            if ((n & 0x40) == 0x40) {
                this.enumType_ = Collections.unmodifiableList((List<?>)this.enumType_);
            }
            if ((n & 0x80) == 0x80) {
                this.service_ = Collections.unmodifiableList((List<?>)this.service_);
            }
            if ((n & 0x100) == 0x100) {
                this.extension_ = Collections.unmodifiableList((List<?>)this.extension_);
            }
            if ((n & 0x8) == 0x8) {
                this.publicDependency_ = Collections.unmodifiableList((List<?>)this.publicDependency_);
            }
            if ((n & 0x10) == 0x10) {
                this.weakDependency_ = Collections.unmodifiableList((List<?>)this.weakDependency_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorProto.class, DescriptorProtos$FileDescriptorProto$Builder.class);
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
    
    public boolean hasPackage() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public String getPackage() {
        final Object package_ = this.package_;
        if (package_ instanceof String) {
            return (String)package_;
        }
        final ByteString byteString = (ByteString)package_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.package_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getPackageBytes() {
        final Object package_ = this.package_;
        if (package_ instanceof String) {
            return (ByteString)(this.package_ = ByteString.copyFromUtf8((String)package_));
        }
        return (ByteString)package_;
    }
    
    public ProtocolStringList getDependencyList() {
        return this.dependency_;
    }
    
    public int getDependencyCount() {
        return this.dependency_.size();
    }
    
    public String getDependency(final int n) {
        return this.dependency_.get(n);
    }
    
    public ByteString getDependencyBytes(final int n) {
        return this.dependency_.getByteString(n);
    }
    
    public List getPublicDependencyList() {
        return this.publicDependency_;
    }
    
    public int getPublicDependencyCount() {
        return this.publicDependency_.size();
    }
    
    public int getPublicDependency(final int n) {
        return this.publicDependency_.get(n);
    }
    
    public List getWeakDependencyList() {
        return this.weakDependency_;
    }
    
    public int getWeakDependencyCount() {
        return this.weakDependency_.size();
    }
    
    public int getWeakDependency(final int n) {
        return this.weakDependency_.get(n);
    }
    
    public List getMessageTypeList() {
        return this.messageType_;
    }
    
    public List getMessageTypeOrBuilderList() {
        return this.messageType_;
    }
    
    public int getMessageTypeCount() {
        return this.messageType_.size();
    }
    
    public DescriptorProtos$DescriptorProto getMessageType(final int n) {
        return this.messageType_.get(n);
    }
    
    public DescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(final int n) {
        return this.messageType_.get(n);
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
    
    public List getServiceList() {
        return this.service_;
    }
    
    public List getServiceOrBuilderList() {
        return this.service_;
    }
    
    public int getServiceCount() {
        return this.service_.size();
    }
    
    public DescriptorProtos$ServiceDescriptorProto getService(final int n) {
        return this.service_.get(n);
    }
    
    public DescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(final int n) {
        return this.service_.get(n);
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
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public DescriptorProtos$FileOptions getOptions() {
        return (this.options_ == null) ? DescriptorProtos$FileOptions.getDefaultInstance() : this.options_;
    }
    
    public DescriptorProtos$FileOptionsOrBuilder getOptionsOrBuilder() {
        return (this.options_ == null) ? DescriptorProtos$FileOptions.getDefaultInstance() : this.options_;
    }
    
    public boolean hasSourceCodeInfo() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public DescriptorProtos$SourceCodeInfo getSourceCodeInfo() {
        return (this.sourceCodeInfo_ == null) ? DescriptorProtos$SourceCodeInfo.getDefaultInstance() : this.sourceCodeInfo_;
    }
    
    public DescriptorProtos$SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
        return (this.sourceCodeInfo_ == null) ? DescriptorProtos$SourceCodeInfo.getDefaultInstance() : this.sourceCodeInfo_;
    }
    
    public boolean hasSyntax() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    public String getSyntax() {
        final Object syntax_ = this.syntax_;
        if (syntax_ instanceof String) {
            return (String)syntax_;
        }
        final ByteString byteString = (ByteString)syntax_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.syntax_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getSyntaxBytes() {
        final Object syntax_ = this.syntax_;
        if (syntax_ instanceof String) {
            return (ByteString)(this.syntax_ = ByteString.copyFromUtf8((String)syntax_));
        }
        return (ByteString)syntax_;
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        for (int i = 0; i < this.getMessageTypeCount(); ++i) {
            if (!this.getMessageType(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int j = 0; j < this.getEnumTypeCount(); ++j) {
            if (!this.getEnumType(j).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int k = 0; k < this.getServiceCount(); ++k) {
            if (!this.getService(k).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int l = 0; l < this.getExtensionCount(); ++l) {
            if (!this.getExtension(l).isInitialized()) {
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
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeBytes(2, this.getPackageBytes());
        }
        for (int i = 0; i < this.dependency_.size(); ++i) {
            codedOutputStream.writeBytes(3, this.dependency_.getByteString(i));
        }
        for (int j = 0; j < this.messageType_.size(); ++j) {
            codedOutputStream.writeMessage(4, (MessageLite)this.messageType_.get(j));
        }
        for (int k = 0; k < this.enumType_.size(); ++k) {
            codedOutputStream.writeMessage(5, (MessageLite)this.enumType_.get(k));
        }
        for (int l = 0; l < this.service_.size(); ++l) {
            codedOutputStream.writeMessage(6, (MessageLite)this.service_.get(l));
        }
        for (int n = 0; n < this.extension_.size(); ++n) {
            codedOutputStream.writeMessage(7, (MessageLite)this.extension_.get(n));
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeMessage(8, this.getOptions());
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            codedOutputStream.writeMessage(9, this.getSourceCodeInfo());
        }
        for (int n2 = 0; n2 < this.publicDependency_.size(); ++n2) {
            codedOutputStream.writeInt32(10, (int)this.publicDependency_.get(n2));
        }
        for (int n3 = 0; n3 < this.weakDependency_.size(); ++n3) {
            codedOutputStream.writeInt32(11, (int)this.weakDependency_.get(n3));
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            codedOutputStream.writeBytes(12, this.getSyntaxBytes());
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
            n += CodedOutputStream.computeBytesSize(2, this.getPackageBytes());
        }
        int n2 = 0;
        for (int i = 0; i < this.dependency_.size(); ++i) {
            n2 += CodedOutputStream.computeBytesSizeNoTag(this.dependency_.getByteString(i));
        }
        int n3 = n + n2 + 1 * this.getDependencyList().size();
        for (int j = 0; j < this.messageType_.size(); ++j) {
            n3 += CodedOutputStream.computeMessageSize(4, (MessageLite)this.messageType_.get(j));
        }
        for (int k = 0; k < this.enumType_.size(); ++k) {
            n3 += CodedOutputStream.computeMessageSize(5, (MessageLite)this.enumType_.get(k));
        }
        for (int l = 0; l < this.service_.size(); ++l) {
            n3 += CodedOutputStream.computeMessageSize(6, (MessageLite)this.service_.get(l));
        }
        for (int n4 = 0; n4 < this.extension_.size(); ++n4) {
            n3 += CodedOutputStream.computeMessageSize(7, (MessageLite)this.extension_.get(n4));
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n3 += CodedOutputStream.computeMessageSize(8, this.getOptions());
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            n3 += CodedOutputStream.computeMessageSize(9, this.getSourceCodeInfo());
        }
        int n5 = 0;
        for (int n6 = 0; n6 < this.publicDependency_.size(); ++n6) {
            n5 += CodedOutputStream.computeInt32SizeNoTag((int)this.publicDependency_.get(n6));
        }
        final int n7 = n3 + n5 + 1 * this.getPublicDependencyList().size();
        int n8 = 0;
        for (int n9 = 0; n9 < this.weakDependency_.size(); ++n9) {
            n8 += CodedOutputStream.computeInt32SizeNoTag((int)this.weakDependency_.get(n9));
        }
        int n10 = n7 + n8 + 1 * this.getWeakDependencyList().size();
        if ((this.bitField0_ & 0x10) == 0x10) {
            n10 += CodedOutputStream.computeBytesSize(12, this.getSyntaxBytes());
        }
        return this.memoizedSerializedSize = n10 + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$FileDescriptorProto parseFrom(final ByteString byteString) {
        return (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$FileDescriptorProto parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileDescriptorProto parseFrom(final byte[] array) {
        return (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$FileDescriptorProto parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileDescriptorProto parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$FileDescriptorProto parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileDescriptorProto parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$FileDescriptorProto parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileDescriptorProto parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$FileDescriptorProto parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$FileDescriptorProto$Builder newBuilder() {
        return DescriptorProtos$FileDescriptorProto.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$FileDescriptorProto$Builder newBuilder(final DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return DescriptorProtos$FileDescriptorProto.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FileDescriptorProto);
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder toBuilder() {
        return (this == DescriptorProtos$FileDescriptorProto.DEFAULT_INSTANCE) ? new DescriptorProtos$FileDescriptorProto$Builder((DescriptorProtos$1)null) : new DescriptorProtos$FileDescriptorProto$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$FileDescriptorProto$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$FileDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$FileDescriptorProto getDefaultInstance() {
        return DescriptorProtos$FileDescriptorProto.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$FileDescriptorProto.PARSER;
    }
    
    public DescriptorProtos$FileDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$FileDescriptorProto.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$FileDescriptorProto();
        PARSER = new DescriptorProtos$FileDescriptorProto$1();
    }
}
