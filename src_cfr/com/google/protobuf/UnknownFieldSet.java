/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$CodedBuilder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.TextFormat;
import com.google.protobuf.UnknownFieldSet$1;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.UnknownFieldSet$Field;
import com.google.protobuf.UnknownFieldSet$Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class UnknownFieldSet
implements MessageLite {
    private static final UnknownFieldSet defaultInstance = new UnknownFieldSet(Collections.emptyMap());
    private Map fields;
    private static final UnknownFieldSet$Parser PARSER = new UnknownFieldSet$Parser();

    private UnknownFieldSet() {
    }

    public static UnknownFieldSet$Builder newBuilder() {
        return UnknownFieldSet$Builder.access$000();
    }

    public static UnknownFieldSet$Builder newBuilder(UnknownFieldSet unknownFieldSet) {
        return UnknownFieldSet.newBuilder().mergeFrom(unknownFieldSet);
    }

    public static UnknownFieldSet getDefaultInstance() {
        return defaultInstance;
    }

    @Override
    public UnknownFieldSet getDefaultInstanceForType() {
        return defaultInstance;
    }

    private UnknownFieldSet(Map map) {
        this.fields = map;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof UnknownFieldSet)) return false;
        if (!this.fields.equals(((UnknownFieldSet)object).fields)) return false;
        return true;
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public Map asMap() {
        return this.fields;
    }

    public boolean hasField(int n2) {
        return this.fields.containsKey(n2);
    }

    public UnknownFieldSet$Field getField(int n2) {
        UnknownFieldSet$Field unknownFieldSet$Field;
        UnknownFieldSet$Field unknownFieldSet$Field2 = (UnknownFieldSet$Field)this.fields.get(n2);
        if (unknownFieldSet$Field2 == null) {
            unknownFieldSet$Field = UnknownFieldSet$Field.getDefaultInstance();
            return unknownFieldSet$Field;
        }
        unknownFieldSet$Field = unknownFieldSet$Field2;
        return unknownFieldSet$Field;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        Iterator iterator = this.fields.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            ((UnknownFieldSet$Field)entry.getValue()).writeTo((Integer)entry.getKey(), codedOutputStream);
        }
    }

    public String toString() {
        return TextFormat.printToString(this);
    }

    @Override
    public ByteString toByteString() {
        try {
            ByteString$CodedBuilder byteString$CodedBuilder = ByteString.newCodedBuilder(this.getSerializedSize());
            this.writeTo(byteString$CodedBuilder.getCodedOutput());
            return byteString$CodedBuilder.build();
        }
        catch (IOException var1_2) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", var1_2);
        }
    }

    @Override
    public byte[] toByteArray() {
        try {
            byte[] arrby = new byte[this.getSerializedSize()];
            CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(arrby);
            this.writeTo(codedOutputStream);
            codedOutputStream.checkNoSpaceLeft();
            return arrby;
        }
        catch (IOException var1_2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var1_2);
        }
    }

    @Override
    public void writeTo(OutputStream outputStream) {
        CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(outputStream);
        this.writeTo(codedOutputStream);
        codedOutputStream.flush();
    }

    @Override
    public void writeDelimitedTo(OutputStream outputStream) {
        CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(outputStream);
        codedOutputStream.writeRawVarint32(this.getSerializedSize());
        this.writeTo(codedOutputStream);
        codedOutputStream.flush();
    }

    @Override
    public int getSerializedSize() {
        int n2 = 0;
        Iterator iterator = this.fields.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            n2 += ((UnknownFieldSet$Field)entry.getValue()).getSerializedSize((Integer)entry.getKey());
        }
        return n2;
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) {
        Iterator iterator = this.fields.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            ((UnknownFieldSet$Field)entry.getValue()).writeAsMessageSetExtensionTo((Integer)entry.getKey(), codedOutputStream);
        }
    }

    public int getSerializedSizeAsMessageSet() {
        int n2 = 0;
        Iterator iterator = this.fields.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            n2 += ((UnknownFieldSet$Field)entry.getValue()).getSerializedSizeAsMessageSetExtension((Integer)entry.getKey());
        }
        return n2;
    }

    @Override
    public boolean isInitialized() {
        return true;
    }

    public static UnknownFieldSet parseFrom(CodedInputStream codedInputStream) {
        return UnknownFieldSet.newBuilder().mergeFrom(codedInputStream).build();
    }

    public static UnknownFieldSet parseFrom(ByteString byteString) {
        return UnknownFieldSet.newBuilder().mergeFrom(byteString).build();
    }

    public static UnknownFieldSet parseFrom(byte[] arrby) {
        return UnknownFieldSet.newBuilder().mergeFrom(arrby).build();
    }

    public static UnknownFieldSet parseFrom(InputStream inputStream) {
        return UnknownFieldSet.newBuilder().mergeFrom(inputStream).build();
    }

    @Override
    public UnknownFieldSet$Builder newBuilderForType() {
        return UnknownFieldSet.newBuilder();
    }

    @Override
    public UnknownFieldSet$Builder toBuilder() {
        return UnknownFieldSet.newBuilder().mergeFrom(this);
    }

    @Override
    public final UnknownFieldSet$Parser getParserForType() {
        return PARSER;
    }

    /* synthetic */ UnknownFieldSet(Map map, UnknownFieldSet$1 unknownFieldSet$1) {
        this(map);
    }

    static /* synthetic */ Map access$200(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.fields;
    }
}

