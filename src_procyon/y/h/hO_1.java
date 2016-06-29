package y.h;

import java.util.*;
import y.c.*;

abstract class hO implements Iterator
{
    final bu d;
    final int e;
    ArrayList f;
    int g;
    
    protected hO(final bu d, final int e) {
        this.d = d;
        this.e = e;
    }
    
    public boolean hasNext() {
        if (this.f == null) {
            this.c();
        }
        if (this.g > this.f.size() - 1) {
            this.g = 0;
            this.f.clear();
            this.a();
        }
        return !this.f.isEmpty();
    }
    
    public Object next() {
        if (this.hasNext()) {
            return this.f.get(this.g++);
        }
        throw new NoSuchElementException();
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    void c() {
        this.f = new ArrayList();
    }
    
    abstract void a();
    
    void a(final d d) {
        final boolean z = fj.z;
        if ((this.e & 0x2) != 0x0) {
            this.f.add(d);
        }
        final aB i = this.d.i(d);
        if ((this.e & 0x4) != 0x0) {
            this.f.add(i.getSourcePort());
            this.f.add(i.getTargetPort());
        }
        if ((this.e & 0x8) != 0x0) {
            final y bends = i.bends();
            while (bends.f()) {
                this.f.add(bends.a());
                bends.g();
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
        }
        if ((this.e & 0x20) != 0x0) {
            int j = 0;
            while (j < i.labelCount()) {
                this.f.add(i.getLabel(j));
                ++j;
                if (z) {
                    break;
                }
            }
        }
    }
    
    void a(final q q) {
        final boolean z = fj.z;
        if ((this.e & 0x1) != 0x0) {
            this.f.add(q);
        }
        final fj t = this.d.t(q);
        if ((this.e & 0x40) != 0x0) {
            int i = 0;
            while (i < t.portCount()) {
                this.f.add(t.getPort(i));
                ++i;
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
        }
        if ((this.e & 0x10) != 0x0) {
            int j = 0;
            while (j < t.labelCount()) {
                this.f.add(t.getLabel(j));
                ++j;
                if (z) {
                    break;
                }
            }
        }
    }
    
    void b(final d d) {
        final boolean z = fj.z;
        final aB i = this.d.i(d);
        Label_0153: {
            Label_0120: {
                if ((this.e & 0x20) != 0x0) {
                    int labelCount = i.labelCount();
                    while (labelCount-- > 0) {
                        this.f.add(i.getLabel(labelCount));
                        if (z) {
                            break Label_0120;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
                if ((this.e & 0x8) != 0x0) {
                    final y bends = i.bends();
                    bends.j();
                    while (bends.f()) {
                        this.f.add(bends.a());
                        bends.h();
                        if (z) {
                            break Label_0153;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
            }
            if ((this.e & 0x4) != 0x0) {
                this.f.add(i.getTargetPort());
                this.f.add(i.getSourcePort());
            }
        }
        if ((this.e & 0x2) != 0x0) {
            this.f.add(d);
        }
    }
    
    void b(final q q) {
        final boolean z = fj.z;
        final fj t = this.d.t(q);
        Label_0106: {
            if ((this.e & 0x10) != 0x0) {
                int labelCount = t.labelCount();
                while (labelCount-- > 0) {
                    this.f.add(t.getLabel(labelCount));
                    if (z) {
                        break Label_0106;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            if ((this.e & 0x40) != 0x0) {
                int portCount = t.portCount();
                while (portCount-- > 0) {
                    this.f.add(t.getPort(portCount));
                    if (z) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                }
            }
        }
        if ((this.e & 0x1) != 0x0) {
            this.f.add(q);
        }
    }
}
