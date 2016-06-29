/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

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
import com.google.protobuf.ListValue$1;
import com.google.protobuf.ListValue$Builder;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Value;
import com.google.protobuf.ValueOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ListValue
extends GeneratedMessage
implements ListValueOrBuilder {
    public static final int VALUES_FIELD_NUMBER = 1;
    private List values_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final ListValue DEFAULT_INSTANCE = new ListValue();
    public static final Parser PARSER = new ListValue$1();

    private ListValue(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private ListValue() {
        this.values_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private ListValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                        if (!(bl2 & true)) {
                            this.values_ = new ArrayList();
                            bl2 |= true;
                        }
                        this.values_.add(codedInputStream.readMessage(Value.PARSER, extensionRegistryLite));
                    }
                    Object var7_8 = null;
                    if (!(bl2 & true)) break block12;
                }
                catch (InvalidProtocolBufferException var4_5) {
                    throw new RuntimeException(var4_5.setUnfinishedMessage(this));
                }
                catch (IOException var4_6) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this));
                }
                this.values_ = Collections.unmodifiableList(this.values_);
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var6_10) {
            Object var7_9 = null;
            if (bl2 & true) {
                this.values_ = Collections.unmodifiableList(this.values_);
            }
            this.makeExtensionsImmutable();
            throw var6_10;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, ListValue$Builder.class);
    }

    @Override
    public List getValuesList() {
        return this.values_;
    }

    @Override
    public List getValuesOrBuilderList() {
        return this.values_;
    }

    @Override
    public int getValuesCount() {
        return this.values_.size();
    }

    @Override
    public Value getValues(int n2) {
        return (Value)this.values_.get(n2);
    }

    @Override
    public ValueOrBuilder getValuesOrBuilder(int n2) {
        return (ValueOrBuilder)this.values_.get(n2);
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
        while (n2 < this.values_.size()) {
            codedOutputStream.writeMessage(1, (MessageLite)this.values_.get(n2));
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
        do {
            if (n3 >= this.values_.size()) {
                this.memoizedSerializedSize = n2;
                return n2;
            }
            n2 += CodedOutputStream.computeMessageSize(1, (MessageLite)this.values_.get(n3));
            ++n3;
        } while (true);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ListValue)) {
            return super.equals(object);
        }
        ListValue listValue = (ListValue)object;
        boolean bl2 = true;
        if (!bl2) return false;
        if (!this.getValuesList().equals(listValue.getValuesList())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int n2 = 41;
        n2 = 19 * n2 + this.getDescriptorForType().hashCode();
        if (this.getValuesCount() > 0) {
            n2 = 37 * n2 + 1;
            n2 = 53 * n2 + this.getValuesList().hashCode();
        }
        this.memoizedHashCode = n2 = 29 * n2 + this.unknownFields.hashCode();
        return n2;
    }

    public static ListValue parseFrom(ByteString byteString) {
        return (ListValue)PARSER.parseFrom(byteString);
    }

    public static ListValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ListValue parseFrom(byte[] arrby) {
        return (ListValue)PARSER.parseFrom(arrby);
    }

    public static ListValue parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static ListValue parseFrom(InputStream inputStream) {
        return (ListValue)PARSER.parseFrom(inputStream);
    }

    public static ListValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream) {
        return (ListValue)PARSER.parseDelimitedFrom(inputStream);
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static ListValue parseFrom(CodedInputStream codedInputStream) {
        return (ListValue)PARSER.parseFrom(codedInputStream);
    }

    public static ListValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public ListValue$Builder newBuilderForType() {
        return ListValue.newBuilder();
    }

    public static ListValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ListValue$Builder newBuilder(ListValue listValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(listValue);
    }

    @Override
    public ListValue$Builder toBuilder() {
        ListValue$Builder listValue$Builder;
        if (this == DEFAULT_INSTANCE) {
            listValue$Builder = new ListValue$Builder(null);
            return listValue$Builder;
        }
        listValue$Builder = new ListValue$Builder(null).mergeFrom(this);
        return listValue$Builder;
    }

    @Override
    protected ListValue$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new ListValue$Builder(generatedMessage$BuilderParent, null);
    }

    public static ListValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public ListValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ ListValue(GeneratedMessage$Builder generatedMessage$Builder, ListValue$1 listValue$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ List access$302(ListValue listValue, List list) {
        listValue.values_ = list;
        return listValue.values_;
    }

    static /* synthetic */ List access$300(ListValue listValue) {
        return listValue.values_;
    }

    /* synthetic */ ListValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ListValue$1 listValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

