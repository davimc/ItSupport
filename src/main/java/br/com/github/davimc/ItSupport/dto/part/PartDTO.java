package br.com.github.davimc.ItSupport.dto.part;

import br.com.github.davimc.ItSupport.entities.Part;
import lombok.Getter;

@Getter
public class PartDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    public PartDTO(Part obj) {
        id = obj.getId();
        name = obj.getName();
        price = obj.getPrice();
        quantity = obj.getQuantity();
    }

}
