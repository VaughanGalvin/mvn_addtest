// Объект, созданный из описания того как он работает
// сначала всегда создание объекта
// потом описание, как объект обращается к методу хранящемуся в описании (с указанием нужных данных)

public class MainBonusService {
    public static void main(String[] args) {
        BonusService service = new BonusService();

        // подготавливаем данные
        long amount = 10000;
        boolean registered = true;
        long expected = 30;

        // обращаемся к методу, который будет прогонять "форумлу" с нашими значениями, а в скобках ссылаемся на подготовленные данные
        long actual = service.calculate(amount, registered);

        // получаем результат
        System.out.println(actual);
    }

}
