package Seminar3;

public class DataCheck {
    public DataCheck() {
    }

    public static int checkInput(String[] input) {
        if (input.length != 6) {
            return -1;
        }
        return 0;
    }

    public static boolean containsChars(String str) {
        CharSequence chars = "1234567890_-+=!?/.,";
        return str.contains(chars);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void checkData(String[] data) throws DataFormatException {
        if(containsChars(data[0])){
            throw new DataFormatException("Фамилия не должна содержать символы");
        }
        if(containsChars(data[1])){
            throw new DataFormatException("Имя не должно содержать символы");
        }
        if(containsChars(data[2])){
            throw new DataFormatException("Отчество не должно содержать символы");
        }
        if (data[3].length() < 10) {
            throw new DataFormatException("Дата рождения введена неверно");
        }
        if (!isNumeric(data[4])) {
            throw new DataFormatException("Телефон введен в неверном формате");
        }
        if (data[5].contains("fm")) {
            throw new DataFormatException("Пол введен неверно!");
        }
    }
}
