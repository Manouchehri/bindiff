/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;

public interface Message$Builder
extends MessageLite$Builder,
MessageOrBuilder {
    @Override
    public Message$Builder clear();

    public Message$Builder mergeFrom(Message var1);

    @Override
    public Message build();

    @Override
    public Message buildPartial();

    @Override
    public Message$Builder clone();

    @Override
    public Message$Builder mergeFrom(CodedInputStream var1);

    @Override
    public Message$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2);

    @Override
    public Descriptors$Descriptor getDescriptorForType();

    public Message$Builder newBuilderForField(Descriptors$FieldDescriptor var1);

    public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor var1);

    public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor var1, int var2);

    public Message$Builder setField(Descriptors$FieldDescriptor var1, Object var2);

    public Message$Builder clearField(Descriptors$FieldDescriptor var1);

    public Message$Builder clearOneof(Descriptors$OneofDescriptor var1);

    public Message$Builder setRepeatedField(Descriptors$FieldDescriptor var1, int var2, Object var3);

    public Message$Builder addRepeatedField(Descriptors$FieldDescriptor var1, Object var2);

    public Message$Builder setUnknownFields(UnknownFieldSet var1);

    public Message$Builder mergeUnknownFields(UnknownFieldSet var1);

    @Override
    public Message$Builder mergeFrom(ByteString var1);

    @Override
    public Message$Builder mergeFrom(ByteString var1, ExtensionRegistryLite var2);

    @Override
    public Message$Builder mergeFrom(byte[] var1);

    @Override
    public Message$Builder mergeFrom(byte[] var1, int var2, int var3);

    @Override
    public Message$Builder mergeFrom(byte[] var1, ExtensionRegistryLite var2);

    @Override
    public Message$Builder mergeFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4);

    @Override
    public Message$Builder mergeFrom(InputStream var1);

    @Override
    public Message$Builder mergeFrom(InputStream var1, ExtensionRegistryLite var2);

    @Override
    public boolean mergeDelimitedFrom(InputStream var1);

    @Override
    public boolean mergeDelimitedFrom(InputStream var1, ExtensionRegistryLite var2);
}

