/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dess.app.gestion_etudiants.model;

/**
 *
 * @author ~mae*~
 */
public class Etudiant {
    private int idEtudiant;
    private String matricule;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;

    public Etudiant() {
    }

    public Etudiant(String matricule, String nom, String prenom, String telephone, String email) {
        
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "idEtudiant=" + idEtudiant + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", email=" + email + '}';
    }
    
    
}
