package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Struct$Builder extends GeneratedMessage$Builder implements StructOrBuilder
{
    private int bitField0_;
    private MapField fields_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }
    
    protected MapField internalGetMapField(final int n) {
        switch (n) {
            case 1: {
                return this.internalGetFields();
            }
            default: {
                throw new RuntimeException(new StringBuilder(37).append("Invalid map field number: ").append(n).toString());
            }
        }
    }
    
    protected MapField internalGetMutableMapField(final int n) {
        switch (n) {
            case 1: {
                return this.internalGetMutableFields();
            }
            default: {
                throw new RuntimeException(new StringBuilder(37).append("Invalid map field number: ").append(n).toString());
            }
        }
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Struct$Builder.class);
    }
    
    private Struct$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private Struct$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public Struct$Builder clear() {
        super.clear();
        this.internalGetMutableFields().clear();
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }
    
    public Struct getDefaultInstanceForType() {
        return Struct.getDefaultInstance();
    }
    
    public Struct build() {
        final Struct buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Struct buildPartial() {
        final Struct struct = new Struct(this, null);
        final int bitField0_ = this.bitField0_;
        struct.fields_ = this.internalGetFields();
        struct.fields_.makeImmutable();
        this.onBuilt();
        return struct;
    }
    
    public Struct$Builder mergeFrom(final Message message) {
        if (message instanceof Struct) {
            return this.mergeFrom((Struct)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Struct$Builder mergeFrom(final Struct struct) {
        if (struct == Struct.getDefaultInstance()) {
            return this;
        }
        this.internalGetMutableFields().mergeFrom(struct.internalGetFields());
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Struct$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Struct struct = null;
        try {
            struct = (Struct)Struct.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            struct = (Struct)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (struct != null) {
                this.mergeFrom(struct);
            }
        }
        return this;
    }
    
    private MapField internalGetFields() {
        if (this.fields_ == null) {
            return MapField.emptyMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
        }
        return this.fields_;
    }
    
    private MapField internalGetMutableFields() {
        this.onChanged();
        if (this.fields_ == null) {
            this.fields_ = MapField.newMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
        }
        if (!this.fields_.isMutable()) {
            this.fields_ = this.fields_.copy();
        }
        return this.fields_;
    }
    
    public Map getFields() {
        return this.internalGetFields().getMap();
    }
    
    public Map getMutableFields() {
        return this.internalGetMutableFields().getMutableMap();
    }
    
    public final Struct$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Struct$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
