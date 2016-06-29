/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
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

public final class DescriptorProtos$DescriptorProto$ReservedRange
extends GeneratedMessage
implements DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder {
    private int bitField0_;
    public static final int START_FIELD_NUMBER = 1;
    private int start_;
    public static final int END_FIELD_NUMBER = 2;
    private int end_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$DescriptorProto$ReservedRange DEFAULT_INSTANCE = new DescriptorProtos$DescriptorProto$ReservedRange();
    public static final Parser PARSER = new DescriptorProtos$DescriptorProto$ReservedRange$1();

    private DescriptorProtos$DescriptorProto$ReservedRange(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$DescriptorProto$ReservedRange() {
        this.start_ = 0;
        this.end_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$DescriptorProto$ReservedRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                        case 8: {
                            this.bitField0_ |= 1;
                            this.start_ = codedInputStream.readInt32();
                            continue block10;
                        }
                        case 16: 
                    }
                    this.bitField0_ |= 2;
                    this.end_ = codedInputStream.readInt32();
                }
                Object var8_9 = null;
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
        catch (Throwable var7_11) {
            Object var8_10 = null;
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$3700();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$3800().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ReservedRange.class, DescriptorProtos$DescriptorProto$ReservedRange$Builder.class);
    }

    @Override
    public boolean hasStart() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public int getStart() {
        return this.start_;
    }

    @Override
    public boolean hasEnd() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public int getEnd() {
        return this.end_;
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
            codedOutputStream.writeInt32(1, this.start_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.end_);
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
            n2 += CodedOutputStream.computeInt32Size(1, this.start_);
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeInt32Size(2, this.end_);
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(ByteString byteString) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(byte[] arrby) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilderForType() {
        return DescriptorProtos$DescriptorProto$ReservedRange.newBuilder();
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilder(DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$DescriptorProto$ReservedRange);
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder toBuilder() {
        DescriptorProtos$DescriptorProto$ReservedRange$Builder descriptorProtos$DescriptorProto$ReservedRange$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$DescriptorProto$ReservedRange$Builder = new DescriptorProtos$DescriptorProto$ReservedRange$Builder(null);
            return descriptorProtos$DescriptorProto$ReservedRange$Builder;
        }
        descriptorProtos$DescriptorProto$ReservedRange$Builder = new DescriptorProtos$DescriptorProto$ReservedRange$Builder(null).mergeFrom(this);
        return descriptorProtos$DescriptorProto$ReservedRange$Builder;
    }

    @Override
    protected DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$DescriptorProto$ReservedRange$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRange getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$DescriptorProto$ReservedRange(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ int access$4202(DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange, int n2) {
        descriptorProtos$DescriptorProto$ReservedRange.start_ = n2;
        return descriptorProtos$DescriptorProto$ReservedRange.start_;
    }

    static /* synthetic */ int access$4302(DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange, int n2) {
        descriptorProtos$DescriptorProto$ReservedRange.end_ = n2;
        return descriptorProtos$DescriptorProto$ReservedRange.end_;
    }

    static /* synthetic */ int access$4402(DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange, int n2) {
        descriptorProtos$DescriptorProto$ReservedRange.bitField0_ = n2;
        return descriptorProtos$DescriptorProto$ReservedRange.bitField0_;
    }

    /* synthetic */ DescriptorProtos$DescriptorProto$ReservedRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

