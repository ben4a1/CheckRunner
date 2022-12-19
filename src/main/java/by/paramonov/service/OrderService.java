package by.paramonov.service;

import by.paramonov.entity.Product;
import by.paramonov.model.DiscountCard;
import by.paramonov.model.incomearguments.ArgumentEntry;
import by.paramonov.entity.Order;
import by.paramonov.model.incomearguments.CardEntry;
import by.paramonov.model.incomearguments.ProductEntry;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class OrderService {

    private static final String INPUT_PRICE_FILE_PATH = "src/main/resources/price.txt";
    private static final String OUTPUT_CHECK_FILE_PATH = "src/main/resources/check.txt";
    private static final File INPUT_PRICE_FILE = new File(INPUT_PRICE_FILE_PATH);
    static final File OUTPUT_CHECK_FILE = new File(OUTPUT_CHECK_FILE_PATH);
    static String regexForPriceListFromFile = " ";

    /**
     * Инициализация прайс-листа из файла 'src/main/resources/price.txt'.
     */
    public static List<Product> priceListFromFile = new ArrayList<>();

    static {
        try {
            FileReader fr = new FileReader(INPUT_PRICE_FILE);
            Scanner scanner = new Scanner(fr);
            if (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(regexForPriceListFromFile);
                int id = Integer.parseInt(split[0]);
                String[] priceAndDescription = new String[]{split[1], split[2]};
                priceListFromFile.add(new Product(id, split[2], Double.parseDouble(split[1])));
                while (scanner.hasNextLine()) {
                    split = scanner.nextLine().split(regexForPriceListFromFile);
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

    private final ArgumentService argumentService;

    public OrderService() {
        Order order = new Order();
        argumentService = new ArgumentService();
    }

    public void setInputOrderAndDiscountCard(String[] inputArgs, Order order) {
        Map<Integer, Integer> inputMap = new HashMap<>();
        List<ArgumentEntry> argumentEntries = argumentService.parseInputArguments(inputArgs);
        argumentEntries.forEach(x -> {
            if (x instanceof ProductEntry) {
                inputMap.put(((ProductEntry) x).getProductId(), ((ProductEntry) x).getProductQuantity());
            } else {
                order.setDiscountCard(DiscountCard.getDiscountCardById(((CardEntry) x).getCardNumber()));
            }
        });
        order.setInputOrder(inputMap);
    }

    public void setSummaryOrderList(Order order) {
        List<String[]> summOrderList = new LinkedList<>();
        order.getInputOrder().forEach((productId, quantity) -> {
            try {
                int quan = quantity;
                Product product = priceListFromFile.get(productId);
                double total = quan * product.getPrice();
                if (product.isPromotion()
                        && quan >= Order.quantityForDiscount) {
                    double temptDiscountValuePromotion = total * Order.quantityDiscount;
                    total -= temptDiscountValuePromotion;
                    order.setDiscountValuePromotion(order.getDiscountValuePromotion() + temptDiscountValuePromotion);
                }
                order.setTotalPrice(order.getTotalPrice() + total);
                String[] tempPosition = new String[]{String.format("%d", quan), // quantity
                        product.getDescription(), // description
                        String.format("%.2f", product.getPrice()), // price for one item
                        String.format("%.2f", total)}; // total price for item
                summOrderList.add(tempPosition);
            } catch (NullPointerException nullPointerException) {
                System.out.printf("Product with ID='%d' does not exist yet", productId);
            }
        });
        if (order.getDiscountCard() != null) {
            order.setDiscountValueCard(order.getTotalPrice() * order.getDiscountCard().getDiscountValue());
        }
        order.setTotalDiscount();
    }
}
