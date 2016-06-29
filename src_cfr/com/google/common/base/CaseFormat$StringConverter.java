/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

final class CaseFormat$StringConverter
extends Converter
implements Serializable {
    private final CaseFormat sourceFormat;
    private final CaseFormat targetFormat;
    private static final long serialVersionUID = 0;

    CaseFormat$StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
        this.sourceFormat = (CaseFormat)((Object)Preconditions.checkNotNull((Object)caseFormat));
        this.targetFormat = (CaseFormat)((Object)Preconditions.checkNotNull((Object)caseFormat2));
    }

    protected String doForward(String string) {
        return this.sourceFormat.to(this.targetFormat, string);
    }

    protected String doBackward(String string) {
        return this.targetFormat.to(this.sourceFormat, string);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof CaseFormat$StringConverter)) return false;
        CaseFormat$StringConverter caseFormat$StringConverter = (CaseFormat$StringConverter)object;
        if (!this.sourceFormat.equals((Object)caseFormat$StringConverter.sourceFormat)) return false;
        if (!this.targetFormat.equals((Object)caseFormat$StringConverter.targetFormat)) return false;
        return true;
    }

    public int hashCode() {
        return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
    }

    public String toString() {
        String string = String.valueOf((Object)this.sourceFormat);
        String string2 = String.valueOf((Object)this.targetFormat);
        return new StringBuilder(14 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(".converterTo(").append(string2).append(")").toString();
    }
}

