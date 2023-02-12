package enums;

public enum CarTypes {
    SEDAN("Седан"),
    HATCHBACK("Хетчбэк"),
    COUPE("Купе"),
    UNIVERSAL("Универсал"),
    SUV("Внедорожник"),
    CROSSOVER("Кроссовер"),
    PICKUP("Пикап"),
    VAN("Фургон"),
    MINIVAN("Минивэн");

    private final String russianName;

    CarTypes(String russianName) {
        this.russianName = russianName;
    }

    @Override
    public String toString() {
        return "Тип кузова: '" + russianName + '\'';
    }
}
