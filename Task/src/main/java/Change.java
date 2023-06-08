import java.util.*;

public class Change {
    Scanner sc = new Scanner(System.in);
    public Map<String, Set<Integer>> changedContact(Map<String, Set<Integer>> phoneBookChange) {
        Program program = new Program();
        Data data = new Data();
        Set<Integer> setPhone;
        List<Integer> listPhone = new ArrayList<>();
        String currName, newName;
        int numPhone;
        int key;
        boolean flag = true;
        while (flag) {
            key = program.validationInput(1, "подменю");
            switch (key) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    System.out.print("Введите текущее имя: ");
                    currName = sc.next();
                    if (phoneBookChange.containsKey(currName)) {
                        System.out.print("Введите новое имя: ");
                        newName = sc.next();
                        setPhone = phoneBookChange.get(currName);
                        phoneBookChange.remove(currName);
                        phoneBookChange.put(newName, setPhone);
                        System.out.println("Контакт изменен");
                    } else System.out.println("\nКонтакт не найден!!!\n");
                    break;
                case 2:
                    System.out.print("Введите имя: ");
                    currName = sc.next();
                    if (phoneBookChange.containsKey(currName)) {
                        setPhone = phoneBookChange.get(currName);
                        numPhone = data.validationData("Введите номер телефона: ");
                        if (setPhone.contains(numPhone)) System.out.println("\nНомер телефона присутствует в списке!!!");
                        else {
                                setPhone.add(numPhone);
                                phoneBookChange.replace(currName, setPhone);
                                System.out.println("Телефонный номер добавлен");
                            }
                    } else System.out.println("\nКонтакт не найден!!!\n");
                    break;
                case 3:
                    System.out.print("Введите имя: ");
                    currName = sc.next();
                    if (phoneBookChange.containsKey(currName)) {
                        numPhone = data.validationData("Введите текущий номер телефона: ");
                        setPhone = phoneBookChange.get(currName);
                        if (setPhone.contains(numPhone)) {
                            listPhone.addAll(setPhone);
                            listPhone.remove((int) listPhone.indexOf(numPhone));
                            numPhone = data.validationData("Введите новый номер телефона: ");
                            listPhone.add(numPhone);
                            setPhone = new HashSet<>(listPhone);
                            phoneBookChange.replace(currName, setPhone);
                            System.out.println("Телефонный номер изменен");
                        } else System.out.println("\nТелефонный номер не найден!!!\n");
                    } else System.out.println("\nКонтакт не найден!!!\n");
                    break;
                case 4:
                    System.out.print("Введите имя: ");
                    currName = sc.next();
                    if (phoneBookChange.containsKey(currName)) {
                        numPhone = data.validationData("Введите номер телефона: ");
                        setPhone = phoneBookChange.get(currName);
                        if (setPhone.contains(numPhone)) {
                            listPhone.addAll(setPhone);
                            listPhone.remove((int) listPhone.indexOf(numPhone));
                            setPhone = new HashSet<>(listPhone);
                            phoneBookChange.replace(currName, setPhone);
                            System.out.println("Телефонный номер удален");
                        } else System.out.println("\nТелефонный номер не найден!!!\n");
                    } else System.out.println("\nКонтакт не найден!!!\n");
                    break;
                default:
                    System.out.println("\nПункта " + key + " нет!!! Выберите другой пункт!!!\n");
                    break;
            }
        }
        return phoneBookChange;
    }
}
