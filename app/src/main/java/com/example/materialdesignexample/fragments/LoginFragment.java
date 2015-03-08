package com.example.materialdesignexample.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.activities.RepositoriesListActivity;
import com.example.materialdesignexample.controllers.LoginController;
import com.example.materialdesignexample.interfaces.IBaseCallbackResponse;
import com.example.materialdesignexample.interfaces.IBaseFragmentCommunicator;
import com.example.materialdesignexample.models.User;

import java.util.List;

/**
 * Created by Amaury Esparza on 04/03/2015.
 */
public class LoginFragment extends Fragment implements View.OnClickListener, IBaseCallbackResponse<User> {

    Button loginButton;
    EditText usernameEdit;
    EditText passwordEdit;
    private final int BUTTON_LOGIN = R.id.buttonLogin;
    private final int EDIT_USERNAME = R.id.editUsername;
    private final int EDIT_PASSWORD = R.id.editPassword;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate the layout
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        usernameEdit = (EditText) getActivity().findViewById(EDIT_USERNAME);
        passwordEdit = (EditText) getActivity().findViewById(EDIT_PASSWORD);
        loginButton = (Button) getActivity().findViewById(BUTTON_LOGIN);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        //If the text field are diferent from null
        if(usernameEdit.getText() != null & passwordEdit.getText() != null) {
            if (v.getId() == BUTTON_LOGIN) {
                LoginController controller = new LoginController(this);
                //Here some parameter
                controller.login();
            }
        }
        else{
            //The fields are required
        }
    }

    @Override
    public void responseCallback(User user){
        if(user != null) {
            Intent intent = new Intent(getActivity(), RepositoriesListActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getActivity(), "Server error, try again later", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void responseListCallback(List<User> listUsers){
        //Doesn't use in this case
    }
}
