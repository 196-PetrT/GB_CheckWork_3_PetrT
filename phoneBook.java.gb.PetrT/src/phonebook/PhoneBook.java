
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена
// с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.

package phonebook;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private static final HashMap<String, List<String>> phonebook = new HashMap<>();

    public static void addContact(String name, String phoneNum) {

        ArrayList<String> phone = new ArrayList<>();

        boolean hasName = phonebook.containsKey(name);
        if (hasName) {
            phonebook.get(name).add(phoneNum);
        } else {
            phone.add(phoneNum);
            phonebook.put(name, phone);
        }
    }

    public static void GetPhoneBook(HashMap<String, List<String>> phonebook){
        List<Map.Entry<String, List<String>>> notes = new ArrayList<>(phonebook.entrySet());

//       for (int i = notes.size() - 1; i > 1; i--) {
//           for (int j = 0; j < notes.size(); j++) {
//               if (notes.get(j).getValue().size() < notes.get(j+1).getValue().size()){
//                   Map.Entry<String, List<String>> buf =  notes.get(j+1);
//                   notes.set(j+1, notes.get(j));
//                   notes.set(j, buf);
//               }
//           }
//       }

        notes.sort((note1, note2) -> Integer.compare(note2.getValue().size(), note1.getValue().size()));

        for (Map.Entry<String, List<String>> note : notes) {
            String name = note.getKey();
            List<String> phoneNumbers = note.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }

    public static void main(String[] args) {
        String name = "Petr";
        String phoneNum = "89998887744";

        addContact(name, phoneNum);
        addContact("Petr", "89998887755");
        addContact("Petr", "89998887766");
        addContact("Nick", "89998887733");


        GetPhoneBook(phonebook);
    }


}

