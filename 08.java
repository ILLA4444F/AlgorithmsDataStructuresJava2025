import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args) {

        // 1. Створення нового списку масиву, додавання кольорів і виведення
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        System.out.println("1. Initial colors: " + colors);

        // 2. Ітерація по всіх елементах
        System.out.print("2. Iterating: ");
        for (String color : colors) {
            System.out.print(color + " ");
        }
        System.out.println();

        // 3. Вставка елемента на першу позицію
        colors.add(0, "Yellow");
        System.out.println("3. After inserting at first position: " + colors);

        // 4. Отримання елемента за індексом
        String secondElement = colors.get(1);
        System.out.println("4. Element at index 1: " + secondElement);

        // 5. Оновлення елемента за індексом
        colors.set(2, "Purple");
        System.out.println("5. After update: " + colors);

        // 6. Видалення третього елемента
        colors.remove(2);
        System.out.println("6. After removing third element: " + colors);

        // 7. Пошук елемента
        boolean containsBlue = colors.contains("Blue");
        System.out.println("7. Contains 'Blue'? " + containsBlue);

        // 8. Сортування списку
        Collections.sort(colors);
        System.out.println("8. Sorted list: " + colors);

        // 9. Копіювання списку (clone)
        ArrayList<String> clonedList = (ArrayList<String>) colors.clone();
        System.out.println("9. Cloned list: " + clonedList);

        // 10. Реверсування елементів
        Collections.reverse(colors);
        System.out.println("10. Reversed list: " + colors);

        // 11. Порівняння двох списків
        boolean areEqual = colors.equals(clonedList);
        System.out.println("11. Are original and cloned equal? " + areEqual);

        // 12. Очищення списку
        colors.clear();
        System.out.println("12. Cleared list: " + colors);

        // 13. Перевірка, чи порожній список
        System.out.println("13. Is empty? " + colors.isEmpty());

        // 14. Збільшення розміру списку (ensureCapacity)
        ArrayList<String> bigList = new ArrayList<>();
        bigList.ensureCapacity(50); 
        System.out.println("14. Increased capacity to 50 (logic only).");

        // 15. Обрізання місткості до фактичного розміру
        bigList.add("One");
        bigList.add("Two");
        bigList.trimToSize();
        System.out.println("15. Trimmed list capacity to size: " + bigList);
    }
}
