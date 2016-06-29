/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Enums$StringConverter
extends Converter
implements Serializable {
    private final Class enumClass;
    private static final long serialVersionUID = 0;

    Enums$StringConverter(Class class_) {
        this.enumClass = (Class)Preconditions.checkNotNull(class_);
    }

    protected Enum doForward(String string) {
        return Enum.valueOf(this.enumClass, string);
    }

    protected String doBackward(Enum enum_) {
        return enum_.name();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Enums$StringConverter)) return false;
        Enums$StringConverter enums$StringConverter = (Enums$StringConverter)object;
        return this.enumClass.equals(enums$StringConverter.enumClass);
    }

    public int hashCode() {
        return this.enumClass.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.enumClass.getName());
        return new StringBuilder(29 + String.valueOf(string).length()).append("Enums.stringConverter(").append(string).append(".class)").toString();
    }
}

