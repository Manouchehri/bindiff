/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$SourceCodeInfo$Location
extends GeneratedMessage
implements DescriptorProtos$SourceCodeInfo$LocationOrBuilder {
    private int bitField0_;
    public static final int PATH_FIELD_NUMBER = 1;
    private List path_;
    private int pathMemoizedSerializedSize = -1;
    public static final int SPAN_FIELD_NUMBER = 2;
    private List span_;
    private int spanMemoizedSerializedSize = -1;
    public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
    private volatile Object leadingComments_;
    public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
    private volatile Object trailingComments_;
    public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
    private LazyStringList leadingDetachedComments_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$SourceCodeInfo$Location DEFAULT_INSTANCE = new DescriptorProtos$SourceCodeInfo$Location();
    public static final Parser PARSER = new DescriptorProtos$SourceCodeInfo$Location$1();

    private DescriptorProtos$SourceCodeInfo$Location(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$SourceCodeInfo$Location() {
        this.path_ = Collections.emptyList();
        this.span_ = Collections.emptyList();
        this.leadingComments_ = "";
        this.trailingComments_ = "";
        this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$SourceCodeInfo$Location(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            block28 : {
                try {
                    boolean bl2 = false;
                    block15 : while (!bl2) {
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            int n4;
                            int n5;
                            case 0: {
                                bl2 = true;
                                continue block15;
                            }
                            default: {
                                if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block15;
                                bl2 = true;
                                continue block15;
                            }
                            case 8: {
                                if (!(n2 & true)) {
                                    this.path_ = new ArrayList();
                                    n2 |= 1;
                                }
                                this.path_.add(codedInputStream.readInt32());
                                continue block15;
                            }
                            case 10: {
                                n4 = codedInputStream.readRawVarint32();
                                n5 = codedInputStream.pushLimit(n4);
                                if ((n2 & 1) != 1 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.path_ = new ArrayList();
                                    n2 |= 1;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.path_.add(codedInputStream.readInt32());
                                }
                                codedInputStream.popLimit(n5);
                                continue block15;
                            }
                            case 16: {
                                if ((n2 & 2) != 2) {
                                    this.span_ = new ArrayList();
                                    n2 |= 2;
                                }
                                this.span_.add(codedInputStream.readInt32());
                                continue block15;
                            }
                            case 18: {
                                n4 = codedInputStream.readRawVarint32();
                                n5 = codedInputStream.pushLimit(n4);
                                if ((n2 & 2) != 2 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.span_ = new ArrayList();
                                    n2 |= 2;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.span_.add(codedInputStream.readInt32());
                                }
                                codedInputStream.popLimit(n5);
                                continue block15;
                            }
                            case 26: {
                                ByteString byteString = codedInputStream.readBytes();
                                this.bitField0_ |= 1;
                                this.leadingComments_ = byteString;
                                continue block15;
                            }
                            case 34: {
                                ByteString byteString = codedInputStream.readBytes();
                                this.bitField0_ |= 2;
                                this.trailingComments_ = byteString;
                                continue block15;
                            }
                            case 50: 
                        }
                        ByteString byteString = codedInputStream.readBytes();
                        if ((n2 & 16) != 16) {
                            this.leadingDetachedComments_ = new LazyStringArrayList();
                            n2 |= 16;
                        }
                        this.leadingDetachedComments_.add(byteString);
                    }
                    Object var10_14 = null;
                    if (!(n2 & true)) break block28;
                }
                catch (InvalidProtocolBufferException var5_6) {
                    throw new RuntimeException(var5_6.setUnfinishedMessage(this));
                }
                catch (IOException var5_7) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
                }
                this.path_ = Collections.unmodifiableList(this.path_);
            }
            if ((n2 & 2) == 2) {
                this.span_ = Collections.unmodifiableList(this.span_);
            }
            if ((n2 & 16) == 16) {
                this.leadingDetachedComments_ = this.leadingDetachedComments_.getUnmodifiableView();
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var9_16) {
            Object var10_15 = null;
            if (n2 & true) {
                this.path_ = Collections.unmodifiableList(this.path_);
            }
            if ((n2 & 2) == 2) {
                this.span_ = Collections.unmodifiableList(this.span_);
            }
            if ((n2 & 16) == 16) {
                this.leadingDetachedComments_ = this.leadingDetachedComments_.getUnmodifiableView();
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var9_16;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$23800();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$23900().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo$Location.class, DescriptorProtos$SourceCodeInfo$Location$Builder.class);
    }

    @Override
    public List getPathList() {
        return this.path_;
    }

    @Override
    public int getPathCount() {
        return this.path_.size();
    }

    @Override
    public int getPath(int n2) {
        return (Integer)this.path_.get(n2);
    }

    @Override
    public List getSpanList() {
        return this.span_;
    }

    @Override
    public int getSpanCount() {
        return this.span_.size();
    }

    @Override
    public int getSpan(int n2) {
        return (Integer)this.span_.get(n2);
    }

    @Override
    public boolean hasLeadingComments() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getLeadingComments() {
        Object object = this.leadingComments_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.leadingComments_ = string;
        return string;
    }

    @Override
    public ByteString getLeadingCommentsBytes() {
        ByteString byteString;
        Object object = this.leadingComments_;
        if (!(object instanceof String)) return (ByteString)object;
        this.leadingComments_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasTrailingComments() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public String getTrailingComments() {
        Object object = this.trailingComments_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.trailingComments_ = string;
        return string;
    }

    @Override
    public ByteString getTrailingCommentsBytes() {
        ByteString byteString;
        Object object = this.trailingComments_;
        if (!(object instanceof String)) return (ByteString)object;
        this.trailingComments_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public ProtocolStringList getLeadingDetachedCommentsList() {
        return this.leadingDetachedComments_;
    }

    @Override
    public int getLeadingDetachedCommentsCount() {
        return this.leadingDetachedComments_.size();
    }

    @Override
    public String getLeadingDetachedComments(int n2) {
        return (String)this.leadingDetachedComments_.get(n2);
    }

    @Override
    public ByteString getLeadingDetachedCommentsBytes(int n2) {
        return this.leadingDetachedComments_.getByteString(n2);
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
        int n2;
        this.getSerializedSize();
        if (this.getPathList().size() > 0) {
            codedOutputStream.writeRawVarint32(10);
            codedOutputStream.writeRawVarint32(this.pathMemoizedSerializedSize);
        }
        for (n2 = 0; n2 < this.path_.size(); ++n2) {
            codedOutputStream.writeInt32NoTag((Integer)this.path_.get(n2));
        }
        if (this.getSpanList().size() > 0) {
            codedOutputStream.writeRawVarint32(18);
            codedOutputStream.writeRawVarint32(this.spanMemoizedSerializedSize);
        }
        for (n2 = 0; n2 < this.span_.size(); ++n2) {
            codedOutputStream.writeInt32NoTag((Integer)this.span_.get(n2));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(3, this.getLeadingCommentsBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(4, this.getTrailingCommentsBytes());
        }
        n2 = 0;
        do {
            if (n2 >= this.leadingDetachedComments_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            }
            codedOutputStream.writeBytes(6, this.leadingDetachedComments_.getByteString(n2));
            ++n2;
        } while (true);
    }

    @Override
    public int getSerializedSize() {
        int n2;
        int n3 = this.memoizedSerializedSize;
        if (n3 != -1) {
            return n3;
        }
        n3 = 0;
        int n4 = 0;
        for (n2 = 0; n2 < this.path_.size(); n4 += CodedOutputStream.computeInt32SizeNoTag((int)((Integer)this.path_.get((int)n2)).intValue()), ++n2) {
        }
        n3 += n4;
        if (!this.getPathList().isEmpty()) {
            ++n3;
            n3 += CodedOutputStream.computeInt32SizeNoTag(n4);
        }
        this.pathMemoizedSerializedSize = n4;
        n4 = 0;
        for (n2 = 0; n2 < this.span_.size(); n4 += CodedOutputStream.computeInt32SizeNoTag((int)((Integer)this.span_.get((int)n2)).intValue()), ++n2) {
        }
        n3 += n4;
        if (!this.getSpanList().isEmpty()) {
            ++n3;
            n3 += CodedOutputStream.computeInt32SizeNoTag(n4);
        }
        this.spanMemoizedSerializedSize = n4;
        if ((this.bitField0_ & 1) == 1) {
            n3 += CodedOutputStream.computeBytesSize(3, this.getLeadingCommentsBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            n3 += CodedOutputStream.computeBytesSize(4, this.getTrailingCommentsBytes());
        }
        n4 = 0;
        n2 = 0;
        do {
            if (n2 >= this.leadingDetachedComments_.size()) {
                n3 += n4;
                n3 += 1 * this.getLeadingDetachedCommentsList().size();
                this.memoizedSerializedSize = n3 += this.unknownFields.getSerializedSize();
                return n3;
            }
            n4 += CodedOutputStream.computeBytesSizeNoTag(this.leadingDetachedComments_.getByteString(n2));
            ++n2;
        } while (true);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(ByteString byteString) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(byte[] arrby) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$SourceCodeInfo$Location parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location$Builder newBuilderForType() {
        return DescriptorProtos$SourceCodeInfo$Location.newBuilder();
    }

    public static DescriptorProtos$SourceCodeInfo$Location$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$SourceCodeInfo$Location$Builder newBuilder(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$SourceCodeInfo$Location);
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location$Builder toBuilder() {
        DescriptorProtos$SourceCodeInfo$Location$Builder descriptorProtos$SourceCodeInfo$Location$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$SourceCodeInfo$Location$Builder = new DescriptorProtos$SourceCodeInfo$Location$Builder(null);
            return descriptorProtos$SourceCodeInfo$Location$Builder;
        }
        descriptorProtos$SourceCodeInfo$Location$Builder = new DescriptorProtos$SourceCodeInfo$Location$Builder(null).mergeFrom(this);
        return descriptorProtos$SourceCodeInfo$Location$Builder;
    }

    @Override
    protected DescriptorProtos$SourceCodeInfo$Location$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$SourceCodeInfo$Location$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$SourceCodeInfo$Location getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$SourceCodeInfo$Location(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ List access$24302(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, List list) {
        descriptorProtos$SourceCodeInfo$Location.path_ = list;
        return descriptorProtos$SourceCodeInfo$Location.path_;
    }

    static /* synthetic */ List access$24402(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, List list) {
        descriptorProtos$SourceCodeInfo$Location.span_ = list;
        return descriptorProtos$SourceCodeInfo$Location.span_;
    }

    static /* synthetic */ Object access$24502(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, Object object) {
        descriptorProtos$SourceCodeInfo$Location.leadingComments_ = object;
        return descriptorProtos$SourceCodeInfo$Location.leadingComments_;
    }

    static /* synthetic */ Object access$24602(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, Object object) {
        descriptorProtos$SourceCodeInfo$Location.trailingComments_ = object;
        return descriptorProtos$SourceCodeInfo$Location.trailingComments_;
    }

    static /* synthetic */ LazyStringList access$24702(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, LazyStringList lazyStringList) {
        descriptorProtos$SourceCodeInfo$Location.leadingDetachedComments_ = lazyStringList;
        return descriptorProtos$SourceCodeInfo$Location.leadingDetachedComments_;
    }

    static /* synthetic */ int access$24802(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location, int n2) {
        descriptorProtos$SourceCodeInfo$Location.bitField0_ = n2;
        return descriptorProtos$SourceCodeInfo$Location.bitField0_;
    }

    static /* synthetic */ List access$24300(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return descriptorProtos$SourceCodeInfo$Location.path_;
    }

    static /* synthetic */ List access$24400(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return descriptorProtos$SourceCodeInfo$Location.span_;
    }

    static /* synthetic */ Object access$24500(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return descriptorProtos$SourceCodeInfo$Location.leadingComments_;
    }

    static /* synthetic */ Object access$24600(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return descriptorProtos$SourceCodeInfo$Location.trailingComments_;
    }

    static /* synthetic */ LazyStringList access$24700(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        return descriptorProtos$SourceCodeInfo$Location.leadingDetachedComments_;
    }

    /* synthetic */ DescriptorProtos$SourceCodeInfo$Location(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

