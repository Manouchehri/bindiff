/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

public enum ReferenceType {
    CONDITIONAL_TRUE,
    CONDITIONAL_FALSE,
    UNCONDITIONAL,
    SWITCH,
    CALL_DIRECT,
    CALL_INDIRECT,
    CALL_VIRTUAL,
    DATA,
    DATA_STRING;
    

    private ReferenceType() {
    }

    public static ReferenceType convertIntToReferenceType(int n2) {
        switch (n2) {
            case 0: {
                return CONDITIONAL_TRUE;
            }
            case 1: {
                return CONDITIONAL_FALSE;
            }
            case 2: {
                return UNCONDITIONAL;
            }
            case 3: {
                return SWITCH;
            }
            case 4: {
                return CALL_DIRECT;
            }
            case 5: {
                return CALL_INDIRECT;
            }
            case 6: {
                return CALL_INDIRECT;
            }
            case 7: {
                return CALL_VIRTUAL;
            }
            case 8: {
                return DATA;
            }
            case 9: {
                return DATA_STRING;
            }
        }
        throw new IllegalArgumentException("Error type is outside of reference type range");
    }

    public static int convertReferenceTypeToInt(ReferenceType referenceType) {
        return referenceType.ordinal();
    }

    public static boolean isCodeReference(ReferenceType referenceType) {
        if (ReferenceType.isDataReference(referenceType)) return false;
        return true;
    }

    public static boolean isDataReference(ReferenceType referenceType) {
        if (referenceType.compareTo(CALL_VIRTUAL) >= 0) return true;
        return false;
    }
}

