package week77assignment;

class TrafficLight {
    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // start on red
    }

    public void next() {
        switch (color) {
            case "RED": color = "GREEN"; break;
            case "GREEN": color = "YELLOW"; break;
            case "YELLOW": color = "RED"; break;
        }
        System.out.println("Next color: " + color);
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        t.next();
        t.next();
        t.next();
    }
}
