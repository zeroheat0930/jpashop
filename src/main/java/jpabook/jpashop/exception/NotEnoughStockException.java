package jpabook.jpashop.exception;

public class NotEnoughStockException extends RuntimeException{
//alt+인서트로 매서드 재정의 넣어줌
    public NotEnoughStockException() {
        super();
    }

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }

}
