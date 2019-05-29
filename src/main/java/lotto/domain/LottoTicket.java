package lotto.domain;

import java.util.*;

public class LottoTicket {
    public static final int PRICE = 1000;

    private static final int LOTTO_NUMBERS = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(final List<Integer> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>();
        lottoNumbers.forEach(lottoNumber -> {
            this.lottoNumbers.add(LottoNumber.valueOf(lottoNumber));
        });
        validateLotto();
    }

    private void validateLotto() {
        if (lottoNumbers.size() != LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 중복없는 6개 숫자만 가능합니다.");
        }
    }

    //TODO 갈끔하게 수정해보자
    public int getSameCount(final LottoTicket otherLottoTicket) {
        int sameCount = 0;
        for (LottoNumber lottoNumber : otherLottoTicket.lottoNumbers) {
            sameCount += checkNumber(lottoNumber);
        }
        return sameCount;
    }

    private int checkNumber(final LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}