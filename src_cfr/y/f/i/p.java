/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.f.i.Q;
import y.f.i.R;
import y.g.e;

class P
extends R {
    private final Q a;

    P(byte by2, double d2, Q q2) {
        super(by2, d2);
        this.a = q2;
    }

    Q a() {
        return this.a;
    }

    @Override
    public int compareTo(Object object) {
        R r2 = (R)object;
        int n2 = e.a(this.j(), r2.j());
        if (n2 != 0) {
            return n2;
        }
        switch (this.k()) {
            case 3: {
                switch (r2.k()) {
                    case 3: {
                        return 0;
                    }
                    case 4: {
                        return 1;
                    }
                }
                return 0;
            }
            case 4: {
                switch (r2.k()) {
                    case 3: {
                        return -1;
                    }
                    case 4: {
                        return 0;
                    }
                }
                return 0;
            }
        }
        return 0;
    }

    public String toString() {
        String string;
        if (this.k() == 3) {
            string = "Start";
            return new StringBuffer().append("x = ").append(this.j()).append(", type = ").append(string).toString();
        }
        string = "End";
        return new StringBuffer().append("x = ").append(this.j()).append(", type = ").append(string).toString();
    }
}

