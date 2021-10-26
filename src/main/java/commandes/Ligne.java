package commandes;

import visitables.PrePostVisitable;
import visitables.Visitable;
import visitors.PrePostVisitor;
import visitors.Visitor;

public class Ligne implements PrePostVisitable, Visitable {
    private String name;
    private int sum;

    public Ligne(String name, int sum){
        this.name = name;
        this.sum = sum;
    }

    @Override
    public void accept(PrePostVisitor prePostVisitor) {
        prePostVisitor.postVisit(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
