package enums;

public enum Bradbury {
    AUTHOR("Брэдбери"),
    DANDELION_WINE("Вино из одуванчиков"),
    THE_MARTIAN_CHRONICLES("Марсианские хроники");

    private final String description;

    // Конструктор
    Bradbury(String description) {
        this.description = description;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return description;
    }
}
