package pory.ex7.pay1;

public class PayService {

    //결제 수단 선택
    public void processPay(String option, int amount) {

        boolean result = false;
        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);

        Pay pay = findPay(option);

        if (pay != null) {
            result = pay.pay(amount);
        }

        //결제 성공 유무
        if (result) {
            System.out.println("결제가 성공했습니다.");
        } else {
            System.out.println("결제가 실패했습니다.");
        }
    }
    public Pay findPay(String option) {

//        Pay pay;
//        if (option.equals("kakao")) {
//            pay = new KakaoPay();
//        } else if (option.equals("naver")) {
//            pay = new NaverPay();
//        } else {
//            pay = null;
//            System.out.println("결제 수단이 없습니다.");
//        }
//        return pay;
//    }
        if (option.equals("kakao")) {
            return new KakaoPay();
        } else if (option.equals("naver")) {
            return new NaverPay();
        } else {
            System.out.println("결제 수단이 없습니다.");
            return null;
        }
    }
}

