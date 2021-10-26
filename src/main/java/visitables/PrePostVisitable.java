package visitables;

import visitors.PrePostVisitor;

public interface PrePostVisitable {
    void accept(PrePostVisitor prePostVisitor);
}
