import java.util.List;
import java.util.Map;
import java.util.Set;

public class Print {
    public void printContact(Map<String, Set<Integer>> phoneBook, String name) {
        if (phoneBook.containsKey(name)) {
            System.out.println("\nКонтакт: " + name);
            System.out.println("Телефонные номера: " + phoneBook.get(name));
        } else System.out.println("\nКонтакт не найден!!!\n");
    }
    public void printAllContacts(List<Map.Entry<String, Set<Integer>>> listContact) {
        String[] contact;
        for (Object item : listContact.toArray()) {
            contact = item.toString().split("=");
            System.out.println("\nКонтакт: " + contact[0]);
            System.out.println("Телефонные номера: " + contact[1]);
        }
    }
}
