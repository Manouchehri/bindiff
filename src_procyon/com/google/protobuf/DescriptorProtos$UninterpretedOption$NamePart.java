package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$UninterpretedOption$NamePart extends GeneratedMessage implements DescriptorProtos$UninterpretedOption$NamePartOrBuilder
{
    private int bitField0_;
    public static final int NAME_PART_FIELD_NUMBER = 1;
    private volatile Object namePart_;
    public static final int IS_EXTENSION_FIELD_NUMBER = 2;
    private boolean isExtension_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$UninterpretedOption$NamePart DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$UninterpretedOption$NamePart(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$UninterpretedOption$NamePart() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.namePart_ = "";
        this.isExtension_ = false;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$UninterpretedOption$NamePart(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.namePart_ = bytes;
                        continue;
                    }
                    case 16: {
                        this.bitField0_ |= 0x2;
                        this.isExtension_ = codedInputStream.readBool();
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
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption$NamePart.class, DescriptorProtos$UninterpretedOption$NamePart$Builder.class);
    }
    
    public boolean hasNamePart() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public String getNamePart() {
        final Object namePart_ = this.namePart_;
        if (namePart_ instanceof String) {
            return (String)namePart_;
        }
        final ByteString byteString = (ByteString)namePart_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.namePart_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getNamePartBytes() {
        final Object namePart_ = this.namePart_;
        if (namePart_ instanceof String) {
            return (ByteString)(this.namePart_ = ByteString.copyFromUtf8((String)namePart_));
        }
        return (ByteString)namePart_;
    }
    
    public boolean hasIsExtension() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public boolean getIsExtension() {
        return this.isExtension_;
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        if (!this.hasNamePart()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (!this.hasIsExtension()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeBytes(1, this.getNamePartBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeBool(2, this.isExtension_);
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
            n += CodedOutputStream.computeBytesSize(1, this.getNamePartBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeBoolSize(2, this.isExtension_);
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(final ByteString byteString) {
        return (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(final byte[] array) {
        return (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilder() {
        return DescriptorProtos$UninterpretedOption$NamePart.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilder(final DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        return DescriptorProtos$UninterpretedOption$NamePart.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$UninterpretedOption$NamePart);
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder toBuilder() {
        return (this == DescriptorProtos$UninterpretedOption$NamePart.DEFAULT_INSTANCE) ? new DescriptorProtos$UninterpretedOption$NamePart$Builder((DescriptorProtos$1)null) : new DescriptorProtos$UninterpretedOption$NamePart$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$UninterpretedOption$NamePart$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$UninterpretedOption$NamePart getDefaultInstance() {
        return DescriptorProtos$UninterpretedOption$NamePart.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$UninterpretedOption$NamePart.PARSER;
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart getDefaultInstanceForType() {
        return DescriptorProtos$UninterpretedOption$NamePart.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$UninterpretedOption$NamePart();
        PARSER = new DescriptorProtos$UninterpretedOption$NamePart$1();
    }
}
