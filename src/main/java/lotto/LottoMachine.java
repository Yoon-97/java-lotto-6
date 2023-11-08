package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    static int countLotto;

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

    public void lottoStart() { //함수명 run으로 변경
        List<Lotto> randomLottos = generateRandomLottos(buyLotto(getPrice()));
        Lotto lotto = new Lotto(inputLottoNumber());
        int bonusNumber = inputBonusNumber();
        validateBonusDuplicate(lotto, bonusNumber);
    }

    public List<Integer> inputLottoNumber() {
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

    public int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public static void buyLotto(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 구입하여야 합니다.");
        }
        countLotto = price / LOTTO_PRICE;
        System.out.println("\n" + countLotto + "개를 구매했습니다.");
    }

    private int getWinCount(Lotto random, Lotto lotto) {
        int count = 0;
        for (Integer i : lotto.getLottoNumbers()) {
            if (random.getLottoNumbers().contains(i)) {
                count++;
            }
        }

        return count;
    }

    private void getWinStatus(List<Lotto> randomLottos, Lotto lotto, int bonusNumber) {
        List<LottoResult> winStatus = new ArrayList<>();
        boolean isBonus = false;
        for (Lotto randomLotto : randomLottos) {
            if (randomLotto.getLottoNumbers().contains(bonusNumber)) {
                isBonus = true;
            }
            winStatus.add(LottoResult.valueOf(getWinCount(randomLotto, lotto), isBonus));
        }
    }

    private void calculateYield(List<LottoResult> winStatus, int lottoAmount) {
        double EarningRate = 0;
        for (LottoResult result : winStatus) {
            EarningRate =
                    EarningRate + ((double) (result.getReward()) / (lottoAmount * TICKET_PRICE) * (result.get(
                            rank)) * (PERCENTAGE));

        }
        OutputView.printRevenueRate(EarningRate);
    }
}
