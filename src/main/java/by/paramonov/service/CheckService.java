package by.paramonov.service;

import by.paramonov.entity.Order;
import by.paramonov.entity.Product;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CheckService {
    private static final String INPUT_PRICE_FILE_PATH = "src/main/resources/price.txt";
    private static final String OUTPUT_CHECK_FILE_PATH = "src/main/resources/check.txt";
    private static final File INPUT_PRICE_FILE = new File(INPUT_PRICE_FILE_PATH);
    static final File OUTPUT_CHECK_FILE = new File(OUTPUT_CHECK_FILE_PATH);
    static List<Product> priceListFromFile = new ArrayList<>();

    static {
        try {
            FileReader fr = new FileReader(INPUT_PRICE_FILE);
            Scanner scanner = new Scanner(fr);
            if (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(" ");
                int id = Integer.parseInt(split[0]);
                String[] priceAndDescription = new String[]{split[1], split[2]};
                priceListFromFile.add(new Product(id, split[2], Double.parseDouble(split[1])));
                while (scanner.hasNextLine()) {
                    split = scanner.nextLine().split(" ");
                    id = Integer.parseInt(split[0]);
                    priceAndDescription[0] = split[1];
                    priceAndDescription[1] = split[2];
                    priceListFromFile.add(new Product(id, split[2], Double.parseDouble(split[1])));
                }
            }
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
