package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$ServiceOptions extends GeneratedMessage$ExtendableMessage implements DescriptorProtos$ServiceOptionsOrBuilder
{
    private int bitField0_;
    public static final int DEPRECATED_FIELD_NUMBER = 33;
    private boolean deprecated_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List uninterpretedOption_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$ServiceOptions DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$ServiceOptions(final GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder) {
        super(generatedMessage$ExtendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$ServiceOptions() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.deprecated_ = false;
        this.uninterpretedOption_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$ServiceOptions(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 264: {
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
        return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$ServiceOptions.class, DescriptorProtos$ServiceOptions$Builder.class);
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
            codedOutputStream.writeBool(33, this.deprecated_);
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
            n += CodedOutputStream.computeBoolSize(33, this.deprecated_);
        }
        for (int i = 0; i < this.uninterpretedOption_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(999, (MessageLite)this.uninterpretedOption_.get(i));
        }
        return this.memoizedSerializedSize = n + this.extensionsSerializedSize() + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$ServiceOptions parseFrom(final ByteString byteString) {
        return (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$ServiceOptions parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$ServiceOptions parseFrom(final byte[] array) {
        return (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$ServiceOptions parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$ServiceOptions parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$ServiceOptions parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$ServiceOptions parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$ServiceOptions parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$ServiceOptions parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$ServiceOptions parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$ServiceOptions$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$ServiceOptions$Builder newBuilder() {
        return DescriptorProtos$ServiceOptions.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$ServiceOptions$Builder newBuilder(final DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions) {
        return DescriptorProtos$ServiceOptions.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$ServiceOptions);
    }
    
    public DescriptorProtos$ServiceOptions$Builder toBuilder() {
        return (this == DescriptorProtos$ServiceOptions.DEFAULT_INSTANCE) ? new DescriptorProtos$ServiceOptions$Builder((DescriptorProtos$1)null) : new DescriptorProtos$ServiceOptions$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$ServiceOptions$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$ServiceOptions$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$ServiceOptions getDefaultInstance() {
        return DescriptorProtos$ServiceOptions.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$ServiceOptions.PARSER;
    }
    
    public DescriptorProtos$ServiceOptions getDefaultInstanceForType() {
        return DescriptorProtos$ServiceOptions.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$ServiceOptions();
        PARSER = new DescriptorProtos$ServiceOptions$1();
    }
}
