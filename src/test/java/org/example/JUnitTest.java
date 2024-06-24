package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.assertj.core.api.Assertions.*;

public class JUnitTest {

    @Test
    public void testAdd() {
        App calculator = new App();

        assumeTrue(System.getProperty("os.arch").equals("amd64"));

        int result = calculator.add(3, 5);
        assertThat(result).isEqualTo(8);
    }
}
