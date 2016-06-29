/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$1;
import com.google.protobuf.UnknownFieldSet$Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class UnknownFieldSet$Field$Builder {
    private UnknownFieldSet$Field result;

    private UnknownFieldSet$Field$Builder() {
    }

    private static UnknownFieldSet$Field$Builder create() {
        UnknownFieldSet$Field$Builder unknownFieldSet$Field$Builder = new UnknownFieldSet$Field$Builder();
        unknownFieldSet$Field$Builder.result = new UnknownFieldSet$Field(null);
        return unknownFieldSet$Field$Builder;
    }

    public UnknownFieldSet$Field build() {
        if (UnknownFieldSet$Field.access$500(this.result) == null) {
            UnknownFieldSet$Field.access$502(this.result, Collections.emptyList());
        } else {
            UnknownFieldSet$Field.access$502(this.result, Collections.unmodifiableList(UnknownFieldSet$Field.access$500(this.result)));
        }
        if (UnknownFieldSet$Field.access$600(this.result) == null) {
            UnknownFieldSet$Field.access$602(this.result, Collections.emptyList());
        } else {
            UnknownFieldSet$Field.access$602(this.result, Collections.unmodifiableList(UnknownFieldSet$Field.access$600(this.result)));
        }
        if (UnknownFieldSet$Field.access$700(this.result) == null) {
            UnknownFieldSet$Field.access$702(this.result, Collections.emptyList());
        } else {
            UnknownFieldSet$Field.access$702(this.result, Collections.unmodifiableList(UnknownFieldSet$Field.access$700(this.result)));
        }
        if (UnknownFieldSet$Field.access$800(this.result) == null) {
            UnknownFieldSet$Field.access$802(this.result, Collections.emptyList());
        } else {
            UnknownFieldSet$Field.access$802(this.result, Collections.unmodifiableList(UnknownFieldSet$Field.access$800(this.result)));
        }
        if (UnknownFieldSet$Field.access$900(this.result) == null) {
            UnknownFieldSet$Field.access$902(this.result, Collections.emptyList());
        } else {
            UnknownFieldSet$Field.access$902(this.result, Collections.unmodifiableList(UnknownFieldSet$Field.access$900(this.result)));
        }
        UnknownFieldSet$Field unknownFieldSet$Field = this.result;
        this.result = null;
        return unknownFieldSet$Field;
    }

    public UnknownFieldSet$Field$Builder clear() {
        this.result = new UnknownFieldSet$Field(null);
        return this;
    }

    public UnknownFieldSet$Field$Builder mergeFrom(UnknownFieldSet$Field unknownFieldSet$Field) {
        if (!UnknownFieldSet$Field.access$500(unknownFieldSet$Field).isEmpty()) {
            if (UnknownFieldSet$Field.access$500(this.result) == null) {
                UnknownFieldSet$Field.access$502(this.result, new ArrayList());
            }
            UnknownFieldSet$Field.access$500(this.result).addAll(UnknownFieldSet$Field.access$500(unknownFieldSet$Field));
        }
        if (!UnknownFieldSet$Field.access$600(unknownFieldSet$Field).isEmpty()) {
            if (UnknownFieldSet$Field.access$600(this.result) == null) {
                UnknownFieldSet$Field.access$602(this.result, new ArrayList());
            }
            UnknownFieldSet$Field.access$600(this.result).addAll(UnknownFieldSet$Field.access$600(unknownFieldSet$Field));
        }
        if (!UnknownFieldSet$Field.access$700(unknownFieldSet$Field).isEmpty()) {
            if (UnknownFieldSet$Field.access$700(this.result) == null) {
                UnknownFieldSet$Field.access$702(this.result, new ArrayList());
            }
            UnknownFieldSet$Field.access$700(this.result).addAll(UnknownFieldSet$Field.access$700(unknownFieldSet$Field));
        }
        if (!UnknownFieldSet$Field.access$800(unknownFieldSet$Field).isEmpty()) {
            if (UnknownFieldSet$Field.access$800(this.result) == null) {
                UnknownFieldSet$Field.access$802(this.result, new ArrayList());
            }
            UnknownFieldSet$Field.access$800(this.result).addAll(UnknownFieldSet$Field.access$800(unknownFieldSet$Field));
        }
        if (UnknownFieldSet$Field.access$900(unknownFieldSet$Field).isEmpty()) return this;
        if (UnknownFieldSet$Field.access$900(this.result) == null) {
            UnknownFieldSet$Field.access$902(this.result, new ArrayList());
        }
        UnknownFieldSet$Field.access$900(this.result).addAll(UnknownFieldSet$Field.access$900(unknownFieldSet$Field));
        return this;
    }

    public UnknownFieldSet$Field$Builder addVarint(long l2) {
        if (UnknownFieldSet$Field.access$500(this.result) == null) {
            UnknownFieldSet$Field.access$502(this.result, new ArrayList());
        }
        UnknownFieldSet$Field.access$500(this.result).add(l2);
        return this;
    }

    public UnknownFieldSet$Field$Builder addFixed32(int n2) {
        if (UnknownFieldSet$Field.access$600(this.result) == null) {
            UnknownFieldSet$Field.access$602(this.result, new ArrayList());
        }
        UnknownFieldSet$Field.access$600(this.result).add(n2);
        return this;
    }

    public UnknownFieldSet$Field$Builder addFixed64(long l2) {
        if (UnknownFieldSet$Field.access$700(this.result) == null) {
            UnknownFieldSet$Field.access$702(this.result, new ArrayList());
        }
        UnknownFieldSet$Field.access$700(this.result).add(l2);
        return this;
    }

    public UnknownFieldSet$Field$Builder addLengthDelimited(ByteString byteString) {
        if (UnknownFieldSet$Field.access$800(this.result) == null) {
            UnknownFieldSet$Field.access$802(this.result, new ArrayList());
        }
        UnknownFieldSet$Field.access$800(this.result).add(byteString);
        return this;
    }

    public UnknownFieldSet$Field$Builder addGroup(UnknownFieldSet unknownFieldSet) {
        if (UnknownFieldSet$Field.access$900(this.result) == null) {
            UnknownFieldSet$Field.access$902(this.result, new ArrayList());
        }
        UnknownFieldSet$Field.access$900(this.result).add(unknownFieldSet);
        return this;
    }

    static /* synthetic */ UnknownFieldSet$Field$Builder access$300() {
        return UnknownFieldSet$Field$Builder.create();
    }
}

