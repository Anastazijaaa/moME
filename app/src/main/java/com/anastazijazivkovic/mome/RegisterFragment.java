package com.anastazijazivkovic.mome;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    EditText etName, etEmail, etPassword, etRePassword;
    Button btnRegister;


    public static RegisterFragment newInstance(){
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etName = view.findViewById(R.id.et_name);
        etEmail = view.findViewById(R.id.et_emailRegister);
        etPassword = view.findViewById(R.id.et_passwordRegister);
        etRePassword = view.findViewById(R.id.et_repassword);
        btnRegister = view.findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkName(etName.getText().toString()) && checkEmail(etEmail.getText().toString()) && checkPassword(etPassword.getText().toString(),etRePassword.getText().toString())){
                    Intent intent = new Intent(getContext(), MenuActivity.class);
                    String name = etName.getText().toString();
                    intent.putExtra("NAME",name);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean checkName(String name){
        if(name.trim().isEmpty()) {
            displayToast("You didn't enter a name!");
            return false;
        }
        return true;
    }

    private boolean checkEmail(String email){
        if(email.trim().isEmpty() || !email.contains("@")){
            displayToast("The email address isn't valid!");
            return false;
        }
        return true;
    }

    private boolean checkPassword(String password, String rePassword){
        if(password.isEmpty()){
            displayToast("You didn't enter a password!");
            return false;
        }
        if(password.length()<5){
            displayToast("The password must have at least 5 characters!");
            return false;
        }
        if(!rePassword.equals(password)){
            displayToast("The passwords don't match!");
            return false;
        }
        return true;
    }

    private void displayToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
