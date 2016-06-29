/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Extension$ExtensionType;

class ExtensionRegistry$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Extension$ExtensionType;

    static {
        $SwitchMap$com$google$protobuf$Extension$ExtensionType = new int[Extension$ExtensionType.values().length];
        try {
            ExtensionRegistry$1.$SwitchMap$com$google$protobuf$Extension$ExtensionType[Extension$ExtensionType.IMMUTABLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            ExtensionRegistry$1.$SwitchMap$com$google$protobuf$Extension$ExtensionType[Extension$ExtensionType.MUTABLE.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
    }
}

