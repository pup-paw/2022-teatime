package com.woowacourse.teatime.exception;

public class AlreadyReservedException extends BadRequestException {

    private static final String ERROR_MESSAGE = "이미 예약이 되어 있습니다.";

    public AlreadyReservedException() {
        super(ERROR_MESSAGE);
    }
}
