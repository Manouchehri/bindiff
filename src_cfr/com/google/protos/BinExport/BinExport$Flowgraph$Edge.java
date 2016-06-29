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
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$EdgeType;
import com.google.protos.BinExport.BinExport$Flowgraph$EdgeOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class BinExport$Flowgraph$Edge
extends GeneratedMessage
implements BinExport$Flowgraph$EdgeOrBuilder {
    private int bitField0_;
    public static final int SOURCE_ADDRESS_FIELD_NUMBER = 1;
    private long sourceAddress_;
    public static final int TARGET_ADDRESS_FIELD_NUMBER = 2;
    private long targetAddress_;
    public static final int TYPE_FIELD_NUMBER = 3;
    private int type_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final BinExport$Flowgraph$Edge DEFAULT_INSTANCE = new BinExport$Flowgraph$Edge();
    public static final Parser PARSER = new BinExport$Flowgraph$Edge$1();

    private BinExport$Flowgraph$Edge(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private BinExport$Flowgraph$Edge() {
        this.sourceAddress_ = 0;
        this.targetAddress_ = 0;
        this.type_ = 3;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private BinExport$Flowgraph$Edge(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                        this.sourceAddress_ = codedInputStream.readUInt64();
                        continue block12;
                    }
                    case 16: {
                        this.bitField0_ |= 2;
                        this.targetAddress_ = codedInputStream.readUInt64();
                        continue block12;
                    }
                    case 24: 
                }
                int n3 = codedInputStream.readEnum();
                BinExport$Flowgraph$Edge$EdgeType binExport$Flowgraph$Edge$EdgeType = BinExport$Flowgraph$Edge$EdgeType.valueOf(n3);
                if (binExport$Flowgraph$Edge$EdgeType == null) {
                    unknownFieldSet$Builder.mergeVarintField(3, n3);
                    continue;
                }
                this.bitField0_ |= 4;
                this.type_ = n3;
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
        return BinExport.access$10000();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$10100().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Edge.class, BinExport$Flowgraph$Edge$Builder.class);
    }

    @Override
    public boolean hasSourceAddress() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public long getSourceAddress() {
        return this.sourceAddress_;
    }

    @Override
    public boolean hasTargetAddress() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public long getTargetAddress() {
        return this.targetAddress_;
    }

    @Override
    public boolean hasType() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public BinExport$Flowgraph$Edge$EdgeType getType() {
        BinExport$Flowgraph$Edge$EdgeType binExport$Flowgraph$Edge$EdgeType;
        BinExport$Flowgraph$Edge$EdgeType binExport$Flowgraph$Edge$EdgeType2 = BinExport$Flowgraph$Edge$EdgeType.valueOf(this.type_);
        if (binExport$Flowgraph$Edge$EdgeType2 == null) {
            binExport$Flowgraph$Edge$EdgeType = BinExport$Flowgraph$Edge$EdgeType.UNCONDITIONAL;
            return binExport$Flowgraph$Edge$EdgeType;
        }
        binExport$Flowgraph$Edge$EdgeType = binExport$Flowgraph$Edge$EdgeType2;
        return binExport$Flowgraph$Edge$EdgeType;
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
        if (!this.hasSourceAddress()) {
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
            codedOutputStream.writeUInt64(1, this.sourceAddress_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeUInt64(2, this.targetAddress_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.type_);
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
            n2 += CodedOutputStream.computeUInt64Size(1, this.sourceAddress_);
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeUInt64Size(2, this.targetAddress_);
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeEnumSize(3, this.type_);
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static BinExport$Flowgraph$Edge parseFrom(ByteString byteString) {
        return (BinExport$Flowgraph$Edge)PARSER.parseFrom(byteString);
    }

    public static BinExport$Flowgraph$Edge parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Edge)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Edge parseFrom(byte[] arrby) {
        return (BinExport$Flowgraph$Edge)PARSER.parseFrom(arrby);
    }

    public static BinExport$Flowgraph$Edge parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Edge)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Edge parseFrom(InputStream inputStream) {
        return (BinExport$Flowgraph$Edge)PARSER.parseFrom(inputStream);
    }

    public static BinExport$Flowgraph$Edge parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Edge)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Edge parseDelimitedFrom(InputStream inputStream) {
        return (BinExport$Flowgraph$Edge)PARSER.parseDelimitedFrom(inputStream);
    }

    public static BinExport$Flowgraph$Edge parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Edge)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Edge parseFrom(CodedInputStream codedInputStream) {
        return (BinExport$Flowgraph$Edge)PARSER.parseFrom(codedInputStream);
    }

    public static BinExport$Flowgraph$Edge parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Edge)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public BinExport$Flowgraph$Edge$Builder newBuilderForType() {
        return BinExport$Flowgraph$Edge.newBuilder();
    }

    public static BinExport$Flowgraph$Edge$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BinExport$Flowgraph$Edge$Builder newBuilder(BinExport$Flowgraph$Edge binExport$Flowgraph$Edge) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Flowgraph$Edge);
    }

    @Override
    public BinExport$Flowgraph$Edge$Builder toBuilder() {
        BinExport$Flowgraph$Edge$Builder binExport$Flowgraph$Edge$Builder;
        if (this == DEFAULT_INSTANCE) {
            binExport$Flowgraph$Edge$Builder = new BinExport$Flowgraph$Edge$Builder(null);
            return binExport$Flowgraph$Edge$Builder;
        }
        binExport$Flowgraph$Edge$Builder = new BinExport$Flowgraph$Edge$Builder(null).mergeFrom(this);
        return binExport$Flowgraph$Edge$Builder;
    }

    @Override
    protected BinExport$Flowgraph$Edge$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Flowgraph$Edge$Builder(generatedMessage$BuilderParent, null);
    }

    public static BinExport$Flowgraph$Edge getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public BinExport$Flowgraph$Edge getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ boolean access$10400() {
        return alwaysUseFieldBuilders;
    }

    /* synthetic */ BinExport$Flowgraph$Edge(GeneratedMessage$Builder generatedMessage$Builder, BinExport$1 binExport$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ long access$10602(BinExport$Flowgraph$Edge binExport$Flowgraph$Edge, long l2) {
        binExport$Flowgraph$Edge.sourceAddress_ = l2;
        return binExport$Flowgraph$Edge.sourceAddress_;
    }

    static /* synthetic */ long access$10702(BinExport$Flowgraph$Edge binExport$Flowgraph$Edge, long l2) {
        binExport$Flowgraph$Edge.targetAddress_ = l2;
        return binExport$Flowgraph$Edge.targetAddress_;
    }

    static /* synthetic */ int access$10802(BinExport$Flowgraph$Edge binExport$Flowgraph$Edge, int n2) {
        binExport$Flowgraph$Edge.type_ = n2;
        return binExport$Flowgraph$Edge.type_;
    }

    static /* synthetic */ int access$10902(BinExport$Flowgraph$Edge binExport$Flowgraph$Edge, int n2) {
        binExport$Flowgraph$Edge.bitField0_ = n2;
        return binExport$Flowgraph$Edge.bitField0_;
    }

    static /* synthetic */ UnknownFieldSet access$11000(BinExport$Flowgraph$Edge binExport$Flowgraph$Edge) {
        return binExport$Flowgraph$Edge.unknownFields;
    }

    /* synthetic */ BinExport$Flowgraph$Edge(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BinExport$1 binExport$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

