package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    int winCount;

    LottoMachine() {
    }

    public static void printRandomLotto(List<Lotto> randomLottos) {
    }

    private void validateNumber(String input) {
        for (char i : input.toCharArray()) {
            if (!Character.isDigit(i)) {
                throw new IllegalArgumentException("유효한 숫자를 입력해주세요");
            }
        }
    }

    private void validateBonusDuplicate(Lotto lotto, int bonus) {
        if (lotto.getLottoNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복하여 설정할 수 없습니다.");
        }
    }

    public int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public List<Lotto> generateRandomLottos(int lottoCount) {
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(RandomLotto.getRandomLottoNumbers());
            randomLottos.add(lotto);
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
        return randomLottos;
    }

    public void lottoStart() {
        List<Lotto> randomLottos = generateRandomLottos(buyLotto(getPrice()));
        Lotto lotto = new Lotto(inputLottoNumber());
        int bonusNumber = inputBonusNumber();
        validateBonusDuplicate(lotto, bonusNumber);
    }

    public List<Integer> inputLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        for (String number : Console.readLine().split(",")) {
            if (!Character.isDigit(number.charAt(0))) {
                throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요");
            }
            lottoNumber.add(Integer.parseInt(number));
        }
        return lottoNumber;
    }

    public int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public int buyLotto(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 구입하여야 합니다.");
        }
        int countLotto = price / 1000;
        System.out.println("\n" + countLotto + "개를 구매했습니다.");
        //구매한 로또 갯수 리턴
        return countLotto;
    }


}
