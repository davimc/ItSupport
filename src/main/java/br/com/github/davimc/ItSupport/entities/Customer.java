package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@DiscriminatorValue(value = "C")
public class Customer extends User{
    
}
