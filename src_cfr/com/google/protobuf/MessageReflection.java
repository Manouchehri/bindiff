/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.LazyField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.MessageReflection$1;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.MessageReflection$MergeTarget$ContainerType;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.UnknownFieldSet$Field;
import com.google.protobuf.UnknownFieldSet$Field$Builder;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$Utf8Validation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class MessageReflection {
    MessageReflection() {
    }

    static void writeMessageTo(Message message, Map treeMap, CodedOutputStream codedOutputStream, boolean bl2) {
        boolean bl3 = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        if (bl2) {
            treeMap = new TreeMap<Object, Object>((Map<Object, Object>)treeMap);
            for (Descriptors$FieldDescriptor object : message.getDescriptorForType().getFields()) {
                if (!object.isRequired() || treeMap.containsKey(object)) continue;
                treeMap.put(object, message.getField(object));
            }
        }
        for (Map.Entry<Object, Object> entry : treeMap.entrySet()) {
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)entry.getKey();
            Object object = entry.getValue();
            if (bl3 && descriptors$FieldDescriptor.isExtension() && descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && !descriptors$FieldDescriptor.isRepeated()) {
                codedOutputStream.writeMessageSetExtension(descriptors$FieldDescriptor.getNumber(), (Message)object);
                continue;
            }
            FieldSet.writeField(descriptors$FieldDescriptor, object, codedOutputStream);
        }
        UnknownFieldSet unknownFieldSet = message.getUnknownFields();
        if (bl3) {
            unknownFieldSet.writeAsMessageSetTo(codedOutputStream);
            return;
        }
        unknownFieldSet.writeTo(codedOutputStream);
    }

    static int getSerializedSize(Message message, Map map) {
        int n2 = 0;
        boolean bl2 = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        for (Map.Entry entry : map.entrySet()) {
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)entry.getKey();
            Object v2 = entry.getValue();
            if (bl2 && descriptors$FieldDescriptor.isExtension() && descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && !descriptors$FieldDescriptor.isRepeated()) {
                n2 += CodedOutputStream.computeMessageSetExtensionSize(descriptors$FieldDescriptor.getNumber(), (Message)v2);
                continue;
            }
            n2 += FieldSet.computeFieldSize(descriptors$FieldDescriptor, v2);
        }
        UnknownFieldSet unknownFieldSet = message.getUnknownFields();
        if (bl2) {
            return n2 += unknownFieldSet.getSerializedSizeAsMessageSet();
        }
        n2 += unknownFieldSet.getSerializedSize();
        return n2;
    }

    static String delimitWithCommas(List list) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    /*
     * Unable to fully structure code
     */
    static boolean isInitialized(MessageOrBuilder var0) {
        for (Object var2_2 : var0.getDescriptorForType().getFields()) {
            if (!var2_2.isRequired() || var0.hasField((Descriptors$FieldDescriptor)var2_2)) continue;
            return false;
        }
        var1_1 = var0.getAllFields().entrySet().iterator();
        do lbl-1000: // 4 sources:
        {
            if (var1_1.hasNext() == false) return true;
            var2_2 = (Map.Entry)var1_1.next();
            var3_3 = (Descriptors$FieldDescriptor)var2_2.getKey();
            if (var3_3.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) ** GOTO lbl-1000
            if (!var3_3.isRepeated()) continue;
            var4_4 = ((List)var2_2.getValue()).iterator();
            do {
                if (!var4_4.hasNext()) ** GOTO lbl-1000
            } while ((var5_5 = (Message)var4_4.next()).isInitialized());
            return false;
        } while (((Message)var2_2.getValue()).isInitialized());
        return false;
    }

    private static String subMessagePrefix(String string, Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2) {
        StringBuilder stringBuilder = new StringBuilder(string);
        if (descriptors$FieldDescriptor.isExtension()) {
            stringBuilder.append('(').append(descriptors$FieldDescriptor.getFullName()).append(')');
        } else {
            stringBuilder.append(descriptors$FieldDescriptor.getName());
        }
        if (n2 != -1) {
            stringBuilder.append('[').append(n2).append(']');
        }
        stringBuilder.append('.');
        return stringBuilder.toString();
    }

    private static void findMissingFields(MessageOrBuilder messageOrBuilder, String string, List list) {
        for (Object object2 : messageOrBuilder.getDescriptorForType().getFields()) {
            if (!object2.isRequired() || messageOrBuilder.hasField((Descriptors$FieldDescriptor)object2)) continue;
            String string2 = String.valueOf(string);
            String string3 = String.valueOf(object2.getName());
            list.add(string3.length() != 0 ? string2.concat(string3) : new String(string2));
        }
        Iterator iterator = messageOrBuilder.getAllFields().entrySet().iterator();
        block1 : while (iterator.hasNext()) {
            Object object2;
            object2 = (Map.Entry)iterator.next();
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)object2.getKey();
            Object v2 = object2.getValue();
            if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) continue;
            if (descriptors$FieldDescriptor.isRepeated()) {
                int n2 = 0;
                Iterator iterator2 = ((List)v2).iterator();
                do {
                    if (!iterator2.hasNext()) continue block1;
                    Object e2 = iterator2.next();
                    MessageReflection.findMissingFields((MessageOrBuilder)e2, MessageReflection.subMessagePrefix(string, descriptors$FieldDescriptor, n2++), list);
                } while (true);
            }
            if (!messageOrBuilder.hasField(descriptors$FieldDescriptor)) continue;
            MessageReflection.findMissingFields((MessageOrBuilder)v2, MessageReflection.subMessagePrefix(string, descriptors$FieldDescriptor, -1), list);
        }
    }

    static List findMissingFields(MessageOrBuilder messageOrBuilder) {
        ArrayList arrayList = new ArrayList();
        MessageReflection.findMissingFields(messageOrBuilder, "", arrayList);
        return arrayList;
    }

    static boolean mergeFieldFrom(CodedInputStream codedInputStream, UnknownFieldSet$Builder unknownFieldSet$Builder, ExtensionRegistryLite extensionRegistryLite, Descriptors$Descriptor descriptors$Descriptor, MessageReflection$MergeTarget messageReflection$MergeTarget, int n2) {
        Object object;
        Descriptors$FieldDescriptor descriptors$FieldDescriptor;
        if (descriptors$Descriptor.getOptions().getMessageSetWireFormat() && n2 == WireFormat.MESSAGE_SET_ITEM_TAG) {
            MessageReflection.mergeMessageSetExtensionFromCodedStream(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, descriptors$Descriptor, messageReflection$MergeTarget);
            return true;
        }
        int n3 = WireFormat.getTagWireType(n2);
        int n4 = WireFormat.getTagFieldNumber(n2);
        Message message = null;
        if (descriptors$Descriptor.isExtensionNumber(n4)) {
            if (!(extensionRegistryLite instanceof ExtensionRegistry)) return unknownFieldSet$Builder.mergeFieldFrom(n2, codedInputStream);
            ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo = messageReflection$MergeTarget.findExtensionByNumber((ExtensionRegistry)extensionRegistryLite, descriptors$Descriptor, n4);
            if (extensionRegistry$ExtensionInfo == null) {
                return unknownFieldSet$Builder.mergeFieldFrom(n2, codedInputStream);
            }
            descriptors$FieldDescriptor = extensionRegistry$ExtensionInfo.descriptor;
            message = extensionRegistry$ExtensionInfo.defaultInstance;
            if (message == null && descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                String string;
                String string2 = String.valueOf(descriptors$FieldDescriptor.getFullName());
                if (string2.length() != 0) {
                    string = "Message-typed extension lacked default instance: ".concat(string2);
                    throw new IllegalStateException(string);
                }
                string = new String("Message-typed extension lacked default instance: ");
                throw new IllegalStateException(string);
            }
        } else {
            if (messageReflection$MergeTarget.getContainerType() != MessageReflection$MergeTarget$ContainerType.MESSAGE) return unknownFieldSet$Builder.mergeFieldFrom(n2, codedInputStream);
            descriptors$FieldDescriptor = descriptors$Descriptor.findFieldByNumber(n4);
        }
        boolean bl2 = false;
        boolean bl3 = false;
        if (descriptors$FieldDescriptor == null) {
            return unknownFieldSet$Builder.mergeFieldFrom(n2, codedInputStream);
        }
        if (n3 == FieldSet.getWireFormatForFieldType(descriptors$FieldDescriptor.getLiteType(), false)) {
            bl3 = false;
        } else {
            if (!descriptors$FieldDescriptor.isPackable()) return unknownFieldSet$Builder.mergeFieldFrom(n2, codedInputStream);
            if (n3 != FieldSet.getWireFormatForFieldType(descriptors$FieldDescriptor.getLiteType(), true)) return unknownFieldSet$Builder.mergeFieldFrom(n2, codedInputStream);
            bl3 = true;
        }
        if (bl2) {
            return unknownFieldSet$Builder.mergeFieldFrom(n2, codedInputStream);
        }
        switch (MessageReflection$1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[descriptors$FieldDescriptor.getType().ordinal()]) {
            case 1: {
                object = messageReflection$MergeTarget.parseGroup(codedInputStream, extensionRegistryLite, descriptors$FieldDescriptor, message);
                break;
            }
            case 2: {
                object = messageReflection$MergeTarget.parseMessage(codedInputStream, extensionRegistryLite, descriptors$FieldDescriptor, message);
                break;
            }
            case 3: {
                int n5 = codedInputStream.readEnum();
                if (descriptors$FieldDescriptor.getFile().supportsUnknownEnumValue()) {
                    object = descriptors$FieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(n5);
                    break;
                }
                object = descriptors$FieldDescriptor.getEnumType().findValueByNumber(n5);
                if (object != null) break;
                unknownFieldSet$Builder.mergeVarintField(n4, n5);
                return true;
            }
            default: {
                object = WireFormat.readPrimitiveField(codedInputStream, descriptors$FieldDescriptor.getLiteType(), messageReflection$MergeTarget.getUtf8Validation(descriptors$FieldDescriptor));
            }
        }
        if (descriptors$FieldDescriptor.isRepeated()) {
            messageReflection$MergeTarget.addRepeatedField(descriptors$FieldDescriptor, object);
            return true;
        }
        messageReflection$MergeTarget.setField(descriptors$FieldDescriptor, object);
        return true;
    }

    private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream codedInputStream, UnknownFieldSet$Builder unknownFieldSet$Builder, ExtensionRegistryLite extensionRegistryLite, Descriptors$Descriptor descriptors$Descriptor, MessageReflection$MergeTarget messageReflection$MergeTarget) {
        int n2;
        int n3 = 0;
        ByteString byteString = null;
        ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo = null;
        while ((n2 = codedInputStream.readTag()) != 0) {
            if (n2 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                n3 = codedInputStream.readUInt32();
                if (n3 == 0 || !(extensionRegistryLite instanceof ExtensionRegistry)) continue;
                extensionRegistry$ExtensionInfo = messageReflection$MergeTarget.findExtensionByNumber((ExtensionRegistry)extensionRegistryLite, descriptors$Descriptor, n3);
                continue;
            }
            if (n2 == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (n3 != 0 && extensionRegistry$ExtensionInfo != null && ExtensionRegistryLite.isEagerlyParseMessageSets()) {
                    MessageReflection.eagerlyMergeMessageSetExtension(codedInputStream, extensionRegistry$ExtensionInfo, extensionRegistryLite, messageReflection$MergeTarget);
                    byteString = null;
                    continue;
                }
                byteString = codedInputStream.readBytes();
                continue;
            }
            if (codedInputStream.skipField(n2)) continue;
        }
        codedInputStream.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
        if (byteString == null) return;
        if (n3 == 0) return;
        if (extensionRegistry$ExtensionInfo != null) {
            MessageReflection.mergeMessageSetExtensionFromBytes(byteString, extensionRegistry$ExtensionInfo, extensionRegistryLite, messageReflection$MergeTarget);
            return;
        }
        if (byteString == null) return;
        unknownFieldSet$Builder.mergeField(n3, UnknownFieldSet$Field.newBuilder().addLengthDelimited(byteString).build());
    }

    private static void mergeMessageSetExtensionFromBytes(ByteString byteString, ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo, ExtensionRegistryLite extensionRegistryLite, MessageReflection$MergeTarget messageReflection$MergeTarget) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = extensionRegistry$ExtensionInfo.descriptor;
        boolean bl2 = messageReflection$MergeTarget.hasField(descriptors$FieldDescriptor);
        if (!bl2 && !ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            LazyField lazyField = new LazyField(extensionRegistry$ExtensionInfo.defaultInstance, extensionRegistryLite, byteString);
            messageReflection$MergeTarget.setField(descriptors$FieldDescriptor, lazyField);
            return;
        }
        Object object = messageReflection$MergeTarget.parseMessageFromBytes(byteString, extensionRegistryLite, descriptors$FieldDescriptor, extensionRegistry$ExtensionInfo.defaultInstance);
        messageReflection$MergeTarget.setField(descriptors$FieldDescriptor, object);
    }

    private static void eagerlyMergeMessageSetExtension(CodedInputStream codedInputStream, ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo, ExtensionRegistryLite extensionRegistryLite, MessageReflection$MergeTarget messageReflection$MergeTarget) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = extensionRegistry$ExtensionInfo.descriptor;
        Object object = messageReflection$MergeTarget.parseMessage(codedInputStream, extensionRegistryLite, descriptors$FieldDescriptor, extensionRegistry$ExtensionInfo.defaultInstance);
        messageReflection$MergeTarget.setField(descriptors$FieldDescriptor, object);
    }
}

