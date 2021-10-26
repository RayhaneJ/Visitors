package commandes;

import visitables.PrePostVisitable;
import visitables.Visitable;
import visitors.PrePostVisitor;
import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Commande implements PrePostVisitable, Visitable {
    private String name;
    private List<Ligne> lignes;

    public void addLigne(Ligne ligne){
        lignes.add(ligne);
    }

    public Commande(String name){
        this.name = name;
        lignes = new ArrayList<>();
    }

    @Override
    public void accept(PrePostVisitor prePostVisitor) {
        prePostVisitor.preVisit(this);
        lignes.forEach((l) -> l.accept(prePostVisitor));
        prePostVisitor.postVisit(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        lignes.forEach((l) -> l.accept(visitor));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
