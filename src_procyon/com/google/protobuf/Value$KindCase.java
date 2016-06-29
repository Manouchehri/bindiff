package com.google.protobuf;

public enum Value$KindCase implements Internal$EnumLite
{
    NULL_VALUE("NULL_VALUE", 0, 1), 
    NUMBER_VALUE("NUMBER_VALUE", 1, 2), 
    STRING_VALUE("STRING_VALUE", 2, 3), 
    BOOL_VALUE("BOOL_VALUE", 3, 4), 
    STRUCT_VALUE("STRUCT_VALUE", 4, 5), 
    LIST_VALUE("LIST_VALUE", 5, 6), 
    KIND_NOT_SET("KIND_NOT_SET", 6, 0);
    
    private int value;
    
    private Value$KindCase(final String s, final int n, final int value) {
        this.value = 0;
        this.value = value;
    }
    
    public static Value$KindCase valueOf(final int n) {
        switch (n) {
            case 1: {
                return Value$KindCase.NULL_VALUE;
            }
            case 2: {
                return Value$KindCase.NUMBER_VALUE;
            }
            case 3: {
                return Value$KindCase.STRING_VALUE;
            }
            case 4: {
                return Value$KindCase.BOOL_VALUE;
            }
            case 5: {
                return Value$KindCase.STRUCT_VALUE;
            }
            case 6: {
                return Value$KindCase.LIST_VALUE;
            }
            case 0: {
                return Value$KindCase.KIND_NOT_SET;
            }
            default: {
                throw new IllegalArgumentException("Value is undefined for this oneof enum.");
            }
        }
    }
    
    public int getNumber() {
        return this.value;
    }
}
