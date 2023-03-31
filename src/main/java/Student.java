
import java.util.Objects;

/**
 * Класс Student - основная сущность нашей БД.
 */
public class Student implements Cloneable{
    private int id;
    private String name;
    private String surname;
    private int faculty;
    private int yearOfBirth;
    private int yearOfIntroduction;

    /**
     * Конструктор, для создания объектра "Student".
     * @param id ID студента.
     * @param name Student name.
     * @param surname Фималия студента.
     * @param yearOfBirth Год рождения студента.
     * @param yearOfIntroduction Год поступления студента.
     * @param faculty Факультет студента.
     */
    public Student(int id, String name, String surname, int yearOfBirth, int yearOfIntroduction, int faculty) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.yearOfBirth = yearOfBirth;
        this.yearOfIntroduction = yearOfIntroduction;
    }

    /**
     * Конструктор копирования
     * @param student объект который будет скопирован.
     */
    public Student(Student student) {
        this.id = student.id;
        this.name = student.name;
        this.surname = student.surname;
        this.faculty = student.faculty;
        this.yearOfBirth = student.yearOfBirth;
        this.yearOfIntroduction = student.yearOfIntroduction;
    }

    /**
     * Метод для возвращения имени студента.
     * @return string - имя студента.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для возвращения фамилии студента.
     * @return string - фамилию студента.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Метод для возвращения факультета.
     * @return string - факультет.
     */
    public int getFaculty() {
        return faculty;
    }

    /**
     * Метод для возвращения года рождения студента.
     * @return int - год рождения.
     */
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * Метод для возращения года поступления в учебное заведение.
     * @return int - год поступления.
     */
    public int getYearOfIntroduction() {
        return yearOfIntroduction;
    }

    /**
     * Метод для возвращения ID студента.
     * @return int - ID
     */
    public int getId() {
        return id;
    }

    /**
     * Метод для сравнения 2х объектов.
     * @param o - с чем сравниваем наш объект.
     * @return boolean - true в случае совпадения, false в противном случае.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id && faculty == student.faculty && yearOfBirth ==
                student.yearOfBirth && yearOfIntroduction == student.yearOfIntroduction
                && name.equals(student.name) && surname.equals(student.surname);
    }

    /**
     * Метод для вычисления Хэш Кода объекта.
     * @return int - hash code нашего объкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, faculty, yearOfBirth, yearOfIntroduction);
    }

    /**
     * Мотод для клонирования объекта.
     * @return Object - клонированный объект.
     * @throws CloneNotSupportedException метод clone в классе Object был вызван для клонирования
     * объекта, но класс объекта не реализует интерфейс Cloneable .
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return  super.clone();
    }

    /**
     * Метод, который приводит наш объект к String.
     * @return String - строчное представление объекта.
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", faculty=" + faculty +
                ", yearOfBirth=" + yearOfBirth +
                ", yearOfIntroduction=" + yearOfIntroduction +
                '}';
    }
}
