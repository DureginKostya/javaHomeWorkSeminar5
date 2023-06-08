import java.util.*;

public class Data {
    Scanner sc = new Scanner(System.in);
    public String getName() {
        System.out.print("Введите имя: ");
        return sc.next();
    }
    public Set<Integer> getNumberPhone() {
        Set<Integer> numPhone = new HashSet<>();
        while (true) {
            numPhone.add(validationData("Введите номер телефона: "));
            if (Objects.equals(validationAddPhone().toLowerCase().trim(), "n")) return numPhone;
        }
    }
    public void deleteContact(Map<String, Set<Integer>> phoneBook, String name) {
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            System.out.println("Контакт удален");
        }
        else System.out.println("\nКонтакт не найден!!!\n");
    }
    public int validationData(String msg) {
        try {
            System.out.print(msg);
            return Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("\nВведен некорректный номер телефона!!! Повторите ввод!!!\n");
            return validationData(msg);
        }
    }
    private String validationAddPhone() {
        String value;
        while (true) {
            System.out.print("Добавить номер телефона [y/n]: ");
            value = sc.next();
            if (Objects.equals(value, "n") || Objects.equals(value, "y")) return value;
            else System.out.println("\nВведено некорректное значение!!! Повторите ввод!!!\n");
        }
    }
}
