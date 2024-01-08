package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "E")
public class Employee extends User{
    
}
