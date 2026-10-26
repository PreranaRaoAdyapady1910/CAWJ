package LAB5.Q19_Calculator;

public class TestBasicCalculator {
    public static void main(String[] args) {

        Calculator calc = BasicCalculator.getInstance();

        assert calc.put(12).put(8).add().read() == 20;

        calc.clearAll();
        assert calc.put(25).put(9).sub().read() == 16;

        calc.clearAll();
        assert calc.put(6).put(7).mul().read() == 42;

        calc.clearAll();
        assert calc.put(40).put(5).div().read() == 8;

        calc.clearAll();
        assert calc.put(14).neg().read() == -14;

        calc.clearAll();
        calc.put(10).put(20);
        calc.clear();
        assert calc.read() == 10;

        calc.clearAll();
        assert calc.read() == 0;

        calc.put(3).put(4).add();
        assert calc.read() == 7;

        System.out.println("All calculator tests passed!");
    }
}