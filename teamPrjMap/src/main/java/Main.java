import controller.MemberController;

public class Main {

    private static MemberController memberController = MemberController.getInstance();

    public static void main(String[] args) {
        memberController.loginView();
    }

}
