package com.google.protos.BinExport;

import java.io.*;
import com.google.protobuf.*;

public final class BinExport$Flowgraph$Vertex$Instruction$Comment extends GeneratedMessage implements BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder
{
    private int bitField0_;
    public static final int COMMENT_FIELD_NUMBER = 1;
    private volatile Object comment_;
    public static final int FLAGS_FIELD_NUMBER = 2;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final BinExport$Flowgraph$Vertex$Instruction$Comment DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private BinExport$Flowgraph$Vertex$Instruction$Comment(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private BinExport$Flowgraph$Vertex$Instruction$Comment() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.comment_ = "";
        this.flags_ = 0;
    }
    
    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private BinExport$Flowgraph$Vertex$Instruction$Comment(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
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
                    case 10: {
                        final ByteString bytes = codedInputStream.readBytes();
                        this.bitField0_ |= 0x1;
                        this.comment_ = bytes;
                        continue;
                    }
                    case 16: {
                        this.bitField0_ |= 0x2;
                        this.flags_ = codedInputStream.readUInt32();
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
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction$Comment.class, BinExport$Flowgraph$Vertex$Instruction$Comment$Builder.class);
    }
    
    @Override
    public boolean hasComment() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public String getComment() {
        final Object comment_ = this.comment_;
        if (comment_ instanceof String) {
            return (String)comment_;
        }
        final ByteString byteString = (ByteString)comment_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.comment_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    @Override
    public ByteString getCommentBytes() {
        final Object comment_ = this.comment_;
        if (comment_ instanceof String) {
            return (ByteString)(this.comment_ = ByteString.copyFromUtf8((String)comment_));
        }
        return (ByteString)comment_;
    }
    
    @Override
    public boolean hasFlags() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    @Override
    public int getFlags() {
        return this.flags_;
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
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeBytes(1, this.getCommentBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeUInt32(2, this.flags_);
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
            n += CodedOutputStream.computeBytesSize(1, this.getCommentBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeUInt32Size(2, this.flags_);
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(final ByteString byteString) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parseFrom(byteString);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(final byte[] array) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parseFrom(array);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(final InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parseFrom(inputStream);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseDelimitedFrom(final InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(final CodedInputStream codedInputStream) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parseFrom(codedInputStream);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilder() {
        return BinExport$Flowgraph$Vertex$Instruction$Comment.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilder(final BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        return BinExport$Flowgraph$Vertex$Instruction$Comment.DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Flowgraph$Vertex$Instruction$Comment);
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder toBuilder() {
        return (this == BinExport$Flowgraph$Vertex$Instruction$Comment.DEFAULT_INSTANCE) ? new BinExport$Flowgraph$Vertex$Instruction$Comment$Builder((BinExport$1)null) : new BinExport$Flowgraph$Vertex$Instruction$Comment$Builder((BinExport$1)null).mergeFrom(this);
    }
    
    @Override
    protected BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static BinExport$Flowgraph$Vertex$Instruction$Comment getDefaultInstance() {
        return BinExport$Flowgraph$Vertex$Instruction$Comment.DEFAULT_INSTANCE;
    }
    
    @Override
    public Parser getParserForType() {
        return BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment getDefaultInstanceForType() {
        return BinExport$Flowgraph$Vertex$Instruction$Comment.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new BinExport$Flowgraph$Vertex$Instruction$Comment();
        PARSER = new BinExport$Flowgraph$Vertex$Instruction$Comment$1();
    }
}
