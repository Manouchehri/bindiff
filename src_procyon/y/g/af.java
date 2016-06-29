package y.g;

import java.io.*;
import java.net.*;

final class af extends a
{
    af() {
        super((X.m == null) ? (X.m = X.a("java.net.URL")) : X.m);
    }
    
    protected Object a(String s) {
        try {
            if (s.indexOf(":/") < 0) {
                return new File(s).toURL();
            }
            if (s.startsWith("resource://")) {
                String s2 = s.substring("resource://".length());
                String substring = null;
                String substring2 = null;
                final int index = s2.indexOf(35);
                if (index > 0) {
                    substring2 = s2.substring(index);
                    s2 = s2.substring(0, index);
                }
                final int index2 = s2.indexOf(63);
                if (index2 > 0) {
                    substring = s2.substring(index2);
                    s2 = s2.substring(0, index2);
                }
                final URL resource = this.getClass().getClassLoader().getResource(s2);
                if (resource == null || (substring2 == null && substring == null)) {
                    return resource;
                }
                s = resource.toString();
                if (substring != null) {
                    s += substring;
                }
                if (substring2 != null) {
                    s += substring2;
                }
            }
            return new URL(s);
        }
        catch (MalformedURLException ex) {
            throw new IllegalArgumentException("Could not convert URL from " + s);
        }
    }
    
    protected String a(final Object o) {
        return ((URL)o).toString();
    }
}
