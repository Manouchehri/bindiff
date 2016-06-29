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
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$InstructionOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BinExport$Flowgraph$Vertex$Instruction
extends GeneratedMessage
implements BinExport$Flowgraph$Vertex$InstructionOrBuilder {
    private int bitField0_;
    public static final int ADDRESS_FIELD_NUMBER = 1;
    private long address_;
    public static final int PRIME_FIELD_NUMBER = 2;
    private int prime_;
    public static final int STRING_REFERENCE_FIELD_NUMBER = 3;
    private int stringReference_;
    public static final int MNEMONIC_FIELD_NUMBER = 4;
    private volatile Object mnemonic_;
    public static final int OPERANDS_FIELD_NUMBER = 5;
    private volatile Object operands_;
    public static final int RAW_BYTES_FIELD_NUMBER = 6;
    private ByteString rawBytes_;
    public static final int CALL_TARGETS_FIELD_NUMBER = 7;
    private List callTargets_;
    public static final int COMMENTS_FIELD_NUMBER = 8;
    private List comments_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final BinExport$Flowgraph$Vertex$Instruction DEFAULT_INSTANCE = new BinExport$Flowgraph$Vertex$Instruction();
    public static final Parser PARSER = new BinExport$Flowgraph$Vertex$Instruction$1();

    private BinExport$Flowgraph$Vertex$Instruction(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private BinExport$Flowgraph$Vertex$Instruction() {
        this.address_ = 0;
        this.prime_ = 0;
        this.stringReference_ = 0;
        this.mnemonic_ = "";
        this.operands_ = "";
        this.rawBytes_ = ByteString.EMPTY;
        this.callTargets_ = Collections.emptyList();
        this.comments_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private BinExport$Flowgraph$Vertex$Instruction(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            boolean bl2 = false;
            block18 : while (!bl2) {
                int n3 = codedInputStream.readTag();
                switch (n3) {
                    ByteString byteString;
                    case 0: {
                        bl2 = true;
                        continue block18;
                    }
                    default: {
                        if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block18;
                        bl2 = true;
                        continue block18;
                    }
                    case 8: {
                        this.bitField0_ |= 1;
                        this.address_ = codedInputStream.readUInt64();
                        continue block18;
                    }
                    case 16: {
                        this.bitField0_ |= 2;
                        this.prime_ = codedInputStream.readUInt32();
                        continue block18;
                    }
                    case 24: {
                        this.bitField0_ |= 4;
                        this.stringReference_ = codedInputStream.readUInt32();
                        continue block18;
                    }
                    case 34: {
                        byteString = codedInputStream.readBytes();
                        this.bitField0_ |= 8;
                        this.mnemonic_ = byteString;
                        continue block18;
                    }
                    case 42: {
                        byteString = codedInputStream.readBytes();
                        this.bitField0_ |= 16;
                        this.operands_ = byteString;
                        continue block18;
                    }
                    case 50: {
                        this.bitField0_ |= 32;
                        this.rawBytes_ = codedInputStream.readBytes();
                        continue block18;
                    }
                    case 56: {
                        if ((n2 & 64) != 64) {
                            this.callTargets_ = new ArrayList();
                            n2 |= 64;
                        }
                        this.callTargets_.add(codedInputStream.readUInt64());
                        continue block18;
                    }
                    case 58: {
                        int n4 = codedInputStream.readRawVarint32();
                        int n5 = codedInputStream.pushLimit(n4);
                        if ((n2 & 64) != 64 && codedInputStream.getBytesUntilLimit() > 0) {
                            this.callTargets_ = new ArrayList();
                            n2 |= 64;
                        }
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            this.callTargets_.add(codedInputStream.readUInt64());
                        }
                        codedInputStream.popLimit(n5);
                        continue block18;
                    }
                    case 66: 
                }
                if ((n2 & 128) != 128) {
                    this.comments_ = new ArrayList();
                    n2 |= 128;
                }
                this.comments_.add(codedInputStream.readMessage(BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER, extensionRegistryLite));
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
            if ((n2 & 64) == 64) {
                this.callTargets_ = Collections.unmodifiableList(this.callTargets_);
            }
            if ((n2 & 128) == 128) {
                this.comments_ = Collections.unmodifiableList(this.comments_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$6100();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$6200().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction.class, BinExport$Flowgraph$Vertex$Instruction$Builder.class);
    }

    @Override
    public boolean hasAddress() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public long getAddress() {
        return this.address_;
    }

    @Override
    public boolean hasPrime() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public int getPrime() {
        return this.prime_;
    }

    @Override
    public boolean hasStringReference() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public int getStringReference() {
        return this.stringReference_;
    }

    @Override
    public boolean hasMnemonic() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public String getMnemonic() {
        Object object = this.mnemonic_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.mnemonic_ = string;
        return string;
    }

    @Override
    public ByteString getMnemonicBytes() {
        ByteString byteString;
        Object object = this.mnemonic_;
        if (!(object instanceof String)) return (ByteString)object;
        this.mnemonic_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasOperands() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public String getOperands() {
        Object object = this.operands_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.operands_ = string;
        return string;
    }

    @Override
    public ByteString getOperandsBytes() {
        ByteString byteString;
        Object object = this.operands_;
        if (!(object instanceof String)) return (ByteString)object;
        this.operands_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasRawBytes() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public ByteString getRawBytes() {
        return this.rawBytes_;
    }

    @Override
    public List getCallTargetsList() {
        return this.callTargets_;
    }

    @Override
    public int getCallTargetsCount() {
        return this.callTargets_.size();
    }

    @Override
    public long getCallTargets(int n2) {
        return (Long)this.callTargets_.get(n2);
    }

    @Override
    public List getCommentsList() {
        return this.comments_;
    }

    @Override
    public List getCommentsOrBuilderList() {
        return this.comments_;
    }

    @Override
    public int getCommentsCount() {
        return this.comments_.size();
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment getComments(int n2) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)this.comments_.get(n2);
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder getCommentsOrBuilder(int n2) {
        return (BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder)this.comments_.get(n2);
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
        if (!this.hasAddress()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (!this.hasPrime()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        int n2 = 0;
        do {
            if (n2 >= this.getCommentsCount()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            if (!this.getComments(n2).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            ++n2;
        } while (true);
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        int n2;
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeUInt64(1, this.address_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeUInt32(2, this.prime_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeUInt32(3, this.stringReference_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeBytes(4, this.getMnemonicBytes());
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeBytes(5, this.getOperandsBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeBytes(6, this.rawBytes_);
        }
        for (n2 = 0; n2 < this.callTargets_.size(); ++n2) {
            codedOutputStream.writeUInt64(7, (Long)this.callTargets_.get(n2));
        }
        n2 = 0;
        do {
            if (n2 >= this.comments_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            }
            codedOutputStream.writeMessage(8, (MessageLite)this.comments_.get(n2));
            ++n2;
        } while (true);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if ((this.bitField0_ & 1) == 1) {
            n2 += CodedOutputStream.computeUInt64Size(1, this.address_);
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeUInt32Size(2, this.prime_);
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeUInt32Size(3, this.stringReference_);
        }
        if ((this.bitField0_ & 8) == 8) {
            n2 += CodedOutputStream.computeBytesSize(4, this.getMnemonicBytes());
        }
        if ((this.bitField0_ & 16) == 16) {
            n2 += CodedOutputStream.computeBytesSize(5, this.getOperandsBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            n2 += CodedOutputStream.computeBytesSize(6, this.rawBytes_);
        }
        int n3 = 0;
        for (int i2 = 0; i2 < this.callTargets_.size(); n3 += CodedOutputStream.computeUInt64SizeNoTag((long)((Long)this.callTargets_.get((int)i2)).longValue()), ++i2) {
        }
        n2 += n3;
        n2 += 1 * this.getCallTargetsList().size();
        n3 = 0;
        do {
            if (n3 >= this.comments_.size()) {
                this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
                return n2;
            }
            n2 += CodedOutputStream.computeMessageSize(8, (MessageLite)this.comments_.get(n3));
            ++n3;
        } while (true);
    }

    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(ByteString byteString) {
        return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(byteString);
    }

    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(byte[] arrby) {
        return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(arrby);
    }

    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(inputStream);
    }

    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex$Instruction parseDelimitedFrom(InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseDelimitedFrom(inputStream);
    }

    public static BinExport$Flowgraph$Vertex$Instruction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(CodedInputStream codedInputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(codedInputStream);
    }

    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Builder newBuilderForType() {
        return BinExport$Flowgraph$Vertex$Instruction.newBuilder();
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Builder newBuilder(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Flowgraph$Vertex$Instruction);
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Builder toBuilder() {
        BinExport$Flowgraph$Vertex$Instruction$Builder binExport$Flowgraph$Vertex$Instruction$Builder;
        if (this == DEFAULT_INSTANCE) {
            binExport$Flowgraph$Vertex$Instruction$Builder = new BinExport$Flowgraph$Vertex$Instruction$Builder(null);
            return binExport$Flowgraph$Vertex$Instruction$Builder;
        }
        binExport$Flowgraph$Vertex$Instruction$Builder = new BinExport$Flowgraph$Vertex$Instruction$Builder(null).mergeFrom(this);
        return binExport$Flowgraph$Vertex$Instruction$Builder;
    }

    @Override
    protected BinExport$Flowgraph$Vertex$Instruction$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Flowgraph$Vertex$Instruction$Builder(generatedMessage$BuilderParent, null);
    }

    public static BinExport$Flowgraph$Vertex$Instruction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ boolean access$7600() {
        return alwaysUseFieldBuilders;
    }

    /* synthetic */ BinExport$Flowgraph$Vertex$Instruction(GeneratedMessage$Builder generatedMessage$Builder, BinExport$1 binExport$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ long access$7802(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction, long l2) {
        binExport$Flowgraph$Vertex$Instruction.address_ = l2;
        return binExport$Flowgraph$Vertex$Instruction.address_;
    }

    static /* synthetic */ int access$7902(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction, int n2) {
        binExport$Flowgraph$Vertex$Instruction.prime_ = n2;
        return binExport$Flowgraph$Vertex$Instruction.prime_;
    }

    static /* synthetic */ int access$8002(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction, int n2) {
        binExport$Flowgraph$Vertex$Instruction.stringReference_ = n2;
        return binExport$Flowgraph$Vertex$Instruction.stringReference_;
    }

    static /* synthetic */ Object access$8102(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction, Object object) {
        binExport$Flowgraph$Vertex$Instruction.mnemonic_ = object;
        return binExport$Flowgraph$Vertex$Instruction.mnemonic_;
    }

    static /* synthetic */ Object access$8202(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction, Object object) {
        binExport$Flowgraph$Vertex$Instruction.operands_ = object;
        return binExport$Flowgraph$Vertex$Instruction.operands_;
    }

    static /* synthetic */ ByteString access$8302(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction, ByteString byteString) {
        binExport$Flowgraph$Vertex$Instruction.rawBytes_ = byteString;
        return binExport$Flowgraph$Vertex$Instruction.rawBytes_;
    }

    static /* synthetic */ List access$8402(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction, List list) {
        binExport$Flowgraph$Vertex$Instruction.callTargets_ = list;
        return binExport$Flowgraph$Vertex$Instruction.callTargets_;
    }

    static /* synthetic */ List access$8502(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction, List list) {
        binExport$Flowgraph$Vertex$Instruction.comments_ = list;
        return binExport$Flowgraph$Vertex$Instruction.comments_;
    }

    static /* synthetic */ int access$8602(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction, int n2) {
        binExport$Flowgraph$Vertex$Instruction.bitField0_ = n2;
        return binExport$Flowgraph$Vertex$Instruction.bitField0_;
    }

    static /* synthetic */ Object access$8100(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        return binExport$Flowgraph$Vertex$Instruction.mnemonic_;
    }

    static /* synthetic */ Object access$8200(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        return binExport$Flowgraph$Vertex$Instruction.operands_;
    }

    static /* synthetic */ List access$8400(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        return binExport$Flowgraph$Vertex$Instruction.callTargets_;
    }

    static /* synthetic */ List access$8500(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        return binExport$Flowgraph$Vertex$Instruction.comments_;
    }

    static /* synthetic */ boolean access$8700() {
        return alwaysUseFieldBuilders;
    }

    static /* synthetic */ UnknownFieldSet access$8800(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        return binExport$Flowgraph$Vertex$Instruction.unknownFields;
    }

    /* synthetic */ BinExport$Flowgraph$Vertex$Instruction(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BinExport$1 binExport$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

