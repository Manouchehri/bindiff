package com.google.common.base;

import java.io.*;
import javax.annotation.*;

final class CaseFormat$StringConverter extends Converter implements Serializable
{
    private final CaseFormat sourceFormat;
    private final CaseFormat targetFormat;
    private static final long serialVersionUID = 0L;
    
    CaseFormat$StringConverter(final CaseFormat caseFormat, final CaseFormat caseFormat2) {
        this.sourceFormat = (CaseFormat)Preconditions.checkNotNull(caseFormat);
        this.targetFormat = (CaseFormat)Preconditions.checkNotNull(caseFormat2);
    }
    
    protected String doForward(final String s) {
        return this.sourceFormat.to(this.targetFormat, s);
    }
    
    protected String doBackward(final String s) {
        return this.targetFormat.to(this.sourceFormat, s);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof CaseFormat$StringConverter) {
            final CaseFormat$StringConverter caseFormat$StringConverter = (CaseFormat$StringConverter)o;
            return this.sourceFormat.equals(caseFormat$StringConverter.sourceFormat) && this.targetFormat.equals(caseFormat$StringConverter.targetFormat);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.sourceFormat);
        final String value2 = String.valueOf(this.targetFormat);
        return new StringBuilder(14 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(".converterTo(").append(value2).append(")").toString();
    }
}
