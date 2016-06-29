package com.google.security.zynamics.zylib.disassembly;

public enum FunctionType
{
    NORMAL("NORMAL", 0), 
    LIBRARY("LIBRARY", 1), 
    IMPORT("IMPORT", 2), 
    THUNK("THUNK", 3), 
    ADJUSTOR_THUNK("ADJUSTOR_THUNK", 4), 
    INVALID("INVALID", 5), 
    UNKNOWN("UNKNOWN", 6);
    
    private FunctionType(final String s, final int n) {
    }
    
    public static FunctionType parseInt(final int n) {
        switch (n) {
            case 1: {
                return FunctionType.NORMAL;
            }
            case 2: {
                return FunctionType.LIBRARY;
            }
            case 3: {
                return FunctionType.IMPORT;
            }
            case 4: {
                return FunctionType.THUNK;
            }
            case 5: {
                return FunctionType.ADJUSTOR_THUNK;
            }
            case 6: {
                return FunctionType.INVALID;
            }
            case 7: {
                return FunctionType.UNKNOWN;
            }
            default: {
                throw new IllegalArgumentException(new StringBuilder(49).append("Internal Error: Invalid function type ").append(n).toString());
            }
        }
    }
    
    @Override
    public String toString() {
        switch (FunctionType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[this.ordinal()]) {
            case 1: {
                return "Normal";
            }
            case 2: {
                return "Library";
            }
            case 3: {
                return "Imported";
            }
            case 4: {
                return "Thunk";
            }
            case 5: {
                return "Adjustor Thunk";
            }
            case 6: {
                return "Invalid";
            }
            case 7: {
                return "Unknown";
            }
            default: {
                throw new IllegalArgumentException("Internal Error: Invalid function type");
            }
        }
    }
}
