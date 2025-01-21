public class CourierTestData {

    //Полные данные курьера
    public static Courier expectedCourier() {
        return new Courier("asddsa123", "123321", "Иван");
    }

    //Данные курьера без пароля
    public static Courier courierWithoutPassword() {
        return new Courier("asddsa123", "", "Иван");
    }

    //Данные курьера с неверным паролем
    public static Courier courierIncorrectPassword() {
        return new Courier("asddsa123", "123321789");
    }
}
