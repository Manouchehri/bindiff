/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

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
import com.google.protobuf.Method$1;
import com.google.protobuf.Method$Builder;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Method
extends GeneratedMessage
implements MethodOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    private volatile Object requestTypeUrl_;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    private boolean requestStreaming_;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    private volatile Object responseTypeUrl_;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    private boolean responseStreaming_;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private List options_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Method DEFAULT_INSTANCE = new Method();
    public static final Parser PARSER = new Method$1();

    private Method(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Method() {
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.requestStreaming_ = false;
        this.responseTypeUrl_ = "";
        this.responseStreaming_ = false;
        this.options_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Method(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        try {
            block17 : {
                try {
                    boolean bl2 = false;
                    block14 : while (!bl2) {
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            ByteString byteString;
                            case 0: {
                                bl2 = true;
                                continue block14;
                            }
                            default: {
                                if (codedInputStream.skipField(n3)) continue block14;
                                bl2 = true;
                                continue block14;
                            }
                            case 10: {
                                this.name_ = byteString = codedInputStream.readBytes();
                                continue block14;
                            }
                            case 18: {
                                this.requestTypeUrl_ = byteString = codedInputStream.readBytes();
                                continue block14;
                            }
                            case 24: {
                                this.requestStreaming_ = codedInputStream.readBool();
                                continue block14;
                            }
                            case 34: {
                                this.responseTypeUrl_ = byteString = codedInputStream.readBytes();
                                continue block14;
                            }
                            case 40: {
                                this.responseStreaming_ = codedInputStream.readBool();
                                continue block14;
                            }
                            case 50: 
                        }
                        if ((n2 & 32) != 32) {
                            this.options_ = new ArrayList();
                            n2 |= 32;
                        }
                        this.options_.add(codedInputStream.readMessage(Option.PARSER, extensionRegistryLite));
                    }
                    Object var8_9 = null;
                    if ((n2 & 32) != 32) break block17;
                }
                catch (InvalidProtocolBufferException var4_5) {
                    throw new RuntimeException(var4_5.setUnfinishedMessage(this));
                }
                catch (IOException var4_6) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this));
                }
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var7_11) {
            Object var8_10 = null;
            if ((n2 & 32) == 32) {
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Method_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Method$Builder.class);
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
    public String getRequestTypeUrl() {
        Object object = this.requestTypeUrl_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.requestTypeUrl_ = string;
        return string;
    }

    @Override
    public ByteString getRequestTypeUrlBytes() {
        ByteString byteString;
        Object object = this.requestTypeUrl_;
        if (!(object instanceof String)) return (ByteString)object;
        this.requestTypeUrl_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    @Override
    public String getResponseTypeUrl() {
        Object object = this.responseTypeUrl_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.responseTypeUrl_ = string;
        return string;
    }

    @Override
    public ByteString getResponseTypeUrlBytes() {
        ByteString byteString;
        Object object = this.responseTypeUrl_;
        if (!(object instanceof String)) return (ByteString)object;
        this.responseTypeUrl_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean getResponseStreaming() {
        return this.responseStreaming_;
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
        if (!this.getNameBytes().isEmpty()) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
        }
        if (!this.getRequestTypeUrlBytes().isEmpty()) {
            codedOutputStream.writeBytes(2, this.getRequestTypeUrlBytes());
        }
        if (this.requestStreaming_) {
            codedOutputStream.writeBool(3, this.requestStreaming_);
        }
        if (!this.getResponseTypeUrlBytes().isEmpty()) {
            codedOutputStream.writeBytes(4, this.getResponseTypeUrlBytes());
        }
        if (this.responseStreaming_) {
            codedOutputStream.writeBool(5, this.responseStreaming_);
        }
        int n2 = 0;
        while (n2 < this.options_.size()) {
            codedOutputStream.writeMessage(6, (MessageLite)this.options_.get(n2));
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
        if (!this.getNameBytes().isEmpty()) {
            n2 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        if (!this.getRequestTypeUrlBytes().isEmpty()) {
            n2 += CodedOutputStream.computeBytesSize(2, this.getRequestTypeUrlBytes());
        }
        if (this.requestStreaming_) {
            n2 += CodedOutputStream.computeBoolSize(3, this.requestStreaming_);
        }
        if (!this.getResponseTypeUrlBytes().isEmpty()) {
            n2 += CodedOutputStream.computeBytesSize(4, this.getResponseTypeUrlBytes());
        }
        if (this.responseStreaming_) {
            n2 += CodedOutputStream.computeBoolSize(5, this.responseStreaming_);
        }
        int n3 = 0;
        do {
            if (n3 >= this.options_.size()) {
                this.memoizedSerializedSize = n2;
                return n2;
            }
            n2 += CodedOutputStream.computeMessageSize(6, (MessageLite)this.options_.get(n3));
            ++n3;
        } while (true);
    }

    public static Method parseFrom(ByteString byteString) {
        return (Method)PARSER.parseFrom(byteString);
    }

    public static Method parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Method)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Method parseFrom(byte[] arrby) {
        return (Method)PARSER.parseFrom(arrby);
    }

    public static Method parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Method)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Method parseFrom(InputStream inputStream) {
        return (Method)PARSER.parseFrom(inputStream);
    }

    public static Method parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Method parseDelimitedFrom(InputStream inputStream) {
        return (Method)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Method parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Method parseFrom(CodedInputStream codedInputStream) {
        return (Method)PARSER.parseFrom(codedInputStream);
    }

    public static Method parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Method$Builder newBuilderForType() {
        return Method.newBuilder();
    }

    public static Method$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Method$Builder newBuilder(Method method) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(method);
    }

    @Override
    public Method$Builder toBuilder() {
        Method$Builder method$Builder;
        if (this == DEFAULT_INSTANCE) {
            method$Builder = new Method$Builder(null);
            return method$Builder;
        }
        method$Builder = new Method$Builder(null).mergeFrom(this);
        return method$Builder;
    }

    @Override
    protected Method$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Method$Builder(generatedMessage$BuilderParent, null);
    }

    public static Method getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Method getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Method(GeneratedMessage$Builder generatedMessage$Builder, Method$1 method$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$302(Method method, Object object) {
        method.name_ = object;
        return method.name_;
    }

    static /* synthetic */ Object access$402(Method method, Object object) {
        method.requestTypeUrl_ = object;
        return method.requestTypeUrl_;
    }

    static /* synthetic */ boolean access$502(Method method, boolean bl2) {
        method.requestStreaming_ = bl2;
        return method.requestStreaming_;
    }

    static /* synthetic */ Object access$602(Method method, Object object) {
        method.responseTypeUrl_ = object;
        return method.responseTypeUrl_;
    }

    static /* synthetic */ boolean access$702(Method method, boolean bl2) {
        method.responseStreaming_ = bl2;
        return method.responseStreaming_;
    }

    static /* synthetic */ List access$802(Method method, List list) {
        method.options_ = list;
        return method.options_;
    }

    static /* synthetic */ int access$902(Method method, int n2) {
        method.bitField0_ = n2;
        return method.bitField0_;
    }

    static /* synthetic */ Object access$300(Method method) {
        return method.name_;
    }

    static /* synthetic */ Object access$400(Method method) {
        return method.requestTypeUrl_;
    }

    static /* synthetic */ Object access$600(Method method) {
        return method.responseTypeUrl_;
    }

    static /* synthetic */ List access$800(Method method) {
        return method.options_;
    }

    /* synthetic */ Method(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Method$1 method$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

