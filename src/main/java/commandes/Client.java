package commandes;

import visitables.PrePostVisitable;
import visitables.Visitable;
import visitors.PrePostVisitor;
import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Client implements PrePostVisitable, Visitable {
    private String name;
    private List<Commande> commandes;

    public Client(String name){
        this.name = name;
        commandes = new ArrayList<>();
    }

    public void addCommande(Commande commande){
        commandes.add(commande);
    }

    public List<Commande> getCommandes(){
        return commandes;
    }

    @Override
    public void accept(PrePostVisitor prePostVisitor) {
        prePostVisitor.preVisit(this);
        commandes.forEach((c) -> c.accept(prePostVisitor));
        prePostVisitor.postVisit(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        commandes.forEach(c -> c.accept(visitor));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
