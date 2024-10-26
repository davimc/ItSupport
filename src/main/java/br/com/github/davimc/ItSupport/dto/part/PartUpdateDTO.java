package br.com.github.davimc.ItSupport.dto.part;

import br.com.github.davimc.ItSupport.entities.Part;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PartUpdateDTO {
    //@Not(message = "Name cannot be empty")
    private String name;
    @PositiveOrZero(message = "Cannot change to a negative value")
    private Double price;
    @PositiveOrZero(message = "Cannot change to a negative value")
    private Double percentageSale;
    @PositiveOrZero(message = "Cannot change to a negative value")
    private Integer quantity;
    private UUID localId;

    public Part fromEntity(Part obj) {
        obj.setName(getName() != null? getName(): obj.getName());
        obj.setPrice(getPrice() != null? getPrice() : obj.getPrice());
        obj.setQuantity(getQuantity() != null? getQuantity() : obj.getQuantity());
        obj.setPercentageSale(getPercentageSale() != null?getPercentageSale():obj.getPercentageSale());

        return obj;
    }
}
