package br.com.github.davimc.ItSupport.dto.part;

import br.com.github.davimc.ItSupport.entities.Part;

import java.util.UUID;

public record PartDTO(UUID id, String name, double price, Double percentage, double salePrice, Integer quantity, String local) {
    public PartDTO (Part obj){
        this(obj.getId(), obj.getName(), obj.getPrice(), (obj.getPercentageSale()*100),
                obj.getPrice() + (obj.getPrice()*obj.getPercentageSale()), obj.getQuantity(),
                obj.getLocal().getName());
    }
}
