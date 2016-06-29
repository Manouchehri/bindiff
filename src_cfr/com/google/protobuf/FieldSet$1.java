/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

class FieldSet$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;
    static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

    static {
        $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat$FieldType.values().length];
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.DOUBLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.FLOAT.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.INT64.ordinal()] = 3;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.UINT64.ordinal()] = 4;
        }
        catch (NoSuchFieldError var0_3) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.INT32.ordinal()] = 5;
        }
        catch (NoSuchFieldError var0_4) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.FIXED64.ordinal()] = 6;
        }
        catch (NoSuchFieldError var0_5) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.FIXED32.ordinal()] = 7;
        }
        catch (NoSuchFieldError var0_6) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.BOOL.ordinal()] = 8;
        }
        catch (NoSuchFieldError var0_7) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.GROUP.ordinal()] = 9;
        }
        catch (NoSuchFieldError var0_8) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.MESSAGE.ordinal()] = 10;
        }
        catch (NoSuchFieldError var0_9) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.STRING.ordinal()] = 11;
        }
        catch (NoSuchFieldError var0_10) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.BYTES.ordinal()] = 12;
        }
        catch (NoSuchFieldError var0_11) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.UINT32.ordinal()] = 13;
        }
        catch (NoSuchFieldError var0_12) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.SFIXED32.ordinal()] = 14;
        }
        catch (NoSuchFieldError var0_13) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.SFIXED64.ordinal()] = 15;
        }
        catch (NoSuchFieldError var0_14) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.SINT32.ordinal()] = 16;
        }
        catch (NoSuchFieldError var0_15) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.SINT64.ordinal()] = 17;
        }
        catch (NoSuchFieldError var0_16) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.ENUM.ordinal()] = 18;
        }
        catch (NoSuchFieldError var0_17) {
            // empty catch block
        }
        $SwitchMap$com$google$protobuf$WireFormat$JavaType = new int[WireFormat$JavaType.values().length];
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.INT.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0_18) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.LONG.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_19) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.FLOAT.ordinal()] = 3;
        }
        catch (NoSuchFieldError var0_20) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.DOUBLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError var0_21) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.BOOLEAN.ordinal()] = 5;
        }
        catch (NoSuchFieldError var0_22) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.STRING.ordinal()] = 6;
        }
        catch (NoSuchFieldError var0_23) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.BYTE_STRING.ordinal()] = 7;
        }
        catch (NoSuchFieldError var0_24) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.ENUM.ordinal()] = 8;
        }
        catch (NoSuchFieldError var0_25) {
            // empty catch block
        }
        try {
            FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.MESSAGE.ordinal()] = 9;
            return;
        }
        catch (NoSuchFieldError var0_26) {
            // empty catch block
        }
    }
}

