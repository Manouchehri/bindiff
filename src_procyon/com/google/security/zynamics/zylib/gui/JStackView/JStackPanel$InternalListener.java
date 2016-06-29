package com.google.security.zynamics.zylib.gui.JStackView;

class JStackPanel$InternalListener implements IStackModelListener
{
    final /* synthetic */ JStackPanel this$0;
    
    private JStackPanel$InternalListener(final JStackPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void dataChanged() {
        this.this$0.repaint();
    }
}
