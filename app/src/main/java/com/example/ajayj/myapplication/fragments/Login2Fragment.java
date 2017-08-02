package com.example.ajayj.myapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajayj.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login2Fragment extends Fragment {

    EditText fusername, fpassword;
    CheckBox frmndcheck;
    Button floginbtn;
    TextView fforgotpwd,fsignupbtn;





    public Login2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login2, container, false);

        fusername= (EditText) view.findViewById(R.id.fusertext2);
        fpassword= (EditText) view.findViewById(R.id.fpasswordtext2);
        frmndcheck= (CheckBox) view.findViewById(R.id.frmndchecktext);
        fforgotpwd= (TextView) view.findViewById(R.id.fforgotpwdtext);
        floginbtn= (Button) view.findViewById(R.id.floginbtn3);
        fsignupbtn= (TextView) view.findViewById(R.id.fsignuptext);

        floginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "HAiii.....!!! hahahaaaa", Toast.LENGTH_SHORT).show();
//                Intent homepage5=new Intent(getActivity(),MainActivity.class);
//                startActivity(homepage5);

            }
        });
        return view;
    }

}
