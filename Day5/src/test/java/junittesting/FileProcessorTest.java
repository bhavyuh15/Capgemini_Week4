package junittesting;

import com.junit.basicjunittest.FileProcessor;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    private static final String TEST_FILE = "testfile.txt";

    @BeforeEach
    void setUp() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE)); // Ensure a clean state
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, JUnit!";
        FileProcessor.writeToFile(TEST_FILE, content);
        String readContent = FileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent, "File content should match the written content.");
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        FileProcessor.writeToFile(TEST_FILE, "Sample Content");
        assertTrue(Files.exists(Path.of(TEST_FILE)), "File should exist after writing.");
    }

    @Test
    void testReadNonExistentFileThrowsIOException() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"),
                "Reading a non-existent file should throw IOException.");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE)); // Cleanup after test
    }
}

