package main.java.week2.Practice_Problem;

public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);

        if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));   // Accepted
        System.out.println(validateFileExtension("notes.txt"));         // Rejected — invalid file type
        System.out.println(validateFileExtension("project.zip"));       // Accepted
        System.out.println(validateFileExtension("report.docx"));       // Accepted
        System.out.println(validateFileExtension("readme"));            // Rejected — invalid file type
    }
}
