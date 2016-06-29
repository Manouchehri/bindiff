/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.protobuf.Struct$1;
import com.google.protobuf.Struct$FieldsDefaultEntryHolder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import java.util.Map;

public final class Struct$Builder
extends GeneratedMessage$Builder
implements StructOrBuilder {
    private int bitField0_;
    private MapField fields_;

    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    @Override
    protected MapField internalGetMapField(int n2) {
        switch (n2) {
            case 1: {
                return this.internalGetFields();
            }
        }
        int n3 = n2;
        throw new RuntimeException(new StringBuilder(37).append("Invalid map field number: ").append(n3).toString());
    }

    @Override
    protected MapField internalGetMutableMapField(int n2) {
        switch (n2) {
            case 1: {
                return this.internalGetMutableFields();
            }
        }
        int n3 = n2;
        throw new RuntimeException(new StringBuilder(37).append("Invalid map field number: ").append(n3).toString());
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Struct$Builder.class);
    }

    private Struct$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Struct$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public Struct$Builder clear() {
        super.clear();
        this.internalGetMutableFields().clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    @Override
    public Struct getDefaultInstanceForType() {
        return Struct.getDefaultInstance();
    }

    @Override
    public Struct build() {
        Struct struct = this.buildPartial();
        if (struct.isInitialized()) return struct;
        throw Struct$Builder.newUninitializedMessageException(struct);
    }

    @Override
    public Struct buildPartial() {
        Struct struct = new Struct(this, null);
        int n2 = this.bitField0_;
        Struct.access$302(struct, this.internalGetFields());
        Struct.access$300(struct).makeImmutable();
        this.onBuilt();
        return struct;
    }

    @Override
    public Struct$Builder mergeFrom(Message message) {
        if (message instanceof Struct) {
            return this.mergeFrom((Struct)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Struct$Builder mergeFrom(Struct struct) {
        if (struct == Struct.getDefaultInstance()) {
            return this;
        }
        this.internalGetMutableFields().mergeFrom(Struct.access$400(struct));
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Struct$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Struct struct = null;
        try {
            try {
                struct = (Struct)Struct.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                struct = (Struct)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (struct == null) return this;
            this.mergeFrom(struct);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (struct == null) throw var5_7;
            this.mergeFrom(struct);
            throw var5_7;
        }
    }

    private MapField internalGetFields() {
        if (this.fields_ != null) return this.fields_;
        return MapField.emptyMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
    }

    private MapField internalGetMutableFields() {
        this.onChanged();
        if (this.fields_ == null) {
            this.fields_ = MapField.newMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
        }
        if (this.fields_.isMutable()) return this.fields_;
        this.fields_ = this.fields_.copy();
        return this.fields_;
    }

    @Override
    public Map getFields() {
        return this.internalGetFields().getMap();
    }

    public Map getMutableFields() {
        return this.internalGetMutableFields().getMutableMap();
    }

    @Override
    public final Struct$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Struct$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Struct$Builder(Struct$1 struct$1) {
        this();
    }

    /* synthetic */ Struct$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Struct$1 struct$1) {
        this(generatedMessage$BuilderParent);
    }
}

