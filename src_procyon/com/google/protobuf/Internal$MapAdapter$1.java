package com.google.protobuf;

final class Internal$MapAdapter$1 implements Internal$MapAdapter$Converter
{
    final /* synthetic */ Internal$EnumLiteMap val$enumMap;
    final /* synthetic */ Internal$EnumLite val$unrecognizedValue;
    
    Internal$MapAdapter$1(final Internal$EnumLiteMap val$enumMap, final Internal$EnumLite val$unrecognizedValue) {
        this.val$enumMap = val$enumMap;
        this.val$unrecognizedValue = val$unrecognizedValue;
    }
    
    public Internal$EnumLite doForward(final Integer n) {
        final Internal$EnumLite valueByNumber = this.val$enumMap.findValueByNumber(n);
        return (valueByNumber == null) ? this.val$unrecognizedValue : valueByNumber;
    }
    
    public Integer doBackward(final Internal$EnumLite internal$EnumLite) {
        return internal$EnumLite.getNumber();
    }
}
