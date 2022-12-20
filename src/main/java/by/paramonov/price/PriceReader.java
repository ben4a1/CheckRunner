package by.paramonov.price;

import by.paramonov.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PriceReader {
    List<Product> getPriceList();
}
