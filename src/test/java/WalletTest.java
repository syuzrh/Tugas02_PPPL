import org.junit.jupiter.api.*;
import org.example.Wallet;

public class WalletTest {
    private Wallet wallet;

    @BeforeAll
    static void setupAll() {
        System.out.println("This is executed before all test cases.");
    }

    @BeforeEach
    void setup() {
        System.out.println("This is executed before each test case.");
        wallet = new Wallet("Test Owner");
    }

    @AfterEach
    void tearDown() {
        System.out.println("This is executed after each test case.");
        wallet = null;
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("This is executed after all test cases.");
    }

    @Test
    void testAddMoney() {
        wallet.addMoney(10000);
        Assertions.assertEquals(1, wallet.getMoneys().get(10000));
    }

    @Test
    void testAddCoin() {
        wallet.addCoin(500);
        Assertions.assertEquals(1, wallet.getCoins().get(500));
    }

    @Test
    void testAddCard() {
        wallet.addCard("Credit Card");
        Assertions.assertTrue(wallet.getCards().contains("Credit Card"));
    }

    @Test
    void testTakeCard() {
        wallet.addCard("Credit Card");
        wallet.takeCard("Credit Card");
        Assertions.assertFalse(wallet.getCards().contains("Credit Card"));
    }

    @Test
    void testTakeCoins() {
        wallet.addCoin(500);
        wallet.takeCoins(500);
        Assertions.assertEquals(0, wallet.getCoins().get(500));
    }

    @Test
    void testCalculateCoins() {
        wallet.addCoin(500);
        wallet.addCoin(500);
        Assertions.assertEquals(1000, wallet.calculateCoins());
    }

    @Test
    void testTakeMoneys() {
        wallet.addMoney(50000);
        wallet.takeMoneys(50000);
        Assertions.assertEquals(0, wallet.getMoneys().get(10000));
    }

    @Test
    void testCalculateMoneys() {
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        Assertions.assertEquals(15000, wallet.calculateMoneys());
    }

    @Test
    void testGetMoneyAvailable() {
        wallet.addMoney(20000);
        wallet.addCoin(200);
        Assertions.assertEquals(20200, wallet.getMoneyAvailable());
    }
}