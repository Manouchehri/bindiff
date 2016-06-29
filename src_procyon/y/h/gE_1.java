package y.h;

final class gE
{
    float a;
    float b;
    float c;
    float d;
    
    public gE(final float a, final float b, final float c, final float d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public float a(final float n) {
        return ((this.d * n + this.c) * n + this.b) * n + this.a;
    }
}
