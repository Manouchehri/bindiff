/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;

public final class DescriptorProtos$UninterpretedOption$NamePart
extends GeneratedMessage
implements DescriptorProtos$UninterpretedOption$NamePartOrBuilder {
    private int bitField0_;
    public static final int NAME_PART_FIELD_NUMBER = 1;
    private volatile Object namePart_;
    public static final int IS_EXTENSION_FIELD_NUMBER = 2;
    private boolean isExtension_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$UninterpretedOption$NamePart DEFAULT_INSTANCE = new DescriptorProtos$UninterpretedOption$NamePart();
    public static final Parser PARSER = new DescriptorProtos$UninterpretedOption$NamePart$1();

    private DescriptorProtos$UninterpretedOption$NamePart(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$UninterpretedOption$NamePart() {
        this.namePart_ = "";
        this.isExtension_ = false;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$UninterpretedOption$NamePart(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            try {
                boolean bl3 = false;
                block10 : while (!bl3) {
                    int n2 = codedInputStream.readTag();
                    switch (n2) {
                        case 0: {
                            bl3 = true;
                            continue block10;
                        }
                        default: {
                            if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block10;
                            bl3 = true;
                            continue block10;
                        }
                        case 10: {
                            ByteString byteString = codedInputStream.readBytes();
                            this.bitField0_ |= 1;
                            this.namePart_ = byteString;
                            continue block10;
                        }
                        case 16: 
                    }
                    this.bitField0_ |= 2;
                    this.isExtension_ = codedInputStream.readBool();
                }
                Object var9_10 = null;
                this.unknownFields = unknownFieldSet$Builder.build();
            }
            catch (InvalidProtocolBufferException var5_6) {
                throw new RuntimeException(var5_6.setUnfinishedMessage(this));
            }
            catch (IOException var5_7) {
                throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var8_12) {
            Object var9_11 = null;
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var8_12;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$21500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$21600().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption$NamePart.class, DescriptorProtos$UninterpretedOption$NamePart$Builder.class);
    }

    @Override
    public boolean hasNamePart() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getNamePart() {
        Object object = this.namePart_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.namePart_ = string;
        return string;
    }

    @Override
    public ByteString getNamePartBytes() {
        ByteString byteString;
        Object object = this.namePart_;
        if (!(object instanceof String)) return (ByteString)object;
        this.namePart_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasIsExtension() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public boolean getIsExtension() {
        return this.isExtension_;
    }

    @Override
    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        if (by2 == 1) {
            return true;
        }
        if (by2 == 0) {
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

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(1, this.getNamePartBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBool(2, this.isExtension_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if ((this.bitField0_ & 1) == 1) {
            n2 += CodedOutputStream.computeBytesSize(1, this.getNamePartBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeBoolSize(2, this.isExtension_);
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(ByteString byteString) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(byte[] arrby) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilderForType() {
        return DescriptorProtos$UninterpretedOption$NamePart.newBuilder();
    }

    public static DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilder(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$UninterpretedOption$NamePart);
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePart$Builder toBuilder() {
        DescriptorProtos$UninterpretedOption$NamePart$Builder descriptorProtos$UninterpretedOption$NamePart$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$UninterpretedOption$NamePart$Builder = new DescriptorProtos$UninterpretedOption$NamePart$Builder(null);
            return descriptorProtos$UninterpretedOption$NamePart$Builder;
        }
        descriptorProtos$UninterpretedOption$NamePart$Builder = new DescriptorProtos$UninterpretedOption$NamePart$Builder(null).mergeFrom(this);
        return descriptorProtos$UninterpretedOption$NamePart$Builder;
    }

    @Override
    protected DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$UninterpretedOption$NamePart$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$UninterpretedOption$NamePart getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePart getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$UninterpretedOption$NamePart(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$22002(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart, Object object) {
        descriptorProtos$UninterpretedOption$NamePart.namePart_ = object;
        return descriptorProtos$UninterpretedOption$NamePart.namePart_;
    }

    static /* synthetic */ boolean access$22102(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart, boolean bl2) {
        descriptorProtos$UninterpretedOption$NamePart.isExtension_ = bl2;
        return descriptorProtos$UninterpretedOption$NamePart.isExtension_;
    }

    static /* synthetic */ int access$22202(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart, int n2) {
        descriptorProtos$UninterpretedOption$NamePart.bitField0_ = n2;
        return descriptorProtos$UninterpretedOption$NamePart.bitField0_;
    }

    static /* synthetic */ Object access$22000(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        return descriptorProtos$UninterpretedOption$NamePart.namePart_;
    }

    /* synthetic */ DescriptorProtos$UninterpretedOption$NamePart(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

