package com.google.protobuf;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;

public abstract class GeneratedMessageLite$ExtendableBuilder extends GeneratedMessageLite$Builder implements GeneratedMessageLite$ExtendableMessageOrBuilder
{
    protected GeneratedMessageLite$ExtendableBuilder(final GeneratedMessageLite$ExtendableMessage generatedMessageLite$ExtendableMessage) {
        super(generatedMessageLite$ExtendableMessage);
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions = ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.clone();
    }
    
    void internalSetExtensionSet(final FieldSet extensions) {
        this.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions = extensions;
    }
    
    protected void copyOnWrite() {
        if (!this.isBuilt) {
            return;
        }
        super.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions = ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.clone();
    }
    
    public final GeneratedMessageLite$ExtendableMessage buildPartial() {
        if (this.isBuilt) {
            return (GeneratedMessageLite$ExtendableMessage)this.instance;
        }
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.makeImmutable();
        return (GeneratedMessageLite$ExtendableMessage)super.buildPartial();
    }
    
    private void verifyExtensionContainingType(final GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension) {
        if (generatedMessageLite$GeneratedExtension.getContainingTypeDefaultInstance() != this.getDefaultInstanceForType()) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }
    
    public final boolean hasExtension(final ExtensionLite extensionLite) {
        return ((GeneratedMessageLite$ExtendableMessage)this.instance).hasExtension(extensionLite);
    }
    
    public final int getExtensionCount(final ExtensionLite extensionLite) {
        return ((GeneratedMessageLite$ExtendableMessage)this.instance).getExtensionCount(extensionLite);
    }
    
    public final Object getExtension(final ExtensionLite extensionLite) {
        return ((GeneratedMessageLite$ExtendableMessage)this.instance).getExtension(extensionLite);
    }
    
    public final Object getExtension(final ExtensionLite extensionLite, final int n) {
        return ((GeneratedMessageLite$ExtendableMessage)this.instance).getExtension(extensionLite, n);
    }
    
    public GeneratedMessageLite$ExtendableBuilder clone() {
        return (GeneratedMessageLite$ExtendableBuilder)super.clone();
    }
    
    public final GeneratedMessageLite$ExtendableBuilder setExtension(final ExtensionLite extensionLite, final Object o) {
        final GeneratedMessageLite$GeneratedExtension access$000 = checkIsLite(extensionLite);
        this.verifyExtensionContainingType(access$000);
        this.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.setField(access$000.descriptor, access$000.toFieldSetType(o));
        return this;
    }
    
    public final GeneratedMessageLite$ExtendableBuilder setExtension(final ExtensionLite extensionLite, final int n, final Object o) {
        final GeneratedMessageLite$GeneratedExtension access$000 = checkIsLite(extensionLite);
        this.verifyExtensionContainingType(access$000);
        this.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.setRepeatedField(access$000.descriptor, n, access$000.singularToFieldSetType(o));
        return this;
    }
    
    public final GeneratedMessageLite$ExtendableBuilder addExtension(final ExtensionLite extensionLite, final Object o) {
        final GeneratedMessageLite$GeneratedExtension access$000 = checkIsLite(extensionLite);
        this.verifyExtensionContainingType(access$000);
        this.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.addRepeatedField(access$000.descriptor, access$000.singularToFieldSetType(o));
        return this;
    }
    
    public final GeneratedMessageLite$ExtendableBuilder clearExtension(final ExtensionLite extensionLite) {
        final GeneratedMessageLite$GeneratedExtension access$000 = checkIsLite(extensionLite);
        this.verifyExtensionContainingType(access$000);
        this.copyOnWrite();
        ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.clearField(access$000.descriptor);
        return this;
    }
}
