package enums;

public enum BusTypes {
    EXTRA_SMALL(0,10),
    SMALL(0,25),
    MEDIUM(40,50),
    LARGE(60,80),
    EXTRA_LARGE(100,1200);

    private final int minCapacity, maxCapacity;

    BusTypes(int minCapacity, int maxCapacity) {
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Вместимость: " +
                (minCapacity != 0 ? ("нижняя граница '" + minCapacity + '\'' ): "")+
                (minCapacity != 0 && maxCapacity != 0 ? ", " : "")+
                (maxCapacity != 0 ? ("верхняя граница '" + maxCapacity + '\'' ): "")+
                "";
    }
}
