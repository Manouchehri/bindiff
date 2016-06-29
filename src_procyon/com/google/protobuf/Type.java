package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Type extends GeneratedMessage implements TypeOrBuilder
{
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
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Type DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Type(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Type() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.fields_ = Collections.emptyList();
        this.oneofs_ = LazyStringArrayList.EMPTY;
        this.options_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Type(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                            this.fields_ = new ArrayList();
                            n |= 0x2;
                        }
                        this.fields_.add(codedInputStream.readMessage(Field.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 26: {
                        final ByteString bytes = codedInputStream.readBytes();
                        if ((n & 0x4) != 0x4) {
                            this.oneofs_ = new LazyStringArrayList();
                            n |= 0x4;
                        }
                        this.oneofs_.add(bytes);
                        continue;
                    }
                    case 34: {
                        if ((n & 0x8) != 0x8) {
                            this.options_ = new ArrayList();
                            n |= 0x8;
                        }
                        this.options_.add(codedInputStream.readMessage(Option.PARSER, extensionRegistryLite));
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
                this.fields_ = Collections.unmodifiableList((List<?>)this.fields_);
            }
            if ((n & 0x4) == 0x4) {
                this.oneofs_ = this.oneofs_.getUnmodifiableView();
            }
            if ((n & 0x8) == 0x8) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
            }
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Type$Builder.class);
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
    
    public List getFieldsList() {
        return this.fields_;
    }
    
    public List getFieldsOrBuilderList() {
        return this.fields_;
    }
    
    public int getFieldsCount() {
        return this.fields_.size();
    }
    
    public Field getFields(final int n) {
        return this.fields_.get(n);
    }
    
    public FieldOrBuilder getFieldsOrBuilder(final int n) {
        return this.fields_.get(n);
    }
    
    public ProtocolStringList getOneofsList() {
        return this.oneofs_;
    }
    
    public int getOneofsCount() {
        return this.oneofs_.size();
    }
    
    public String getOneofs(final int n) {
        return this.oneofs_.get(n);
    }
    
    public ByteString getOneofsBytes(final int n) {
        return this.oneofs_.getByteString(n);
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
        for (int i = 0; i < this.fields_.size(); ++i) {
            codedOutputStream.writeMessage(2, (MessageLite)this.fields_.get(i));
        }
        for (int j = 0; j < this.oneofs_.size(); ++j) {
            codedOutputStream.writeBytes(3, this.oneofs_.getByteString(j));
        }
        for (int k = 0; k < this.options_.size(); ++k) {
            codedOutputStream.writeMessage(4, (MessageLite)this.options_.get(k));
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
        int n = 0;
        if (!this.getNameBytes().isEmpty()) {
            n += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        for (int i = 0; i < this.fields_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(2, (MessageLite)this.fields_.get(i));
        }
        int n2 = 0;
        for (int j = 0; j < this.oneofs_.size(); ++j) {
            n2 += CodedOutputStream.computeBytesSizeNoTag(this.oneofs_.getByteString(j));
        }
        int memoizedSerializedSize2 = n + n2 + 1 * this.getOneofsList().size();
        for (int k = 0; k < this.options_.size(); ++k) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(4, (MessageLite)this.options_.get(k));
        }
        if (this.sourceContext_ != null) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(5, this.getSourceContext());
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static Type parseFrom(final ByteString byteString) {
        return (Type)Type.PARSER.parseFrom(byteString);
    }
    
    public static Type parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Type)Type.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Type parseFrom(final byte[] array) {
        return (Type)Type.PARSER.parseFrom(array);
    }
    
    public static Type parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Type)Type.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Type parseFrom(final InputStream inputStream) {
        return (Type)Type.PARSER.parseFrom(inputStream);
    }
    
    public static Type parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Type)Type.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Type parseDelimitedFrom(final InputStream inputStream) {
        return (Type)Type.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Type parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Type)Type.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Type parseFrom(final CodedInputStream codedInputStream) {
        return (Type)Type.PARSER.parseFrom(codedInputStream);
    }
    
    public static Type parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Type)Type.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Type$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Type$Builder newBuilder() {
        return Type.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Type$Builder newBuilder(final Type type) {
        return Type.DEFAULT_INSTANCE.toBuilder().mergeFrom(type);
    }
    
    public Type$Builder toBuilder() {
        return (this == Type.DEFAULT_INSTANCE) ? new Type$Builder((Type$1)null) : new Type$Builder((Type$1)null).mergeFrom(this);
    }
    
    protected Type$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Type$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Type getDefaultInstance() {
        return Type.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Type.PARSER;
    }
    
    public Type getDefaultInstanceForType() {
        return Type.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Type();
        PARSER = new Type$1();
    }
}
