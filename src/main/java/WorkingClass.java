
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Класс, содержащий основные методы для работы с нашей базой данных.
 */
public class WorkingClass {
    private static WorkingClass workingClass = null;
    private final static File file = new File("C:\\IntellijProjects\\Lab271Maven\\src\\main\\java\\data.txt");

    /**
     * Конструктор по умолчанию.
     */
    public WorkingClass() {
    }

    /**
     * Данный метод служит для создания объекта класса WorkingClass.
     * @return объект класса WorkingClass.
     */
    static WorkingClass getInstance() {
        return Objects.requireNonNullElseGet(workingClass, () -> (workingClass =
                new WorkingClass()));
    }

    /**
     * Метод, служащий для считывания информаций с нашей БД и ее запись в коллекцию.
     * @return Коллекция ArrayList, которая уже содержит считанную информацию с файла.
     */
    public ArrayList<Student> readFromCSVFile() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        String readingStr;
        int lineCount = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((readingStr = bufferedReader.readLine()) != null) {
                lineCount++;
                if (lineCount == 1)
                    continue;
                String[] splitedCSVString = readingStr.split(",");
                studentArrayList.add(
                        new Student(
                                Integer.parseInt(splitedCSVString[0]),
                                splitedCSVString[1],
                                splitedCSVString[2],
                                Integer.parseInt(splitedCSVString[3]),
                                Integer.parseInt(splitedCSVString[4]),
                                Integer.parseInt(splitedCSVString[5])
                        )
                );
            }
        } catch (IOException exception) {
            System.out.println("Exception!");
            exception.printStackTrace();
        }

        return studentArrayList;
    }

    /**
     * Данный метод служит для вывода считаной информаций на экран.
     * @param studArrayList коллекция Студентов, которую мы выводим на экран.
     */
    public void showStudentArrayList(@NotNull ArrayList<Student> studArrayList) {
        for (Student student : studArrayList) {
            for (Faculties faculty : Faculties.values()) {
                if (student.getFaculty() == faculty.ordinal() + 1)
                    if (faculty.ordinal() + 1 == student.getFaculty()) {
                        System.out.println(student.getId() + " "
                                + student.getName() + " "
                                + student.getSurname() + " "
                                + student.getYearOfBirth() + " "
                                + student.getYearOfIntroduction() + " "
                                + " " + faculty + "\t" + student.getFaculty());
                        break;
                    }
            }
        }
    }


}
