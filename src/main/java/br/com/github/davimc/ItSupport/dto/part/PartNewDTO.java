package br.com.github.davimc.ItSupport.dto.part;

import br.com.github.davimc.ItSupport.entities.Part;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class PartNewDTO {
    @NotNull(message = "name is required")
    @Size(min=2, message = "name must be at least 2 length")
    private String name;
    @NotNull(message = "price is required")
    @Positive(message = "price cannot be negative")
    private Double price;

    @NotNull(message = "quantity is required")
    @PositiveOrZero(message = "quantity cannot be negative")
    private Integer quantity;

    public Part copyToEntity() {
        return new Part(null, name, price, quantity);
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
