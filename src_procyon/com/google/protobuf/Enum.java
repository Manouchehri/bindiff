package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Enum extends GeneratedMessage implements EnumOrBuilder
{
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    private List enumvalue_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private List options_;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    private SourceContext sourceContext_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Enum DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Enum(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Enum() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.enumvalue_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Enum(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                            this.enumvalue_ = new ArrayList();
                            n |= 0x2;
                        }
                        this.enumvalue_.add(codedInputStream.readMessage(EnumValue.PARSER, extensionRegistryLite));
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
                this.enumvalue_ = Collections.unmodifiableList((List<?>)this.enumvalue_);
            }
            if ((n & 0x4) == 0x4) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
            }
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Enum$Builder.class);
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
    
    public List getEnumvalueList() {
        return this.enumvalue_;
    }
    
    public List getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }
    
    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }
    
    public EnumValue getEnumvalue(final int n) {
        return this.enumvalue_.get(n);
    }
    
    public EnumValueOrBuilder getEnumvalueOrBuilder(final int n) {
        return this.enumvalue_.get(n);
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
        for (int i = 0; i < this.enumvalue_.size(); ++i) {
            codedOutputStream.writeMessage(2, (MessageLite)this.enumvalue_.get(i));
        }
        for (int j = 0; j < this.options_.size(); ++j) {
            codedOutputStream.writeMessage(3, (MessageLite)this.options_.get(j));
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.writeMessage(4, this.getSourceContext());
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
        for (int i = 0; i < this.enumvalue_.size(); ++i) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.enumvalue_.get(i));
        }
        for (int j = 0; j < this.options_.size(); ++j) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_.get(j));
        }
        if (this.sourceContext_ != null) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(4, this.getSourceContext());
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static Enum parseFrom(final ByteString byteString) {
        return (Enum)Enum.PARSER.parseFrom(byteString);
    }
    
    public static Enum parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)Enum.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Enum parseFrom(final byte[] array) {
        return (Enum)Enum.PARSER.parseFrom(array);
    }
    
    public static Enum parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)Enum.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Enum parseFrom(final InputStream inputStream) {
        return (Enum)Enum.PARSER.parseFrom(inputStream);
    }
    
    public static Enum parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)Enum.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Enum parseDelimitedFrom(final InputStream inputStream) {
        return (Enum)Enum.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Enum parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)Enum.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Enum parseFrom(final CodedInputStream codedInputStream) {
        return (Enum)Enum.PARSER.parseFrom(codedInputStream);
    }
    
    public static Enum parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)Enum.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Enum$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Enum$Builder newBuilder() {
        return Enum.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Enum$Builder newBuilder(final Enum enum1) {
        return Enum.DEFAULT_INSTANCE.toBuilder().mergeFrom(enum1);
    }
    
    public Enum$Builder toBuilder() {
        return (this == Enum.DEFAULT_INSTANCE) ? new Enum$Builder((Enum$1)null) : new Enum$Builder((Enum$1)null).mergeFrom(this);
    }
    
    protected Enum$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Enum$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Enum getDefaultInstance() {
        return Enum.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Enum.PARSER;
    }
    
    public Enum getDefaultInstanceForType() {
        return Enum.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Enum();
        PARSER = new Enum$1();
    }
}
