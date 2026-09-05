public class ExceptionHierarchyExample {
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException.");
        } catch (Exception e) {
            System.out.println("Caught a general Exception.");
        }
    }
}
