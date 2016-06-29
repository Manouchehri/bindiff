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
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$InstructionOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$VertexOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BinExport$Flowgraph$Vertex
extends GeneratedMessage
implements BinExport$Flowgraph$VertexOrBuilder {
    private int bitField0_;
    public static final int PRIME_FIELD_NUMBER = 1;
    private long prime_;
    public static final int INSTRUCTIONS_FIELD_NUMBER = 2;
    private List instructions_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final BinExport$Flowgraph$Vertex DEFAULT_INSTANCE = new BinExport$Flowgraph$Vertex();
    public static final Parser PARSER = new BinExport$Flowgraph$Vertex$1();

    private BinExport$Flowgraph$Vertex(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private BinExport$Flowgraph$Vertex() {
        this.prime_ = 0;
        this.instructions_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private BinExport$Flowgraph$Vertex(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            boolean bl2 = false;
            block11 : while (!bl2) {
                int n3 = codedInputStream.readTag();
                switch (n3) {
                    case 0: {
                        bl2 = true;
                        continue block11;
                    }
                    default: {
                        if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block11;
                        bl2 = true;
                        continue block11;
                    }
                    case 8: {
                        this.bitField0_ |= 1;
                        this.prime_ = codedInputStream.readUInt64();
                        continue block11;
                    }
                    case 18: 
                }
                if ((n2 & 2) != 2) {
                    this.instructions_ = new ArrayList();
                    n2 |= 2;
                }
                this.instructions_.add(codedInputStream.readMessage(BinExport$Flowgraph$Vertex$Instruction.PARSER, extensionRegistryLite));
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
            if ((n2 & 2) == 2) {
                this.instructions_ = Collections.unmodifiableList(this.instructions_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$5900();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$6000().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex.class, BinExport$Flowgraph$Vertex$Builder.class);
    }

    @Override
    public boolean hasPrime() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public long getPrime() {
        return this.prime_;
    }

    @Override
    public List getInstructionsList() {
        return this.instructions_;
    }

    @Override
    public List getInstructionsOrBuilderList() {
        return this.instructions_;
    }

    @Override
    public int getInstructionsCount() {
        return this.instructions_.size();
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction getInstructions(int n2) {
        return (BinExport$Flowgraph$Vertex$Instruction)this.instructions_.get(n2);
    }

    @Override
    public BinExport$Flowgraph$Vertex$InstructionOrBuilder getInstructionsOrBuilder(int n2) {
        return (BinExport$Flowgraph$Vertex$InstructionOrBuilder)this.instructions_.get(n2);
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
        if (!this.hasPrime()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        int n2 = 0;
        do {
            if (n2 >= this.getInstructionsCount()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            if (!this.getInstructions(n2).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            ++n2;
        } while (true);
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeUInt64(1, this.prime_);
        }
        int n2 = 0;
        do {
            if (n2 >= this.instructions_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            }
            codedOutputStream.writeMessage(2, (MessageLite)this.instructions_.get(n2));
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
            n2 += CodedOutputStream.computeUInt64Size(1, this.prime_);
        }
        int n3 = 0;
        do {
            if (n3 >= this.instructions_.size()) {
                this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
                return n2;
            }
            n2 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.instructions_.get(n3));
            ++n3;
        } while (true);
    }

    public static BinExport$Flowgraph$Vertex parseFrom(ByteString byteString) {
        return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(byteString);
    }

    public static BinExport$Flowgraph$Vertex parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex parseFrom(byte[] arrby) {
        return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(arrby);
    }

    public static BinExport$Flowgraph$Vertex parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex parseFrom(InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(inputStream);
    }

    public static BinExport$Flowgraph$Vertex parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex parseDelimitedFrom(InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex)PARSER.parseDelimitedFrom(inputStream);
    }

    public static BinExport$Flowgraph$Vertex parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex parseFrom(CodedInputStream codedInputStream) {
        return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(codedInputStream);
    }

    public static BinExport$Flowgraph$Vertex parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public BinExport$Flowgraph$Vertex$Builder newBuilderForType() {
        return BinExport$Flowgraph$Vertex.newBuilder();
    }

    public static BinExport$Flowgraph$Vertex$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BinExport$Flowgraph$Vertex$Builder newBuilder(BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Flowgraph$Vertex);
    }

    @Override
    public BinExport$Flowgraph$Vertex$Builder toBuilder() {
        BinExport$Flowgraph$Vertex$Builder binExport$Flowgraph$Vertex$Builder;
        if (this == DEFAULT_INSTANCE) {
            binExport$Flowgraph$Vertex$Builder = new BinExport$Flowgraph$Vertex$Builder(null);
            return binExport$Flowgraph$Vertex$Builder;
        }
        binExport$Flowgraph$Vertex$Builder = new BinExport$Flowgraph$Vertex$Builder(null).mergeFrom(this);
        return binExport$Flowgraph$Vertex$Builder;
    }

    @Override
    protected BinExport$Flowgraph$Vertex$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Flowgraph$Vertex$Builder(generatedMessage$BuilderParent, null);
    }

    public static BinExport$Flowgraph$Vertex getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public BinExport$Flowgraph$Vertex getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ boolean access$9200() {
        return alwaysUseFieldBuilders;
    }

    /* synthetic */ BinExport$Flowgraph$Vertex(GeneratedMessage$Builder generatedMessage$Builder, BinExport$1 binExport$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ long access$9402(BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex, long l2) {
        binExport$Flowgraph$Vertex.prime_ = l2;
        return binExport$Flowgraph$Vertex.prime_;
    }

    static /* synthetic */ List access$9502(BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex, List list) {
        binExport$Flowgraph$Vertex.instructions_ = list;
        return binExport$Flowgraph$Vertex.instructions_;
    }

    static /* synthetic */ int access$9602(BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex, int n2) {
        binExport$Flowgraph$Vertex.bitField0_ = n2;
        return binExport$Flowgraph$Vertex.bitField0_;
    }

    static /* synthetic */ List access$9500(BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        return binExport$Flowgraph$Vertex.instructions_;
    }

    static /* synthetic */ boolean access$9700() {
        return alwaysUseFieldBuilders;
    }

    static /* synthetic */ UnknownFieldSet access$9800(BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        return binExport$Flowgraph$Vertex.unknownFields;
    }

    /* synthetic */ BinExport$Flowgraph$Vertex(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BinExport$1 binExport$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

