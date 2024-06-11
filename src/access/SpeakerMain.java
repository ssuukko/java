package access;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(90);
        speaker.showVolume();;

        speaker.volumeUp();
        speaker.showVolume();

        speaker.volumeUp();
        speaker.showVolume();

//        //필드에 직접 접근
//        System.out.println("volume 필드 직접 접근 수정");
//        speaker.volume = 200;
//        speaker.showVolume();

//        만약 만든 개발자가 아니라 다른 개발자가 수정할때  speaker.volume = 200; 처럼 직접적으로
//        접근해서 volume을 높힌다면 speaker는 망가짐
//        그래서 Speaker에 volume을 private
    }
}
