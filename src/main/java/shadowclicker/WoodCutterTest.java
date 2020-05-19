package shadowclicker;

public class WoodCutterTest extends Script {
    public void onLoop() throws InterruptedException {

        if(getMethods().isInvFull()){
            getMethods().mouseClick(1787, 207);
            sleep(8000);

            int[] coords = getMethods().pixelSearch(1269, 258, 1440, 371, 97,73,46,5);
            if(coords[0] > 0 && coords[1] > 0) {
                getMethods().mouseClick(coords[0], coords[1]);
                System.out.println(coords[0]+" " +coords[1]);
                sleep(4000);
            }

        }else {
            int[] bank = getMethods().pixelSearch(1359, 284, 1371, 306, 97,73,46,5);
            if(bank[0] > 0 && bank[1] > 0) {
                getMethods().mouseClick(1718, 121);
                sleep(8000);
            }

            int[] tree = getMethods().pixelSearch(1221, 173, 1354, 304, 91,107,40,5);
            if(tree[0] > 0 && tree[1] > 0) {
                getMethods().mouseClick(tree[0], tree[1]);
                sleep(10000);
            }

        }

        sleep(1000);
    }
}
