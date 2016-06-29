package com.google.protobuf;

import java.util.*;

public abstract class GeneratedMessage$ExtendableMessage extends GeneratedMessage implements GeneratedMessage$ExtendableMessageOrBuilder
{
    private final FieldSet extensions;
    
    protected GeneratedMessage$ExtendableMessage() {
        this.extensions = FieldSet.newFieldSet();
    }
    
    protected GeneratedMessage$ExtendableMessage(final GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder) {
        super(generatedMessage$ExtendableBuilder);
        this.extensions = generatedMessage$ExtendableBuilder.buildExtensions();
    }
    
    private void verifyExtensionContainingType(final Extension extension) {
        if (extension.getDescriptor().getContainingType() != this.getDescriptorForType()) {
            final String value = String.valueOf(String.valueOf(extension.getDescriptor().getContainingType().getFullName()));
            final String value2 = String.valueOf(String.valueOf(this.getDescriptorForType().getFullName()));
            throw new IllegalArgumentException(new StringBuilder(62 + value.length() + value2.length()).append("Extension is for type \"").append(value).append("\" which does not match message type \"").append(value2).append("\".").toString());
        }
    }
    
    public final boolean hasExtension(final ExtensionLite extensionLite) {
        final Extension access$500 = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType(access$500);
        return this.extensions.hasField(access$500.getDescriptor());
    }
    
    public final int getExtensionCount(final ExtensionLite extensionLite) {
        final Extension access$500 = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType(access$500);
        return this.extensions.getRepeatedFieldCount(access$500.getDescriptor());
    }
    
    public final Object getExtension(final ExtensionLite extensionLite) {
        final Extension access$500 = GeneratedMessage.access$500(extensionLite);
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
        final Extension access$500 = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType(access$500);
        return access$500.singularFromReflectionType(this.extensions.getRepeatedField(access$500.getDescriptor(), n));
    }
    
    protected boolean extensionsAreInitialized() {
        return this.extensions.isInitialized();
    }
    
    public boolean isInitialized() {
        return super.isInitialized() && this.extensionsAreInitialized();
    }
    
    protected boolean parseUnknownField(final CodedInputStream codedInputStream, final UnknownFieldSet$Builder unknownFieldSet$Builder, final ExtensionRegistryLite extensionRegistryLite, final int n) {
        return MessageReflection.mergeFieldFrom(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, this.getDescriptorForType(), new MessageReflection$ExtensionAdapter(this.extensions), n);
    }
    
    protected void makeExtensionsImmutable() {
        this.extensions.makeImmutable();
    }
    
    protected GeneratedMessage$ExtendableMessage$ExtensionWriter newExtensionWriter() {
        return new GeneratedMessage$ExtendableMessage$ExtensionWriter(this, false, null);
    }
    
    protected GeneratedMessage$ExtendableMessage$ExtensionWriter newMessageSetExtensionWriter() {
        return new GeneratedMessage$ExtendableMessage$ExtensionWriter(this, true, null);
    }
    
    protected int extensionsSerializedSize() {
        return this.extensions.getSerializedSize();
    }
    
    protected int extensionsSerializedSizeAsMessageSet() {
        return this.extensions.getMessageSetSerializedSize();
    }
    
    protected Map getExtensionFields() {
        return this.extensions.getAllFields();
    }
    
    public Map getAllFields() {
        final Map access$800 = GeneratedMessage.access$800(this, false);
        access$800.putAll(this.getExtensionFields());
        return Collections.unmodifiableMap((Map<?, ?>)access$800);
    }
    
    public Map getAllFieldsRaw() {
        final Map access$800 = GeneratedMessage.access$800(this, false);
        access$800.putAll(this.getExtensionFields());
        return Collections.unmodifiableMap((Map<?, ?>)access$800);
    }
    
    public boolean hasField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.isExtension()) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            return this.extensions.hasField(descriptors$FieldDescriptor);
        }
        return super.hasField(descriptors$FieldDescriptor);
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
    
    private void verifyContainingType(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() != this.getDescriptorForType()) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }
}
