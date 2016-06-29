/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
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

public final class DescriptorProtos$OneofDescriptorProto
extends GeneratedMessage
implements DescriptorProtos$OneofDescriptorProtoOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$OneofDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$OneofDescriptorProto();
    public static final Parser PARSER = new DescriptorProtos$OneofDescriptorProto$1();

    private DescriptorProtos$OneofDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$OneofDescriptorProto() {
        this.name_ = "";
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$OneofDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            try {
                boolean bl3 = false;
                block9 : while (!bl3) {
                    int n2 = codedInputStream.readTag();
                    switch (n2) {
                        case 0: {
                            bl3 = true;
                            continue block9;
                        }
                        default: {
                            if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block9;
                            bl3 = true;
                            continue block9;
                        }
                        case 10: 
                    }
                    ByteString byteString = codedInputStream.readBytes();
                    this.bitField0_ |= 1;
                    this.name_ = byteString;
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
        return DescriptorProtos.access$7700();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$7800().ensureFieldAccessorsInitialized(DescriptorProtos$OneofDescriptorProto.class, DescriptorProtos$OneofDescriptorProto$Builder.class);
    }

    @Override
    public boolean hasName() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getName() {
        Object object = this.name_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.name_ = string;
        return string;
    }

    @Override
    public ByteString getNameBytes() {
        ByteString byteString;
        Object object = this.name_;
        if (!(object instanceof String)) return (ByteString)object;
        this.name_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
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
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
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
            n2 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(byte[] arrby) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$OneofDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$OneofDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$OneofDescriptorProto.newBuilder();
    }

    public static DescriptorProtos$OneofDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$OneofDescriptorProto$Builder newBuilder(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$OneofDescriptorProto);
    }

    @Override
    public DescriptorProtos$OneofDescriptorProto$Builder toBuilder() {
        DescriptorProtos$OneofDescriptorProto$Builder descriptorProtos$OneofDescriptorProto$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$OneofDescriptorProto$Builder = new DescriptorProtos$OneofDescriptorProto$Builder(null);
            return descriptorProtos$OneofDescriptorProto$Builder;
        }
        descriptorProtos$OneofDescriptorProto$Builder = new DescriptorProtos$OneofDescriptorProto$Builder(null).mergeFrom(this);
        return descriptorProtos$OneofDescriptorProto$Builder;
    }

    @Override
    protected DescriptorProtos$OneofDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$OneofDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$OneofDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$OneofDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$OneofDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$8202(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto, Object object) {
        descriptorProtos$OneofDescriptorProto.name_ = object;
        return descriptorProtos$OneofDescriptorProto.name_;
    }

    static /* synthetic */ int access$8302(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto, int n2) {
        descriptorProtos$OneofDescriptorProto.bitField0_ = n2;
        return descriptorProtos$OneofDescriptorProto.bitField0_;
    }

    static /* synthetic */ Object access$8200(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        return descriptorProtos$OneofDescriptorProto.name_;
    }

    /* synthetic */ DescriptorProtos$OneofDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

