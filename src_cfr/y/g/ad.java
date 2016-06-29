/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.Locale;
import java.util.StringTokenizer;
import y.g.X;
import y.g.a;
import y.g.p;

final class ad
extends a {
    ad() {
        Class class_ = X.q == null ? (X.q = X.a("java.util.Locale")) : X.q;
        super(class_);
    }

    @Override
    protected Object a(String string) {
        Locale locale;
        boolean bl2 = p.c;
        StringTokenizer stringTokenizer = new StringTokenizer(string, "_", false);
        String string2 = stringTokenizer.nextToken();
        if (!stringTokenizer.hasMoreTokens()) return new Locale(string2, "");
        String string3 = stringTokenizer.nextToken();
        if (stringTokenizer.hasMoreTokens()) {
            String string4 = stringTokenizer.nextToken();
            locale = new Locale(string2, string3, string4);
            if (!bl2) return locale;
        }
        locale = new Locale(string2, string3);
        if (!bl2) return locale;
        return new Locale(string2, "");
    }

    @Override
    protected String a(Object object) {
        Locale locale = (Locale)object;
        String string = locale.getLanguage();
        if (locale.getCountry().length() <= 0) return string;
        string = new StringBuffer().append(string).append("_").append(locale.getCountry()).toString();
        if (locale.getVariant().length() <= 0) return string;
        return new StringBuffer().append(string).append("_").append(locale.getVariant()).toString();
    }
}

