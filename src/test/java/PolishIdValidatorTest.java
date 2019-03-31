import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


@RunWith(JUnitParamsRunner.class)
public class PolishIdValidatorTest {

    @Test
    @Parameters({"LQA227831", "XHE872560"})
    public void correct_validate_test(String given) {

        PolishIdValidator id = new PolishIdValidator();

        assertTrue(id.validate(given));
    }
    @Test
    @Parameters({"LBA227831", "XHE872563", "ABC123456"})
    public void incorrectValidateTest(String given) {

        PolishIdValidator id = new PolishIdValidator();

        assertFalse(id.validate(given));
    }
    @Test
    @Parameters ({"XBE8725","XBAE872560", "XBE87259060"})
    public void incorrectAmountOfInputValidateTest(String given) {

        PolishIdValidator id = new PolishIdValidator();

        assertFalse(id.validate(given));
    }

    @Test
    public void emptyInputValidateTest(String given) {
        given = "";
        PolishIdValidator id = new PolishIdValidator();

        assertFalse(id.validate(given));
    }

    @Test
    @Parameters ({"872560XHE","227LQA831"})
    public void wrongOrderOfInputValidateTest(String given) {

        PolishIdValidator id = new PolishIdValidator();

        assertFalse(id.validate(given));

    }

}