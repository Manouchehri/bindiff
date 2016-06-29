package y.g;

import java.util.*;

final class ad extends a
{
    ad() {
        super((X.q == null) ? (X.q = X.a("java.util.Locale")) : X.q);
    }
    
    protected Object a(final String s) {
        final boolean c = p.c;
        final StringTokenizer stringTokenizer = new StringTokenizer(s, "_", false);
        final String nextToken = stringTokenizer.nextToken();
        if (stringTokenizer.hasMoreTokens()) {
            final String nextToken2 = stringTokenizer.nextToken();
            if (stringTokenizer.hasMoreTokens()) {
                final Locale locale = new Locale(nextToken, nextToken2, stringTokenizer.nextToken());
                if (!c) {
                    return locale;
                }
            }
            final Locale locale = new Locale(nextToken, nextToken2);
            if (!c) {
                return locale;
            }
        }
        return new Locale(nextToken, "");
    }
    
    protected String a(final Object o) {
        final Locale locale = (Locale)o;
        String s = locale.getLanguage();
        if (locale.getCountry().length() > 0) {
            s = s + "_" + locale.getCountry();
            if (locale.getVariant().length() > 0) {
                s = s + "_" + locale.getVariant();
            }
        }
        return s;
    }
}
