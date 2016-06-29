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

public interface Message$Builder extends MessageLite$Builder, MessageOrBuilder {
   Message$Builder clear();

   Message$Builder mergeFrom(Message var1);

   Message build();

   Message buildPartial();

   Message$Builder clone();

   Message$Builder mergeFrom(CodedInputStream var1);

   Message$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2);

   Descriptors$Descriptor getDescriptorForType();

   Message$Builder newBuilderForField(Descriptors$FieldDescriptor var1);

   Message$Builder getFieldBuilder(Descriptors$FieldDescriptor var1);

   Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor var1, int var2);

   Message$Builder setField(Descriptors$FieldDescriptor var1, Object var2);

   Message$Builder clearField(Descriptors$FieldDescriptor var1);

   Message$Builder clearOneof(Descriptors$OneofDescriptor var1);

   Message$Builder setRepeatedField(Descriptors$FieldDescriptor var1, int var2, Object var3);

   Message$Builder addRepeatedField(Descriptors$FieldDescriptor var1, Object var2);

   Message$Builder setUnknownFields(UnknownFieldSet var1);

   Message$Builder mergeUnknownFields(UnknownFieldSet var1);

   Message$Builder mergeFrom(ByteString var1);

   Message$Builder mergeFrom(ByteString var1, ExtensionRegistryLite var2);

   Message$Builder mergeFrom(byte[] var1);

   Message$Builder mergeFrom(byte[] var1, int var2, int var3);

   Message$Builder mergeFrom(byte[] var1, ExtensionRegistryLite var2);

   Message$Builder mergeFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4);

   Message$Builder mergeFrom(InputStream var1);

   Message$Builder mergeFrom(InputStream var1, ExtensionRegistryLite var2);

   boolean mergeDelimitedFrom(InputStream var1);

   boolean mergeDelimitedFrom(InputStream var1, ExtensionRegistryLite var2);
}
