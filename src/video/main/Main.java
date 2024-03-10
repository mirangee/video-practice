package video.main;

import static video.ui.AppUi.*;

public class Main {
    public static void main(String[] args) {

        AppController controller = new AppController();

        while (true) {
            showMain();
            int num = inputNumber("\n어떤 메뉴로 이동할까요? ");
            controller.selectMenu(num);
        }
    }
}
