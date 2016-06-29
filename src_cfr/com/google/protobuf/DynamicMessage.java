/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.DynamicMessage$1;
import com.google.protobuf.DynamicMessage$Builder;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DynamicMessage
extends AbstractMessage {
    private final Descriptors$Descriptor type;
    private final FieldSet fields;
    private final Descriptors$FieldDescriptor[] oneofCases;
    private final UnknownFieldSet unknownFields;
    private int memoizedSize = -1;

    DynamicMessage(Descriptors$Descriptor descriptors$Descriptor, FieldSet fieldSet, Descriptors$FieldDescriptor[] arrdescriptors$FieldDescriptor, UnknownFieldSet unknownFieldSet) {
        this.type = descriptors$Descriptor;
        this.fields = fieldSet;
        this.oneofCases = arrdescriptors$FieldDescriptor;
        this.unknownFields = unknownFieldSet;
    }

    public static DynamicMessage getDefaultInstance(Descriptors$Descriptor descriptors$Descriptor) {
        int n2 = descriptors$Descriptor.toProto().getOneofDeclCount();
        Descriptors$FieldDescriptor[] arrdescriptors$FieldDescriptor = new Descriptors$FieldDescriptor[n2];
        return new DynamicMessage(descriptors$Descriptor, FieldSet.emptySet(), arrdescriptors$FieldDescriptor, UnknownFieldSet.getDefaultInstance());
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, CodedInputStream codedInputStream) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(codedInputStream));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, CodedInputStream codedInputStream, ExtensionRegistry extensionRegistry) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(codedInputStream, (ExtensionRegistryLite)extensionRegistry));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, ByteString byteString) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(byteString));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, ByteString byteString, ExtensionRegistry extensionRegistry) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(byteString, (ExtensionRegistryLite)extensionRegistry));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, byte[] arrby) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(arrby));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, byte[] arrby, ExtensionRegistry extensionRegistry) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(arrby, (ExtensionRegistryLite)extensionRegistry));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, InputStream inputStream) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(inputStream));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, InputStream inputStream, ExtensionRegistry extensionRegistry) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(inputStream, (ExtensionRegistryLite)extensionRegistry));
    }

    public static DynamicMessage$Builder newBuilder(Descriptors$Descriptor descriptors$Descriptor) {
        return new DynamicMessage$Builder(descriptors$Descriptor, null);
    }

    public static DynamicMessage$Builder newBuilder(Message message) {
        return new DynamicMessage$Builder(message.getDescriptorForType(), null).mergeFrom(message);
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return this.type;
    }

    @Override
    public DynamicMessage getDefaultInstanceForType() {
        return DynamicMessage.getDefaultInstance(this.type);
    }

    @Override
    public Map getAllFields() {
        return this.fields.getAllFields();
    }

    @Override
    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = this.oneofCases[descriptors$OneofDescriptor.getIndex()];
        if (descriptors$FieldDescriptor != null) return true;
        return false;
    }

    @Override
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        return this.oneofCases[descriptors$OneofDescriptor.getIndex()];
    }

    @Override
    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.hasField(descriptors$FieldDescriptor);
    }

    @Override
    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        List list = this.fields.getField(descriptors$FieldDescriptor);
        if (list != null) return list;
        if (descriptors$FieldDescriptor.isRepeated()) {
            return Collections.emptyList();
        }
        if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) return descriptors$FieldDescriptor.getDefaultValue();
        return DynamicMessage.getDefaultInstance(descriptors$FieldDescriptor.getMessageType());
    }

    @Override
    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedFieldCount(descriptors$FieldDescriptor);
    }

    @Override
    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedField(descriptors$FieldDescriptor, n2);
    }

    @Override
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    static boolean isInitialized(Descriptors$Descriptor descriptors$Descriptor, FieldSet fieldSet) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor;
        Iterator iterator = descriptors$Descriptor.getFields().iterator();
        do {
            if (!iterator.hasNext()) return fieldSet.isInitialized();
        } while (!(descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)iterator.next()).isRequired() || fieldSet.hasField(descriptors$FieldDescriptor));
        return false;
    }

    @Override
    public boolean isInitialized() {
        return DynamicMessage.isInitialized(this.type, this.fields);
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.type.getOptions().getMessageSetWireFormat()) {
            this.fields.writeMessageSetTo(codedOutputStream);
            this.unknownFields.writeAsMessageSetTo(codedOutputStream);
            return;
        }
        this.fields.writeTo(codedOutputStream);
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSize;
        if (n2 != -1) {
            return n2;
        }
        if (this.type.getOptions().getMessageSetWireFormat()) {
            n2 = this.fields.getMessageSetSerializedSize();
            n2 += this.unknownFields.getSerializedSizeAsMessageSet();
        } else {
            n2 = this.fields.getSerializedSize();
            n2 += this.unknownFields.getSerializedSize();
        }
        this.memoizedSize = n2;
        return n2;
    }

    @Override
    public DynamicMessage$Builder newBuilderForType() {
        return new DynamicMessage$Builder(this.type, null);
    }

    @Override
    public DynamicMessage$Builder toBuilder() {
        return this.newBuilderForType().mergeFrom(this);
    }

    @Override
    public Parser getParserForType() {
        return new DynamicMessage$1(this);
    }

    private void verifyContainingType(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() == this.type) return;
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }

    private void verifyOneofContainingType(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        if (descriptors$OneofDescriptor.getContainingType() == this.type) return;
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }

    static /* synthetic */ Descriptors$Descriptor access$200(DynamicMessage dynamicMessage) {
        return dynamicMessage.type;
    }

    static /* synthetic */ FieldSet access$300(DynamicMessage dynamicMessage) {
        return dynamicMessage.fields;
    }

    static /* synthetic */ UnknownFieldSet access$400(DynamicMessage dynamicMessage) {
        return dynamicMessage.unknownFields;
    }

    static /* synthetic */ Descriptors$FieldDescriptor[] access$500(DynamicMessage dynamicMessage) {
        return dynamicMessage.oneofCases;
    }
}

