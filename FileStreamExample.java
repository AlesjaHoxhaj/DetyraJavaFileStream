import java.io.*;

public class FileStreamExample {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        if (!inputFile.exists()) {
            try {
                if (inputFile.createNewFile()) {
                    System.out.println("Skedari 'input.txt' nuk u gjet. U krijua automatikisht si bosh.");
                }
            } catch (IOException e) {
                System.out.println("Gabim gjatë krijimit të skedarit input.txt.");
                e.printStackTrace();
                return;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }

            System.out.println("Konvertimi përfundoi me sukses.");

        } catch (IOException e) {
            System.out.println("Ndodhi një gabim gjatë leximit ose shkrimit të skedarëve.");
            e.printStackTrace();
        }
    }
}