package tasks.task1;

/**
 * 1. Визначити ті рядки, довжина яких менша (більша) середньої. На вхід поступає
 * масив String. На виході – масив String.
 */
public class Task1 {
    public String[] process(String[] strings) {
        int sum = 0;
        for (String str: strings) {
            sum = sum + str.length();
        }
        int avg = sum / strings.length;
        String[] res = new String[0];
        for (String str: strings) {
            if (str.length()>avg) {
                String[] res2 = new String[res.length+1];
                for (int i = 0; i < res.length; i++) {
                    res2[i] = res[i];
                }
                res2[res.length] = str;
                res = res2;
            }
        }
        return res;
    }
}
