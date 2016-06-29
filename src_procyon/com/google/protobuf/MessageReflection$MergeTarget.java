package com.google.protobuf;

interface MessageReflection$MergeTarget
{
    Descriptors$Descriptor getDescriptorForType();
    
    MessageReflection$MergeTarget$ContainerType getContainerType();
    
    ExtensionRegistry$ExtensionInfo findExtensionByName(final ExtensionRegistry p0, final String p1);
    
    ExtensionRegistry$ExtensionInfo findExtensionByNumber(final ExtensionRegistry p0, final Descriptors$Descriptor p1, final int p2);
    
    Object getField(final Descriptors$FieldDescriptor p0);
    
    boolean hasField(final Descriptors$FieldDescriptor p0);
    
    MessageReflection$MergeTarget setField(final Descriptors$FieldDescriptor p0, final Object p1);
    
    MessageReflection$MergeTarget clearField(final Descriptors$FieldDescriptor p0);
    
    MessageReflection$MergeTarget setRepeatedField(final Descriptors$FieldDescriptor p0, final int p1, final Object p2);
    
    MessageReflection$MergeTarget addRepeatedField(final Descriptors$FieldDescriptor p0, final Object p1);
    
    boolean hasOneof(final Descriptors$OneofDescriptor p0);
    
    MessageReflection$MergeTarget clearOneof(final Descriptors$OneofDescriptor p0);
    
    Descriptors$FieldDescriptor getOneofFieldDescriptor(final Descriptors$OneofDescriptor p0);
    
    Object parseGroup(final CodedInputStream p0, final ExtensionRegistryLite p1, final Descriptors$FieldDescriptor p2, final Message p3);
    
    Object parseMessage(final CodedInputStream p0, final ExtensionRegistryLite p1, final Descriptors$FieldDescriptor p2, final Message p3);
    
    Object parseMessageFromBytes(final ByteString p0, final ExtensionRegistryLite p1, final Descriptors$FieldDescriptor p2, final Message p3);
    
    WireFormat$Utf8Validation getUtf8Validation(final Descriptors$FieldDescriptor p0);
    
    MessageReflection$MergeTarget newMergeTargetForField(final Descriptors$FieldDescriptor p0, final Message p1);
    
    Object finish();
}
