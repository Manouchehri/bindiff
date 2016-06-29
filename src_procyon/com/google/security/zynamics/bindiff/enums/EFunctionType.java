package com.google.security.zynamics.bindiff.enums;

public enum EFunctionType
{
    NORMAL("NORMAL", 0), 
    LIBRARY("LIBRARY", 1), 
    THUNK("THUNK", 2), 
    IMPORTED("IMPORTED", 3), 
    UNKNOWN("UNKNOWN", 4), 
    MIXED("MIXED", 5);
    
    private EFunctionType(final String s, final int n) {
    }
    
    public static int getOrdinal(final EFunctionType eFunctionType) {
        switch (EFunctionType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[eFunctionType.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
            default: {
                throw new IllegalArgumentException("Unknown raw function type.");
            }
        }
    }
    
    public static EFunctionType getType(final int n) {
        switch (n) {
            case 0: {
                return EFunctionType.NORMAL;
            }
            case 1: {
                return EFunctionType.LIBRARY;
            }
            case 2: {
                return EFunctionType.THUNK;
            }
            case 3: {
                return EFunctionType.IMPORTED;
            }
            case 4: {
                return EFunctionType.UNKNOWN;
            }
            case 5: {
                return EFunctionType.MIXED;
            }
            default: {
                throw new IllegalArgumentException("Unknown raw function type.");
            }
        }
    }
    
    public static String getTypeChar(final EFunctionType eFunctionType) {
        switch (EFunctionType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[eFunctionType.ordinal()]) {
            case 1: {
                return "N";
            }
            case 2: {
                return "L";
            }
            case 3: {
                return "T";
            }
            case 4: {
                return "I";
            }
            case 5: {
                return "U";
            }
            case 6: {
                return "Mixed Function Match";
            }
            default: {
                throw new IllegalArgumentException("Unknown raw function type.");
            }
        }
    }
    
    @Override
    public String toString() {
        switch (EFunctionType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[this.ordinal()]) {
            case 1: {
                return "Normal";
            }
            case 2: {
                return "Library";
            }
            case 3: {
                return "Thunk";
            }
            case 4: {
                return "Imported";
            }
            case 5: {
                return "Unknown";
            }
            case 6: {
                return "Mixed Function Match";
            }
            default: {
                throw new IllegalArgumentException("Unknown raw function type.");
            }
        }
    }
}
