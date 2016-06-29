package y.b;

import java.util.*;

abstract class s extends p
{
    long f;
    
    s() {
        this.f = 0L;
    }
    
    public void disposeAnimation() {
        final int a = e.a;
        if (this.a.isEmpty()) {
            this.b = false;
            return;
        }
        int i = this.a.size() - 1;
        while (i > -1) {
            ((d)this.a.get(i)).disposeAnimation();
            --i;
            if (a != 0) {
                return;
            }
            if (a != 0) {
                break;
            }
        }
        this.b = false;
    }
    
    public long preferredDuration() {
        final int a = e.a;
        if (this.c) {
            this.f = 0L;
            for (final d d : this.a) {
                if (d.preferredDuration() > this.f) {
                    this.f = d.preferredDuration();
                    if (a != 0) {
                        return this.f;
                    }
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
            }
            this.c = false;
        }
        return this.f;
    }
}
