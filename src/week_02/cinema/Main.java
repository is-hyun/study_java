package week_02.cinema;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Seat[] seats = new Seat[10];
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat(i + 1);
        }

        while (true) {
            System.out.println("\n=== 영화관 좌석 관리 시스템 ===");
            System.out.println("1. 전체 좌석 | 2. 좌석 예약 | 3. 예약 취소    |");
            System.out.println("4. 좌석 수정 | 5. 좌석 삭제 | 6. 프로그램 종료 |");
            int choice = readInt("메뉴 선택 >> ");

            switch(choice) {
                case 1: // 전체 좌석
                    System.out.println("[현재 좌석 현황]");
                    for (int i = 0; i <seats.length; i++) {
                        if (seats[i] == null) {
                            System.out.println((i+1) + "번 좌석 조회 불가");
                            continue;
                        }
                        String status = seats[i].isReserved() ? "예약중" : "예약가능";
                        if (seats[i].getSeatNumber() < 10) {
                            System.out.println(seats[i].getSeatNumber() + "번 좌석  : [" + status + "]");
                        } else {
                            System.out.println(seats[i].getSeatNumber() + "번 좌석 : [" + status + "]");
                        }
                    }
                    break;
                case 2: // 좌석 예약
                    int reserveNum = readInt("예약할 좌석 번호 : ");
                    int reserveIndex = -1;

                    for (int i = 0; i < seats.length; i++) {
                        if (seats[i] != null && seats[i].getSeatNumber() == reserveNum) {
                            reserveIndex = i;
                            break;
                        }
                    }

                    if (reserveIndex != -1) {
                        if (seats[reserveIndex].reserve()) {
                            System.out.println("\n✅ " + reserveNum + "번 좌석 예약 완료");
                        } else {
                            System.out.println("\n🚫 이미 예약된 좌석입니다. (" + reserveNum + ")");
                        }
                    } else {
                        System.err.println("존재하지 않는 좌석입니다.\n");
                    }
                    break;
                case 3: // 예약 취소
                    int cancelNum = readInt("취소할 좌석 번호 : ");
                    int cancelIndex = -1;

                    for (int i = 0; i < seats.length; i++) {
                        if (seats[i] != null && seats[i].getSeatNumber() == cancelNum) {
                            cancelIndex = i;
                            break;
                        }
                    }

                    if (cancelIndex != -1) {
                    if (seats[cancelIndex].cancel()) {
                        System.out.println("\n✅ " + cancelNum + "번 좌석 예약 취소 완료");
                    } else {
                            System.out.println("\n🚫 이미 비어있는 좌석입니다. (" + cancelNum + ")" );
                        }
                    } else {
                        System.err.println("존재하지 않는 좌석입니다.\n");
                    }
                    break;
                case 4: // 좌석 정보 수정
                    int editNum = readInt("수정할 좌석 번호 : ");
                    int editIndex = -1;

                    for (int i = 0; i < seats.length; i++) {
                        if (seats[i] != null && seats[i].getSeatNumber() == editNum) {
                            editIndex = i;
                            break;
                        }
                    }
                    if (editIndex != -1) {
                        int newNum = readInt("새로운 좌석 번호 입력 : ");

                        boolean isDuplicate = false;
                        for (int i = 0; i < seats.length; i++) {
                            if (seats[i] != null && seats[i].getSeatNumber() == newNum) {
                                System.out.println("\n🚫 이미 존재하는 좌석 번호입니다.");
                                isDuplicate = true;
                                break;
                            }
                        }
                        if (!isDuplicate) {
                            seats[editIndex].setSeatNumber(newNum);
                            System.out.printf("\n✅ 좌석 번호 수정 완료 (%d → %d)\n", editNum, newNum);
                        }
                    } else {
                        System.err.println("존재하지 않는 좌석입니다.\n");
                    }
                    break;
                case 5: // 좌석 삭제
                    int deleteNum = readInt("삭제할 좌석 번호 : ");
                    int deleteIdx = deleteNum - 1;
                    for (int i = 0; i < seats.length; i++) {
                        if (seats[i] != null && seats[i].getSeatNumber() == deleteNum) {
                            deleteIdx = i; // 찾은 방 번호를 대입합니다.
                            break;
                        }
                    }

                    if (deleteIdx == -1 && deleteNum - 1 >= 0 && deleteNum - 1 < seats.length) {
                        deleteIdx = deleteNum - 1;
                    }

                    if (deleteIdx >= 0 && deleteIdx < seats.length) {
                        if (seats[deleteIdx] == null) {
                            System.out.println("\n🚫 이미 삭제된 좌석입니다.");
                        } else {
                            seats[deleteIdx] = null;
                            System.out.println("\n✅ " + deleteNum + "번 좌석 삭제 완료");
                        }
                    } else {
                        System.err.println("존재하지 않는 좌석입니다.\n");
                    }
                    break;
                case 6: // 종료
                    System.out.println("\n=== 프로그램 종료 ===");
                    sc.close();
                    return;
                default:
                    System.err.println("잘못된 입력입니다. 다시 입력해 주세요\n");
            }
        }
    }

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }
}
