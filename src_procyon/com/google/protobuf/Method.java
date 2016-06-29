package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Method extends GeneratedMessage implements MethodOrBuilder
{
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
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Method DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Method(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Method() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.requestStreaming_ = false;
        this.responseTypeUrl_ = "";
        this.responseStreaming_ = false;
        this.options_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Method(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n = 0;
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
                        if (!codedInputStream.skipField(tag)) {
                            i = 1;
                            continue;
                        }
                        continue;
                    }
                    case 10: {
                        this.name_ = codedInputStream.readBytes();
                        continue;
                    }
                    case 18: {
                        this.requestTypeUrl_ = codedInputStream.readBytes();
                        continue;
                    }
                    case 24: {
                        this.requestStreaming_ = codedInputStream.readBool();
                        continue;
                    }
                    case 34: {
                        this.responseTypeUrl_ = codedInputStream.readBytes();
                        continue;
                    }
                    case 40: {
                        this.responseStreaming_ = codedInputStream.readBool();
                        continue;
                    }
                    case 50: {
                        if ((n & 0x20) != 0x20) {
                            this.options_ = new ArrayList();
                            n |= 0x20;
                        }
                        this.options_.add(codedInputStream.readMessage(Option.PARSER, extensionRegistryLite));
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
            if ((n & 0x20) == 0x20) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
            }
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Method_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Method$Builder.class);
    }
    
    public String getName() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (String)name_;
        }
        final ByteString byteString = (ByteString)name_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.name_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getNameBytes() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (ByteString)(this.name_ = ByteString.copyFromUtf8((String)name_));
        }
        return (ByteString)name_;
    }
    
    public String getRequestTypeUrl() {
        final Object requestTypeUrl_ = this.requestTypeUrl_;
        if (requestTypeUrl_ instanceof String) {
            return (String)requestTypeUrl_;
        }
        final ByteString byteString = (ByteString)requestTypeUrl_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.requestTypeUrl_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getRequestTypeUrlBytes() {
        final Object requestTypeUrl_ = this.requestTypeUrl_;
        if (requestTypeUrl_ instanceof String) {
            return (ByteString)(this.requestTypeUrl_ = ByteString.copyFromUtf8((String)requestTypeUrl_));
        }
        return (ByteString)requestTypeUrl_;
    }
    
    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }
    
    public String getResponseTypeUrl() {
        final Object responseTypeUrl_ = this.responseTypeUrl_;
        if (responseTypeUrl_ instanceof String) {
            return (String)responseTypeUrl_;
        }
        final ByteString byteString = (ByteString)responseTypeUrl_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.responseTypeUrl_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getResponseTypeUrlBytes() {
        final Object responseTypeUrl_ = this.responseTypeUrl_;
        if (responseTypeUrl_ instanceof String) {
            return (ByteString)(this.responseTypeUrl_ = ByteString.copyFromUtf8((String)responseTypeUrl_));
        }
        return (ByteString)responseTypeUrl_;
    }
    
    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }
    
    public List getOptionsList() {
        return this.options_;
    }
    
    public List getOptionsOrBuilderList() {
        return this.options_;
    }
    
    public int getOptionsCount() {
        return this.options_.size();
    }
    
    public Option getOptions(final int n) {
        return this.options_.get(n);
    }
    
    public OptionOrBuilder getOptionsOrBuilder(final int n) {
        return this.options_.get(n);
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
        for (int i = 0; i < this.options_.size(); ++i) {
            codedOutputStream.writeMessage(6, (MessageLite)this.options_.get(i));
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (!this.getNameBytes().isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        if (!this.getRequestTypeUrlBytes().isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(2, this.getRequestTypeUrlBytes());
        }
        if (this.requestStreaming_) {
            memoizedSerializedSize2 += CodedOutputStream.computeBoolSize(3, this.requestStreaming_);
        }
        if (!this.getResponseTypeUrlBytes().isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(4, this.getResponseTypeUrlBytes());
        }
        if (this.responseStreaming_) {
            memoizedSerializedSize2 += CodedOutputStream.computeBoolSize(5, this.responseStreaming_);
        }
        for (int i = 0; i < this.options_.size(); ++i) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(6, (MessageLite)this.options_.get(i));
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static Method parseFrom(final ByteString byteString) {
        return (Method)Method.PARSER.parseFrom(byteString);
    }
    
    public static Method parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Method)Method.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Method parseFrom(final byte[] array) {
        return (Method)Method.PARSER.parseFrom(array);
    }
    
    public static Method parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Method)Method.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Method parseFrom(final InputStream inputStream) {
        return (Method)Method.PARSER.parseFrom(inputStream);
    }
    
    public static Method parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Method)Method.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Method parseDelimitedFrom(final InputStream inputStream) {
        return (Method)Method.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Method parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Method)Method.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Method parseFrom(final CodedInputStream codedInputStream) {
        return (Method)Method.PARSER.parseFrom(codedInputStream);
    }
    
    public static Method parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Method)Method.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Method$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Method$Builder newBuilder() {
        return Method.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Method$Builder newBuilder(final Method method) {
        return Method.DEFAULT_INSTANCE.toBuilder().mergeFrom(method);
    }
    
    public Method$Builder toBuilder() {
        return (this == Method.DEFAULT_INSTANCE) ? new Method$Builder((Method$1)null) : new Method$Builder((Method$1)null).mergeFrom(this);
    }
    
    protected Method$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Method$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Method getDefaultInstance() {
        return Method.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Method.PARSER;
    }
    
    public Method getDefaultInstanceForType() {
        return Method.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Method();
        PARSER = new Method$1();
    }
}
