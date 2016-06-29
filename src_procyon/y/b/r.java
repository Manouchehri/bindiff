package y.b;

final class r extends s
{
    boolean[] d;
    double[] e;
    
    public r() {
        this.d = null;
        this.e = null;
    }
    
    public void initAnimation() {
        final int a = y.b.e.a;
        this.b = true;
        if (this.a.isEmpty()) {
            return;
        }
        this.d = new boolean[this.a.size()];
        this.e = new double[this.a.size()];
        final double n = this.preferredDuration();
        int i = 0;
        while (i < this.a.size()) {
            final d d = this.a.get(i);
            d.initAnimation();
            this.d[i] = false;
            this.e[i] = ((0.0 < n) ? (d.preferredDuration() / n) : 0.0);
            ++i;
            if (a != 0) {
                break;
            }
        }
    }
    
    public void calcFrame(final double n) {
        final int a = y.b.e.a;
        if (this.a.isEmpty()) {
            return;
        }
        int i = 0;
        while (i < this.a.size()) {
            Label_0172: {
                if (n <= this.e[i]) {
                    double n2 = (0.0 < this.e[i]) ? (n / this.e[i]) : 1.0;
                    Label_0098: {
                        if (1.0 < n2) {
                            n2 = 1.0;
                            if (a == 0) {
                                break Label_0098;
                            }
                        }
                        if (0.0 > n2) {
                            n2 = 0.0;
                        }
                    }
                    this.a.get(i).calcFrame(n2);
                    if (1.0 != n2) {
                        break Label_0172;
                    }
                    this.d[i] = true;
                    if (a == 0) {
                        break Label_0172;
                    }
                }
                if (!this.d[i]) {
                    ((d)this.a.get(i)).calcFrame(1.0);
                    this.d[i] = true;
                }
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
    }
}
