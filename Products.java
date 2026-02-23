import java.util.*;
import java.util.stream.Collectors;

public class Products {

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(

                new Product("iPhone", "Electronics", 80000, 5, true,
                        Arrays.asList(
                                new Review("Rahul", 5, "Excellent"),
                                new Review("Amit", 4, "Very good"),
                                new Review("Sneha", 5, "Loved it")
                        )),

                new Product("Laptop", "Electronics", 70000, 2, true,
                        Arrays.asList(
                                new Review("Priya", 4, "Good performance"),
                                new Review("Rohit", 3, "Average battery")
                        )),

                new Product("Shoes", "Fashion", 3000, 10, true,
                        Arrays.asList(
                                new Review("Neha", 5, "Very comfortable"),
                                new Review("Arjun", 4, "Nice design")
                        )),

                new Product("T-shirt", "Fashion", 1500, 0, false,
                        Arrays.asList(
                                new Review("Karan", 2, "Not good"),
                                new Review("Simran", 3, "Okay product")
                        )),

                new Product("Watch", "Accessories", 5000, 3, true,
                        Arrays.asList(
                                new Review("Vikas", 5, "Premium feel"),
                                new Review("Riya", 4, "Worth buying")
                        )),

                new Product("Headphones", "Electronics", 2000, 0, false,
                        Arrays.asList(
                                new Review("Manish", 1, "Stopped working"),
                                new Review("Pooja", 2, "Not satisfied")
                        )),

                new Product("Bag", "Accessories", 2500, 7, true,
                        Arrays.asList(
                                new Review("Alok", 4, "Spacious"),
                                new Review("Nisha", 5, "Excellent quality")
                        ))
        );

        // All In-Stock Products
        List<Product> inStockProducts = products.stream()
                .filter(Product::isInStock)
                .toList();
        inStockProducts.forEach(p ->
                System.out.println("In Stock: " + p.getName() + " - " + p.getPrice())
        );

        System.out.println();

        // Out of Stock Products
        List<Product> outOfStock = products.stream()
                .filter(p -> !p.isInStock())
                .toList();
        outOfStock.forEach(p ->
                System.out.println("Out of Stock: " + p.getName() + " - " + p.getPrice())
        );

        System.out.println();

        //  Products Price > 5000
        List<Product> expensiveProducts = products.stream()
                .filter(p -> p.getPrice() > 5000)
                .toList();
        expensiveProducts.forEach(p ->
                System.out.println("Expensive: " + p.getName())
        );

        System.out.println();

        // Electronics Category
        List<Product> electronics = products.stream()
                .filter(p -> "Electronics".equals(p.getCategory()))
                .toList();
        electronics.forEach(p ->
                System.out.println("Category: " + p.getName() + " - " + p.getCategory())
        );

        System.out.println();

        // Quantity Greater Than 5
        List<Product> quantityGreaterThanFive = products.stream()
                .filter(p -> p.getQuantity() > 5)
                .toList();
        quantityGreaterThanFive.forEach(p ->
                System.out.println("Quantity > 5: " + p.getName())
        );

        System.out.println();

        //  Uppercase Name with Price
        List<String> nameAndPriceUppercase = products.stream()
                .map(p -> p.getName().toUpperCase() + " - " + p.getPrice())
                .toList();
        nameAndPriceUppercase.forEach(System.out::println);

        System.out.println();

        // Unique Categories
        List<String> uniqueCategories = products.stream()
                .map(Product::getCategory)
                .distinct()
                .toList();
        uniqueCategories.forEach(c ->
                System.out.println("Unique Category: " + c)
        );

        System.out.println();

        // Unique Prices
        List<Double> uniquePrices = products.stream()
                .map(Product::getPrice)
                .distinct()
                .toList();
        uniquePrices.forEach(p ->
                System.out.println("Unique Prices" + p));

        System.out.println();

        // Sort
        List<Double> sortPrice = products.stream()
                .map(Product::getPrice)
                .sorted()
                .toList();
        sortPrice.forEach(p ->
                System.out.println("get price asec: " + p));

        System.out.println();

        // Sort quantity
        List<Integer> sortQuantity = products.stream()
                .map(Product::getQuantity)
                .sorted()
                .toList();
        sortQuantity.forEach(p ->
                System.out.println("get quantity asec: " + p));

        System.out.println();

        // sort by category then price
        List<Product> sortCategoryThenPrice = products.stream()
                .sorted(
                        Comparator.comparing(Product::getCategory)
                                .thenComparing(Product::getPrice)
                )
                .toList();
        sortCategoryThenPrice.forEach(p ->
                System.out.println("get category and then price asec: " 
                        + p.getCategory() + " - " + p.getName() + " - " + p.getPrice()));

