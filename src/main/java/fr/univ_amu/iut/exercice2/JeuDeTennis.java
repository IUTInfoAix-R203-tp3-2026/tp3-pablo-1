package fr.univ_amu.iut.exercice2;

import java.util.List;

/// Kata 2 - Jeu de tennis.
///
/// Classe d'état qui gère le scoring d'un jeu de tennis entre deux joueurs.
/// Pratique idéale pour découvrir comment structurer une **machine à états** et
/// comment un test bien nommé devient une spécification lisible.
public class JeuDeTennis {

  private final String joueur1;
  private final String joueur2;
  private int points1;
  private int points2;

  public JeuDeTennis(String joueur1, String joueur2) {
    this.joueur1 = joueur1;
    this.joueur2 = joueur2;
  }

  /// Enregistre un point pour le joueur dont le nom est passé en argument.
  public void marquerPoint(String joueur) {
    // TODO kata 2 : incrémenter le compteur du joueur qui vient de marquer.

    List<Integer> lpoints = List.of(0, 15, 30, 40);

    if (joueur == joueur1) {
      if (points1 == 1 || points1 == 40 && points2 == 0 || points1 == 40 && points2 == 15) {
        points1 = 2;
      }
      if (points1 == 40) {
        points1 = 1;
      } else {
        for (int i = 0; i < 3; i++) {
          if (points1 == lpoints.get(i)) {
            points1 = lpoints.get(i + 1);
            break;
          }
        }
      }
    } else {
      if (points2 == 1 || points1 == 0 && points2 == 40 || points1 == 15 && points2 == 40) {
        points2 = 2;
      }
      if (points2 == 40) {
        points2 = 1;
      } else {
        for (int i = 0; i < 3; i++) {
          if (points2 == lpoints.get(i)) {
            points2 = lpoints.get(i + 1);
            break;
          }
        }
      }
    }
    if (points1 == points2 && points1 == 1) {
      points1 = 40;
      points2 = 40;
    }
  }

  /// Retourne la représentation textuelle du score courant.
  public String getScore() {
    // TODO kata 2 : construire la chaîne du score en gérant les cas :
    // - <4 points chacun et pas d'égalité à 40 : "X-Y" (ex "15-30")
    // - égalité >=3 : "Égalité"
    // - après Égalité, un joueur mène d'un point : "Avantage <nom>"
    // - un joueur a 4 points et 2 d'avance : "Jeu pour <nom>"
    if (points1 == 40 && points2 == 40) {
      return "Égalité";
    }
    if (points1 == 1) {
      return "Avantage " + joueur1;
    }
    if (points2 == 1) {
      return "Avantage " + joueur2;
    }
    if (points1 == 2) {
      return "Jeu pour " + joueur1;
    }
    if (points2 == 2) {
      return "Jeu pour " + joueur2;
    } else {
      String score = points1 + "-" + points2;
      return score;
    }
  }
}
