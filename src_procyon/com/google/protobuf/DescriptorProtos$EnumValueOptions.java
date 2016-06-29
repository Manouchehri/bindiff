package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$EnumValueOptions extends GeneratedMessage$ExtendableMessage implements DescriptorProtos$EnumValueOptionsOrBuilder
{
    private int bitField0_;
    public static final int DEPRECATED_FIELD_NUMBER = 1;
    private boolean deprecated_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List uninterpretedOption_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$EnumValueOptions DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$EnumValueOptions(final GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder) {
        super(generatedMessage$ExtendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$EnumValueOptions() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.deprecated_ = false;
        this.uninterpretedOption_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$EnumValueOptions(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.deprecated_ = codedInputStream.readBool();
                        continue;
                    }
                    case 7994: {
                        if ((n & 0x2) != 0x2) {
                            this.uninterpretedOption_ = new ArrayList();
                            n |= 0x2;
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
            if ((n & 0x2) == 0x2) {
                this.uninterpretedOption_ = Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueOptions.class, DescriptorProtos$EnumValueOptions$Builder.class);
    }
    
    public boolean hasDeprecated() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public boolean getDeprecated() {
        return this.deprecated_;
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
            codedOutputStream.writeBool(1, this.deprecated_);
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
            n += CodedOutputStream.computeBoolSize(1, this.deprecated_);
        }
        for (int i = 0; i < this.uninterpretedOption_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(999, (MessageLite)this.uninterpretedOption_.get(i));
        }
        return this.memoizedSerializedSize = n + this.extensionsSerializedSize() + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$EnumValueOptions parseFrom(final ByteString byteString) {
        return (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$EnumValueOptions parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumValueOptions parseFrom(final byte[] array) {
        return (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$EnumValueOptions parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumValueOptions parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$EnumValueOptions parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumValueOptions parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$EnumValueOptions parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$EnumValueOptions parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$EnumValueOptions parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$EnumValueOptions$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$EnumValueOptions$Builder newBuilder() {
        return DescriptorProtos$EnumValueOptions.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$EnumValueOptions$Builder newBuilder(final DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        return DescriptorProtos$EnumValueOptions.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$EnumValueOptions);
    }
    
    public DescriptorProtos$EnumValueOptions$Builder toBuilder() {
        return (this == DescriptorProtos$EnumValueOptions.DEFAULT_INSTANCE) ? new DescriptorProtos$EnumValueOptions$Builder((DescriptorProtos$1)null) : new DescriptorProtos$EnumValueOptions$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$EnumValueOptions$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$EnumValueOptions$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$EnumValueOptions getDefaultInstance() {
        return DescriptorProtos$EnumValueOptions.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$EnumValueOptions.PARSER;
    }
    
    public DescriptorProtos$EnumValueOptions getDefaultInstanceForType() {
        return DescriptorProtos$EnumValueOptions.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$EnumValueOptions();
        PARSER = new DescriptorProtos$EnumValueOptions$1();
    }
}
