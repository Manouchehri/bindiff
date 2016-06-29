/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$1;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage$ExtensionWriter;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;

public abstract class GeneratedMessageLite$ExtendableMessage
extends GeneratedMessageLite
implements GeneratedMessageLite$ExtendableMessageOrBuilder {
    protected FieldSet extensions = FieldSet.newFieldSet();

    protected final void mergeExtensionFields(GeneratedMessageLite$ExtendableMessage generatedMessageLite$ExtendableMessage) {
        if (this.extensions.isImmutable()) {
            this.extensions = this.extensions.clone();
        }
        this.extensions.mergeFrom(generatedMessageLite$ExtendableMessage.extensions);
    }

    private void verifyExtensionContainingType(GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension) {
        if (generatedMessageLite$GeneratedExtension.getContainingTypeDefaultInstance() == this.getDefaultInstanceForType()) return;
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }

    @Override
    public final boolean hasExtension(ExtensionLite extensionLite) {
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(generatedMessageLite$GeneratedExtension);
        return this.extensions.hasField(generatedMessageLite$GeneratedExtension.descriptor);
    }

    @Override
    public final int getExtensionCount(ExtensionLite extensionLite) {
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(generatedMessageLite$GeneratedExtension);
        return this.extensions.getRepeatedFieldCount(generatedMessageLite$GeneratedExtension.descriptor);
    }

    @Override
    public final Object getExtension(ExtensionLite extensionLite) {
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(generatedMessageLite$GeneratedExtension);
        Object object = this.extensions.getField(generatedMessageLite$GeneratedExtension.descriptor);
        if (object != null) return generatedMessageLite$GeneratedExtension.fromFieldSetType(object);
        return generatedMessageLite$GeneratedExtension.defaultValue;
    }

    @Override
    public final Object getExtension(ExtensionLite extensionLite, int n2) {
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(generatedMessageLite$GeneratedExtension);
        return generatedMessageLite$GeneratedExtension.singularFromFieldSetType(this.extensions.getRepeatedField(generatedMessageLite$GeneratedExtension.descriptor, n2));
    }

    protected boolean extensionsAreInitialized() {
        return this.extensions.isInitialized();
    }

    protected static void makeExtensionsImmutable(FieldSet fieldSet) {
        fieldSet.makeImmutable();
    }

    protected GeneratedMessageLite$ExtendableMessage$ExtensionWriter newExtensionWriter() {
        return new GeneratedMessageLite$ExtendableMessage$ExtensionWriter(this, false, null);
    }

    protected GeneratedMessageLite$ExtendableMessage$ExtensionWriter newMessageSetExtensionWriter() {
        return new GeneratedMessageLite$ExtendableMessage$ExtensionWriter(this, true, null);
    }

    protected int extensionsSerializedSize() {
        return this.extensions.getSerializedSize();
    }

    protected int extensionsSerializedSizeAsMessageSet() {
        return this.extensions.getMessageSetSerializedSize();
    }
}

