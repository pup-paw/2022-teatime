package com.woowacourse.teatime.exception;

public class NotFoundScheduleException extends NotFoundException {

    private static final String ERROR_MESSAGE = "존재하지 않는 스케줄입니다.";

    public NotFoundScheduleException() {
        super(ERROR_MESSAGE);
    }
}
