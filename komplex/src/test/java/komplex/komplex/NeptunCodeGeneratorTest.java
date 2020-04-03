package komplex.komplex;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class NeptunCodeGeneratorTest {

    @Test
    public void getNextCounter() {
        NeptunCodeGenerator neptunCodeGenerator = mock(NeptunCodeGenerator.class);
        
        neptunCodeGenerator.getNextCounter();
        neptunCodeGenerator.getNextCounter();
        
        verify(neptunCodeGenerator, times(2)).getNextCounter();
    }
}
