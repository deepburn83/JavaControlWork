package HomeWork;

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения телефонной книги
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу
        addContact(phoneBook, "Пупкин", generatePhoneNumber());
        addContact(phoneBook, "Лупкин", generatePhoneNumber());
        addContact(phoneBook, "Кнопкин", generatePhoneNumber());
        addContact(phoneBook, "Пупкин", generatePhoneNumber());
        addContact(phoneBook, "Кнопкин", generatePhoneNumber());

        // Выводим отсортированный список контактов по убыванию числа телефонов
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Если контакт уже существует, добавляем новый телефон к существующему списку
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            // Если контакт новый, создаем новую запись
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    // Метод для генерации случайного телефонного номера
    private static String generatePhoneNumber() {
        Random random = new Random();
        return "+7(" +
                String.format("%03d", random.nextInt(1000)) + ") " +
                String.format("%03d", random.nextInt(1000)) + "-" +
                String.format("%02d", random.nextInt(100)) + "-" +
                String.format("%02d", random.nextInt(100));
    }

    // Метод для вывода телефонной книги
    private static void printPhoneBook(Map<String, List<String>> phoneBook) {
        // Создаем список записей телефонной книги и сортируем его по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        // Выводим отсортированный список
        for (int i = sortedEntries.size() - 1; i >= 0; i--) {
            Map.Entry<String, List<String>> entry = sortedEntries.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

