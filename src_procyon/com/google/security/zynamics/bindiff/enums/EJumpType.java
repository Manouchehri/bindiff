package com.google.security.zynamics.bindiff.enums;

public enum EJumpType
{
    JUMP_TRUE("JUMP_TRUE", 0), 
    JUMP_FALSE("JUMP_FALSE", 1), 
    UNCONDITIONAL("UNCONDITIONAL", 2), 
    SWITCH("SWITCH", 3);
    
    private EJumpType(final String s, final int n) {
    }
    
    public static final int getOrdinal(final EJumpType eJumpType) {
        switch (EJumpType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[eJumpType.ordinal()]) {
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
            default: {
                throw new IllegalArgumentException("Unknown jump type.");
            }
        }
    }
    
    public static EJumpType getType(final int n) {
        switch (n) {
            case 0: {
                return EJumpType.JUMP_TRUE;
            }
            case 1: {
                return EJumpType.JUMP_FALSE;
            }
            case 2: {
                return EJumpType.UNCONDITIONAL;
            }
            case 3: {
                return EJumpType.SWITCH;
            }
            default: {
                throw new IllegalArgumentException(String.format("Unknown jump type %d.", n));
            }
        }
    }
}
