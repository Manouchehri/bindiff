/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
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
import com.google.protos.BinExport.BinExport;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Callgraph$Edge$1;
import com.google.protos.BinExport.BinExport$Callgraph$Edge$Builder;
import com.google.protos.BinExport.BinExport$Callgraph$EdgeOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class BinExport$Callgraph$Edge
extends GeneratedMessage
implements BinExport$Callgraph$EdgeOrBuilder {
    private int bitField0_;
    public static final int SOURCE_FUNCTION_ADDRESS_FIELD_NUMBER = 1;
    private long sourceFunctionAddress_;
    public static final int SOURCE_INSTRUCTION_ADDRESS_FIELD_NUMBER = 2;
    private long sourceInstructionAddress_;
    public static final int TARGET_ADDRESS_FIELD_NUMBER = 3;
    private long targetAddress_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final BinExport$Callgraph$Edge DEFAULT_INSTANCE = new BinExport$Callgraph$Edge();
    public static final Parser PARSER = new BinExport$Callgraph$Edge$1();

    private BinExport$Callgraph$Edge(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private BinExport$Callgraph$Edge() {
        this.sourceFunctionAddress_ = 0;
        this.sourceInstructionAddress_ = 0;
        this.targetAddress_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private BinExport$Callgraph$Edge(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            boolean bl3 = false;
            block12 : while (!bl3) {
                int n2 = codedInputStream.readTag();
                switch (n2) {
                    case 0: {
                        bl3 = true;
                        continue block12;
                    }
                    default: {
                        if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block12;
                        bl3 = true;
                        continue block12;
                    }
                    case 8: {
                        this.bitField0_ |= 1;
                        this.sourceFunctionAddress_ = codedInputStream.readUInt64();
                        continue block12;
                    }
                    case 16: {
                        this.bitField0_ |= 2;
                        this.sourceInstructionAddress_ = codedInputStream.readUInt64();
                        continue block12;
                    }
                    case 24: 
                }
                this.bitField0_ |= 4;
                this.targetAddress_ = codedInputStream.readUInt64();
            }
            return;
        }
        catch (InvalidProtocolBufferException var5_6) {
            throw new RuntimeException(var5_6.setUnfinishedMessage(this));
        }
        catch (IOException var5_7) {
            throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
        }
        finally {
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$3500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$3600().ensureFieldAccessorsInitialized(BinExport$Callgraph$Edge.class, BinExport$Callgraph$Edge$Builder.class);
    }

    @Override
    public boolean hasSourceFunctionAddress() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public long getSourceFunctionAddress() {
        return this.sourceFunctionAddress_;
    }

    @Override
    public boolean hasSourceInstructionAddress() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public long getSourceInstructionAddress() {
        return this.sourceInstructionAddress_;
    }

    @Override
    public boolean hasTargetAddress() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public long getTargetAddress() {
        return this.targetAddress_;
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
        if (!this.hasSourceFunctionAddress()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (!this.hasSourceInstructionAddress()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (!this.hasTargetAddress()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeUInt64(1, this.sourceFunctionAddress_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeUInt64(2, this.sourceInstructionAddress_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeUInt64(3, this.targetAddress_);
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
            n2 += CodedOutputStream.computeUInt64Size(1, this.sourceFunctionAddress_);
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeUInt64Size(2, this.sourceInstructionAddress_);
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeUInt64Size(3, this.targetAddress_);
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static BinExport$Callgraph$Edge parseFrom(ByteString byteString) {
        return (BinExport$Callgraph$Edge)PARSER.parseFrom(byteString);
    }

    public static BinExport$Callgraph$Edge parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Edge)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BinExport$Callgraph$Edge parseFrom(byte[] arrby) {
        return (BinExport$Callgraph$Edge)PARSER.parseFrom(arrby);
    }

    public static BinExport$Callgraph$Edge parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Edge)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static BinExport$Callgraph$Edge parseFrom(InputStream inputStream) {
        return (BinExport$Callgraph$Edge)PARSER.parseFrom(inputStream);
    }

    public static BinExport$Callgraph$Edge parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Edge)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Callgraph$Edge parseDelimitedFrom(InputStream inputStream) {
        return (BinExport$Callgraph$Edge)PARSER.parseDelimitedFrom(inputStream);
    }

    public static BinExport$Callgraph$Edge parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Edge)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Callgraph$Edge parseFrom(CodedInputStream codedInputStream) {
        return (BinExport$Callgraph$Edge)PARSER.parseFrom(codedInputStream);
    }

    public static BinExport$Callgraph$Edge parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Edge)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public BinExport$Callgraph$Edge$Builder newBuilderForType() {
        return BinExport$Callgraph$Edge.newBuilder();
    }

    public static BinExport$Callgraph$Edge$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BinExport$Callgraph$Edge$Builder newBuilder(BinExport$Callgraph$Edge binExport$Callgraph$Edge) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Callgraph$Edge);
    }

    @Override
    public BinExport$Callgraph$Edge$Builder toBuilder() {
        BinExport$Callgraph$Edge$Builder binExport$Callgraph$Edge$Builder;
        if (this == DEFAULT_INSTANCE) {
            binExport$Callgraph$Edge$Builder = new BinExport$Callgraph$Edge$Builder(null);
            return binExport$Callgraph$Edge$Builder;
        }
        binExport$Callgraph$Edge$Builder = new BinExport$Callgraph$Edge$Builder(null).mergeFrom(this);
        return binExport$Callgraph$Edge$Builder;
    }

    @Override
    protected BinExport$Callgraph$Edge$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Callgraph$Edge$Builder(generatedMessage$BuilderParent, null);
    }

    public static BinExport$Callgraph$Edge getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public BinExport$Callgraph$Edge getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ boolean access$3900() {
        return alwaysUseFieldBuilders;
    }

    /* synthetic */ BinExport$Callgraph$Edge(GeneratedMessage$Builder generatedMessage$Builder, BinExport$1 binExport$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ long access$4102(BinExport$Callgraph$Edge binExport$Callgraph$Edge, long l2) {
        binExport$Callgraph$Edge.sourceFunctionAddress_ = l2;
        return binExport$Callgraph$Edge.sourceFunctionAddress_;
    }

    static /* synthetic */ long access$4202(BinExport$Callgraph$Edge binExport$Callgraph$Edge, long l2) {
        binExport$Callgraph$Edge.sourceInstructionAddress_ = l2;
        return binExport$Callgraph$Edge.sourceInstructionAddress_;
    }

    static /* synthetic */ long access$4302(BinExport$Callgraph$Edge binExport$Callgraph$Edge, long l2) {
        binExport$Callgraph$Edge.targetAddress_ = l2;
        return binExport$Callgraph$Edge.targetAddress_;
    }

    static /* synthetic */ int access$4402(BinExport$Callgraph$Edge binExport$Callgraph$Edge, int n2) {
        binExport$Callgraph$Edge.bitField0_ = n2;
        return binExport$Callgraph$Edge.bitField0_;
    }

    static /* synthetic */ UnknownFieldSet access$4500(BinExport$Callgraph$Edge binExport$Callgraph$Edge) {
        return binExport$Callgraph$Edge.unknownFields;
    }

    /* synthetic */ BinExport$Callgraph$Edge(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BinExport$1 binExport$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

