package visitorsImpl;

import commandes.Client;
import commandes.Commande;
import commandes.GroupeClient;
import commandes.Ligne;
import visitors.Visitor;

public class PrintRapportCommandes implements Visitor {
    @Override
    public void visit(GroupeClient groupeClient) {
        System.out.println(groupeClient.getName());
    }

    @Override
    public void visit(Client client) {
        System.out.println(client.getName());
    }

    @Override
    public void visit(Commande commande) {
        System.out.println(commande.getName());
    }

    @Override
    public void visit(Ligne ligne) {
        System.out.println(String.format("%s %s",ligne.getName(), ligne.getSum()));
    }
}
