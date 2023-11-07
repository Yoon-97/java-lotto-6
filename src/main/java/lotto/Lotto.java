package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 입니다");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int[] check = new int[45];
        for (Integer i : numbers) {
            check[i-1]++;
        }
        for (int i : check) {
            if (i > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
            }
        }
    }
    public List<Integer> getLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        for (String number : Console.readLine().split(",")) {
            if (!Character.isDigit(number.charAt(0))) {
                throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요");
            }
            lottoNumber.add(Integer.parseInt(number));
        }
        return lottoNumber;
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        for (char i : input.toCharArray()) {
            if (!Character.isDigit(i)) {
                throw new IllegalArgumentException("유효한 숫자를 입력해주세요");
            }
        }
        round = Integer.parseInt(input);
    }

    public int buyLotto(int price) {
        System.out.println("구입금액을 입력해 주세요.");
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 구입하여야 합니다.");
        }
        int countLotto = price / 1000
        System.out.println(countLotto + "개를 구매했습니다.");
        //구매한 로또 갯수 리턴
        return countLotto;
    }
}
