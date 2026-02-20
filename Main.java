import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        even number
        List<Integer> list7 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list7.stream().filter(n -> n % 2 == 0).toList());

//        greater than 50
        List<Integer> list8 = Arrays.asList(10, 55, 23, 67, 89, 12);
        System.out.println(list8.stream().filter(n -> n > 50).toList());

//        multiply with 3
        List<Integer> list9 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list9.stream().map(n -> n * 3).toList());

//        length
        List<String> words1 = Arrays.asList("java", "spring", "boot");
        System.out.println(words1.stream().map(String::length).toList());
//        uppercase
        List<String> word6 = Arrays.asList("java", "spring", "boot");
        System.out.println(word6.stream().map(String::toUpperCase).toList());

//        remove duplicates
        List<Integer> list11 = Arrays.asList(1, 22, 3, 4, 4, 5, 5, 6);
        System.out.println(list11.stream().distinct().toList());

//        sorting in asec
        List<Integer> list12 = Arrays.asList(0, 9, 5, 1, 7, 3, 2);
        System.out.println(list12.stream().sorted().toList());

//        sorting in desc
        List<Integer> list22 = Arrays.asList(0, 9, 5, 1, 7, 3, 2);
        //        not for large numbers
//        System.out.println(list2.stream().sorted((a,b)->(b-a)).toList());
        System.out.println(list22.stream().sorted(Comparator.reverseOrder()).toList());

        //        get first 5
        List<Integer> list33 = Arrays.asList(0, 9, 5, 1, 7, 3, 2);
        System.out.println(list33.stream().limit(5).toList());

//        skip 3
        List<Integer> list44 = Arrays.asList(0, 9, 5, 1, 7, 3, 2);
        System.out.println(list44.stream().skip(2).toList());

//        big questions
        List<Integer> list55 = Arrays.asList(0, 9, 5, 1, 7, 3, 2);
        System.out.println(list55.stream().filter(n -> n % 2 == 0).map(n -> n * 10).sorted(Comparator.reverseOrder()).distinct().limit(3).toList());

//        max in list
        List<Integer> list = Arrays.asList(0, 9, 5, 1, 7, 3, 2);
        Optional<Integer> maxValue = list.stream().max(Integer::compareTo);
        System.out.println(maxValue);

//        group by length of string
        List<String> word1 = Arrays.asList("java", "spring", "boot", "grapes");
        Map<Integer, List<String>> groupBy = word1.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupBy);

//        starting with A
        List<String> wordS = Arrays.asList("java", "spring", "Aboot", "grapes");
        List<String> wordStart = wordS.stream().filter(s -> s.startsWith("A") || s.startsWith("a")).toList();
        System.out.println(wordStart);

//       FIND DUPLICATE
        List<Integer> list1 = Arrays.asList(1, 22, 3, 4, 4, 5, 5, 6);
//        Set<Integer> seen = new HashSet<Integer>();
//        List<Integer> duplicateFind = list1.stream().filter(n -> !seen.add(n)).distinct().toList();
        List<Integer> duplicates = list1.stream().filter(n -> Collections.frequency(list1, n) > 1).distinct().toList();
        System.out.println(duplicates);

//        remove null values
        List<String> word5 = Arrays.asList("java", "spring", null, "grapes");
        List<String> removeNull = word5.stream().filter(n -> n != null).toList();
        System.out.println(removeNull);

//        flatten a list
        List<Integer> listB = Arrays.asList(4, 5, 6);
        List<Integer> listC = Arrays.asList(7, 8, 9);
        List<List<Integer>> listof = Arrays.asList(Arrays.asList(1, 2, 3), listB, listC);
        List<Integer> flatten = listof.stream().flatMap(List::stream).toList();
        System.out.println(flatten);

//        use of partioned for even/odd
        List<Integer> method = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> partionedBy = method.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partionedBy.get(true));
        System.out.println(partionedBy.get(false));

//        frequency of elements
        List<String> duplicateWords = Arrays.asList("java", "boot", "grapes", "spring", "boot", "java", "grapes");
        Map<String, Long> freqMap = duplicateWords.stream().collect(Collectors.groupingBy(word -> word, TreeMap::new, Collectors.counting()));
//      new way to write
//        Map<String, Long> freqMap = duplicateWords.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freqMap);

//        merge lists
        List<Integer> lista = Arrays.asList(4, 5, 6);
        List<Integer> listb = Arrays.asList(7, 8, 9);
        List<Integer> mergedList = Stream.concat(lista.stream(), listb.stream()).toList();
        System.out.println(mergedList);

//        to find first element
        List<String> first = Arrays.asList("java", "spring", "Aboot", "grapes");
        first.stream().findFirst().ifPresent(System.out::println);
//        System.out.println(first.get(0));

//        sum of elements
        List<Integer> sum = Arrays.asList(-1, 9, 5, 1, 7, 3, 2);
        System.out.println(sum.stream().mapToInt(Integer::intValue).sum());

//        max second in list
        List<Integer> secMax = Arrays.asList(0, 9, 5, 1, 7, 3, 2);
        Optional<Integer> second = secMax.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(second);

//        positive numbers
        List<Integer> pos = Arrays.asList(0, -9, 5, 1, 7, -3, 2);
        boolean allPos = pos.stream().allMatch(n -> n > 0);
        boolean allNeg = pos.stream().noneMatch(n -> n < 0);
        List<Integer> allNum = pos.stream().filter(n -> n > 0).toList();
        System.out.println("postive: " + allPos + " nums: " + allNum + " " + allNeg);

//        avg numbers
        List<Integer> avgNum = Arrays.asList(0, 9, 5, 1, 7, 3, 2);
        OptionalDouble avg = avgNum.stream().mapToInt(Integer::intValue).average();
        System.out.println(avg);

//        filter that alphabet contain
        List<String> filterWord = Arrays.asList("java", "spring", "Aboot", "grapes");
        List<String> restWord = filterWord.stream().filter(n -> n.toLowerCase().contains("p")).toList();
        System.out.println(restWord);

//        prime numbers
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> primes = numbers.stream()
                .filter(n -> {
                    if (n <= 1) return false;
                    for (int i = 2; i <= Math.sqrt(n); i++) {
                        if (n % i == 0) return false;
                    }
                    return true;
                }).toList();
        System.out.println(primes);

        //    length wise strings
        List<String> lenWise = Arrays.asList("apple", "banana", "kiwi", "oranges", "grapesss");
        List<String> sortedLen = lenWise.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).toList();
//        List<String> sortedLen = lenWise.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.println(sortedLen);

//        product of all
        List<Integer> pro = Arrays.asList(1, 2, 3, 4, 5, 6);
        int totalPro = pro.stream().reduce(1, (a, b) -> a * b);
        System.out.println(totalPro);

//        palindrome strings
        List<String> palindromeStrings = Arrays.asList("madam", "apple", "racecar", "banana", "level");
        List<String> checkString = palindromeStrings.stream().filter(n -> new StringBuilder(n)
                .reverse().toString().equals(n)).toList();
        System.out.println(checkString);

//        count characters
        List<String> countChara = Arrays.asList("madam", "apple", "racecar", "banana", "level");
        int totalChar = countChara.stream().mapToInt(String::length).sum();
        System.out.println(totalChar);
    }
}