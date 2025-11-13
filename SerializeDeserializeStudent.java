import java.io.*;

public class SerializeDeserializeStudent {
    public static void main(String[] args) {
        // Test with different Student objects
        Student[] students = {
            new Student("John Doe", 20, "A"),
            new Student("Jane Smith", 22, "B"),
            new Student("Bob Johnson", 19, "C")
        };

        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            String filename = "student" + (i + 1) + ".ser";

            // Serialize
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(student);
                System.out.println("Student " + (i + 1) + " serialized successfully.");
            } catch (IOException e) {
                System.err.println("Serialization failed for Student " + (i + 1) + ": " + e.getMessage());
            }

            // Deserialize
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                Student deserializedStudent = (Student) ois.readObject();
                System.out.println("Deserialized Student " + (i + 1) + ": " + deserializedStudent);
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Deserialization failed for Student " + (i + 1) + ": " + e.getMessage());
            }
        }

        // Test exception handling: try to deserialize a non-existent file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("nonexistent.ser"))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("Deserialized from nonexistent file: " + deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Expected exception for non-existent file: " + e.getMessage());
        }
    }
}
