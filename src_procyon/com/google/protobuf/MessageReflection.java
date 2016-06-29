package com.google.protobuf;

import java.util.*;
import java.io.*;

class MessageReflection
{
    static void writeMessageTo(final Message message, Map treeMap, final CodedOutputStream codedOutputStream, final boolean b) {
        final boolean messageSetWireFormat = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        if (b) {
            treeMap = new TreeMap<Descriptors$FieldDescriptor, Object>(treeMap);
            for (final Descriptors$FieldDescriptor descriptors$FieldDescriptor : message.getDescriptorForType().getFields()) {
                if (descriptors$FieldDescriptor.isRequired() && !treeMap.containsKey(descriptors$FieldDescriptor)) {
                    treeMap.put(descriptors$FieldDescriptor, message.getField(descriptors$FieldDescriptor));
                }
            }
        }
        for (final Map.Entry<Descriptors$FieldDescriptor, Object> entry : treeMap.entrySet()) {
            final Descriptors$FieldDescriptor descriptors$FieldDescriptor2 = entry.getKey();
            final Message value = entry.getValue();
            if (messageSetWireFormat && descriptors$FieldDescriptor2.isExtension() && descriptors$FieldDescriptor2.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && !descriptors$FieldDescriptor2.isRepeated()) {
                codedOutputStream.writeMessageSetExtension(descriptors$FieldDescriptor2.getNumber(), value);
            }
            else {
                FieldSet.writeField(descriptors$FieldDescriptor2, value, codedOutputStream);
            }
        }
        final UnknownFieldSet unknownFields = message.getUnknownFields();
        if (messageSetWireFormat) {
            unknownFields.writeAsMessageSetTo(codedOutputStream);
        }
        else {
            unknownFields.writeTo(codedOutputStream);
        }
    }
    
    static int getSerializedSize(final Message message, final Map map) {
        int n = 0;
        final boolean messageSetWireFormat = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        for (final Map.Entry<Descriptors$FieldDescriptor, V> entry : map.entrySet()) {
            final Descriptors$FieldDescriptor descriptors$FieldDescriptor = entry.getKey();
            final V value = entry.getValue();
            if (messageSetWireFormat && descriptors$FieldDescriptor.isExtension() && descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && !descriptors$FieldDescriptor.isRepeated()) {
                n += CodedOutputStream.computeMessageSetExtensionSize(descriptors$FieldDescriptor.getNumber(), (MessageLite)value);
            }
            else {
                n += FieldSet.computeFieldSize(descriptors$FieldDescriptor, value);
            }
        }
        final UnknownFieldSet unknownFields = message.getUnknownFields();
        int n2;
        if (messageSetWireFormat) {
            n2 = n + unknownFields.getSerializedSizeAsMessageSet();
        }
        else {
            n2 = n + unknownFields.getSerializedSize();
        }
        return n2;
    }
    
    static String delimitWithCommas(final List list) {
        final StringBuilder sb = new StringBuilder();
        for (final String s : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(s);
        }
        return sb.toString();
    }
    
    static boolean isInitialized(final MessageOrBuilder messageOrBuilder) {
        for (final Descriptors$FieldDescriptor descriptors$FieldDescriptor : messageOrBuilder.getDescriptorForType().getFields()) {
            if (descriptors$FieldDescriptor.isRequired() && !messageOrBuilder.hasField(descriptors$FieldDescriptor)) {
                return false;
            }
        }
        for (final Map.Entry<Descriptors$FieldDescriptor, V> entry : messageOrBuilder.getAllFields().entrySet()) {
            final Descriptors$FieldDescriptor descriptors$FieldDescriptor2 = entry.getKey();
            if (descriptors$FieldDescriptor2.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                if (descriptors$FieldDescriptor2.isRepeated()) {
                    final Iterator iterator3 = ((List)entry.getValue()).iterator();
                    while (iterator3.hasNext()) {
                        if (!iterator3.next().isInitialized()) {
                            return false;
                        }
                    }
                }
                else {
                    if (!((Message)entry.getValue()).isInitialized()) {
                        return false;
                    }
                    continue;
                }
            }
        }
        return true;
    }
    
    private static String subMessagePrefix(final String s, final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n) {
        final StringBuilder sb = new StringBuilder(s);
        if (descriptors$FieldDescriptor.isExtension()) {
            sb.append('(').append(descriptors$FieldDescriptor.getFullName()).append(')');
        }
        else {
            sb.append(descriptors$FieldDescriptor.getName());
        }
        if (n != -1) {
            sb.append('[').append(n).append(']');
        }
        sb.append('.');
        return sb.toString();
    }
    
