/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$Builder$BuilderParentImpl;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessage$Builder
extends AbstractMessage$Builder {
    private GeneratedMessage$BuilderParent builderParent;
    private GeneratedMessage$Builder$BuilderParentImpl meAsParent;
    private boolean isClean;
    private UnknownFieldSet unknownFields = UnknownFieldSet.getDefaultInstance();

    protected GeneratedMessage$Builder() {
        this(null);
    }

    protected GeneratedMessage$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        this.builderParent = generatedMessage$BuilderParent;
    }

    void dispose() {
        this.builderParent = null;
    }

    protected void onBuilt() {
        if (this.builderParent == null) return;
        this.markClean();
    }

    protected void markClean() {
        this.isClean = true;
    }

    protected boolean isClean() {
        return this.isClean;
    }

    @Override
    public GeneratedMessage$Builder clone() {
        GeneratedMessage$Builder generatedMessage$Builder = (GeneratedMessage$Builder)this.getDefaultInstanceForType().newBuilderForType();
        generatedMessage$Builder.mergeFrom((Message)this.buildPartial());
        return generatedMessage$Builder;
    }

    @Override
    public GeneratedMessage$Builder clear() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
        this.onChanged();
        return this;
    }

    protected abstract GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable();

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
    }

    @Override
    public Map getAllFields() {
        return Collections.unmodifiableMap(this.getAllFieldsMutable());
    }

    private Map getAllFieldsMutable() {
        TreeMap<Descriptors$FieldDescriptor, Object> treeMap = new TreeMap<Descriptors$FieldDescriptor, Object>();
        Descriptors$Descriptor descriptors$Descriptor = GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
        Iterator<E> iterator = descriptors$Descriptor.getFields().iterator();
        while (iterator.hasNext()) {
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)iterator.next();
            if (descriptors$FieldDescriptor.isRepeated()) {
                List list = (List)this.getField(descriptors$FieldDescriptor);
                if (list.isEmpty()) continue;
                treeMap.put(descriptors$FieldDescriptor, list);
                continue;
            }
            if (!this.hasField(descriptors$FieldDescriptor)) continue;
            treeMap.put(descriptors$FieldDescriptor, this.getField(descriptors$FieldDescriptor));
        }
        return treeMap;
    }

    @Override
    public Message$Builder newBuilderForField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).newBuilder();
    }

    @Override
    public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getBuilder(this);
    }

    @Override
    public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeatedBuilder(this, n2);
    }

    @Override
    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).has(this);
    }

    @Override
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).get(this);
    }

    @Override
    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).has(this);
    }

    @Override
    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        Object object = GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).get(this);
        if (!descriptors$FieldDescriptor.isRepeated()) return object;
        return Collections.unmodifiableList((List)object);
    }

    @Override
    public GeneratedMessage$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).set(this, object);
        return this;
    }

    @Override
    public GeneratedMessage$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).clear(this);
        return this;
    }

    @Override
    public GeneratedMessage$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).clear(this);
        return this;
    }

    @Override
    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeatedCount(this);
    }

    @Override
    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeated(this, n2);
    }

    @Override
    public GeneratedMessage$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2, Object object) {
        GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).setRepeated(this, n2, object);
        return this;
    }

    @Override
    public GeneratedMessage$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).addRepeated(this, object);
        return this;
    }

    @Override
    public GeneratedMessage$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        this.unknownFields = unknownFieldSet;
        this.onChanged();
        return this;
    }

    @Override
    public GeneratedMessage$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFieldSet).build();
        this.onChanged();
        return this;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean isInitialized() {
        var1_1 = this.getDescriptorForType().getFields().iterator();
        do lbl-1000: // 4 sources:
        {
            if (var1_1.hasNext() == false) return true;
            var2_2 = (Descriptors$FieldDescriptor)var1_1.next();
            if (var2_2.isRequired() && !this.hasField(var2_2)) {
                return false;
            }
            if (var2_2.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) ** GOTO lbl-1000
            if (!var2_2.isRepeated()) continue;
            var3_3 = (List)this.getField(var2_2);
            var4_4 = var3_3.iterator();
            do {
                if (!var4_4.hasNext()) ** GOTO lbl-1000
            } while ((var5_5 = (Message)var4_4.next()).isInitialized());
            return false;
        } while (!this.hasField(var2_2) || ((Message)this.getField(var2_2)).isInitialized());
        return false;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    protected boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet$Builder unknownFieldSet$Builder, ExtensionRegistryLite extensionRegistryLite, int n2) {
        return unknownFieldSet$Builder.mergeFieldFrom(n2, codedInputStream);
    }

    protected GeneratedMessage$BuilderParent getParentForChildren() {
        if (this.meAsParent != null) return this.meAsParent;
        this.meAsParent = new GeneratedMessage$Builder$BuilderParentImpl(this, null);
        return this.meAsParent;
    }

    protected final void onChanged() {
        if (!this.isClean) return;
        if (this.builderParent == null) return;
        this.builderParent.markDirty();
        this.isClean = false;
    }

    protected MapField internalGetMapField(int n2) {
        String string;
        String string2 = String.valueOf(this.getClass().getName());
        if (string2.length() != 0) {
            string = "No map fields found in ".concat(string2);
            throw new RuntimeException(string);
        }
        string = new String("No map fields found in ");
        throw new RuntimeException(string);
    }

    protected MapField internalGetMutableMapField(int n2) {
        String string;
        String string2 = String.valueOf(this.getClass().getName());
        if (string2.length() != 0) {
            string = "No map fields found in ".concat(string2);
            throw new RuntimeException(string);
        }
        string = new String("No map fields found in ");
        throw new RuntimeException(string);
    }

    static /* synthetic */ Map access$900(GeneratedMessage$Builder generatedMessage$Builder) {
        return generatedMessage$Builder.getAllFieldsMutable();
    }
}

