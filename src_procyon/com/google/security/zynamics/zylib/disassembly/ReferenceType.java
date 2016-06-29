package com.google.security.zynamics.zylib.disassembly;

public enum ReferenceType
{
    CONDITIONAL_TRUE("CONDITIONAL_TRUE", 0), 
    CONDITIONAL_FALSE("CONDITIONAL_FALSE", 1), 
    UNCONDITIONAL("UNCONDITIONAL", 2), 
    SWITCH("SWITCH", 3), 
    CALL_DIRECT("CALL_DIRECT", 4), 
    CALL_INDIRECT("CALL_INDIRECT", 5), 
    CALL_VIRTUAL("CALL_VIRTUAL", 6), 
    DATA("DATA", 7), 
    DATA_STRING("DATA_STRING", 8);
    
    private ReferenceType(final String s, final int n) {
    }
    
    public static ReferenceType convertIntToReferenceType(final int n) {
        switch (n) {
            case 0: {
                return ReferenceType.CONDITIONAL_TRUE;
            }
            case 1: {
                return ReferenceType.CONDITIONAL_FALSE;
            }
            case 2: {
                return ReferenceType.UNCONDITIONAL;
            }
            case 3: {
                return ReferenceType.SWITCH;
            }
            case 4: {
                return ReferenceType.CALL_DIRECT;
            }
            case 5: {
                return ReferenceType.CALL_INDIRECT;
            }
            case 6: {
                return ReferenceType.CALL_INDIRECT;
            }
            case 7: {
                return ReferenceType.CALL_VIRTUAL;
            }
            case 8: {
                return ReferenceType.DATA;
            }
            case 9: {
                return ReferenceType.DATA_STRING;
            }
            default: {
                throw new IllegalArgumentException("Error type is outside of reference type range");
            }
        }
    }
    
    public static int convertReferenceTypeToInt(final ReferenceType referenceType) {
        return referenceType.ordinal();
    }
    
    public static boolean isCodeReference(final ReferenceType referenceType) {
        return !isDataReference(referenceType);
    }
    
    public static boolean isDataReference(final ReferenceType referenceType) {
        return referenceType.compareTo(ReferenceType.CALL_VIRTUAL) >= 0;
    }
}
