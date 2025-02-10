package lab.main_classes;

public class Coordinates {
    private double x;
    private double y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static CoordinatesBuilder builder() {
        return new CoordinatesBuilder();
    }

    public static class CoordinatesBuilder {
        private double x;
        private double y;

        public CoordinatesBuilder x(double x) {
            this.x = x;
            return this;
        }

        public CoordinatesBuilder y(double y) {
            this.y = y;
            return this;
        }

        public Coordinates build() {
            return new Coordinates(x, y);
        }
    }
}