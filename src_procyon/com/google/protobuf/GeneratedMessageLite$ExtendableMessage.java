package com.google.protobuf;

public abstract class GeneratedMessageLite$ExtendableMessage extends GeneratedMessageLite implements GeneratedMessageLite$ExtendableMessageOrBuilder
{
    protected FieldSet extensions;
    
    public GeneratedMessageLite$ExtendableMessage() {
        this.extensions = FieldSet.newFieldSet();
    }
    
    protected final void mergeExtensionFields(final GeneratedMessageLite$ExtendableMessage generatedMessageLite$ExtendableMessage) {
        if (this.extensions.isImmutable()) {
            this.extensions = this.extensions.clone();
        }
        this.extensions.mergeFrom(generatedMessageLite$ExtendableMessage.extensions);
    }
    
    private void verifyExtensionContainingType(final GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension) {
        if (generatedMessageLite$GeneratedExtension.getContainingTypeDefaultInstance() != this.getDefaultInstanceForType()) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }
    
    public final boolean hasExtension(final ExtensionLite extensionLite) {
        final GeneratedMessageLite$GeneratedExtension access$000 = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(access$000);
        return this.extensions.hasField(access$000.descriptor);
    }
    
    public final int getExtensionCount(final ExtensionLite extensionLite) {
        final GeneratedMessageLite$GeneratedExtension access$000 = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(access$000);
        return this.extensions.getRepeatedFieldCount(access$000.descriptor);
    }
    
    public final Object getExtension(final ExtensionLite extensionLite) {
        final GeneratedMessageLite$GeneratedExtension access$000 = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(access$000);
        final Object field = this.extensions.getField(access$000.descriptor);
        if (field == null) {
            return access$000.defaultValue;
        }
        return access$000.fromFieldSetType(field);
    }
    
    public final Object getExtension(final ExtensionLite extensionLite, final int n) {
        final GeneratedMessageLite$GeneratedExtension access$000 = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType(access$000);
        return access$000.singularFromFieldSetType(this.extensions.getRepeatedField(access$000.descriptor, n));
    }
    
    protected boolean extensionsAreInitialized() {
        return this.extensions.isInitialized();
    }
    
    protected static void makeExtensionsImmutable(final FieldSet set) {
        set.makeImmutable();
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
