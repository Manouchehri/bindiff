package com.google.protos.BinExport;

import java.util.*;
import java.io.*;
import com.google.protobuf.*;

public final class BinExport$Flowgraph$Vertex$Instruction extends GeneratedMessage implements BinExport$Flowgraph$Vertex$InstructionOrBuilder
{
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
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final BinExport$Flowgraph$Vertex$Instruction DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private BinExport$Flowgraph$Vertex$Instruction(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private BinExport$Flowgraph$Vertex$Instruction() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.address_ = 0L;
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
    
    private BinExport$Flowgraph$Vertex$Instruction(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 8: {
                        this.bitField0_ |= 0x1;
                        this.address_ = codedInputStream.readUInt64();
                        continue;
                    }
                    case 16: {
                        this.bitField0_ |= 0x2;
                        this.prime_ = codedInputStream.readUInt32();
                        continue;
                    }
                    case 24: {
                        this.bitField0_ |= 0x4;
                        this.stringReference_ = codedInputStream.readUInt32();
                        continue;
                    }
                    case 34: {
                        final ByteString bytes = codedInputStream.readBytes();
                        this.bitField0_ |= 0x8;
                        this.mnemonic_ = bytes;
                        continue;
                    }
                    case 42: {
                        final ByteString bytes2 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x10;
                        this.operands_ = bytes2;
                        continue;
                    }
                    case 50: {
                        this.bitField0_ |= 0x20;
                        this.rawBytes_ = codedInputStream.readBytes();
                        continue;
                    }
                    case 56: {
                        if ((n & 0x40) != 0x40) {
                            this.callTargets_ = new ArrayList();
                            n |= 0x40;
                        }
                        this.callTargets_.add(codedInputStream.readUInt64());
                        continue;
                    }
                    case 58: {
                        final int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                        if ((n & 0x40) != 0x40 && codedInputStream.getBytesUntilLimit() > 0) {
                            this.callTargets_ = new ArrayList();
                            n |= 0x40;
                        }
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            this.callTargets_.add(codedInputStream.readUInt64());
                        }
                        codedInputStream.popLimit(pushLimit);
                        continue;
                    }
                    case 66: {
                        if ((n & 0x80) != 0x80) {
                            this.comments_ = new ArrayList();
                            n |= 0x80;
                        }
                        this.comments_.add(codedInputStream.readMessage(BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER, extensionRegistryLite));
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
            if ((n & 0x40) == 0x40) {
                this.callTargets_ = Collections.unmodifiableList((List<?>)this.callTargets_);
            }
            if ((n & 0x80) == 0x80) {
                this.comments_ = Collections.unmodifiableList((List<?>)this.comments_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction.class, BinExport$Flowgraph$Vertex$Instruction$Builder.class);
    }
    
    @Override
    public boolean hasAddress() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public long getAddress() {
        return this.address_;
    }
    
    @Override
    public boolean hasPrime() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    @Override
    public int getPrime() {
        return this.prime_;
    }
    
    @Override
    public boolean hasStringReference() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    @Override
    public int getStringReference() {
        return this.stringReference_;
    }
    
    @Override
    public boolean hasMnemonic() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    @Override
    public String getMnemonic() {
        final Object mnemonic_ = this.mnemonic_;
        if (mnemonic_ instanceof String) {
            return (String)mnemonic_;
        }
        final ByteString byteString = (ByteString)mnemonic_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.mnemonic_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    @Override
    public ByteString getMnemonicBytes() {
        final Object mnemonic_ = this.mnemonic_;
        if (mnemonic_ instanceof String) {
            return (ByteString)(this.mnemonic_ = ByteString.copyFromUtf8((String)mnemonic_));
        }
        return (ByteString)mnemonic_;
    }
    
    @Override
    public boolean hasOperands() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    @Override
    public String getOperands() {
        final Object operands_ = this.operands_;
        if (operands_ instanceof String) {
            return (String)operands_;
        }
        final ByteString byteString = (ByteString)operands_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.operands_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    @Override
    public ByteString getOperandsBytes() {
        final Object operands_ = this.operands_;
        if (operands_ instanceof String) {
            return (ByteString)(this.operands_ = ByteString.copyFromUtf8((String)operands_));
        }
        return (ByteString)operands_;
    }
    
    @Override
    public boolean hasRawBytes() {
        return (this.bitField0_ & 0x20) == 0x20;
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
    public long getCallTargets(final int n) {
        return this.callTargets_.get(n);
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
    public BinExport$Flowgraph$Vertex$Instruction$Comment getComments(final int n) {
        return this.comments_.get(n);
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder getCommentsOrBuilder(final int n) {
        return this.comments_.get(n);
    }
    
    @Override
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
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
        for (int i = 0; i < this.getCommentsCount(); ++i) {
            if (!this.getComments(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    @Override
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeUInt64(1, this.address_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeUInt32(2, this.prime_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeUInt32(3, this.stringReference_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            codedOutputStream.writeBytes(4, this.getMnemonicBytes());
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            codedOutputStream.writeBytes(5, this.getOperandsBytes());
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            codedOutputStream.writeBytes(6, this.rawBytes_);
        }
        for (int i = 0; i < this.callTargets_.size(); ++i) {
            codedOutputStream.writeUInt64(7, (long)this.callTargets_.get(i));
        }
        for (int j = 0; j < this.comments_.size(); ++j) {
            codedOutputStream.writeMessage(8, (MessageLite)this.comments_.get(j));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
    
    @Override
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int n = 0;
        if ((this.bitField0_ & 0x1) == 0x1) {
            n += CodedOutputStream.computeUInt64Size(1, this.address_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeUInt32Size(2, this.prime_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeUInt32Size(3, this.stringReference_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            n += CodedOutputStream.computeBytesSize(4, this.getMnemonicBytes());
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            n += CodedOutputStream.computeBytesSize(5, this.getOperandsBytes());
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            n += CodedOutputStream.computeBytesSize(6, this.rawBytes_);
        }
        int n2 = 0;
        for (int i = 0; i < this.callTargets_.size(); ++i) {
            n2 += CodedOutputStream.computeUInt64SizeNoTag((long)this.callTargets_.get(i));
        }
        int n3 = n + n2 + 1 * this.getCallTargetsList().size();
        for (int j = 0; j < this.comments_.size(); ++j) {
            n3 += CodedOutputStream.computeMessageSize(8, (MessageLite)this.comments_.get(j));
        }
        return this.memoizedSerializedSize = n3 + this.unknownFields.getSerializedSize();
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(final ByteString byteString) {
        return (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parseFrom(byteString);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(final byte[] array) {
        return (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parseFrom(array);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(final InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parseFrom(inputStream);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction parseDelimitedFrom(final InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(final CodedInputStream codedInputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parseFrom(codedInputStream);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Builder newBuilder() {
        return BinExport$Flowgraph$Vertex$Instruction.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Builder newBuilder(final BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        return BinExport$Flowgraph$Vertex$Instruction.DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Flowgraph$Vertex$Instruction);
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Builder toBuilder() {
        return (this == BinExport$Flowgraph$Vertex$Instruction.DEFAULT_INSTANCE) ? new BinExport$Flowgraph$Vertex$Instruction$Builder((BinExport$1)null) : new BinExport$Flowgraph$Vertex$Instruction$Builder((BinExport$1)null).mergeFrom(this);
    }
    
    @Override
    protected BinExport$Flowgraph$Vertex$Instruction$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Flowgraph$Vertex$Instruction$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction getDefaultInstance() {
        return BinExport$Flowgraph$Vertex$Instruction.DEFAULT_INSTANCE;
    }
    
    @Override
    public Parser getParserForType() {
        return BinExport$Flowgraph$Vertex$Instruction.PARSER;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction getDefaultInstanceForType() {
        return BinExport$Flowgraph$Vertex$Instruction.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new BinExport$Flowgraph$Vertex$Instruction();
        PARSER = new BinExport$Flowgraph$Vertex$Instruction$1();
    }
}
