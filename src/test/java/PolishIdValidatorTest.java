import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


@RunWith(JUnitParamsRunner.class)
public class PolishIdValidatorTest {

   private PolishIdValidator id;
    @Before
    public void setup(){
        id = new PolishIdValidator();

    }

    @Test
    @Parameters({"LQA227831", "XHE872560"})
    public void CorrectIDValuesValidateTest(String given) {

        assertTrue(id.validate(given));
    }

    @Test
    @Parameters({"lqa227831", "xhe872560"})
    public void correctIDValuesLowerCaseValidateTest(String given) {

        assertTrue(id.validate(given));
    }
    @Test
    @Parameters({"LBA227831", "XHE872563", "ABC123456"})
    public void incorrectValidateTest(String given) {

        assertFalse(id.validate(given));
    }
    @Test
    @Parameters ({"XBE8725","XBAE872560", "XBE87259060"})
    public void incorrectAmountOfInputValidateTest(String given) {


        assertFalse(id.validate(given));
    }

    @Test
    public void emptyInputValidateTest() {
        String given = "";

        assertFalse(id.validate(given));
    }

    @Test
    @Parameters ({"872560XHE","227LQA831"})
    public void wrongOrderOfInputValidateTest(String given) {

        assertFalse(id.validate(given));

    }


}