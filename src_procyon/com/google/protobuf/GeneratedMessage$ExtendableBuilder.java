package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public abstract class GeneratedMessage$ExtendableBuilder extends GeneratedMessage$Builder implements GeneratedMessage$ExtendableMessageOrBuilder
{
    private FieldSet extensions;
    
    protected GeneratedMessage$ExtendableBuilder() {
        this.extensions = FieldSet.emptySet();
    }
    
    protected GeneratedMessage$ExtendableBuilder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.extensions = FieldSet.emptySet();
    }
    
    void internalSetExtensionSet(final FieldSet extensions) {
        this.extensions = extensions;
    }
    
    public GeneratedMessage$ExtendableBuilder clear() {
        this.extensions = FieldSet.emptySet();
        return (GeneratedMessage$ExtendableBuilder)super.clear();
    }
    
    public GeneratedMessage$ExtendableBuilder clone() {
        return (GeneratedMessage$ExtendableBuilder)super.clone();
    }
    
    private void ensureExtensionsIsMutable() {
        if (this.extensions.isImmutable()) {
            this.extensions = this.extensions.clone();
        }
    }
    
    private void verifyExtensionContainingType(final Extension extension) {
        if (extension.getDescriptor().getContainingType() != this.getDescriptorForType()) {
            final String value = String.valueOf(String.valueOf(extension.getDescriptor().getContainingType().getFullName()));
            final String value2 = String.valueOf(String.valueOf(this.getDescriptorForType().getFullName()));
            throw new IllegalArgumentException(new StringBuilder(62 + value.length() + value2.length()).append("Extension is for type \"").append(value).append("\" which does not match message type \"").append(value2).append("\".").toString());
        }
    }
    
    public final boolean hasExtension(final ExtensionLite extensionLite) {
        final Extension access$500 = checkNotLite(extensionLite);
        this.verifyExtensionContainingType(access$500);
        return this.extensions.hasField(access$500.getDescriptor());
    }
    
    public final int getExtensionCount(final ExtensionLite extensionLite) {
        final Extension access$500 = checkNotLite(extensionLite);
        this.verifyExtensionContainingType(access$500);
        return this.extensions.getRepeatedFieldCount(access$500.getDescriptor());
    }
    
    public final Object getExtension(final ExtensionLite extensionLite) {
        final Extension access$500 = checkNotLite(extensionLite);
        this.verifyExtensionContainingType(access$500);
        final Descriptors$FieldDescriptor descriptor = access$500.getDescriptor();
        final Object field = this.extensions.getField(descriptor);
        if (field != null) {
            return access$500.fromReflectionType(field);
        }
        if (descriptor.isRepeated()) {
            return Collections.emptyList();
        }
        if (descriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            return access$500.getMessageDefaultInstance();
        }
        return access$500.fromReflectionType(descriptor.getDefaultValue());
    }
    
    public final Object getExtension(final ExtensionLite extensionLite, final int n) {
        final Extension access$500 = checkNotLite(extensionLite);
        this.verifyExtensionContainingType(access$500);
        return access$500.singularFromReflectionType(this.extensions.getRepeatedField(access$500.getDescriptor(), n));
    }
    
    public final GeneratedMessage$ExtendableBuilder setExtension(final ExtensionLite extensionLite, final Object o) {
        final Extension access$500 = checkNotLite(extensionLite);
        this.verifyExtensionContainingType(access$500);
        this.ensureExtensionsIsMutable();
        this.extensions.setField(access$500.getDescriptor(), access$500.toReflectionType(o));
        this.onChanged();
        return this;
    }
    
    public final GeneratedMessage$ExtendableBuilder setExtension(final ExtensionLite extensionLite, final int n, final Object o) {
        final Extension access$500 = checkNotLite(extensionLite);
        this.verifyExtensionContainingType(access$500);
        this.ensureExtensionsIsMutable();
        this.extensions.setRepeatedField(access$500.getDescriptor(), n, access$500.singularToReflectionType(o));
        this.onChanged();
        return this;
    }
    
    public final GeneratedMessage$ExtendableBuilder addExtension(final ExtensionLite extensionLite, final Object o) {
        final Extension access$500 = checkNotLite(extensionLite);
        this.verifyExtensionContainingType(access$500);
        this.ensureExtensionsIsMutable();
        this.extensions.addRepeatedField(access$500.getDescriptor(), access$500.singularToReflectionType(o));
        this.onChanged();
        return this;
    }
    
    public final GeneratedMessage$ExtendableBuilder clearExtension(final ExtensionLite extensionLite) {
        final Extension access$500 = checkNotLite(extensionLite);
        this.verifyExtensionContainingType(access$500);
        this.ensureExtensionsIsMutable();
        this.extensions.clearField(access$500.getDescriptor());
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
    
    public boolean isInitialized() {
        return super.isInitialized() && this.extensionsAreInitialized();
    }
    
    protected boolean parseUnknownField(final CodedInputStream codedInputStream, final UnknownFieldSet$Builder unknownFieldSet$Builder, final ExtensionRegistryLite extensionRegistryLite, final int n) {
        return MessageReflection.mergeFieldFrom(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, this.getDescriptorForType(), new MessageReflection$BuilderAdapter(this), n);
    }
    
    public Map getAllFields() {
        final Map access$900 = GeneratedMessage$Builder.access$900(this);
        access$900.putAll(this.extensions.getAllFields());
        return Collections.unmodifiableMap((Map<?, ?>)access$900);
    }
    
    public Object getField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (!descriptors$FieldDescriptor.isExtension()) {
            return super.getField(descriptors$FieldDescriptor);
        }
        this.verifyContainingType(descriptors$FieldDescriptor);
        final Object field = this.extensions.getField(descriptors$FieldDescriptor);
        if (field != null) {
            return field;
        }
        if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            return DynamicMessage.getDefaultInstance(descriptors$FieldDescriptor.getMessageType());
        }
        return descriptors$FieldDescriptor.getDefaultValue();
    }
    
    public int getRepeatedFieldCount(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.isExtension()) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            return this.extensions.getRepeatedFieldCount(descriptors$FieldDescriptor);
        }
        return super.getRepeatedFieldCount(descriptors$FieldDescriptor);
    }
    
    public Object getRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n) {
        if (descriptors$FieldDescriptor.isExtension()) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            return this.extensions.getRepeatedField(descriptors$FieldDescriptor, n);
        }
        return super.getRepeatedField(descriptors$FieldDescriptor, n);
    }
    
    public boolean hasField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.isExtension()) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            return this.extensions.hasField(descriptors$FieldDescriptor);
        }
        return super.hasField(descriptors$FieldDescriptor);
    }
    
    public GeneratedMessage$ExtendableBuilder setField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        if (descriptors$FieldDescriptor.isExtension()) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            this.ensureExtensionsIsMutable();
            this.extensions.setField(descriptors$FieldDescriptor, o);
            this.onChanged();
            return this;
        }
        return (GeneratedMessage$ExtendableBuilder)super.setField(descriptors$FieldDescriptor, o);
    }
    
    public GeneratedMessage$ExtendableBuilder clearField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.isExtension()) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            this.ensureExtensionsIsMutable();
            this.extensions.clearField(descriptors$FieldDescriptor);
            this.onChanged();
            return this;
        }
        return (GeneratedMessage$ExtendableBuilder)super.clearField(descriptors$FieldDescriptor);
    }
    
    public GeneratedMessage$ExtendableBuilder setRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n, final Object o) {
        if (descriptors$FieldDescriptor.isExtension()) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            this.ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(descriptors$FieldDescriptor, n, o);
            this.onChanged();
            return this;
        }
        return (GeneratedMessage$ExtendableBuilder)super.setRepeatedField(descriptors$FieldDescriptor, n, o);
    }
    
    public GeneratedMessage$ExtendableBuilder addRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        if (descriptors$FieldDescriptor.isExtension()) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            this.ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(descriptors$FieldDescriptor, o);
            this.onChanged();
            return this;
        }
        return (GeneratedMessage$ExtendableBuilder)super.addRepeatedField(descriptors$FieldDescriptor, o);
    }
    
    protected final void mergeExtensionFields(final GeneratedMessage$ExtendableMessage generatedMessage$ExtendableMessage) {
        this.ensureExtensionsIsMutable();
        this.extensions.mergeFrom(generatedMessage$ExtendableMessage.extensions);
        this.onChanged();
    }
    
    private void verifyContainingType(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() != this.getDescriptorForType()) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }
}
