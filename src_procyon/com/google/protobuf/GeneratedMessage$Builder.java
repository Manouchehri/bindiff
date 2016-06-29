package com.google.protobuf;

import java.util.*;

public abstract class GeneratedMessage$Builder extends AbstractMessage$Builder
{
    private GeneratedMessage$BuilderParent builderParent;
    private GeneratedMessage$Builder$BuilderParentImpl meAsParent;
    private boolean isClean;
    private UnknownFieldSet unknownFields;
    
    protected GeneratedMessage$Builder() {
        this(null);
    }
    
    protected GeneratedMessage$Builder(final GeneratedMessage$BuilderParent builderParent) {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
        this.builderParent = builderParent;
    }
    
    void dispose() {
        this.builderParent = null;
    }
    
    protected void onBuilt() {
        if (this.builderParent != null) {
            this.markClean();
        }
    }
    
    protected void markClean() {
        this.isClean = true;
    }
    
    protected boolean isClean() {
        return this.isClean;
    }
    
    public GeneratedMessage$Builder clone() {
        final GeneratedMessage$Builder generatedMessage$Builder = (GeneratedMessage$Builder)this.getDefaultInstanceForType().newBuilderForType();
        generatedMessage$Builder.mergeFrom(this.buildPartial());
        return generatedMessage$Builder;
    }
    
    public GeneratedMessage$Builder clear() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
        this.onChanged();
        return this;
    }
    
    protected abstract GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable();
    
    public Descriptors$Descriptor getDescriptorForType() {
        return this.internalGetFieldAccessorTable().descriptor;
    }
    
    public Map getAllFields() {
        return Collections.unmodifiableMap((Map<?, ?>)this.getAllFieldsMutable());
    }
    
    private Map getAllFieldsMutable() {
        final TreeMap<Descriptors$FieldDescriptor, List> treeMap = new TreeMap<Descriptors$FieldDescriptor, List>();
        for (final Descriptors$FieldDescriptor descriptors$FieldDescriptor : this.internalGetFieldAccessorTable().descriptor.getFields()) {
            if (descriptors$FieldDescriptor.isRepeated()) {
                final List list = (List)this.getField(descriptors$FieldDescriptor);
                if (list.isEmpty()) {
                    continue;
                }
                treeMap.put(descriptors$FieldDescriptor, list);
            }
            else {
                if (!this.hasField(descriptors$FieldDescriptor)) {
                    continue;
                }
                treeMap.put(descriptors$FieldDescriptor, (List)this.getField(descriptors$FieldDescriptor));
            }
        }
        return treeMap;
    }
    
    public Message$Builder newBuilderForField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).newBuilder();
    }
    
    public Message$Builder getFieldBuilder(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).getBuilder(this);
    }
    
    public Message$Builder getRepeatedFieldBuilder(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n) {
        return this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).getRepeatedBuilder(this, n);
    }
    
    public boolean hasOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this.internalGetFieldAccessorTable().getOneof(descriptors$OneofDescriptor).has(this);
    }
    
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this.internalGetFieldAccessorTable().getOneof(descriptors$OneofDescriptor).get(this);
    }
    
    public boolean hasField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).has(this);
    }
    
    public Object getField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        final Object value = this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).get(this);
        if (descriptors$FieldDescriptor.isRepeated()) {
            return Collections.unmodifiableList((List<?>)value);
        }
        return value;
    }
    
    public GeneratedMessage$Builder setField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).set(this, o);
        return this;
    }
    
    public GeneratedMessage$Builder clearField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).clear(this);
        return this;
    }
    
    public GeneratedMessage$Builder clearOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.internalGetFieldAccessorTable().getOneof(descriptors$OneofDescriptor).clear(this);
        return this;
    }
    
    public int getRepeatedFieldCount(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).getRepeatedCount(this);
    }
    
    public Object getRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n) {
        return this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).getRepeated(this, n);
    }
    
    public GeneratedMessage$Builder setRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n, final Object o) {
        this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).setRepeated(this, n, o);
        return this;
    }
    
    public GeneratedMessage$Builder addRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).addRepeated(this, o);
        return this;
    }
    
    public GeneratedMessage$Builder setUnknownFields(final UnknownFieldSet unknownFields) {
        this.unknownFields = unknownFields;
        this.onChanged();
        return this;
    }
    
    public GeneratedMessage$Builder mergeUnknownFields(final UnknownFieldSet set) {
        this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(set).build();
        this.onChanged();
        return this;
    }
    
    public boolean isInitialized() {
        for (final Descriptors$FieldDescriptor descriptors$FieldDescriptor : this.getDescriptorForType().getFields()) {
            if (descriptors$FieldDescriptor.isRequired() && !this.hasField(descriptors$FieldDescriptor)) {
                return false;
            }
            if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                continue;
            }
            if (descriptors$FieldDescriptor.isRepeated()) {
                final Iterator iterator2 = ((List)this.getField(descriptors$FieldDescriptor)).iterator();
                while (iterator2.hasNext()) {
                    if (!iterator2.next().isInitialized()) {
                        return false;
                    }
                }
            }
            else {
                if (this.hasField(descriptors$FieldDescriptor) && !((Message)this.getField(descriptors$FieldDescriptor)).isInitialized()) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    protected boolean parseUnknownField(final CodedInputStream codedInputStream, final UnknownFieldSet$Builder unknownFieldSet$Builder, final ExtensionRegistryLite extensionRegistryLite, final int n) {
        return unknownFieldSet$Builder.mergeFieldFrom(n, codedInputStream);
    }
    
    protected GeneratedMessage$BuilderParent getParentForChildren() {
        if (this.meAsParent == null) {
            this.meAsParent = new GeneratedMessage$Builder$BuilderParentImpl(this, null);
        }
        return this.meAsParent;
    }
    
    protected final void onChanged() {
        if (this.isClean && this.builderParent != null) {
            this.builderParent.markDirty();
            this.isClean = false;
        }
    }
    
    protected MapField internalGetMapField(final int n) {
        final String s = "No map fields found in ";
        final String value = String.valueOf(this.getClass().getName());
        throw new RuntimeException((value.length() != 0) ? s.concat(value) : new String(s));
    }
    
    protected MapField internalGetMutableMapField(final int n) {
        final String s = "No map fields found in ";
        final String value = String.valueOf(this.getClass().getName());
        throw new RuntimeException((value.length() != 0) ? s.concat(value) : new String(s));
    }
}
