package practiceDers1;


import org.junit.*;

public class C02_JUnit {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
        //Her class'ta ilk çalışır. 1 kere çalışır.
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }

    @Before
    public void before(){
        System.out.println("Before");
        //Her testten önce çalışır
    }

    @After
    public void after(){
        System.out.println("After");
        //Her testten sonra çalışır.
    }

    @Test
    public void test01(){
        System.out.println("Test 01");
    }

    @Test
    public void test02(){
        System.out.println("Test 02");
    }

    @Test
    public void test03(){
        System.out.println("Test 03");
    }
}