import java.util.*;

public class Program {
    Scanner sc = new Scanner(System.in);
    Map<String, Set<Integer>> telephoneDirectory = new HashMap<>();
    public void run() {
        Data data = new Data();
        Print print = new Print();
        Change change = new Change();
        int key;
        while (true) {
            key = validationInput(0, "меню");
            switch (key) {
                case 0:
                    System.exit(0);
                case 1:
                    telephoneDirectory.put(data.getName(), data.getNumberPhone());
                    System.out.println("Контакт добавлен");
                    break;
                case 2:
                    if (!telephoneDirectory.isEmpty()) {
                        telephoneDirectory = change.changedContact(telephoneDirectory);
                    } else System.out.println("\nТелефонный справочник пуст!!!\n");
                    break;
                case 3:
                    if (!telephoneDirectory.isEmpty()) {
                        System.out.print("Введите имя: ");
                        data.deleteContact(telephoneDirectory, sc.next());
                    } else System.out.println("\nТелефонный справочник пуст!!!\n");
                    break;
                case 4:
                    if (!telephoneDirectory.isEmpty()) {
                        System.out.print("Введите имя: ");
                        print.printContact(telephoneDirectory, sc.next());
                    } else System.out.println("\nТелефонный справочник пуст!!!\n");
                    break;
                case 5:
                    if (!telephoneDirectory.isEmpty()) {
                        print.printAllContacts(sortedTelephoneDirectory());
                    } else System.out.println("\nТелефонный справочник пуст!!!\n");
                    break;
                default:
                    System.out.println("\nПункта " + key + "нет!!! Выберите другой пункт!!!\n");
                    break;
            }
        }
    }
    private List<Map.Entry<String, Set<Integer>>> sortedTelephoneDirectory() {
        Comparator<Map.Entry<String, Set<Integer>>> value = (((o1, o2) -> Integer.compare(o2.getValue().size(), o1.getValue().size())));
        List<Map.Entry<String, Set<Integer>>> list = new ArrayList<>(telephoneDirectory.entrySet());
        list.sort(value);
        return list;
    }
    private void printHint() {
        String msg = new StringBuilder()
                .append("\nМеню:\n")
                .append("* Добавить контакт - << 1 >>\n")
                .append("* Изменить контакт  - << 2 >>\n")
                .append("* Удалить контакт - << 3 >>\n")
                .append("* Просмотреть контакт - << 4 >>\n")
                .append("* Просмотреть все контакты - << 5 >>\n")
                .append("* Выйти - << 0 >>\n")
                .toString();
        System.out.println(msg);
    }
    private void printHintChange() {
        String msg = new StringBuilder()
                .append("\nПодменю:\n")
                .append("* Изменить имя - << 1 >>\n")
                .append("* Добавить номер телефона - << 2 >>\n")
                .append("* Изменить номер телефона  - << 3 >>\n")
                .append("* Удалить номер телефона - << 4 >>\n")
                .append("* Вернуться в меню - << 0 >>\n")
                .toString();
        System.out.println(msg);
    }
    public int validationInput(int i, String str) {
        try {
            if (i == 0) printHint();
            else printHintChange();
            System.out.print("Выберите пункт " + str + ": ");
            return Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("\nПункта " + str + " нет!!! Выберите другой пункт!!!\n");
            return validationInput(i, str);
        }
    }
}
