/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.TextFormat$1;
import com.google.protobuf.TextFormat$Parser;
import com.google.protobuf.TextFormat$Parser$SingularOverwritePolicy;

public class TextFormat$Parser$Builder {
    private boolean allowUnknownFields = false;
    private TextFormat$Parser$SingularOverwritePolicy singularOverwritePolicy = TextFormat$Parser$SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;

    public TextFormat$Parser$Builder setSingularOverwritePolicy(TextFormat$Parser$SingularOverwritePolicy textFormat$Parser$SingularOverwritePolicy) {
        this.singularOverwritePolicy = textFormat$Parser$SingularOverwritePolicy;
        return this;
    }

    public TextFormat$Parser build() {
        return new TextFormat$Parser(this.allowUnknownFields, this.singularOverwritePolicy, null);
    }
}

