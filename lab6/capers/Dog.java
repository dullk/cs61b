package capers;

import java.io.File;
import java.io.Serializable;
import java.util.*;

import static capers.Utils.*;

/** Represents a dog that can be serialized.
 * @author Zhen Kang
*/
public class Dog implements Serializable { // TODO

    /** Folder that dogs live in. */
    static final File DOG_FOLDER = join(CapersRepository.CWD, ".capers/dogs");; // TODO (hint: look at the `join`
                                         //      function in Utils)

    /** Age of dog. */
    private int age;
    /** Breed of dog. */
    private String breed;
    /** Name of dog. */
    private String name;

    /**
     * Creates a dog object with the specified parameters.
     * @param name Name of dog
     * @param breed Breed of dog
     * @param age Age of dog
     */
    public Dog(String name, String breed, int age) {
        this.age = age;
        this.breed = breed;
        this.name = name;
    }

    /**
     * Reads in and deserializes a dog from a file with name NAME in DOG_FOLDER.
     *
     * @param name Name of dog to load
     * @return Dog read from file
     */
    public static Dog fromFile(String name) {
        // TODO (hint: look at the Utils file)
        String dogFileName = join(DOG_FOLDER, name).toString();
        File inFile = new File(dogFileName);
        if (inFile.exists()) {
            return readObject(inFile, Dog.class);
        }
        System.out.println(name + " doesn't exist.");
        return null;
    }

    /**
     * Increases a dog's age and celebrates!
     */
    public void haveBirthday() {
        age += 1;
        System.out.println(toString());
        System.out.println("Happy birthday! Woof! Woof!");
    }

    /**
     * Saves a dog to a file for future use.
     */
    public void saveDog() {
        File outFile = join(DOG_FOLDER, name);
        if (outFile.exists()) {
            System.out.println(name + " has already exist.");
        } else {
            writeObject(outFile,this);
            System.out.println(toString());
        }
        // TODO (hint: don't forget dog names are unique)
    }

    @Override
    public String toString() {
        return String.format(
            "Woof! My name is %s and I am a %s! I am %d years old! Woof!",
            name, breed, age);
    }

}
