package by.paramonov.model.incomearguments;

import by.paramonov.model.TypeOfArgument;
import lombok.Getter;

@Getter
public class ProductEntry extends ArgumentEntry {


    private final int productId;
    private final int productQuantity;

    public ProductEntry(TypeOfArgument type, int productId, int productQuantity) {
        super(type);
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
