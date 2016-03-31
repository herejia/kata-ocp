class EvaluateurDeMultiples implements Evaluateur {
    private int multipleDe;

    EvaluateurDeMultiples(int multipleDe) {
        this.multipleDe = multipleDe;
    }

    public boolean evaluates(Saisie saisie) {
        return saisie.isMultipleDe(multipleDe);
    }
}
