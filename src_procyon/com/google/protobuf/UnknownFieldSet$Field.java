package com.google.protobuf;

import java.util.*;

public final class UnknownFieldSet$Field
{
    private static final UnknownFieldSet$Field fieldDefaultInstance;
    private List varint;
    private List fixed32;
    private List fixed64;
    private List lengthDelimited;
    private List group;
    
    public static UnknownFieldSet$Field$Builder newBuilder() {
        return create();
    }
    
    public static UnknownFieldSet$Field$Builder newBuilder(final UnknownFieldSet$Field unknownFieldSet$Field) {
        return newBuilder().mergeFrom(unknownFieldSet$Field);
    }
    
    public static UnknownFieldSet$Field getDefaultInstance() {
        return UnknownFieldSet$Field.fieldDefaultInstance;
    }
    
    public List getVarintList() {
        return this.varint;
    }
    
    public List getFixed32List() {
        return this.fixed32;
    }
    
    public List getFixed64List() {
        return this.fixed64;
    }
    
    public List getLengthDelimitedList() {
        return this.lengthDelimited;
    }
    
    public List getGroupList() {
        return this.group;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof UnknownFieldSet$Field && Arrays.equals(this.getIdentityArray(), ((UnknownFieldSet$Field)o).getIdentityArray()));
    }
    
    public int hashCode() {
        return Arrays.hashCode(this.getIdentityArray());
    }
    
    private Object[] getIdentityArray() {
        return new Object[] { this.varint, this.fixed32, this.fixed64, this.lengthDelimited, this.group };
    }
    
    public void writeTo(final int n, final CodedOutputStream codedOutputStream) {
        final Iterator<Long> iterator = this.varint.iterator();
        while (iterator.hasNext()) {
            codedOutputStream.writeUInt64(n, iterator.next());
        }
        final Iterator<Integer> iterator2 = this.fixed32.iterator();
        while (iterator2.hasNext()) {
            codedOutputStream.writeFixed32(n, iterator2.next());
        }
        final Iterator<Long> iterator3 = this.fixed64.iterator();
        while (iterator3.hasNext()) {
            codedOutputStream.writeFixed64(n, iterator3.next());
        }
        final Iterator<ByteString> iterator4 = this.lengthDelimited.iterator();
        while (iterator4.hasNext()) {
            codedOutputStream.writeBytes(n, iterator4.next());
        }
        final Iterator<UnknownFieldSet> iterator5 = this.group.iterator();
        while (iterator5.hasNext()) {
            codedOutputStream.writeGroup(n, iterator5.next());
        }
    }
    
    public int getSerializedSize(final int n) {
        int n2 = 0;
        final Iterator<Long> iterator = this.varint.iterator();
        while (iterator.hasNext()) {
            n2 += CodedOutputStream.computeUInt64Size(n, iterator.next());
        }
        final Iterator<Integer> iterator2 = this.fixed32.iterator();
        while (iterator2.hasNext()) {
            n2 += CodedOutputStream.computeFixed32Size(n, iterator2.next());
        }
        final Iterator<Long> iterator3 = this.fixed64.iterator();
        while (iterator3.hasNext()) {
            n2 += CodedOutputStream.computeFixed64Size(n, iterator3.next());
        }
        final Iterator<ByteString> iterator4 = this.lengthDelimited.iterator();
        while (iterator4.hasNext()) {
            n2 += CodedOutputStream.computeBytesSize(n, iterator4.next());
        }
        final Iterator<UnknownFieldSet> iterator5 = this.group.iterator();
        while (iterator5.hasNext()) {
            n2 += CodedOutputStream.computeGroupSize(n, iterator5.next());
        }
        return n2;
    }
    
    public void writeAsMessageSetExtensionTo(final int n, final CodedOutputStream codedOutputStream) {
        final Iterator<ByteString> iterator = this.lengthDelimited.iterator();
        while (iterator.hasNext()) {
            codedOutputStream.writeRawMessageSetExtension(n, iterator.next());
        }
    }
    
    public int getSerializedSizeAsMessageSetExtension(final int n) {
        int n2 = 0;
        final Iterator<ByteString> iterator = this.lengthDelimited.iterator();
        while (iterator.hasNext()) {
            n2 += CodedOutputStream.computeRawMessageSetExtensionSize(n, iterator.next());
        }
        return n2;
    }
    
    static {
        fieldDefaultInstance = newBuilder().build();
    }
}
