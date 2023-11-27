package cs3318.A03;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 * The ColourTableTest class contains a set of JUnit tests for the ColourTable class.
 * Each test method corresponds to a specific functionality of the ColourTable class,
 * validating its behavior under various scenarios. These tests ensure that the ColourTable
 * class adheres to the specified requirements and behaves as expected in different scenarios.
 */
class ColourTableTest {

    /**
     * The constructorValidPaletteSize function tests the constructor of the ColourTable class.
     * It checks that a valid palette size is accepted and that it initializes other properties correctly.
     */
    @Test
    void constructorValidPaletteSize() {
        // Arrange
        int validPaletteSize = 8; // Choose a valid palette size

        // Act
        ColourTable colourTable = new ColourTable(validPaletteSize);

        // Assert
        assertNotNull(colourTable, "ColourTable object should not be null");
        // Add more assertions based on the expected behavior of your constructor
        assertEquals(validPaletteSize, colourTable.getPaletteSize(), "Palette size should match");
        // Add more assertions if your constructor initializes other properties
    }

    /**
     * The constructorInvalidPaletteSize function tests the ColourTable constructor with an invalid palette size.
     * The test should fail if the constructor does not throw an IllegalArgumentException when given a palette size of 1.
     */
    @Test
    void constructorInvalidPaletteSize() {
        // Arrange
        int invalidPaletteSize = 1; // Choose an invalid palette size

        // Act & Assert
        // Use assertThrows to check that the specified type of exception (IllegalArgumentException) is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            // This lambda expression contains the code that is expected to throw the exception
            // Attempt to create a ColourTable with an invalid palette size
            new ColourTable(invalidPaletteSize);
        });
    }

    /**
     * The addValidColor function tests the add function of the ColourTable class.
     * It creates a ColourTable with a valid palette size, and adds a valid RGB color to it.
     * The test passes if the colour is added successfully.
     */
    @Test
    void addValidColor() {
        // Arrange
        ColourTable colourTable = new ColourTable(8); // Create a ColourTable with a valid palette size
        int validRGBColor = 0xFF00FF; // Choose a valid RGB color (example: purple)

        // Act
        // Write the code to add the valid RGB color to the table
        colourTable.add(validRGBColor);

        // Assert
        // Add assertions to ensure that the color is added successfully
        assertTrue(colourTable.contains(validRGBColor), "Valid RGB color should be added");
        // You might add more assertions based on your specific requirements
    }

    /**
     * The addInvalidColor function tests the add function of the ColourTable class.
     * It checks that an IllegalArgumentException is thrown when attempting to add a color outside of the valid range.
     */
    @Test
    void addInvalidColor() {
        // Arrange
        ColourTable colourTable = new ColourTable(4); // Set a valid palette size for testing
        int invalidColor = 0xFFFFFF0; // An invalid RGB color (outside the valid range)

        // Act & Assert
        // Use assertThrows to check that the specified type of exception (IllegalArgumentException) is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            // This lambda expression contains the code that is expected to throw the exception
            // Attempt to add an invalid RGB color
            colourTable.add(invalidColor);
        });
    }

    /**
     * The addColorAtFullCapacity function tests the add function of the ColourTable class.
     * It creates a new ColourTable object with a small palette size for testing purposes, and adds two colors to it.
     * Then, it attempts to add a third color when the table is at full capacity and expects an IllegalStateException to be thrown.
     */
    @Test
    void addColorAtFullCapacity() {
        // Arrange
        ColourTable colourTable = new ColourTable(2); // Set a small palette size for testing
        int firstColor = 0xFF0000; // First color
        int secondColor = 0x00FF00; // Second color

        // Act
        colourTable.add(firstColor);
        colourTable.add(secondColor);

        // Assert
        assertThrows(IllegalStateException.class, () -> {
            // Attempt to add a third color when the table is at full capacity
            colourTable.add(0x0000FF);
        }, "Expected IllegalStateException to be thrown, but nothing was thrown.");
    }

    /**
     * The addSameColorMoreThanOnce function tests the add function to ensure that it throws an IllegalArgumentException
     * when attempting to add the same color more than once.
     */
    @Test
    void addSameColorMoreThanOnce() {
        // Arrange
        ColourTable colourTable = new ColourTable(4); // Set a valid palette size for testing
        int redColor = 0xFF0000; // Red color

        // Act & Assert
        // Use assertThrows to check that the specified type of exception (IllegalArgumentException) is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            // This lambda expression contains the code that is expected to throw the exception
            // Attempt to add the same color more than once
            colourTable.add(redColor);
            colourTable.add(redColor);
        });
    }
}
