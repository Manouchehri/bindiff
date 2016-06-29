package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$FieldOptions extends GeneratedMessage$ExtendableMessage implements DescriptorProtos$FieldOptionsOrBuilder
{
    private int bitField0_;
    public static final int CTYPE_FIELD_NUMBER = 1;
    private int ctype_;
    public static final int PACKED_FIELD_NUMBER = 2;
    private boolean packed_;
    public static final int JSTYPE_FIELD_NUMBER = 6;
    private int jstype_;
    public static final int LAZY_FIELD_NUMBER = 5;
    private boolean lazy_;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    private boolean deprecated_;
    public static final int WEAK_FIELD_NUMBER = 10;
    private boolean weak_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List uninterpretedOption_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$FieldOptions DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$FieldOptions(final GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder) {
        super(generatedMessage$ExtendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$FieldOptions() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.ctype_ = 0;
        this.packed_ = false;
        this.jstype_ = 0;
        this.lazy_ = false;
        this.deprecated_ = false;
        this.weak_ = false;
        this.uninterpretedOption_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$FieldOptions(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 8: {
                        final int enum1 = codedInputStream.readEnum();
                        if (DescriptorProtos$FieldOptions$CType.valueOf(enum1) == null) {
                            builder.mergeVarintField(1, enum1);
                            continue;
                        }
                        this.bitField0_ |= 0x1;
                        this.ctype_ = enum1;
                        continue;
                    }
                    case 16: {
                        this.bitField0_ |= 0x2;
                        this.packed_ = codedInputStream.readBool();
                        continue;
                    }
                    case 24: {
                        this.bitField0_ |= 0x10;
                        this.deprecated_ = codedInputStream.readBool();
                        continue;
                    }
                    case 40: {
                        this.bitField0_ |= 0x8;
                        this.lazy_ = codedInputStream.readBool();
                        continue;
                    }
                    case 48: {
                        final int enum2 = codedInputStream.readEnum();
                        if (DescriptorProtos$FieldOptions$JSType.valueOf(enum2) == null) {
                            builder.mergeVarintField(6, enum2);
                            continue;
                        }
                        this.bitField0_ |= 0x4;
                        this.jstype_ = enum2;
                        continue;
                    }
                    case 80: {
                        this.bitField0_ |= 0x20;
                        this.weak_ = codedInputStream.readBool();
                        continue;
                    }
                    case 7994: {
                        if ((n & 0x40) != 0x40) {
                            this.uninterpretedOption_ = new ArrayList();
                            n |= 0x40;
                        }
                        this.uninterpretedOption_.add(codedInputStream.readMessage(DescriptorProtos$UninterpretedOption.PARSER, extensionRegistryLite));
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
            if ((n & 0x40) == 0x40) {
                this.uninterpretedOption_ = Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$FieldOptions.class, DescriptorProtos$FieldOptions$Builder.class);
    }
    
    public boolean hasCtype() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public DescriptorProtos$FieldOptions$CType getCtype() {
        final DescriptorProtos$FieldOptions$CType value = DescriptorProtos$FieldOptions$CType.valueOf(this.ctype_);
        return (value == null) ? DescriptorProtos$FieldOptions$CType.STRING : value;
    }
    
    public boolean hasPacked() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public boolean getPacked() {
        return this.packed_;
    }
    
    public boolean hasJstype() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public DescriptorProtos$FieldOptions$JSType getJstype() {
        final DescriptorProtos$FieldOptions$JSType value = DescriptorProtos$FieldOptions$JSType.valueOf(this.jstype_);
        return (value == null) ? DescriptorProtos$FieldOptions$JSType.JS_NORMAL : value;
    }
    
    public boolean hasLazy() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public boolean getLazy() {
        return this.lazy_;
    }
    
    public boolean hasDeprecated() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    public boolean getDeprecated() {
        return this.deprecated_;
    }
    
    public boolean hasWeak() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    public boolean getWeak() {
        return this.weak_;
    }
    
    public List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }
    
    public List getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }
    
    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }
    
    public DescriptorProtos$UninterpretedOption getUninterpretedOption(final int n) {
        return this.uninterpretedOption_.get(n);
    }
    
    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(final int n) {
        return this.uninterpretedOption_.get(n);
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        for (int i = 0; i < this.getUninterpretedOptionCount(); ++i) {
            if (!this.getUninterpretedOption(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (!this.extensionsAreInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        final GeneratedMessage$ExtendableMessage$ExtensionWriter extensionWriter = this.newExtensionWriter();
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeEnum(1, this.ctype_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeBool(2, this.packed_);
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            codedOutputStream.writeBool(3, this.deprecated_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            codedOutputStream.writeBool(5, this.lazy_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeEnum(6, this.jstype_);
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            codedOutputStream.writeBool(10, this.weak_);
        }
        for (int i = 0; i < this.uninterpretedOption_.size(); ++i) {
            codedOutputStream.writeMessage(999, (MessageLite)this.uninterpretedOption_.get(i));
        }
        extensionWriter.writeUntil(536870912, codedOutputStream);
        this.unknownFields.writeTo(codedOutputStream);
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int n = 0;
        if ((this.bitField0_ & 0x1) == 0x1) {
            n += CodedOutputStream.computeEnumSize(1, this.ctype_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeBoolSize(2, this.packed_);
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            n += CodedOutputStream.computeBoolSize(3, this.deprecated_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            n += CodedOutputStream.computeBoolSize(5, this.lazy_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeEnumSize(6, this.jstype_);
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            n += CodedOutputStream.computeBoolSize(10, this.weak_);
        }
        for (int i = 0; i < this.uninterpretedOption_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(999, (MessageLite)this.uninterpretedOption_.get(i));
        }
        return this.memoizedSerializedSize = n + this.extensionsSerializedSize() + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$FieldOptions parseFrom(final ByteString byteString) {
        return (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$FieldOptions parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FieldOptions parseFrom(final byte[] array) {
        return (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$FieldOptions parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FieldOptions parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$FieldOptions parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FieldOptions parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$FieldOptions parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FieldOptions parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$FieldOptions parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$FieldOptions$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$FieldOptions$Builder newBuilder() {
        return DescriptorProtos$FieldOptions.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$FieldOptions$Builder newBuilder(final DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        return DescriptorProtos$FieldOptions.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FieldOptions);
    }
    
    public DescriptorProtos$FieldOptions$Builder toBuilder() {
        return (this == DescriptorProtos$FieldOptions.DEFAULT_INSTANCE) ? new DescriptorProtos$FieldOptions$Builder((DescriptorProtos$1)null) : new DescriptorProtos$FieldOptions$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$FieldOptions$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$FieldOptions$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$FieldOptions getDefaultInstance() {
        return DescriptorProtos$FieldOptions.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$FieldOptions.PARSER;
    }
    
    public DescriptorProtos$FieldOptions getDefaultInstanceForType() {
        return DescriptorProtos$FieldOptions.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$FieldOptions();
        PARSER = new DescriptorProtos$FieldOptions$1();
    }
}
