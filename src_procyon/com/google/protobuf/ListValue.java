package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class ListValue extends GeneratedMessage implements ListValueOrBuilder
{
    public static final int VALUES_FIELD_NUMBER = 1;
    private List values_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final ListValue DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private ListValue(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private ListValue() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.values_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private ListValue(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        if ((n & 0x1) != 0x1) {
                            this.values_ = new ArrayList();
                            n |= 0x1;
                        }
                        this.values_.add(codedInputStream.readMessage(Value.PARSER, extensionRegistryLite));
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
            if ((n & 0x1) == 0x1) {
                this.values_ = Collections.unmodifiableList((List<?>)this.values_);
            }
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, ListValue$Builder.class);
    }
    
    public List getValuesList() {
        return this.values_;
    }
    
    public List getValuesOrBuilderList() {
        return this.values_;
    }
    
    public int getValuesCount() {
        return this.values_.size();
    }
    
    public Value getValues(final int n) {
        return this.values_.get(n);
    }
    
    public ValueOrBuilder getValuesOrBuilder(final int n) {
        return this.values_.get(n);
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
        for (int i = 0; i < this.values_.size(); ++i) {
            codedOutputStream.writeMessage(1, (MessageLite)this.values_.get(i));
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        for (int i = 0; i < this.values_.size(); ++i) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(1, (MessageLite)this.values_.get(i));
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ListValue)) {
            return super.equals(o);
        }
        final ListValue listValue = (ListValue)o;
        return true && this.getValuesList().equals(listValue.getValuesList());
    }
    
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int n = 19 * 41 + this.getDescriptorForType().hashCode();
        if (this.getValuesCount() > 0) {
            n = 53 * (37 * n + 1) + this.getValuesList().hashCode();
        }
        return this.memoizedHashCode = 29 * n + this.unknownFields.hashCode();
    }
    
    public static ListValue parseFrom(final ByteString byteString) {
        return (ListValue)ListValue.PARSER.parseFrom(byteString);
    }
    
    public static ListValue parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)ListValue.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static ListValue parseFrom(final byte[] array) {
        return (ListValue)ListValue.PARSER.parseFrom(array);
    }
    
    public static ListValue parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)ListValue.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static ListValue parseFrom(final InputStream inputStream) {
        return (ListValue)ListValue.PARSER.parseFrom(inputStream);
    }
    
    public static ListValue parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)ListValue.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static ListValue parseDelimitedFrom(final InputStream inputStream) {
        return (ListValue)ListValue.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static ListValue parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)ListValue.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static ListValue parseFrom(final CodedInputStream codedInputStream) {
        return (ListValue)ListValue.PARSER.parseFrom(codedInputStream);
    }
    
    public static ListValue parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue)ListValue.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public ListValue$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static ListValue$Builder newBuilder() {
        return ListValue.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static ListValue$Builder newBuilder(final ListValue listValue) {
        return ListValue.DEFAULT_INSTANCE.toBuilder().mergeFrom(listValue);
    }
    
    public ListValue$Builder toBuilder() {
        return (this == ListValue.DEFAULT_INSTANCE) ? new ListValue$Builder((ListValue$1)null) : new ListValue$Builder((ListValue$1)null).mergeFrom(this);
    }
    
    protected ListValue$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new ListValue$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static ListValue getDefaultInstance() {
        return ListValue.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return ListValue.PARSER;
    }
    
    public ListValue getDefaultInstanceForType() {
        return ListValue.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new ListValue();
        PARSER = new ListValue$1();
    }
}
