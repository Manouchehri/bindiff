/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$1;
import com.google.protobuf.UnknownFieldSet$Field$Builder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class UnknownFieldSet$Field {
    private static final UnknownFieldSet$Field fieldDefaultInstance = UnknownFieldSet$Field.newBuilder().build();
    private List varint;
    private List fixed32;
    private List fixed64;
    private List lengthDelimited;
    private List group;

    private UnknownFieldSet$Field() {
    }

    public static UnknownFieldSet$Field$Builder newBuilder() {
        return UnknownFieldSet$Field$Builder.access$300();
    }

    public static UnknownFieldSet$Field$Builder newBuilder(UnknownFieldSet$Field unknownFieldSet$Field) {
        return UnknownFieldSet$Field.newBuilder().mergeFrom(unknownFieldSet$Field);
    }

    public static UnknownFieldSet$Field getDefaultInstance() {
        return fieldDefaultInstance;
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

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof UnknownFieldSet$Field) return Arrays.equals(this.getIdentityArray(), ((UnknownFieldSet$Field)object).getIdentityArray());
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.getIdentityArray());
    }

    private Object[] getIdentityArray() {
        return new Object[]{this.varint, this.fixed32, this.fixed64, this.lengthDelimited, this.group};
    }

    public void writeTo(int n2, CodedOutputStream codedOutputStream) {
        long l2;
        Iterator iterator = this.varint.iterator();
        while (iterator.hasNext()) {
            l2 = (Long)iterator.next();
            codedOutputStream.writeUInt64(n2, l2);
        }
        iterator = this.fixed32.iterator();
        while (iterator.hasNext()) {
            int n3 = (Integer)iterator.next();
            codedOutputStream.writeFixed32(n2, n3);
        }
        iterator = this.fixed64.iterator();
        while (iterator.hasNext()) {
            l2 = (Long)iterator.next();
            codedOutputStream.writeFixed64(n2, l2);
        }
        for (ByteString byteString : this.lengthDelimited) {
            codedOutputStream.writeBytes(n2, byteString);
        }
        iterator = this.group.iterator();
        while (iterator.hasNext()) {
            UnknownFieldSet unknownFieldSet = (UnknownFieldSet)iterator.next();
            codedOutputStream.writeGroup(n2, unknownFieldSet);
        }
    }

    public int getSerializedSize(int n2) {
        long l2;
        int n3 = 0;
        Iterator iterator = this.varint.iterator();
        while (iterator.hasNext()) {
            l2 = (Long)iterator.next();
            n3 += CodedOutputStream.computeUInt64Size(n2, l2);
        }
        iterator = this.fixed32.iterator();
        while (iterator.hasNext()) {
            int n4 = (Integer)iterator.next();
            n3 += CodedOutputStream.computeFixed32Size(n2, n4);
        }
        iterator = this.fixed64.iterator();
        while (iterator.hasNext()) {
            l2 = (Long)iterator.next();
            n3 += CodedOutputStream.computeFixed64Size(n2, l2);
        }
        for (ByteString byteString : this.lengthDelimited) {
            n3 += CodedOutputStream.computeBytesSize(n2, byteString);
        }
        iterator = this.group.iterator();
        while (iterator.hasNext()) {
            UnknownFieldSet unknownFieldSet = (UnknownFieldSet)iterator.next();
            n3 += CodedOutputStream.computeGroupSize(n2, unknownFieldSet);
        }
        return n3;
    }

    public void writeAsMessageSetExtensionTo(int n2, CodedOutputStream codedOutputStream) {
        Iterator iterator = this.lengthDelimited.iterator();
        while (iterator.hasNext()) {
            ByteString byteString = (ByteString)iterator.next();
            codedOutputStream.writeRawMessageSetExtension(n2, byteString);
        }
    }

    public int getSerializedSizeAsMessageSetExtension(int n2) {
        int n3 = 0;
        Iterator iterator = this.lengthDelimited.iterator();
        while (iterator.hasNext()) {
            ByteString byteString = (ByteString)iterator.next();
            n3 += CodedOutputStream.computeRawMessageSetExtensionSize(n2, byteString);
        }
        return n3;
    }

    /* synthetic */ UnknownFieldSet$Field(UnknownFieldSet$1 unknownFieldSet$1) {
        this();
    }

    static /* synthetic */ List access$500(UnknownFieldSet$Field unknownFieldSet$Field) {
        return unknownFieldSet$Field.varint;
    }

    static /* synthetic */ List access$502(UnknownFieldSet$Field unknownFieldSet$Field, List list) {
        unknownFieldSet$Field.varint = list;
        return unknownFieldSet$Field.varint;
    }

    static /* synthetic */ List access$600(UnknownFieldSet$Field unknownFieldSet$Field) {
        return unknownFieldSet$Field.fixed32;
    }

    static /* synthetic */ List access$602(UnknownFieldSet$Field unknownFieldSet$Field, List list) {
        unknownFieldSet$Field.fixed32 = list;
        return unknownFieldSet$Field.fixed32;
    }

    static /* synthetic */ List access$700(UnknownFieldSet$Field unknownFieldSet$Field) {
        return unknownFieldSet$Field.fixed64;
    }

    static /* synthetic */ List access$702(UnknownFieldSet$Field unknownFieldSet$Field, List list) {
        unknownFieldSet$Field.fixed64 = list;
        return unknownFieldSet$Field.fixed64;
    }

    static /* synthetic */ List access$800(UnknownFieldSet$Field unknownFieldSet$Field) {
        return unknownFieldSet$Field.lengthDelimited;
    }

    static /* synthetic */ List access$802(UnknownFieldSet$Field unknownFieldSet$Field, List list) {
        unknownFieldSet$Field.lengthDelimited = list;
        return unknownFieldSet$Field.lengthDelimited;
    }

    static /* synthetic */ List access$900(UnknownFieldSet$Field unknownFieldSet$Field) {
        return unknownFieldSet$Field.group;
    }

    static /* synthetic */ List access$902(UnknownFieldSet$Field unknownFieldSet$Field, List list) {
        unknownFieldSet$Field.group = list;
        return unknownFieldSet$Field.group;
    }
}

