package y.h;

import y.c.*;

public class gj implements o, cf
{
    int xe;
    boolean we;
    
    public gj() {
        this.xe = 0;
        this.we = false;
    }
    
    public void onGraph2DSelectionEvent(final ce ce) {
        this.we = true;
        if (this.xe == 0) {
            this.updateSelectionState(ce.e());
            this.we = false;
        }
    }
    
    public void onGraphEvent(final l l) {
        final boolean z = fj.z;
        Label_0138: {
            switch (l.a()) {
                case 12: {
                    ++this.xe;
                    if (z) {
                        break Label_0138;
                    }
                    break;
                }
                case 13: {
                    --this.xe;
                    if (!this.we || this.xe != 0) {
                        break;
                    }
                    this.updateSelectionState((bu)l.c());
                    this.we = false;
                    if (z) {
                        break Label_0138;
                    }
                    break;
                }
                case 0:
                case 1:
                case 3:
                case 5:
                case 6:
                case 7:
                case 10:
                case 11: {
                    this.we = true;
                    if (this.xe == 0) {
                        this.updateSelectionState((bu)l.c());
                        this.we = false;
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    protected void updateSelectionState(final bu bu) {
    }
}
