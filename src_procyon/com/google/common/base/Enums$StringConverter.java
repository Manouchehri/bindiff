package com.google.common.base;

import java.io.*;
import javax.annotation.*;

final class Enums$StringConverter extends Converter implements Serializable
{
    private final Class enumClass;
    private static final long serialVersionUID = 0L;
    
    Enums$StringConverter(final Class clazz) {
        this.enumClass = (Class)Preconditions.checkNotNull(clazz);
    }
    
    protected Enum doForward(final String s) {
        return Enum.valueOf((Class<Enum>)this.enumClass, s);
    }
    
    protected String doBackward(final Enum enum1) {
        return enum1.name();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Enums$StringConverter && this.enumClass.equals(((Enums$StringConverter)o).enumClass);
    }
    
    @Override
    public int hashCode() {
        return this.enumClass.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.enumClass.getName());
        return new StringBuilder(29 + String.valueOf(value).length()).append("Enums.stringConverter(").append(value).append(".class)").toString();
    }
}
