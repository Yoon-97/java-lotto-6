package lotto;

public class lottoMachine {

    public int getPrice() {

    }
    public int buyLotto(int price) {
        System.out.println("구입금액을 입력해 주세요.");
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 구입하여야 합니다.");
        }
        int countLotto = price / 1000;
        System.out.println(countLotto + "개를 구매했습니다.");
        //구매한 로또 갯수 리턴
        return countLotto;
    }
}
