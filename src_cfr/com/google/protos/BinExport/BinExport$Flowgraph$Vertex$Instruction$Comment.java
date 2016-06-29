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
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class BinExport$Flowgraph$Vertex$Instruction$Comment
extends GeneratedMessage
implements BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder {
    private int bitField0_;
    public static final int COMMENT_FIELD_NUMBER = 1;
    private volatile Object comment_;
    public static final int FLAGS_FIELD_NUMBER = 2;
    private int flags_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final BinExport$Flowgraph$Vertex$Instruction$Comment DEFAULT_INSTANCE = new BinExport$Flowgraph$Vertex$Instruction$Comment();
    public static final Parser PARSER = new BinExport$Flowgraph$Vertex$Instruction$Comment$1();

    private BinExport$Flowgraph$Vertex$Instruction$Comment(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private BinExport$Flowgraph$Vertex$Instruction$Comment() {
        this.comment_ = "";
        this.flags_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private BinExport$Flowgraph$Vertex$Instruction$Comment(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            boolean bl3 = false;
            block11 : while (!bl3) {
                int n2 = codedInputStream.readTag();
                switch (n2) {
                    case 0: {
                        bl3 = true;
                        continue block11;
                    }
                    default: {
                        if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block11;
                        bl3 = true;
                        continue block11;
                    }
                    case 10: {
                        ByteString byteString = codedInputStream.readBytes();
                        this.bitField0_ |= 1;
                        this.comment_ = byteString;
                        continue block11;
                    }
                    case 16: 
                }
                this.bitField0_ |= 2;
                this.flags_ = codedInputStream.readUInt32();
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
        return BinExport.access$6300();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$6400().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction$Comment.class, BinExport$Flowgraph$Vertex$Instruction$Comment$Builder.class);
    }

    @Override
    public boolean hasComment() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getComment() {
        Object object = this.comment_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.comment_ = string;
        return string;
    }

    @Override
    public ByteString getCommentBytes() {
        ByteString byteString;
        Object object = this.comment_;
        if (!(object instanceof String)) return (ByteString)object;
        this.comment_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasFlags() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public int getFlags() {
        return this.flags_;
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
        if (!this.hasComment()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (!this.hasFlags()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(1, this.getCommentBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeUInt32(2, this.flags_);
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
            n2 += CodedOutputStream.computeBytesSize(1, this.getCommentBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeUInt32Size(2, this.flags_);
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(ByteString byteString) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(byteString);
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(byte[] arrby) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(arrby);
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(inputStream);
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseDelimitedFrom(InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseDelimitedFrom(inputStream);
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(CodedInputStream codedInputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(codedInputStream);
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilderForType() {
        return BinExport$Flowgraph$Vertex$Instruction$Comment.newBuilder();
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilder(BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Flowgraph$Vertex$Instruction$Comment);
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder toBuilder() {
        BinExport$Flowgraph$Vertex$Instruction$Comment$Builder binExport$Flowgraph$Vertex$Instruction$Comment$Builder;
        if (this == DEFAULT_INSTANCE) {
            binExport$Flowgraph$Vertex$Instruction$Comment$Builder = new BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(null);
            return binExport$Flowgraph$Vertex$Instruction$Comment$Builder;
        }
        binExport$Flowgraph$Vertex$Instruction$Comment$Builder = new BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(null).mergeFrom(this);
        return binExport$Flowgraph$Vertex$Instruction$Comment$Builder;
    }

    @Override
    protected BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(generatedMessage$BuilderParent, null);
    }

    public static BinExport$Flowgraph$Vertex$Instruction$Comment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ boolean access$6700() {
        return alwaysUseFieldBuilders;
    }

    /* synthetic */ BinExport$Flowgraph$Vertex$Instruction$Comment(GeneratedMessage$Builder generatedMessage$Builder, BinExport$1 binExport$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$6902(BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment, Object object) {
        binExport$Flowgraph$Vertex$Instruction$Comment.comment_ = object;
        return binExport$Flowgraph$Vertex$Instruction$Comment.comment_;
    }

    static /* synthetic */ int access$7002(BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment, int n2) {
        binExport$Flowgraph$Vertex$Instruction$Comment.flags_ = n2;
        return binExport$Flowgraph$Vertex$Instruction$Comment.flags_;
    }

    static /* synthetic */ int access$7102(BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment, int n2) {
        binExport$Flowgraph$Vertex$Instruction$Comment.bitField0_ = n2;
        return binExport$Flowgraph$Vertex$Instruction$Comment.bitField0_;
    }

    static /* synthetic */ Object access$6900(BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        return binExport$Flowgraph$Vertex$Instruction$Comment.comment_;
    }

    static /* synthetic */ UnknownFieldSet access$7200(BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        return binExport$Flowgraph$Vertex$Instruction$Comment.unknownFields;
    }

    /* synthetic */ BinExport$Flowgraph$Vertex$Instruction$Comment(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BinExport$1 binExport$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

