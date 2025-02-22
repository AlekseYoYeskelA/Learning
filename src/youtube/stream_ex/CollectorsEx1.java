package youtube.stream_ex;

import javax.print.DocFlavor;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


public class CollectorsEx1 {
    //группировка отделов по начальникам
    static Map<User, List<Department>> departmentByChief(Company company) {
        return company
                .departments()
                .collect(groupingBy(Department::chief));
    }

    //группировка названий отедлов по начальникам
    static Map<User, List<String>> departmentNamesByChief(Company company) {
        return company.departments()
                .collect(groupingBy(Department::chief,
                        mapping(Department::title, toList())
                ));
    }

    //группировка людей, которые подчиняются определенному начальнику
    static Map<User, Set<User>> supervisors(Company company) {
        return company.departments()
                .collect(groupingBy(Department::chief,
                        flatMapping(Department::users, toSet())
                ));
    }

    //группировка начальников по работникам (K = работник, V = начальник)
//    static Map<User, Set<User>> workers(Company company) {
//        return company.departments()
//                .collect(groupingBy(Department::users,
//                        flatMapping(Department::chief, toSet())));
//
//    }

    static Map<String, Integer> getLowestBookPriceByCategory(List<Book> list) {
        return list.stream()
                .collect(toMap(Book::getCategory,
                        Book::getPrice,
                        BinaryOperator.minBy(Comparator.naturalOrder())
                ));
    }

    public static void main(String[] args) {
        Company company = () -> Stream.empty();

        System.out.println(departmentByChief(company));
    }
}

