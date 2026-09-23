package week_02.cinema;

public class Seat implements Reservable{
    // 필드
    private int seatNumber;     // 좌석 번호
    private boolean reserved;   // 예약 여부
    // 생성자
    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    // getter setter
    public int getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public boolean reserve() {
        if (this.reserved) {
            return false;   // 실패
        } else {
            this.reserved = true;
            return true;    // 성공
        }
    }

    @Override
    public boolean cancel() {
        if (!this.reserved) {
            return false;   // 실패
        } else {
            this.reserved = false;
            return true;    // 성공
        }
    }

}
