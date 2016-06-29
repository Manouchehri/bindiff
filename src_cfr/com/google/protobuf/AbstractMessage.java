/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Message;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.TextFormat;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMessage
extends AbstractMessageLite
implements Message {
    protected int memoizedSize = -1;

    @Override
    public boolean isInitialized() {
        return MessageReflection.isInitialized(this);
    }

    @Override
    public List findInitializationErrors() {
        return MessageReflection.findMissingFields(this);
    }

    @Override
    public String getInitializationErrorString() {
        return MessageReflection.delimitWithCommas(this.findInitializationErrors());
    }

    @Override
    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }

    @Override
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }

    @Override
    public final String toString() {
        return TextFormat.printToString(this);
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        MessageReflection.writeMessageTo(this, this.getAllFields(), codedOutputStream, false);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSize;
        if (n2 != -1) {
            return n2;
        }
        this.memoizedSize = MessageReflection.getSerializedSize(this, this.getAllFields());
        return this.memoizedSize;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Message)) {
            return false;
        }
        Message message = (Message)object;
        if (this.getDescriptorForType() != message.getDescriptorForType()) {
            return false;
        }
        if (!AbstractMessage.compareFields(this.getAllFields(), message.getAllFields())) return false;
        if (!this.getUnknownFields().equals(message.getUnknownFields())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int n2 = this.memoizedHashCode;
        if (n2 != 0) return n2;
        n2 = 41;
        n2 = 19 * n2 + this.getDescriptorForType().hashCode();
        n2 = AbstractMessage.hashFields(n2, this.getAllFields());
        this.memoizedHashCode = n2 = 29 * n2 + this.getUnknownFields().hashCode();
        return n2;
    }

    private static ByteString toByteString(Object object) {
        if (!(object instanceof byte[])) return (ByteString)object;
        return ByteString.copyFrom((byte[])object);
    }

    private static boolean compareBytes(Object object, Object object2) {
        if (!(object instanceof byte[])) return AbstractMessage.toByteString(object).equals(AbstractMessage.toByteString(object2));
        if (!(object2 instanceof byte[])) return AbstractMessage.toByteString(object).equals(AbstractMessage.toByteString(object2));
        return Arrays.equals((byte[])object, (byte[])object2);
    }

    private static Map convertMapEntryListToMap(List list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Iterator iterator = list.iterator();
        Message message = (Message)iterator.next();
        Descriptors$Descriptor descriptors$Descriptor = message.getDescriptorForType();
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = descriptors$Descriptor.findFieldByName("key");
        Descriptors$FieldDescriptor descriptors$FieldDescriptor2 = descriptors$Descriptor.findFieldByName("value");
        hashMap.put(message.getField(descriptors$FieldDescriptor), message.getField(descriptors$FieldDescriptor2));
        while (iterator.hasNext()) {
            message = (Message)iterator.next();
            hashMap.put(message.getField(descriptors$FieldDescriptor), message.getField(descriptors$FieldDescriptor2));
        }
        return hashMap;
    }

    private static boolean compareMapField(Object object, Object object2) {
        Map map = AbstractMessage.convertMapEntryListToMap((List)object);
        Map map2 = AbstractMessage.convertMapEntryListToMap((List)object2);
        return MapFieldLite.equals(map, map2);
    }

    /*
     * Unable to fully structure code
     */
    static boolean compareFields(Map var0, Map var1_1) {
        if (var0.size() != var1_1.size()) {
            return false;
        }
        var2_2 = var0.keySet().iterator();
        block0 : do lbl-1000: // 4 sources:
        {
            if (var2_2.hasNext() == false) return true;
            var3_3 = (Descriptors$FieldDescriptor)var2_2.next();
            if (!var1_1.containsKey(var3_3)) {
                return false;
            }
            var4_4 = var0.get(var3_3);
            var5_5 = var1_1.get(var3_3);
            if (var3_3.getType() != Descriptors$FieldDescriptor$Type.BYTES) ** GOTO lbl20
            if (!var3_3.isRepeated()) ** GOTO lbl18
            var6_6 = (List)var4_4;
            var7_7 = (List)var5_5;
            if (var6_6.size() != var7_7.size()) {
                return false;
            }
            ** GOTO lbl22
lbl18: // 1 sources:
            if (AbstractMessage.compareBytes(var4_4, var5_5)) ** GOTO lbl-1000
            return false;
lbl20: // 1 sources:
            if (!(var3_3.isMapField() != false ? AbstractMessage.compareMapField(var4_4, var5_5) == false : var4_4.equals(var5_5) == false)) ** GOTO lbl-1000
            return false;
lbl22: // 1 sources:
            var8_8 = 0;
            do {
                if (var8_8 >= var6_6.size()) continue block0;
                if (!AbstractMessage.compareBytes(var6_6.get(var8_8), var7_7.get(var8_8))) {
                    return false;
                }
                ++var8_8;
            } while (true);
            break;
        } while (true);
    }

    private static int hashMapField(Object object) {
        return MapFieldLite.calculateHashCodeForMap(AbstractMessage.convertMapEntryListToMap((List)object));
    }

    protected static int hashFields(int n2, Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)entry.getKey();
            Object v2 = entry.getValue();
            n2 = 37 * n2 + descriptors$FieldDescriptor.getNumber();
            if (descriptors$FieldDescriptor.isMapField()) {
                n2 = 53 * n2 + AbstractMessage.hashMapField(v2);
                continue;
            }
            if (descriptors$FieldDescriptor.getType() != Descriptors$FieldDescriptor$Type.ENUM) {
                n2 = 53 * n2 + v2.hashCode();
                continue;
            }
            if (descriptors$FieldDescriptor.isRepeated()) {
                List list = (List)v2;
                n2 = 53 * n2 + Internal.hashEnumList(list);
                continue;
            }
            n2 = 53 * n2 + Internal.hashEnum((Internal$EnumLite)v2);
        }
        return n2;
    }

    @Override
    UninitializedMessageException newUninitializedMessageException() {
        return AbstractMessage$Builder.newUninitializedMessageException(this);
    }
}