    private static void findMissingFields(final MessageOrBuilder messageOrBuilder, final String s, final List list) {
        for (final Descriptors$FieldDescriptor descriptors$FieldDescriptor : messageOrBuilder.getDescriptorForType().getFields()) {
            if (descriptors$FieldDescriptor.isRequired() && !messageOrBuilder.hasField(descriptors$FieldDescriptor)) {
                final String value = String.valueOf(s);
                final String value2 = String.valueOf(descriptors$FieldDescriptor.getName());
                list.add((value2.length() != 0) ? value.concat(value2) : new String(value));
            }
        }
        for (final Map.Entry<K, MessageOrBuilder> entry : messageOrBuilder.getAllFields().entrySet()) {
            final Descriptors$FieldDescriptor descriptors$FieldDescriptor2 = (Descriptors$FieldDescriptor)entry.getKey();
            final MessageOrBuilder value3 = entry.getValue();
            if (descriptors$FieldDescriptor2.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                if (descriptors$FieldDescriptor2.isRepeated()) {
                    int n = 0;
                    final Iterator<Object> iterator3 = ((List<Object>)value3).iterator();
                    while (iterator3.hasNext()) {
                        findMissingFields(iterator3.next(), subMessagePrefix(s, descriptors$FieldDescriptor2, n++), list);
                    }
                }
                else {
                    if (!messageOrBuilder.hasField(descriptors$FieldDescriptor2)) {
                        continue;
                    }
                    findMissingFields(value3, subMessagePrefix(s, descriptors$FieldDescriptor2, -1), list);
                }
            }
        }
    }
    
    static List findMissingFields(final MessageOrBuilder messageOrBuilder) {
        final ArrayList list = new ArrayList();
        findMissingFields(messageOrBuilder, "", list);
        return list;
    }
    
    static boolean mergeFieldFrom(final CodedInputStream codedInputStream, final UnknownFieldSet$Builder unknownFieldSet$Builder, final ExtensionRegistryLite extensionRegistryLite, final Descriptors$Descriptor descriptors$Descriptor, final MessageReflection$MergeTarget messageReflection$MergeTarget, final int n) {
        if (descriptors$Descriptor.getOptions().getMessageSetWireFormat() && n == WireFormat.MESSAGE_SET_ITEM_TAG) {
            mergeMessageSetExtensionFromCodedStream(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, descriptors$Descriptor, messageReflection$MergeTarget);
            return true;
        }
        final int tagWireType = WireFormat.getTagWireType(n);
        final int tagFieldNumber = WireFormat.getTagFieldNumber(n);
        Message defaultInstance = null;
        Descriptors$FieldDescriptor descriptors$FieldDescriptor;
        if (descriptors$Descriptor.isExtensionNumber(tagFieldNumber)) {
            if (extensionRegistryLite instanceof ExtensionRegistry) {
                final ExtensionRegistry$ExtensionInfo extensionByNumber = messageReflection$MergeTarget.findExtensionByNumber((ExtensionRegistry)extensionRegistryLite, descriptors$Descriptor, tagFieldNumber);
                if (extensionByNumber == null) {
                    descriptors$FieldDescriptor = null;
                }
                else {
                    descriptors$FieldDescriptor = extensionByNumber.descriptor;
                    defaultInstance = extensionByNumber.defaultInstance;
                    if (defaultInstance == null && descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                        final String s = "Message-typed extension lacked default instance: ";
                        final String value = String.valueOf(descriptors$FieldDescriptor.getFullName());
                        throw new IllegalStateException((value.length() != 0) ? s.concat(value) : new String(s));
                    }
                }
            }
            else {
                descriptors$FieldDescriptor = null;
            }
        }
        else if (messageReflection$MergeTarget.getContainerType() == MessageReflection$MergeTarget$ContainerType.MESSAGE) {
            descriptors$FieldDescriptor = descriptors$Descriptor.findFieldByNumber(tagFieldNumber);
        }
        else {
            descriptors$FieldDescriptor = null;
        }
        boolean b = false;
        boolean b2 = false;
        if (descriptors$FieldDescriptor == null) {
            b = true;
        }
        else if (tagWireType == FieldSet.getWireFormatForFieldType(descriptors$FieldDescriptor.getLiteType(), false)) {
            b2 = false;
        }
        else if (descriptors$FieldDescriptor.isPackable() && tagWireType == FieldSet.getWireFormatForFieldType(descriptors$FieldDescriptor.getLiteType(), true)) {
            b2 = true;
        }
        else {
            b = true;
        }
        if (b) {
            return unknownFieldSet$Builder.mergeFieldFrom(n, codedInputStream);
        }
        if (b2) {
            final int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
            if (descriptors$FieldDescriptor.getLiteType() == WireFormat$FieldType.ENUM) {
                while (codedInputStream.getBytesUntilLimit() > 0) {
                    final int enum1 = codedInputStream.readEnum();
                    if (descriptors$FieldDescriptor.getFile().supportsUnknownEnumValue()) {
                        messageReflection$MergeTarget.addRepeatedField(descriptors$FieldDescriptor, descriptors$FieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(enum1));
                    }
                    else {
                        final Descriptors$EnumValueDescriptor valueByNumber = descriptors$FieldDescriptor.getEnumType().findValueByNumber(enum1);
                        if (valueByNumber == null) {
                            return true;
                        }
                        messageReflection$MergeTarget.addRepeatedField(descriptors$FieldDescriptor, valueByNumber);
                    }
                }
            }
            else {
                while (codedInputStream.getBytesUntilLimit() > 0) {
                    messageReflection$MergeTarget.addRepeatedField(descriptors$FieldDescriptor, WireFormat.readPrimitiveField(codedInputStream, descriptors$FieldDescriptor.getLiteType(), messageReflection$MergeTarget.getUtf8Validation(descriptors$FieldDescriptor)));
                }
            }
            codedInputStream.popLimit(pushLimit);
        }
        else {
            Object o = null;
            switch (MessageReflection$1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[descriptors$FieldDescriptor.getType().ordinal()]) {
                case 1: {
                    o = messageReflection$MergeTarget.parseGroup(codedInputStream, extensionRegistryLite, descriptors$FieldDescriptor, defaultInstance);
                    break;
                }
                case 2: {
                    o = messageReflection$MergeTarget.parseMessage(codedInputStream, extensionRegistryLite, descriptors$FieldDescriptor, defaultInstance);
                    break;
                }
                case 3: {
                    final int enum2 = codedInputStream.readEnum();
                    if (descriptors$FieldDescriptor.getFile().supportsUnknownEnumValue()) {
                        o = descriptors$FieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(enum2);
                        break;
                    }
                    o = descriptors$FieldDescriptor.getEnumType().findValueByNumber(enum2);
                    if (o == null) {
                        unknownFieldSet$Builder.mergeVarintField(tagFieldNumber, enum2);
                        return true;
                    }
                    break;
                }
                default: {
                    o = WireFormat.readPrimitiveField(codedInputStream, descriptors$FieldDescriptor.getLiteType(), messageReflection$MergeTarget.getUtf8Validation(descriptors$FieldDescriptor));
                    break;
                }
            }
            if (descriptors$FieldDescriptor.isRepeated()) {
                messageReflection$MergeTarget.addRepeatedField(descriptors$FieldDescriptor, o);
            }
            else {
                messageReflection$MergeTarget.setField(descriptors$FieldDescriptor, o);
            }
        }
        return true;
    }
    
