/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;

public abstract class GeneratedMessageLite$ExtendableBuilder
extends GeneratedMessageLite$Builder
implements GeneratedMessageLite$ExtendableMessageOrBuilder {
    protected GeneratedMessageLite$ExtendableBuilder(GeneratedMessageLite$ExtendableMessage generatedMessageLite$ExtendableMessage) {
        super(generatedMessageLite$ExtendableMessage);
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions = ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.clone();
    }

    void internalSetExtensionSet(FieldSet fieldSet) {
        this.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions = fieldSet;
    }

    @Override
    protected void copyOnWrite() {
        if (!this.isBuilt) {
            return;
        }
        super.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions = ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.clone();
    }

    @Override
    public final GeneratedMessageLite$ExtendableMessage buildPartial() {
        if (this.isBuilt) {
            return (GeneratedMessageLite$ExtendableMessage)this.instance;
        }
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.makeImmutable();
        return (GeneratedMessageLite$ExtendableMessage)super.buildPartial();
    }

    private void verifyExtensionContainingType(GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension) {
        if (generatedMessageLite$GeneratedExtension.getContainingTypeDefaultInstance() == this.getDefaultInstanceForType()) return;
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }

    @Override
    public final boolean hasExtension(ExtensionLite extensionLite) {
        return ((GeneratedMessageLite$ExtendableMessage)this.instance).hasExtension(extensionLite);
    }

    @Override
    public final int getExtensionCount(ExtensionLite extensionLite) {
        return ((GeneratedMessageLite$ExtendableMessage)this.instance).getExtensionCount(extensionLite);
    }

    @Override
    public final Object getExtension(ExtensionLite extensionLite) {
        return ((GeneratedMessageLite$ExtendableMessage)this.instance).getExtension(extensionLite);
    }

    @Override
    public final Object getExtension(ExtensionLite extensionLite, int n2) {
        return ((GeneratedMessageLite$ExtendableMessage)this.instance).getExtension(extensionLite, n2);
    }

    @Override
    public GeneratedMessageLite$ExtendableBuilder clone() {
        return (GeneratedMessageLite$ExtendableBuilder)super.clone();
    }

    public final GeneratedMessageLite$ExtendableBuilder setExtension(ExtensionLite extensionLite, Object object) {
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(generatedMessageLite$GeneratedExtension);
        this.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.setField(generatedMessageLite$GeneratedExtension.descriptor, generatedMessageLite$GeneratedExtension.toFieldSetType(object));
        return this;
    }

    public final GeneratedMessageLite$ExtendableBuilder setExtension(ExtensionLite extensionLite, int n2, Object object) {
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(generatedMessageLite$GeneratedExtension);
        this.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.setRepeatedField(generatedMessageLite$GeneratedExtension.descriptor, n2, generatedMessageLite$GeneratedExtension.singularToFieldSetType(object));
        return this;
    }

    public final GeneratedMessageLite$ExtendableBuilder addExtension(ExtensionLite extensionLite, Object object) {
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(generatedMessageLite$GeneratedExtension);
        this.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.addRepeatedField(generatedMessageLite$GeneratedExtension.descriptor, generatedMessageLite$GeneratedExtension.singularToFieldSetType(object));
        return this;
    }

    public final GeneratedMessageLite$ExtendableBuilder clearExtension(ExtensionLite extensionLite) {
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(generatedMessageLite$GeneratedExtension);
        this.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.clearField(generatedMessageLite$GeneratedExtension.descriptor);
        return this;
    }
}

