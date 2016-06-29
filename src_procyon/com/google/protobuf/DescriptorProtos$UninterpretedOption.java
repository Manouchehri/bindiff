package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$UninterpretedOption extends GeneratedMessage implements DescriptorProtos$UninterpretedOptionOrBuilder
{
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 2;
    private List name_;
    public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
    private volatile Object identifierValue_;
    public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
    private long positiveIntValue_;
    public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
    private long negativeIntValue_;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
    private double doubleValue_;
    public static final int STRING_VALUE_FIELD_NUMBER = 7;
    private ByteString stringValue_;
    public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
    private volatile Object aggregateValue_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$UninterpretedOption DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$UninterpretedOption(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$UninterpretedOption() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = Collections.emptyList();
        this.identifierValue_ = "";
        this.positiveIntValue_ = 0L;
        this.negativeIntValue_ = 0L;
        this.doubleValue_ = 0.0;
        this.stringValue_ = ByteString.EMPTY;
        this.aggregateValue_ = "";
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$UninterpretedOption(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 18: {
                        if ((n & 0x1) != 0x1) {
                            this.name_ = new ArrayList();
                            n |= 0x1;
                        }
                        this.name_.add(codedInputStream.readMessage(DescriptorProtos$UninterpretedOption$NamePart.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 26: {
                        final ByteString bytes = codedInputStream.readBytes();
                        this.bitField0_ |= 0x1;
                        this.identifierValue_ = bytes;
                        continue;
                    }
                    case 32: {
                        this.bitField0_ |= 0x2;
                        this.positiveIntValue_ = codedInputStream.readUInt64();
                        continue;
                    }
                    case 40: {
                        this.bitField0_ |= 0x4;
                        this.negativeIntValue_ = codedInputStream.readInt64();
                        continue;
                    }
                    case 49: {
                        this.bitField0_ |= 0x8;
                        this.doubleValue_ = codedInputStream.readDouble();
                        continue;
                    }
                    case 58: {
                        this.bitField0_ |= 0x10;
                        this.stringValue_ = codedInputStream.readBytes();
                        continue;
                    }
                    case 66: {
                        final ByteString bytes2 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x20;
                        this.aggregateValue_ = bytes2;
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
            if ((n & 0x1) == 0x1) {
                this.name_ = Collections.unmodifiableList((List<?>)this.name_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption.class, DescriptorProtos$UninterpretedOption$Builder.class);
    }
    
    public List getNameList() {
        return this.name_;
    }
    
    public List getNameOrBuilderList() {
        return this.name_;
    }
    
    public int getNameCount() {
        return this.name_.size();
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart getName(final int n) {
        return this.name_.get(n);
    }
    
    public DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(final int n) {
        return this.name_.get(n);
    }
    
    public boolean hasIdentifierValue() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public String getIdentifierValue() {
        final Object identifierValue_ = this.identifierValue_;
        if (identifierValue_ instanceof String) {
            return (String)identifierValue_;
        }
        final ByteString byteString = (ByteString)identifierValue_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.identifierValue_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getIdentifierValueBytes() {
        final Object identifierValue_ = this.identifierValue_;
        if (identifierValue_ instanceof String) {
            return (ByteString)(this.identifierValue_ = ByteString.copyFromUtf8((String)identifierValue_));
        }
        return (ByteString)identifierValue_;
    }
    
    public boolean hasPositiveIntValue() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public long getPositiveIntValue() {
        return this.positiveIntValue_;
    }
    
    public boolean hasNegativeIntValue() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public long getNegativeIntValue() {
        return this.negativeIntValue_;
    }
    
    public boolean hasDoubleValue() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public double getDoubleValue() {
        return this.doubleValue_;
    }
    
    public boolean hasStringValue() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    public ByteString getStringValue() {
        return this.stringValue_;
    }
    
    public boolean hasAggregateValue() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    public String getAggregateValue() {
        final Object aggregateValue_ = this.aggregateValue_;
        if (aggregateValue_ instanceof String) {
            return (String)aggregateValue_;
        }
        final ByteString byteString = (ByteString)aggregateValue_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.aggregateValue_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getAggregateValueBytes() {
        final Object aggregateValue_ = this.aggregateValue_;
        if (aggregateValue_ instanceof String) {
            return (ByteString)(this.aggregateValue_ = ByteString.copyFromUtf8((String)aggregateValue_));
        }
        return (ByteString)aggregateValue_;
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        for (int i = 0; i < this.getNameCount(); ++i) {
            if (!this.getName(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.name_.size(); ++i) {
            codedOutputStream.writeMessage(2, (MessageLite)this.name_.get(i));
        }
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeBytes(3, this.getIdentifierValueBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeUInt64(4, this.positiveIntValue_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeInt64(5, this.negativeIntValue_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            codedOutputStream.writeDouble(6, this.doubleValue_);
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            codedOutputStream.writeBytes(7, this.stringValue_);
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            codedOutputStream.writeBytes(8, this.getAggregateValueBytes());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int n = 0;
        for (int i = 0; i < this.name_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(2, (MessageLite)this.name_.get(i));
        }
        if ((this.bitField0_ & 0x1) == 0x1) {
            n += CodedOutputStream.computeBytesSize(3, this.getIdentifierValueBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeUInt64Size(4, this.positiveIntValue_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeInt64Size(5, this.negativeIntValue_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            n += CodedOutputStream.computeDoubleSize(6, this.doubleValue_);
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            n += CodedOutputStream.computeBytesSize(7, this.stringValue_);
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            n += CodedOutputStream.computeBytesSize(8, this.getAggregateValueBytes());
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$UninterpretedOption parseFrom(final ByteString byteString) {
        return (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$UninterpretedOption parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$UninterpretedOption parseFrom(final byte[] array) {
        return (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$UninterpretedOption parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$UninterpretedOption parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$UninterpretedOption parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$UninterpretedOption parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$UninterpretedOption parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$UninterpretedOption parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$UninterpretedOption parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$UninterpretedOption$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$UninterpretedOption$Builder newBuilder() {
        return DescriptorProtos$UninterpretedOption.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$UninterpretedOption$Builder newBuilder(final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        return DescriptorProtos$UninterpretedOption.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$UninterpretedOption);
    }
    
    public DescriptorProtos$UninterpretedOption$Builder toBuilder() {
        return (this == DescriptorProtos$UninterpretedOption.DEFAULT_INSTANCE) ? new DescriptorProtos$UninterpretedOption$Builder((DescriptorProtos$1)null) : new DescriptorProtos$UninterpretedOption$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$UninterpretedOption$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$UninterpretedOption$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$UninterpretedOption getDefaultInstance() {
        return DescriptorProtos$UninterpretedOption.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$UninterpretedOption.PARSER;
    }
    
    public DescriptorProtos$UninterpretedOption getDefaultInstanceForType() {
        return DescriptorProtos$UninterpretedOption.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$UninterpretedOption();
        PARSER = new DescriptorProtos$UninterpretedOption$1();
    }
}
