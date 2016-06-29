package y.f;

import java.io.*;

class ab
{
    private int a;
    private Writer b;
    private StringBuffer c;
    private String d;
    
    public ab(final Writer b) {
        (this.c = new StringBuffer(100)).append("\t\t\t\t");
        this.a = 0;
        this.b = b;
        this.d = System.getProperty("line.separator");
    }
    
    protected void a() {
        final boolean j = X.j;
        final int a = this.a;
        while (this.c.length() < a) {
            this.c.append(this.c.toString());
            if (j) {
                return;
            }
            if (j) {
                break;
            }
        }
        this.b.write(this.c.toString(), 0, a);
    }
    
    public void a(final String s) {
        this.a();
        this.b.write(s);
        this.b.write(this.d);
        this.a();
        this.b.write("[" + this.d);
        ++this.a;
    }
    
    protected void a(final String s, final String s2) {
        this.a();
        this.b.write(s);
        this.b.write(9);
        this.b.write(s2);
        this.b.write(this.d);
    }
    
    public void a(final String s, final double n) {
        this.a(s, Double.toString(n));
    }
    
    public void a(final String s, final int n) {
        this.a(s, Integer.toString(n));
    }
    
    public void b(final String s, final String s2) {
        this.a(s, this.b(s2));
    }
    
    protected String b(final String s) {
        final boolean j = X.j;
        int i = 0;
        char char1 = '\0';
        Label_0074: {
            while (i < s.length()) {
                final char c = char1 = s.charAt(i);
                if (j || ((char1 > '\u00ff' || c == '\n' || c == '&' || c == '\"') && !j)) {
                    break Label_0074;
                }
                ++i;
                if (j) {
                    goto Label_0073;
                }
            }
            goto Label_0073;
        }
        if (char1 == '\0') {
            return '\"' + s + '\"';
        }
        final StringBuffer sb = new StringBuffer(s.length() + 5);
        sb.append('\"');
        int k = 0;
        while (k < s.length()) {
            final char char2 = s.charAt(k);
            if (j) {
                return sb.toString();
            }
            Label_0243: {
                if (char2 > '\u00ff') {
                    sb.append("&#x");
                    sb.append(Integer.toHexString(char2));
                    sb.append(';');
                    if (!j) {
                        break Label_0243;
                    }
                }
                Label_0224: {
                    switch (char2) {
                        case '\"': {
                            sb.append("&quot;");
                            if (j) {
                                break Label_0224;
                            }
                            break Label_0243;
                        }
                        case '&': {
                            sb.append("&amp;");
                            if (j) {
                                break;
                            }
                            break Label_0243;
                        }
                    }
                }
                sb.append(char2);
            }
            ++k;
            if (j) {
                break;
            }
        }
        sb.append('\"');
        return sb.toString();
    }
    
    public void b() {
        --this.a;
        this.a();
        this.b.write("]" + this.d);
    }
}
