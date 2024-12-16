package enums;

public enum Lovecraft {
    AUTHOR("Лавкрафт"),
    DREAMS_OF_CTHULHU("Сны Ктулху"),
    CALL_OF_CTHULHU("Зов Ктулху"),
    RIDGES_OF_MADNESS("Хребты безумия"),
    LURKING_AT_THE_THRESHOLD("Таящийся у порога");

    private final String description;

    // Конструктор
    Lovecraft(String description) {
        this.description = description;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return description;
    }
}
