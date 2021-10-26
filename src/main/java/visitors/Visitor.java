package visitors;

import commandes.Client;
import commandes.Commande;
import commandes.GroupeClient;
import commandes.Ligne;

public interface Visitor {
    void visit(GroupeClient groupeClient);
    void visit(Client client);
    void visit(Commande commande);
    void visit(Ligne ligne);
}
