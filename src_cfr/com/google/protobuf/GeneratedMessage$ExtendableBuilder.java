/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Extension;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$ExtendableMessage;
import com.google.protobuf.GeneratedMessage$ExtendableMessageOrBuilder;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.MessageReflection$BuilderAdapter;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.util.Collections;
import java.util.Map;

public abstract class GeneratedMessage$ExtendableBuilder
extends GeneratedMessage$Builder
implements GeneratedMessage$ExtendableMessageOrBuilder {
    private FieldSet extensions = FieldSet.emptySet();

    protected GeneratedMessage$ExtendableBuilder() {
    }

    protected GeneratedMessage$ExtendableBuilder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
    }

    void internalSetExtensionSet(FieldSet fieldSet) {
        this.extensions = fieldSet;
    }

    @Override
    public GeneratedMessage$ExtendableBuilder clear() {
        this.extensions = FieldSet.emptySet();
        return (GeneratedMessage$ExtendableBuilder)super.clear();
    }

    @Override
    public GeneratedMessage$ExtendableBuilder clone() {
        return (GeneratedMessage$ExtendableBuilder)super.clone();
    }

    private void ensureExtensionsIsMutable() {
        if (!this.extensions.isImmutable()) return;
        this.extensions = this.extensions.clone();
    }

    private void verifyExtensionContainingType(Extension extension) {
        if (extension.getDescriptor().getContainingType() == this.getDescriptorForType()) return;
        String string = String.valueOf(String.valueOf(extension.getDescriptor().getContainingType().getFullName()));
        String string2 = String.valueOf(String.valueOf(this.getDescriptorForType().getFullName()));
        throw new IllegalArgumentException(new StringBuilder(62 + string.length() + string2.length()).append("Extension is for type \"").append(string).append("\" which does not match message type \"").append(string2).append("\".").toString());
    }

    @Override
    public final boolean hasExtension(ExtensionLite extensionLite) {
        Extension extension = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType(extension);
        return this.extensions.hasField(extension.getDescriptor());
    }

    @Override
    public final int getExtensionCount(ExtensionLite extensionLite) {
        Extension extension = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType(extension);
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = extension.getDescriptor();
        return this.extensions.getRepeatedFieldCount(descriptors$FieldDescriptor);
    }

    @Override
    public final Object getExtension(ExtensionLite extensionLite) {
        Extension extension = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType(extension);
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = extension.getDescriptor();
        Object object = this.extensions.getField(descriptors$FieldDescriptor);
        if (object != null) return extension.fromReflectionType(object);
        if (descriptors$FieldDescriptor.isRepeated()) {
            return Collections.emptyList();
        }
        if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) return extension.fromReflectionType(descriptors$FieldDescriptor.getDefaultValue());
        return extension.getMessageDefaultInstance();
    }

    @Override
    public final Object getExtension(ExtensionLite extensionLite, int n2) {
        Extension extension = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType(extension);
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = extension.getDescriptor();
        return extension.singularFromReflectionType(this.extensions.getRepeatedField(descriptors$FieldDescriptor, n2));
    }

    public final GeneratedMessage$ExtendableBuilder setExtension(ExtensionLite extensionLite, Object object) {
        Extension extension = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType(extension);
        this.ensureExtensionsIsMutable();
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = extension.getDescriptor();
        this.extensions.setField(descriptors$FieldDescriptor, extension.toReflectionType(object));
        this.onChanged();
        return this;
    }

    public final GeneratedMessage$ExtendableBuilder setExtension(ExtensionLite extensionLite, int n2, Object object) {
        Extension extension = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType(extension);
        this.ensureExtensionsIsMutable();
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = extension.getDescriptor();
        this.extensions.setRepeatedField(descriptors$FieldDescriptor, n2, extension.singularToReflectionType(object));
        this.onChanged();
        return this;
    }

    public final GeneratedMessage$ExtendableBuilder addExtension(ExtensionLite extensionLite, Object object) {
        Extension extension = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType(extension);
        this.ensureExtensionsIsMutable();
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = extension.getDescriptor();
        this.extensions.addRepeatedField(descriptors$FieldDescriptor, extension.singularToReflectionType(object));
        this.onChanged();
        return this;
    }

    public final GeneratedMessage$ExtendableBuilder clearExtension(ExtensionLite extensionLite) {
        Extension extension = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType(extension);
        this.ensureExtensionsIsMutable();
        this.extensions.clearField(extension.getDescriptor());
        this.onChanged();
        return this;
    }

    protected boolean extensionsAreInitialized() {
        return this.extensions.isInitialized();
    }

    private FieldSet buildExtensions() {
        this.extensions.makeImmutable();
        return this.extensions;
    }

    @Override
    public boolean isInitialized() {
        if (!super.isInitialized()) return false;
        if (!this.extensionsAreInitialized()) return false;
        return true;
    }

    @Override
    protected boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet$Builder unknownFieldSet$Builder, ExtensionRegistryLite extensionRegistryLite, int n2) {
        return MessageReflection.mergeFieldFrom(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, this.getDescriptorForType(), new MessageReflection$BuilderAdapter(this), n2);
    }

    @Override
    public Map getAllFields() {
        Map map = GeneratedMessage$Builder.access$900(this);
        map.putAll(this.extensions.getAllFields());
        return Collections.unmodifiableMap(map);
    }

    @Override
    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (!descriptors$FieldDescriptor.isExtension()) return super.getField(descriptors$FieldDescriptor);
        this.verifyContainingType(descriptors$FieldDescriptor);
        Object object = this.extensions.getField(descriptors$FieldDescriptor);
        if (object != null) return object;
        if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) return descriptors$FieldDescriptor.getDefaultValue();
        return DynamicMessage.getDefaultInstance(descriptors$FieldDescriptor.getMessageType());
    }

    @Override
    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (!descriptors$FieldDescriptor.isExtension()) return super.getRepeatedFieldCount(descriptors$FieldDescriptor);
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.extensions.getRepeatedFieldCount(descriptors$FieldDescriptor);
    }

    @Override
    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2) {
        if (!descriptors$FieldDescriptor.isExtension()) return super.getRepeatedField(descriptors$FieldDescriptor, n2);
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.extensions.getRepeatedField(descriptors$FieldDescriptor, n2);
    }

    @Override
    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (!descriptors$FieldDescriptor.isExtension()) return super.hasField(descriptors$FieldDescriptor);
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.extensions.hasField(descriptors$FieldDescriptor);
    }

    @Override
    public GeneratedMessage$ExtendableBuilder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        if (!descriptors$FieldDescriptor.isExtension()) return (GeneratedMessage$ExtendableBuilder)super.setField(descriptors$FieldDescriptor, object);
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureExtensionsIsMutable();
        this.extensions.setField(descriptors$FieldDescriptor, object);
        this.onChanged();
        return this;
    }

    @Override
    public GeneratedMessage$ExtendableBuilder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (!descriptors$FieldDescriptor.isExtension()) return (GeneratedMessage$ExtendableBuilder)super.clearField(descriptors$FieldDescriptor);
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureExtensionsIsMutable();
        this.extensions.clearField(descriptors$FieldDescriptor);
        this.onChanged();
        return this;
    }

    @Override
    public GeneratedMessage$ExtendableBuilder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2, Object object) {
        if (!descriptors$FieldDescriptor.isExtension()) return (GeneratedMessage$ExtendableBuilder)super.setRepeatedField(descriptors$FieldDescriptor, n2, object);
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureExtensionsIsMutable();
        this.extensions.setRepeatedField(descriptors$FieldDescriptor, n2, object);
        this.onChanged();
        return this;
    }

    @Override
    public GeneratedMessage$ExtendableBuilder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        if (!descriptors$FieldDescriptor.isExtension()) return (GeneratedMessage$ExtendableBuilder)super.addRepeatedField(descriptors$FieldDescriptor, object);
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureExtensionsIsMutable();
        this.extensions.addRepeatedField(descriptors$FieldDescriptor, object);
        this.onChanged();
        return this;
    }

    protected final void mergeExtensionFields(GeneratedMessage$ExtendableMessage generatedMessage$ExtendableMessage) {
        this.ensureExtensionsIsMutable();
        this.extensions.mergeFrom(GeneratedMessage$ExtendableMessage.access$600(generatedMessage$ExtendableMessage));
        this.onChanged();
    }

    private void verifyContainingType(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() == this.getDescriptorForType()) return;
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }

    static /* synthetic */ FieldSet access$400(GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder) {
        return generatedMessage$ExtendableBuilder.buildExtensions();
    }
}

