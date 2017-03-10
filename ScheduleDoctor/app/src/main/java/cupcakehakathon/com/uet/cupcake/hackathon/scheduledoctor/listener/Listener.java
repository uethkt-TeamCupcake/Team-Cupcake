package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.listener;

/**
 * Created by Luong Tran on 3/10/2017.
 */

public class Listener {

    public interface listenerLogin {

        void showLogin();

        void startMain();
    }

    public interface loginStatus {
        void loginSuccess(int id, int idFaculty);

        void loginFail();
    }
}