    private static void mergeMessageSetExtensionFromCodedStream(final CodedInputStream codedInputStream, final UnknownFieldSet$Builder unknownFieldSet$Builder, final ExtensionRegistryLite extensionRegistryLite, final Descriptors$Descriptor descriptors$Descriptor, final MessageReflection$MergeTarget messageReflection$MergeTarget) {
        int uInt32 = 0;
        ByteString bytes = null;
        ExtensionRegistry$ExtensionInfo extensionByNumber = null;
        while (true) {
            final int tag = codedInputStream.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                uInt32 = codedInputStream.readUInt32();
                if (uInt32 == 0 || !(extensionRegistryLite instanceof ExtensionRegistry)) {
                    continue;
                }
                extensionByNumber = messageReflection$MergeTarget.findExtensionByNumber((ExtensionRegistry)extensionRegistryLite, descriptors$Descriptor, uInt32);
            }
            else if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (uInt32 != 0 && extensionByNumber != null && ExtensionRegistryLite.isEagerlyParseMessageSets()) {
                    eagerlyMergeMessageSetExtension(codedInputStream, extensionByNumber, extensionRegistryLite, messageReflection$MergeTarget);
                    bytes = null;
                }
                else {
                    bytes = codedInputStream.readBytes();
                }
            }
            else {
                if (!codedInputStream.skipField(tag)) {
                    break;
                }
                continue;
            }
        }
        codedInputStream.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
        if (bytes != null && uInt32 != 0) {
            if (extensionByNumber != null) {
                mergeMessageSetExtensionFromBytes(bytes, extensionByNumber, extensionRegistryLite, messageReflection$MergeTarget);
            }
            else if (bytes != null) {
                unknownFieldSet$Builder.mergeField(uInt32, UnknownFieldSet$Field.newBuilder().addLengthDelimited(bytes).build());
            }
        }
    }
    
    private static void mergeMessageSetExtensionFromBytes(final ByteString byteString, final ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo, final ExtensionRegistryLite extensionRegistryLite, final MessageReflection$MergeTarget messageReflection$MergeTarget) {
        final Descriptors$FieldDescriptor descriptor = extensionRegistry$ExtensionInfo.descriptor;
        if (messageReflection$MergeTarget.hasField(descriptor) || ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            messageReflection$MergeTarget.setField(descriptor, messageReflection$MergeTarget.parseMessageFromBytes(byteString, extensionRegistryLite, descriptor, extensionRegistry$ExtensionInfo.defaultInstance));
        }
        else {
            messageReflection$MergeTarget.setField(descriptor, new LazyField(extensionRegistry$ExtensionInfo.defaultInstance, extensionRegistryLite, byteString));
        }
    }
    
    private static void eagerlyMergeMessageSetExtension(final CodedInputStream codedInputStream, final ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo, final ExtensionRegistryLite extensionRegistryLite, final MessageReflection$MergeTarget messageReflection$MergeTarget) {
        final Descriptors$FieldDescriptor descriptor = extensionRegistry$ExtensionInfo.descriptor;
        messageReflection$MergeTarget.setField(descriptor, messageReflection$MergeTarget.parseMessage(codedInputStream, extensionRegistryLite, descriptor, extensionRegistry$ExtensionInfo.defaultInstance));
    }
}
