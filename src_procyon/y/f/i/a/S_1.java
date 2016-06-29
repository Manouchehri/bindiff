package y.f.i.a;

import y.f.*;

public class S
{
    public static final S a;
    public static final S b;
    public static final S c;
    public static final S d;
    
    public static S a(final y y) {
        if (y.a == y) {
            return S.a;
        }
        if (y.c == y) {
            return S.b;
        }
        if (y.d == y) {
            return S.d;
        }
        if (y.b == y) {
            return S.c;
        }
        return null;
    }
    
    public static S a(final aE ae) {
        if (ae.c()) {
            return S.a;
        }
        if (ae.d()) {
            return S.b;
        }
        if (ae.e()) {
            return S.c;
        }
        if (ae.f()) {
            return S.d;
        }
        return null;
    }
    
    public static S a(final ax ax) {
        return a(ax.e());
    }
    
    static {
        a = new S();
        b = new S();
        c = new S();
        d = new S();
    }
}
