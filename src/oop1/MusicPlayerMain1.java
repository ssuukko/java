package oop1;

public class MusicPlayerMain1 {
    public static void main(String[] args) {
        int volume = 0;
        boolean isON = false;

        //음악 플레이어 켜기
        isON = true ;
        System.out.println("음악 플레이어를 실행합니다.");

        //볼륨 증가
        volume ++;
        System.out.println("음악 플레이어 볼륨:" + volume);

        //볼륨 증가
        volume ++;
        System.out.println("음악 플레이어 볼륨:" + volume);

        //볼륨 감소
        volume --;
        System.out.println("음악 플레이어 볼륨:" + volume);

        //음악 플레이어 상태
        if(isON){
            System.out.println("음악 플레이어 ON"+ volume);
        }else
            System.out.println("음악 플레이어 OFF");

        isON= false;
        System.out.println("음악 플레이어를 종료합니다.");


    }
}
