/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dess.app.gestion_etudiants;

/**
 *
 * @author ~mae*~
 */

import com.dess.app.gestion_etudiants.dao.EtudiantDAO;
import com.dess.app.gestion_etudiants.model.Etudiant;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final EtudiantDAO etudiantDAO = new EtudiantDAO();

    public static void main(String[] args) {
        int choix;
        do {
            afficherMenu();
            choix = lireEntier("Votre choix : ");
            switch (choix) {
                case 1 ->
                    ajouterEtudiant();
                case 2 ->
                    listerEtudiants();
                case 3 ->
                    rechercherEtudiant();
                case 4 ->
                    modifierTelephone();
                case 5 ->
                    modifierEmail();
                case 6 ->
                    supprimerEtudiant();
                case 7 ->
                    nbreTotalEtudiants();
                case 0 ->
                    System.out.println("Fin du programme.");
                default ->
                    System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void afficherMenu() {
        System.out.println("""
===== GESTION DES ETUDIANTS =====
1. Ajouter un étudiant
2. Lister les étudiants
3. Rechercher un étudiant
4. Modifier le téléphone d'un étudiant
5. Modifier l'email d'un étudiant                          
6. Supprimer un étudiant
7. Nombre total d'étudiants
0. Quitter
""");
    }

    private static void ajouterEtudiant() {
        System.out.println("\n--- Ajout d'un étudiant ---");
        String matricule = "";
        do {
            System.out.print("Matricule : ");
            matricule = scanner.nextLine();
        } while (matricule.equals(""));
        try {
            Etudiant etudiant = etudiantDAO.rechercherParMatricule(matricule);
            if (etudiant != null) {
                System.out.println("Ce matricule a déjà été attribué.\n");
                return;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche : " + e.getMessage());
        }
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Téléphone : ");
        String telephone = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        Etudiant etudiant = new Etudiant(
                matricule,
                nom,
                prenom,
                telephone,
                email
        );
        try {
            etudiantDAO.ajouter(etudiant);
            System.out.println("Étudiant ajouté avec succès.\n");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    private static void listerEtudiants() {
        System.out.println("\n--- Liste des étudiants ---");
        try {
            List<Etudiant> etudiants = etudiantDAO.lister();
            if (etudiants.isEmpty()) {
                System.out.println("Aucun étudiant enregistré.\n");
            } else {
                etudiants.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage : " + e.getMessage());
        }
    }

    private static void rechercherEtudiant() {
        System.out.println("\n--- Recherche d'un étudiant ---");
        System.out.println("""
                           1. Par matricule
                           2. Par nom
                           """);
        int choice = lireEntier("Votre choix : ");
        if (choice == 1) {
            System.out.print("Matricule : ");
            String matricule = scanner.nextLine();
            try {
                Etudiant etudiant = etudiantDAO.rechercherParMatricule(matricule);
                if (etudiant == null) {
                    System.out.println("Étudiant introuvable.\n");
                } else {
                    System.out.println(etudiant);
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la recherche : " + e.getMessage());
            }
        } else if (choice == 2) {
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            try {
                Etudiant etudiant = etudiantDAO.rechercherParNom(nom);
                if (etudiant == null) {
                    System.out.println("Étudiant introuvable.\n");
                } else {
                    System.out.println(etudiant);
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la recherche : " + e.getMessage());
            }
        } else {
            System.out.println("Choix invalide");
        }

    }

    private static void modifierTelephone() {
        System.out.println("\n--- Modification du téléphone ---");
        System.out.print("Matricule : ");
        String matricule = scanner.nextLine();
        System.out.print("Nouveau téléphone : ");
        String telephone = scanner.nextLine();
        try {
            boolean modifie = etudiantDAO.modifierTelephone(matricule, telephone);
            if (modifie) {
                System.out.println("Téléphone modifié avec succès.");
            } else {
                System.out.println("Aucun étudiant trouvé avec ce matricule.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification : "
                    + e.getMessage());
        }
    }

    private static void supprimerEtudiant() {
        System.out.println("\n--- Suppression d'un étudiant ---");
        System.out.print("Matricule : ");
        String matricule = scanner.nextLine();
        try {
            boolean supprime = etudiantDAO.supprimer(matricule);
            if (supprime) {
                System.out.println("Étudiant supprimé avec succès.");
            } else {
                System.out.println("Aucun étudiant trouvé avec ce matricule.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : "
                    + e.getMessage());
        }
    }

    private static int lireEntier(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un entier valide.");
            }
        }
    }

    private static void modifierEmail() {
        System.out.println("\n--- Modification de l'email ---");
        System.out.print("Matricule : ");
        String matricule = scanner.nextLine();
        System.out.print("Nouveau email : ");
        String email = scanner.nextLine();
        try {
            boolean modifie = etudiantDAO.modifierEmail(matricule, email);
            if (modifie) {
                System.out.println("Email modifié avec succès.");
            } else {
                System.out.println("Aucun étudiant trouvé avec ce matricule.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification : "
                    + e.getMessage());
        }
    }

    private static void nbreTotalEtudiants() {
        System.out.println("\n--- Nombre total d'étudiants ---");
        try {
            int nbre = etudiantDAO.nbreTotalEtudiants();
            System.out.println("Il y a un nombre total de " + nbre + " étudiant(s).");
        } catch (SQLException e) {
            System.out.println("Erreur lors du calcul: " + e.getMessage());
        }
    }
}
