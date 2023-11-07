package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateBoundery(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 입니다");
        }
    }

    private void validateBoundery(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 입니다");
            }

        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int[] check = new int[45];
        for (Integer i : numbers) {
            check[i - 1]++;
        }
        for (int i : check) {
            if (i > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
            }
        }
    }
}
