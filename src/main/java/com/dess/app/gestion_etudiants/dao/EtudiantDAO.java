/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dess.app.gestion_etudiants.dao;

import com.dess.app.gestion_etudiants.config.DBConnection;
import com.dess.app.gestion_etudiants.model.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ~mae*~
 */
public class EtudiantDAO {

    public void ajouter(Etudiant etudiant) throws SQLException {
        String sql = "INSERT INTO etudiant(matricule, nom, prenom, telephone, email)"
                + "VALUES (?,?,?,?,?)";
        try (
                Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, etudiant.getMatricule());
            ps.setString(2, etudiant.getNom());
            ps.setString(3, etudiant.getPrenom());
            ps.setString(4, etudiant.getTelephone());
            ps.setString(5, etudiant.getEmail());

            ps.executeUpdate();

        }
    }

    public List<Etudiant> lister() throws SQLException {
        List<Etudiant> etudiants = new ArrayList<>();

        String sql = "SELECT id_etudiant, matricule, nom, prenom, telephone, email FROM etudiant ORDER BY id_etudiant";
        try (
                Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setIdEtudiant(rs.getInt("id_etudiant"));
                etudiant.setMatricule(rs.getString("matricule"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setTelephone(rs.getString("telephone"));
                etudiant.setEmail(rs.getString("email"));

                etudiants.add(etudiant);
            }
        }
        return etudiants;
    }

    public Etudiant rechercherParMatricule(String matricule) throws SQLException {
        String sql = "SELECT id_etudiant, matricule, nom, prenom, telephone, email FROM etudiant WHERE matricule = ?";
        try (
                Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, matricule);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Etudiant etudiant = new Etudiant();
                    etudiant.setIdEtudiant(rs.getInt("id_etudiant"));
                    etudiant.setMatricule(rs.getString("matricule"));
                    etudiant.setNom(rs.getString("nom"));
                    etudiant.setPrenom(rs.getString("prenom"));
                    etudiant.setTelephone(rs.getString("telephone"));
                    etudiant.setEmail(rs.getString("email"));
                    return etudiant;
                }
            }
        }
        return null;
    }

    public boolean modifierTelephone(String matricule, String nouveauTelephone) throws SQLException {
        String sql = "UPDATE etudiant SET telephone = ? WHERE matricule = ?";
        try (
                Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nouveauTelephone);
            ps.setString(2, matricule);
            int lignesModifiees = ps.executeUpdate();
            return lignesModifiees > 0;
        }
    }

    public boolean supprimer(String matricule) throws SQLException {
        String sql = "DELETE FROM etudiant WHERE matricule = ?";
        try (
                Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, matricule);
            int lignesSupprimees = ps.executeUpdate();
            return lignesSupprimees > 0;
        }
    }

    public boolean modifierEmail(String matricule, String nouveauEmail) throws SQLException {
        String sql = "UPDATE etudiant SET email = ? WHERE matricule = ?";
        try (
                Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nouveauEmail);
            ps.setString(2, matricule);
            int lignesModifiees = ps.executeUpdate();
            return lignesModifiees > 0;
        }
    }

    public Etudiant rechercherParNom(String nom) throws SQLException {
        String sql = "SELECT id_etudiant, matricule, nom, prenom, telephone, email FROM etudiant WHERE nom = ?";
        try (
                Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nom);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Etudiant etudiant = new Etudiant();
                    etudiant.setIdEtudiant(rs.getInt("id_etudiant"));
                    etudiant.setMatricule(rs.getString("matricule"));
                    etudiant.setNom(rs.getString("nom"));
                    etudiant.setPrenom(rs.getString("prenom"));
                    etudiant.setTelephone(rs.getString("telephone"));
                    etudiant.setEmail(rs.getString("email"));
                    return etudiant;
                }
            }
        }
        return null;
    }
    
     public int nbreTotalEtudiants() throws SQLException {
        String sql = "SELECT COUNT(matricule) AS total FROM etudiant ";
        try (
                Connection connection = DBConnection.getConnection();Statement ps = connection.createStatement()) {
            try (ResultSet rs = ps.executeQuery(sql)) {
                if (rs.next()) {
                   int nbreLignes=rs.getInt("total");
                   return nbreLignes;
                }
            }
        }
        return 0;
    }
}
