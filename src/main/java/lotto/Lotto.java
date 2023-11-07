package lotto;

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
            check[i]++;
        }
        for (int i : check) {
            if (i > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
            }
        }
    }


        public List getLottoNumber() {
        String lottoNumber = Console.readLine();

        return ;
    }

    // TODO: 추가 기능 구현
}
