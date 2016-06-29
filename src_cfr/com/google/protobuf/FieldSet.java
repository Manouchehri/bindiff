/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.FieldSet$1;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.LazyField;
import com.google.protobuf.LazyField$LazyIterator;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.SmallSortedMap;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import com.google.protobuf.WireFormat$Utf8Validation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class FieldSet {
    private final SmallSortedMap fields;
    private boolean isImmutable;
    private boolean hasLazyField = false;
    private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    private FieldSet(boolean bl2) {
        this.fields = SmallSortedMap.newFieldMap(0);
        this.makeImmutable();
    }

    public static FieldSet newFieldSet() {
        return new FieldSet();
    }

    public static FieldSet emptySet() {
        return DEFAULT_INSTANCE;
    }

    public void makeImmutable() {
        if (this.isImmutable) {
            return;
        }
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public FieldSet clone() {
        Map.Entry entry;
        FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite;
        FieldSet fieldSet = FieldSet.newFieldSet();
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); ++i2) {
            entry = this.fields.getArrayEntryAt(i2);
            fieldSet$FieldDescriptorLite = (FieldSet$FieldDescriptorLite)entry.getKey();
            fieldSet.setField(fieldSet$FieldDescriptorLite, entry.getValue());
        }
        Iterator iterator = this.fields.getOverflowEntries().iterator();
        do {
            if (!iterator.hasNext()) {
                fieldSet.hasLazyField = this.hasLazyField;
                return fieldSet;
            }
            entry = (Map.Entry)iterator.next();
            fieldSet$FieldDescriptorLite = (FieldSet$FieldDescriptorLite)entry.getKey();
            fieldSet.setField(fieldSet$FieldDescriptorLite, entry.getValue());
        } while (true);
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public Map getAllFields() {
        SmallSortedMap smallSortedMap /* !! */ ;
        if (this.hasLazyField) {
            SmallSortedMap smallSortedMap2 = SmallSortedMap.newFieldMap(16);
            for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); ++i2) {
                this.cloneFieldEntry(smallSortedMap2, this.fields.getArrayEntryAt(i2));
            }
            Iterator iterator = this.fields.getOverflowEntries().iterator();
            do {
                if (!iterator.hasNext()) {
                    if (!this.fields.isImmutable()) return smallSortedMap2;
                    smallSortedMap2.makeImmutable();
                    return smallSortedMap2;
                }
                Map.Entry entry = (Map.Entry)iterator.next();
                this.cloneFieldEntry(smallSortedMap2, entry);
            } while (true);
        }
        if (this.fields.isImmutable()) {
            smallSortedMap /* !! */  = this.fields;
            return smallSortedMap /* !! */ ;
        }
        smallSortedMap /* !! */  = Collections.unmodifiableMap(this.fields);
        return smallSortedMap /* !! */ ;
    }

    private void cloneFieldEntry(Map map, Map.Entry entry) {
        FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = (FieldSet$FieldDescriptorLite)entry.getKey();
        Object v2 = entry.getValue();
        if (v2 instanceof LazyField) {
            map.put(fieldSet$FieldDescriptorLite, ((LazyField)v2).getValue());
            return;
        }
        map.put(fieldSet$FieldDescriptorLite, v2);
    }

    public Iterator iterator() {
        if (!this.hasLazyField) return this.fields.entrySet().iterator();
        return new LazyField$LazyIterator(this.fields.entrySet().iterator());
    }

    public boolean hasField(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite) {
        if (fieldSet$FieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        if (this.fields.get(fieldSet$FieldDescriptorLite) == null) return false;
        return true;
    }

    public Object getField(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite) {
        Object object = this.fields.get(fieldSet$FieldDescriptorLite);
        if (!(object instanceof LazyField)) return object;
        return ((LazyField)object).getValue();
    }

    public void setField(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, Object arrayList) {
        if (fieldSet$FieldDescriptorLite.isRepeated()) {
            if (!(arrayList instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            for (Object e2 : arrayList2) {
                FieldSet.verifyType(fieldSet$FieldDescriptorLite.getLiteType(), e2);
            }
            arrayList = arrayList2;
        } else {
            FieldSet.verifyType(fieldSet$FieldDescriptorLite.getLiteType(), arrayList);
        }
        if (arrayList instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put(fieldSet$FieldDescriptorLite, (Object)arrayList);
    }

    public void clearField(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite) {
        this.fields.remove(fieldSet$FieldDescriptorLite);
        if (!this.fields.isEmpty()) return;
        this.hasLazyField = false;
    }

    public int getRepeatedFieldCount(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite) {
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object object = this.getField(fieldSet$FieldDescriptorLite);
        if (object != null) return ((List)object).size();
        return 0;
    }

    public Object getRepeatedField(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, int n2) {
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object object = this.getField(fieldSet$FieldDescriptorLite);
        if (object != null) return ((List)object).get(n2);
        throw new IndexOutOfBoundsException();
    }

    public void setRepeatedField(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, int n2, Object object) {
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object object2 = this.getField(fieldSet$FieldDescriptorLite);
        if (object2 == null) {
            throw new IndexOutOfBoundsException();
        }
        FieldSet.verifyType(fieldSet$FieldDescriptorLite.getLiteType(), object);
        ((List)object2).set(n2, object);
    }

    public void addRepeatedField(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, Object object) {
        ArrayList<Object> arrayList;
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        FieldSet.verifyType(fieldSet$FieldDescriptorLite.getLiteType(), object);
        Object object2 = this.getField(fieldSet$FieldDescriptorLite);
        if (object2 == null) {
            arrayList = new ArrayList<Object>();
            this.fields.put(fieldSet$FieldDescriptorLite, arrayList);
        } else {
            arrayList = (ArrayList<Object>)object2;
        }
        arrayList.add(object);
    }

    private static void verifyType(WireFormat$FieldType wireFormat$FieldType, Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        boolean bl2 = false;
        switch (FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[wireFormat$FieldType.getJavaType().ordinal()]) {
            case 1: {
                bl2 = object instanceof Integer;
                break;
            }
            case 2: {
                bl2 = object instanceof Long;
                break;
            }
            case 3: {
                bl2 = object instanceof Float;
                break;
            }
            case 4: {
                bl2 = object instanceof Double;
                break;
            }
            case 5: {
                bl2 = object instanceof Boolean;
                break;
            }
            case 6: {
                bl2 = object instanceof String;
                break;
            }
            case 7: {
                if (object instanceof ByteString) return;
                if (object instanceof byte[]) {
                    return;
                }
                boolean bl3 = false;
                bl2 = bl3;
                break;
            }
            case 8: {
                if (object instanceof Integer) return;
                if (object instanceof Internal$EnumLite) {
                    return;
                }
                boolean bl4 = false;
                bl2 = bl4;
                break;
            }
            case 9: {
                if (object instanceof MessageLite) return;
                if (object instanceof LazyField) {
                    return;
                }
                boolean bl5 = false;
                bl2 = bl5;
            }
        }
        if (bl2) return;
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public boolean isInitialized() {
        Map.Entry entry;
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); ++i2) {
            if (this.isInitialized(this.fields.getArrayEntryAt(i2))) continue;
            return false;
        }
        Iterator iterator = this.fields.getOverflowEntries().iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (this.isInitialized(entry = (Map.Entry)iterator.next()));
        return false;
    }

    private boolean isInitialized(Map.Entry entry) {
        FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = (FieldSet$FieldDescriptorLite)entry.getKey();
        if (fieldSet$FieldDescriptorLite.getLiteJavaType() != WireFormat$JavaType.MESSAGE) return true;
        if (fieldSet$FieldDescriptorLite.isRepeated()) {
            MessageLite messageLite;
            Iterator iterator = ((List)entry.getValue()).iterator();
            do {
                if (!iterator.hasNext()) return true;
            } while ((messageLite = (MessageLite)iterator.next()).isInitialized());
            return false;
        }
        Object v2 = entry.getValue();
        if (v2 instanceof MessageLite) {
            if (((MessageLite)v2).isInitialized()) return true;
            return false;
        }
        if (!(v2 instanceof LazyField)) throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        return true;
    }

    static int getWireFormatForFieldType(WireFormat$FieldType wireFormat$FieldType, boolean bl2) {
        if (!bl2) return wireFormat$FieldType.getWireType();
        return 2;
    }

    public void mergeFrom(FieldSet fieldSet) {
        for (int i2 = 0; i2 < fieldSet.fields.getNumArrayEntries(); ++i2) {
            this.mergeFromField(fieldSet.fields.getArrayEntryAt(i2));
        }
        Iterator iterator = fieldSet.fields.getOverflowEntries().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            this.mergeFromField(entry);
        }
    }

    private Object cloneIfMutable(Object object) {
        if (!(object instanceof byte[])) return object;
        byte[] arrby = (byte[])object;
        byte[] arrby2 = new byte[arrby.length];
        System.arraycopy(arrby, 0, arrby2, 0, arrby.length);
        return arrby2;
    }

    private void mergeFromField(Map.Entry entry) {
        FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = (FieldSet$FieldDescriptorLite)entry.getKey();
        Object object = entry.getValue();
        if (object instanceof LazyField) {
            object = ((LazyField)object).getValue();
        }
        if (fieldSet$FieldDescriptorLite.isRepeated()) {
            ArrayList arrayList = this.getField(fieldSet$FieldDescriptorLite);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            Iterator iterator = ((List)object).iterator();
            do {
                if (!iterator.hasNext()) {
                    this.fields.put(fieldSet$FieldDescriptorLite, arrayList);
                    return;
                }
                Object e2 = iterator.next();
                ((List)arrayList).add(this.cloneIfMutable(e2));
            } while (true);
        }
        if (fieldSet$FieldDescriptorLite.getLiteJavaType() != WireFormat$JavaType.MESSAGE) {
            this.fields.put(fieldSet$FieldDescriptorLite, this.cloneIfMutable(object));
            return;
        }
        Object object2 = this.getField(fieldSet$FieldDescriptorLite);
        if (object2 == null) {
            this.fields.put(fieldSet$FieldDescriptorLite, this.cloneIfMutable(object));
            return;
        }
        object2 = fieldSet$FieldDescriptorLite.internalMergeFrom(((MessageLite)object2).toBuilder(), (MessageLite)object).build();
        this.fields.put(fieldSet$FieldDescriptorLite, object2);
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat$FieldType wireFormat$FieldType, boolean bl2) {
        if (!bl2) return WireFormat.readPrimitiveField(codedInputStream, wireFormat$FieldType, WireFormat$Utf8Validation.LOOSE);
        return WireFormat.readPrimitiveField(codedInputStream, wireFormat$FieldType, WireFormat$Utf8Validation.STRICT);
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Map.Entry entry;
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); ++i2) {
            entry = this.fields.getArrayEntryAt(i2);
            FieldSet.writeField((FieldSet$FieldDescriptorLite)entry.getKey(), entry.getValue(), codedOutputStream);
        }
        Iterator iterator = this.fields.getOverflowEntries().iterator();
        while (iterator.hasNext()) {
            entry = (Map.Entry)iterator.next();
            FieldSet.writeField((FieldSet$FieldDescriptorLite)entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }

    public void writeMessageSetTo(CodedOutputStream codedOutputStream) {
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); ++i2) {
            this.writeMessageSetTo(this.fields.getArrayEntryAt(i2), codedOutputStream);
        }
        Iterator iterator = this.fields.getOverflowEntries().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            this.writeMessageSetTo(entry, codedOutputStream);
        }
    }

    private void writeMessageSetTo(Map.Entry entry, CodedOutputStream codedOutputStream) {
        FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = (FieldSet$FieldDescriptorLite)entry.getKey();
        if (fieldSet$FieldDescriptorLite.getLiteJavaType() == WireFormat$JavaType.MESSAGE && !fieldSet$FieldDescriptorLite.isRepeated() && !fieldSet$FieldDescriptorLite.isPacked()) {
            Object object = entry.getValue();
            if (object instanceof LazyField) {
                object = ((LazyField)object).getValue();
            }
            codedOutputStream.writeMessageSetExtension(((FieldSet$FieldDescriptorLite)entry.getKey()).getNumber(), (MessageLite)object);
            return;
        }
        FieldSet.writeField(fieldSet$FieldDescriptorLite, entry.getValue(), codedOutputStream);
    }

    private static void writeElement(CodedOutputStream codedOutputStream, WireFormat$FieldType wireFormat$FieldType, int n2, Object object) {
        if (wireFormat$FieldType == WireFormat$FieldType.GROUP) {
            codedOutputStream.writeGroup(n2, (MessageLite)object);
            return;
        }
        codedOutputStream.writeTag(n2, FieldSet.getWireFormatForFieldType(wireFormat$FieldType, false));
        FieldSet.writeElementNoTag(codedOutputStream, wireFormat$FieldType, object);
    }

    static void writeElementNoTag(CodedOutputStream codedOutputStream, WireFormat$FieldType wireFormat$FieldType, Object object) {
        switch (wireFormat$FieldType) {
            case DOUBLE: {
                codedOutputStream.writeDoubleNoTag((Double)object);
                return;
            }
            case FLOAT: {
                codedOutputStream.writeFloatNoTag(((Float)object).floatValue());
                return;
            }
            case INT64: {
                codedOutputStream.writeInt64NoTag((Long)object);
                return;
            }
            case UINT64: {
                codedOutputStream.writeUInt64NoTag((Long)object);
                return;
            }
            case INT32: {
                codedOutputStream.writeInt32NoTag((Integer)object);
                return;
            }
            case FIXED64: {
                codedOutputStream.writeFixed64NoTag((Long)object);
                return;
            }
            case FIXED32: {
                codedOutputStream.writeFixed32NoTag((Integer)object);
                return;
            }
            case BOOL: {
                codedOutputStream.writeBoolNoTag((Boolean)object);
                return;
            }
            case GROUP: {
                codedOutputStream.writeGroupNoTag((MessageLite)object);
                return;
            }
            case MESSAGE: {
                codedOutputStream.writeMessageNoTag((MessageLite)object);
                return;
            }
            case STRING: {
                if (object instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString)object);
                    return;
                }
                codedOutputStream.writeStringNoTag((String)object);
                return;
            }
            case BYTES: {
                if (object instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString)object);
                    return;
                }
                codedOutputStream.writeByteArrayNoTag((byte[])object);
                return;
            }
            case UINT32: {
                codedOutputStream.writeUInt32NoTag((Integer)object);
                return;
            }
            case SFIXED32: {
                codedOutputStream.writeSFixed32NoTag((Integer)object);
                return;
            }
            case SFIXED64: {
                codedOutputStream.writeSFixed64NoTag((Long)object);
                return;
            }
            case SINT32: {
                codedOutputStream.writeSInt32NoTag((Integer)object);
                return;
            }
            case SINT64: {
                codedOutputStream.writeSInt64NoTag((Long)object);
                return;
            }
            case ENUM: {
                if (object instanceof Internal$EnumLite) {
                    codedOutputStream.writeEnumNoTag(((Internal$EnumLite)object).getNumber());
                    return;
                }
                codedOutputStream.writeEnumNoTag((Integer)object);
            }
        }
    }

    public static void writeField(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, Object object, CodedOutputStream codedOutputStream) {
        WireFormat$FieldType wireFormat$FieldType = fieldSet$FieldDescriptorLite.getLiteType();
        int n2 = fieldSet$FieldDescriptorLite.getNumber();
        if (fieldSet$FieldDescriptorLite.isRepeated()) {
            List list = (List)object;
            if (fieldSet$FieldDescriptorLite.isPacked()) {
                codedOutputStream.writeTag(n2, 2);
                int n3 = 0;
                for (Object e22 : list) {
                    n3 += FieldSet.computeElementSizeNoTag(wireFormat$FieldType, e22);
                }
                codedOutputStream.writeRawVarint32(n3);
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    Object e22;
                    e22 = iterator.next();
                    FieldSet.writeElementNoTag(codedOutputStream, wireFormat$FieldType, e22);
                }
                return;
            }
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Object e3 = iterator.next();
                FieldSet.writeElement(codedOutputStream, wireFormat$FieldType, n2, e3);
            }
            return;
        }
        if (object instanceof LazyField) {
            FieldSet.writeElement(codedOutputStream, wireFormat$FieldType, n2, ((LazyField)object).getValue());
            return;
        }
        FieldSet.writeElement(codedOutputStream, wireFormat$FieldType, n2, object);
    }

    public int getSerializedSize() {
        Map.Entry entry;
        int n2 = 0;
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); n2 += FieldSet.computeFieldSize((FieldSet$FieldDescriptorLite)((FieldSet$FieldDescriptorLite)entry.getKey()), entry.getValue()), ++i2) {
            entry = this.fields.getArrayEntryAt(i2);
        }
        Iterator iterator = this.fields.getOverflowEntries().iterator();
        while (iterator.hasNext()) {
            entry = (Map.Entry)iterator.next();
            n2 += FieldSet.computeFieldSize((FieldSet$FieldDescriptorLite)entry.getKey(), entry.getValue());
        }
        return n2;
    }

    public int getMessageSetSerializedSize() {
        int n2 = 0;
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); n2 += this.getMessageSetSerializedSize((Map.Entry)this.fields.getArrayEntryAt((int)i2)), ++i2) {
        }
        Iterator iterator = this.fields.getOverflowEntries().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            n2 += this.getMessageSetSerializedSize(entry);
        }
        return n2;
    }

    private int getMessageSetSerializedSize(Map.Entry entry) {
        FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = (FieldSet$FieldDescriptorLite)entry.getKey();
        Object v2 = entry.getValue();
        if (fieldSet$FieldDescriptorLite.getLiteJavaType() != WireFormat$JavaType.MESSAGE) return FieldSet.computeFieldSize(fieldSet$FieldDescriptorLite, v2);
        if (fieldSet$FieldDescriptorLite.isRepeated()) return FieldSet.computeFieldSize(fieldSet$FieldDescriptorLite, v2);
        if (fieldSet$FieldDescriptorLite.isPacked()) return FieldSet.computeFieldSize(fieldSet$FieldDescriptorLite, v2);
        if (!(v2 instanceof LazyField)) return CodedOutputStream.computeMessageSetExtensionSize(((FieldSet$FieldDescriptorLite)entry.getKey()).getNumber(), (MessageLite)v2);
        return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldSet$FieldDescriptorLite)entry.getKey()).getNumber(), (LazyField)v2);
    }

    private static int computeElementSize(WireFormat$FieldType wireFormat$FieldType, int n2, Object object) {
        int n3 = CodedOutputStream.computeTagSize(n2);
        if (wireFormat$FieldType != WireFormat$FieldType.GROUP) return n3 + FieldSet.computeElementSizeNoTag(wireFormat$FieldType, object);
        n3 *= 2;
        return n3 + FieldSet.computeElementSizeNoTag(wireFormat$FieldType, object);
    }

    static int computeElementSizeNoTag(WireFormat$FieldType wireFormat$FieldType, Object object) {
        switch (wireFormat$FieldType) {
            case DOUBLE: {
                return CodedOutputStream.computeDoubleSizeNoTag((Double)object);
            }
            case FLOAT: {
                return CodedOutputStream.computeFloatSizeNoTag(((Float)object).floatValue());
            }
            case INT64: {
                return CodedOutputStream.computeInt64SizeNoTag((Long)object);
            }
            case UINT64: {
                return CodedOutputStream.computeUInt64SizeNoTag((Long)object);
            }
            case INT32: {
                return CodedOutputStream.computeInt32SizeNoTag((Integer)object);
            }
            case FIXED64: {
                return CodedOutputStream.computeFixed64SizeNoTag((Long)object);
            }
            case FIXED32: {
                return CodedOutputStream.computeFixed32SizeNoTag((Integer)object);
            }
            case BOOL: {
                return CodedOutputStream.computeBoolSizeNoTag((Boolean)object);
            }
            case GROUP: {
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite)object);
            }
            case BYTES: {
                if (!(object instanceof ByteString)) return CodedOutputStream.computeByteArraySizeNoTag((byte[])object);
                return CodedOutputStream.computeBytesSizeNoTag((ByteString)object);
            }
            case STRING: {
                if (!(object instanceof ByteString)) return CodedOutputStream.computeStringSizeNoTag((String)object);
                return CodedOutputStream.computeBytesSizeNoTag((ByteString)object);
            }
            case UINT32: {
                return CodedOutputStream.computeUInt32SizeNoTag((Integer)object);
            }
            case SFIXED32: {
                return CodedOutputStream.computeSFixed32SizeNoTag((Integer)object);
            }
            case SFIXED64: {
                return CodedOutputStream.computeSFixed64SizeNoTag((Long)object);
            }
            case SINT32: {
                return CodedOutputStream.computeSInt32SizeNoTag((Integer)object);
            }
            case SINT64: {
                return CodedOutputStream.computeSInt64SizeNoTag((Long)object);
            }
            case MESSAGE: {
                if (!(object instanceof LazyField)) return CodedOutputStream.computeMessageSizeNoTag((MessageLite)object);
                return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField)object);
            }
            case ENUM: {
                if (!(object instanceof Internal$EnumLite)) return CodedOutputStream.computeEnumSizeNoTag((Integer)object);
                return CodedOutputStream.computeEnumSizeNoTag(((Internal$EnumLite)object).getNumber());
            }
        }
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    }

    public static int computeFieldSize(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, Object object) {
        WireFormat$FieldType wireFormat$FieldType = fieldSet$FieldDescriptorLite.getLiteType();
        int n2 = fieldSet$FieldDescriptorLite.getNumber();
        if (!fieldSet$FieldDescriptorLite.isRepeated()) return FieldSet.computeElementSize(wireFormat$FieldType, n2, object);
        if (fieldSet$FieldDescriptorLite.isPacked()) {
            int n3 = 0;
            Iterator iterator = ((List)object).iterator();
            while (iterator.hasNext()) {
                Object e2 = iterator.next();
                n3 += FieldSet.computeElementSizeNoTag(wireFormat$FieldType, e2);
            }
            return n3 + CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeRawVarint32Size(n3);
        }
        int n4 = 0;
        Iterator iterator = ((List)object).iterator();
        while (iterator.hasNext()) {
            Object e3 = iterator.next();
            n4 += FieldSet.computeElementSize(wireFormat$FieldType, n2, e3);
        }
        return n4;
    }
}

