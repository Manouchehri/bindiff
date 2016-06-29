/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$EnumLite;

public enum Value$KindCase implements Internal$EnumLite
{
    NULL_VALUE(1),
    NUMBER_VALUE(2),
    STRING_VALUE(3),
    BOOL_VALUE(4),
    STRUCT_VALUE(5),
    LIST_VALUE(6),
    KIND_NOT_SET(0);
    
    private int value = 0;

    private Value$KindCase(int n3) {
        this.value = n3;
    }

    public static Value$KindCase valueOf(int n2) {
        switch (n2) {
            case 1: {
                return NULL_VALUE;
            }
            case 2: {
                return NUMBER_VALUE;
            }
            case 3: {
                return STRING_VALUE;
            }
            case 4: {
                return BOOL_VALUE;
            }
            case 5: {
                return STRUCT_VALUE;
            }
            case 6: {
                return LIST_VALUE;
            }
            case 0: {
                return KIND_NOT_SET;
            }
        }
        throw new IllegalArgumentException("Value is undefined for this oneof enum.");
    }

    @Override
    public int getNumber() {
        return this.value;
    }
}

