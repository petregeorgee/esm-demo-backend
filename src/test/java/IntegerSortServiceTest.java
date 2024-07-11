import com.example.demo.service.IntegerSortService;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerSortServiceTest {

    private final IntegerSortService sortService = new IntegerSortService();

    @Test
    public void testQuickSort() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5));

        sortService.quickSort(numbers, 0, numbers.size() - 1);

        List<Integer> expected = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9);
        assertEquals(expected, numbers);
    }

    @Test
    public void testQuickSort_EmptyList() {
        // Arrange
        List<Integer> numbers = new ArrayList<>();

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sortService.quickSort(numbers, 0, numbers.size() - 1);
        });
        assertEquals("Input list cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testQuickSort_NullList() {
        List<Integer> numbers = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sortService.quickSort(numbers, 0, 0);
        });
        assertEquals("Input list cannot be null or empty", exception.getMessage());
    }
}
