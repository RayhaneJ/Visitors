package visitors;

import commandes.Client;
import commandes.Commande;
import commandes.GroupeClient;
import commandes.Ligne;

public interface PrePostVisitor {
    void preVisit(GroupeClient groupeClient);
    void preVisit(Client client);
    void preVisit(Commande commande);
    void preVisit(Ligne ligne);
    void postVisit(GroupeClient client);
    void postVisit(Client client);
    void postVisit(Commande commande);
    void postVisit(Ligne ligne);
}
