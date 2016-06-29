package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$SourceCodeInfo$Location extends GeneratedMessage implements DescriptorProtos$SourceCodeInfo$LocationOrBuilder
{
    private int bitField0_;
    public static final int PATH_FIELD_NUMBER = 1;
    private List path_;
    private int pathMemoizedSerializedSize;
    public static final int SPAN_FIELD_NUMBER = 2;
    private List span_;
    private int spanMemoizedSerializedSize;
    public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
    private volatile Object leadingComments_;
    public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
    private volatile Object trailingComments_;
    public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
    private LazyStringList leadingDetachedComments_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$SourceCodeInfo$Location DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$SourceCodeInfo$Location(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.pathMemoizedSerializedSize = -1;
        this.spanMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$SourceCodeInfo$Location() {
        this.pathMemoizedSerializedSize = -1;
        this.spanMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.path_ = Collections.emptyList();
        this.span_ = Collections.emptyList();
        this.leadingComments_ = "";
        this.trailingComments_ = "";
        this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$SourceCodeInfo$Location(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        if ((n & 0x1) != 0x1) {
                            this.path_ = new ArrayList();
                            n |= 0x1;
                        }
                        this.path_.add(codedInputStream.readInt32());
                        continue;
                    }
                    case 10: {
                        final int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                        if ((n & 0x1) != 0x1 && codedInputStream.getBytesUntilLimit() > 0) {
                            this.path_ = new ArrayList();
                            n |= 0x1;
                        }
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            this.path_.add(codedInputStream.readInt32());
                        }
                        codedInputStream.popLimit(pushLimit);
                        continue;
                    }
                    case 16: {
                        if ((n & 0x2) != 0x2) {
                            this.span_ = new ArrayList();
                            n |= 0x2;
                        }
                        this.span_.add(codedInputStream.readInt32());
                        continue;
                    }
                    case 18: {
                        final int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                        if ((n & 0x2) != 0x2 && codedInputStream.getBytesUntilLimit() > 0) {
                            this.span_ = new ArrayList();
                            n |= 0x2;
                        }
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            this.span_.add(codedInputStream.readInt32());
                        }
                        codedInputStream.popLimit(pushLimit2);
                        continue;
                    }
                    case 26: {
                        final ByteString bytes = codedInputStream.readBytes();
                        this.bitField0_ |= 0x1;
                        this.leadingComments_ = bytes;
                        continue;
                    }
                    case 34: {
                        final ByteString bytes2 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x2;
                        this.trailingComments_ = bytes2;
                        continue;
                    }
                    case 50: {
                        final ByteString bytes3 = codedInputStream.readBytes();
                        if ((n & 0x10) != 0x10) {
                            this.leadingDetachedComments_ = new LazyStringArrayList();
                            n |= 0x10;
                        }
                        this.leadingDetachedComments_.add(bytes3);
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
            if ((n & 0x1) == 0x1) {
                this.path_ = Collections.unmodifiableList((List<?>)this.path_);
            }
            if ((n & 0x2) == 0x2) {
                this.span_ = Collections.unmodifiableList((List<?>)this.span_);
            }
            if ((n & 0x10) == 0x10) {
                this.leadingDetachedComments_ = this.leadingDetachedComments_.getUnmodifiableView();
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo$Location.class, DescriptorProtos$SourceCodeInfo$Location$Builder.class);
    }
    
    public List getPathList() {
        return this.path_;
    }
    
    public int getPathCount() {
        return this.path_.size();
    }
    
    public int getPath(final int n) {
        return this.path_.get(n);
    }
    
    public List getSpanList() {
        return this.span_;
    }
    
    public int getSpanCount() {
        return this.span_.size();
    }
    
    public int getSpan(final int n) {
        return this.span_.get(n);
    }
    
    public boolean hasLeadingComments() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public String getLeadingComments() {
        final Object leadingComments_ = this.leadingComments_;
        if (leadingComments_ instanceof String) {
            return (String)leadingComments_;
        }
        final ByteString byteString = (ByteString)leadingComments_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.leadingComments_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getLeadingCommentsBytes() {
        final Object leadingComments_ = this.leadingComments_;
        if (leadingComments_ instanceof String) {
            return (ByteString)(this.leadingComments_ = ByteString.copyFromUtf8((String)leadingComments_));
        }
        return (ByteString)leadingComments_;
    }
    
    public boolean hasTrailingComments() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public String getTrailingComments() {
        final Object trailingComments_ = this.trailingComments_;
        if (trailingComments_ instanceof String) {
            return (String)trailingComments_;
        }
        final ByteString byteString = (ByteString)trailingComments_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.trailingComments_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getTrailingCommentsBytes() {
        final Object trailingComments_ = this.trailingComments_;
        if (trailingComments_ instanceof String) {
            return (ByteString)(this.trailingComments_ = ByteString.copyFromUtf8((String)trailingComments_));
        }
        return (ByteString)trailingComments_;
    }
    
    public ProtocolStringList getLeadingDetachedCommentsList() {
        return this.leadingDetachedComments_;
    }
    
    public int getLeadingDetachedCommentsCount() {
        return this.leadingDetachedComments_.size();
    }
    
    public String getLeadingDetachedComments(final int n) {
        return this.leadingDetachedComments_.get(n);
    }
    
    public ByteString getLeadingDetachedCommentsBytes(final int n) {
        return this.leadingDetachedComments_.getByteString(n);
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        this.getSerializedSize();
        if (this.getPathList().size() > 0) {
            codedOutputStream.writeRawVarint32(10);
            codedOutputStream.writeRawVarint32(this.pathMemoizedSerializedSize);
        }
        for (int i = 0; i < this.path_.size(); ++i) {
            codedOutputStream.writeInt32NoTag((int)this.path_.get(i));
        }
        if (this.getSpanList().size() > 0) {
            codedOutputStream.writeRawVarint32(18);
            codedOutputStream.writeRawVarint32(this.spanMemoizedSerializedSize);
        }
        for (int j = 0; j < this.span_.size(); ++j) {
            codedOutputStream.writeInt32NoTag((int)this.span_.get(j));
        }
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeBytes(3, this.getLeadingCommentsBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeBytes(4, this.getTrailingCommentsBytes());
        }
        for (int k = 0; k < this.leadingDetachedComments_.size(); ++k) {
            codedOutputStream.writeBytes(6, this.leadingDetachedComments_.getByteString(k));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        final int n = 0;
        int pathMemoizedSerializedSize = 0;
        for (int i = 0; i < this.path_.size(); ++i) {
            pathMemoizedSerializedSize += CodedOutputStream.computeInt32SizeNoTag((int)this.path_.get(i));
        }
        int n2 = n + pathMemoizedSerializedSize;
        if (!this.getPathList().isEmpty()) {
            n2 = ++n2 + CodedOutputStream.computeInt32SizeNoTag(pathMemoizedSerializedSize);
        }
        this.pathMemoizedSerializedSize = pathMemoizedSerializedSize;
        int spanMemoizedSerializedSize = 0;
        for (int j = 0; j < this.span_.size(); ++j) {
            spanMemoizedSerializedSize += CodedOutputStream.computeInt32SizeNoTag((int)this.span_.get(j));
        }
        int n3 = n2 + spanMemoizedSerializedSize;
        if (!this.getSpanList().isEmpty()) {
            n3 = ++n3 + CodedOutputStream.computeInt32SizeNoTag(spanMemoizedSerializedSize);
        }
        this.spanMemoizedSerializedSize = spanMemoizedSerializedSize;
        if ((this.bitField0_ & 0x1) == 0x1) {
            n3 += CodedOutputStream.computeBytesSize(3, this.getLeadingCommentsBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n3 += CodedOutputStream.computeBytesSize(4, this.getTrailingCommentsBytes());
        }
        int n4 = 0;
        for (int k = 0; k < this.leadingDetachedComments_.size(); ++k) {
            n4 += CodedOutputStream.computeBytesSizeNoTag(this.leadingDetachedComments_.getByteString(k));
        }
        return this.memoizedSerializedSize = n3 + n4 + 1 * this.getLeadingDetachedCommentsList().size() + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(final ByteString byteString) {
        return (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(final byte[] array) {
        return (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location$Builder newBuilder() {
        return DescriptorProtos$SourceCodeInfo$Location.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location$Builder newBuilder(final DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return DescriptorProtos$SourceCodeInfo$Location.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$SourceCodeInfo$Location);
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder toBuilder() {
        return (this == DescriptorProtos$SourceCodeInfo$Location.DEFAULT_INSTANCE) ? new DescriptorProtos$SourceCodeInfo$Location$Builder((DescriptorProtos$1)null) : new DescriptorProtos$SourceCodeInfo$Location$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$SourceCodeInfo$Location$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$SourceCodeInfo$Location$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$SourceCodeInfo$Location getDefaultInstance() {
        return DescriptorProtos$SourceCodeInfo$Location.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$SourceCodeInfo$Location.PARSER;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location getDefaultInstanceForType() {
        return DescriptorProtos$SourceCodeInfo$Location.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$SourceCodeInfo$Location();
        PARSER = new DescriptorProtos$SourceCodeInfo$Location$1();
    }
}
