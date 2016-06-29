/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage$1;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DynamicMessage$Builder
extends AbstractMessage$Builder {
    private final Descriptors$Descriptor type;
    private FieldSet fields;
    private final Descriptors$FieldDescriptor[] oneofCases;
    private UnknownFieldSet unknownFields;

    private DynamicMessage$Builder(Descriptors$Descriptor descriptors$Descriptor) {
        this.type = descriptors$Descriptor;
        this.fields = FieldSet.newFieldSet();
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
        this.oneofCases = new Descriptors$FieldDescriptor[descriptors$Descriptor.toProto().getOneofDeclCount()];
    }

    @Override
    public DynamicMessage$Builder clear() {
        if (this.fields.isImmutable()) {
            this.fields = FieldSet.newFieldSet();
        } else {
            this.fields.clear();
        }
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
        return this;
    }

    @Override
    public DynamicMessage$Builder mergeFrom(Message message) {
        if (!(message instanceof DynamicMessage)) return (DynamicMessage$Builder)super.mergeFrom(message);
        DynamicMessage dynamicMessage = (DynamicMessage)message;
        if (DynamicMessage.access$200(dynamicMessage) != this.type) {
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
        this.ensureIsMutable();
        this.fields.mergeFrom(DynamicMessage.access$300(dynamicMessage));
        this.mergeUnknownFields(DynamicMessage.access$400(dynamicMessage));
        int n2 = 0;
        while (n2 < this.oneofCases.length) {
            if (this.oneofCases[n2] == null) {
                this.oneofCases[n2] = DynamicMessage.access$500(dynamicMessage)[n2];
            } else if (DynamicMessage.access$500(dynamicMessage)[n2] != null && this.oneofCases[n2] != DynamicMessage.access$500(dynamicMessage)[n2]) {
                this.fields.clearField(this.oneofCases[n2]);
                this.oneofCases[n2] = DynamicMessage.access$500(dynamicMessage)[n2];
            }
            ++n2;
        }
        return this;
    }

    @Override
    public DynamicMessage build() {
        if (this.isInitialized()) return this.buildPartial();
        throw DynamicMessage$Builder.newUninitializedMessageException(new DynamicMessage(this.type, this.fields, Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields));
    }

    private DynamicMessage buildParsed() {
        if (this.isInitialized()) return this.buildPartial();
        throw DynamicMessage$Builder.newUninitializedMessageException(new DynamicMessage(this.type, this.fields, Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields)).asInvalidProtocolBufferException();
    }

    @Override
    public DynamicMessage buildPartial() {
        this.fields.makeImmutable();
        return new DynamicMessage(this.type, this.fields, Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields);
    }

    @Override
    public DynamicMessage$Builder clone() {
        DynamicMessage$Builder dynamicMessage$Builder = new DynamicMessage$Builder(this.type);
        dynamicMessage$Builder.fields.mergeFrom(this.fields);
        dynamicMessage$Builder.mergeUnknownFields(this.unknownFields);
        System.arraycopy(this.oneofCases, 0, dynamicMessage$Builder.oneofCases, 0, this.oneofCases.length);
        return dynamicMessage$Builder;
    }

    @Override
    public boolean isInitialized() {
        return DynamicMessage.isInitialized(this.type, this.fields);
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return this.type;
    }

    @Override
    public DynamicMessage getDefaultInstanceForType() {
        return DynamicMessage.getDefaultInstance(this.type);
    }

    @Override
    public Map getAllFields() {
        return this.fields.getAllFields();
    }

    @Override
    public DynamicMessage$Builder newBuilderForField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) return new DynamicMessage$Builder(descriptors$FieldDescriptor.getMessageType());
        throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
    }

    @Override
    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = this.oneofCases[descriptors$OneofDescriptor.getIndex()];
        if (descriptors$FieldDescriptor != null) return true;
        return false;
    }

    @Override
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        return this.oneofCases[descriptors$OneofDescriptor.getIndex()];
    }

    @Override
    public DynamicMessage$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = this.oneofCases[descriptors$OneofDescriptor.getIndex()];
        if (descriptors$FieldDescriptor == null) return this;
        this.clearField(descriptors$FieldDescriptor);
        return this;
    }

    @Override
    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.hasField(descriptors$FieldDescriptor);
    }

    @Override
    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        List list = this.fields.getField(descriptors$FieldDescriptor);
        if (list != null) return list;
        if (descriptors$FieldDescriptor.isRepeated()) {
            return Collections.emptyList();
        }
        if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) return descriptors$FieldDescriptor.getDefaultValue();
        return DynamicMessage.getDefaultInstance(descriptors$FieldDescriptor.getMessageType());
    }

    @Override
    public DynamicMessage$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        Descriptors$OneofDescriptor descriptors$OneofDescriptor;
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        if (descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.ENUM) {
            this.ensureEnumValueDescriptor(descriptors$FieldDescriptor, object);
        }
        if ((descriptors$OneofDescriptor = descriptors$FieldDescriptor.getContainingOneof()) != null) {
            int n2 = descriptors$OneofDescriptor.getIndex();
            Descriptors$FieldDescriptor descriptors$FieldDescriptor2 = this.oneofCases[n2];
            if (descriptors$FieldDescriptor2 != null && descriptors$FieldDescriptor2 != descriptors$FieldDescriptor) {
                this.fields.clearField(descriptors$FieldDescriptor2);
            }
            this.oneofCases[n2] = descriptors$FieldDescriptor;
        }
        this.fields.setField(descriptors$FieldDescriptor, object);
        return this;
    }

    @Override
    public DynamicMessage$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        int n2;
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        Descriptors$OneofDescriptor descriptors$OneofDescriptor = descriptors$FieldDescriptor.getContainingOneof();
        if (descriptors$OneofDescriptor != null && this.oneofCases[n2 = descriptors$OneofDescriptor.getIndex()] == descriptors$FieldDescriptor) {
            this.oneofCases[n2] = null;
        }
        this.fields.clearField(descriptors$FieldDescriptor);
        return this;
    }

    @Override
    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedFieldCount(descriptors$FieldDescriptor);
    }

    @Override
    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedField(descriptors$FieldDescriptor, n2);
    }

    @Override
    public DynamicMessage$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2, Object object) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        this.fields.setRepeatedField(descriptors$FieldDescriptor, n2, object);
        return this;
    }

    @Override
    public DynamicMessage$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        this.fields.addRepeatedField(descriptors$FieldDescriptor, object);
        return this;
    }

    @Override
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override
    public DynamicMessage$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        if (this.getDescriptorForType().getFile().getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO3) {
            return this;
        }
        this.unknownFields = unknownFieldSet;
        return this;
    }

    @Override
    public DynamicMessage$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        if (this.getDescriptorForType().getFile().getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO3) {
            return this;
        }
        this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFieldSet).build();
        return this;
    }

    private void verifyContainingType(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() == this.type) return;
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }

    private void verifyOneofContainingType(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        if (descriptors$OneofDescriptor.getContainingType() == this.type) return;
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }

    private void ensureSingularEnumValueDescriptor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (object instanceof Descriptors$EnumValueDescriptor) return;
        throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
    }

    private void ensureEnumValueDescriptor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        if (!descriptors$FieldDescriptor.isRepeated()) {
            this.ensureSingularEnumValueDescriptor(descriptors$FieldDescriptor, object);
            return;
        }
        Iterator iterator = ((List)object).iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            this.ensureSingularEnumValueDescriptor(descriptors$FieldDescriptor, e2);
        }
    }

    private void ensureIsMutable() {
        if (!this.fields.isImmutable()) return;
        this.fields = this.fields.clone();
    }

    @Override
    public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
    }

    @Override
    public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2) {
        throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
    }

    static /* synthetic */ DynamicMessage access$000(DynamicMessage$Builder dynamicMessage$Builder) {
        return dynamicMessage$Builder.buildParsed();
    }

    /* synthetic */ DynamicMessage$Builder(Descriptors$Descriptor descriptors$Descriptor, DynamicMessage$1 dynamicMessage$1) {
        this(descriptors$Descriptor);
    }
}

