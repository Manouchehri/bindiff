/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder$LimitedInputStream;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$1;
import com.google.protobuf.UnknownFieldSet$Field;
import com.google.protobuf.UnknownFieldSet$Field$Builder;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class UnknownFieldSet$Builder
implements MessageLite$Builder {
    private Map fields;
    private int lastFieldNumber;
    private UnknownFieldSet$Field$Builder lastField;

    private UnknownFieldSet$Builder() {
    }

    private static UnknownFieldSet$Builder create() {
        UnknownFieldSet$Builder unknownFieldSet$Builder = new UnknownFieldSet$Builder();
        unknownFieldSet$Builder.reinitialize();
        return unknownFieldSet$Builder;
    }

    private UnknownFieldSet$Field$Builder getFieldBuilder(int n2) {
        if (this.lastField != null) {
            if (n2 == this.lastFieldNumber) {
                return this.lastField;
            }
            this.addField(this.lastFieldNumber, this.lastField.build());
        }
        if (n2 == 0) {
            return null;
        }
        UnknownFieldSet$Field unknownFieldSet$Field = (UnknownFieldSet$Field)this.fields.get(n2);
        this.lastFieldNumber = n2;
        this.lastField = UnknownFieldSet$Field.newBuilder();
        if (unknownFieldSet$Field == null) return this.lastField;
        this.lastField.mergeFrom(unknownFieldSet$Field);
        return this.lastField;
    }

    @Override
    public UnknownFieldSet build() {
        this.getFieldBuilder(0);
        UnknownFieldSet unknownFieldSet = this.fields.isEmpty() ? UnknownFieldSet.getDefaultInstance() : new UnknownFieldSet(Collections.unmodifiableMap(this.fields), null);
        this.fields = null;
        return unknownFieldSet;
    }

    @Override
    public UnknownFieldSet buildPartial() {
        return this.build();
    }

    @Override
    public UnknownFieldSet$Builder clone() {
        this.getFieldBuilder(0);
        return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(this.fields, null));
    }

    @Override
    public UnknownFieldSet getDefaultInstanceForType() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private void reinitialize() {
        this.fields = Collections.emptyMap();
        this.lastFieldNumber = 0;
        this.lastField = null;
    }

    @Override
    public UnknownFieldSet$Builder clear() {
        this.reinitialize();
        return this;
    }

    public UnknownFieldSet$Builder clearField(int n2) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        if (this.lastField != null && this.lastFieldNumber == n2) {
            this.lastField = null;
            this.lastFieldNumber = 0;
        }
        if (!this.fields.containsKey(n2)) return this;
        this.fields.remove(n2);
        return this;
    }

    public UnknownFieldSet$Builder mergeFrom(UnknownFieldSet unknownFieldSet) {
        if (unknownFieldSet == UnknownFieldSet.getDefaultInstance()) return this;
        Iterator iterator = UnknownFieldSet.access$200(unknownFieldSet).entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            this.mergeField((Integer)entry.getKey(), (UnknownFieldSet$Field)entry.getValue());
        }
        return this;
    }

    public UnknownFieldSet$Builder mergeField(int n2, UnknownFieldSet$Field unknownFieldSet$Field) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        if (this.hasField(n2)) {
            this.getFieldBuilder(n2).mergeFrom(unknownFieldSet$Field);
            return this;
        }
        this.addField(n2, unknownFieldSet$Field);
        return this;
    }

    public UnknownFieldSet$Builder mergeVarintField(int n2, int n3) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        this.getFieldBuilder(n2).addVarint(n3);
        return this;
    }

    public UnknownFieldSet$Builder mergeLengthDelimitedField(int n2, ByteString byteString) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        this.getFieldBuilder(n2).addLengthDelimited(byteString);
        return this;
    }

    public boolean hasField(int n2) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        if (n2 == this.lastFieldNumber) return true;
        if (this.fields.containsKey(n2)) return true;
        return false;
    }

    public UnknownFieldSet$Builder addField(int n2, UnknownFieldSet$Field unknownFieldSet$Field) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        if (this.lastField != null && this.lastFieldNumber == n2) {
            this.lastField = null;
            this.lastFieldNumber = 0;
        }
        if (this.fields.isEmpty()) {
            this.fields = new TreeMap();
        }
        this.fields.put(n2, unknownFieldSet$Field);
        return this;
    }

    public Map asMap() {
        this.getFieldBuilder(0);
        return Collections.unmodifiableMap(this.fields);
    }

    @Override
    public UnknownFieldSet$Builder mergeFrom(CodedInputStream codedInputStream) {
        int n2;
        do {
            if ((n2 = codedInputStream.readTag()) == 0) return this;
        } while (this.mergeFieldFrom(n2, codedInputStream));
        return this;
    }

    public boolean mergeFieldFrom(int n2, CodedInputStream codedInputStream) {
        int n3 = WireFormat.getTagFieldNumber(n2);
        switch (WireFormat.getTagWireType(n2)) {
            case 0: {
                this.getFieldBuilder(n3).addVarint(codedInputStream.readInt64());
                return true;
            }
            case 1: {
                this.getFieldBuilder(n3).addFixed64(codedInputStream.readFixed64());
                return true;
            }
            case 2: {
                this.getFieldBuilder(n3).addLengthDelimited(codedInputStream.readBytes());
                return true;
            }
            case 3: {
                UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
                codedInputStream.readGroup(n3, unknownFieldSet$Builder, (ExtensionRegistryLite)ExtensionRegistry.getEmptyRegistry());
                this.getFieldBuilder(n3).addGroup(unknownFieldSet$Builder.build());
                return true;
            }
            case 4: {
                return false;
            }
            case 5: {
                this.getFieldBuilder(n3).addFixed32(codedInputStream.readFixed32());
                return true;
            }
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override
    public UnknownFieldSet$Builder mergeFrom(ByteString byteString) {
        try {
            CodedInputStream codedInputStream = byteString.newCodedInput();
            this.mergeFrom(codedInputStream);
            codedInputStream.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException var2_3) {
            throw var2_3;
        }
        catch (IOException var2_4) {
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", var2_4);
        }
    }

    @Override
    public UnknownFieldSet$Builder mergeFrom(byte[] arrby) {
        try {
            CodedInputStream codedInputStream = CodedInputStream.newInstance(arrby);
            this.mergeFrom(codedInputStream);
            codedInputStream.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException var2_3) {
            throw var2_3;
        }
        catch (IOException var2_4) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", var2_4);
        }
    }

    @Override
    public UnknownFieldSet$Builder mergeFrom(InputStream inputStream) {
        CodedInputStream codedInputStream = CodedInputStream.newInstance(inputStream);
        this.mergeFrom(codedInputStream);
        codedInputStream.checkLastTagWas(0);
        return this;
    }

    @Override
    public boolean mergeDelimitedFrom(InputStream inputStream) {
        int n2 = inputStream.read();
        if (n2 == -1) {
            return false;
        }
        int n3 = CodedInputStream.readRawVarint32(n2, inputStream);
        AbstractMessageLite$Builder$LimitedInputStream abstractMessageLite$Builder$LimitedInputStream = new AbstractMessageLite$Builder$LimitedInputStream(inputStream, n3);
        this.mergeFrom(abstractMessageLite$Builder$LimitedInputStream);
        return true;
    }

    @Override
    public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeDelimitedFrom(inputStream);
    }

    @Override
    public UnknownFieldSet$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(codedInputStream);
    }

    @Override
    public UnknownFieldSet$Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(byteString);
    }

    @Override
    public UnknownFieldSet$Builder mergeFrom(byte[] arrby, int n2, int n3) {
        try {
            CodedInputStream codedInputStream = CodedInputStream.newInstance(arrby, n2, n3);
            this.mergeFrom(codedInputStream);
            codedInputStream.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException var4_5) {
            throw var4_5;
        }
        catch (IOException var4_6) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", var4_6);
        }
    }

    @Override
    public UnknownFieldSet$Builder mergeFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(arrby);
    }

    @Override
    public UnknownFieldSet$Builder mergeFrom(byte[] arrby, int n2, int n3, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(arrby, n2, n3);
    }

    @Override
    public UnknownFieldSet$Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(inputStream);
    }

    @Override
    public boolean isInitialized() {
        return true;
    }

    static /* synthetic */ UnknownFieldSet$Builder access$000() {
        return UnknownFieldSet$Builder.create();
    }
}

