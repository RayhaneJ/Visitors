package visitorsImpl;

import commandes.Client;
import commandes.Commande;
import commandes.GroupeClient;
import commandes.Ligne;
import visitors.PrePostVisitor;

public class XMLRapportCommandes implements PrePostVisitor {

    @Override
    public void preVisit(GroupeClient groupeClient) {
        System.out.println(String.format("<%s>", groupeClient.getName()));
    }

    @Override
    public void preVisit(Client client) {
        System.out.println(String.format("<client name=\"%s\">", client.getName()));
    }

    @Override
    public void preVisit(Commande commande) {
        System.out.println(String.format("<commande name=\"%s\">", commande.getName()));
    }

    @Override
    public void preVisit(Ligne ligne) {
        System.out.println(String.format("<ligne name=\"%s\" sum=%s/>", ligne.getName(), ligne.getSum()));
    }

    @Override
    public void postVisit(GroupeClient groupeClient) {
        System.out.println(String.format("</groupe>"));
    }

    @Override
    public void postVisit(Client client) {
        System.out.println(String.format("</client>"));
    }

    @Override
    public void postVisit(Commande commande) {
        System.out.println(String.format("</commande>"));
    }

    @Override
    public void postVisit(Ligne ligne) {
        preVisit(ligne);
    }
}
