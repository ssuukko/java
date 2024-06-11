package class_st;

public class ProductOrderMain {

    public static void main(String[] args) {

        ProductOrder[] orders  =  new ProductOrder[3];

        ProductOrder product1 = new ProductOrder();
        product1.productName = "두부";
        product1.price = 2000;
        product1.quenty = 2;
        orders[0] = product1;

        ProductOrder product2 = new ProductOrder();
        product2.productName = "김치";
        product2.price = 5000;
        product2.quenty = 1;
        orders[1] = product2;


        ProductOrder product3 = new ProductOrder();
        product3.productName = "콜라";
        product3.price = 1500;
        product3.quenty = 2;
        orders[2] = product3;

//        int total = product1.price * product1.quenty + product2.price *  product2.quenty+ product3.price * product3.quenty;
//        ProductOrder[] productOrders = {product1, product2, product3};

        int totalAmount = 0;
        for (ProductOrder order : orders) {
            System.out.println("상품명 :" + order.productName + ", 가격 :" +order.price + ", 수량 :" + order.quenty );
            totalAmount += order.price * order.quenty;
        }
        System.out.println("총 결제 금액: " + totalAmount);

//        for (ProductOrder productOrder : productOrders) {
//            System.out.println("상품명 :" + productOrder.productName + ", 가격 :" +productOrder.price + ", 수량 :" + productOrder.quenty );
//        }

//        System.out.println("총 결제 금액: " + total);
    }
}
