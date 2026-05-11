package fr.univ_amu.iut.exercice1;

/// Kata 1 - Années bissextiles.
///
/// Premier kata en pair programming. Kata court (~10-15 min) parfait pour poser
/// le rythme driver/navigator et les swaps de 7 minutes.
public class AnneesBissextiles {

  /// Détermine si une année est bissextile selon les règles du calendrier
  /// grégorien.
  ///
  /// @param annee année à tester (positive)
  /// @return `true` si l'année est bissextile, `false` sinon
  public static boolean estBissextile(int annee) {
    return (annee % 4 == 0 && annee % 100 != 0) || (annee % 4 == 0 && annee % 400 == 0);
  }
}
