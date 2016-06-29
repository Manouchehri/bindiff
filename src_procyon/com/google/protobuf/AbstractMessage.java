package com.google.protobuf;

import java.util.*;

public abstract class AbstractMessage extends AbstractMessageLite implements Message
{
    protected int memoizedSize;
    
    public AbstractMessage() {
        this.memoizedSize = -1;
    }
    
    public boolean isInitialized() {
        return MessageReflection.isInitialized(this);
    }
    
    public List findInitializationErrors() {
        return MessageReflection.findMissingFields(this);
    }
    
    public String getInitializationErrorString() {
        return MessageReflection.delimitWithCommas(this.findInitializationErrors());
    }
    
    public boolean hasOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }
    
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }
    
    public final String toString() {
        return TextFormat.printToString(this);
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        MessageReflection.writeMessageTo(this, this.getAllFields(), codedOutputStream, false);
    }
    
    public int getSerializedSize() {
        final int memoizedSize = this.memoizedSize;
        if (memoizedSize != -1) {
            return memoizedSize;
        }
        return this.memoizedSize = MessageReflection.getSerializedSize(this, this.getAllFields());
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Message)) {
            return false;
        }
        final Message message = (Message)o;
        return this.getDescriptorForType() == message.getDescriptorForType() && compareFields(this.getAllFields(), message.getAllFields()) && this.getUnknownFields().equals(message.getUnknownFields());
    }
    
    public int hashCode() {
        int memoizedHashCode = this.memoizedHashCode;
        if (memoizedHashCode == 0) {
            memoizedHashCode = 29 * hashFields(19 * 41 + this.getDescriptorForType().hashCode(), this.getAllFields()) + this.getUnknownFields().hashCode();
            this.memoizedHashCode = memoizedHashCode;
        }
        return memoizedHashCode;
    }
    
    private static ByteString toByteString(final Object o) {
        if (o instanceof byte[]) {
            return ByteString.copyFrom((byte[])o);
        }
        return (ByteString)o;
    }
    
    private static boolean compareBytes(final Object o, final Object o2) {
        if (o instanceof byte[] && o2 instanceof byte[]) {
            return Arrays.equals((byte[])o, (byte[])o2);
        }
        return toByteString(o).equals(toByteString(o2));
    }
    
    private static Map convertMapEntryListToMap(final List list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        final Iterator<Message> iterator = list.iterator();
        final Message message = iterator.next();
        final Descriptors$Descriptor descriptorForType = message.getDescriptorForType();
        final Descriptors$FieldDescriptor fieldByName = descriptorForType.findFieldByName("key");
        final Descriptors$FieldDescriptor fieldByName2 = descriptorForType.findFieldByName("value");
        hashMap.put(message.getField(fieldByName), message.getField(fieldByName2));
        while (iterator.hasNext()) {
            final Message message2 = iterator.next();
            hashMap.put(message2.getField(fieldByName), message2.getField(fieldByName2));
        }
        return hashMap;
    }
    
    private static boolean compareMapField(final Object o, final Object o2) {
        return MapFieldLite.equals(convertMapEntryListToMap((List)o), convertMapEntryListToMap((List)o2));
    }
    
    static boolean compareFields(final Map map, final Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (final Descriptors$FieldDescriptor descriptors$FieldDescriptor : map.keySet()) {
            if (!map2.containsKey(descriptors$FieldDescriptor)) {
                return false;
            }
            final V value = map.get(descriptors$FieldDescriptor);
            final List<Object> value2 = map2.get(descriptors$FieldDescriptor);
            if (descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.BYTES) {
                if (descriptors$FieldDescriptor.isRepeated()) {
                    final List<Object> list = (List<Object>)value;
                    final List<Object> list2 = value2;
                    if (list.size() != list2.size()) {
                        return false;
                    }
                    for (int i = 0; i < list.size(); ++i) {
                        if (!compareBytes(list.get(i), list2.get(i))) {
                            return false;
                        }
                    }
                }
                else {
                    if (!compareBytes(value, value2)) {
                        return false;
                    }
                    continue;
                }
            }
            else if (descriptors$FieldDescriptor.isMapField()) {
                if (!compareMapField(value, value2)) {
                    return false;
                }
                continue;
            }
            else {
                if (!value.equals(value2)) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    private static int hashMapField(final Object o) {
        return MapFieldLite.calculateHashCodeForMap(convertMapEntryListToMap((List)o));
    }
    
    protected static int hashFields(int n, final Map map) {
        for (final Map.Entry<Descriptors$FieldDescriptor, V> entry : map.entrySet()) {
            final Descriptors$FieldDescriptor descriptors$FieldDescriptor = entry.getKey();
            final V value = entry.getValue();
            n = 37 * n + descriptors$FieldDescriptor.getNumber();
            if (descriptors$FieldDescriptor.isMapField()) {
                n = 53 * n + hashMapField(value);
            }
            else if (descriptors$FieldDescriptor.getType() != Descriptors$FieldDescriptor$Type.ENUM) {
                n = 53 * n + value.hashCode();
            }
            else if (descriptors$FieldDescriptor.isRepeated()) {
                n = 53 * n + Internal.hashEnumList((List)value);
            }
            else {
                n = 53 * n + Internal.hashEnum((Internal$EnumLite)value);
            }
        }
        return n;
    }
    
    UninitializedMessageException newUninitializedMessageException() {
        return AbstractMessage$Builder.newUninitializedMessageException(this);
    }
}
