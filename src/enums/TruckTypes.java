package enums;

public enum TruckTypes {
    N1(0, 3.5f),
    N2(3.5f, 12),
    N3(12, 0);

    private final float minLoadCapacity, maxLoadCapacity;

    TruckTypes(float minLoadCapacity, float maxLoadCapacity) {
        this.minLoadCapacity = minLoadCapacity;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Грузоподъемность: " +
                (minLoadCapacity != 0 ? ("от '" + minLoadCapacity + '\'' ): "")+
                (minLoadCapacity != 0 && maxLoadCapacity != 0 ? ", " : "")+
                (maxLoadCapacity != 0 ? ("до " + maxLoadCapacity + '\'' ): "")+
                "";
    }
}
