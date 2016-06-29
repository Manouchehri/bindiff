/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$MapAdapter$Converter;

final class Internal$MapAdapter$1
implements Internal$MapAdapter$Converter {
    final /* synthetic */ Internal$EnumLiteMap val$enumMap;
    final /* synthetic */ Internal$EnumLite val$unrecognizedValue;

    Internal$MapAdapter$1(Internal$EnumLiteMap internal$EnumLiteMap, Internal$EnumLite internal$EnumLite) {
        this.val$enumMap = internal$EnumLiteMap;
        this.val$unrecognizedValue = internal$EnumLite;
    }

    public Internal$EnumLite doForward(Integer n2) {
        Internal$EnumLite internal$EnumLite;
        Internal$EnumLite internal$EnumLite2 = this.val$enumMap.findValueByNumber(n2);
        if (internal$EnumLite2 == null) {
            internal$EnumLite = this.val$unrecognizedValue;
            return internal$EnumLite;
        }
        internal$EnumLite = internal$EnumLite2;
        return internal$EnumLite;
    }

    public Integer doBackward(Internal$EnumLite internal$EnumLite) {
        return internal$EnumLite.getNumber();
    }
}

