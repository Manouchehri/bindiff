package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$MessageOptions extends GeneratedMessage$ExtendableMessage implements DescriptorProtos$MessageOptionsOrBuilder
{
    private int bitField0_;
    public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
    private boolean messageSetWireFormat_;
    public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
    private boolean noStandardDescriptorAccessor_;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    private boolean deprecated_;
    public static final int MAP_ENTRY_FIELD_NUMBER = 7;
    private boolean mapEntry_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List uninterpretedOption_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$MessageOptions DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$MessageOptions(final GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder) {
        super(generatedMessage$ExtendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$MessageOptions() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.messageSetWireFormat_ = false;
        this.noStandardDescriptorAccessor_ = false;
        this.deprecated_ = false;
        this.mapEntry_ = false;
        this.uninterpretedOption_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$MessageOptions(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.bitField0_ |= 0x1;
                        this.messageSetWireFormat_ = codedInputStream.readBool();
                        continue;
                    }
                    case 16: {
                        this.bitField0_ |= 0x2;
                        this.noStandardDescriptorAccessor_ = codedInputStream.readBool();
                        continue;
                    }
                    case 24: {
                        this.bitField0_ |= 0x4;
                        this.deprecated_ = codedInputStream.readBool();
                        continue;
                    }
                    case 56: {
                        this.bitField0_ |= 0x8;
                        this.mapEntry_ = codedInputStream.readBool();
                        continue;
                    }
                    case 7994: {
                        if ((n & 0x10) != 0x10) {
                            this.uninterpretedOption_ = new ArrayList();
                            n |= 0x10;
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
            if ((n & 0x10) == 0x10) {
                this.uninterpretedOption_ = Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_MessageOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$MessageOptions.class, DescriptorProtos$MessageOptions$Builder.class);
    }
    
    public boolean hasMessageSetWireFormat() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public boolean getMessageSetWireFormat() {
        return this.messageSetWireFormat_;
    }
    
    public boolean hasNoStandardDescriptorAccessor() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public boolean getNoStandardDescriptorAccessor() {
        return this.noStandardDescriptorAccessor_;
    }
    
    public boolean hasDeprecated() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public boolean getDeprecated() {
        return this.deprecated_;
    }
    
    public boolean hasMapEntry() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public boolean getMapEntry() {
        return this.mapEntry_;
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
            codedOutputStream.writeBool(1, this.messageSetWireFormat_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeBool(2, this.noStandardDescriptorAccessor_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeBool(3, this.deprecated_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            codedOutputStream.writeBool(7, this.mapEntry_);
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
            n += CodedOutputStream.computeBoolSize(1, this.messageSetWireFormat_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeBoolSize(2, this.noStandardDescriptorAccessor_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeBoolSize(3, this.deprecated_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            n += CodedOutputStream.computeBoolSize(7, this.mapEntry_);
        }
        for (int i = 0; i < this.uninterpretedOption_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(999, (MessageLite)this.uninterpretedOption_.get(i));
        }
        return this.memoizedSerializedSize = n + this.extensionsSerializedSize() + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$MessageOptions parseFrom(final ByteString byteString) {
        return (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$MessageOptions parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$MessageOptions parseFrom(final byte[] array) {
        return (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$MessageOptions parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$MessageOptions parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$MessageOptions parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$MessageOptions parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$MessageOptions parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$MessageOptions parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$MessageOptions parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$MessageOptions$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$MessageOptions$Builder newBuilder() {
        return DescriptorProtos$MessageOptions.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$MessageOptions$Builder newBuilder(final DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        return DescriptorProtos$MessageOptions.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$MessageOptions);
    }
    
    public DescriptorProtos$MessageOptions$Builder toBuilder() {
        return (this == DescriptorProtos$MessageOptions.DEFAULT_INSTANCE) ? new DescriptorProtos$MessageOptions$Builder((DescriptorProtos$1)null) : new DescriptorProtos$MessageOptions$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$MessageOptions$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$MessageOptions$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$MessageOptions getDefaultInstance() {
        return DescriptorProtos$MessageOptions.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$MessageOptions.PARSER;
    }
    
    public DescriptorProtos$MessageOptions getDefaultInstanceForType() {
        return DescriptorProtos$MessageOptions.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$MessageOptions();
        PARSER = new DescriptorProtos$MessageOptions$1();
    }
}
