package com.google.protobuf;

import java.io.*;
import java.util.*;

public final class DynamicMessage extends AbstractMessage
{
    private final Descriptors$Descriptor type;
    private final FieldSet fields;
    private final Descriptors$FieldDescriptor[] oneofCases;
    private final UnknownFieldSet unknownFields;
    private int memoizedSize;
    
    DynamicMessage(final Descriptors$Descriptor type, final FieldSet fields, final Descriptors$FieldDescriptor[] oneofCases, final UnknownFieldSet unknownFields) {
        this.memoizedSize = -1;
        this.type = type;
        this.fields = fields;
        this.oneofCases = oneofCases;
        this.unknownFields = unknownFields;
    }
    
    public static DynamicMessage getDefaultInstance(final Descriptors$Descriptor descriptors$Descriptor) {
        return new DynamicMessage(descriptors$Descriptor, FieldSet.emptySet(), new Descriptors$FieldDescriptor[descriptors$Descriptor.toProto().getOneofDeclCount()], UnknownFieldSet.getDefaultInstance());
    }
    
    public static DynamicMessage parseFrom(final Descriptors$Descriptor descriptors$Descriptor, final CodedInputStream codedInputStream) {
        return ((DynamicMessage$Builder)newBuilder(descriptors$Descriptor).mergeFrom(codedInputStream)).buildParsed();
    }
    
    public static DynamicMessage parseFrom(final Descriptors$Descriptor descriptors$Descriptor, final CodedInputStream codedInputStream, final ExtensionRegistry extensionRegistry) {
        return ((DynamicMessage$Builder)newBuilder(descriptors$Descriptor).mergeFrom(codedInputStream, extensionRegistry)).buildParsed();
    }
    
    public static DynamicMessage parseFrom(final Descriptors$Descriptor descriptors$Descriptor, final ByteString byteString) {
        return ((DynamicMessage$Builder)newBuilder(descriptors$Descriptor).mergeFrom(byteString)).buildParsed();
    }
    
    public static DynamicMessage parseFrom(final Descriptors$Descriptor descriptors$Descriptor, final ByteString byteString, final ExtensionRegistry extensionRegistry) {
        return ((DynamicMessage$Builder)newBuilder(descriptors$Descriptor).mergeFrom(byteString, extensionRegistry)).buildParsed();
    }
    
    public static DynamicMessage parseFrom(final Descriptors$Descriptor descriptors$Descriptor, final byte[] array) {
        return ((DynamicMessage$Builder)newBuilder(descriptors$Descriptor).mergeFrom(array)).buildParsed();
    }
    
    public static DynamicMessage parseFrom(final Descriptors$Descriptor descriptors$Descriptor, final byte[] array, final ExtensionRegistry extensionRegistry) {
        return ((DynamicMessage$Builder)newBuilder(descriptors$Descriptor).mergeFrom(array, extensionRegistry)).buildParsed();
    }
    
    public static DynamicMessage parseFrom(final Descriptors$Descriptor descriptors$Descriptor, final InputStream inputStream) {
        return ((DynamicMessage$Builder)newBuilder(descriptors$Descriptor).mergeFrom(inputStream)).buildParsed();
    }
    
    public static DynamicMessage parseFrom(final Descriptors$Descriptor descriptors$Descriptor, final InputStream inputStream, final ExtensionRegistry extensionRegistry) {
        return ((DynamicMessage$Builder)newBuilder(descriptors$Descriptor).mergeFrom(inputStream, extensionRegistry)).buildParsed();
    }
    
    public static DynamicMessage$Builder newBuilder(final Descriptors$Descriptor descriptors$Descriptor) {
        return new DynamicMessage$Builder(descriptors$Descriptor, null);
    }
    
    public static DynamicMessage$Builder newBuilder(final Message message) {
        return new DynamicMessage$Builder(message.getDescriptorForType(), null).mergeFrom(message);
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return this.type;
    }
    
    public DynamicMessage getDefaultInstanceForType() {
        return getDefaultInstance(this.type);
    }
    
    public Map getAllFields() {
        return this.fields.getAllFields();
    }
    
    public boolean hasOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        return this.oneofCases[descriptors$OneofDescriptor.getIndex()] != null;
    }
    
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        return this.oneofCases[descriptors$OneofDescriptor.getIndex()];
    }
    
    public boolean hasField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.hasField(descriptors$FieldDescriptor);
    }
    
    public Object getField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        Object o = this.fields.getField(descriptors$FieldDescriptor);
        if (o == null) {
            if (descriptors$FieldDescriptor.isRepeated()) {
                o = Collections.emptyList();
            }
            else if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                o = getDefaultInstance(descriptors$FieldDescriptor.getMessageType());
            }
            else {
                o = descriptors$FieldDescriptor.getDefaultValue();
            }
        }
        return o;
    }
    
    public int getRepeatedFieldCount(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedFieldCount(descriptors$FieldDescriptor);
    }
    
    public Object getRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedField(descriptors$FieldDescriptor, n);
    }
    
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    static boolean isInitialized(final Descriptors$Descriptor descriptors$Descriptor, final FieldSet set) {
        for (final Descriptors$FieldDescriptor descriptors$FieldDescriptor : descriptors$Descriptor.getFields()) {
            if (descriptors$FieldDescriptor.isRequired() && !set.hasField(descriptors$FieldDescriptor)) {
                return false;
            }
        }
        return set.isInitialized();
    }
    
    public boolean isInitialized() {
        return isInitialized(this.type, this.fields);
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if (this.type.getOptions().getMessageSetWireFormat()) {
            this.fields.writeMessageSetTo(codedOutputStream);
            this.unknownFields.writeAsMessageSetTo(codedOutputStream);
        }
        else {
            this.fields.writeTo(codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSize = this.memoizedSize;
        if (memoizedSize != -1) {
            return memoizedSize;
        }
        int memoizedSize2;
        if (this.type.getOptions().getMessageSetWireFormat()) {
            memoizedSize2 = this.fields.getMessageSetSerializedSize() + this.unknownFields.getSerializedSizeAsMessageSet();
        }
        else {
            memoizedSize2 = this.fields.getSerializedSize() + this.unknownFields.getSerializedSize();
        }
        return this.memoizedSize = memoizedSize2;
    }
    
    public DynamicMessage$Builder newBuilderForType() {
        return new DynamicMessage$Builder(this.type, null);
    }
    
    public DynamicMessage$Builder toBuilder() {
        return this.newBuilderForType().mergeFrom(this);
    }
    
    public Parser getParserForType() {
        return new DynamicMessage$1(this);
    }
    
    private void verifyContainingType(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() != this.type) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }
    
    private void verifyOneofContainingType(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        if (descriptors$OneofDescriptor.getContainingType() != this.type) {
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }
    }
}
