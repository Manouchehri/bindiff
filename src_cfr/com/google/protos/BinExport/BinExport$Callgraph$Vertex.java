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
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$1;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$Builder;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$FunctionType;
import com.google.protos.BinExport.BinExport$Callgraph$VertexOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class BinExport$Callgraph$Vertex
extends GeneratedMessage
implements BinExport$Callgraph$VertexOrBuilder {
    private int bitField0_;
    public static final int ADDRESS_FIELD_NUMBER = 1;
    private long address_;
    public static final int PRIME_FIELD_NUMBER = 2;
    private long prime_;
    public static final int FUNCTION_TYPE_FIELD_NUMBER = 3;
    private int functionType_;
    public static final int HAS_REAL_NAME_FIELD_NUMBER = 4;
    private boolean hasRealName_;
    public static final int MANGLED_NAME_FIELD_NUMBER = 5;
    private volatile Object mangledName_;
    public static final int DEMANGLED_NAME_FIELD_NUMBER = 6;
    private volatile Object demangledName_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final BinExport$Callgraph$Vertex DEFAULT_INSTANCE = new BinExport$Callgraph$Vertex();
    public static final Parser PARSER = new BinExport$Callgraph$Vertex$1();

    private BinExport$Callgraph$Vertex(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private BinExport$Callgraph$Vertex() {
        this.address_ = 0;
        this.prime_ = 0;
        this.functionType_ = 0;
        this.hasRealName_ = false;
        this.mangledName_ = "";
        this.demangledName_ = "";
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private BinExport$Callgraph$Vertex(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            boolean bl3 = false;
            block15 : while (!bl3) {
                int n2 = codedInputStream.readTag();
                switch (n2) {
                    case 0: {
                        bl3 = true;
                        continue block15;
                    }
                    default: {
                        if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block15;
                        bl3 = true;
                        continue block15;
                    }
                    case 8: {
                        this.bitField0_ |= 1;
                        this.address_ = codedInputStream.readUInt64();
                        continue block15;
                    }
                    case 16: {
                        this.bitField0_ |= 2;
                        this.prime_ = codedInputStream.readUInt64();
                        continue block15;
                    }
                    case 24: {
                        int n3 = codedInputStream.readEnum();
                        BinExport$Callgraph$Vertex$FunctionType binExport$Callgraph$Vertex$FunctionType = BinExport$Callgraph$Vertex$FunctionType.valueOf(n3);
                        if (binExport$Callgraph$Vertex$FunctionType == null) {
                            unknownFieldSet$Builder.mergeVarintField(3, n3);
                            continue block15;
                        }
                        this.bitField0_ |= 4;
                        this.functionType_ = n3;
                        continue block15;
                    }
                    case 32: {
                        this.bitField0_ |= 8;
                        this.hasRealName_ = codedInputStream.readBool();
                        continue block15;
                    }
                    case 42: {
                        ByteString byteString = codedInputStream.readBytes();
                        this.bitField0_ |= 16;
                        this.mangledName_ = byteString;
                        continue block15;
                    }
                    case 50: 
                }
                ByteString byteString = codedInputStream.readBytes();
                this.bitField0_ |= 32;
                this.demangledName_ = byteString;
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
        return BinExport.access$2000();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$2100().ensureFieldAccessorsInitialized(BinExport$Callgraph$Vertex.class, BinExport$Callgraph$Vertex$Builder.class);
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
    public long getPrime() {
        return this.prime_;
    }

    @Override
    public boolean hasFunctionType() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public BinExport$Callgraph$Vertex$FunctionType getFunctionType() {
        BinExport$Callgraph$Vertex$FunctionType binExport$Callgraph$Vertex$FunctionType;
        BinExport$Callgraph$Vertex$FunctionType binExport$Callgraph$Vertex$FunctionType2 = BinExport$Callgraph$Vertex$FunctionType.valueOf(this.functionType_);
        if (binExport$Callgraph$Vertex$FunctionType2 == null) {
            binExport$Callgraph$Vertex$FunctionType = BinExport$Callgraph$Vertex$FunctionType.NORMAL;
            return binExport$Callgraph$Vertex$FunctionType;
        }
        binExport$Callgraph$Vertex$FunctionType = binExport$Callgraph$Vertex$FunctionType2;
        return binExport$Callgraph$Vertex$FunctionType;
    }

    @Override
    public boolean hasHasRealName() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public boolean getHasRealName() {
        return this.hasRealName_;
    }

    @Override
    public boolean hasMangledName() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public String getMangledName() {
        Object object = this.mangledName_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.mangledName_ = string;
        return string;
    }

    @Override
    public ByteString getMangledNameBytes() {
        ByteString byteString;
        Object object = this.mangledName_;
        if (!(object instanceof String)) return (ByteString)object;
        this.mangledName_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasDemangledName() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public String getDemangledName() {
        Object object = this.demangledName_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.demangledName_ = string;
        return string;
    }

    @Override
    public ByteString getDemangledNameBytes() {
        ByteString byteString;
        Object object = this.demangledName_;
        if (!(object instanceof String)) return (ByteString)object;
        this.demangledName_ = byteString = ByteString.copyFromUtf8((String)object);
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
        if (!this.hasAddress()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (!this.hasPrime()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeUInt64(1, this.address_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeUInt64(2, this.prime_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.functionType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeBool(4, this.hasRealName_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeBytes(5, this.getMangledNameBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeBytes(6, this.getDemangledNameBytes());
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
            n2 += CodedOutputStream.computeUInt64Size(1, this.address_);
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeUInt64Size(2, this.prime_);
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeEnumSize(3, this.functionType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            n2 += CodedOutputStream.computeBoolSize(4, this.hasRealName_);
        }
        if ((this.bitField0_ & 16) == 16) {
            n2 += CodedOutputStream.computeBytesSize(5, this.getMangledNameBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            n2 += CodedOutputStream.computeBytesSize(6, this.getDemangledNameBytes());
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static BinExport$Callgraph$Vertex parseFrom(ByteString byteString) {
        return (BinExport$Callgraph$Vertex)PARSER.parseFrom(byteString);
    }

    public static BinExport$Callgraph$Vertex parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Vertex)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BinExport$Callgraph$Vertex parseFrom(byte[] arrby) {
        return (BinExport$Callgraph$Vertex)PARSER.parseFrom(arrby);
    }

    public static BinExport$Callgraph$Vertex parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Vertex)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static BinExport$Callgraph$Vertex parseFrom(InputStream inputStream) {
        return (BinExport$Callgraph$Vertex)PARSER.parseFrom(inputStream);
    }

    public static BinExport$Callgraph$Vertex parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Vertex)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Callgraph$Vertex parseDelimitedFrom(InputStream inputStream) {
        return (BinExport$Callgraph$Vertex)PARSER.parseDelimitedFrom(inputStream);
    }

    public static BinExport$Callgraph$Vertex parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Vertex)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Callgraph$Vertex parseFrom(CodedInputStream codedInputStream) {
        return (BinExport$Callgraph$Vertex)PARSER.parseFrom(codedInputStream);
    }

    public static BinExport$Callgraph$Vertex parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Vertex)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public BinExport$Callgraph$Vertex$Builder newBuilderForType() {
        return BinExport$Callgraph$Vertex.newBuilder();
    }

    public static BinExport$Callgraph$Vertex$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BinExport$Callgraph$Vertex$Builder newBuilder(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Callgraph$Vertex);
    }

    @Override
    public BinExport$Callgraph$Vertex$Builder toBuilder() {
        BinExport$Callgraph$Vertex$Builder binExport$Callgraph$Vertex$Builder;
        if (this == DEFAULT_INSTANCE) {
            binExport$Callgraph$Vertex$Builder = new BinExport$Callgraph$Vertex$Builder(null);
            return binExport$Callgraph$Vertex$Builder;
        }
        binExport$Callgraph$Vertex$Builder = new BinExport$Callgraph$Vertex$Builder(null).mergeFrom(this);
        return binExport$Callgraph$Vertex$Builder;
    }

    @Override
    protected BinExport$Callgraph$Vertex$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Callgraph$Vertex$Builder(generatedMessage$BuilderParent, null);
    }

    public static BinExport$Callgraph$Vertex getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public BinExport$Callgraph$Vertex getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ boolean access$2400() {
        return alwaysUseFieldBuilders;
    }

    /* synthetic */ BinExport$Callgraph$Vertex(GeneratedMessage$Builder generatedMessage$Builder, BinExport$1 binExport$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ long access$2602(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex, long l2) {
        binExport$Callgraph$Vertex.address_ = l2;
        return binExport$Callgraph$Vertex.address_;
    }

    static /* synthetic */ long access$2702(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex, long l2) {
        binExport$Callgraph$Vertex.prime_ = l2;
        return binExport$Callgraph$Vertex.prime_;
    }

    static /* synthetic */ int access$2802(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex, int n2) {
        binExport$Callgraph$Vertex.functionType_ = n2;
        return binExport$Callgraph$Vertex.functionType_;
    }

    static /* synthetic */ boolean access$2902(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex, boolean bl2) {
        binExport$Callgraph$Vertex.hasRealName_ = bl2;
        return binExport$Callgraph$Vertex.hasRealName_;
    }

    static /* synthetic */ Object access$3002(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex, Object object) {
        binExport$Callgraph$Vertex.mangledName_ = object;
        return binExport$Callgraph$Vertex.mangledName_;
    }

    static /* synthetic */ Object access$3102(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex, Object object) {
        binExport$Callgraph$Vertex.demangledName_ = object;
        return binExport$Callgraph$Vertex.demangledName_;
    }

    static /* synthetic */ int access$3202(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex, int n2) {
        binExport$Callgraph$Vertex.bitField0_ = n2;
        return binExport$Callgraph$Vertex.bitField0_;
    }

    static /* synthetic */ Object access$3000(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        return binExport$Callgraph$Vertex.mangledName_;
    }

    static /* synthetic */ Object access$3100(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        return binExport$Callgraph$Vertex.demangledName_;
    }

    static /* synthetic */ UnknownFieldSet access$3300(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        return binExport$Callgraph$Vertex.unknownFields;
    }

    /* synthetic */ BinExport$Callgraph$Vertex(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BinExport$1 binExport$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

