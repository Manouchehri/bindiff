package com.google.protobuf;

public class SingleFieldBuilder implements GeneratedMessage$BuilderParent
{
    private GeneratedMessage$BuilderParent parent;
    private GeneratedMessage$Builder builder;
    private GeneratedMessage message;
    private boolean isClean;
    
    public SingleFieldBuilder(final GeneratedMessage message, final GeneratedMessage$BuilderParent parent, final boolean isClean) {
        if (message == null) {
            throw new NullPointerException();
        }
        this.message = message;
        this.parent = parent;
        this.isClean = isClean;
    }
    
    public void dispose() {
        this.parent = null;
    }
    
    public GeneratedMessage getMessage() {
        if (this.message == null) {
            this.message = (GeneratedMessage)this.builder.buildPartial();
        }
        return this.message;
    }
    
    public GeneratedMessage build() {
        this.isClean = true;
        return this.getMessage();
    }
    
    public GeneratedMessage$Builder getBuilder() {
        if (this.builder == null) {
            (this.builder = (GeneratedMessage$Builder)this.message.newBuilderForType(this)).mergeFrom(this.message);
            this.builder.markClean();
        }
        return this.builder;
    }
    
    public MessageOrBuilder getMessageOrBuilder() {
        if (this.builder != null) {
            return this.builder;
        }
        return this.message;
    }
    
    public SingleFieldBuilder setMessage(final GeneratedMessage message) {
        if (message == null) {
            throw new NullPointerException();
        }
        this.message = message;
        if (this.builder != null) {
            this.builder.dispose();
            this.builder = null;
        }
        this.onChanged();
        return this;
    }
    
    public SingleFieldBuilder mergeFrom(final GeneratedMessage message) {
        if (this.builder == null && this.message == this.message.getDefaultInstanceForType()) {
            this.message = message;
        }
        else {
            this.getBuilder().mergeFrom(message);
        }
        this.onChanged();
        return this;
    }
    
    public SingleFieldBuilder clear() {
        this.message = (GeneratedMessage)((this.message != null) ? this.message.getDefaultInstanceForType() : this.builder.getDefaultInstanceForType());
        if (this.builder != null) {
            this.builder.dispose();
            this.builder = null;
        }
        this.onChanged();
        return this;
    }
    
    private void onChanged() {
        if (this.builder != null) {
            this.message = null;
        }
        if (this.isClean && this.parent != null) {
            this.parent.markDirty();
            this.isClean = false;
        }
    }
    
    public void markDirty() {
        this.onChanged();
    }
}
