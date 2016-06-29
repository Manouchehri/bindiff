package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DynamicMessage$Builder extends AbstractMessage$Builder
{
    private final Descriptors$Descriptor type;
    private FieldSet fields;
    private final Descriptors$FieldDescriptor[] oneofCases;
    private UnknownFieldSet unknownFields;
    
    private DynamicMessage$Builder(final Descriptors$Descriptor type) {
        this.type = type;
        this.fields = FieldSet.newFieldSet();
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
        this.oneofCases = new Descriptors$FieldDescriptor[type.toProto().getOneofDeclCount()];
    }
    
    public DynamicMessage$Builder clear() {
        if (this.fields.isImmutable()) {
            this.fields = FieldSet.newFieldSet();
        }
        else {
            this.fields.clear();
        }
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
        return this;
    }
    
    public DynamicMessage$Builder mergeFrom(final Message message) {
        if (!(message instanceof DynamicMessage)) {
            return (DynamicMessage$Builder)super.mergeFrom(message);
        }
        final DynamicMessage dynamicMessage = (DynamicMessage)message;
        if (dynamicMessage.type != this.type) {
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
        this.ensureIsMutable();
        this.fields.mergeFrom(dynamicMessage.fields);
        this.mergeUnknownFields(dynamicMessage.unknownFields);
        for (int i = 0; i < this.oneofCases.length; ++i) {
            if (this.oneofCases[i] == null) {
                this.oneofCases[i] = dynamicMessage.oneofCases[i];
            }
            else if (dynamicMessage.oneofCases[i] != null && this.oneofCases[i] != dynamicMessage.oneofCases[i]) {
                this.fields.clearField(this.oneofCases[i]);
                this.oneofCases[i] = dynamicMessage.oneofCases[i];
            }
        }
        return this;
    }
    
    public DynamicMessage build() {
        if (!this.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(new DynamicMessage(this.type, this.fields, Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields));
        }
        return this.buildPartial();
    }
    
    private DynamicMessage buildParsed() {
        if (!this.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(new DynamicMessage(this.type, this.fields, Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields)).asInvalidProtocolBufferException();
        }
        return this.buildPartial();
    }
    
    public DynamicMessage buildPartial() {
        this.fields.makeImmutable();
        return new DynamicMessage(this.type, this.fields, Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields);
    }
    
    public DynamicMessage$Builder clone() {
        final DynamicMessage$Builder dynamicMessage$Builder = new DynamicMessage$Builder(this.type);
        dynamicMessage$Builder.fields.mergeFrom(this.fields);
        dynamicMessage$Builder.mergeUnknownFields(this.unknownFields);
        System.arraycopy(this.oneofCases, 0, dynamicMessage$Builder.oneofCases, 0, this.oneofCases.length);
        return dynamicMessage$Builder;
    }
    
    public boolean isInitialized() {
        return DynamicMessage.isInitialized(this.type, this.fields);
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return this.type;
    }
    
    public DynamicMessage getDefaultInstanceForType() {
        return DynamicMessage.getDefaultInstance(this.type);
    }
    
    public Map getAllFields() {
        return this.fields.getAllFields();
    }
    
    public DynamicMessage$Builder newBuilderForField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }
        return new DynamicMessage$Builder(descriptors$FieldDescriptor.getMessageType());
    }
    
    public boolean hasOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        return this.oneofCases[descriptors$OneofDescriptor.getIndex()] != null;
    }
    
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        return this.oneofCases[descriptors$OneofDescriptor.getIndex()];
    }
    
    public DynamicMessage$Builder clearOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        final Descriptors$FieldDescriptor descriptors$FieldDescriptor = this.oneofCases[descriptors$OneofDescriptor.getIndex()];
        if (descriptors$FieldDescriptor != null) {
            this.clearField(descriptors$FieldDescriptor);
        }
        return this;
    }
    
    public boolean hasField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.hasField(descriptors$FieldDescriptor);
    }
    
    public Object getField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        Object o = this.fields.getField(descriptors$FieldDescriptor);
        if (o == null) {
            if (descriptors$FieldDescriptor.isRepeated()) {
                o = Collections.emptyList();
            }
            else if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                o = DynamicMessage.getDefaultInstance(descriptors$FieldDescriptor.getMessageType());
            }
            else {
                o = descriptors$FieldDescriptor.getDefaultValue();
            }
        }
        return o;
    }
    
    public DynamicMessage$Builder setField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        if (descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.ENUM) {
            this.ensureEnumValueDescriptor(descriptors$FieldDescriptor, o);
        }
        final Descriptors$OneofDescriptor containingOneof = descriptors$FieldDescriptor.getContainingOneof();
        if (containingOneof != null) {
            final int index = containingOneof.getIndex();
            final Descriptors$FieldDescriptor descriptors$FieldDescriptor2 = this.oneofCases[index];
            if (descriptors$FieldDescriptor2 != null && descriptors$FieldDescriptor2 != descriptors$FieldDescriptor) {
                this.fields.clearField(descriptors$FieldDescriptor2);
            }
            this.oneofCases[index] = descriptors$FieldDescriptor;
        }
        this.fields.setField(descriptors$FieldDescriptor, o);
        return this;
    }
    
    public DynamicMessage$Builder clearField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        final Descriptors$OneofDescriptor containingOneof = descriptors$FieldDescriptor.getContainingOneof();
        if (containingOneof != null) {
            final int index = containingOneof.getIndex();
            if (this.oneofCases[index] == descriptors$FieldDescriptor) {
                this.oneofCases[index] = null;
            }
        }
        this.fields.clearField(descriptors$FieldDescriptor);
        return this;
    }
    
    public int getRepeatedFieldCount(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedFieldCount(descriptors$FieldDescriptor);
    }
    
    public Object getRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedField(descriptors$FieldDescriptor, n);
    }
    
    public DynamicMessage$Builder setRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n, final Object o) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        this.fields.setRepeatedField(descriptors$FieldDescriptor, n, o);
        return this;
    }
    
    public DynamicMessage$Builder addRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        this.fields.addRepeatedField(descriptors$FieldDescriptor, o);
        return this;
    }
    
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    public DynamicMessage$Builder setUnknownFields(final UnknownFieldSet unknownFields) {
        if (this.getDescriptorForType().getFile().getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO3) {
            return this;
        }
        this.unknownFields = unknownFields;
        return this;
    }
    
    public DynamicMessage$Builder mergeUnknownFields(final UnknownFieldSet set) {
        if (this.getDescriptorForType().getFile().getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO3) {
            return this;
        }
        this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(set).build();
        return this;
    }
    
    private void verifyContainingType(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() != this.type) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }
    
    private void verifyOneofContainingType(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        if (descriptors$OneofDescriptor.getContainingType() != this.type) {
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }
    }
    
    private void ensureSingularEnumValueDescriptor(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (!(o instanceof Descriptors$EnumValueDescriptor)) {
            throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
        }
    }
    
    private void ensureEnumValueDescriptor(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        if (descriptors$FieldDescriptor.isRepeated()) {
            final Iterator<Object> iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                this.ensureSingularEnumValueDescriptor(descriptors$FieldDescriptor, iterator.next());
            }
        }
        else {
            this.ensureSingularEnumValueDescriptor(descriptors$FieldDescriptor, o);
        }
    }
    
    private void ensureIsMutable() {
        if (this.fields.isImmutable()) {
            this.fields = this.fields.clone();
        }
    }
    
    public Message$Builder getFieldBuilder(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
    }
    
    public Message$Builder getRepeatedFieldBuilder(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n) {
        throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
    }
}
