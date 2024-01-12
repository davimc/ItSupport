package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service extends AuditableImpl{

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private User employee;

    @OneToMany(mappedBy = "service")
    private List<Authorization> authorizations = new ArrayList<>();
}
