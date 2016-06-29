package y.b;

class m implements d
{
    private final d a;
    private n b;
    
    m(final d a, final n b) {
        this.a = a;
        this.b = b;
    }
    
    public void initAnimation() {
        this.a.initAnimation();
    }
    
    public void calcFrame(final double n) {
        this.a.calcFrame(this.b.a(n));
    }
    
    public void disposeAnimation() {
        this.a.disposeAnimation();
    }
    
    public long preferredDuration() {
        return this.a.preferredDuration();
    }
}
