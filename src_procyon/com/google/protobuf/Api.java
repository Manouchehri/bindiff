package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Api extends GeneratedMessage implements ApiOrBuilder
{
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
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Api DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Api(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Api() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.methods_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.version_ = "";
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Api(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        if ((n & 0x2) != 0x2) {
                            this.methods_ = new ArrayList();
                            n |= 0x2;
                        }
                        this.methods_.add(codedInputStream.readMessage(Method.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 26: {
                        if ((n & 0x4) != 0x4) {
                            this.options_ = new ArrayList();
                            n |= 0x4;
                        }
                        this.options_.add(codedInputStream.readMessage(Option.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 34: {
                        this.version_ = codedInputStream.readBytes();
                        continue;
                    }
                    case 42: {
                        SourceContext$Builder builder = null;
                        if (this.sourceContext_ != null) {
                            builder = this.sourceContext_.toBuilder();
                        }
                        this.sourceContext_ = (SourceContext)codedInputStream.readMessage(SourceContext.PARSER, extensionRegistryLite);
                        if (builder != null) {
                            builder.mergeFrom(this.sourceContext_);
                            this.sourceContext_ = builder.buildPartial();
                            continue;
                        }
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
            if ((n & 0x2) == 0x2) {
                this.methods_ = Collections.unmodifiableList((List<?>)this.methods_);
            }
            if ((n & 0x4) == 0x4) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
            }
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Api$Builder.class);
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
    
    public List getMethodsList() {
        return this.methods_;
    }
    
    public List getMethodsOrBuilderList() {
        return this.methods_;
    }
    
    public int getMethodsCount() {
        return this.methods_.size();
    }
    
    public Method getMethods(final int n) {
        return this.methods_.get(n);
    }
    
    public MethodOrBuilder getMethodsOrBuilder(final int n) {
        return this.methods_.get(n);
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
    
    public String getVersion() {
        final Object version_ = this.version_;
        if (version_ instanceof String) {
            return (String)version_;
        }
        final ByteString byteString = (ByteString)version_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.version_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getVersionBytes() {
        final Object version_ = this.version_;
        if (version_ instanceof String) {
            return (ByteString)(this.version_ = ByteString.copyFromUtf8((String)version_));
        }
        return (ByteString)version_;
    }
    
    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }
    
    public SourceContext getSourceContext() {
        return (this.sourceContext_ == null) ? SourceContext.getDefaultInstance() : this.sourceContext_;
    }
    
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        return this.getSourceContext();
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
        for (int i = 0; i < this.methods_.size(); ++i) {
            codedOutputStream.writeMessage(2, (MessageLite)this.methods_.get(i));
        }
        for (int j = 0; j < this.options_.size(); ++j) {
            codedOutputStream.writeMessage(3, (MessageLite)this.options_.get(j));
        }
        if (!this.getVersionBytes().isEmpty()) {
            codedOutputStream.writeBytes(4, this.getVersionBytes());
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.writeMessage(5, this.getSourceContext());
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
        for (int i = 0; i < this.methods_.size(); ++i) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.methods_.get(i));
        }
        for (int j = 0; j < this.options_.size(); ++j) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_.get(j));
        }
        if (!this.getVersionBytes().isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(4, this.getVersionBytes());
        }
        if (this.sourceContext_ != null) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(5, this.getSourceContext());
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static Api parseFrom(final ByteString byteString) {
        return (Api)Api.PARSER.parseFrom(byteString);
    }
    
    public static Api parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Api)Api.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Api parseFrom(final byte[] array) {
        return (Api)Api.PARSER.parseFrom(array);
    }
    
    public static Api parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Api)Api.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Api parseFrom(final InputStream inputStream) {
        return (Api)Api.PARSER.parseFrom(inputStream);
    }
    
    public static Api parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Api)Api.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Api parseDelimitedFrom(final InputStream inputStream) {
        return (Api)Api.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Api parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Api)Api.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Api parseFrom(final CodedInputStream codedInputStream) {
        return (Api)Api.PARSER.parseFrom(codedInputStream);
    }
    
    public static Api parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Api)Api.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Api$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Api$Builder newBuilder() {
        return Api.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Api$Builder newBuilder(final Api api) {
        return Api.DEFAULT_INSTANCE.toBuilder().mergeFrom(api);
    }
    
    public Api$Builder toBuilder() {
        return (this == Api.DEFAULT_INSTANCE) ? new Api$Builder((Api$1)null) : new Api$Builder((Api$1)null).mergeFrom(this);
    }
    
    protected Api$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Api$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Api getDefaultInstance() {
        return Api.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Api.PARSER;
    }
    
    public Api getDefaultInstanceForType() {
        return Api.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Api();
        PARSER = new Api$1();
    }
}
