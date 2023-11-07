package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLotto {
    public RandomLotto(){}
//순서 리팯토링
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int COUNT_NUMBER = 6;
    private static List<Integer> RandomLottoNumbers;

    public static List<Integer> getRandomLottoNumbers() {
        RandomLottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_NUMBER);
        List<Integer> lottoTicketNumberList = new ArrayList<>(RandomLottoNumbers);
        Collections.sort(lottoTicketNumberList);
        return lottoTicketNumberList;
    }

}