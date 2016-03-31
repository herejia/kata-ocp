class FizzBuzz {
    private final FluxAffichage fluxAffichage;
    private final Decideurs decideurs;

    FizzBuzz(FluxAffichage fluxAffichage, Decideurs decideurs) {
        this.fluxAffichage = fluxAffichage;
        this.decideurs = decideurs;
    }

    void print(Saisie saisie) {
        decideurs.agissez(fluxAffichage, saisie);
    }
}
