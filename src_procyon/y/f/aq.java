package y.f;

import y.g.*;
import y.c.*;

class aq extends p
{
    c a;
    private final an b;
    
    aq(final an b, final c a) {
        this.b = b;
        this.a = a;
    }
    
    public Object b(final Object o) {
        final aE ae = (aE)this.a.b(o);
        Label_0637: {
            if (ae != null && !ae.g()) {
                final boolean a = ae.a();
                final byte b = this.b.b();
                if (this.b.b(b)) {
                    Label_0304: {
                        switch (b) {
                            case 1: {
                                switch (ae.b()) {
                                    case 2: {
                                        return aE.a((byte)4, a);
                                    }
                                    case 8: {
                                        return aE.a((byte)1, a);
                                    }
                                    case 1: {
                                        return aE.a((byte)8, a);
                                    }
                                    case 4: {
                                        return aE.a((byte)2, a);
                                    }
                                    default: {
                                        break Label_0304;
                                    }
                                }
                                break;
                            }
                            case 3: {
                                switch (ae.b()) {
                                    case 2: {
                                        return aE.a((byte)8, a);
                                    }
                                    case 4: {
                                        return aE.a((byte)1, a);
                                    }
                                    case 1: {
                                        return aE.a((byte)4, a);
                                    }
                                    case 8: {
                                        return aE.a((byte)2, a);
                                    }
                                    default: {
                                        break Label_0304;
                                    }
                                }
                                break;
                            }
                            case 2: {
                                switch (ae.b()) {
                                    case 2: {
                                        return aE.a((byte)1, a);
                                    }
                                    case 4: {
                                        return ae;
                                    }
                                    case 1: {
                                        return aE.a((byte)2, a);
                                    }
                                    case 8: {
                                        return ae;
                                    }
                                    default: {
                                        break Label_0304;
                                    }
                                }
                                break;
                            }
                            case 0: {
                                switch (ae.b()) {
                                    case 2: {
                                        return ae;
                                    }
                                    case 4: {
                                        return aE.a((byte)8, a);
                                    }
                                    case 1: {
                                        return ae;
                                    }
                                    case 8: {
                                        return aE.a((byte)4, a);
                                    }
                                    default: {
                                        break Label_0304;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    if (!X.j) {
                        return ae;
                    }
                }
                Label_0561: {
                    switch (b) {
                        case 1: {
                            switch (ae.b()) {
                                case 2: {
                                    return aE.a((byte)8, a);
                                }
                                case 8: {
                                    return aE.a((byte)1, a);
                                }
                                case 1: {
                                    return aE.a((byte)4, a);
                                }
                                case 4: {
                                    return aE.a((byte)2, a);
                                }
                                default: {
                                    break Label_0561;
                                }
                            }
                            break;
                        }
                        case 3: {
                            switch (ae.b()) {
                                case 2: {
                                    return aE.a((byte)4, a);
                                }
                                case 4: {
                                    return aE.a((byte)1, a);
                                }
                                case 1: {
                                    return aE.a((byte)8, a);
                                }
                                case 8: {
                                    return aE.a((byte)2, a);
                                }
                                default: {
                                    break Label_0561;
                                }
                            }
                            break;
                        }
                        case 2: {
                            switch (ae.b()) {
                                case 2: {
                                    return aE.a((byte)1, a);
                                }
                                case 4: {
                                    return aE.a((byte)8, a);
                                }
                                case 1: {
                                    return aE.a((byte)2, a);
                                }
                                case 8: {
                                    return aE.a((byte)4, a);
                                }
                                default: {
                                    break Label_0637;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        return ae;
    }
}
