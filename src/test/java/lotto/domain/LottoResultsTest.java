package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {
    @Test
    void 수익률_확인() {
        List<Integer> lottoNumbersFirst = Arrays.asList(
                1, 2, 3, 4, 5, 6
        );

        List<Integer> lottoNumbersSecond = Arrays.asList(
                1, 2, 3, 4, 5, 7
        );
        LottoTickets lottoTickets = new LottoTickets(
                Arrays.asList(new LottoTicket(lottoNumbersFirst), new LottoTicket(lottoNumbersSecond))
        );

        LottoTicket rewardTicket = new LottoTicket(
                Arrays.asList(1, 2, 3, 6, 7, 8)
        );

        LottoResults lottoResults = new LottoResults(lottoTickets, rewardTicket,new LottoMoney(2000));

        assertThat(lottoResults.getYield()).isEqualTo(500);
    }
}