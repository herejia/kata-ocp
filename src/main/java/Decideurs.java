import java.util.HashMap;
import java.util.Map;

class Decideurs {
    private final Acteur acteurDefaut;
    private Map<Evaluateur, Acteur> decideurs;

    Decideurs(Acteur acteurDefaut) {
        decideurs = new HashMap<Evaluateur, Acteur>();
        this.acteurDefaut = acteurDefaut;
    }

    void agissez(FluxAffichage fluxAffichage, Saisie saisie) {
        Boolean aAgit = false;
        for (Map.Entry<Evaluateur, Acteur> entry : decideurs.entrySet()) {
            if (entry.getKey().evaluates(saisie)) {
                entry.getValue().agit(fluxAffichage, saisie);
                aAgit = true;
            }
        }
        if (!aAgit) {
            acteurDefaut.agit(fluxAffichage, saisie);
        }
    }

    void put(Evaluateur evaluateur, Acteur acteur) {
        decideurs.put(evaluateur, acteur);
    }
}
