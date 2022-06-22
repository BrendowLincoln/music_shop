package br.edu.femass.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Supplier {

    private Long id;
    private String cnpj;
    private String legalName;
    private String commercialName;


    @Override
    public String toString() {
        return "Code: " + this.id
                + "\nLegal Name: " + this.legalName
                + "\nCommercial Name: " + this.commercialName
                + "\n";
    }

}
