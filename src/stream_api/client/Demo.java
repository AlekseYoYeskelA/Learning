package stream_api.client;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<Client> clients = List.of(
                new Client(1, "Мужской", "Алексей", "Бусаров", 29, "Инженер", 777.77),
                new Client(2, "МУЖСКОЙ", "Кедр", "Шишкин", 33, "Лесник", 348.59),
                new Client(3, "Женский", "Мария", "Мирная", 19, "Менеджер по продажам", 874.91),
                new Client(4, "ЖеНскИЙ", "Алла", "Палкова", 42, "Бухгалтер", 666.666),
                new Client(5, "мужской", "Аркадий", "Укупник", 71, "Поющий пудель", 99999.99),
                new Client(6, "мУжСКой", "Гений", "Миллиардеров", 53, "Миллиардер", 123456789101112.13),
                new Client(7, "женский", "Илона", "Маскова", 27, "Модель космостарс", 333.69),
                new Client(8, "ЖЕНСКИЙ", "Инста", "Рилсова", 18, "Блогерка", (69 + 42 * 14.88 + 228 * 3.14) / 12)
        );

        System.out.println(findLowerSalaryAndSort(clients, 800));
        System.out.println("--------------------------------------------");
        System.out.println(canBuyVodka(clients));
        System.out.println("--------------------------------------------");
        System.out.println(groupingByGenderAndJob(clients));
        System.out.println("--------------------------------------------");
        System.out.println(groupingByNameLength(clients));
    }

    public static List<Client> findLowerSalaryAndSort(List<Client> clients, double maxSalary) {
        return clients.stream()
                .filter(client -> client.getSalary() <= maxSalary)
                .sorted(Comparator.comparingDouble(Client::getSalary))
                .toList();
    }

    public static List<String> canBuyVodka(List<Client> clients) {
        return clients.stream()
                .filter(client -> client.getAge() >= 21)
                .map(Client::getFullName)
                .sorted()
                .toList();
    }

    public static Map<String, List<String>> groupingByGenderAndJob(List<Client> clients) {
        return clients.stream()
                .filter(client -> client.getAge() < 50)
                .collect(Collectors.groupingBy(Client::getGender,
                        Collectors.mapping(Client::getJob, Collectors.toList())));
    }

    public static Map<Integer, String> groupingByNameLength(List<Client> clients) {
        return clients.stream()
                .map(Client::getName)
                .collect(Collectors.groupingBy(String::length, Collectors.joining(", ")));
    }
}