        System.out.println();

        // count
        long countStocks = products.stream()
                .filter(Product::isInStock)
                .count();
        System.out.println("countStocks: " + countStocks);

        System.out.println();

        // count in category
        long countElectronic = products.stream()
                .filter(p -> "Electronics".equals(p.getCategory()))
                .count();
        System.out.println("Count products in electrons: " + countElectronic);

        System.out.println();

        //count with price
        List<Product> countPrice = products.stream()
                .filter(p -> p.getPrice() > 10000)
                .toList();
        System.out.println("Count: " + countPrice.size());
        countPrice.forEach(p ->
                System.out.println("Product: " + p.getName() + " & Price: " + p.getPrice())
        );

        System.out.println();

        // most expense product
        Optional<Product> mostExpensive = products.stream()
                .max(Comparator.comparing(Product::getPrice));
        mostExpensive.ifPresent(p ->
                System.out.println("Most Expensive: "
                        + p.getName() + " & Price: " + p.getPrice())
        );

        System.out.println();

        // cheapest
        Optional<Product> mostCheapest = products.stream()
                .min(Comparator.comparing(Product::getPrice));
        mostCheapest.ifPresent(p ->
                System.out.println("Most Cheapest: "
                        + p.getName() + " & Price: " + p.getPrice())
        );

        System.out.println();

        //Highest quantity
        Optional<Product> highestQuantity = products.stream()
                .max(Comparator.comparing(Product::getQuantity));
        highestQuantity.ifPresent(p->
                System.out.println("Highest Quantity: "
                + p.getName() + "QUANTITY: " + p.getQuantity()));

        System.out.println();

        // total value
        double totalInventoryValue = products.stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
        System.out.println("Total Inventory Value: " + totalInventoryValue);

        System.out.println();

        //total price of all product
        double totalProduct = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Total prices: " + totalProduct);

        System.out.println();

        //group by category -- collect(Collector.groupingBY)
        Map<String , List<Product>> groupCategory = products.stream()
                .collect(Collectors.groupingBy
                        (Product::getCategory));
        groupCategory.forEach((category, list) -> {
            System.out.println("Category: " + category);
            list.forEach(p -> 
                    System.out.println("  - " + p.getName()));
        });

        System.out.println();

        //count products by category -- Collectors.counting()
        Map<String, Long> countPerCategory = products.stream()
                        .collect(Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.counting()
                        ));
        countPerCategory.forEach((category, count) ->
                System.out.println(category + " → " + count));

        System.out.println();

        //stock group by
        Map<Boolean, List<Product>> groupByStock =
                products.stream()
                        .collect(Collectors.groupingBy
                                (Product::isInStock));
        groupByStock.forEach((status, list) -> {
            System.out.println("InStock = " + status);
            list.forEach(p -> 
                    System.out.println("  - " + p.getName()));
        });

        System.out.println();

        //group by range of price 
        Map<String, List<Product>> groupByPriceRange =
                products.stream()
                        .collect(Collectors.groupingBy(p ->
                                p.getPrice() < 5000 ? "Below 5000" : "5000 and Above"
                        ));
        groupByPriceRange.forEach((range, list) -> {
            System.out.println("Range: " + range);
            list.forEach(p ->
                    System.out.println("  - " + p.getName() + " : " + p.getPrice()));
        });

        System.out.println();

        //partitioned
        Map<Boolean,List<Product>> partitionedStatus = products.stream()
                .collect(Collectors.partitioningBy(Product::isInStock));
        System.out.println("In stock:" );
        partitionedStatus.get(true).forEach(p->
                System.out.println(p.getName()));
        System.out.println("Out stock: ");
        partitionedStatus.get(false).forEach(p ->
                System.out.println(p.getName()));

        System.out.println();

        // find first
        Optional<Product> firstAbove50k = products.stream()
                .filter(p -> p.getPrice() > 50000)
                .findFirst();
        firstAbove50k.ifPresent(p ->
                System.out.println("First product above 50k: " + p.getName()));

        System.out.println();

        //find first out of stock
        Optional<Product> firstOutOfStock = products.stream()
                .filter(p -> !p.isInStock())
                .findFirst();
        firstOutOfStock.ifPresent(p ->
                System.out.println("First out of stock: " + p.getName()));

        // Average Product Price
        OptionalDouble averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average();
        averagePrice.ifPresent(avg ->
                System.out.println("Average Price: " + avg));

        System.out.println();

    }
}