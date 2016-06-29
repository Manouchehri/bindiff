/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Api$1;
import com.google.protobuf.Api$Builder;
import com.google.protobuf.ApiOrBuilder;
import com.google.protobuf.ApiProto;
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
import com.google.protobuf.Method;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Api
extends GeneratedMessage
implements ApiOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int METHODS_FIELD_NUMBER = 2;
    private List methods_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private List options_;
    public static final int VERSION_FIELD_NUMBER = 4;
    private volatile Object version_;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    private SourceContext sourceContext_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Api DEFAULT_INSTANCE = new Api();
    public static final Parser PARSER = new Api$1();

    private Api(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Api() {
        this.name_ = "";
        this.methods_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.version_ = "";
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Api(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        try {
            block20 : {
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
                                    this.methods_ = new ArrayList();
                                    n2 |= 2;
                                }
                                this.methods_.add(codedInputStream.readMessage(Method.PARSER, extensionRegistryLite));
                                continue block13;
                            }
                            case 26: {
                                if ((n2 & 4) != 4) {
                                    this.options_ = new ArrayList();
                                    n2 |= 4;
                                }
                                this.options_.add(codedInputStream.readMessage(Option.PARSER, extensionRegistryLite));
                                continue block13;
                            }
                            case 34: {
                                this.version_ = object = codedInputStream.readBytes();
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
                    if ((n2 & 2) != 2) break block20;
                }
                catch (InvalidProtocolBufferException var4_5) {
                    throw new RuntimeException(var4_5.setUnfinishedMessage(this));
                }
                catch (IOException var4_6) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this));
                }
                this.methods_ = Collections.unmodifiableList(this.methods_);
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
                this.methods_ = Collections.unmodifiableList(this.methods_);
            }
            if ((n2 & 4) == 4) {
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Api$Builder.class);
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
    public List getMethodsList() {
        return this.methods_;
    }

    @Override
    public List getMethodsOrBuilderList() {
        return this.methods_;
    }

    @Override
    public int getMethodsCount() {
        return this.methods_.size();
    }

    @Override
    public Method getMethods(int n2) {
        return (Method)this.methods_.get(n2);
    }

    @Override
    public MethodOrBuilder getMethodsOrBuilder(int n2) {
        return (MethodOrBuilder)this.methods_.get(n2);
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
    public String getVersion() {
        Object object = this.version_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.version_ = string;
        return string;
    }

    @Override
    public ByteString getVersionBytes() {
        ByteString byteString;
        Object object = this.version_;
        if (!(object instanceof String)) return (ByteString)object;
        this.version_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
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
        for (n2 = 0; n2 < this.methods_.size(); ++n2) {
            codedOutputStream.writeMessage(2, (MessageLite)this.methods_.get(n2));
        }
        for (n2 = 0; n2 < this.options_.size(); ++n2) {
            codedOutputStream.writeMessage(3, (MessageLite)this.options_.get(n2));
        }
        if (!this.getVersionBytes().isEmpty()) {
            codedOutputStream.writeBytes(4, this.getVersionBytes());
        }
        if (this.sourceContext_ == null) return;
        codedOutputStream.writeMessage(5, this.getSourceContext());
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
        for (n2 = 0; n2 < this.methods_.size(); n3 += CodedOutputStream.computeMessageSize((int)2, (MessageLite)((MessageLite)this.methods_.get((int)n2))), ++n2) {
        }
        for (n2 = 0; n2 < this.options_.size(); n3 += CodedOutputStream.computeMessageSize((int)3, (MessageLite)((MessageLite)this.options_.get((int)n2))), ++n2) {
        }
        if (!this.getVersionBytes().isEmpty()) {
            n3 += CodedOutputStream.computeBytesSize(4, this.getVersionBytes());
        }
        if (this.sourceContext_ != null) {
            n3 += CodedOutputStream.computeMessageSize(5, this.getSourceContext());
        }
        this.memoizedSerializedSize = n3;
        return n3;
    }

    public static Api parseFrom(ByteString byteString) {
        return (Api)PARSER.parseFrom(byteString);
    }

    public static Api parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Api)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Api parseFrom(byte[] arrby) {
        return (Api)PARSER.parseFrom(arrby);
    }

    public static Api parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Api)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Api parseFrom(InputStream inputStream) {
        return (Api)PARSER.parseFrom(inputStream);
    }

    public static Api parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Api parseDelimitedFrom(InputStream inputStream) {
        return (Api)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Api parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Api parseFrom(CodedInputStream codedInputStream) {
        return (Api)PARSER.parseFrom(codedInputStream);
    }

    public static Api parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Api$Builder newBuilderForType() {
        return Api.newBuilder();
    }

    public static Api$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Api$Builder newBuilder(Api api) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(api);
    }

    @Override
    public Api$Builder toBuilder() {
        Api$Builder api$Builder;
        if (this == DEFAULT_INSTANCE) {
            api$Builder = new Api$Builder(null);
            return api$Builder;
        }
        api$Builder = new Api$Builder(null).mergeFrom(this);
        return api$Builder;
    }

    @Override
    protected Api$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Api$Builder(generatedMessage$BuilderParent, null);
    }

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Api getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Api(GeneratedMessage$Builder generatedMessage$Builder, Api$1 api$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$302(Api api, Object object) {
        api.name_ = object;
        return api.name_;
    }

    static /* synthetic */ List access$402(Api api, List list) {
        api.methods_ = list;
        return api.methods_;
    }

    static /* synthetic */ List access$502(Api api, List list) {
        api.options_ = list;
        return api.options_;
    }

    static /* synthetic */ Object access$602(Api api, Object object) {
        api.version_ = object;
        return api.version_;
    }

    static /* synthetic */ SourceContext access$702(Api api, SourceContext sourceContext) {
        api.sourceContext_ = sourceContext;
        return api.sourceContext_;
    }

    static /* synthetic */ int access$802(Api api, int n2) {
        api.bitField0_ = n2;
        return api.bitField0_;
    }

    static /* synthetic */ Object access$300(Api api) {
        return api.name_;
    }

    static /* synthetic */ List access$400(Api api) {
        return api.methods_;
    }

    static /* synthetic */ List access$500(Api api) {
        return api.options_;
    }

    static /* synthetic */ Object access$600(Api api) {
        return api.version_;
    }

    /* synthetic */ Api(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Api$1 api$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

