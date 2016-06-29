/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Field;
import com.google.protobuf.FieldOrBuilder;
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
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Type$1;
import com.google.protobuf.Type$Builder;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Type
extends GeneratedMessage
implements TypeOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int FIELDS_FIELD_NUMBER = 2;
    private List fields_;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    private LazyStringList oneofs_;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private List options_;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    private SourceContext sourceContext_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Type DEFAULT_INSTANCE = new Type();
    public static final Parser PARSER = new Type$1();

    private Type(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Type() {
        this.name_ = "";
        this.fields_ = Collections.emptyList();
        this.oneofs_ = LazyStringArrayList.EMPTY;
        this.options_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Type(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        try {
            block23 : {
                try {
                    boolean bl2 = false;
                    block13 : while (!bl2) {
                        Object object;
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            case 0: {
                                bl2 = true;
                                continue block13;
                            }
                            default: {
                                if (codedInputStream.skipField(n3)) continue block13;
                                bl2 = true;
                                continue block13;
                            }
                            case 10: {
                                this.name_ = object = codedInputStream.readBytes();
                                continue block13;
                            }
                            case 18: {
                                if ((n2 & 2) != 2) {
                                    this.fields_ = new ArrayList();
                                    n2 |= 2;
                                }
                                this.fields_.add(codedInputStream.readMessage(Field.PARSER, extensionRegistryLite));
                                continue block13;
                            }
                            case 26: {
                                object = codedInputStream.readBytes();
                                if ((n2 & 4) != 4) {
                                    this.oneofs_ = new LazyStringArrayList();
                                    n2 |= 4;
                                }
                                this.oneofs_.add((ByteString)object);
                                continue block13;
                            }
                            case 34: {
                                if ((n2 & 8) != 8) {
                                    this.options_ = new ArrayList();
                                    n2 |= 8;
                                }
                                this.options_.add(codedInputStream.readMessage(Option.PARSER, extensionRegistryLite));
                                continue block13;
                            }
                            case 42: 
                        }
                        object = null;
                        if (this.sourceContext_ != null) {
                            object = this.sourceContext_.toBuilder();
                        }
                        this.sourceContext_ = (SourceContext)codedInputStream.readMessage(SourceContext.PARSER, extensionRegistryLite);
                        if (object == null) continue;
                        object.mergeFrom(this.sourceContext_);
                        this.sourceContext_ = object.buildPartial();
                    }
                    Object var8_9 = null;
                    if ((n2 & 2) != 2) break block23;
                }
                catch (InvalidProtocolBufferException var4_5) {
                    throw new RuntimeException(var4_5.setUnfinishedMessage(this));
                }
                catch (IOException var4_6) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this));
                }
                this.fields_ = Collections.unmodifiableList(this.fields_);
            }
            if ((n2 & 4) == 4) {
                this.oneofs_ = this.oneofs_.getUnmodifiableView();
            }
            if ((n2 & 8) == 8) {
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var7_11) {
            Object var8_10 = null;
            if ((n2 & 2) == 2) {
                this.fields_ = Collections.unmodifiableList(this.fields_);
            }
            if ((n2 & 4) == 4) {
                this.oneofs_ = this.oneofs_.getUnmodifiableView();
            }
            if ((n2 & 8) == 8) {
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Type$Builder.class);
    }

    @Override
    public String getName() {
        Object object = this.name_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.name_ = string;
        return string;
    }

    @Override
    public ByteString getNameBytes() {
        ByteString byteString;
        Object object = this.name_;
        if (!(object instanceof String)) return (ByteString)object;
        this.name_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public List getFieldsList() {
        return this.fields_;
    }

    @Override
    public List getFieldsOrBuilderList() {
        return this.fields_;
    }

    @Override
    public int getFieldsCount() {
        return this.fields_.size();
    }

    @Override
    public Field getFields(int n2) {
        return (Field)this.fields_.get(n2);
    }

    @Override
    public FieldOrBuilder getFieldsOrBuilder(int n2) {
        return (FieldOrBuilder)this.fields_.get(n2);
    }

    @Override
    public ProtocolStringList getOneofsList() {
        return this.oneofs_;
    }

    @Override
    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    @Override
    public String getOneofs(int n2) {
        return (String)this.oneofs_.get(n2);
    }

    @Override
    public ByteString getOneofsBytes(int n2) {
        return this.oneofs_.getByteString(n2);
    }

    @Override
    public List getOptionsList() {
        return this.options_;
    }

    @Override
    public List getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override
    public Option getOptions(int n2) {
        return (Option)this.options_.get(n2);
    }

    @Override
    public OptionOrBuilder getOptionsOrBuilder(int n2) {
        return (OptionOrBuilder)this.options_.get(n2);
    }

    @Override
    public boolean hasSourceContext() {
        if (this.sourceContext_ == null) return false;
        return true;
    }

    @Override
    public SourceContext getSourceContext() {
        SourceContext sourceContext;
        if (this.sourceContext_ == null) {
            sourceContext = SourceContext.getDefaultInstance();
            return sourceContext;
        }
        sourceContext = this.sourceContext_;
        return sourceContext;
    }

    @Override
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        return this.getSourceContext();
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
        if (!this.getNameBytes().isEmpty()) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
        }
        for (n2 = 0; n2 < this.fields_.size(); ++n2) {
            codedOutputStream.writeMessage(2, (MessageLite)this.fields_.get(n2));
        }
        for (n2 = 0; n2 < this.oneofs_.size(); ++n2) {
            codedOutputStream.writeBytes(3, this.oneofs_.getByteString(n2));
        }
        n2 = 0;
        do {
            if (n2 >= this.options_.size()) {
                if (this.sourceContext_ == null) return;
                codedOutputStream.writeMessage(5, this.getSourceContext());
                return;
            }
            codedOutputStream.writeMessage(4, (MessageLite)this.options_.get(n2));
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
        if (!this.getNameBytes().isEmpty()) {
            n3 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        for (n2 = 0; n2 < this.fields_.size(); n3 += CodedOutputStream.computeMessageSize((int)2, (MessageLite)((MessageLite)this.fields_.get((int)n2))), ++n2) {
        }
        n2 = 0;
        for (int i2 = 0; i2 < this.oneofs_.size(); n2 += CodedOutputStream.computeBytesSizeNoTag((ByteString)this.oneofs_.getByteString((int)i2)), ++i2) {
        }
        n3 += n2;
        n3 += 1 * this.getOneofsList().size();
        for (n2 = 0; n2 < this.options_.size(); n3 += CodedOutputStream.computeMessageSize((int)4, (MessageLite)((MessageLite)this.options_.get((int)n2))), ++n2) {
        }
        if (this.sourceContext_ != null) {
            n3 += CodedOutputStream.computeMessageSize(5, this.getSourceContext());
        }
        this.memoizedSerializedSize = n3;
        return n3;
    }

    public static Type parseFrom(ByteString byteString) {
        return (Type)PARSER.parseFrom(byteString);
    }

    public static Type parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Type)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Type parseFrom(byte[] arrby) {
        return (Type)PARSER.parseFrom(arrby);
    }

    public static Type parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Type)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Type parseFrom(InputStream inputStream) {
        return (Type)PARSER.parseFrom(inputStream);
    }

    public static Type parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Type parseDelimitedFrom(InputStream inputStream) {
        return (Type)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Type parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(CodedInputStream codedInputStream) {
        return (Type)PARSER.parseFrom(codedInputStream);
    }

    public static Type parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Type$Builder newBuilderForType() {
        return Type.newBuilder();
    }

    public static Type$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Type$Builder newBuilder(Type type) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(type);
    }

    @Override
    public Type$Builder toBuilder() {
        Type$Builder type$Builder;
        if (this == DEFAULT_INSTANCE) {
            type$Builder = new Type$Builder(null);
            return type$Builder;
        }
        type$Builder = new Type$Builder(null).mergeFrom(this);
        return type$Builder;
    }

    @Override
    protected Type$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Type$Builder(generatedMessage$BuilderParent, null);
    }

    public static Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Type getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Type(GeneratedMessage$Builder generatedMessage$Builder, Type$1 type$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$302(Type type, Object object) {
        type.name_ = object;
        return type.name_;
    }

    static /* synthetic */ List access$402(Type type, List list) {
        type.fields_ = list;
        return type.fields_;
    }

    static /* synthetic */ LazyStringList access$502(Type type, LazyStringList lazyStringList) {
        type.oneofs_ = lazyStringList;
        return type.oneofs_;
    }

    static /* synthetic */ List access$602(Type type, List list) {
        type.options_ = list;
        return type.options_;
    }

    static /* synthetic */ SourceContext access$702(Type type, SourceContext sourceContext) {
        type.sourceContext_ = sourceContext;
        return type.sourceContext_;
    }

    static /* synthetic */ int access$802(Type type, int n2) {
        type.bitField0_ = n2;
        return type.bitField0_;
    }

    static /* synthetic */ Object access$300(Type type) {
        return type.name_;
    }

    static /* synthetic */ List access$400(Type type) {
        return type.fields_;
    }

    static /* synthetic */ LazyStringList access$500(Type type) {
        return type.oneofs_;
    }

    static /* synthetic */ List access$600(Type type) {
        return type.options_;
    }

    /* synthetic */ Type(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Type$1 type$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

