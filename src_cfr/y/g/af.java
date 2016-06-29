/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import y.g.X;
import y.g.a;

final class af
extends a {
    af() {
        Class class_ = X.m == null ? (X.m = X.a("java.net.URL")) : X.m;
        super(class_);
    }

    @Override
    protected Object a(String string) {
        try {
            int n2;
            URL uRL;
            if (string.indexOf(":/") < 0) {
                return new File(string).toURL();
            }
            if (!string.startsWith("resource://")) return new URL(string);
            String string2 = string.substring("resource://".length());
            String string3 = null;
            String string4 = null;
            int n3 = string2.indexOf(35);
            if (n3 > 0) {
                string4 = string2.substring(n3);
                string2 = string2.substring(0, n3);
            }
            if ((n2 = string2.indexOf(63)) > 0) {
                string3 = string2.substring(n2);
                string2 = string2.substring(0, n2);
            }
            if ((uRL = this.getClass().getClassLoader().getResource(string2)) == null) return uRL;
            if (string4 == null && string3 == null) {
                return uRL;
            }
            string = uRL.toString();
            if (string3 != null) {
                string = new StringBuffer().append(string).append(string3).toString();
            }
            if (string4 == null) return new URL(string);
            string = new StringBuffer().append(string).append(string4).toString();
            return new URL(string);
        }
        catch (MalformedURLException var2_3) {
            throw new IllegalArgumentException(new StringBuffer().append("Could not convert URL from ").append(string).toString());
        }
    }

    @Override
    protected String a(Object object) {
        return ((URL)object).toString();
    }
}

