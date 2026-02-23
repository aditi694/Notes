import java.util.*;

public class Main1 {

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

// Products having at least one 5-star review
        List<Product> productsWithFiveStar = products.stream()
                .filter(product ->
                        product.getReviews().stream()
                                .anyMatch(review -> review.getRating() == 5)
                )
                .toList();
        productsWithFiveStar.forEach(p ->
                System.out.println(p.getName()));

        System.out.println();

// Products having at no  5-star review
        List<Product> no5star = products.stream()
                .filter(product ->
                        product.getReviews().stream()
                                .noneMatch(review -> review.getRating() == 5)
                )
                .toList();
        no5star.forEach(p ->
                System.out.println(p.getName()));

        System.out.println();

// Products having at least one 5-star review
        long count5star = products.stream()
                .filter(product ->
                        product.getReviews().stream()
                                .anyMatch(review -> review.getRating() == 5)
                )
                .count();
        System.out.println(count5star);

        System.out.println();


    }
}