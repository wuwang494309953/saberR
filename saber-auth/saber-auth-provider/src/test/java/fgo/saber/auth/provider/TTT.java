package fgo.saber.auth.provider;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zq
 * @Date 2018/9/18
 */
@Slf4j
public class TTT {

    @Test
    public void test1() {
        log.info(generateMatrix(5).toString());
    }


    public int[][] generateMatrix(int n) {
        int i = 1;
        int x = 0, y = 1;
        int[][] result = new int[n][n];
        result[0][1] = 1;
        while (i <= n * n) {
            while(y < n) {
                result[x][y] = i;
                y++;
                i++;
            }
            while(x < n) {
                result[x][y] = i;
                x++;
                i++;
            }

        }
        return result;
    }
}
