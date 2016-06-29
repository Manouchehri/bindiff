package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.Map;

public interface MessageOrBuilder extends MessageLiteOrBuilder {
   Message getDefaultInstanceForType();

   List findInitializationErrors();

   String getInitializationErrorString();

   Descriptors$Descriptor getDescriptorForType();

   Map getAllFields();

   boolean hasOneof(Descriptors$OneofDescriptor var1);

   Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1);

   boolean hasField(Descriptors$FieldDescriptor var1);

   Object getField(Descriptors$FieldDescriptor var1);

   int getRepeatedFieldCount(Descriptors$FieldDescriptor var1);

   Object getRepeatedField(Descriptors$FieldDescriptor var1, int var2);

   UnknownFieldSet getUnknownFields();
}
