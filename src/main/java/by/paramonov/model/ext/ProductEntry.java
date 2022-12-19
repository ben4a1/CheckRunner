package by.paramonov.model.ext;

import by.paramonov.model.ArgumentEntry;
import by.paramonov.model.TypeOfArgument;
import lombok.Data;

public class ProductEntry extends ArgumentEntry {

    private int productId;
    private int productQuantity;

    public ProductEntry(TypeOfArgument type, int productId, int productQuantity) {
        super(type);
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
