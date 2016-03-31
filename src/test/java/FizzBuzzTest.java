import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzTest {

    private static final EvaluateurDeMultiples MULTIPLE_3 = new EvaluateurDeMultiples(3);
    private static final EvaluateurDeMultiples MULTIPLE_5 = new EvaluateurDeMultiples(5);
    private static final EvaluateurDeMultiples MULTIPLE_15 = new EvaluateurDeMultiples(15);
    private static final EvaluateurDeMultiples MULTIPLE_14 = new EvaluateurDeMultiples(14);
    private static final EvaluateurDeMultiples MULTIPLE_10 = new EvaluateurDeMultiples(10);
    @Mock
    private FluxAffichage fluxAffichage;
    private FizzBuzz fizzBuzz;

    @Before
    public void doBefore() {
        Acteur acteurDefaut = new Acteur() {
            public void agit(FluxAffichage fluxAffichage, Saisie saisie) {
                fluxAffichage.afficher(String.valueOf(saisie.getValue()));
            }
        };
        Decideurs decideurs = new Decideurs(acteurDefaut);
        decideurs.put(MULTIPLE_3, newActeur("Fizz!"));
        decideurs.put(MULTIPLE_5, newActeur("Buzz!"));
        decideurs.put(MULTIPLE_15, newActeur("FizzBuzz!"));
        decideurs.put(MULTIPLE_14, newActeur("Bang!"));
        decideurs.put(MULTIPLE_10, newActeur("Boum"));

        fizzBuzz = new FizzBuzz(fluxAffichage, decideurs);
    }

    private Acteur newActeur(final String message) {
        return new Acteur() {
            public void agit(FluxAffichage fluxAffichage, Saisie saisie) {
                fluxAffichage.afficher(message);
            }
        };
    }

    @Test
    public void doit_afficher_zero_en_console_si_zero_saisi() {
        doitAfficher(0, "0");
    }
    
    @Test
    public void doit_afficher_fizz_si_est_multiple_de_trois() {
        doitAfficher(9, "Fizz!");
    }

    @Test
    public void doit_afficher_buzz_si_est_multiple_de_cinq() {
        doitAfficher(10, "Buzz!");
    }

    @Test
    public void doit_afficher_fizz_buzz_si_est_multiple_de_quinze() {
        doitAfficher(30, "FizzBuzz!");
    }

    @Test
    public void doit_afficher_bang_si_quatorze_saisi() {
        doitAfficher(14, "Bang!");
    }

    @Test
    public void doit_afficher_boom_si_10_est_saisi() {
        doitAfficher(10, "Boum");
    }

    private void doitAfficher(int value, String valeur) {
        Saisie saisie = Saisie.of(value);

        fizzBuzz.print(saisie);

        verify(fluxAffichage).afficher(valeur);
    }
}
