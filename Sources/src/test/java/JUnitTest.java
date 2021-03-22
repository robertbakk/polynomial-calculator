import static org.junit.Assert.*;

import org.junit.*;

public class JUnitTest {

    private static PolinomModel m;
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;

    public JUnitTest() { }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        m = new PolinomModel();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println(nrTesteExecutate + " teste executate - " + nrTesteCuSucces + " teste au avut succes");
    }

    @Before
    public void setUp() throws Exception {
        nrTesteExecutate++;
    }

    @After
    public void tearDown() throws Exception { }

    @Test
    public void testResetGetValue() {
        m.reset();
        Polinom p1 = m.getRez1();
        Polinom p2 = m.getRez2();
        assertNull(p1); // verifica p1 sa fie null
        assertNull(p2); // verifica p2 sa fie null
        nrTesteCuSucces++;
    }

    @Test
    public void testAdunare() {
        m.reset();
        Polinom A = new Polinom("x-x^2+1");
        Polinom B = new Polinom("x^3-1+x");
        m.adunare(A, B);
        String t = m.getRez1().toString();
        assertNotNull(t); // verifica t sa nu fie null
        assertEquals(t, "x^3-x^2+2x");
        nrTesteCuSucces++;
    }

    @Test
    public void testDiferenta() {
        m.reset();
        Polinom A = new Polinom("x-x^2+1");
        Polinom B = new Polinom("x-1");
        m.diferenta(A, B);
        String t = m.getRez1().toString();
        assertNotNull(t); // verifica t sa nu fie null
        assertEquals(t, "-x^2+2"); // verifica t sa nu fie null
        nrTesteCuSucces++;
    }

    @Test
    public void testInmultire() {
        m.reset();
        Polinom A = new Polinom("x-x^2+1");
        Polinom B = new Polinom("x-1");
        m.inmultire(A, B);
        String t = m.getRez1().toString();
        assertNotNull(t); // verifica t sa nu fie null
        assertEquals(t, "-x^3+2x^2-1");
        nrTesteCuSucces++;
    }

    @Test
    public void testImpartire() {
        m.reset();
        Polinom A = new Polinom("2x^2+4x-3");
        Polinom B = new Polinom("2x-1");
        m.impartire(A, B);
        String t1 = m.getRez1().toString();
        String t2 = m.getRez2().toString();
        assertNotNull(t1);  // verifica t sa nu fie null
        assertNotNull(t2);  // verifica t sa nu fie null
        assertEquals(t1, "x+2.5");
        assertEquals(t2, "-0.5");
        nrTesteCuSucces++;
    }

    @Test
    public void testDerivare() {
        m.reset();
        Polinom A = new Polinom("x-x^2+1");
        Polinom B = new Polinom("x-1");
        m.derivare(A);
        String t1 = m.getRez1().toString();
        m.derivare(B);
        String t2 = m.getRez1().toString();
        assertNotNull(t1); // verifica t1 sa nu fie null
        assertEquals(t1, "-2x+1");
        assertNotNull(t2); // verifica t2 sa nu fie null
        assertEquals(t2, "1");
        nrTesteCuSucces++;
    }

    @Test
    public void testIntegrare() {
        m.reset();
        Polinom A = new Polinom("x-3x^2+1");
        Polinom B = new Polinom("x-1");
        m.integrare(A);
        String t1 = m.getRez1().toString();
        m.integrare(B);
        String t2 = m.getRez1().toString();
        assertNotNull(t1); // verifica t1 sa nu fie null
        assertEquals(t1, "-x^3+0.5x^2+x");
        assertNotNull(t2); // verifica t2 sa nu fie null
        assertEquals(t2, "0.5x^2-x");
        nrTesteCuSucces++;
    }

}