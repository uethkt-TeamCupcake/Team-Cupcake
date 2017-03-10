package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener;

/**
 * Created by NgocThai on 10/03/2017.
 */

public class Listener {

    public interface listenIllness {
        void onClick(int id);
    }

    public interface listenHospital {
        void onClick(int id);
    }

    public interface listenFaculty {
        void onClick(int id);
    }

    public interface listenerLogin {
        void showRegister();

        void showLogin();

        void startMain();
    }


    // STATUS CONNECT SERVER SQL

    public interface requestStatus {
        void requestSuccess(int id);

        void requestError();

        void requestErrorResponse();
    }

    public interface loginStatus {
        void loginSuccess(int id);

        void loginFail();

        void loginRequestError();
    }

    public interface registerStatus {
        void registerSuccess(int id);

        void registerExist();

        void registerFail();
    }
}
