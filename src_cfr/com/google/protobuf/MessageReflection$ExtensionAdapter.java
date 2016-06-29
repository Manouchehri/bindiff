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
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.MessageReflection$MergeTarget$ContainerType;
import com.google.protobuf.WireFormat$Utf8Validation;

class MessageReflection$ExtensionAdapter
implements MessageReflection$MergeTarget {
    private final FieldSet extensions;

    MessageReflection$ExtensionAdapter(FieldSet fieldSet) {
        this.extensions = fieldSet;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
    }

    @Override
    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.extensions.getField(descriptors$FieldDescriptor);
    }

    @Override
    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.extensions.hasField(descriptors$FieldDescriptor);
    }

    @Override
    public MessageReflection$MergeTarget setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.extensions.setField(descriptors$FieldDescriptor, object);
        return this;
    }

    @Override
    public MessageReflection$MergeTarget clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.extensions.clearField(descriptors$FieldDescriptor);
        return this;
    }

    @Override
    public MessageReflection$MergeTarget setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2, Object object) {
        this.extensions.setRepeatedField(descriptors$FieldDescriptor, n2, object);
        return this;
    }

    @Override
    public MessageReflection$MergeTarget addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.extensions.addRepeatedField(descriptors$FieldDescriptor, object);
        return this;
    }

    @Override
    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return false;
    }

    @Override
    public MessageReflection$MergeTarget clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this;
    }

    @Override
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return null;
    }

    @Override
    public MessageReflection$MergeTarget$ContainerType getContainerType() {
        return MessageReflection$MergeTarget$ContainerType.EXTENSION_SET;
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
        Message$Builder message$Builder = message.newBuilderForType();
        if (!descriptors$FieldDescriptor.isRepeated() && (message2 = (Message)this.getField(descriptors$FieldDescriptor)) != null) {
            message$Builder.mergeFrom(message2);
        }
        codedInputStream.readGroup(descriptors$FieldDescriptor.getNumber(), message$Builder, extensionRegistryLite);
        return message$Builder.buildPartial();
    }

    @Override
    public Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message message) {
        Message message2;
        Message$Builder message$Builder = message.newBuilderForType();
        if (!descriptors$FieldDescriptor.isRepeated() && (message2 = (Message)this.getField(descriptors$FieldDescriptor)) != null) {
            message$Builder.mergeFrom(message2);
        }
        codedInputStream.readMessage(message$Builder, extensionRegistryLite);
        return message$Builder.buildPartial();
    }

    @Override
    public Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message message) {
        Message message2;
        Message$Builder message$Builder = message.newBuilderForType();
        if (!descriptors$FieldDescriptor.isRepeated() && (message2 = (Message)this.getField(descriptors$FieldDescriptor)) != null) {
            message$Builder.mergeFrom(message2);
        }
        message$Builder.mergeFrom(byteString, extensionRegistryLite);
        return message$Builder.buildPartial();
    }

    @Override
    public MessageReflection$MergeTarget newMergeTargetForField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message message) {
        throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
    }

    @Override
    public WireFormat$Utf8Validation getUtf8Validation(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (!descriptors$FieldDescriptor.needsUtf8Check()) return WireFormat$Utf8Validation.LOOSE;
        return WireFormat$Utf8Validation.STRICT;
    }

    @Override
    public Object finish() {
        throw new UnsupportedOperationException("finish() called on FieldSet object");
    }
}

