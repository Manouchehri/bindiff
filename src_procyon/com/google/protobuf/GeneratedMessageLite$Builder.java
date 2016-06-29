package com.google.protobuf;

public abstract class GeneratedMessageLite$Builder extends AbstractMessageLite$Builder
{
    private final GeneratedMessageLite defaultInstance;
    protected GeneratedMessageLite instance;
    protected boolean isBuilt;
    
    protected GeneratedMessageLite$Builder(final GeneratedMessageLite defaultInstance) {
        this.defaultInstance = defaultInstance;
        this.instance = (GeneratedMessageLite)defaultInstance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_INSTANCE, new Object[0]);
        this.isBuilt = false;
    }
    
    protected void copyOnWrite() {
        if (this.isBuilt) {
            final GeneratedMessageLite instance = (GeneratedMessageLite)this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_INSTANCE, new Object[0]);
            instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MERGE_FROM, this.instance);
            this.instance = instance;
            this.isBuilt = false;
        }
    }
    
    public final boolean isInitialized() {
        return GeneratedMessageLite.isInitialized(this.instance, false);
    }
    
    public final GeneratedMessageLite$Builder clear() {
        this.instance = (GeneratedMessageLite)this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_INSTANCE, new Object[0]);
        return this;
    }
    
    public GeneratedMessageLite$Builder clone() {
        final GeneratedMessageLite$Builder builderForType = this.getDefaultInstanceForType().newBuilderForType();
        builderForType.mergeFrom(this.buildPartial());
        return builderForType;
    }
    
    public GeneratedMessageLite buildPartial() {
        this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MAKE_IMMUTABLE, new Object[0]);
        this.isBuilt = true;
        return this.instance;
    }
    
    public final GeneratedMessageLite build() {
        final GeneratedMessageLite buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessageLite$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public GeneratedMessageLite$Builder mergeFrom(final GeneratedMessageLite generatedMessageLite) {
        this.copyOnWrite();
        this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MERGE_FROM, generatedMessageLite);
        return this;
    }
    
    public GeneratedMessageLite getDefaultInstanceForType() {
        return this.defaultInstance;
    }
    
    protected boolean parseUnknownField(final CodedInputStream codedInputStream, final UnknownFieldSetLite$Builder unknownFieldSetLite$Builder, final ExtensionRegistryLite extensionRegistryLite, final int n) {
        return unknownFieldSetLite$Builder.mergeFieldFrom(n, codedInputStream);
    }
    
    public GeneratedMessageLite$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        GeneratedMessageLite generatedMessageLite = null;
        try {
            generatedMessageLite = (GeneratedMessageLite)this.getDefaultInstanceForType().getParserForType().parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            generatedMessageLite = (GeneratedMessageLite)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (generatedMessageLite != null) {
                this.mergeFrom(generatedMessageLite);
            }
        }
        return this;
    }
}
