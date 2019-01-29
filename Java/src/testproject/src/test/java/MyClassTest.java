import com.wajahat.MyClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Class Test for MyClass
 * Created by wajahat
 */
@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {
    @Spy
    MyClass myClass;

    @Test
    public void testProcess() {
        myClass.process();
        Mockito.verify(myClass, Mockito.times(1)).method();
    }
}
