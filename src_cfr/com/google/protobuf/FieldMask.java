/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldMask$1;
import com.google.protobuf.FieldMask$Builder;
import com.google.protobuf.FieldMaskOrBuilder;
import com.google.protobuf.FieldMaskProto;
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
import java.io.IOException;
import java.io.InputStream;

public final class FieldMask
extends GeneratedMessage
implements FieldMaskOrBuilder {
    public static final int PATHS_FIELD_NUMBER = 1;
    private LazyStringList paths_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final FieldMask DEFAULT_INSTANCE = new FieldMask();
    public static final Parser PARSER = new FieldMask$1();

    private FieldMask(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private FieldMask() {
        this.paths_ = LazyStringArrayList.EMPTY;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private FieldMask(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        try {
            block12 : {
                try {
                    boolean bl3 = false;
                    block9 : while (!bl3) {
                        int n2 = codedInputStream.readTag();
                        switch (n2) {
                            case 0: {
                                bl3 = true;
                                continue block9;
                            }
                            default: {
                                if (codedInputStream.skipField(n2)) continue block9;
                                bl3 = true;
                                continue block9;
                            }
                            case 10: 
                        }
                        ByteString byteString = codedInputStream.readBytes();
                        if (!(bl2 & true)) {
                            this.paths_ = new LazyStringArrayList();
                            bl2 |= true;
                        }
                        this.paths_.add(byteString);
                    }
                    Object var8_9 = null;
                    if (!(bl2 & true)) break block12;
                    this.paths_ = this.paths_.getUnmodifiableView();
                }
                catch (InvalidProtocolBufferException var4_5) {
                    throw new RuntimeException(var4_5.setUnfinishedMessage(this));
                }
                catch (IOException var4_6) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this));
                }
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var7_11) {
            Object var8_10 = null;
            if (bl2 & true) {
                this.paths_ = this.paths_.getUnmodifiableView();
            }
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, FieldMask$Builder.class);
    }

    @Override
    public ProtocolStringList getPathsList() {
        return this.paths_;
    }

    @Override
    public int getPathsCount() {
        return this.paths_.size();
    }

    @Override
    public String getPaths(int n2) {
        return (String)this.paths_.get(n2);
    }

    @Override
    public ByteString getPathsBytes(int n2) {
        return this.paths_.getByteString(n2);
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
        int n2 = 0;
        while (n2 < this.paths_.size()) {
            codedOutputStream.writeBytes(1, this.paths_.getByteString(n2));
            ++n2;
        }
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        int n3 = 0;
        int n4 = 0;
        do {
            if (n4 >= this.paths_.size()) {
                n2 += n3;
                this.memoizedSerializedSize = n2 += 1 * this.getPathsList().size();
                return n2;
            }
            n3 += CodedOutputStream.computeBytesSizeNoTag(this.paths_.getByteString(n4));
            ++n4;
        } while (true);
    }

    public static FieldMask parseFrom(ByteString byteString) {
        return (FieldMask)PARSER.parseFrom(byteString);
    }

    public static FieldMask parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static FieldMask parseFrom(byte[] arrby) {
        return (FieldMask)PARSER.parseFrom(arrby);
    }

    public static FieldMask parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static FieldMask parseFrom(InputStream inputStream) {
        return (FieldMask)PARSER.parseFrom(inputStream);
    }

    public static FieldMask parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream) {
        return (FieldMask)PARSER.parseDelimitedFrom(inputStream);
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static FieldMask parseFrom(CodedInputStream codedInputStream) {
        return (FieldMask)PARSER.parseFrom(codedInputStream);
    }

    public static FieldMask parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public FieldMask$Builder newBuilderForType() {
        return FieldMask.newBuilder();
    }

    public static FieldMask$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static FieldMask$Builder newBuilder(FieldMask fieldMask) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(fieldMask);
    }

    @Override
    public FieldMask$Builder toBuilder() {
        FieldMask$Builder fieldMask$Builder;
        if (this == DEFAULT_INSTANCE) {
            fieldMask$Builder = new FieldMask$Builder(null);
            return fieldMask$Builder;
        }
        fieldMask$Builder = new FieldMask$Builder(null).mergeFrom(this);
        return fieldMask$Builder;
    }

    @Override
    protected FieldMask$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new FieldMask$Builder(generatedMessage$BuilderParent, null);
    }

    public static FieldMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public FieldMask getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ FieldMask(GeneratedMessage$Builder generatedMessage$Builder, FieldMask$1 fieldMask$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ LazyStringList access$302(FieldMask fieldMask, LazyStringList lazyStringList) {
        fieldMask.paths_ = lazyStringList;
        return fieldMask.paths_;
    }

    static /* synthetic */ LazyStringList access$300(FieldMask fieldMask) {
        return fieldMask.paths_;
    }

    /* synthetic */ FieldMask(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, FieldMask$1 fieldMask$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

