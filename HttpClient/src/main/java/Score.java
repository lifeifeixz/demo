import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author flysLi
 * @date 2018/5/28
 */
public class Score {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入班级总人数:");
//        double sum = scanner.nextInt();
//        double passCount = 0;
//        for (int i = 0; i < sum; i++) {
//            System.out.println("请输入第" + (i + 1) + "位学生的成绩:");
//            int score = scanner.nextInt();
//            if (score > 80) {
//                passCount = passCount + 1;
//            }
//        }
//        System.out.println("80分以上的学生人数是:" + (passCount));
//        System.out.println("80分以上的学生所占的比例为:" + ((passCount / sum) * 100) + "%");
//        Double a = 0.1;
//        Double b = 0.2;
//        BigDecimal a1 = new BigDecimal(Double.toString(a));
//        BigDecimal b1 = new BigDecimal(Double.toString(b));
//        System.out.println(a1.add(b1).doubleValue());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("老婆你爱我吗？");
            String input = scanner.next();
            if ("爱".equals(input)) {
                break;
            } else {
                System.out.println("为什么？");
            }
        }
    }
}
