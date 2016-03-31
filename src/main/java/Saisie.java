class Saisie {
    private Integer value;

    private Saisie(Integer value) {
        this.value = value;
    }

    boolean isMultipleDe(int multipleDe) {
        return value != 0 && value % multipleDe == 0;
    }

    static Saisie of(int value) {
        return new Saisie(value);
    }

    Integer getValue() {
        return value;
    }
}
