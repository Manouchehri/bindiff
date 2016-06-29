/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.MessageReflection$MergeTarget$ContainerType;
import com.google.protobuf.WireFormat$Utf8Validation;

class MessageReflection$BuilderAdapter
implements MessageReflection$MergeTarget {
    private final Message$Builder builder;

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return this.builder.getDescriptorForType();
    }

    public MessageReflection$BuilderAdapter(Message$Builder message$Builder) {
        this.builder = message$Builder;
    }

    @Override
    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.builder.getField(descriptors$FieldDescriptor);
    }

    @Override
    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.builder.hasField(descriptors$FieldDescriptor);
    }

    @Override
    public MessageReflection$MergeTarget setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.builder.setField(descriptors$FieldDescriptor, object);
        return this;
    }

    @Override
    public MessageReflection$MergeTarget clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.builder.clearField(descriptors$FieldDescriptor);
        return this;
    }

    @Override
    public MessageReflection$MergeTarget setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2, Object object) {
        this.builder.setRepeatedField(descriptors$FieldDescriptor, n2, object);
        return this;
    }

    @Override
    public MessageReflection$MergeTarget addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.builder.addRepeatedField(descriptors$FieldDescriptor, object);
        return this;
    }

    @Override
    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this.builder.hasOneof(descriptors$OneofDescriptor);
    }

    @Override
    public MessageReflection$MergeTarget clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.builder.clearOneof(descriptors$OneofDescriptor);
        return this;
    }

    @Override
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this.builder.getOneofFieldDescriptor(descriptors$OneofDescriptor);
    }

    @Override
    public MessageReflection$MergeTarget$ContainerType getContainerType() {
        return MessageReflection$MergeTarget$ContainerType.MESSAGE;
    }

    @Override
    public ExtensionRegistry$ExtensionInfo findExtensionByName(ExtensionRegistry extensionRegistry, String string) {
        return extensionRegistry.findImmutableExtensionByName(string);
    }

    @Override
    public ExtensionRegistry$ExtensionInfo findExtensionByNumber(ExtensionRegistry extensionRegistry, Descriptors$Descriptor descriptors$Descriptor, int n2) {
        return extensionRegistry.findImmutableExtensionByNumber(descriptors$Descriptor, n2);
    }

    @Override
    public Object parseGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message message) {
        Message message2;
        Message$Builder message$Builder = message != null ? message.newBuilderForType() : this.builder.newBuilderForField(descriptors$FieldDescriptor);
        if (!descriptors$FieldDescriptor.isRepeated() && (message2 = (Message)this.getField(descriptors$FieldDescriptor)) != null) {
            message$Builder.mergeFrom(message2);
        }
        codedInputStream.readGroup(descriptors$FieldDescriptor.getNumber(), message$Builder, extensionRegistryLite);
        return message$Builder.buildPartial();
    }

    @Override
    public Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message message) {
        Message message2;
        Message$Builder message$Builder = message != null ? message.newBuilderForType() : this.builder.newBuilderForField(descriptors$FieldDescriptor);
        if (!descriptors$FieldDescriptor.isRepeated() && (message2 = (Message)this.getField(descriptors$FieldDescriptor)) != null) {
            message$Builder.mergeFrom(message2);
        }
        codedInputStream.readMessage(message$Builder, extensionRegistryLite);
        return message$Builder.buildPartial();
    }

    @Override
    public Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message message) {
        Message message2;
        Message$Builder message$Builder = message != null ? message.newBuilderForType() : this.builder.newBuilderForField(descriptors$FieldDescriptor);
        if (!descriptors$FieldDescriptor.isRepeated() && (message2 = (Message)this.getField(descriptors$FieldDescriptor)) != null) {
            message$Builder.mergeFrom(message2);
        }
        message$Builder.mergeFrom(byteString, extensionRegistryLite);
        return message$Builder.buildPartial();
    }

    @Override
    public MessageReflection$MergeTarget newMergeTargetForField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message message) {
        if (message == null) return new MessageReflection$BuilderAdapter(this.builder.newBuilderForField(descriptors$FieldDescriptor));
        return new MessageReflection$BuilderAdapter(message.newBuilderForType());
    }

    @Override
    public WireFormat$Utf8Validation getUtf8Validation(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.needsUtf8Check()) {
            return WireFormat$Utf8Validation.STRICT;
        }
        if (descriptors$FieldDescriptor.isRepeated()) return WireFormat$Utf8Validation.LOOSE;
        if (!(this.builder instanceof GeneratedMessage$Builder)) return WireFormat$Utf8Validation.LOOSE;
        return WireFormat$Utf8Validation.LAZY;
    }

    @Override
    public Object finish() {
        return this.builder.buildPartial();
    }
}

