import java.util.Scanner;

public class MVCPatternDemo {
    public static void main (String[] args) {
        ModelInterface model = new Model();
        ControllerInterface controller = new Controller(model);

        //System.out.println(name);
        /*
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);

         */

    }
}
