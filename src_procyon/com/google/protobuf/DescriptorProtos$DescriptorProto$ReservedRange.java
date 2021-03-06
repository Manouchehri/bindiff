package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$DescriptorProto$ReservedRange extends GeneratedMessage implements DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder
{
    private int bitField0_;
    public static final int START_FIELD_NUMBER = 1;
    private int start_;
    public static final int END_FIELD_NUMBER = 2;
    private int end_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$DescriptorProto$ReservedRange DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$DescriptorProto$ReservedRange(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$DescriptorProto$ReservedRange() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.start_ = 0;
        this.end_ = 0;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$DescriptorProto$ReservedRange(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 8: {
                        this.bitField0_ |= 0x1;
                        this.start_ = codedInputStream.readInt32();
                        continue;
                    }
                    case 16: {
                        this.bitField0_ |= 0x2;
                        this.end_ = codedInputStream.readInt32();
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
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ReservedRange_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ReservedRange_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ReservedRange.class, DescriptorProtos$DescriptorProto$ReservedRange$Builder.class);
    }
    
    public boolean hasStart() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public int getStart() {
        return this.start_;
    }
    
    public boolean hasEnd() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public int getEnd() {
        return this.end_;
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeInt32(1, this.start_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeInt32(2, this.end_);
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
            n += CodedOutputStream.computeInt32Size(1, this.start_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeInt32Size(2, this.end_);
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(final ByteString byteString) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(final byte[] array) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilder() {
        return DescriptorProtos$DescriptorProto$ReservedRange.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilder(final DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        return DescriptorProtos$DescriptorProto$ReservedRange.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$DescriptorProto$ReservedRange);
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder toBuilder() {
        return (this == DescriptorProtos$DescriptorProto$ReservedRange.DEFAULT_INSTANCE) ? new DescriptorProtos$DescriptorProto$ReservedRange$Builder((DescriptorProtos$1)null) : new DescriptorProtos$DescriptorProto$ReservedRange$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$DescriptorProto$ReservedRange$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$DescriptorProto$ReservedRange getDefaultInstance() {
        return DescriptorProtos$DescriptorProto$ReservedRange.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$DescriptorProto$ReservedRange.PARSER;
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto$ReservedRange.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$DescriptorProto$ReservedRange();
        PARSER = new DescriptorProtos$DescriptorProto$ReservedRange$1();
    }
}
