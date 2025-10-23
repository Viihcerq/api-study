import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class DemoTest {
    @DisplayName("test fail")
    @Test
    void testGivenNewProduto_whenCreate_thenFail() throws Exception{
        fail("Um erro acontecerá");
    }
}
