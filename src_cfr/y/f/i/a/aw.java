/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.f.i.a.ah;

class aW {
    private ah a;
    private ah b;

    aW(ah ah2, ah ah3) {
        this.a = ah2;
        this.b = ah3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aW)) {
            return false;
        }
        aW aW2 = (aW)object;
        if (this.a == null) return false;
        if (this.b == null) return false;
        if (aW2.a == null) return false;
        if (aW2.b == null) return false;
        if (!this.a.equals(aW2.a)) return false;
        if (!this.b.equals(aW2.b)) return false;
        return true;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : super.hashCode();
        return 31 * n2 + (this.b != null ? this.b.hashCode() : super.hashCode());
    }
}

