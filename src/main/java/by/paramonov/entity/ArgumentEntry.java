package by.paramonov.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
public class ArgumentEntry extends BaseEntity implements Comparator<ArgumentEntry> {
    private int productId;
    private int productQuantity;

    public ArgumentEntry() {
    }

    public ArgumentEntry(int productId, int productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    @Override
    public int compare(ArgumentEntry o1, ArgumentEntry o2) {
        return o1.productId - o2.productId;
    }
}
