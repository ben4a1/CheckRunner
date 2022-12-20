package by.paramonov.model.incomeentries;

import by.paramonov.model.TypeOfArgument;
import lombok.Getter;

import java.util.Objects;

@Getter
public class ProductEntry extends ArgumentEntry {

    private final int productId;
    private final int productQuantity;

    public ProductEntry(TypeOfArgument type, int productId, int productQuantity) {
        super(type);
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntry that)) return false;
        return productId == that.productId && productQuantity == that.productQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productQuantity);
    }
}
