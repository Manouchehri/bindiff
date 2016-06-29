package y.f.c.a;

import y.f.*;

class bg
{
    final ax a;
    
    private bg(final ax a) {
        this.a = a;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && this.a == ((bg)o).a);
    }
    
    public int hashCode() {
        return this.a.hashCode();
    }
    
    static bg a(final ax ax) {
        return new bg(ax);
    }
}
