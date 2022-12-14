package tests.task1;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1. Визначити ті рядки, довжина яких менша (більша) середньої. На вхід поступає
 * масив String. На виході – масив String.
 */
public class Task1 {
    @Test public void test(){
        tasks.task1.Task1 task = new tasks.task1.Task1();
        String[] processed = task.process(new String[]{"Привіт", "Звідки ти родом?", "Як тебе звати?"});
        Assert.assertArrayEquals(new String[]{"Звідки ти родом?", "Як тебе звати?"},processed);
    }
}
