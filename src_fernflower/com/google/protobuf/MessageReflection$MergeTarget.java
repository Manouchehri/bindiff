package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Message;
import com.google.protobuf.MessageReflection$MergeTarget$ContainerType;
import com.google.protobuf.WireFormat$Utf8Validation;

interface MessageReflection$MergeTarget {
   Descriptors$Descriptor getDescriptorForType();

   MessageReflection$MergeTarget$ContainerType getContainerType();

   ExtensionRegistry$ExtensionInfo findExtensionByName(ExtensionRegistry var1, String var2);

   ExtensionRegistry$ExtensionInfo findExtensionByNumber(ExtensionRegistry var1, Descriptors$Descriptor var2, int var3);

   Object getField(Descriptors$FieldDescriptor var1);

   boolean hasField(Descriptors$FieldDescriptor var1);

   MessageReflection$MergeTarget setField(Descriptors$FieldDescriptor var1, Object var2);

   MessageReflection$MergeTarget clearField(Descriptors$FieldDescriptor var1);

   MessageReflection$MergeTarget setRepeatedField(Descriptors$FieldDescriptor var1, int var2, Object var3);

   MessageReflection$MergeTarget addRepeatedField(Descriptors$FieldDescriptor var1, Object var2);

   boolean hasOneof(Descriptors$OneofDescriptor var1);

   MessageReflection$MergeTarget clearOneof(Descriptors$OneofDescriptor var1);

   Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1);

   Object parseGroup(CodedInputStream var1, ExtensionRegistryLite var2, Descriptors$FieldDescriptor var3, Message var4);

   Object parseMessage(CodedInputStream var1, ExtensionRegistryLite var2, Descriptors$FieldDescriptor var3, Message var4);

   Object parseMessageFromBytes(ByteString var1, ExtensionRegistryLite var2, Descriptors$FieldDescriptor var3, Message var4);

   WireFormat$Utf8Validation getUtf8Validation(Descriptors$FieldDescriptor var1);

   MessageReflection$MergeTarget newMergeTargetForField(Descriptors$FieldDescriptor var1, Message var2);

   Object finish();
}
