package commandes;

import visitables.PrePostVisitable;
import visitables.Visitable;
import visitors.PrePostVisitor;
import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class GroupeClient implements PrePostVisitable, Visitable {
    private String name;
    private List<Client> clients;

    public GroupeClient(String name){
        this.name = name;
        clients = new ArrayList<>();
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public void addCommande(String client, Commande commande){
        Client retrievedClient = clients.stream().filter((c) -> c.getName() == client)
                .findFirst().orElse(null);
        retrievedClient.addCommande(commande);
    }

    public void addLigne(String commande, Ligne ligne){
        Commande retrievedCommande = clients.stream()
                .flatMap(c -> c.getCommandes().stream())
                .filter(co -> co.getName() == commande)
                .findFirst().orElse(null);
        retrievedCommande.addLigne(ligne);
    }

    @Override
    public void accept(PrePostVisitor prePostVisitor) {
        prePostVisitor.preVisit(this);
        clients.forEach((c) -> c.accept(prePostVisitor));
        prePostVisitor.postVisit(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        clients.forEach((c) -> visitor.visit(c));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }
}
