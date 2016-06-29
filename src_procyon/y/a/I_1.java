package y.a;

final class I
{
    public H a;
    public H b;
    
    public void a(final H h) {
        h.b = null;
        h.a = null;
        if (this.b == null) {
            this.b = h;
            this.a = h;
            if (!h.a) {
                return;
            }
        }
        this.b.a = h;
        h.b = this.b;
        this.b = h;
    }
    
    public void b(final H h) {
        final boolean a = h.a;
        Label_0035: {
            if (h != this.a) {
                h.b.a = h.a;
                if (!a) {
                    break Label_0035;
                }
            }
            this.a = h.a;
        }
        if (h != this.b) {
            h.a.b = h.b;
            if (!a) {
                return;
            }
        }
        this.b = h.b;
    }
}
