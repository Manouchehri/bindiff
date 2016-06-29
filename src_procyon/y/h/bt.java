package y.h;

import y.d.*;

final class bt implements gt
{
    final aZ a;
    
    public bt(final aZ a) {
        this.a = a;
    }
    
    public q getMinimumSize() {
        final bg n = this.a.a.n;
        if (n != null) {
            return n.a(this.a);
        }
        return new q(0.0, 0.0);
    }
    
    public q getMaximumSize() {
        final bg n = this.a.a.n;
        if (n != null) {
            return n.b(this.a);
        }
        return new q(Double.MAX_VALUE, Double.MAX_VALUE);
    }
}
