package com.google.protobuf;

import java.util.*;

final class FieldSet
{
    private final SmallSortedMap fields;
    private boolean isImmutable;
    private boolean hasLazyField;
    private static final FieldSet DEFAULT_INSTANCE;
    
    private FieldSet() {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(16);
    }
    
    private FieldSet(final boolean b) {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(0);
        this.makeImmutable();
    }
    
    public static FieldSet newFieldSet() {
        return new FieldSet();
    }
    
    public static FieldSet emptySet() {
        return FieldSet.DEFAULT_INSTANCE;
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
        final FieldSet fieldSet = newFieldSet();
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            final Map.Entry arrayEntry = this.fields.getArrayEntryAt(i);
            fieldSet.setField(arrayEntry.getKey(), arrayEntry.getValue());
        }
        for (final Map.Entry<FieldSet$FieldDescriptorLite, V> entry : this.fields.getOverflowEntries()) {
            fieldSet.setField(entry.getKey(), entry.getValue());
        }
        fieldSet.hasLazyField = this.hasLazyField;
        return fieldSet;
    }
    
    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }
    
    public Map getAllFields() {
        if (this.hasLazyField) {
            final SmallSortedMap fieldMap = SmallSortedMap.newFieldMap(16);
            for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
                this.cloneFieldEntry(fieldMap, this.fields.getArrayEntryAt(i));
            }
            final Iterator<Map.Entry> iterator = this.fields.getOverflowEntries().iterator();
            while (iterator.hasNext()) {
                this.cloneFieldEntry(fieldMap, (Map.Entry)iterator.next());
            }
            if (this.fields.isImmutable()) {
                fieldMap.makeImmutable();
            }
            return fieldMap;
        }
        return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap((Map<?, ?>)this.fields);
    }
    
    private void cloneFieldEntry(final Map map, final Map.Entry entry) {
        final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = entry.getKey();
        final V value = entry.getValue();
        if (value instanceof LazyField) {
            map.put(fieldSet$FieldDescriptorLite, ((LazyField)value).getValue());
        }
        else {
            map.put(fieldSet$FieldDescriptorLite, value);
        }
    }
    
    public Iterator iterator() {
        if (this.hasLazyField) {
            return new LazyField$LazyIterator(this.fields.entrySet().iterator());
        }
        return this.fields.entrySet().iterator();
    }
    
    public boolean hasField(final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite) {
        if (fieldSet$FieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.fields.get(fieldSet$FieldDescriptorLite) != null;
    }
    
    public Object getField(final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite) {
        final Object value = this.fields.get(fieldSet$FieldDescriptorLite);
        if (value instanceof LazyField) {
            return ((LazyField)value).getValue();
        }
        return value;
    }
    
    public void setField(final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, Object o) {
        if (fieldSet$FieldDescriptorLite.isRepeated()) {
            if (!(o instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            final ArrayList<Object> list = new ArrayList<Object>();
            list.addAll((Collection<?>)o);
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                verifyType(fieldSet$FieldDescriptorLite.getLiteType(), iterator.next());
            }
            o = list;
        }
        else {
            verifyType(fieldSet$FieldDescriptorLite.getLiteType(), o);
        }
        if (o instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put(fieldSet$FieldDescriptorLite, o);
    }
    
    public void clearField(final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite) {
        this.fields.remove(fieldSet$FieldDescriptorLite);
        if (this.fields.isEmpty()) {
            this.hasLazyField = false;
        }
    }
    
    public int getRepeatedFieldCount(final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite) {
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        final Object field = this.getField(fieldSet$FieldDescriptorLite);
        if (field == null) {
            return 0;
        }
        return ((List)field).size();
    }
    
    public Object getRepeatedField(final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, final int n) {
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        final Object field = this.getField(fieldSet$FieldDescriptorLite);
        if (field == null) {
            throw new IndexOutOfBoundsException();
        }
        return ((List<Object>)field).get(n);
    }
    
    public void setRepeatedField(final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, final int n, final Object o) {
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        final Object field = this.getField(fieldSet$FieldDescriptorLite);
        if (field == null) {
            throw new IndexOutOfBoundsException();
        }
        verifyType(fieldSet$FieldDescriptorLite.getLiteType(), o);
        ((List<Object>)field).set(n, o);
    }
    
    public void addRepeatedField(final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, final Object o) {
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        verifyType(fieldSet$FieldDescriptorLite.getLiteType(), o);
        final Object field = this.getField(fieldSet$FieldDescriptorLite);
        List<Object> list;
        if (field == null) {
            list = new ArrayList<Object>();
            this.fields.put(fieldSet$FieldDescriptorLite, list);
        }
        else {
            list = (List<Object>)field;
        }
        list.add(o);
    }
    
    private static void verifyType(final WireFormat$FieldType wireFormat$FieldType, final Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        int n = 0;
        switch (FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[wireFormat$FieldType.getJavaType().ordinal()]) {
            case 1: {
                n = ((o instanceof Integer) ? 1 : 0);
                break;
            }
            case 2: {
                n = ((o instanceof Long) ? 1 : 0);
                break;
            }
            case 3: {
                n = ((o instanceof Float) ? 1 : 0);
                break;
            }
            case 4: {
                n = ((o instanceof Double) ? 1 : 0);
                break;
            }
            case 5: {
                n = ((o instanceof Boolean) ? 1 : 0);
                break;
            }
            case 6: {
                n = ((o instanceof String) ? 1 : 0);
                break;
            }
            case 7: {
                n = ((o instanceof ByteString || o instanceof byte[]) ? 1 : 0);
                break;
            }
            case 8: {
                n = ((o instanceof Integer || o instanceof Internal$EnumLite) ? 1 : 0);
                break;
            }
            case 9: {
                n = ((o instanceof MessageLite || o instanceof LazyField) ? 1 : 0);
                break;
            }
        }
        if (n == 0) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }
    
    public boolean isInitialized() {
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            if (!this.isInitialized(this.fields.getArrayEntryAt(i))) {
                return false;
            }
        }
        final Iterator<Map.Entry> iterator = this.fields.getOverflowEntries().iterator();
        while (iterator.hasNext()) {
            if (!this.isInitialized((Map.Entry)iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isInitialized(final Map.Entry entry) {
        final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = entry.getKey();
        if (fieldSet$FieldDescriptorLite.getLiteJavaType() == WireFormat$JavaType.MESSAGE) {
            if (fieldSet$FieldDescriptorLite.isRepeated()) {
                final Iterator<MessageLite> iterator = ((List)entry.getValue()).iterator();
                while (iterator.hasNext()) {
                    if (!iterator.next().isInitialized()) {
                        return false;
                    }
                }
            }
            else {
                final V value = entry.getValue();
                if (value instanceof MessageLite) {
                    if (!((MessageLite)value).isInitialized()) {
                        return false;
                    }
                }
                else {
                    if (value instanceof LazyField) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }
    
    static int getWireFormatForFieldType(final WireFormat$FieldType wireFormat$FieldType, final boolean b) {
        if (b) {
            return 2;
        }
        return wireFormat$FieldType.getWireType();
    }
    
    public void mergeFrom(final FieldSet set) {
        for (int i = 0; i < set.fields.getNumArrayEntries(); ++i) {
            this.mergeFromField(set.fields.getArrayEntryAt(i));
        }
        final Iterator<Map.Entry> iterator = set.fields.getOverflowEntries().iterator();
        while (iterator.hasNext()) {
            this.mergeFromField((Map.Entry)iterator.next());
        }
    }
    
    private Object cloneIfMutable(final Object o) {
        if (o instanceof byte[]) {
            final byte[] array = (byte[])o;
            final byte[] array2 = new byte[array.length];
            System.arraycopy(array, 0, array2, 0, array.length);
            return array2;
        }
        return o;
    }
    
    private void mergeFromField(final Map.Entry entry) {
        final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = entry.getKey();
        Object o = entry.getValue();
        if (o instanceof LazyField) {
            o = ((LazyField)o).getValue();
        }
        if (fieldSet$FieldDescriptorLite.isRepeated()) {
            Object field = this.getField(fieldSet$FieldDescriptorLite);
            if (field == null) {
                field = new ArrayList<Object>();
            }
            final Iterator<Object> iterator = ((List<Object>)o).iterator();
            while (iterator.hasNext()) {
                ((List<Object>)field).add(this.cloneIfMutable(iterator.next()));
            }
            this.fields.put(fieldSet$FieldDescriptorLite, field);
        }
        else if (fieldSet$FieldDescriptorLite.getLiteJavaType() == WireFormat$JavaType.MESSAGE) {
            final Object field2 = this.getField(fieldSet$FieldDescriptorLite);
            if (field2 == null) {
                this.fields.put(fieldSet$FieldDescriptorLite, this.cloneIfMutable(o));
            }
            else {
                this.fields.put(fieldSet$FieldDescriptorLite, fieldSet$FieldDescriptorLite.internalMergeFrom(((MessageLite)field2).toBuilder(), (MessageLite)o).build());
            }
        }
        else {
            this.fields.put(fieldSet$FieldDescriptorLite, this.cloneIfMutable(o));
        }
    }
    
    public static Object readPrimitiveField(final CodedInputStream codedInputStream, final WireFormat$FieldType wireFormat$FieldType, final boolean b) {
        if (b) {
            return WireFormat.readPrimitiveField(codedInputStream, wireFormat$FieldType, WireFormat$Utf8Validation.STRICT);
        }
        return WireFormat.readPrimitiveField(codedInputStream, wireFormat$FieldType, WireFormat$Utf8Validation.LOOSE);
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            final Map.Entry arrayEntry = this.fields.getArrayEntryAt(i);
            writeField(arrayEntry.getKey(), arrayEntry.getValue(), codedOutputStream);
        }
        for (final Map.Entry<FieldSet$FieldDescriptorLite, V> entry : this.fields.getOverflowEntries()) {
            writeField(entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }
    
    public void writeMessageSetTo(final CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            this.writeMessageSetTo(this.fields.getArrayEntryAt(i), codedOutputStream);
        }
        final Iterator<Map.Entry> iterator = this.fields.getOverflowEntries().iterator();
        while (iterator.hasNext()) {
            this.writeMessageSetTo((Map.Entry)iterator.next(), codedOutputStream);
        }
    }
    
    private void writeMessageSetTo(final Map.Entry entry, final CodedOutputStream codedOutputStream) {
        final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = entry.getKey();
        if (fieldSet$FieldDescriptorLite.getLiteJavaType() == WireFormat$JavaType.MESSAGE && !fieldSet$FieldDescriptorLite.isRepeated() && !fieldSet$FieldDescriptorLite.isPacked()) {
            Object o = entry.getValue();
            if (o instanceof LazyField) {
                o = ((LazyField)o).getValue();
            }
            codedOutputStream.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite)o);
        }
        else {
            writeField(fieldSet$FieldDescriptorLite, entry.getValue(), codedOutputStream);
        }
    }
    
    private static void writeElement(final CodedOutputStream codedOutputStream, final WireFormat$FieldType wireFormat$FieldType, final int n, final Object o) {
        if (wireFormat$FieldType == WireFormat$FieldType.GROUP) {
            codedOutputStream.writeGroup(n, (MessageLite)o);
        }
        else {
            codedOutputStream.writeTag(n, getWireFormatForFieldType(wireFormat$FieldType, false));
            writeElementNoTag(codedOutputStream, wireFormat$FieldType, o);
        }
    }
    
    static void writeElementNoTag(final CodedOutputStream codedOutputStream, final WireFormat$FieldType wireFormat$FieldType, final Object o) {
        switch (FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[wireFormat$FieldType.ordinal()]) {
            case 1: {
                codedOutputStream.writeDoubleNoTag((double)o);
                break;
            }
            case 2: {
                codedOutputStream.writeFloatNoTag((float)o);
                break;
            }
            case 3: {
                codedOutputStream.writeInt64NoTag((long)o);
                break;
            }
            case 4: {
                codedOutputStream.writeUInt64NoTag((long)o);
                break;
            }
            case 5: {
                codedOutputStream.writeInt32NoTag((int)o);
                break;
            }
            case 6: {
                codedOutputStream.writeFixed64NoTag((long)o);
                break;
            }
            case 7: {
                codedOutputStream.writeFixed32NoTag((int)o);
                break;
            }
            case 8: {
                codedOutputStream.writeBoolNoTag((boolean)o);
                break;
            }
            case 9: {
                codedOutputStream.writeGroupNoTag((MessageLite)o);
                break;
            }
            case 10: {
                codedOutputStream.writeMessageNoTag((MessageLite)o);
                break;
            }
            case 11: {
                if (o instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString)o);
                    break;
                }
                codedOutputStream.writeStringNoTag((String)o);
                break;
            }
            case 12: {
                if (o instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString)o);
                    break;
                }
                codedOutputStream.writeByteArrayNoTag((byte[])o);
                break;
            }
            case 13: {
                codedOutputStream.writeUInt32NoTag((int)o);
                break;
            }
            case 14: {
                codedOutputStream.writeSFixed32NoTag((int)o);
                break;
            }
            case 15: {
                codedOutputStream.writeSFixed64NoTag((long)o);
                break;
            }
            case 16: {
                codedOutputStream.writeSInt32NoTag((int)o);
                break;
            }
            case 17: {
                codedOutputStream.writeSInt64NoTag((long)o);
                break;
            }
            case 18: {
                if (o instanceof Internal$EnumLite) {
                    codedOutputStream.writeEnumNoTag(((Internal$EnumLite)o).getNumber());
                    break;
                }
                codedOutputStream.writeEnumNoTag((int)o);
                break;
            }
        }
    }
    
    public static void writeField(final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, final Object o, final CodedOutputStream codedOutputStream) {
        final WireFormat$FieldType liteType = fieldSet$FieldDescriptorLite.getLiteType();
        final int number = fieldSet$FieldDescriptorLite.getNumber();
        if (fieldSet$FieldDescriptorLite.isRepeated()) {
            final List list = (List)o;
            if (fieldSet$FieldDescriptorLite.isPacked()) {
                codedOutputStream.writeTag(number, 2);
                int n = 0;
                final Iterator<Object> iterator = list.iterator();
                while (iterator.hasNext()) {
                    n += computeElementSizeNoTag(liteType, iterator.next());
                }
                codedOutputStream.writeRawVarint32(n);
                final Iterator<Object> iterator2 = list.iterator();
                while (iterator2.hasNext()) {
                    writeElementNoTag(codedOutputStream, liteType, iterator2.next());
                }
            }
            else {
                final Iterator<Object> iterator3 = list.iterator();
                while (iterator3.hasNext()) {
                    writeElement(codedOutputStream, liteType, number, iterator3.next());
                }
            }
        }
        else if (o instanceof LazyField) {
            writeElement(codedOutputStream, liteType, number, ((LazyField)o).getValue());
        }
        else {
            writeElement(codedOutputStream, liteType, number, o);
        }
    }
    
    public int getSerializedSize() {
        int n = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            final Map.Entry arrayEntry = this.fields.getArrayEntryAt(i);
            n += computeFieldSize(arrayEntry.getKey(), arrayEntry.getValue());
        }
        for (final Map.Entry<FieldSet$FieldDescriptorLite, V> entry : this.fields.getOverflowEntries()) {
            n += computeFieldSize(entry.getKey(), entry.getValue());
        }
        return n;
    }
    
    public int getMessageSetSerializedSize() {
        int n = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            n += this.getMessageSetSerializedSize(this.fields.getArrayEntryAt(i));
        }
        final Iterator<Map.Entry> iterator = this.fields.getOverflowEntries().iterator();
        while (iterator.hasNext()) {
            n += this.getMessageSetSerializedSize((Map.Entry)iterator.next());
        }
        return n;
    }
    
    private int getMessageSetSerializedSize(final Map.Entry entry) {
        final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = entry.getKey();
        final LazyField value = entry.getValue();
        if (fieldSet$FieldDescriptorLite.getLiteJavaType() != WireFormat$JavaType.MESSAGE || fieldSet$FieldDescriptorLite.isRepeated() || fieldSet$FieldDescriptorLite.isPacked()) {
            return computeFieldSize(fieldSet$FieldDescriptorLite, value);
        }
        if (value instanceof LazyField) {
            return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(entry.getKey().getNumber(), value);
        }
        return CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite)value);
    }
    
    private static int computeElementSize(final WireFormat$FieldType wireFormat$FieldType, final int n, final Object o) {
        int computeTagSize = CodedOutputStream.computeTagSize(n);
        if (wireFormat$FieldType == WireFormat$FieldType.GROUP) {
            computeTagSize *= 2;
        }
        return computeTagSize + computeElementSizeNoTag(wireFormat$FieldType, o);
    }
    
    static int computeElementSizeNoTag(final WireFormat$FieldType wireFormat$FieldType, final Object o) {
        switch (FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[wireFormat$FieldType.ordinal()]) {
            case 1: {
                return CodedOutputStream.computeDoubleSizeNoTag((double)o);
            }
            case 2: {
                return CodedOutputStream.computeFloatSizeNoTag((float)o);
            }
            case 3: {
                return CodedOutputStream.computeInt64SizeNoTag((long)o);
            }
            case 4: {
                return CodedOutputStream.computeUInt64SizeNoTag((long)o);
            }
            case 5: {
                return CodedOutputStream.computeInt32SizeNoTag((int)o);
            }
            case 6: {
                return CodedOutputStream.computeFixed64SizeNoTag((long)o);
            }
            case 7: {
                return CodedOutputStream.computeFixed32SizeNoTag((int)o);
            }
            case 8: {
                return CodedOutputStream.computeBoolSizeNoTag((boolean)o);
            }
            case 9: {
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite)o);
            }
            case 12: {
                if (o instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString)o);
                }
                return CodedOutputStream.computeByteArraySizeNoTag((byte[])o);
            }
            case 11: {
                if (o instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString)o);
                }
                return CodedOutputStream.computeStringSizeNoTag((String)o);
            }
            case 13: {
                return CodedOutputStream.computeUInt32SizeNoTag((int)o);
            }
            case 14: {
                return CodedOutputStream.computeSFixed32SizeNoTag((int)o);
            }
            case 15: {
                return CodedOutputStream.computeSFixed64SizeNoTag((long)o);
            }
            case 16: {
                return CodedOutputStream.computeSInt32SizeNoTag((int)o);
            }
            case 17: {
                return CodedOutputStream.computeSInt64SizeNoTag((long)o);
            }
            case 10: {
                if (o instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite)o);
                }
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite)o);
            }
            case 18: {
                if (o instanceof Internal$EnumLite) {
                    return CodedOutputStream.computeEnumSizeNoTag(((Internal$EnumLite)o).getNumber());
                }
                return CodedOutputStream.computeEnumSizeNoTag((int)o);
            }
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
    }
    
    public static int computeFieldSize(final FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, final Object o) {
        final WireFormat$FieldType liteType = fieldSet$FieldDescriptorLite.getLiteType();
        final int number = fieldSet$FieldDescriptorLite.getNumber();
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            return computeElementSize(liteType, number, o);
        }
        if (fieldSet$FieldDescriptorLite.isPacked()) {
            int n = 0;
            final Iterator<Object> iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                n += computeElementSizeNoTag(liteType, iterator.next());
            }
            return n + CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeRawVarint32Size(n);
        }
        int n2 = 0;
        final Iterator<Object> iterator2 = ((List)o).iterator();
        while (iterator2.hasNext()) {
            n2 += computeElementSize(liteType, number, iterator2.next());
        }
        return n2;
    }
    
    static {
        DEFAULT_INSTANCE = new FieldSet(true);
    }
}
