package com.google.protobuf;

import java.util.*;

public final class UnknownFieldSet$Field$Builder
{
    private UnknownFieldSet$Field result;
    
    private static UnknownFieldSet$Field$Builder create() {
        final UnknownFieldSet$Field$Builder unknownFieldSet$Field$Builder = new UnknownFieldSet$Field$Builder();
        unknownFieldSet$Field$Builder.result = new UnknownFieldSet$Field(null);
        return unknownFieldSet$Field$Builder;
    }
    
    public UnknownFieldSet$Field build() {
        if (this.result.varint == null) {
            this.result.varint = Collections.emptyList();
        }
        else {
            this.result.varint = Collections.unmodifiableList((List<?>)this.result.varint);
        }
        if (this.result.fixed32 == null) {
            this.result.fixed32 = Collections.emptyList();
        }
        else {
            this.result.fixed32 = Collections.unmodifiableList((List<?>)this.result.fixed32);
        }
        if (this.result.fixed64 == null) {
            this.result.fixed64 = Collections.emptyList();
        }
        else {
            this.result.fixed64 = Collections.unmodifiableList((List<?>)this.result.fixed64);
        }
        if (this.result.lengthDelimited == null) {
            this.result.lengthDelimited = Collections.emptyList();
        }
        else {
            this.result.lengthDelimited = Collections.unmodifiableList((List<?>)this.result.lengthDelimited);
        }
        if (this.result.group == null) {
            this.result.group = Collections.emptyList();
        }
        else {
            this.result.group = Collections.unmodifiableList((List<?>)this.result.group);
        }
        final UnknownFieldSet$Field result = this.result;
        this.result = null;
        return result;
    }
    
    public UnknownFieldSet$Field$Builder clear() {
        this.result = new UnknownFieldSet$Field(null);
        return this;
    }
    
    public UnknownFieldSet$Field$Builder mergeFrom(final UnknownFieldSet$Field unknownFieldSet$Field) {
        if (!unknownFieldSet$Field.varint.isEmpty()) {
            if (this.result.varint == null) {
                this.result.varint = new ArrayList();
            }
            this.result.varint.addAll(unknownFieldSet$Field.varint);
        }
        if (!unknownFieldSet$Field.fixed32.isEmpty()) {
            if (this.result.fixed32 == null) {
                this.result.fixed32 = new ArrayList();
            }
            this.result.fixed32.addAll(unknownFieldSet$Field.fixed32);
        }
        if (!unknownFieldSet$Field.fixed64.isEmpty()) {
            if (this.result.fixed64 == null) {
                this.result.fixed64 = new ArrayList();
            }
            this.result.fixed64.addAll(unknownFieldSet$Field.fixed64);
        }
        if (!unknownFieldSet$Field.lengthDelimited.isEmpty()) {
            if (this.result.lengthDelimited == null) {
                this.result.lengthDelimited = new ArrayList();
            }
            this.result.lengthDelimited.addAll(unknownFieldSet$Field.lengthDelimited);
        }
        if (!unknownFieldSet$Field.group.isEmpty()) {
            if (this.result.group == null) {
                this.result.group = new ArrayList();
            }
            this.result.group.addAll(unknownFieldSet$Field.group);
        }
        return this;
    }
    
    public UnknownFieldSet$Field$Builder addVarint(final long n) {
        if (this.result.varint == null) {
            this.result.varint = new ArrayList();
        }
        this.result.varint.add(n);
        return this;
    }
    
    public UnknownFieldSet$Field$Builder addFixed32(final int n) {
        if (this.result.fixed32 == null) {
            this.result.fixed32 = new ArrayList();
        }
        this.result.fixed32.add(n);
        return this;
    }
    
    public UnknownFieldSet$Field$Builder addFixed64(final long n) {
        if (this.result.fixed64 == null) {
            this.result.fixed64 = new ArrayList();
        }
        this.result.fixed64.add(n);
        return this;
    }
    
    public UnknownFieldSet$Field$Builder addLengthDelimited(final ByteString byteString) {
        if (this.result.lengthDelimited == null) {
            this.result.lengthDelimited = new ArrayList();
        }
        this.result.lengthDelimited.add(byteString);
        return this;
    }
    
    public UnknownFieldSet$Field$Builder addGroup(final UnknownFieldSet set) {
        if (this.result.group == null) {
            this.result.group = new ArrayList();
        }
        this.result.group.add(set);
        return this;
    }
}
