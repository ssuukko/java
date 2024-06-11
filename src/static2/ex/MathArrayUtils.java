package static2.ex;

public class MathArrayUtils {

    private MathArrayUtils() {
        //private 인스턴스 생성을 막는다.
    }

    public static int sum(int[] values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
//        int total = values[0] + values[1] + values[2] + values[3] + values[4];
        return total;
    }

    public static double average(int[] values) {
        return (double) sum(values) / values.length;
//        int valueAverage = values[0] + values[1] + values[2] + values[3] + values[4] / values.length ;
//        return valueAverage;
    }

    public static int min(int[] values) {
        int minValue = values[0];
        for (int value : values) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }
    //        if (values[0] > values[1]) {
//            return values[1];
//        }else if (values[0] < values[1]) {
//            return values[0];
//        }else if (values[1] > values[2]) {
//            return values[2];
//        }else if (values[2] > values[3]) {
//            return values[3];
//        }else
//            return values[4];
//    }

    public static int max(int[] values) {
        int maxValue = values[0];
        for (int value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
//       if (values[0] > values[1]) {
//           return values[0];
//       } else if (values[1] > values[2]) {
//           return values[1];
//       }else if (values[2] > values[3]) {
//           return values[2];
//       }else if (values[3] > values[4]) {
//           return values[3];
//       }else
//           return values[4];
//    }
}
