package week77practice;

class Locker {
    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Change rejected: incorrect current code.");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
