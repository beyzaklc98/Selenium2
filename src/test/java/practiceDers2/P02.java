package practiceDers2;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 {

    //Verify that we have pom.xml file in our project => please try in 4 min s
    // Framewor exemal'de pom.xml oldugunu test edin

    @Test
    public void name() {

        String verify = "C:\\com_Batch81JUnit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(verify)));
    }
}

