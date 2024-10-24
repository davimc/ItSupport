package br.com.github.davimc.ItSupport.dto.part;

import br.com.github.davimc.ItSupport.entities.Part;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PartNewDTO {
    @NotNull(message = "name is required")
    @Size(min=2, message = "name must have at least two letters")
    private String name;

    @NotNull(message = "price is required")
    @PositiveOrZero(message = "price must be positive")
    private double price;
    @PositiveOrZero(message = "quantity must be positive")
    private int quantity;

    @PositiveOrZero(message = "percentage must be positive")
    private double percentageSale;

    private UUID localId;

    public Part copyToEntity() {
        return new Part(null,name,price,percentageSale,quantity,null, null);
    }
}
