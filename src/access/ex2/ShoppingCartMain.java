package access.ex2;

public class ShoppingCartMain {
    public static void main(String[] args) {

        //장바구니에는 상품을 촤대 10개만 담을수 있다
        //10개 초과시 "장바구니가 가득찼습니다" 출력

        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("마늘", 2000, 2);
        Item item2 = new Item("상추", 3000, 4);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.displayItems();
    }
}
