/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jrgab
 */
public class CadastroModel {
    private int idCadastro; 
    private String nomeCadastro; 
    private String emailCadastro;
    private String senhaCadastro;

    public String getNomeCadastro() {
        return nomeCadastro;
    }

    public void setNomeCadastro(String nomeCadastro) {
        this.nomeCadastro = nomeCadastro;
    }

    public String getEmailCadastro() {
        return emailCadastro;
    }

    public void setEmailCadastro(String emailCadastro) {
        this.emailCadastro = emailCadastro;
    }

    public String getSenhaCadastro() {
        return senhaCadastro;
    }

    public void setSenhaCadastro(String senhaCadastro) {
        this.senhaCadastro = senhaCadastro;
    }
    
}
