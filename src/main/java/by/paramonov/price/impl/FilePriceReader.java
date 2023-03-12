package by.paramonov.price.impl;

import by.paramonov.entity.Product;
import by.paramonov.price.PriceReader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static by.paramonov.entity.Product.*;

@Component
public class FilePriceReader implements PriceReader {

    private static final String INPUT_PRICE_FILE_PATH = "src/main/resources/price.txt";
    private static final File INPUT_PRICE_FILE = new File(INPUT_PRICE_FILE_PATH);
    static String regexForPriceListFromFile = " ";
    @Override
    public List<Product> getPriceList() {
        List<Product> priceListFromFile = new ArrayList<>();
        try {
            FileReader fr = new FileReader(INPUT_PRICE_FILE);
            Scanner scanner = new Scanner(fr);
            if (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(regexForPriceListFromFile);
                int id = Integer.parseInt(split[0]);
                String[] priceAndDescription = new String[]{split[1], split[2]};
                priceListFromFile.add(aProduct().withId(id).withDescription(split[2]).withPrice(Double.parseDouble(split[1])).build());
                while (scanner.hasNextLine()) {
                    split = scanner.nextLine().split(regexForPriceListFromFile);
                    id = Integer.parseInt(split[0]);
                    priceAndDescription[0] = split[1];
                    priceAndDescription[1] = split[2];
                    priceListFromFile.add(aProduct().withId(id).withDescription(split[2]).withPrice(Double.parseDouble(split[1])).build());
                }
            }
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return priceListFromFile;
    }
}
