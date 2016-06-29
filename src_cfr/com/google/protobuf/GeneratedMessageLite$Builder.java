/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite$Builder;

public abstract class GeneratedMessageLite$Builder
extends AbstractMessageLite$Builder {
    private final GeneratedMessageLite defaultInstance;
    protected GeneratedMessageLite instance;
    protected boolean isBuilt;

    protected GeneratedMessageLite$Builder(GeneratedMessageLite generatedMessageLite) {
        this.defaultInstance = generatedMessageLite;
        this.instance = (GeneratedMessageLite)generatedMessageLite.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_INSTANCE, new Object[0]);
        this.isBuilt = false;
    }

    protected void copyOnWrite() {
        if (!this.isBuilt) return;
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite)this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_INSTANCE, new Object[0]);
        generatedMessageLite.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MERGE_FROM, this.instance);
        this.instance = generatedMessageLite;
        this.isBuilt = false;
    }

    @Override
    public final boolean isInitialized() {
        return GeneratedMessageLite.isInitialized(this.instance, false);
    }

    @Override
    public final GeneratedMessageLite$Builder clear() {
        this.instance = (GeneratedMessageLite)this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_INSTANCE, new Object[0]);
        return this;
    }

    @Override
    public GeneratedMessageLite$Builder clone() {
        GeneratedMessageLite$Builder generatedMessageLite$Builder = this.getDefaultInstanceForType().newBuilderForType();
        generatedMessageLite$Builder.mergeFrom(this.buildPartial());
        return generatedMessageLite$Builder;
    }

    @Override
    public GeneratedMessageLite buildPartial() {
        this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MAKE_IMMUTABLE, new Object[0]);
        this.isBuilt = true;
        return this.instance;
    }

    @Override
    public final GeneratedMessageLite build() {
        GeneratedMessageLite generatedMessageLite = this.buildPartial();
        if (generatedMessageLite.isInitialized()) return generatedMessageLite;
        throw GeneratedMessageLite$Builder.newUninitializedMessageException(generatedMessageLite);
    }

    public GeneratedMessageLite$Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
        this.copyOnWrite();
        this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MERGE_FROM, generatedMessageLite);
        return this;
    }

    @Override
    public GeneratedMessageLite getDefaultInstanceForType() {
        return this.defaultInstance;
    }

    protected boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSetLite$Builder unknownFieldSetLite$Builder, ExtensionRegistryLite extensionRegistryLite, int n2) {
        return unknownFieldSetLite$Builder.mergeFieldFrom(n2, codedInputStream);
    }

    @Override
    public GeneratedMessageLite$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        GeneratedMessageLite generatedMessageLite = null;
        try {
            generatedMessageLite = (GeneratedMessageLite)this.getDefaultInstanceForType().getParserForType().parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            generatedMessageLite = (GeneratedMessageLite)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (generatedMessageLite != null) {
                this.mergeFrom(generatedMessageLite);
            }
        }
    }
}

