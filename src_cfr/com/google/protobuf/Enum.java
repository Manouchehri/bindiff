/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Enum$1;
import com.google.protobuf.Enum$Builder;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValueOrBuilder;
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
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Enum
extends GeneratedMessage
implements EnumOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    private List enumvalue_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private List options_;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    private SourceContext sourceContext_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Enum DEFAULT_INSTANCE = new Enum();
    public static final Parser PARSER = new Enum$1();

    private Enum(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Enum() {
        this.name_ = "";
        this.enumvalue_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Enum(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        try {
            block19 : {
                try {
                    boolean bl2 = false;
                    block12 : while (!bl2) {
                        Object object;
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            case 0: {
                                bl2 = true;
                                continue block12;
                            }
                            default: {
                                if (codedInputStream.skipField(n3)) continue block12;
                                bl2 = true;
                                continue block12;
                            }
                            case 10: {
                                this.name_ = object = codedInputStream.readBytes();
                                continue block12;
                            }
                            case 18: {
                                if ((n2 & 2) != 2) {
                                    this.enumvalue_ = new ArrayList();
                                    n2 |= 2;
                                }
                                this.enumvalue_.add(codedInputStream.readMessage(EnumValue.PARSER, extensionRegistryLite));
                                continue block12;
                            }
                            case 26: {
                                if ((n2 & 4) != 4) {
                                    this.options_ = new ArrayList();
                                    n2 |= 4;
                                }
                                this.options_.add(codedInputStream.readMessage(Option.PARSER, extensionRegistryLite));
                                continue block12;
                            }
                            case 34: 
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
                    if ((n2 & 2) != 2) break block19;
                }
                catch (InvalidProtocolBufferException var4_5) {
                    throw new RuntimeException(var4_5.setUnfinishedMessage(this));
                }
                catch (IOException var4_6) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this));
                }
                this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
            }
            if ((n2 & 4) == 4) {
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var7_11) {
            Object var8_10 = null;
            if ((n2 & 2) == 2) {
                this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
            }
            if ((n2 & 4) == 4) {
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Enum$Builder.class);
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
    public List getEnumvalueList() {
        return this.enumvalue_;
    }

    @Override
    public List getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    @Override
    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    @Override
    public EnumValue getEnumvalue(int n2) {
        return (EnumValue)this.enumvalue_.get(n2);
    }

    @Override
    public EnumValueOrBuilder getEnumvalueOrBuilder(int n2) {
        return (EnumValueOrBuilder)this.enumvalue_.get(n2);
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
        for (n2 = 0; n2 < this.enumvalue_.size(); ++n2) {
            codedOutputStream.writeMessage(2, (MessageLite)this.enumvalue_.get(n2));
        }
        n2 = 0;
        do {
            if (n2 >= this.options_.size()) {
                if (this.sourceContext_ == null) return;
                codedOutputStream.writeMessage(4, this.getSourceContext());
                return;
            }
            codedOutputStream.writeMessage(3, (MessageLite)this.options_.get(n2));
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
        for (n2 = 0; n2 < this.enumvalue_.size(); n3 += CodedOutputStream.computeMessageSize((int)2, (MessageLite)((MessageLite)this.enumvalue_.get((int)n2))), ++n2) {
        }
        for (n2 = 0; n2 < this.options_.size(); n3 += CodedOutputStream.computeMessageSize((int)3, (MessageLite)((MessageLite)this.options_.get((int)n2))), ++n2) {
        }
        if (this.sourceContext_ != null) {
            n3 += CodedOutputStream.computeMessageSize(4, this.getSourceContext());
        }
        this.memoizedSerializedSize = n3;
        return n3;
    }

    public static Enum parseFrom(ByteString byteString) {
        return (Enum)PARSER.parseFrom(byteString);
    }

    public static Enum parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Enum parseFrom(byte[] arrby) {
        return (Enum)PARSER.parseFrom(arrby);
    }

    public static Enum parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Enum parseFrom(InputStream inputStream) {
        return (Enum)PARSER.parseFrom(inputStream);
    }

    public static Enum parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Enum parseDelimitedFrom(InputStream inputStream) {
        return (Enum)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Enum parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Enum parseFrom(CodedInputStream codedInputStream) {
        return (Enum)PARSER.parseFrom(codedInputStream);
    }

    public static Enum parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Enum$Builder newBuilderForType() {
        return Enum.newBuilder();
    }

    public static Enum$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Enum$Builder newBuilder(Enum enum_) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(enum_);
    }

    @Override
    public Enum$Builder toBuilder() {
        Enum$Builder enum$Builder;
        if (this == DEFAULT_INSTANCE) {
            enum$Builder = new Enum$Builder(null);
            return enum$Builder;
        }
        enum$Builder = new Enum$Builder(null).mergeFrom(this);
        return enum$Builder;
    }

    @Override
    protected Enum$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Enum$Builder(generatedMessage$BuilderParent, null);
    }

    public static Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Enum getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Enum(GeneratedMessage$Builder generatedMessage$Builder, Enum$1 enum$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$302(Enum enum_, Object object) {
        enum_.name_ = object;
        return enum_.name_;
    }

    static /* synthetic */ List access$402(Enum enum_, List list) {
        enum_.enumvalue_ = list;
        return enum_.enumvalue_;
    }

    static /* synthetic */ List access$502(Enum enum_, List list) {
        enum_.options_ = list;
        return enum_.options_;
    }

    static /* synthetic */ SourceContext access$602(Enum enum_, SourceContext sourceContext) {
        enum_.sourceContext_ = sourceContext;
        return enum_.sourceContext_;
    }

    static /* synthetic */ int access$702(Enum enum_, int n2) {
        enum_.bitField0_ = n2;
        return enum_.bitField0_;
    }

    static /* synthetic */ Object access$300(Enum enum_) {
        return enum_.name_;
    }

    static /* synthetic */ List access$400(Enum enum_) {
        return enum_.enumvalue_;
    }

    static /* synthetic */ List access$500(Enum enum_) {
        return enum_.options_;
    }

    /* synthetic */ Enum(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Enum$1 enum$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

