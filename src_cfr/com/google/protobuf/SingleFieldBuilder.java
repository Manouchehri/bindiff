/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;

public class SingleFieldBuilder
implements GeneratedMessage$BuilderParent {
    private GeneratedMessage$BuilderParent parent;
    private GeneratedMessage$Builder builder;
    private GeneratedMessage message;
    private boolean isClean;

    public SingleFieldBuilder(GeneratedMessage generatedMessage, GeneratedMessage$BuilderParent generatedMessage$BuilderParent, boolean bl2) {
        if (generatedMessage == null) {
            throw new NullPointerException();
        }
        this.message = generatedMessage;
        this.parent = generatedMessage$BuilderParent;
        this.isClean = bl2;
    }

    public void dispose() {
        this.parent = null;
    }

    public GeneratedMessage getMessage() {
        if (this.message != null) return this.message;
        this.message = (GeneratedMessage)this.builder.buildPartial();
        return this.message;
    }

    public GeneratedMessage build() {
        this.isClean = true;
        return this.getMessage();
    }

    public GeneratedMessage$Builder getBuilder() {
        if (this.builder != null) return this.builder;
        this.builder = (GeneratedMessage$Builder)this.message.newBuilderForType(this);
        this.builder.mergeFrom(this.message);
        this.builder.markClean();
        return this.builder;
    }

    public MessageOrBuilder getMessageOrBuilder() {
        if (this.builder == null) return this.message;
        return this.builder;
    }

    public SingleFieldBuilder setMessage(GeneratedMessage generatedMessage) {
        if (generatedMessage == null) {
            throw new NullPointerException();
        }
        this.message = generatedMessage;
        if (this.builder != null) {
            this.builder.dispose();
            this.builder = null;
        }
        this.onChanged();
        return this;
    }

    public SingleFieldBuilder mergeFrom(GeneratedMessage generatedMessage) {
        if (this.builder == null && this.message == this.message.getDefaultInstanceForType()) {
            this.message = generatedMessage;
        } else {
            this.getBuilder().mergeFrom(generatedMessage);
        }
        this.onChanged();
        return this;
    }

    public SingleFieldBuilder clear() {
        this.message = (GeneratedMessage)(this.message != null ? this.message.getDefaultInstanceForType() : this.builder.getDefaultInstanceForType());
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
        if (!this.isClean) return;
        if (this.parent == null) return;
        this.parent.markDirty();
        this.isClean = false;
    }

    @Override
    public void markDirty() {
        this.onChanged();
    }
}

