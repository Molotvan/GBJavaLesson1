

public class Main {
    public static void main(String[] args) {
        String equ = "5?4? + 3?9?7 = 43580";
        System.out.println(trueEquality(splitEquation(equ)));
    }

    public static String[] splitEquation(String equ) {//разбиваем уравнение на массив строк, убираем операнды
        String[] temp = equ.split(" ");
        String[] fin = {temp[0], temp[2], temp[4]};
        return fin;
    }

    public static String trueEquality(String[] arr) {
        String first = arr[0];
        String second = arr[1];
        if (first.length() > second.length()) {//в случае, если у слагаемых разная разрядность, добавляем нули к меньшему
            StringBuilder builder = new StringBuilder();
            builder.append(second);
            while (builder.length() != first.length()) {
                builder.insert(0, '0');
            }
            second = builder.toString();
        } else if (first.length() < second.length()) {
            StringBuilder builder = new StringBuilder();
            builder.append(first);
            while (builder.length() != second.length()) {
                builder.insert(0, '0');
            }
            first = builder.toString();
        }
        String trueEquality = null;
        for (int i = 0; i < second.length(); i++) {// При пропущенных цифрах на одном и том же разряде имеем несколько решений
            if (first.charAt(i) == '?' && second.charAt(i) == '?') {
                trueEquality = "Есть несколько решений";
            }
        }
        if (trueEquality != "Есть несколько решений") {
            int sum = Integer.parseInt(arr[2]);

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < second.length(); i++) {//составляем вспомогательное слагаемое из значащих символов
                if (first.charAt(i) != '?' && first.charAt(i) != '0') {
                    builder.append(first.charAt(i));
                } else if (first.charAt(i) == '0' && second.charAt(i) == '?') {
                    builder.append(first.charAt(i));
                } else {
                    builder.append(second.charAt(i));
                }
            }

            String diff = builder.toString();

            String diff2 = Integer.toString(sum - Integer.parseInt(diff));//получаем второе вспомогательное слагаемое
            if (diff2.length() > Math.min(arr[0].length(), arr[1].length())) {
                trueEquality = "Нет решений";
            } else {
                StringBuilder builder2 = new StringBuilder();
                builder2.append(diff2);
                while (builder2.length() != first.length()) {
                    builder2.insert(0, '0');
                }
                diff2 = builder2.toString();
                StringBuilder builderFirst = new StringBuilder();
                StringBuilder builderSecond = new StringBuilder();
                for (int i = 0; i < second.length(); i++) {//из второго вспомогательного слагаемого расставляем цифры по пропущенным разрядам исходных слагаемых
                    if (first.charAt(i) != '?') {
                        builderFirst.append(first.charAt(i));
                    } else {
                        builderFirst.append(diff2.charAt(i));
                    }
                    if (second.charAt(i) != '?') {
                        builderSecond.append(second.charAt(i));
                    } else {
                        builderSecond.append(diff2.charAt(i));
                    }

                }
                first = builderFirst.toString();
                second = builderSecond.toString();
                trueEquality = first + '+' + second + '=' + arr[2];
            }
        }
        return trueEquality;
    }
}

